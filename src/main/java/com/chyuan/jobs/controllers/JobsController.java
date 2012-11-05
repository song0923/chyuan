package com.chyuan.jobs.controllers;

import java.util.List;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.interceptor.LoginRequired;
import com.chyuan.jobs.home.JobsHome;
import com.chyuan.jobs.model.Jobs;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Page;

@Path("")
public class JobsController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private JobsHome jobsHome;
	
	/********************************** 前台控制器  ***********************************/
	
	/**
	 * 前台：查看招聘明细
	 * @param id
	 * @return
	 */
	@Get("/jobs/detail/{id}")
	public String jobsDetail(@Param("id")Long id){
		Jobs jobs = jobsHome.getJobs(id);
		inv.addModel("Jobs", jobs);
		return Constants.JOBS_DETAIL;
	}
	
	/**
	 * 前台：招聘中心列表
	 * @param type
	 * @return
	 */
	@Get("/jobs/list/{type}")
	public String jobsList(@Param("type")Integer type){
		int pageIndex = inv.getParameter("page") != null ? Integer.parseInt(inv.getParameter("page")) : 1;
		int total = jobsHome.countGetJobsList(type, null);
		int start = (pageIndex - 1) * Constants.PAGE_SIZE;
		List<Jobs> jobsList = jobsHome.getJobsList(type, start, Constants.PAGE_SIZE, null);
		Page<Jobs> page = new Page<Jobs>(total, Constants.PAGE_SIZE, pageIndex, jobsList);
		inv.addModel("page", page);
		inv.addModel("jobsList", jobsList);
		return Constants.JOBS_LIST;
	}
	
	/********************************** 后台控制器  ***********************************/
	
	/**
	 * 后台：招聘列表
	 * @param type 语言类型
	 * @return
	 */
	@Get("/admin/jobs/list/{type}")
	@LoginRequired
	public String jobsListBank(@Param("type")Integer type) {
		int pageIndex = inv.getParameter("page") != null ? Integer.parseInt(inv.getParameter("page")) : 1;
		int total = jobsHome.countGetJobsList(type, null);
		int start = (pageIndex - 1) * Constants.PAGE_SIZE;
		List<Jobs> jobsList = jobsHome.getJobsList(type, start, Constants.PAGE_SIZE, null);
		Page<Jobs> page = new Page<Jobs>(total, Constants.PAGE_SIZE, pageIndex, jobsList);
		inv.addModel("page", page);
		inv.addModel("jobsList", jobsList);
		inv.addModel("type", type);
		return Constants.A_JOBS_LIST;
	}
	
	/**
	 * 后台：跳转招聘页面（添加）
	 * @param type
	 * @return
	 */
	@Get("/admin/jobs/add/{type}")
	@LoginRequired
	public String jobsPageAdd(@Param("type")Integer type){
		String titler = "添加";
		inv.addModel("titler", titler);
		inv.addModel("type", type);
		return Constants.A_JOBS;
	}
	
	/**
	 * 后台：跳转招聘页面（编辑）
	 * @param id
	 * @param type
	 * @return
	 */
	@Get("/admin/jobs/edit/{id}/{type}")
	@LoginRequired
	public String jobsPageAdd(@Param("id")Long id, @Param("type")Integer type){
		String titler = "编辑";
		Jobs jobs = jobsHome.getJobs(id);
		inv.addModel("jobs", jobs);
		inv.addModel("titler", titler);
		inv.addModel("type", type);
		return Constants.A_JOBS;
	}
	
	/**
	 * 后台：保存招聘
	 * @param Jobs
	 * @return
	 */
	@Post("/admin/jobs/save")
	@LoginRequired
	public String JobsSave(Jobs jobs){
		jobsHome.saveJobs(jobs);
		String jobs_msg = "招聘信息保存成功！";
		inv.addModel("type", jobs.getType());
		return "@<script>alert(\"" + jobs_msg + "\");location.href=\"/admin/jobs/list/" + jobs.getType() + "\";</script>";
	}
	
	/**
	 * 后台：删除招聘
	 * @param id
	 * @param type
	 * @return
	 */
	@Get("/admin/jobs/delete/{id}/{type}")
	@LoginRequired
	public String jobsDelete(@Param("id")Long id, @Param("type")Integer type){
		jobsHome.deleteJobs(id);
		return "@<script>alert(\"招聘信息删除成功！\");location.href=\"/admin/jobs/list/" + type + "\";</script>";
	}
}
