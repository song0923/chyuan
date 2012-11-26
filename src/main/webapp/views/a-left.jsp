<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/include/a_common.jsp"%>
<script language="javascript" type="text/javascript">
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};

	$(function() {
		$(".menu_text a").click(function() {
			$(".menu_text a").removeClass("mousehover")
			$(this).addClass("mousehover")
		})
	});
</script>
</head>
<body>
	<div id="my_menu" class="sdmenu">
      <div>
        <span><a href="#notop">中文内容管理</a></span>
        <ul class="menu_text"><li>
        <a href="${domain}/admin/aboutUs/editPage/1" target="mainFrame">关于我们</a>
        <a href="${domain}/admin/product/list/1" target="mainFrame">产品展示</a>
        <a href="${domain}/admin/news/list/1" target="mainFrame">新闻中心</a>
        <a href="${domain}/admin/jobs/list/1" target="mainFrame">招聘信息</a>
        </li></ul>
      </div>
      <p class="menu_bottom">&nbsp;</p>
      <!-- <div>
        <span><a href="#notop">英文内容管理</a></span>
        <ul class="menu_text"><li>
        <a href="Single_edit.asp?menuid=16" target="mainFrame">About US</a>
        <a href="Products_list.asp?menuid=17" target="mainFrame">Products</a>
        <a href="News_list.asp?menuid=18" target="mainFrame">News</a>
        <a href="News_list.asp?menuid=19" target="mainFrame">Jobs</a>
        </li></ul>
      </div>
      <p class="menu_bottom">&nbsp;</p> -->
      <!-- <div>
        <span><a href="#notop">互动信息管理</a></span>
        <ul class="menu_text">
        	<li>
        		<a href="GuestBook_list.asp" target="mainFrame">网站留言管理</a>
				<a href="SysChat_set.asp?langid=1" target="mainFrame">在线客服设置</a>
        </li></ul>
      </div> -->
      <p class="menu_bottom">&nbsp;</p>
      <div>
        <span><a href="#notop">网站系统设置</a></span>
        <ul class="menu_text">
        	<li>
				<a href="${domain}/admin/webInfo/editPage/1" target="mainFrame">网站信息设置</a>
				<c:if test="${sessionUser.userName eq 'admin'}">
	        		<a href="${domain}/admin/user/list" target="mainFrame">网站管理员设置</a>
	        	</c:if>
        	</li>
        </ul>
      </div>
      <p class="menu_bottom">&nbsp;</p>
    </div>

</body>
</html>