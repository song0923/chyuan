package com.chyuan.aboutUs.model;

public class AboutUs {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 类型。1：中文；2：英文
	 */
	private Integer type;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
