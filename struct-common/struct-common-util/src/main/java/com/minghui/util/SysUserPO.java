package com.minghui.util;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 20:48 2019/3/26
 * @Modified By:
 */
@Data
public class SysUserPO implements Serializable {

    private static final long serialVersionUID = 2901539147524152211L;

    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 警员号
     */
    private String policeNo;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 组织id
     */
    private Long departmentId;

    /**
     * 组织编码
     */
    private String departmentNo;

    /**
     * 组织名称
     */
    private String departmentName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 备注
     */
    private String remark;

    /**
     * 角色组id
     */
    private Long roleGroupId;

    /**
     * 用户有效起始时间
     */
    private Date effectiveStartTime;

    /**
     * 用户有效结束时间
     */
    private Date effectiveEndTime;

    /**
     * 通用数据权限(1、市局,2、分局,3、支队,4、支队,5、支队,6、个人)
     */
    private Short general;

    /**
     * 是否删除（0、否；1、是）
     */
    private Boolean isDelete;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后登录ip地址
     */
    private String lastLoginAddress;

    /**
     * 是否多端登录(true表示支持,false表示不支持)
     */
    private Boolean noMulLogin;

    /**
     * 绑定的ip地址
     */
    private String bindIpAdd;

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
     * 新增数据的ip
     */
    private String createServerHost;

    /**
     * 修改用户
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
     * 更新数据ip
     */
    private String updateServerHost;

    /**
     * 记录版本号
     */
    private Integer recordVersion;
}
