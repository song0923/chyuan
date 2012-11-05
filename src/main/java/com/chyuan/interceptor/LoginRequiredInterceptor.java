package com.chyuan.interceptor;

import java.lang.annotation.Annotation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Interceptor;
import org.springframework.stereotype.Component;

@Component
@Interceptor(oncePerRequest = true)
public class LoginRequiredInterceptor extends ControllerInterceptorAdapter {
	@Override
	public Class<? extends Annotation> getRequiredAnnotationClass() {
		return LoginRequired.class;
	}

	@Override
	public Object before(Invocation inv) throws Exception {
		HttpServletRequest request = inv.getRequest();
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
			// 如果没有登录，重定向到登录页面
			return "@<script>top.location.href=\"/admin\";</script>";
		}
		return true;
	}
}
