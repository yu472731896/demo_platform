package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台用户权限表实体类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysPermission extends BaseModel implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 8807656027940226048L;

    private Long id;

    /**
     * 父级权限id
     */
    private Long pid;

    /**
     * 名称
     */
    private String name;

    /**
     * 权限值
     */
    private String value;

    /**
     * 图标
     */
    private String icon;

    /**
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    private Integer type;

    /**
     * 前端资源路径
     */
    private String uri;

    /**
     * 启用状态；0->禁用；1->启用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;
}