package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseExample;
import com.minghui.common.framework.model.ExampleUtil;
import com.minghui.common.framework.page.Pager;
import com.minghui.entity.constant.CommonConstant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * 后台用户表条件参数实体类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
@Data
public class SysUserExample extends BaseExample {

    /**
     * 排序语句
     */
    private String orderByClause;

    /**
     * 是否需要distinct关键字
     */
    private boolean distinct;

    /**
     * where的or条件列表
     */
    private List<Criteria> oredCriteria;

    /**
     * 过滤列:需要select的字段
     */
    private List<String> includeColumns = new ArrayList<>();

    /**
     * 实体类字段与数据库字段的映射关系对象
     */
    private static Map<String, String> modelInfo = new HashMap<>();

    /**
     * 分页对象
     */
    private Pager pager;

    /**
     * 实体类字段与数据库字段的映射关系
     */
    static {
        modelInfo.put("id", "id");
        modelInfo.put("username", "username");
        modelInfo.put("password", "password");
        modelInfo.put("icon", "icon");
        modelInfo.put("email", "email");
        modelInfo.put("nickName", "nick_name");
        modelInfo.put("note", "note");
        modelInfo.put("loginTime", "login_time");
        modelInfo.put("status", "status");
        modelInfo.put("isDelete", "is_delete");
        modelInfo.put("createUser", "create_user");
        modelInfo.put("createDepartment", "create_department");
        modelInfo.put("createTime", "create_time");
        modelInfo.put("createServerHost", "create_server_host");
        modelInfo.put("updateUser", "update_user");
        modelInfo.put("updateDepartment", "update_department");
        modelInfo.put("updateTime", "update_time");
        modelInfo.put("updateServerHost", "update_server_host");
        modelInfo.put("recordVersion", "record_version");
    }

    /**
     * 构造函数，初始化where条件列表
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public SysUserExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * 添加条件对象
     * @param criteria 条件对象
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 添加or条件对象，并返回条件对象
     * @return 条件对象
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 新建条件对象，条件列表为空，则添加到列表
     * @return 条件对象
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 创建条件对象
     * @return 条件对象
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 重置：条件对象，排序对象，distinct参数
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 需要select过滤的字段
     * @param field 字段名称
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public void addSelectiveField(String field) {
        String columnName = modelInfo.get(field);
        includeColumns.add(columnName);
    }

    /**
     * 需要select过滤的字段列表
     * @param fields 字段名称数组
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public void addSelectiveFields(String... fields) {
        for (String field : fields) {
			addSelectiveField(field);
		}
    }

    /**
     * 需要select过滤的字段列表
     * @param fields 字段名称数组
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public void addSelectiveFields(List<String> fields) {
        for (String field : fields) {
			addSelectiveField(field);
		}
    }

    /**
     * 添加需要排序的字段和类型
     * @param orderFields 字段名称数组
     * @param orderTypes 排序类型数组
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public void addOrderFields(String[] orderFields, String[] orderTypes) {
        orderByClause = ExampleUtil.getOrderFields(orderFields, orderTypes, modelInfo, orderByClause);
    }

    /**
     * 添加需要排序的字段和类型
     * @param orderField 字段名称
     * @param orderType 排序类型
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public void addOrderField(String orderField, String orderType) {
        orderByClause = ExampleUtil.getOrderField(orderField, orderType, modelInfo, orderByClause);
    }

    /**
     * 添加需要排序的字段
     * @param orderField 字段名称
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public void addAscOrderField(String orderField) {
        addOrderField(orderField, CommonConstant.OrderType.ASC);
    }

    /**
     * 添加需要排序的字段
     * @param orderField 字段名称
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public void addDescOrderField(String orderField) {
        addOrderField(orderField, CommonConstant.OrderType.DESC);
    }

    /**
     * 后台用户表查询添加抽象对象
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    @Data
    protected abstract static class GeneratedCriteria {

        /**
         * and条件列表
         */
        private List<Criterion> criteria;

