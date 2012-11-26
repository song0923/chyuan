<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/include/a_common.jsp"%>
<script type="text/javascript">
	function check() {
		<c:if test="${titler eq '新增'}">
		if ($.trim($("#userName").val()) == "") {
			alert("请填写用户名");
			$("#userName").focus();
			return false
		}

		if ($.trim($("#password").val()) == "") {
			alert("请填写密码");
			$("#password").focus();
			return false
		}
		
		if ($.trim($("#repassword").val()) == "") {
			alert("请再次填写密码");
			$("#repassword").focus();
			return false
		}
		
		if ($.trim($("#password").val()) != $.trim($("#repassword").val())) {
			alert("两次密码填写不同");
			$("#password").val("");
			$("#repassword").val("");
			$("#password").focus();
			return false
		}
		</c:if>
		if ($.trim($("#realName").val()) == "") {
			alert("请填写真实姓名");
			$("#realName").focus();
			return false
		}
		return true;
	}
</script>

</head>
<body>
	<div id="cms_main">
		<div class="main_title">
			<span class="page_content">网站系统设置－网站管理员设置</span>
		</div>
		<div class="height5"></div>

		<table id="main_content">
			<tr>
				<td colspan="4" class="content_list">
					<ul class="edit_menu">
						<li><a href="javascript:history.back();" class="edit_manage"><strong>返回</strong>网站管理员设置</a></li>
					</ul>
				</td>
			</tr>
		</table>

		<div class="height5"></div>

		<div class="mc_title">
			<span class="mc_titlel">${titler}</span><span class="mc_titler"></span>
		</div>

		<form method="post" action="/admin/user/save" onsubmit="return check();">
			<input type="hidden" name="id" value="${user.id}" />
			<table class="mc_table">
				<tr>
					<td width="100" class="mc_table_title">用户名</td>
					<td>
						<ul class="list_input">
							<li class="input_l"></li>
							<li class="input_mc">
								<input name="userName" type="text" id="userName" value="${user.userName}" <c:if test="${titler eq '编辑'}">disabled="disabled"</c:if>/>
							</li>
							<li class="input_r"></li>
							<li class="input_ltext"><span>*</span>必填</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="mc_table_title">密 码</td>
					<td>
						<ul class="list_input">
							<li class="input_l"></li>
							<li class="input_mc">
								<input name="password" type="password" id="password" <c:if test="${titler eq '编辑'}">disabled="disabled"</c:if>/>
							</li>
							<li class="input_r"></li>
							<li class="input_ltext"><span>*</span>必填</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="mc_table_title">重复密码</td>
					<td>
						<ul class="list_input">
							<li class="input_l"></li>
							<li class="input_mc">
								<input name="repassword" type="password" id="repassword" <c:if test="${titler eq '编辑'}">disabled="disabled"</c:if>/>
							</li>
							<li class="input_r"></li>
							<li class="input_ltext"><span>*</span>必填</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="mc_table_title">真实姓名</td>
					<td>
						<ul class="list_input">
							<li class="input_l"></li>
							<li class="input_mc">
								<input name="realName" type="text" id="realName" value="${user.realName}"/>
							</li>
							<li class="input_r"></li>
							<li class="input_ltext"><span>*</span>必填</li>
						</ul>
					</td>
				</tr>
			</table>
			<div class="mc_submit">
				<input type="image" name="imageField" id="imageField" src="${domain}/images/submit.gif" />
			</div>
		</form>
	</div>
</body>
</html>