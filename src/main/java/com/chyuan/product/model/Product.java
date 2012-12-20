package com.chyuan.product.model;

import java.util.Date;

import com.chyuan.common.BaseModel;

public class Product extends BaseModel {
	private static final long serialVersionUID = -7642852847061345816L;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 发布日期
	 */
	private Date createTime;
	/**
	 * 类型。1：中文；2：英文
	 */
	private Integer type;
	/**
	 * 缩略图
	 */
	private String thumbnail;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