        /**
         * 构造函数
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        /**
         * 查询条件是否有效
         * @return 查询条件是否有效
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public boolean isValid() {
            return criteria.size() > 0;
        }

        /**
         * 获取and条件对象List列表
         * @return 条件列表
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        /**
         * 添加and条件对象
         * @param condition 条件
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        /**
         * 添加=条件
         * @param condition 条件
         * @param value 属性值
         * @param property 属性名
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        /**
         * 添加区间条件对象
         * @param condition 条件
         * @param value1 第一个值
         * @param value2 第二个值
         * @param property 属性名称
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        /**
         * 添加idis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        /**
         * 添加idis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        /**
         * 添加 id = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        /**
         * 添加 id <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        /**
         * 添加 id > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        /**
         * 添加 id >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        /**
         * 添加 id < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        /**
         * 添加 id <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        /**
         * 添加idin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        /**
         * 添加idnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        /**
         * 添加id between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        /**
         * 添加id not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        /**
         * 添加usernameis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        /**
         * 添加usernameis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        /**
         * 添加 username = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        /**
         * 添加 username <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        /**
         * 添加 username > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        /**
         * 添加 username >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        /**
         * 添加 username < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        /**
         * 添加 username <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        /**
         * 添加 username like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        /**
         * 添加 username not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        /**
         * 添加usernamein 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        /**
         * 添加usernamenot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        /**
         * 添加username between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        /**
         * 添加username not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        /**
         * 添加passwordis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        /**
         * 添加passwordis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        /**
         * 添加 password = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        /**
         * 添加 password <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        /**
         * 添加 password > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        /**
         * 添加 password >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        /**
         * 添加 password < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        /**
         * 添加 password <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        /**
         * 添加 password like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        /**
         * 添加 password not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        /**
         * 添加passwordin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        /**
         * 添加passwordnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        /**
         * 添加password between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        /**
         * 添加password not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        /**
         * 添加iconis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        /**
         * 添加iconis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        /**
         * 添加 icon = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        /**
         * 添加 icon <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        /**
         * 添加 icon > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        /**
         * 添加 icon >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        /**
         * 添加 icon < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        /**
         * 添加 icon <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        /**
         * 添加 icon like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        /**
         * 添加 icon not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        /**
         * 添加iconin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        /**
         * 添加iconnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        /**
         * 添加icon between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        /**
         * 添加icon not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        /**
         * 添加emailis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        /**
         * 添加emailis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        /**
         * 添加 email = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        /**
         * 添加 email <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        /**
         * 添加 email > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        /**
         * 添加 email >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        /**
         * 添加 email < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        /**
         * 添加 email <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        /**
         * 添加 email like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        /**
         * 添加 email not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        /**
         * 添加emailin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        /**
         * 添加emailnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        /**
         * 添加email between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        /**
         * 添加email not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        /**
         * 添加nickNameis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        /**
         * 添加nickNameis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        /**
         * 添加 nickName = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加 nickName <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加 nickName > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加 nickName >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加 nickName < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加 nickName <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加 nickName like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加 nickName not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加nickNamein 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加nickNamenot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加nickName between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加nickName not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        /**
         * 添加noteis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        /**
         * 添加noteis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        /**
         * 添加 note = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        /**
         * 添加 note <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        /**
         * 添加 note > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        /**
         * 添加 note >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        /**
         * 添加 note < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        /**
         * 添加 note <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        /**
         * 添加 note like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        /**
         * 添加 note not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        /**
         * 添加notein 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        /**
         * 添加notenot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        /**
         * 添加note between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        /**
         * 添加note not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        /**
         * 添加loginTimeis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        /**
         * 添加loginTimeis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        /**
         * 添加 loginTime = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        /**
         * 添加 loginTime <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        /**
         * 添加 loginTime > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        /**
         * 添加 loginTime >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        /**
         * 添加 loginTime < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        /**
         * 添加 loginTime <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        /**
         * 添加loginTimein 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        /**
         * 添加loginTimenot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        /**
         * 添加loginTime between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        /**
         * 添加loginTime not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        /**
         * 添加statusis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        /**
         * 添加statusis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        /**
         * 添加 status = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        /**
         * 添加 status <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        /**
         * 添加 status > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        /**
         * 添加 status >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        /**
         * 添加 status < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        /**
         * 添加 status <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        /**
         * 添加statusin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        /**
         * 添加statusnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        /**
         * 添加status between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        /**
         * 添加status not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        /**
         * 添加isDeleteis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        /**
         * 添加isDeleteis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        /**
         * 添加 isDelete = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        /**
         * 添加 isDelete <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        /**
         * 添加 isDelete > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        /**
         * 添加 isDelete >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        /**
         * 添加 isDelete < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        /**
         * 添加 isDelete <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        /**
         * 添加isDeletein 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        /**
         * 添加isDeletenot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        /**
         * 添加isDelete between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        /**
         * 添加isDelete not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        /**
         * 添加createUseris null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        /**
         * 添加createUseris not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        /**
         * 添加 createUser = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加 createUser <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加 createUser > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加 createUser >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加 createUser < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加 createUser <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加 createUser like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加 createUser not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加createUserin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加createUsernot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加createUser between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加createUser not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        /**
         * 添加createDepartmentis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentIsNull() {
            addCriterion("create_department is null");
            return (Criteria) this;
        }

        /**
         * 添加createDepartmentis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentIsNotNull() {
            addCriterion("create_department is not null");
            return (Criteria) this;
        }

        /**
         * 添加 createDepartment = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentEqualTo(String value) {
            addCriterion("create_department =", value, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 createDepartment <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentNotEqualTo(String value) {
            addCriterion("create_department <>", value, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 createDepartment > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentGreaterThan(String value) {
            addCriterion("create_department >", value, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 createDepartment >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("create_department >=", value, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 createDepartment < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentLessThan(String value) {
            addCriterion("create_department <", value, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 createDepartment <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentLessThanOrEqualTo(String value) {
            addCriterion("create_department <=", value, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 createDepartment like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentLike(String value) {
            addCriterion("create_department like", value, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 createDepartment not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentNotLike(String value) {
            addCriterion("create_department not like", value, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加createDepartmentin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentIn(List<String> values) {
            addCriterion("create_department in", values, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加createDepartmentnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentNotIn(List<String> values) {
            addCriterion("create_department not in", values, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加createDepartment between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentBetween(String value1, String value2) {
            addCriterion("create_department between", value1, value2, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加createDepartment not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateDepartmentNotBetween(String value1, String value2) {
            addCriterion("create_department not between", value1, value2, "createDepartment");
            return (Criteria) this;
        }

        /**
         * 添加createTimeis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        /**
         * 添加createTimeis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        /**
         * 添加 createTime = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        /**
         * 添加 createTime <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        /**
         * 添加 createTime > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        /**
         * 添加 createTime >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        /**
         * 添加 createTime < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        /**
         * 添加 createTime <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        /**
         * 添加createTimein 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        /**
         * 添加createTimenot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        /**
         * 添加createTime between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        /**
         * 添加createTime not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        /**
         * 添加createServerHostis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostIsNull() {
            addCriterion("create_server_host is null");
            return (Criteria) this;
        }

        /**
         * 添加createServerHostis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostIsNotNull() {
            addCriterion("create_server_host is not null");
            return (Criteria) this;
        }

        /**
         * 添加 createServerHost = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostEqualTo(String value) {
            addCriterion("create_server_host =", value, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 createServerHost <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostNotEqualTo(String value) {
            addCriterion("create_server_host <>", value, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 createServerHost > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostGreaterThan(String value) {
            addCriterion("create_server_host >", value, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 createServerHost >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostGreaterThanOrEqualTo(String value) {
            addCriterion("create_server_host >=", value, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 createServerHost < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostLessThan(String value) {
            addCriterion("create_server_host <", value, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 createServerHost <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostLessThanOrEqualTo(String value) {
            addCriterion("create_server_host <=", value, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 createServerHost like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostLike(String value) {
            addCriterion("create_server_host like", value, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 createServerHost not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostNotLike(String value) {
            addCriterion("create_server_host not like", value, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加createServerHostin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostIn(List<String> values) {
            addCriterion("create_server_host in", values, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加createServerHostnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostNotIn(List<String> values) {
            addCriterion("create_server_host not in", values, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加createServerHost between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostBetween(String value1, String value2) {
            addCriterion("create_server_host between", value1, value2, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加createServerHost not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andCreateServerHostNotBetween(String value1, String value2) {
            addCriterion("create_server_host not between", value1, value2, "createServerHost");
            return (Criteria) this;
        }

        /**
         * 添加updateUseris null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        /**
         * 添加updateUseris not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        /**
         * 添加 updateUser = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加 updateUser <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加 updateUser > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加 updateUser >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加 updateUser < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加 updateUser <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加 updateUser like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加 updateUser not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加updateUserin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加updateUsernot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加updateUser between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加updateUser not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        /**
         * 添加updateDepartmentis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentIsNull() {
            addCriterion("update_department is null");
            return (Criteria) this;
        }

        /**
         * 添加updateDepartmentis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentIsNotNull() {
            addCriterion("update_department is not null");
            return (Criteria) this;
        }

        /**
         * 添加 updateDepartment = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentEqualTo(String value) {
            addCriterion("update_department =", value, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 updateDepartment <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentNotEqualTo(String value) {
            addCriterion("update_department <>", value, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 updateDepartment > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentGreaterThan(String value) {
            addCriterion("update_department >", value, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 updateDepartment >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("update_department >=", value, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 updateDepartment < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentLessThan(String value) {
            addCriterion("update_department <", value, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 updateDepartment <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentLessThanOrEqualTo(String value) {
            addCriterion("update_department <=", value, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 updateDepartment like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentLike(String value) {
            addCriterion("update_department like", value, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加 updateDepartment not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentNotLike(String value) {
            addCriterion("update_department not like", value, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加updateDepartmentin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentIn(List<String> values) {
            addCriterion("update_department in", values, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加updateDepartmentnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentNotIn(List<String> values) {
            addCriterion("update_department not in", values, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加updateDepartment between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentBetween(String value1, String value2) {
            addCriterion("update_department between", value1, value2, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加updateDepartment not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateDepartmentNotBetween(String value1, String value2) {
            addCriterion("update_department not between", value1, value2, "updateDepartment");
            return (Criteria) this;
        }

        /**
         * 添加updateTimeis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        /**
         * 添加updateTimeis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        /**
         * 添加 updateTime = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        /**
         * 添加 updateTime <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        /**
         * 添加 updateTime > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        /**
         * 添加 updateTime >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        /**
         * 添加 updateTime < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        /**
         * 添加 updateTime <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        /**
         * 添加updateTimein 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        /**
         * 添加updateTimenot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        /**
         * 添加updateTime between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        /**
         * 添加updateTime not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        /**
         * 添加updateServerHostis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostIsNull() {
            addCriterion("update_server_host is null");
            return (Criteria) this;
        }

        /**
         * 添加updateServerHostis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostIsNotNull() {
            addCriterion("update_server_host is not null");
            return (Criteria) this;
        }

        /**
         * 添加 updateServerHost = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostEqualTo(String value) {
            addCriterion("update_server_host =", value, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 updateServerHost <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostNotEqualTo(String value) {
            addCriterion("update_server_host <>", value, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 updateServerHost > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostGreaterThan(String value) {
            addCriterion("update_server_host >", value, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 updateServerHost >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostGreaterThanOrEqualTo(String value) {
            addCriterion("update_server_host >=", value, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 updateServerHost < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostLessThan(String value) {
            addCriterion("update_server_host <", value, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 updateServerHost <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostLessThanOrEqualTo(String value) {
            addCriterion("update_server_host <=", value, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 updateServerHost like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostLike(String value) {
            addCriterion("update_server_host like", value, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加 updateServerHost not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostNotLike(String value) {
            addCriterion("update_server_host not like", value, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加updateServerHostin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostIn(List<String> values) {
            addCriterion("update_server_host in", values, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加updateServerHostnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostNotIn(List<String> values) {
            addCriterion("update_server_host not in", values, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加updateServerHost between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostBetween(String value1, String value2) {
            addCriterion("update_server_host between", value1, value2, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加updateServerHost not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUpdateServerHostNotBetween(String value1, String value2) {
            addCriterion("update_server_host not between", value1, value2, "updateServerHost");
            return (Criteria) this;
        }

        /**
         * 添加recordVersionis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionIsNull() {
            addCriterion("record_version is null");
            return (Criteria) this;
        }

        /**
         * 添加recordVersionis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionIsNotNull() {
            addCriterion("record_version is not null");
            return (Criteria) this;
        }

        /**
         * 添加 recordVersion = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionEqualTo(Integer value) {
            addCriterion("record_version =", value, "recordVersion");
            return (Criteria) this;
        }

        /**
         * 添加 recordVersion <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionNotEqualTo(Integer value) {
            addCriterion("record_version <>", value, "recordVersion");
            return (Criteria) this;
        }

        /**
         * 添加 recordVersion > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionGreaterThan(Integer value) {
            addCriterion("record_version >", value, "recordVersion");
            return (Criteria) this;
        }

        /**
         * 添加 recordVersion >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_version >=", value, "recordVersion");
            return (Criteria) this;
        }

        /**
         * 添加 recordVersion < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionLessThan(Integer value) {
            addCriterion("record_version <", value, "recordVersion");
            return (Criteria) this;
        }

        /**
         * 添加 recordVersion <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionLessThanOrEqualTo(Integer value) {
            addCriterion("record_version <=", value, "recordVersion");
            return (Criteria) this;
        }

        /**
         * 添加recordVersionin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionIn(List<Integer> values) {
            addCriterion("record_version in", values, "recordVersion");
            return (Criteria) this;
        }

        /**
         * 添加recordVersionnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionNotIn(List<Integer> values) {
            addCriterion("record_version not in", values, "recordVersion");
            return (Criteria) this;
        }

        /**
         * 添加recordVersion between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionBetween(Integer value1, Integer value2) {
            addCriterion("record_version between", value1, value2, "recordVersion");
            return (Criteria) this;
        }

        /**
         * 添加recordVersion not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRecordVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("record_version not between", value1, value2, "recordVersion");
            return (Criteria) this;
        }
    }

    /**
     * 后台用户表条件对象类
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public static class Criteria extends GeneratedCriteria {


        /**
         * 条件对象构造函数
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        protected Criteria() {
            super();
        }
    }

    /**
     * 后台用户表and 条件对象
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    @Data
    public static class Criterion {

        /**
         * 条件
         */
        private String condition;

