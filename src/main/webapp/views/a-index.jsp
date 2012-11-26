<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<frameset rows="105,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="/views/a-top.jsp"
		name="topFrame" scrolling="No" noresize="noresize" id="topFrame"
		title="topFrame" marginwidth="0" marginheight="0" />
	<frameset cols="199,*" frameborder="0" border="false" framespacing="0" id="frame">
		<frame src="/views/a-left.jsp" name="leftFrame" scrolling="yes"
			noresize="noresize" id="leftFrame" title="leftFrame" marginwidth="0"
			marginheight="0" />
		<frame src="/admin/login/main" name="mainFrame"
			scrolling="yes" noresize="noresize" id="mainFrame" title="mainFrame"
			marginwidth="0" marginheight="0" />
	</frameset>
</frameset>
<noframes>
	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<p align="center">此网页使用了框架，但您的浏览器不支持框架。</p>
	</body>
</noframes>
</html>