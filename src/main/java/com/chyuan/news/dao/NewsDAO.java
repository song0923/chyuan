package com.chyuan.news.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.chyuan.news.model.News;

@DAO
public interface NewsDAO {
	String TABLE_NAME = " news ";
	String FIELDS = " id,title,content,create_time,type ";
	
	/**
	 * 获取一条新闻
	 * @param id
	 * @return
	 */
	@SQL(" select " + FIELDS + " from " + TABLE_NAME + " where id = :1 ")
	public News getNews(Long id);
	
	/**
	 * 获取新闻分页数据
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@SQL(" select " + FIELDS + " from " + TABLE_NAME + " where type = :1" +
			" #if(:4){and (title like :4 or content like :4)} " +
			" order by create_time desc limit :2 , :3 ")
	public List<News> getNewsList(Integer type, int start, int pageSize, String searchText);
	
	/**
	 * 获取新闻总记录数
	 * @return
	 */
	@SQL(" select count(1) from " + TABLE_NAME + " where type = :1 " +
			" #if(:2){and (title like :2 or content like :2)} ")
	public int countGetNewsList(Integer type, String searchText);
	
	@SQL(" insert into " + TABLE_NAME + "(" + FIELDS + ")" + " values(:1.id, :1.title, :1.content, now(), :1.type) ")
	public void insertNews(News news);
	
	@SQL(" update " + TABLE_NAME + " set title = :1.title, content = :1.content, type = :1.type where id = :1.id ")
	public void updateNews(News news);
	
	@SQL(" delete from " + TABLE_NAME + " where id = :1 ")
	public void deleteNews(Long id);
}
