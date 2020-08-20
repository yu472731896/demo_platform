package com.minghui.util;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 20:49 2019/3/26
 * @Modified By:
 */
@Data
public class SysRolePO implements Serializable {

    /**
     * 主键
     */
    private Long roleId;

    /**
     * 角色编码
     */
    private String roleNo;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 父级ID
     */
    private Long roleParentId;

    /**
     * 父级名称
     */
    private String roleParentName;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 是否删除（0、否；1、是）
     */
    private Boolean isDelete;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建部门
     */
    private String createDepartment;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人ip
     */
    private String createServerHost;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改部门
     */
    private String updateDepartment;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 更新人ip
     */
    private String updateServerHost;

    /**
     * 记录版本号
     */
    private Integer recordVersion;

    private static final long serialVersionUID = -4531028220326904015L;
}
