package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台用户表实体类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseModel implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 7793126779848361984L;

    private Long id;

    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 最后登录时间
     */
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;
}