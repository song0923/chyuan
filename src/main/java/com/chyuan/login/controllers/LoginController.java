package com.chyuan.login.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.interceptor.LoginRequired;
import com.chyuan.login.home.LoginHome;
import com.chyuan.login.model.Login;
import com.chyuan.news.home.NewsHome;
import com.chyuan.news.model.News;
import com.chyuan.product.home.ProductHome;
import com.chyuan.product.model.Product;
import com.chyuan.user.model.User;
import com.chyuan.utils.Constants;
import com.chyuan.utils.RePageConstants;

@Path("/admin")
public class LoginController {
	@Autowired
	private LoginHome loginHome;
	@Autowired
	private InvocationLocal inv ;
	@Autowired
	private NewsHome newsHome;
	@Autowired
	private ProductHome productHome;
	
	/**
	 * 转到登录页面
	 * @return
	 */
	@Get("")
	public String loginPage(){
		return RePageConstants.LOGIN_PAGE;
	}
	
	/**
	 * 登录
	 * @param login
	 * @param inv
	 * @return
	 */
	@Post("/login/submit")
	public Object login(Login login){
		HttpSession session = inv.getRequest().getSession();
		//获取session中的验证码
		String kaptchaExpected = (String)session
			    .getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//获取页面提交的验证码
		String kaptchaReceived = login.getCheckCode();
		
		JSONObject json = new JSONObject();
		
		if(!kaptchaExpected.equals(kaptchaReceived)){
			try {
				json.put("status", 0);
				json.put("msg", "验证码错误！");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return json;
		}
		
		User user = loginHome.checkUser(login.getUserName(), login.getPassword());
		if(null == user){
			try {
				json.put("status", 0);
				json.put("msg", "用户名或密码错误！");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return json;
		}else{
			try {
				session.setAttribute(Constants.LOGIN_USER, user);
				json.put("status", 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return json;
		}
	}

	/**
	 * 跳转到后台index
	 * @return
	 */
	@Get("/login/index")
	@LoginRequired
	public String toIndexPage(){
		return RePageConstants.A_INDEX;
	}
	
	/**
	 * 跳转到后台主页
	 * @return
	 */
	@Get("/login/main")
	@LoginRequired
	public String toMainPage(){
		//获取产品列表
		List<Product> productList = productHome.getProductList(1, 0, 5, null);
		int productToal = productHome.countGetProductList(1, null);
		
		//获取新闻列表
		List<News> newsList = newsHome.getNewsList(1, 0, 5, null);
		int newsTotal = newsHome.countGetNewsList(1, null);
		
		inv.addModel("newsList", newsList);
		inv.addModel("newsTotal", newsTotal);
		inv.addModel("productList", productList);
		inv.addModel("productToal", productToal);
		return RePageConstants.A_MAIN;
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@Get("/login/loginOut")
	@LoginRequired
	public String loginOut(){
		HttpSession session = inv.getRequest().getSession();
		session.removeAttribute(Constants.LOGIN_USER);
		return RePageConstants.LOGIN_PAGE;
	}
}
