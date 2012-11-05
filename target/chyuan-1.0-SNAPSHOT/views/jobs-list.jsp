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
		$("#menu_li_jobs").attr("class", "menu_selected");
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
						href="${domain}/jobs/list/${langType}">${resouces.jobs}</a>
				</div>

				<div class="page-jobs">
					<table border="0" align="center">
						<tr><th class="jobs-time">${resouces.jobsTime}</th><th class="jobs-title">${resouces.jobsTitle}</th></tr>
						<c:choose>
							<c:when test="${not empty productList}">
								<c:forEach items="${jobsList}" var="jobs">
									<tr>
										<td class="time-list">
											<span><fmt:formatDate pattern="yyyy-MM-dd" value="${jobs.createTime}"/></span>
										</td>
										<td>
											<a href="${domain}/jobs/detail/${jobs.id}" title="${jobs.title}">${jobs.title}</a>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise><tr><td align="center" colspan="2">暂无数据</td></tr></c:otherwise>
						</c:choose>
					</table>
					
					<div class="page_list">
						<div class="list_info">
							<g:pager curPage="${page.curPage}" total="${page.total}" pageSize="${page.pageSize}" forwardUrl="" />
						</div>
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