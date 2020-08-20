/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ExampleUtil
 * Author:   lhp
 * Date:     2020/3/9 15:30
 * Description: Example请求参数工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.minghui.common.framework.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Example请求参数工具类
 * @author lhp 2020-03-09 15:30
 * @since 1.0.0
 */
public class ExampleUtil {
    /**
     * 升序
     */
    public static final String ASC = "asc";
    /**
     * 降序
     */
    public static final String DESC = "desc";
    /**
     * 英文逗号
     */
    public static final String SPLIT_EN_COMMA = ",";
    /**
     * 英文空格
     */
    public static final String SPLIT_EN_BLANK = " ";


    /**
     * 添加需要排序的字段和类型
     * @param orderField 字段名称
     * @param orderType 排序类型
     * @param modelInfo
     * @param orderByClause
     * @author lvv 2020-03-09 15:21
     * @since 1.0.0
     */
    public static String getOrderField(String orderField, String orderType, Map<String, String> modelInfo, String orderByClause) {
        if (StringUtils.isNotEmpty(orderField)) {
            StringBuilder orderByCauserBuilder = new StringBuilder();
            String type;
            if (modelInfo.get(orderField) != null) {
                if (orderType.toLowerCase().equals(DESC)) {
                    type = DESC;
                } else {
                    type = ASC;
                }
                orderByCauserBuilder.append(modelInfo.get(orderField));
                orderByCauserBuilder.append(SPLIT_EN_BLANK);
                orderByCauserBuilder.append(type);
                orderByCauserBuilder.append(SPLIT_EN_COMMA);
            }
            if (StringUtils.isNotBlank(orderByCauserBuilder)) {
                if (StringUtils.isNotEmpty(orderByClause)) {
                    orderByClause += SPLIT_EN_COMMA;
                    orderByClause += orderByCauserBuilder.substring(0, orderByCauserBuilder.length() - 1);
                } else {
                    orderByClause = orderByCauserBuilder.substring(0, orderByCauserBuilder.length() - 1);
                }
            }
        }
        return orderByClause;
    }

    /**
     * 添加需要排序的字段和类型
     * @param orderFields 字段名称数组
     * @param orderTypes 排序类型数组
     * @param modelInfo
     * @param orderByClause
     * @author lvv 2020-03-09 15:21
     * @since 1.0.0
     */
    public static String getOrderFields(String[] orderFields, String[] orderTypes, Map<String, String> modelInfo, String orderByClause) {
        if (orderFields != null) {
            StringBuilder orderByCauserBuilder = new StringBuilder();
            int orderFieldsLength = orderFields.length;
            int orderTypesLength = 0;
            String type;
            if (orderFields != null) {
                orderTypesLength = orderTypes.length;
            }
            for (int i = 0; i < orderFieldsLength; i++) {
                if (modelInfo.get(orderFields[i]) != null) {
                    if (orderTypesLength > i && orderTypes[i].toLowerCase().equals(DESC)) {
                        type = DESC;
                    } else {
                        type = ASC;
                    }
                    orderByCauserBuilder.append(modelInfo.get(orderFields[i]));
                    orderByCauserBuilder.append(SPLIT_EN_BLANK);
                    orderByCauserBuilder.append(type);
                    orderByCauserBuilder.append(SPLIT_EN_COMMA);
                }
            }
            if (StringUtils.isNotBlank(orderByCauserBuilder)) {
                if (StringUtils.isNotEmpty(orderByClause)) {
                    orderByClause += SPLIT_EN_COMMA;
                    orderByClause += orderByCauserBuilder.substring(0, orderByCauserBuilder.length() - 1);
                } else {
                    orderByClause = orderByCauserBuilder.substring(0, orderByCauserBuilder.length() - 1);
                }
            }
        }
        return orderByClause;
    }
}