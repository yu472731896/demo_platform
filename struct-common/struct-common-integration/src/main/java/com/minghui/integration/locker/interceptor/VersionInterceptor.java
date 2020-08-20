package com.ropeok.integration.locker.interceptor;


import com.ropeok.integration.annotation.VersionLocker;
import com.ropeok.integration.cache.Cache;
import com.ropeok.integration.locker.cache.LocalVersionLockerCache;
import com.ropeok.integration.locker.cache.VersionLockerCache;
import com.ropeok.integration.locker.util.PluginUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * <p>Mybatis乐观锁插件</p>
 * @Author:chenql
 * @Description:
 * @Date:Created in 11:04 2018/5/8
 * @Modified By:
 */
@Intercepts(value = {
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
@Slf4j
@Component
public class VersionInterceptor implements Interceptor {

    private Properties props = null;
    private static VersionLocker trueLocker;
    private static VersionLocker falseLocker;
    private static final String JDBC_PROPERTY = "record_version";
    private static final String JAVA_PROPERTY = "recordVersion";
    private VersionLockerCache versionLockerCache = new LocalVersionLockerCache();
    private static final String[] FILTER_METHOD_NAME = {"updateByPrimaryKeySelective","updateByPrimaryKey","updateByExampleSelective","updateByExample"};

    private static final String FILTER_VERSION_PREFIX = ".*com.ropeok.*.*ServiceImpl.*";

    public VersionInterceptor(){}

    @VersionLocker(true)
    private void versionValueTrue(){}

    @VersionLocker(false)
    private void versionValueFalse(){}

    static {
        try {
            trueLocker = VersionInterceptor.class.getDeclaredMethod("versionValueTrue").getAnnotation(
                    VersionLocker.class);
            falseLocker = VersionInterceptor.class.getDeclaredMethod("versionValueFalse").getAnnotation(
                    VersionLocker.class);
        }catch (Exception e){
            throw new RuntimeException("the versionlock plugin init faild!",e);
        }
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String versionColum;
        String versionField;
        if(null == props || props.isEmpty()){
            versionColum = JDBC_PROPERTY;
            versionField = JAVA_PROPERTY;
        }else{
            versionColum = props.getProperty("versionColum",JDBC_PROPERTY);
            versionField = props.getProperty("versionField",JAVA_PROPERTY);
        }
        String method = invocation.getMethod().getName();
        if(!"prepare".equals(method)){
            return invocation.proceed();
        }
        StatementHandler handler = (StatementHandler) PluginUtil.processTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(handler);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        if(!sqlCommandType.equals(SqlCommandType.UPDATE)){
            return invocation.proceed();
        }
        // 2019-04-26 add 如果不是框架的方法,不进行拦截操作
        if (!Arrays.asList(FILTER_METHOD_NAME).contains(getMapperShortId(mappedStatement))){
            return invocation.proceed();
        }

        // 查询调用栈 检查是否有去版本控制注解
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element:elements){
            if (Pattern.matches(FILTER_VERSION_PREFIX, element.getClassName())){
                Class<?> claz = Class.forName(element.getClassName());
                Method[] methods = claz.getDeclaredMethods();
                for (Method m:methods){
                    if (Objects.equals(m.getName(),element.getMethodName())){
                        VersionLocker versionLocker = m.getAnnotation(VersionLocker.class);
                        if (versionLocker != null && !versionLocker.value()){
                            return invocation.proceed();
                        }
                    }
                }
            }
        }
        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        VersionLocker versionLocker = getVersionLocker(mappedStatement,boundSql);
        if(versionLocker != null && !versionLocker.value()){
            return invocation.proceed();
        }
        Object originalVersion = null;
        if (!"updateByExampleSelective".equalsIgnoreCase(getMapperShortId(mappedStatement))){
            originalVersion = metaObject.getValue("delegate.boundSql.parameterObject."+versionField);
        }else{
            originalVersion = metaObject.getValue("delegate.boundSql.parameterObject.record."+versionField);
        }
        if(originalVersion == null || Integer.parseInt(originalVersion.toString())<0){
            throw new BindingException("value of version field ["+versionField+"] can't be empty !");
        }
        try {
            metaObject.setValue("delegate.boundSql.parameterObject."+versionField,(Integer)originalVersion+1);
        }catch (Exception e){
            metaObject.setValue("delegate.boundSql.parameterObject."+versionField,originalVersion);
        }
        String sql = boundSql.getSql();
        if(log.isDebugEnabled()){
            log.debug("==> old sql :{}",formatSql(sql));
        }
        sql = addVersionToSql(sql,versionColum,originalVersion);
        metaObject.setValue("delegate.boundSql.sql",sql);
        if(log.isDebugEnabled()){
            log.debug("==> new sql :{}",sql);
        }
        return invocation.proceed();
    }

    private String formatSql(String sql){
        if (StringUtils.isEmpty(sql)){
            return "";
        }
        sql = sql.replaceAll("[\\s\n ]+"," ");
        return sql;
    }

    private String addVersionToSql(String sql, String versionColum,Object oldVersionValue) {
        try {
            Statement statement = CCJSqlParserUtil.parse(sql);
            if(!(statement instanceof Update)){
                return sql;
            }
            Update update = (Update) statement;
            if(!contains(update,versionColum)){
                buildVersionExpression(update,versionColum);
            }
            Expression where = update.getWhere();
            if(where !=null){
                AndExpression andExpression = new AndExpression(where,buildVersionEquals(versionColum,oldVersionValue));
                update.setWhere(andExpression);
            }else{
                update.setWhere(buildVersionEquals(versionColum,oldVersionValue));
            }
            return update.toString();
        } catch (JSQLParserException e) {
            log.error("构建表达式sql出现异常",e);
            return sql;
        }
    }

    /**
     * @Author:chenql
     * @Description:构建and 表达式
     * @Date: 18:31 2018/5/9
     */
    private Expression buildVersionEquals(String versionColum, Object originalVersion) {
        EqualsTo equalsTo = new EqualsTo();
        Column column = new Column();
        column.setColumnName(versionColum);
        equalsTo.setLeftExpression(column);
        equalsTo.setRightExpression(new LongValue(originalVersion.toString()));
        return equalsTo;
    }

    private void buildVersionExpression(Update update, String versionColumn) {
        List<Column> columns = update.getColumns();
        Column column = new Column();
        column.setColumnName(versionColumn);
        columns.add(column);

        List<Expression> expressions = update.getExpressions();
        Addition add = new Addition();
        add.setLeftExpression(column);
        add.setRightExpression(new LongValue(1L));
        expressions.add(add);
    }

    /**
     * @Author:chenql
     * @Description:校验更新对象是否存在版本号字段
     * @Date: 18:21 2018/5/9
     */
    private boolean contains(Update update, String versionColum) {
        List<Column> columns = update.getColumns();
        for (Column column : columns){
            if(column.getColumnName().equalsIgnoreCase(versionColum)){
                return true;
            }
        }
        return false;
    }


    private VersionLocker getVersionLocker(MappedStatement mappedStatement, BoundSql boundSql) {
        Class<?>[] paramClasz = null;
        Object paramObj = boundSql.getParameterObject();

        /******************下面的处理参数顺序不能乱****************************/
        // 处理@Param标记参数
        if(paramObj instanceof MapperMethod.ParamMap<?>){
            MapperMethod.ParamMap<?> paramMap = (MapperMethod.ParamMap<?>) paramObj;
            if(null != paramMap && !paramMap.isEmpty()){
                int len = paramMap.size() /2;
                paramClasz = new Class<?>[len];
                for (int i=0; i<len; i++){
                    Object index = paramMap.get("param"+(i+1));
                    paramClasz[i] = index.getClass();
                    if(List.class.isAssignableFrom(paramClasz[i])){
                        return falseLocker;
                    }
                }

            }

            // 处理Map类型参数 不支持批量
        }else if(paramObj instanceof Map){
            Map map = (Map) paramObj;
            if(map.get("list") != null || map.get("array") != null){
                return falseLocker;
            }else{
                paramClasz = new Class<?>[]{Map.class};
            }
        }else{
            // 处理POJO实体对象类型参数(默认按照这个方式)
            paramClasz = new Class<?>[]{paramObj.getClass()};
        }
        Cache.Signature cms = new Cache.Signature(mappedStatement.getId(),paramClasz);
        VersionLocker versionLocker = versionLockerCache.getObject(cms);
        if(versionLocker != null){
            return versionLocker;
        }
        Class<?> mapper = getMapper(mappedStatement);
        if(mapper != null){
            Method method = null;
            try {
                if(Arrays.asList(FILTER_METHOD_NAME).contains(getMapperShortId(mappedStatement))
                        || Arrays.asList(FILTER_METHOD_NAME).contains(getMapperShortId(mappedStatement))){
                    Method[] methods = mapper.getInterfaces()[0].getMethods();
                    for (Method m : methods){
                        if(getMapperShortId(mappedStatement).equals(m.getName())){
                            method = m;
                            break;
                        }
                    }
                }else{
                    return versionLocker;
                }
            }catch (SecurityException e){
                throw new RuntimeException("the map type param error."+ e,e);
            }
            if (method == null){
                throw new RuntimeException("not found method.");
            }
            versionLocker = method.getAnnotation(VersionLocker.class);
            if(versionLocker == null){
                versionLocker = trueLocker;
            }

            if(!versionLockerCache.containSignature(cms)){
                versionLockerCache.cacheObject(cms,versionLocker);
            }
            return versionLocker;
        }else{
            throw new RuntimeException("Config info error,maybe you have not config the mapper interface");
        }
    }

    private String getMapperShortId(MappedStatement mappedStatement) {
        String id = mappedStatement.getId();
        int pos = id.lastIndexOf(".");
        return id.substring(pos+1);
    }

    private Class<?> getMapper(MappedStatement mappedStatement) {
        String nameSpace = getMapperNameSpace(mappedStatement);
        Collection<Class<?>> mappers = mappedStatement.getConfiguration().getMapperRegistry().getMappers();
        for (Class<?> claz :mappers){
            if(claz.getName().equals(nameSpace)){
                return claz;
            }
        }
        return null;
    }

    private String getMapperNameSpace(MappedStatement mappedStatement) {
        String id = mappedStatement.getId();
        int pos = id.lastIndexOf(".");
        return id.substring(0,pos);
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof StatementHandler || target instanceof ParameterHandler){
            return Plugin.wrap(target,this);
        }else{
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        if(null != properties && !properties.isEmpty()){
            props = properties;
        }
    }
}
