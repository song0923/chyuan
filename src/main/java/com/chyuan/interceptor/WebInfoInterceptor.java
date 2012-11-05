package com.chyuan.interceptor;

import javax.servlet.ServletContext;
import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.chyuan.language.LanguageResouces;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Utils;
import com.chyuan.webInfo.model.WebInfo;

/**
 * 第一次访问网站时，从数据库加载网站信息
 * @author song
 *
 */
@Component
@Interceptor(oncePerRequest = true)
public class WebInfoInterceptor extends ControllerInterceptorAdapter {
	@Autowired
	private Utils utils;
	
	@Override
    public Object before(Invocation inv) throws Exception {
		ServletContext context = inv.getServletContext();
		WebInfo webInfo = (WebInfo)context.getAttribute("webInfo");
		LanguageResouces resouces = (LanguageResouces)context.getAttribute("resouces");
		if(null == webInfo || null == resouces){
			utils.systemConfig(Constants.LANGUAGE_CN, context);
		}
        return true;
    }
}