        /**
         * 条件值
         */
        private Object value;

        /**
         * 第二个条件值
         */
        private Object secondValue;

        /**
         * 是否无条件值
         */
        private boolean noValue;

        /**
         * 是否只有一个条件值
         */
        private boolean singleValue;

        /**
         * 是否区间条件值
         */
        private boolean betweenValue;

        /**
         * 是否列表条件值
         */
        private boolean listValue;

        /**
         * 操作类型
         */
        private String typeHandler;

        /**
         * condition条件构造函数
         * @param condition 条件
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        /**
         * condition value typeHandler 条件构造函数
         * @param condition 条件
         * @param value 条件值
         * @param typeHandler 操作类型
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        /**
         * condition value 条件构造函数
         * @param condition 条件
         * @param value 条件值
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        /**
         * condition value secondValue typeHandler 条件构造函数
         * @param condition 条件
         * @param value 条件值
         * @param secondValue 第二个条件值
         * @param typeHandler 操作类型
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        /**
         * condition value secondValue 条件构造函数
         * @param condition 条件
         * @param value 条件值
         * @param secondValue 第二个条件值
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    /**
     * 后台用户表实体类常量类
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public static final class PropertyConstants {

        /**
         * 
         */
        public static final String ID = "id";

        /**
         * 
         */
        public static final String USERNAME = "username";

