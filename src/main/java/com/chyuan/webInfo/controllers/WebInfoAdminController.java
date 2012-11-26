package com.chyuan.webInfo.controllers;

import javax.servlet.ServletContext;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.interceptor.LoginRequired;
import com.chyuan.utils.RePageConstants;
import com.chyuan.utils.Utils;
import com.chyuan.webInfo.home.WebInfoHome;
import com.chyuan.webInfo.model.WebInfo;

@LoginRequired
@Path("/admin/webInfo")
public class WebInfoAdminController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private WebInfoHome webInfoHome;
	@Autowired
	private Utils utils;

	/**
	 * 后台：跳转到网站信息编辑页面
	 * @return
	 */
	@Get("/editPage/{type}")
	public String editWebInfoPage(@Param("type")Integer type){
		WebInfo webInfo = webInfoHome.getWebInfo(type);
		inv.addModel("webInfo", webInfo);
		return RePageConstants.A_WEB_INFO;
	}
	
	/**
	 * 后台：编辑网站信息
	 * @return
	 */
	@Post("/edit")
	public String editWebInfo(WebInfo webInfo){
		webInfoHome.editWebInfo(webInfo);
		WebInfo wi = webInfoHome.getWebInfo(webInfo.getType());
		ServletContext context = inv.getServletContext();
		utils.systemConfig((String)context.getAttribute("language"), context);
		inv.addModel("webInfo", wi);
		inv.addModel("webInfo_msg", "网站信息编辑成功！");
		return RePageConstants.A_WEB_INFO;
	}
}
