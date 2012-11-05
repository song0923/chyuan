<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/include/a_common.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
		var msg = "${aboutUs_msg}";
		if(msg != ""){
			alert(msg);
		}
	});
</script>
</head>
<body>
	<div id="cms_main">
		<div class="main_title">
			<span class="page_content"> 中文内容管理－关于我们</span>
		</div>
		<div class="height5"></div>
		<div class="mc_title">
			<span class="mc_titlel">编辑【关于我们】</span><span class="mc_titler"></span>
		</div>

		<form id="frmDemo" name="edit" method="post" action="/admin/aboutUs/edit/${aboutUs.id}">
			<table class="mc_table">
				<tr>
					<td><textarea id="Content" name="content" rows="20" cols="80"
							style="width: 100%">${aboutUs.content}</textarea></td>
				</tr>
			</table>
			<div class="mc_submit">
				<input type="image" name="imageField" id="imageField"
					src="${domain}/images/submit.gif"/>
			</div>
		</form>
	</div>
</body>
</html>