        /**
         * 
         */
        public static final String PASSWORD = "password";

        /**
         * 头像
         */
        public static final String ICON = "icon";

        /**
         * 邮箱
         */
        public static final String EMAIL = "email";

        /**
         * 昵称
         */
        public static final String NICK_NAME = "nickName";

        /**
         * 备注信息
         */
        public static final String NOTE = "note";

        /**
         * 最后登录时间
         */
        public static final String LOGIN_TIME = "loginTime";

        /**
         * 帐号启用状态：0->禁用；1->启用
         */
        public static final String STATUS = "status";

        /**
         * 是否删除，0否，1是
         */
        public static final String IS_DELETE = "isDelete";

        /**
         * 
         */
        public static final String CREATE_USER = "createUser";

        /**
         * 
         */
        public static final String CREATE_DEPARTMENT = "createDepartment";

        /**
         * 
         */
        public static final String CREATE_TIME = "createTime";

        /**
         * 
         */
        public static final String CREATE_SERVER_HOST = "createServerHost";

        /**
         * 
         */
        public static final String UPDATE_USER = "updateUser";

        /**
         * 
         */
        public static final String UPDATE_DEPARTMENT = "updateDepartment";

        /**
         * 
         */
        public static final String UPDATE_TIME = "updateTime";

        /**
         * 
         */
        public static final String UPDATE_SERVER_HOST = "updateServerHost";

        /**
         * 
         */
        public static final String RECORD_VERSION = "recordVersion";
    }
}