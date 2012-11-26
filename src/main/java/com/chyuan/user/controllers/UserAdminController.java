package com.chyuan.user.controllers;

import java.util.List;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

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
@LoginRequired
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
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@Get("/add")
	public String userPageAdd(){
		inv.addModel("titler", Constants.TITLER_ADD);
		return RePageConstants.A_USER;
	}
	
	/**
	 * 跳转到编辑页面
	 * @param id
	 * @return
	 */
	@Get("/edit/{id}")
	public String userPageEdit(@Param("id")Long id){
		User user = userHome.findUserById(id);
		inv.addModel("user", user);
		inv.addModel("titler", Constants.TITLER_EDIT);
		return RePageConstants.A_USER;
	}
	
	/**
	 * 保存管理员
	 * @param user
	 * @return
	 */
	@Post("/save")
	public String userSave(User user){
		userHome.saveUser(user);
		String msg = "管理员保存成功！";
		return "@<script>alert(\"" + msg + "\");location.href=\"/admin/user/list\";</script>";
	}
	
	/**
	 * 删除管理员
	 * @param id
	 * @return
	 */
	@Get("/delete/{id}")
	public String deleteUser(@Param("id")Long id){
		userHome.deleteUser(id);
		return "@<script>alert(\"管理员删除成功！\");location.href=\"/admin/user/list\";</script>";
	}
}
