package com.chyuan.aboutUs.controllers;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.aboutUs.home.AboutUsHome;
import com.chyuan.aboutUs.model.AboutUs;
import com.chyuan.utils.Constants;
import com.chyuan.utils.RePageConstants;
/**
 * 关于我们：前台控制器
 * @author song.zhang@boco.jp
 *
 */
@Path("/aboutUs")
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
	@Get("/{id}")
	public String aboutUs(@Param("id")Long id){
		String language = (String)inv.getServletContext().getAttribute("language");
		Integer type = language.equals(Constants.LANGUAGE_CN) ? 1 : 2;
		AboutUs aboutUs = aboutUsHome.getAboutUsByType(type);
		inv.addModel("aboutUs", aboutUs);
		return RePageConstants.ABOUT_US;
	}
}
