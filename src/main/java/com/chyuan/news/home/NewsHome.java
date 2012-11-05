package com.chyuan.news.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chyuan.news.dao.NewsDAO;
import com.chyuan.news.model.News;

@Component
public class NewsHome {
	@Autowired
	private NewsDAO newsDao;
	
	public News getNews(Long id){
		return newsDao.getNews(id);
	}
	
	public List<News> getNewsList(Integer type, int start, int pageSize, String searchText){
		return newsDao.getNewsList(type, start, pageSize, searchText);
	}
	
	public int countGetNewsList(Integer type, String searchText){
		return newsDao.countGetNewsList(type, searchText);
	}
	
	public void saveNews(News news){
		if(null == news.getId()){
			newsDao.insertNews(news);
		}else{
			newsDao.updateNews(news);
		}
	}
	
	public void deleteNews(Long id){
		newsDao.deleteNews(id);
	}
}
