package com.chyuan.news.controllers;

import java.util.List;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.news.home.NewsHome;
import com.chyuan.news.model.News;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Page;
import com.chyuan.utils.RePageConstants;
/**
 * 新闻：前台控制器
 * @author song.zhang@boco.jp
 *
 */
@Path("/news")
public class NewsController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private NewsHome newsHome;
	
	/**
	 * 前台：查看新闻明细
	 * @param id
	 * @return
	 */
	@Get("/detail/{id}")
	public String newsDetail(@Param("id")Long id){
		News news = newsHome.getNews(id);
		inv.addModel("news", news);
		return RePageConstants.NEWS_DETAIL;
	}
	
	/**
	 * 前台：新闻中心列表
	 * @param type
	 * @return
	 */
	@Get("/list/{type}")
	public String newsList(@Param("type")Integer type){
		int pageIndex = inv.getParameter("page") != null ? Integer.parseInt(inv.getParameter("page")) : 1;
		int total = newsHome.countGetNewsList(type, null);
		int start = (pageIndex - 1) * Constants.PAGE_SIZE;
		List<News> newsList = newsHome.getNewsList(type, start, Constants.PAGE_SIZE, null);
		Page<News> page = new Page<News>(total, Constants.PAGE_SIZE, pageIndex, newsList);
		inv.addModel("page", page);
		inv.addModel("newsList", newsList);
		return RePageConstants.NEWS_LIST;
	}
}
