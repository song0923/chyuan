package com.chyuan.utils;

/**
 * 系统常量
 * @author song
 *
 */
public class Constants {
	/**
	 * 登录用户存储session的key
	 */
	public static final String LOGIN_USER = "user";
	/**
	 * 网站语言：中文
	 */
	public static final String LANGUAGE_CN = "cn";
	/**
	 * 网站语言：英文
	 */
	public static final String LANGUAGE_EN = "en";
	/**
	 * 分页每页显示记录数
	 */
	public static final int PAGE_SIZE = 10;
	/**
	 * 产品展示列表：分页每页显示记录数
	 */
	public static final int PRODUCT_PAGE_SIZE = 9;
	
	/******************************** 文件上传硬盘目录  ***********************************/
	/**
	 * 文件上传根目录
	 */
	protected static String UPLOAD_ROOT_PATH = "D:/tomcat/jmbk/upload";
	/**
	 * 文件上传：图片目录
	 */
	public static final String UPLOAD_IMG_PATH = UPLOAD_ROOT_PATH + "/img";
	/**
	 * 文件上传：flash目录
	 */
	public static final String UPLOAD_FLASH_PATH = UPLOAD_ROOT_PATH + "/flash";
	/**
	 * 文件上传：多媒体目录
	 */
	public static final String UPLOAD_MEDIA_PATH = UPLOAD_ROOT_PATH + "/media";
	
	/******************************** 搜索类型  ***********************************/
	/**
	 * 产品
	 */
	public static final int SEARCH_PRODUCT = 1;
	/**
	 * 新闻
	 */
	public static final int SEARCH_NEWS = 2;
	/**
	 * 招聘
	 */
	public static final int SEARCH_JOBS = 3;
	
	/******************************** 文件上传限制大小  ***********************************/
	/**
	 * 图片文件大小：10M
	 */
	public static final long MAX_IMG_SIZE = 10000000;
	protected static String IMG_SIZE = "10M";
	/**
	 * flash文件大小：10M
	 */
	public static final long MAX_FLASH_SIZE = 20000000;
	protected static String FLASH_SIZE = "20M";
	/**
	 * media文件大小：10M
	 */
	public static final long MAX_MEDIA_SIZE = 50000000;
	protected static String MEDIA_SIZE = "50M";
	
	/******************************** 文件上传限制大小  ***********************************/
	/**
	 * 提示信息：上传文件为空
	 */
	public static final String MSG_FILE_EMPTY = "上传文件不能为空！";
	/**
	 * 提示信息：图片超过大小限制
	 */
	public static final String MSG_IMG_SIZE = "上传文件的大小不能超过" + IMG_SIZE;
	/**
	 * 提示信息：flash超过大小限制
	 */
	public static final String MSG_FLASH_SIZE = "上传文件的大小不能超过" + FLASH_SIZE;
	/**
	 * 提示信息：media超过大小限制
	 */
	public static final String MSG_MEDIA_SIZE = "上传文件的大小不能超过" + MEDIA_SIZE;
	
	/******************************** URL访问上传文件上下文路径  ***********************************/
	/**
	 * 访问上传文件，上下文根路径
	 */
	protected static String CONTEXT_ROOT_PATH = "/upload";
	/**
	 * 图片访问上下文路径
	 */
	public static final String CONTEXT_IMG_PATH = CONTEXT_ROOT_PATH + "/img";
	/**
	 * flash访问上下文路径
	 */
	public static final String CONTEXT_FLASH_PATH = CONTEXT_ROOT_PATH + "/flash";
	/**
	 * media访问上下文路径
	 */
	public static final String CONTEXT_MEDIA_PATH = CONTEXT_ROOT_PATH + "/media";
}
