package com.chyuan.user.model;

import java.util.Date;

public class User {

	private Long id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 是否删除。1：是；0：否
	 */
	private Integer isDelete;
	/**
	 * 创建日期
	 */
	private Date createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
