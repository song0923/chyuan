<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${domain}/css/reset.css" rel="stylesheet" type="text/css" />
<link href="${domain}/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${domain}/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
	function onkey(e) {
		if (window.event) { // IE
			keynum = e.keyCode;
		} else if (e.which) { // Netscape/Firefox/Opera
			keynum = e.which;
		}
		if (keynum == 13) {
			check();
		}
	}

	function check() {
		if (document.login.userName.value == "") {
			alert("请填写用户名");
			document.login.userName.focus();
			return false;
		}
		if (document.login.password.value == "") {
			alert("请填写密码");
			document.login.password.focus();
			return false;
		}
		if (document.login.checkCode.value == "") {
			alert("请填写验证码");
			document.login.checkCode.focus();
			return false;
		}
		if (document.login.checkCode.value.length < 4) {
			alert("验证码必须为4位");
			document.login.checkCode.focus();
			return false;
		}
		var re = /^[0-9]*$/;//只能输入数字
		if (!re.test(document.login.checkCode.value)) {
			alert("验证码必须是数字");
			document.login.checkCode.focus();
			return false;
		}
		
		$.ajax({
			type : "POST",
			url : "${domain}/admin/login/submit",
			dataType: "json",
			data : $("#login").serialize(),
			success : function(data) {
				if(data.status == 0)
					alert(data.msg);
				if(data.status == 1)
					location.href = "${domain}/admin/index";
			}
		});
		return true;
	}
</script>
</head>
<body>
	<div class="index_clear"></div>
	<div id="web_main">
		<div class="main">
			<div class="login_right">
				<form name="login" id="login">
					<ul>
						<li><input name="userName" type="text" id="userName" value=""
							 onkeydown="return onkey(event)"/></li>
						<li><input name="password" type="password" value=""
							id="password" onkeydown="return onkey(event);"/></li>
						<li><input name="checkCode" type="text"
							id="checkCode" maxlength="4" onkeydown="return onkey(event)"/>
							<img src="${domain}/kaptcha.jpg" id="kaptchaImage"/>
						</li>
					</ul>
					<div class="test_buttom">
						<a href="javascript:void(0);" onclick="javascript:check();" class="login_submit">登 录</a>
						<a href="javascript:void(0);" class="login_refresh" onclick="changeCode();">刷 新</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		login.userName.focus();
		function changeCode(){
			$('#kaptchaImage').attr('src', '${domain}/kaptcha.jpg?' + Math.floor(Math.random()*100));
		}
		$(function(){
			var msg = "${msg}";
			if(msg != ""){
				alert(msg);
			}
		});
	</script>
</body>
</html>