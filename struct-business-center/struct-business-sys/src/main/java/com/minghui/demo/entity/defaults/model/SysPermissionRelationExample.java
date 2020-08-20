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
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)条件参数实体类
 * @author ThinkPad 2020-08-17 10:38
 * @since 1.0.0
 */
@Data
public class SysPermissionRelationExample extends BaseExample {

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
        modelInfo.put("adminId", "admin_id");
        modelInfo.put("permissionId", "permission_id");
        modelInfo.put("type", "type");
    }

    /**
     * 构造函数，初始化where条件列表
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    public SysPermissionRelationExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * 添加条件对象
     * @param criteria 条件对象
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 添加or条件对象，并返回条件对象
     * @return 条件对象
     * @author ThinkPad 2020-08-17 10:38
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
     * @author ThinkPad 2020-08-17 10:38
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
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 重置：条件对象，排序对象，distinct参数
     * @author ThinkPad 2020-08-17 10:38
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
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    public void addSelectiveField(String field) {
        String columnName = modelInfo.get(field);
        includeColumns.add(columnName);
    }

    /**
     * 需要select过滤的字段列表
     * @param fields 字段名称数组
     * @author ThinkPad 2020-08-17 10:38
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
     * @author ThinkPad 2020-08-17 10:38
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
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    public void addOrderFields(String[] orderFields, String[] orderTypes) {
        orderByClause = ExampleUtil.getOrderFields(orderFields, orderTypes, modelInfo, orderByClause);
    }

    /**
     * 添加需要排序的字段和类型
     * @param orderField 字段名称
     * @param orderType 排序类型
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    public void addOrderField(String orderField, String orderType) {
        orderByClause = ExampleUtil.getOrderField(orderField, orderType, modelInfo, orderByClause);
    }

    /**
     * 添加需要排序的字段
     * @param orderField 字段名称
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    public void addAscOrderField(String orderField) {
        addOrderField(orderField, CommonConstant.OrderType.ASC);
    }

    /**
     * 添加需要排序的字段
     * @param orderField 字段名称
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    public void addDescOrderField(String orderField) {
        addOrderField(orderField, CommonConstant.OrderType.DESC);
    }

    /**
     * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)查询添加抽象对象
     * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        /**
         * 查询条件是否有效
         * @return 查询条件是否有效
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public boolean isValid() {
            return criteria.size() > 0;
        }

        /**
         * 获取and条件对象List列表
         * @return 条件列表
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        /**
         * 添加and条件对象
         * @param condition 条件
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        /**
         * 添加idis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        /**
         * 添加adminIdis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        /**
         * 添加adminIdis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        /**
         * 添加 adminId = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdEqualTo(Long value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        /**
         * 添加 adminId <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdNotEqualTo(Long value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        /**
         * 添加 adminId > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdGreaterThan(Long value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        /**
         * 添加 adminId >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        /**
         * 添加 adminId < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdLessThan(Long value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        /**
         * 添加 adminId <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        /**
         * 添加adminIdin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdIn(List<Long> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        /**
         * 添加adminIdnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdNotIn(List<Long> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        /**
         * 添加adminId between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdBetween(Long value1, Long value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        /**
         * 添加adminId not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        /**
         * 添加permissionIdis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        /**
         * 添加permissionIdis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        /**
         * 添加 permissionId = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdEqualTo(Long value) {
            addCriterion("permission_id =", value, "permissionId");
            return (Criteria) this;
        }

        /**
         * 添加 permissionId <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdNotEqualTo(Long value) {
            addCriterion("permission_id <>", value, "permissionId");
            return (Criteria) this;
        }

        /**
         * 添加 permissionId > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdGreaterThan(Long value) {
            addCriterion("permission_id >", value, "permissionId");
            return (Criteria) this;
        }

        /**
         * 添加 permissionId >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("permission_id >=", value, "permissionId");
            return (Criteria) this;
        }

        /**
         * 添加 permissionId < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdLessThan(Long value) {
            addCriterion("permission_id <", value, "permissionId");
            return (Criteria) this;
        }

        /**
         * 添加 permissionId <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdLessThanOrEqualTo(Long value) {
            addCriterion("permission_id <=", value, "permissionId");
            return (Criteria) this;
        }

        /**
         * 添加permissionIdin 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdIn(List<Long> values) {
            addCriterion("permission_id in", values, "permissionId");
            return (Criteria) this;
        }

        /**
         * 添加permissionIdnot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdNotIn(List<Long> values) {
            addCriterion("permission_id not in", values, "permissionId");
            return (Criteria) this;
        }

        /**
         * 添加permissionId between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdBetween(Long value1, Long value2) {
            addCriterion("permission_id between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        /**
         * 添加permissionId not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andPermissionIdNotBetween(Long value1, Long value2) {
            addCriterion("permission_id not between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        /**
         * 添加typeis null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        /**
         * 添加typeis not null条件对象，并返回条件对象
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        /**
         * 添加 type = value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        /**
         * 添加 type <> value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        /**
         * 添加 type > value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        /**
         * 添加 type >= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        /**
         * 添加 type < value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        /**
         * 添加 type <= value条件对象，并返回对象
         * @param value 条件值
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        /**
         * 添加typein 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        /**
         * 添加typenot in 条件对象
         * @param values 条件列表
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        /**
         * 添加type between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        /**
         * 添加type not between value1 and value2条件对象，并返回条件对象
         * @param value1 左区间
         * @param  value2 右区间
         * @return 条件对象
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    /**
     * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)条件对象类
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    public static class Criteria extends GeneratedCriteria {


        /**
         * 条件对象构造函数
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        protected Criteria() {
            super();
        }
    }

    /**
     * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)and 条件对象
     * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
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
         * @author ThinkPad 2020-08-17 10:38
         * @since 1.0.0
         */
        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    /**
     * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)实体类常量类
     * @author ThinkPad 2020-08-17 10:38
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
        public static final String ADMIN_ID = "adminId";

        /**
         * 
         */
        public static final String PERMISSION_ID = "permissionId";

        /**
         * 
         */
        public static final String TYPE = "type";
    }
}