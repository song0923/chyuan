package com.chyuan.utils;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.chyuan.language.LanguageResouces;
import com.chyuan.webInfo.home.WebInfoHome;
import com.chyuan.webInfo.model.WebInfo;

@Component
public class Utils {
	private static LanguageResouces resouces;
	@Autowired
	private WebInfoHome webInfoHome;

	/**
	 * 给context里面设置网站基本信息
	 * @param webInfo
	 * @param context
	 */
	public void systemConfig(String language, ServletContext context){
		resouces = LanguageResouces.getResoucesInstance(language);
		Integer type = language.equals(Constants.LANGUAGE_EN) ? 2 : 1;
		WebInfo webInfo = webInfoHome.getWebInfo(type);
		
		context.setAttribute("resouces", resouces);
		context.setAttribute("webInfo", webInfo);
		
		context.setAttribute("domain", webInfo.getWebsite());
		context.setAttribute("company", webInfo.getCompany());
		context.setAttribute("address", webInfo.getAddress());
		context.setAttribute("hotline", webInfo.getHotline());
		context.setAttribute("fax", webInfo.getFax());
		context.setAttribute("mail", webInfo.getMail());
		context.setAttribute("postcode", webInfo.getPostcode());
		context.setAttribute("language", language);
		context.setAttribute("langType", webInfo.getType());
		context.setAttribute("webKeyword", webInfo.getWebKeyword());
		context.setAttribute("webDescription", webInfo.getWebDescription());
	}
}
