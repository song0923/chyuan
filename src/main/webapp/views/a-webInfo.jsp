<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/include/a_common.jsp"%>
<script type="text/javascript">
	function setTab(name, cursel, n) {
		for (var i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var con = document.getElementById("con_" + name + "_" + i);
			menu.className = i == cursel ? "hover" : "";
			con.style.display = i == cursel ? "block" : "none";
		}
	}
	$(document).ready(function(){
		var msg = "${webInfo_msg}";
		if(msg != ""){
			alert(msg);
		}
	});
</script>
</head>
<body>
	<div id="cms_main">
		<div class="main_title">
			<span class="sys_info">网站系统设置－网站信息设置 </span>
		</div>
		<div class="height5"></div>
		<div id="main_tags">
			<ul>
				<li id="one1" onclick="setTab('one',1,2)" class="hover">中文网站信息设置</li>
				<!-- <li id="one2" onClick="setTab('one',2,2)">英文网站信息设置</li> -->
			</ul>
		</div>
		<div class="contentbox">
			<div id="con_one_1" class="hover">
				<script type="text/javascript">
					function check1(){
						if (document.edit1.Site_Name.value == ""){
							alert("请填写网站名称");
							document.edit1.Site_Name.focus();
							return false;
						}
						return true;
					}
				</script>

				<form name="edit1" method="post" action="/admin/webInfo/edit" onsubmit="return check1()">
					<input type="hidden" name="type" value="${webInfo.type}"/>
					<table id="main_content">
						<tr>
							<td width="100" class="content_title">网站名称</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_ma"><input name="webNameCn" type="text"
										id="webNameCn" value="${webInfo.webNameCn}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">网站地址</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="website" type="text"
										id="website" value="${webInfo.website}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">网站关键字</td>
							<td class="content_list" style="padding-right: 10px"><textarea
									name="webKeywordCn" cols="90" rows="3" id="webKeywordCn">${webInfo.webKeywordCn}</textarea></td>
						</tr>
						<tr>
							<td class="content_title">网站说明</td>
							<td class="content_list" style="padding-right: 10px"><textarea
									name="webDescriptionCn" id="webDescriptionCn" cols="90"
									rows="3">${webInfo.webDescriptionCn}</textarea></td>
						</tr>
						<tr>
							<td class="content_title">公司名称</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="company" type="text"
										id="company" value="${webInfo.company}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">热线电话</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="hotline" type="text"
										id="hotline" value="${webInfo.hotline}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">公司地址</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_ma"><input name="addressCn" type="text"
										id="addressCn" value="${webInfo.addressCn}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">邮编</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="postcode" type="text"
										id="postcode" value="${webInfo.postcode}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">联系电话</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="phone" type="text"
										id="phone" value="${webInfo.phone}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">传真号码</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="fax" type="text"
										id="fax" value="${webInfo.fax}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">手机号码</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="mobile" type="text"
										id="mobile" value="${webInfo.mobile}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">邮件地址</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="mail" type="text"
										id="mail" value="${webInfo.mail}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">联系人</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="linkman"
										type="text" id="linkman" value="${webInfo.linkman}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">ICP备案号</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="icpCode" type="text"
										id="icpCode" value="${webInfo.icpCode}" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
					</table>
					<div class="mc_submit">
						<input type="image" name="imageField" id="imageField"
							src="${domain}/images/submit.gif"/>
					</div>
				</form>
			</div>
			<!-- <div id="con_one_2" style="display: none">
				<script type="text/javascript">
					function check2(){
						if (document.edit2.Site_Name.value == ""){
							alert("请填写网站名称");
							document.edit2.Site_Name.focus();
							return false
						}
						return true;
					}
				</script>

				<form name="edit2" method="post" action="?Action=edit&langid=2"
					onSubmit="return check2()">
					<table id="main_content">
						<tr>
							<td width="100" class="content_title">网站名称</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_ma"><input name="Site_Name" type="text"
										id="Site_Name"
										value="Shanghai Netgather Industry Development Co.,Ltd." /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">网站地址</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="Site_Http" type="text"
										id="Site_Http" value="www.netgather.com" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">网站关键字</td>
							<td class="content_list" style="padding-right: 10px"><textarea
									name="Site_KeyWords" cols="90" rows="3" id="Site_KeyWords">Pharmaceutical raw materials and intermedia</textarea></td>
						</tr>
						<tr>
							<td class="content_title">网站说明</td>
							<td class="content_list" style="padding-right: 10px"><textarea
									name="Site_Description" id="Site_Description" cols="90"
									rows="3">Shanghai Netgather Chemical Co.,Ltd.and Shanghai Import & Export Co., Ltd. is inorganic chemicals, organic chemicals, fine chemicals, flavors and fragrances, food additives, pharmaceutical raw materials and intermediates business, sales of high-tech chemical enterprise</textarea></td>
						</tr>
						<tr>
							<td class="content_title">公司地址</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_ma"><input name="Site_ADD" type="text"
										id="Site_ADD" value="Shanghai jia ding qu hua ting zhen" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">邮编</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="Site_ZIP" type="text"
										id="Site_ZIP" value="200000" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">联系电话</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="Site_TEL" type="text"
										id="Site_TEL" value="8621-58888888" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">传真号码</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="Site_FAX" type="text"
										id="Site_FAX" value="8621-58888888" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">手机号码</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="Site_HP" type="text"
										id="Site_HP" value="13888888888" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">邮件地址</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="Site_Mail" type="text"
										id="Site_Mail" value="netgather@netgather.com" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">联系人</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="Site_Linkman"
										type="text" id="Site_Linkman" value="Netgather" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">ICP备案号</td>
							<td class="content_list">
								<ul class="list_input">
									<li class="input_l"></li>
									<li class="input_md"><input name="Site_ICP" type="text"
										id="Site_ICP" value="沪ICP备00000001" /></li>
									<li class="input_r"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="content_title">第三方代码</td>
							<td class="content_list" style="padding-right: 10px"><textarea
									name="Site_Plugins" cols="90" rows="5" id="Site_Plugins"></textarea></td>
						</tr>
					</table>
					<div class="mc_submit">
						<input type="image" name="imageField" id="imageField"
							src="images/submit.gif">
					</div>
				</form>
			</div> -->
		</div>
	</div>
</body>
</html>