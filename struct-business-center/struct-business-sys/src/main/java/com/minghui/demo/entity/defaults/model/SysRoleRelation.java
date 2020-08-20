package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台用户和角色关系表实体类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleRelation extends BaseModel implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 7252927400995330048L;

    private Long id;

    private Long userId;

    private Long roleId;
}