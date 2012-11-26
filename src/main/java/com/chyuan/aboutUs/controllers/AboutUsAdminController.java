package com.chyuan.aboutUs.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.aboutUs.home.AboutUsHome;
import com.chyuan.aboutUs.model.AboutUs;
import com.chyuan.interceptor.LoginRequired;
import com.chyuan.utils.RePageConstants;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
/**
 * 关于我们：后台控制器
 * @author song.zhang@boco.jp
 *
 */
@LoginRequired
@Path("/admin/aboutUs")
public class AboutUsAdminController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private AboutUsHome aboutUsHome;
	
	/**
	 * 后台：进入关于我们编辑页面
	 * @param type
	 * @return
	 */
	@Get("/editPage/{type}")
	public String aboutUsEditPage(@Param("type")Integer type){
		AboutUs aboutUs = aboutUsHome.getAboutUsByType(type);
		inv.addModel("aboutUs", aboutUs);
		return RePageConstants.A_ABOUT_US;
	}
	
	/**
	 * 后台：编辑关于我们
	 * @param aboutUs
	 * @param id
	 * @return
	 */
	@Post("/edit/{id}")
	public String aboutUsEdit(AboutUs aboutUs, @Param("id")Long id){
		aboutUsHome.editAboutUs(aboutUs, id);
		AboutUs au = aboutUsHome.getAboutUsById(id);
		inv.addModel("aboutUs", au);
		inv.addModel("aboutUs_msg", "编辑成功！");
		return RePageConstants.A_ABOUT_US;
	}
}
