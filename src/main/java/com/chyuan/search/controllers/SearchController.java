package com.chyuan.search.controllers;

import java.util.List;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.jobs.home.JobsHome;
import com.chyuan.jobs.model.Jobs;
import com.chyuan.news.home.NewsHome;
import com.chyuan.news.model.News;
import com.chyuan.product.home.ProductHome;
import com.chyuan.product.model.Product;
import com.chyuan.search.model.Search;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Page;

@Path("/search")
public class SearchController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private NewsHome newsHome;
	@Autowired
	private ProductHome productHome;
	@Autowired
	private JobsHome jobsHome;

	@Post("")
	public String search(Search search) {
		inv.addModel("searchText", search.getSearchText());
		inv.addModel("searchId", search.getSearchId());
		switch (search.getSearchId()) {
		case Constants.SEARCH_PRODUCT:
			List<Product> productList = productHome.getProductList(search.getType(), 0, Constants.PAGE_SIZE, "%" + search.getSearchText() + "%");
			int totalProduct = productHome.countGetProductList(search.getType(), "%" + search.getSearchText() + "%");
			Page<Product> pageProduct = new Page<Product>(totalProduct, Constants.PAGE_SIZE, 1, productList);
			inv.addModel("productList", productList);
			inv.addModel("page", pageProduct);
			return Constants.PRODUCT_LIST;
		case Constants.SEARCH_NEWS:
			List<News> newsList = newsHome.getNewsList(search.getType(), 0, Constants.PAGE_SIZE, "%" + search.getSearchText() + "%");
			int totalNews = newsHome.countGetNewsList(search.getType(), "%" + search.getSearchText() + "%");
			Page<News> pageNews = new Page<News>(totalNews, Constants.PAGE_SIZE, 1, newsList);
			inv.addModel("newsList", newsList);
			inv.addModel("page", pageNews);
			return Constants.NEWS_LIST;
		case Constants.SEARCH_JOBS:
			List<Jobs> jobsList = jobsHome.getJobsList(search.getType(), 0, Constants.PAGE_SIZE, "%" + search.getSearchText() + "%");
			int totalJobs = jobsHome.countGetJobsList(search.getType(), "%" + search.getSearchText() + "%");
			Page<Jobs> pageJobs = new Page<Jobs>(totalJobs, Constants.PAGE_SIZE, 1, jobsList);
			inv.addModel("jobsList", jobsList);
			inv.addModel("page", pageJobs);
			return Constants.JOBS_LIST;
		default:
			return null;
		}
	}
}
