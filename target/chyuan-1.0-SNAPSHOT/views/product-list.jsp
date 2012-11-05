<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="g" uri="/WEB-INF/tags-core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/include/common.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#menu_li_product").attr("class", "menu_selected");
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
						href="${domain}/product/list/${langType}">${resouces.product}</a>
				</div>
				
				<div class="page-products">
					<ul class="clearfix">
						<c:choose>
							<c:when test="${not empty productList}">
								<c:forEach items="${productList}" var="product">
									<li><a href="${domain}/product/detail/${product.id}" title="${product.title}">
										<img src="${domain}${product.thumbnail}" width="210" height="150" alt="${product.title}" />
										<span>${product.title}</span></a></li>
								</c:forEach>
							</c:when>
							<c:otherwise><span align="center">暂无产品</span></c:otherwise>
						</c:choose>
					</ul>
				</div>
				
				<div class="page_list">
					<div class="list_info">
						<g:pager curPage="${page.curPage}" total="${page.total}" pageSize="${page.pageSize}" forwardUrl="" />
					</div>
				</div>
			</div>

			<div class="page-left">
				<%@include file="/WEB-INF/include/search.jsp"%>

				<%@include file="/WEB-INF/include/contact.jsp"%>
			</div>
		</div>

		<%@include file="/WEB-INF/include/bottom.jsp"%>
	</div>
</body>
</html>