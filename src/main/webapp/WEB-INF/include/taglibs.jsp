<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<c:set var="app" scope="page"
	value="${pageContext.request.contextPath}" />
<c:set var="serverName" scope="page"
	value="${pageContext.request.serverName}" />
<c:set var="serverPort" scope="page"
	value="${pageContext.request.serverPort}" />
<c:set var="webUrl" scope="page"
	value="${pageContext.request.requestURL}" />
