package com.chyuan.webInfo.model;

import com.chyuan.common.BaseModel;

public class WebInfo extends BaseModel {
	private static final long serialVersionUID = 2917857533744823445L;
	
	/**
	 * 网站中文名称
	 */
	private String webName;
	/**
	 * 网站地址
	 */
	private String website;
	/**
	 * 网站关键字
	 */
	private String webKeyword;
	/**
	 * 网站说明
	 */
	private String webDescription;
	/**
	 * 公司地址
	 */
	private String address;
	/**
	 * 邮编
	 */
	private String postcode;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 邮箱
	 */
	private String mail;
	/**
	 * 联系人
	 */
	private String linkman;
	/**
	 * icp备案号
	 */
	private String icpCode;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 热线电话
	 */
	private String hotline;
	/**
	 * 类型。1：中文；2：英文
	 */
	private Integer type;
	
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getIcpCode() {
		return icpCode;
	}
	public void setIcpCode(String icpCode) {
		this.icpCode = icpCode;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getHotline() {
		return hotline;
	}
	public void setHotline(String hotline) {
		this.hotline = hotline;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getWebName() {
		return webName;
	}
	public void setWebName(String webName) {
		this.webName = webName;
	}
	public String getWebKeyword() {
		return webKeyword;
	}
	public void setWebKeyword(String webKeyword) {
		this.webKeyword = webKeyword;
	}
	public String getWebDescription() {
		return webDescription;
	}
	public void setWebDescription(String webDescription) {
		this.webDescription = webDescription;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
