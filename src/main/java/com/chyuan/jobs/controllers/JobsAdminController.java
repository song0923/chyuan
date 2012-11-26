package com.chyuan.jobs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.interceptor.LoginRequired;
import com.chyuan.jobs.home.JobsHome;
import com.chyuan.jobs.model.Jobs;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Page;
import com.chyuan.utils.RePageConstants;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
/**
 * 招聘：后台控制器
 * @author song.zhang@boco.jp
 *
 */
@LoginRequired
@Path("/admin/jobs")
public class JobsAdminController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private JobsHome jobsHome;
	
	/**
	 * 后台：招聘列表
	 * @param type 语言类型
	 * @return
	 */
	@Get("/list/{type}")
	public String jobsListBank(@Param("type")Integer type) {
		int pageIndex = inv.getParameter("page") != null ? Integer.parseInt(inv.getParameter("page")) : 1;
		int total = jobsHome.countGetJobsList(type, null);
		int start = (pageIndex - 1) * Constants.PAGE_SIZE;
		List<Jobs> jobsList = jobsHome.getJobsList(type, start, Constants.PAGE_SIZE, null);
		Page<Jobs> page = new Page<Jobs>(total, Constants.PAGE_SIZE, pageIndex, jobsList);
		inv.addModel("page", page);
		inv.addModel("jobsList", jobsList);
		inv.addModel("type", type);
		return RePageConstants.A_JOBS_LIST;
	}
	
	/**
	 * 后台：跳转招聘页面（添加）
	 * @param type
	 * @return
	 */
	@Get("/add/{type}")
	public String jobsPageAdd(@Param("type")Integer type){
		String titler = "添加";
		inv.addModel("titler", titler);
		inv.addModel("type", type);
		return RePageConstants.A_JOBS;
	}
	
	/**
	 * 后台：跳转招聘页面（编辑）
	 * @param id
	 * @param type
	 * @return
	 */
	@Get("/edit/{id}/{type}")
	public String jobsPageAdd(@Param("id")Long id, @Param("type")Integer type){
		String titler = "编辑";
		Jobs jobs = jobsHome.getJobs(id);
		inv.addModel("jobs", jobs);
		inv.addModel("titler", titler);
		inv.addModel("type", type);
		return RePageConstants.A_JOBS;
	}
	
	/**
	 * 后台：保存招聘
	 * @param Jobs
	 * @return
	 */
	@Post("/save")
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
	@Get("/delete/{id}/{type}")
	public String jobsDelete(@Param("id")Long id, @Param("type")Integer type){
		jobsHome.deleteJobs(id);
		return "@<script>alert(\"招聘信息删除成功！\");location.href=\"/admin/jobs/list/" + type + "\";</script>";
	}
}
