package com.chyuan.aboutUs.model;

import com.chyuan.common.BaseModel;

public class AboutUs extends BaseModel {
	private static final long serialVersionUID = -2100367750850699846L;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
