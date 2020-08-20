package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseExample;
import com.minghui.common.framework.model.ExampleUtil;
import com.minghui.common.framework.page.Pager;
import com.minghui.entity.constant.CommonConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * 后台用户和角色关系表条件参数实体类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
@Data
public class SysRoleRelationExample extends BaseExample {

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
        modelInfo.put("userId", "user_id");
        modelInfo.put("roleId", "role_id");
    }

    /**
     * 构造函数，初始化where条件列表
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public SysRoleRelationExample() {
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
     * 后台用户和角色关系表查询添加抽象对象
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
         * 添加userIdis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        /**
         * 添加userIdis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        /**
         * 添加 userId = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        /**
         * 添加 userId <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        /**
         * 添加 userId > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        /**
         * 添加 userId >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        /**
         * 添加 userId < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        /**
         * 添加 userId <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        /**
         * 添加userIdin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        /**
         * 添加userIdnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        /**
         * 添加userId between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        /**
         * 添加userId not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        /**
         * 添加roleIdis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        /**
         * 添加roleIdis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        /**
         * 添加 roleId = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdEqualTo(Long value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        /**
         * 添加 roleId <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdNotEqualTo(Long value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        /**
         * 添加 roleId > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdGreaterThan(Long value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        /**
         * 添加 roleId >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        /**
         * 添加 roleId < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdLessThan(Long value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        /**
         * 添加 roleId <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        /**
         * 添加roleIdin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        /**
         * 添加roleIdnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        /**
         * 添加roleId between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdBetween(Long value1, Long value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        /**
         * 添加roleId not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }
    }

    /**
     * 后台用户和角色关系表条件对象类
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
     * 后台用户和角色关系表and 条件对象
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
     * 后台用户和角色关系表实体类常量类
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
        public static final String USER_ID = "userId";

        /**
         * 
         */
        public static final String ROLE_ID = "roleId";
    }
}