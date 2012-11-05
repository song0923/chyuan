<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/include/a_common.jsp"%>
<script>
	function delNews(id, type){
		if(confirm('确认删除？')){
			location.href = "/admin/news/delete/" + id + "/" + type;
		}
	}
	
	function delProduct(id, type){
		if(confirm('确认删除？')){
			location.href = "/admin/product/delete/" + id + "/" + type;
		}
	}
</script>
</head>
<body>
	<div id="cms_main">
		<div>
			<div id="include-weather">
				<center>
					<iframe src="http://m.weather.com.cn/m/pn11/weather.htm"
						width="95%" height="50" marginwidth="0" marginheight="0"
						frameborder="0" scrolling="no"></iframe>
				</center>
			</div>
			<div class="main_Lbox" id="sys-guestbook">
				<h3>最新留言</h3>
				<ul>
					<li><center>暂无留言</center></li>
				</ul>
			</div>
			<div class="main_Lbox" id="sys-pro">
				<h3>
					<a href="/admin/product/add/1" title="产品展示"><span>添加</span></a>产品展示<span>共<em>${productTotal}</em>条
					</span>
				</h3>
				<ul>
					<c:choose>
						<c:when test="${not empty productList}">
							<c:forEach items="${productList}" var="product">
								<li onmouseover="this.style.backgroundColor='#eff5ff'" onmouseout="this.style.backgroundColor=''">
									<span style="float: right"><a
										href="/admin/product/edit/${product.id}/${product.type}">
										<img src="${domain}/images/info_edit.gif"/></a>
										<a href="javascript:void(0);" onclick="delProduct('${product.id}', '${product.type}');">
										<img src="${domain}/images/info_del.gif"/></a></span>
									<span style="color: #666">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${product.createTime}" />
									&nbsp;&nbsp;</span>${product.title}</li>
							</c:forEach>
						</c:when>
						<c:otherwise><li><center>暂无产品</center></li></c:otherwise>
					</c:choose>
				</ul>
			</div>
			<div class="main_Lbox" id="sys-news">
				<h3>
					<a href="/admin/news/add/1" title="新闻中心"><span>添加</span></a>新闻中心<span>共<em>${newsTotal}</em>条
					</span>
				</h3>
				<ul>
					<c:choose>
						<c:when test="${not empty newsList}">
							<c:forEach items="${newsList}" var="news">
								<li onmouseover="this.style.backgroundColor='#eff5ff'"
									onmouseout="this.style.backgroundColor=''">
									<span style="float: right">
									<a href="/admin/news/edit/${news.id}/${news.type}"><img src="${domain}/images/info_edit.gif"/></a>
									<a href="javascript:void(0);" onclick="delNews('${news.id}', '${news.type}');">
										<img src="${domain}/images/info_del.gif"/></a></span>
									<span style="color: #666">
										&nbsp;<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${news.createTime}" />&nbsp;&nbsp;
									</span>
									${news.title}
								</li>
							</c:forEach>
						</c:when>
						<c:otherwise><li><center>暂无新闻</center></li></c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>