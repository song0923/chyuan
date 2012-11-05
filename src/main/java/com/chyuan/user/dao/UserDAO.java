package com.chyuan.user.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import com.chyuan.user.model.User;

@DAO
public interface UserDAO {
	String TABLE_NAME = " user ";
	String FIELDS = " id,user_name,real_name,password ";

	@SQL("select " + FIELDS + " from " + TABLE_NAME + " where user_name = :1 and password = :2")
	public User findOneUser(String userName, String password);
}
