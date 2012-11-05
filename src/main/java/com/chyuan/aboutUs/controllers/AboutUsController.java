package com.chyuan.aboutUs.controllers;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import org.springframework.beans.factory.annotation.Autowired;
import com.chyuan.aboutUs.home.AboutUsHome;
import com.chyuan.aboutUs.model.AboutUs;
import com.chyuan.interceptor.LoginRequired;
import com.chyuan.utils.Constants;

@Path("")
public class AboutUsController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private AboutUsHome aboutUsHome;
	
	/**
	 * 前台：关于我们
	 * @param language
	 * @param id
	 * @return
	 */
	@Get("/aboutUs/{id}")
	public String aboutUs(@Param("id")Long id){
		String language = (String)inv.getServletContext().getAttribute("language");
		Integer type = language.equals(Constants.LANGUAGE_CN) ? 1 : 2;
		AboutUs aboutUs = aboutUsHome.getAboutUsByType(type);
		inv.addModel("aboutUs", aboutUs);
		return Constants.ABOUT_US;
	}
	
	/**
	 * 后台：进入关于我们编辑页面
	 * @param type
	 * @return
	 */
	@Get("/admin/aboutUs/editPage/{type}")
	@LoginRequired
	public String aboutUsEditPage(@Param("type")Integer type){
		AboutUs aboutUs = aboutUsHome.getAboutUsByType(type);
		inv.addModel("aboutUs", aboutUs);
		return Constants.A_ABOUT_US;
	}
	
	/**
	 * 后台：编辑关于我们
	 * @param aboutUs
	 * @param id
	 * @return
	 */
	@Post("/admin/aboutUs/edit/{id}")
	@LoginRequired
	public String aboutUsEdit(AboutUs aboutUs, @Param("id")Long id){
		aboutUsHome.editAboutUs(aboutUs, id);
		AboutUs au = aboutUsHome.getAboutUsById(id);
		inv.addModel("aboutUs", au);
		inv.addModel("aboutUs_msg", "编辑成功！");
		return Constants.A_ABOUT_US;
	}
	
}
