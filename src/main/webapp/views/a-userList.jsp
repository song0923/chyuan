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
	function del(id){
		if(confirm('确认删除？')){
			location.href = "/admin/user/delete/" + id;
		}
	}
</script>
</head>
<body>
	<div id="cms_main">
		<div class="main_title">
			<span class="sys_admin">网站系统设置－网站管理员设置</span>
		</div>
		<div class="height5"></div>

		<table id="main_content">
			<tr>
				<td colspan="5" class="content_list">
					<ul class="edit_menu">
						<li><a href="/admin/user/add" class="edit_add">添加管理员</a></li>
					</ul>
				</td>
			</tr>
			<tr class="content_title">
				<td width="115">序号</td>
				<td width="150">添加日期</td>
				<td>用户名</td>
				<td>真实姓名</td>
				<td width="140" style="background-image: none;">操作</td>
			</tr>
			<c:choose>
				<c:when test="${not empty userList}">
					<c:forEach items="${userList}" var="user">
						<tr class="content_list"
							onmouseover="this.style.backgroundColor='#D3E1F6'"
							onmouseout="this.style.backgroundColor=''">
							<td>${user.id}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${user.createTime}" /></td>
							<td>${user.userName}</td>
							<td>${user.realName}</td>
							<td style="background-image: none;">
								<a href="/admin/user/edit/${user.id}">
									<img src="${domain}/images/info_edit.gif"/></a>|
								<a href="javascript:void(0);" onclick="del('${user.id}');">
									<img src="${domain}/images/info_del.gif"/></a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr class="content_list"
							onmouseover="this.style.backgroundColor='#D3E1F6'"
							onmouseout="this.style.backgroundColor=''">
						<td colspan="5"><center>暂无信息</center></td></tr>
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