package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台用户角色表实体类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseModel implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 4901224396063253504L;

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 后台用户数量
     */
    private Integer adminCount;

    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;

    private Integer sort;
}