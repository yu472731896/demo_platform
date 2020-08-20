package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表实体类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusMember extends BaseModel implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1986618189513325056L;

    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    private Long memberLevelId;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 帐号启用状态:0->禁用；1->启用
     */
    private Integer status;

    /**
     * 头像
     */
    private String icon;

    /**
     * 性别：0->未知；1->男；2->女
     */
    private Integer gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 所做城市
     */
    private String city;

    /**
     * 职业
     */
    private String job;

    /**
     * 个性签名
     */
    private String personalizedSignature;

    /**
     * 用户来源
     */
    private Integer sourceType;

    /**
     * 积分
     */
    private Integer integration;

    /**
     * 微信Id
     */
    private String weixinOpenid;
}