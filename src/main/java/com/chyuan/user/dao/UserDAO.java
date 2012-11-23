package com.chyuan.user.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.chyuan.user.model.User;
import com.chyuan.utils.Constants;

@DAO
public interface UserDAO {
	String TABLE_NAME = " user ";
	String FIELDS = " id,user_name,real_name,password,is_delete ";

	@SQL("select " + FIELDS + " from " + TABLE_NAME + " where user_name = :1 and password = :2 and is_delete = " + Constants.IS_DELETE_NO)
	public User findOneUser(String userName, String password);
	
	@SQL("select " + FIELDS + " from " + TABLE_NAME + " where is_delete = " + Constants.IS_DELETE_NO + " and id <> 1 order by id desc limit :1 , :2 ")
	public List<User> getUserList(int start, int pageSize);
	
	@SQL("select count(1) from " + TABLE_NAME + " where is_delete = " + Constants.IS_DELETE_NO + " and id <> 1 ")
	public int countGetUserList();
}
