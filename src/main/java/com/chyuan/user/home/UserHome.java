package com.chyuan.user.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chyuan.user.dao.UserDAO;
import com.chyuan.user.model.User;
import com.chyuan.utils.Md5;

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
	
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	public User findUserById(Long id){
		return userDao.findUserById(id);
	}
	
	/**
	 * 保存用户
	 * @param user
	 */
	public void saveUser(User user){
		if(null == user.getId()){
			user.setPassword(Md5.md5s(user.getPassword()));
			userDao.insertUser(user);
		}else{
			userDao.editUser(user);
		}
	}
	
	/**
	 * 删除用户
	 * @param id
	 */
	public void deleteUser(Long id){
		userDao.deleteUser(id);
	}
}
