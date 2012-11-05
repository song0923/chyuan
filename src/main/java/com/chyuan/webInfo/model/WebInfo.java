package com.chyuan.webInfo.model;

public class WebInfo {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 网站中文名称
	 */
	private String webNameCn;
	/**
	 * 网站地址
	 */
	private String website;
	/**
	 * 网站关键字
	 */
	private String webKeywordCn;
	/**
	 * 网站说明
	 */
	private String webDescriptionCn;
	/**
	 * 公司地址
	 */
	private String addressCn;
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
	
	public String getWebNameCn() {
		return webNameCn;
	}
	public void setWebNameCn(String webNameCn) {
		this.webNameCn = webNameCn;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getWebKeywordCn() {
		return webKeywordCn;
	}
	public void setWebKeywordCn(String webKeywordCn) {
		this.webKeywordCn = webKeywordCn;
	}
	public String getWebDescriptionCn() {
		return webDescriptionCn;
	}
	public void setWebDescriptionCn(String webDescriptionCn) {
		this.webDescriptionCn = webDescriptionCn;
	}
	public String getAddressCn() {
		return addressCn;
	}
	public void setAddressCn(String addressCn) {
		this.addressCn = addressCn;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
