package com.chyuan.user.controllers;

import java.util.List;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.interceptor.LoginRequired;
import com.chyuan.user.home.UserHome;
import com.chyuan.user.model.User;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Page;
import com.chyuan.utils.RePageConstants;
/**
 * 后台控制器：管理员管理
 * @author song.zhang@boco.jp
 *
 */
@Path("/admin/user")
public class UserAdminController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private UserHome userHome;
	
	/**
	 * 跳转到用户列表页
	 * @return
	 */
	@Get("/list")
	@LoginRequired
	public String list(){
		int pageIndex = inv.getParameter("page") != null ? Integer.parseInt(inv.getParameter("page")) : 1;
		int total = userHome.countGetUserList();
		int start = (pageIndex - 1) * Constants.PAGE_SIZE;
		List<User> userList = userHome.getUserList(start, Constants.PAGE_SIZE);
		Page<User> page = new Page<User>(total, Constants.PAGE_SIZE, pageIndex, userList);
		inv.addModel("userList", userList);
		inv.addModel("page", page);
		return RePageConstants.A_USER_List;
	}
}
