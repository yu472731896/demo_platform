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
 * 后台用户角色表条件参数实体类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
@Data
public class SysRoleExample extends BaseExample {

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
        modelInfo.put("name", "name");
        modelInfo.put("description", "description");
        modelInfo.put("adminCount", "admin_count");
        modelInfo.put("status", "status");
        modelInfo.put("sort", "sort");
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
    public SysRoleExample() {
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
     * 后台用户角色表查询添加抽象对象
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
         * 添加nameis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        /**
         * 添加nameis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        /**
         * 添加 name = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        /**
         * 添加 name <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        /**
         * 添加 name > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        /**
         * 添加 name >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        /**
         * 添加 name < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        /**
         * 添加 name <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        /**
         * 添加 name like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        /**
         * 添加 name not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        /**
         * 添加namein 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        /**
         * 添加namenot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        /**
         * 添加name between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        /**
         * 添加name not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        /**
         * 添加descriptionis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        /**
         * 添加descriptionis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        /**
         * 添加 description = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        /**
         * 添加 description <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        /**
         * 添加 description > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        /**
         * 添加 description >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        /**
         * 添加 description < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        /**
         * 添加 description <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        /**
         * 添加 description like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        /**
         * 添加 description not like value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        /**
         * 添加descriptionin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        /**
         * 添加descriptionnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        /**
         * 添加description between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        /**
         * 添加description not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        /**
         * 添加adminCountis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountIsNull() {
            addCriterion("admin_count is null");
            return (Criteria) this;
        }

        /**
         * 添加adminCountis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountIsNotNull() {
            addCriterion("admin_count is not null");
            return (Criteria) this;
        }

        /**
         * 添加 adminCount = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountEqualTo(Integer value) {
            addCriterion("admin_count =", value, "adminCount");
            return (Criteria) this;
        }

        /**
         * 添加 adminCount <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountNotEqualTo(Integer value) {
            addCriterion("admin_count <>", value, "adminCount");
            return (Criteria) this;
        }

        /**
         * 添加 adminCount > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountGreaterThan(Integer value) {
            addCriterion("admin_count >", value, "adminCount");
            return (Criteria) this;
        }

        /**
         * 添加 adminCount >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_count >=", value, "adminCount");
            return (Criteria) this;
        }

        /**
         * 添加 adminCount < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountLessThan(Integer value) {
            addCriterion("admin_count <", value, "adminCount");
            return (Criteria) this;
        }

        /**
         * 添加 adminCount <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountLessThanOrEqualTo(Integer value) {
            addCriterion("admin_count <=", value, "adminCount");
            return (Criteria) this;
        }

        /**
         * 添加adminCountin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountIn(List<Integer> values) {
            addCriterion("admin_count in", values, "adminCount");
            return (Criteria) this;
        }

        /**
         * 添加adminCountnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountNotIn(List<Integer> values) {
            addCriterion("admin_count not in", values, "adminCount");
            return (Criteria) this;
        }

        /**
         * 添加adminCount between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountBetween(Integer value1, Integer value2) {
            addCriterion("admin_count between", value1, value2, "adminCount");
            return (Criteria) this;
        }

        /**
         * 添加adminCount not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andAdminCountNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_count not between", value1, value2, "adminCount");
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
         * 添加sortis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        /**
         * 添加sortis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        /**
         * 添加 sort = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        /**
         * 添加 sort <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        /**
         * 添加 sort > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        /**
         * 添加 sort >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        /**
         * 添加 sort < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        /**
         * 添加 sort <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        /**
         * 添加sortin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        /**
         * 添加sortnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        /**
         * 添加sort between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        /**
         * 添加sort not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-18 11:46
         * @since 1.0.0
         */
        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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
     * 后台用户角色表条件对象类
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
     * 后台用户角色表and 条件对象
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
     * 后台用户角色表实体类常量类
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    public static final class PropertyConstants {

        /**
         * 
         */
        public static final String ID = "id";

        /**
         * 名称
         */
        public static final String NAME = "name";

        /**
         * 描述
         */
        public static final String DESCRIPTION = "description";

        /**
         * 后台用户数量
         */
        public static final String ADMIN_COUNT = "adminCount";

        /**
         * 启用状态：0->禁用；1->启用
         */
        public static final String STATUS = "status";

        /**
         * 
         */
        public static final String SORT = "sort";

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