package com.chyuan.login.model;

public class Login {
	/**
	 * 登录用户名
	 */
	private String userName;
	
	/**
	 * 登录密码
	 */
	private String password;
	
	/**
	 * 验证码
	 */
	private String checkCode;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

}
