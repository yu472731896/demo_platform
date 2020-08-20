package com.minghui.database.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class LoginInfo implements Serializable {
	/**
	 * @author cwp 2017年7月26日 下午7:43:57
	 */
	private static final long serialVersionUID = 1L;
	//管理员角色
	public static String ADMIN_ROLE = "admin";
	//普通用户角色
	public static String USER_ROLE = "user";
	
	//主键id
	private String loginId;
	//登录账号
	private String policeId;
	//用户名称
	private String userName;
	//登录密码
	private String passWord;
	//
	private String departmentId;
	//警员名字
	private String policeName;
	//角色
	private String role;
	//验证码
	private String code;
	//创建
	String createUserId;
	
	//创建时间
	Timestamp createTime;
	
	//更新
	String updateUserId;
	
	//更新时间
	Timestamp updateTime;
	
	//归属派出所名称
	String departName;
	
	private String departmentPrivilege;
	
	//用户状态
	private String userState;


}
