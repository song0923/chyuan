package com.chyuan.webInfo.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import com.chyuan.webInfo.model.WebInfo;

@DAO
public interface WebInfoDAO {
	String TABLE_NAME = " web_info ";
	String FIELDS = " id,web_name,website,web_keyword,web_description,address,postcode,phone,fax,mobile,mail,linkman,icp_code,company,hotline,type ";
	
	@SQL(" select " + FIELDS + " from " + TABLE_NAME + " where type = :1 ")
	public WebInfo getWebInfo(Integer type);
	
	@SQL(" update " + TABLE_NAME + " set web_name = :1.webName, website = :1.website, web_keyword = :1.webKeyword, web_description = :1.webDescription, address = :1.address, postcode = :1.postcode, phone = :1.phone, fax = :1.fax, mobile = :1.mobile, mail = :1.mail, linkman = :1.linkman, icp_code = :1.icpCode, company = :1.company, hotline = :1.hotline where type = :1.type ")
	public void editWebInfo(WebInfo webInfo);
}
