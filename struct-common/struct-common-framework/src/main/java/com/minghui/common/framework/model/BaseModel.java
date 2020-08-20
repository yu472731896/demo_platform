package com.minghui.common.framework.model;

import java.util.Date;

public abstract class BaseModel {

	protected Boolean isDelete;

	/**
	 * 创建用户
	 */
	protected String createUser;
	
	/**
	 * 创建部门
	 */
	protected String createDepartment;

	/**
	 * 创建人ip
	 */
	private String createServerHost;
	
	/**
	 * 创建时间
	 */
	protected Date createTime;
	
	/**
	 * 修改用户
	 */
	protected String updateUser;
	
	/**
	 * 修改部门
	 */
	protected String updateDepartment;

	/**
	 * 更新人ip
	 */
	private String updateServerHost;
	
	/**
	 * 修改时间
	 */
	protected Date updateTime;
	
	protected Integer recordVersion;

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateDepartment() {
		return createDepartment;
	}

	public void setCreateDepartment(String createDepartment) {
		this.createDepartment = createDepartment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateDepartment() {
		return updateDepartment;
	}

	public void setUpdateDepartment(String updateDepartment) {
		this.updateDepartment = updateDepartment;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getRecordVersion() {
		return recordVersion;
	}

	public void setRecordVersion(Integer recordVersion) {
		this.recordVersion = recordVersion;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getCreateServerHost() {
		return createServerHost;
	}

	public void setCreateServerHost(String createServerHost) {
		this.createServerHost = createServerHost;
	}

	public String getUpdateServerHost() {
		return updateServerHost;
	}

	public void setUpdateServerHost(String updateServerHost) {
		this.updateServerHost = updateServerHost;
	}
}
