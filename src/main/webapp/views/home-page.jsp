<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${company}</title>
<%@include file="/WEB-INF/include/keyword.jsp"%>
<%@include file="/WEB-INF/include/common.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#menu_li_homePage").attr("class", "menu_selected");
		
		<!--//--><![CDATA[//><!--
		var scrollPic_01 = new ScrollPic();
		scrollPic_01.scrollContId   = "ScrollBox"; //内容容器ID
		scrollPic_01.arrLeftId      = "LeftArr1";//左箭头ID
		scrollPic_01.arrRightId     = "RightArr1"; //右箭头ID
		scrollPic_01.frameWidth     = 648;//显示框宽度
		scrollPic_01.pageWidth      = 162; //翻页宽度
		scrollPic_01.speed          = 10; //移动速度(单位毫秒，越小越快)
		scrollPic_01.space          = 5; //每次移动像素(单位px，越大越快)
		scrollPic_01.autoPlay       = true; //自动播放
		scrollPic_01.autoPlayTime   = 5; //自动播放间隔时间(秒)
		scrollPic_01.initialize(); //初始化
		//--><!]]>
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
					<div class="productsroll">
						<div id="LeftArr1" class="ScorllLeft1"></div>
          				<div id="RightArr1" class="ScorllRight1"></div>
						<ul id="ScrollBox" class="clearfix">
							<c:choose>
								<c:when test="${not empty productList}">
									<c:forEach items="${productList}" var="product">
										<li>
											<a href="${domain}/product/detail/${product.id}" title="${product.title}">
												<img src="${domain}${product.thumbnail}" alt="${product.title}" width="142" height="102" />
												<span>${product.title}</span>
											</a>
										</li>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<li>
										<a href="javascript:void(0);" title="暂无产品">
											<img src="" alt="暂无产品" width="142" height="102" />
											<span>暂无产品</span>
										</a>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
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