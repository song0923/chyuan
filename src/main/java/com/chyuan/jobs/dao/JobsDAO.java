package com.chyuan.jobs.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.chyuan.jobs.model.Jobs;

@DAO
public interface JobsDAO {
	String TABLE_NAME = " jobs ";
	String FIELDS = " id,title,content,create_time,type ";
	
	/**
	 * 获取一条招聘
	 * @param id
	 * @return
	 */
	@SQL(" select " + FIELDS + " from " + TABLE_NAME + " where id = :1 ")
	public Jobs getJobs(Long id);
	
	/**
	 * 获取招聘分页数据
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@SQL(" select " + FIELDS + " from " + TABLE_NAME + " where type = :1 " +
			" #if(:4){and (title like :4 or content like :4)} " +
			" order by create_time desc limit :2 , :3 ")
	public List<Jobs> getJobsList(Integer type, int start, int pageSize, String searchText);
	
	/**
	 * 获取招聘总记录数
	 * @return
	 */
	@SQL(" select count(1) from " + TABLE_NAME + " where type = :1 " +
			" #if(:2){and (title like :2 or content like :2)} ")
	public int countGetJobsList(Integer type, String searchText);
	
	@SQL(" insert into " + TABLE_NAME + "(" + FIELDS + ")" + " values(:1.id, :1.title, :1.content, now(), :1.type) ")
	public void insertJobs(Jobs jobs);
	
	@SQL(" update " + TABLE_NAME + " set title = :1.title, content = :1.content, type = :1.type where id = :1.id ")
	public void updateJobs(Jobs jobs);
	
	@SQL(" delete from " + TABLE_NAME + " where id = :1 ")
	public void deleteJobs(Long id);
}
