package com.chyuan.webInfo.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chyuan.webInfo.dao.WebInfoDAO;
import com.chyuan.webInfo.model.WebInfo;

@Component
public class WebInfoHome {

	@Autowired
	private WebInfoDAO wenInfoDao;
	
	/**
	 * 获取网站信息
	 * @return
	 */
	public WebInfo getWebInfo(Integer type){
		return wenInfoDao.getWebInfo(type);
	}
	
	/**
	 * 编辑网站信息
	 * @param webInfo
	 */
	public void editWebInfo(WebInfo webInfo){
		wenInfoDao.editWebInfo(webInfo);
	}
}
