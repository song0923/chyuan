<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="copyright">
	<p>
		Copyright ©2004-2012&nbsp;<a href="${domain}"
			title="${company}">${company}</a> All Rights Reserved.鄂ICP备09003590号
	</p>
	<p>
		<span>${resouces.ct_address}: </span>${address} <span>${resouces.ct_postcode}: </span>${postcode}
	</p>
	<p>
		<span>${resouces.ct_hotline}: </span>${hotline} <span>${resouces.ct_fax}: </span>${fax} 
	</p>
	<p>
		<span>${resouces.ct_email}: </span>${mail}
	</p>
	
	<div id="OnlineChat" style="right: 3px; top: 130px; position: absolute; z-index: 50">
		<div id="ChatList"
			style="float: right; overflow: hidden; display: none;">
			<div style="width: 158px">
				<div class="Chat_top"></div>
				<div class="Chat_title">
					${resouces.business}<br />9:00-18:00
				</div>
				<div class="Chat_bg">
					<ul>
						<li><a
							href="http://wpa.qq.com/msgrd?v=3&amp;uin=7848126&amp;site=${company}&amp;menu=yes"
							target="_blank"><img border="0"
								src="http://wpa.qq.com/pa?p=2:445393201:50"/></a></li>
						<li><a
							href="http://wpa.qq.com/msgrd?v=3&amp;uin=240357115&amp;site=${company}&amp;menu=yes"
							title="在线客服" target="_blank"><img border="0"
								src="http://wpa.qq.com/pa?p=2:56135762:50"/></a></li>
					</ul>
				</div>
				<div class="Chat_bottom"></div>
			</div>
		</div>

		<div style="float: right; width: 24px; margin: 9px 0 0 0">
			<img id="ChatMenu" src="${domain}/${language}/chat/Chat_Open.gif"
				onmouseover="javascript:ChangeMenu()" height="100" width="24"/>
		</div>
	</div>
<script type="text/javascript" src="${domain}/${language}/chat/site_chat.js"></script>
</div>