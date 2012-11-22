<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 中英语言切换 --%>
<div class="top">
	<img src="${domain}/${language}/images/logo.jpg" width="650" height="90"
		alt="${company}" />
	<%-- <c:if test="${language == 'cn'}">
		<div id="lang"><a href="${domain}/en/index"><img src="/en/images/gb.gif" width="16" height="11"/>${resouces.language}</a></div>
	</c:if>
	<c:if test="${language == 'en'}">
		<div id="lang"><a href="${domain}/cn/index"><img src="/cn/images/cn.gif" width="16" height="11"/>${resouces.language}</a></div>
	</c:if> --%>
</div>

<div id="MainMenu" class="ddsmoothmenu">
	<ul>
		<li><a href="${domain}/${language}/index" title="${resouces.homePage}" id="menu_li_homePage"><span>${resouces.homePage}</span></a></li>
		<li><a href="${domain}/product/list/${langType}" title="${resouces.product}" id="menu_li_product"><span>${resouces.product}</span></a>
		</li>
		<li><a href="${domain}/news/list/${langType}" title="${resouces.newsCenter}" id="menu_li_newsCenter"><span>${resouces.newsCenter}</span></a></li>
		<li><a href="${domain}/jobs/list/${langType}" title="${resouces.jobs}" id="menu_li_jobs"><span>${resouces.jobs}</span></a></li>
		<li><a href="${domain}/aboutUs/1" title="${resouces.aboutUs}" id="menu_li_aboutUs"><span>${resouces.aboutUs}</span></a>
			<%-- <ul class="menulevel">
				<li><a href="${domain}/single.asp?menuid=13">销售网络</a></li>
				<li><a href="${domain}/single.asp?menuid=14">组织结构</a></li>
				<li><a href="${domain}/single.asp?menuid=15">联系我们</a></li>
			</ul> --%>
		</li>
		<%-- <li><a href="${domain}/guestbook.asp"><span>留言反馈</span></a></li> --%>
	</ul>

</div>

<script type="text/javascript">
	jQuery(document).ready(function() {
		ddsmoothmenu.init({
			mainmenuid : "MainMenu", //menu DIV id
			orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
			classname : 'ddsmoothmenu', //class added to menu's outer DIV
			//customtheme: ["#1c5a80", "#18374a"],
			contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
		})
	})
</script>