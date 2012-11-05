package com.chyuan.jobs.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chyuan.jobs.dao.JobsDAO;
import com.chyuan.jobs.model.Jobs;

@Component
public class JobsHome {
	@Autowired
	private JobsDAO jobsDao;
	
	public Jobs getJobs(Long id){
		return jobsDao.getJobs(id);
	}
	
	public List<Jobs> getJobsList(Integer type, int start, int pageSize, String searchText){
		return jobsDao.getJobsList(type, start, pageSize, searchText);
	}
	
	public int countGetJobsList(Integer type, String searchText){
		return jobsDao.countGetJobsList(type, searchText);
	}
	
	public void saveJobs(Jobs Jobs){
		if(null == Jobs.getId()){
			jobsDao.insertJobs(Jobs);
		}else{
			jobsDao.updateJobs(Jobs);
		}
	}
	
	public void deleteJobs(Long id){
		jobsDao.deleteJobs(id);
	}
}
