package com.chyuan.jobs.controllers;

import java.util.List;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.jobs.home.JobsHome;
import com.chyuan.jobs.model.Jobs;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Page;
import com.chyuan.utils.RePageConstants;
/**
 * 招聘：前台控制器
 * @author song.zhang@boco.jp
 *
 */
@Path("/jobs")
public class JobsController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private JobsHome jobsHome;
	
	/**
	 * 前台：查看招聘明细
	 * @param id
	 * @return
	 */
	@Get("/detail/{id}")
	public String jobsDetail(@Param("id")Long id){
		Jobs jobs = jobsHome.getJobs(id);
		inv.addModel("Jobs", jobs);
		return RePageConstants.JOBS_DETAIL;
	}
	
	/**
	 * 前台：招聘中心列表
	 * @param type
	 * @return
	 */
	@Get("/list/{type}")
	public String jobsList(@Param("type")Integer type){
		int pageIndex = inv.getParameter("page") != null ? Integer.parseInt(inv.getParameter("page")) : 1;
		int total = jobsHome.countGetJobsList(type, null);
		int start = (pageIndex - 1) * Constants.PAGE_SIZE;
		List<Jobs> jobsList = jobsHome.getJobsList(type, start, Constants.PAGE_SIZE, null);
		Page<Jobs> page = new Page<Jobs>(total, Constants.PAGE_SIZE, pageIndex, jobsList);
		inv.addModel("page", page);
		inv.addModel("jobsList", jobsList);
		return RePageConstants.JOBS_LIST;
	}
}
