package com.chyuan.user.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chyuan.user.dao.UserDAO;
import com.chyuan.user.model.User;

@Component
public class UserHome {
	@Autowired
	private UserDAO userDao;
	
	/**
	 * 获取用户分页信息
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<User> getUserList(int start, int pageSize){
		return userDao.getUserList(start, pageSize);
	}
	
	/**
	 * 获取用户总数
	 * @return
	 */
	public int countGetUserList(){
		return userDao.countGetUserList();
	}
}
