<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/include/common.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#menu_li_homePage").attr("class", "menu_selected");
		
		$(".productshow").Xslider({
			unitdisplayed:4,//可视的单位个数   必需项;
			numtoMove:1,//该参数是必需项。指定每次移动最小单元的个数
			//movelength:1,//要移动的单位个数    必需项;
			maxlength:null,//可视宽度或高度    默认查找要移动对象外层的宽或高度;
			unitlen:null,//移动的单位宽或高度     默认查找li的尺寸;
			nowlength:null,//移动最长宽或高（要移动对象的宽度或高度）   默认由li个数乘以unitlen所得的积;
			dir:"H",//水平移动还是垂直移动，默认H为水平移动，传入V或其他字符则表示垂直移动;
			autoscroll:2000//自动移动间隔时间     默认null不自动移动;
		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<%@include file="/WEB-INF/include/menu.jsp"%>

		<%@include file="/WEB-INF/include/banner.jsp"%>

		<div id="index_main" class="clearfix">
			<div class="index-left">
				<div class="index-products">
					<h2>
						<a href="${domain}/product/list/${langType}">
							<img src="${domain}/${language}/images/more.gif" width="32" height="5"/>
						</a>
					</h2>
					<div class="productshow">
						<div class="scrollcontainer">
							<ul>
								<c:choose>
									<c:when test="${not empty productList}">
										<c:forEach items="${productList}" var="product">
											<li>
												<div><a href="${domain}/product/detail/${product.id}" title="${product.title}">
													<img src="${domain}${product.thumbnail}" alt="${product.title}" width="150" height="95" />
												</a></div>
												<p>
													<a href="${domain}/product/detail/${product.id}" title="${product.title}">${product.title}</a>
												</p>
											</li>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<li></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
						<a class="abtn aleft" href="#left">左移</a>
						<a class="abtn aright" href="#right">右移</a>
					</div>
				</div>

				<div class="index-news">
					<h2>
						<a href="${domain}/news/list/${langType}">
							<img src="${domain}/${language}/images/more.gif" width="32" height="5"/>
						</a>
					</h2>
					<ul>
						<c:forEach items="${newsList}" var="news">
							<li><a href="${domain}/news/detail/${news.id}" title="${news.title}">
								<span><fmt:formatDate pattern="yyyy-MM-dd" value="${news.createTime}"/></span>${fn:substring(news.title, 0, 15)}</a>
							</li>
						</c:forEach>
					</ul>
				</div>

				<div class="index-about">
					<h2>
						<span>${resouces.aboutUs}</span><a href="${domain}/aboutUs/1"><img
							src="${domain}/${language}/images/more.gif" width="32" height="5" alt="${resouces.aboutUs}" /></a>
					</h2>
					<p>
						<img src="${domain}/${language}/images/index_AboutPic.jpg" alt="${resouces.aboutUs}" width="145"
							height="181" /><a href="${domain}/aboutUs/1" title="${resouces.aboutUs}"id="p-content">
							<script>
								var content = '${aboutUs.content}';
								$("#p-content").html(content);
								var con = $("#p-content").text().substring(0, 120);
								$("#p-content").html(con + "......");
							</script>
						</a>
					</p>
				</div>
			</div>

			<div class="index-right">
				<%@include file="/WEB-INF/include/search.jsp"%>

				<div class="index-jobs">
					<h2>
						<a href="${domain}/jobs/list/${langType}"><img
							src="${domain}/${language}/images/more.gif" width="32" height="5"/></a>
					</h2>
					<ul>
						<c:forEach items="${jobsList}" var="jobs">
							<li><a href="${domain}/jobs/detail/${jobs.id}" title="${jobs.title}"><span>
									- ${jobs.title}</span></a></li>
						</c:forEach>
					</ul>
				</div>

				<%@include file="/WEB-INF/include/contact.jsp"%>
			</div>
		</div>

		<%@include file="/WEB-INF/include/bottom.jsp"%>
	</div>
</body>
</html>