<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>404 - Not Found</title>
<style type="text/css">
body,html,p {
	margin: 0px;
	padding: 0px
}
/* Clear */
.clearfix:after {
	content: "";
	display: block;
	height: 0px;
	clear: both;
	visibility: hidden
}

.clearfix {
	display: inline-block
}
/* Hides from IE-mac \*/
* html .clearfix {
	height: 1%
}

.clearfix {
	display: block
}
/* End hide from IE-mac */
body {
	background: #e9e9e9 url(${domain}/images/404_bg.gif) center repeat-y;
	padding: 10px;
	color: #3e3e3e;
	font: 14px/1.5 "\5FAE\8F6F\96C5\9ED1", "\5B8B\4F53", Tahoma, Helvetica,
		Arial, sans-serif
}

#wrapper {
	border: 3px solid #ededed;
	background: #FFF;
	margin: 0px auto;
	width: 720px
}

#top {
	background: url(${domain}/images/nav_bg.gif);
	height: 70px
}

#logo {
	float: left;
	text-align: center;
	padding-top: 8px;
	width: 210px
}

#menu {
	float: right;
	font-size: 12px;
	padding: 32px 20px 0px 0px
}

#menu a:link,#menu a:visited,#menu a:active {
	color: #FFF;
	text-decoration: none
}

#menu a:hover {
	font-weight: bold
}

#contact {
	padding: 15px 15px 0px 15px
}

#contact p {
	margin-bottom: 15px
}

#contact span {
	color: #186bbf
}

.fun {
	color: #666;
	font-size: 12px;
	padding: 0px 20px
}

.fun a:link,.fun a:visited,.fun a:active {
	border: 1px dashed #FFF;
	border-bottom: 1px dashed #186bbf;
	color: #186bbf;
	text-decoration: none
}

.fun a:hover {
	border: 1px dashed #186bbf
}

#none404 {
	border: #CCC 1px dashed;
	text-align: center
}

#copyright {
	font-size: 12px;
	text-align: center;
	padding-bottom: 10px
}

#copyright a:link,#copyright a:visited,#copyright a:active {
	border: 1px dashed #FFF;
	border-bottom: 1px dashed #186bbf;
	color: #186bbf;
	text-decoration: none
}

#copyright a:hover {
	border: 1px dashed #186bbf
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="contact">
			<p>
				<b>尊敬的访客，您好:</b><br /> 您要找的资源已被删除、已更名或暂时不可用。( <span>HTTP 错误
					404 - Not Found</span> )
			</p>
			<p id="none404">
				<a href="/"><img src="${domain}/images/404.gif" alt="返回主页" width="350"
					height="120" border="0" /></a>
			</p>
			<b>最可能的原因:</b>
			<p class="fun">
				1、指定的目录或文件在 Web 服务器上不存在。<br /> 2、URL 拼写错误。<br /> 3、某个自定义筛选器或模块(如
				URLScan)限制了对该文件的访问。
			</p>
		</div>
		<div id="copyright">
			Copyright <a href="${domain}">${company}</a> 版权所有
		</div>
	</div>
</body>
</html>