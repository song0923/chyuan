<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="g" uri="/WEB-INF/tags-core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/include/a_common.jsp"%>
<script>
	function del(id, type){
		if(confirm('确认删除？')){
			location.href = "/admin/product/delete/" + id + "/" + type;
		}
	}
</script>
</head>
<body>
	<div id="cms_main">
		<div class="main_title">
			<span class="page_content"> 中文内容管理－产品展示</span>
		</div>
		<div class="height5"></div>

		<table id="main_content">
			<tr>
				<td colspan="5" class="content_list">
					<ul class="edit_menu">
						<li><a href="/admin/product/add/${type}" class="edit_add">添加产品展示</a></li>
					</ul>
				</td>
			</tr>
			<tr class="content_title">
				<td width="115">序号</td>
				<td width="150">添加日期</td>
				<td>标题名称</td>
				<td width="140" style="background-image: none;">操作</td>
			</tr>
			<c:choose>
				<c:when test="${not empty productList}">
					<c:forEach items="${productList}" var="product">
						<tr class="content_list"
							onmouseover="this.style.backgroundColor='#D3E1F6'"
							onmouseout="this.style.backgroundColor=''">
							<td>${product.id}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
									value="${product.createTime}" /></td>
							<td>${product.title}</td>
							<td style="background-image: none;">
								<a href="/admin/product/edit/${product.id}/${type}"><img
									src="${domain}/images/info_edit.gif"/></a>|
								<a href="javascript:void(0);" onclick="del('${product.id}', '${type}');">
									<img src="${domain}/images/info_del.gif"/></a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr class="content_list"
							onmouseover="this.style.backgroundColor='#D3E1F6'"
							onmouseout="this.style.backgroundColor=''">
						<td colspan="4"><center>暂无产品</center></td></tr>
				</c:otherwise>
			</c:choose>
		</table>

		<div class="page_list">
			<div class="list_info">
				<g:pager curPage="${page.curPage}" total="${page.total}"
					pageSize="${page.pageSize}" forwardUrl="" />
			</div>
		</div>
	</div>
</body>
</html>