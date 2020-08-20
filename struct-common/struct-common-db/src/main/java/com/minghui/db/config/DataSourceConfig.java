package com.ropeok.db.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.ropeok.db.util.DataSourceKey;
import com.ropeok.db.util.MultiDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Classname:DataSourceConfig
 * @Descriptions: 在设置了spring.datasource.enable.dynamic 等于true是开启多数据源
 * @Auther:chenqinglin
 * @Date:2018/12/14 17:28
 * @Version: 1.0
 */
@Configuration
@ConditionalOnProperty(name = {"spring.datasource.dynamic.enable"}, matchIfMissing = false, havingValue = "true")
public class DataSourceConfig {

    /**
     * @param:
     * @description:<p>[核心数据源]</p>
     * @auther: chenqinglin
     * @date: 2018/12/14 17:40
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.core")
    public DataSource dataSourceCore(){
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * @param:
     * @description:<p>[日志数据源]</p>
     * @auther: chenqinglin
     * @date: 2018/12/14 17:40
     */
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.log")
//    public DataSource dataSourceLog(){
//        return DruidDataSourceBuilder.create().build();
//    }

    /**
     * @param:
     * @description:<p>[只需要纳入动态数据源到spring容器]</p>
     * @auther: chenqinglin
     * @date: 2018/12/14 17:40
     */
    @Bean
    @Primary
    public DataSource dataSource() {
        MultiDataSource dataSource = new MultiDataSource();
        DataSource coreDataSource = this.dataSourceCore();
        dataSource.addDataSource(DataSourceKey.core, coreDataSource);
        dataSource.setDefaultTargetDataSource(coreDataSource);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //加载mybatis配置文件
//        bean.setConfigLocation(new ClassPathResource("mybatis.cfg.xml"));
        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:mybatis/mappers/**/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @param: dataSource
     * @description:<p>[将数据源纳入spring事物管理]</p>
     * @auther: chenqinglin
     * @date: 2018/12/14 17:44
     */
    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource")  DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
