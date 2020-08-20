package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)实体类
 * @author ThinkPad 2020-08-17 10:38
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysPermissionRelation extends BaseModel implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 3185008441138862592L;

    private Long id;

    private Long adminId;

    private Long permissionId;

    private Integer type;
}