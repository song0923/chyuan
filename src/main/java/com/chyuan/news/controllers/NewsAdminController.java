package com.chyuan.news.controllers;

import java.util.List;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.interceptor.LoginRequired;
import com.chyuan.news.home.NewsHome;
import com.chyuan.news.model.News;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Page;
import com.chyuan.utils.RePageConstants;
/**
 * 新闻：后台控制器
 * @author song.zhang@boco.jp
 *
 */
@LoginRequired
@Path("/admin/news")
public class NewsAdminController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private NewsHome newsHome;
	
	/**
	 * 后台：新闻列表
	 * @param type 语言类型
	 * @return
	 */
	@Get("/list/{type}")
	public String newsListBank(@Param("type")Integer type) {
		int pageIndex = inv.getParameter("page") != null ? Integer.parseInt(inv.getParameter("page")) : 1;
		int total = newsHome.countGetNewsList(type, null);
		int start = (pageIndex - 1) * Constants.PAGE_SIZE;
		List<News> newsList = newsHome.getNewsList(type, start, Constants.PAGE_SIZE, null);
		Page<News> page = new Page<News>(total, Constants.PAGE_SIZE, pageIndex, newsList);
		inv.addModel("page", page);
		inv.addModel("newsList", newsList);
		inv.addModel("type", type);
		return RePageConstants.A_NEWS_LIST;
	}
	
	/**
	 * 后台：跳转新闻页面（添加）
	 * @param type
	 * @return
	 */
	@Get("/add/{type}")
	public String newsPageAdd(@Param("type")Integer type){
		String titler = "添加";
		inv.addModel("titler", titler);
		inv.addModel("type", type);
		return RePageConstants.A_NEWS;
	}
	
	/**
	 * 后台：跳转新闻页面（编辑）
	 * @param id
	 * @param type
	 * @return
	 */
	@Get("/edit/{id}/{type}")
	public String newsPageAdd(@Param("id")Long id, @Param("type")Integer type){
		String titler = "编辑";
		News news = newsHome.getNews(id);
		inv.addModel("news", news);
		inv.addModel("titler", titler);
		inv.addModel("type", type);
		return RePageConstants.A_NEWS;
	}
	
	/**
	 * 后台：保存新闻
	 * @param news
	 * @return
	 */
	@Post("/save")
	public String newsSave(News news){
		newsHome.saveNews(news);
		String news_msg = "新闻保存成功！";
		inv.addModel("type", news.getType());
		return "@<script>alert(\"" + news_msg + "\");location.href=\"/admin/news/list/" + news.getType() + "\";</script>";
	}
	
	/**
	 * 后台：删除新闻
	 * @param id
	 * @param type
	 * @return
	 */
	@Get("/delete/{id}/{type}")
	public String newsDelete(@Param("id")Long id, @Param("type")Integer type){
		newsHome.deleteNews(id);
		return "@<script>alert(\"新闻删除成功！\");location.href=\"/admin/news/list/" + type + "\";</script>";
	}
}
