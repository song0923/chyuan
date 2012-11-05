package com.chyuan.index.controllers;

import java.util.List;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.aboutUs.home.AboutUsHome;
import com.chyuan.aboutUs.model.AboutUs;
import com.chyuan.jobs.home.JobsHome;
import com.chyuan.jobs.model.Jobs;
import com.chyuan.news.home.NewsHome;
import com.chyuan.news.model.News;
import com.chyuan.product.home.ProductHome;
import com.chyuan.product.model.Product;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Utils;

@Path("")
public class IndexController {
	@Autowired
	private AboutUsHome aboutUsHome;
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private NewsHome newsHome;
	@Autowired
	private ProductHome productHome;
	@Autowired
	private JobsHome jobsHome;
	@Autowired
	private Utils utils;
	
	/**
	 * 进入网站首页
	 * @return
	 */
	@Get("/{language}/index")
	public String index(@Param("language")String language){
		if(null == language || (!language.equals(Constants.LANGUAGE_CN) && !language.equals(Constants.LANGUAGE_EN))){
			language = Constants.LANGUAGE_CN;
		}
		this.getHomePageData(language);
		return Constants.HOME_PAGE;
	}
	
	/**
	 * 进入网站首页
	 * @return
	 */
	@Get("/index")
	public String index(){
		String language = Constants.LANGUAGE_CN;
		this.getHomePageData(language);
		return Constants.HOME_PAGE;
	}
	
	/**
	 * 获取首页数据
	 * @param language
	 */
	protected void getHomePageData(String language){
		//设置语言
		utils.systemConfig(language, inv.getServletContext());
		//获取关于我们数据
		Integer type = language.equals(Constants.LANGUAGE_CN) ? 1 : 2;
		AboutUs aboutUs = aboutUsHome.getAboutUsByType(type);
		//获取新闻数据
		List<News> newsList = newsHome.getNewsList(type, 0, 7, null);
		//获取产品展示数据
		List<Product> productList = productHome.getProductList(type, 0, 10, null);
		//获取招聘数据
		List<Jobs> jobsList = jobsHome.getJobsList(type, 0, 10, null);
		
		inv.addModel("aboutUs", aboutUs);
		inv.addModel("newsList", newsList);
		inv.addModel("productList", productList);
		inv.addModel("jobsList", jobsList);
	}
}
