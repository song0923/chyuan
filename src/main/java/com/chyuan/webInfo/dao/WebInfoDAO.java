package com.chyuan.webInfo.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import com.chyuan.webInfo.model.WebInfo;

@DAO
public interface WebInfoDAO {
	String TABLE_NAME = " web_info ";
	String FIELDS = " id,web_name_cn,website,web_keyword_cn,web_description_cn,address_cn,postcode,phone,fax,mobile,mail,linkman,icp_code,company,hotline,type ";
	
	@SQL(" select " + FIELDS + " from " + TABLE_NAME + " where type = :1 ")
	public WebInfo getWebInfo(Integer type);
	
	@SQL(" update " + TABLE_NAME + " set web_name_cn = :1.webNameCn, website = :1.website, web_keyword_cn = :1.webKeywordCn, web_description_cn = :1.webDescriptionCn, address_cn = :1.addressCn, postcode = :1.postcode, phone = :1.phone, fax = :1.fax, mobile = :1.mobile, mail = :1.mail, linkman = :1.linkman, icp_code = :1.icpCode, company = :1.company, hotline = :1.hotline where type = :1.type ")
	public void editWebInfo(WebInfo webInfo);
}
