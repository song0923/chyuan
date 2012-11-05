package com.chyuan.language;

import com.chyuan.utils.Constants;

public class LanguageResouces {
	private static LanguageResouces resouces = new LanguageResouces();
	/**
	 * 主页
	 */
	private String homePage;
	/**
	 * 关于我们
	 */
	private String aboutUs;
	/**
	 * 新闻中心
	 */
	private String newsCenter;
	/**
	 * 新闻标题
	 */
	private String newsTitle;
	/**
	 * 新闻日期
	 */
	private String newsTime;
	/**
	 * 产品展示
	 */
	private String product;
	/**
	 * 当前位置
	 */
	private String location;
	/**
	 * 招聘信息
	 */
	private String jobs;
	/**
	 * 招聘标题
	 */
	private String jobsTitle;
	/**
	 * 招聘日期
	 */
	private String jobsTime;
	/**
	 * 语言
	 */
	private String language;
	/**
	 * 地址
	 */
	private String ct_address;
	/**
	 * 邮编
	 */
	private String ct_postcode;
	/**
	 * 热线电话
	 */
	private String ct_hotline;
	/**
	 * 传真
	 */
	private String ct_fax;
	/**
	 * 邮箱
	 */
	private String ct_email;
	/**
	 * 我们营业的时间
	 */
	private String business;
	
	/**
	 * 创建中文配置
	 * @return
	 */
	private static LanguageResouces getResoucesCN(){
		resouces.aboutUs = "关于我们";
		resouces.homePage = "主页";
		resouces.newsCenter = "新闻中心";
		resouces.location = "当前位置：";
		resouces.newsTitle = "新闻标题";
		resouces.newsTime = "日期";
		resouces.product = "产品展示";
		resouces.jobs = "招聘信息";
		resouces.jobsTitle = "招聘岗位";
		resouces.jobsTime = "日期";
		resouces.language = "English";
		resouces.ct_address = "地址";
		resouces.ct_postcode = "邮编";
		resouces.ct_hotline = "全国服务热线";
		resouces.ct_fax = "传真";
		resouces.ct_email = "邮箱";
		resouces.business = "我们营业的时间";
		return resouces;
	}
	
	/**
	 * 创建英文配置
	 * @return
	 */
	private static LanguageResouces getResoucesEN(){
		resouces.aboutUs = "About US";
		resouces.homePage = "Home";
		resouces.newsCenter = "News";
		resouces.location = "Location:";
		resouces.newsTitle = "Title";
		resouces.newsTime = "Time";
		resouces.product = "Product";
		resouces.jobs = "Jobs";
		resouces.jobsTitle = "Recruitment jobs";
		resouces.jobsTime = "Time";
		resouces.language = "简体中文";
		resouces.ct_address = "ADD";
		resouces.ct_postcode = "ZIP";
		resouces.ct_hotline = "Hotline";
		resouces.ct_fax = "Fax";
		resouces.ct_email = "Email";
		resouces.business = "Our business hours";
		return resouces;
	}
	
	/**
	 * 获取配置实例
	 * @param language
	 * @return
	 */
	public static LanguageResouces getResoucesInstance(String language){
		if(language.equals(Constants.LANGUAGE_EN)){
			resouces = getResoucesEN();
		}else{
			resouces = getResoucesCN();
		}
		return resouces;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public String getHomePage() {
		return homePage;
	}

	public String getNewsCenter() {
		return newsCenter;
	}

	public String getLocation() {
		return location;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public String getNewsTime() {
		return newsTime;
	}

	public String getProduct() {
		return product;
	}

	public String getJobs() {
		return jobs;
	}

	public String getJobsTitle() {
		return jobsTitle;
	}

	public String getJobsTime() {
		return jobsTime;
	}

	public String getLanguage() {
		return language;
	}

	public String getCt_address() {
		return ct_address;
	}

	public String getCt_postcode() {
		return ct_postcode;
	}

	public String getCt_hotline() {
		return ct_hotline;
	}

	public String getCt_fax() {
		return ct_fax;
	}

	public String getCt_email() {
		return ct_email;
	}

	public String getBusiness() {
		return business;
	}
}
