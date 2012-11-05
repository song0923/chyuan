package com.chyuan.search.model;

public class Search {
	/**
	 * 搜索类型。1：产品；2：新闻；3：招聘
	 */
	private Integer searchId;
	/**
	 * 搜索关键字
	 */
	private String searchText;
	/**
	 * 语言类型。1：中文；2：英文
	 */
	private Integer type;
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
}
