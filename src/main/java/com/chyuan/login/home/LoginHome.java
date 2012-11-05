package com.chyuan.login.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.chyuan.user.dao.UserDAO;
import com.chyuan.user.model.User;
import com.chyuan.utils.Md5;

@Component
public class LoginHome {
	@Autowired
	private UserDAO userDao;
	
	/**
	 * 根据用户名密码验证用户是否存在
	 * @param userName
	 * @param password
	 * @return
	 */
	public User checkUser(String userName, String password){
		return userDao.findOneUser(userName, Md5.md5s(password));
	}
}
