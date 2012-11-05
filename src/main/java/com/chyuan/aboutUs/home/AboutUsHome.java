package com.chyuan.aboutUs.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.chyuan.aboutUs.dao.AboutUsDAO;
import com.chyuan.aboutUs.model.AboutUs;

@Component
public class AboutUsHome {
	@Autowired
	private AboutUsDAO aboutUsDao;

	/**
	 * 获取关于我们信息
	 * @return
	 */
	public AboutUs getAboutUsById(Long id){
		return aboutUsDao.getAboutUsById(id);
	}
	
	public AboutUs getAboutUsByType(Integer type){
		return aboutUsDao.getAboutUsByType(type);
	}
	
	/**
	 * 编辑关于我们信息
	 * @param aboutUs
	 */
	public void editAboutUs(AboutUs aboutUs, Long id){
		aboutUsDao.editAboutUs(aboutUs, id);
	}
}
