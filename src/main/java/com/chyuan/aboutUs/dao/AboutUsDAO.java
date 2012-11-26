package com.chyuan.aboutUs.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import com.chyuan.aboutUs.model.AboutUs;

@DAO
public interface AboutUsDAO {

	String TABLENAME = " about_us ";
	String FIELDS = " id,content,type ";
	
	@SQL("select " + FIELDS + " from " + TABLENAME + " where id = :1")
	public AboutUs getAboutUsById(Long id);
	
	@SQL("select " + FIELDS + " from " + TABLENAME + " where type = :1")
	public AboutUs getAboutUsByType(Integer type);
	
	@SQL(" update " + TABLENAME + " set content = :1.content where id = :2 ")
	public void editAboutUs(AboutUs aboutUs, Long id);
}
