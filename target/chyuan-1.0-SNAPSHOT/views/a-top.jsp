<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/include/a_common.jsp"%>
</head>
<body>
	<div id="cms_top">
		<div class="top_logo">
			<img src="${domain}/images/logo.jpg" alt="" />
		</div>
		<div class="top_nav">
			<div class="top_admin" id="close_left">
				<img src="${domain}/images/top_close.gif" alt="关闭左边管理菜单"
					onclick="switchBar(this)" /><span>您好：<b>${user.realName}</b></span>
			</div>
			<div class="top_menu">
				<a href="${domain}/admin/main" target="mainFrame" class="menu_main"><span>后台主页</span></a><a
					href="${domain}/index" class="menu_view" target="_blank"><span>点击预览网站</span></a>
			</div>
			<div class="menu_exit">
				<a href="${domain}/admin/loginOut" target="_top"><span>退出系统</span></a>
			</div>
		</div>
	</div>
</body>
</html>