function check()
{
	if(document.guestbook.Guest_Name.value=="")
	{
		alert("请填写您的姓名");
		document.guestbook.Guest_Name.focus();
		return false
	}
	if(document.guestbook.Guest_Email.value=="")
	{
		alert("请填写邮件地址");
		document.guestbook.Guest_Email.focus();
		return false
	}
	if(document.guestbook.Content.value=="")
	{
		alert("请填写反馈内容");
		document.guestbook.Content.focus();
		return false
	}
	if(document.guestbook.checkcode.value=="")
	{
		alert("请填写验证码");
		document.guestbook.checkcode.focus();
		return false
	}
	if(document.guestbook.checkcode.value.length<4)
	{
		alert("验证码必须为4位");
		document.guestbook.checkcode.focus();
		return false;
	}
	//var re = /^[0-9]+.?[0-9]*$/;//判断字符串是否为数字
	var re = /^[1-9]+[0-9]*]*$/;//判断字符串是否为正整数
	if (!re.test(document.guestbook.checkcode.value))
	{
		alert("验证码必须是数字");
		document.guestbook.checkcode.focus();
		return false;
	}
	 
	return true;
}