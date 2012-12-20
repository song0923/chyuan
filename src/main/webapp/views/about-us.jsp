<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>关于我们 - ${company}</title>
<%@include file="/WEB-INF/include/keyword.jsp"%>
<%@include file="/WEB-INF/include/common.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#menu_li_aboutUs").attr("class", "menu_selected");
	});
</script>
</head>
<body>
	<div id="wrapper">
		<%@include file="/WEB-INF/include/menu.jsp"%>

		<%@include file="/WEB-INF/include/banner.jsp"%>

		<div id="page_main" class="clearfix">
			<div class="page-right">
				<div class="site-nav">
					<span>${resouces.location}</span><a href="${domain}/${language}/index">${resouces.homePage}</a> &gt;&gt; <a
						href="${domain}/aboutUs/1">${resouces.aboutUs}</a>
				</div>

				<div class="page-single">
					<p style="LINE-HEIGHT: 25px">
						${aboutUs.content}
					</p>
				</div>
			</div>

			<div class="page-left">
				<%@include file="/WEB-INF/include/left-about.jsp"%>

				<%@include file="/WEB-INF/include/search.jsp"%>

				<%@include file="/WEB-INF/include/contact.jsp"%>
			</div>
		</div>

		<%@include file="/WEB-INF/include/bottom.jsp"%>
	</div>
</body>
</html>