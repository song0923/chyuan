<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/include/a_common.jsp"%>
<script type="text/javascript">
	function check() {
		if ($.trim($("#title").val()) == ""){
			alert("请填写标题名称");
			$("#title").val("");
			$("#title").focus();
			return false;
		}
		return true;
	}
</script>

</head>
<body>
	<div id="cms_main">
		<div class="main_title">
			<span class="page_content"> 中文内容管理－新闻中心</span>
		</div>
		<div class="height5"></div>

		<table id="main_content">
			<tr>
				<td colspan="4" class="content_list">
					<ul class="edit_menu">
						<li><a href="javascript:history.back();" class="edit_manage"><strong>返回</strong>新闻中心</a></li>
					</ul>
				</td>
			</tr>
		</table>

		<div class="height5"></div>

		<div class="mc_title">
			<span class="mc_titlel">${titler}</span><span class="mc_titler"></span>
		</div>

		<form method="post" action="/admin/news/save" onsubmit="return check();">
			<input type="hidden" name="id" value="${news.id}"/>
			<input type="hidden" name="type" value="${type}"/>
			<table class="mc_table">
				<tr>
					<td width="60" class="mc_table_title">标题名称</td>
					<td>
						<ul class="list_input">
							<li class="input_l"></li>
							<li class="input_ma"><input name="title" type="text" id="title" value="${news.title}"/></li>
							<li class="input_r"></li>
						</ul>
					</td>
				</tr>
				<tr>
					<td colspan="2"><textarea id="Content" name="content"
							rows="24" cols="80" style="width: 100%">${news.content}</textarea></td>
				</tr>
			</table>
			<div class="mc_submit">
				<input type="image" name="imageField" id="imageField" src="${domain}/images/submit.gif"/>
			</div>
		</form>
	</div>
</body>
</html>