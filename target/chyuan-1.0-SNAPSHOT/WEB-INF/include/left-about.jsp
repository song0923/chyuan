<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="left-about">
	<h2>
		<span>关于我们</span>
	</h2>
	<div id="LeftMenu" class="ddsmoothmenu-v">
		<ul>
			<li><a href="/cn/single.asp?menuid=13"><span>销售网络</span></a></li>
			<li><a href="/cn/single.asp?menuid=14"><span>组织结构</span></a></li>
			<li><a href="/cn/single.asp?menuid=15"><span>联系我们</span></a></li>
		</ul>
	</div>

	<script type="text/javascript">
		ddsmoothmenu.init({
			mainmenuid : "LeftMenu", //Menu DIV id
			orientation : 'v', //Horizontal or vertical menu: Set to "h" or "v"
			classname : 'ddsmoothmenu-v', //class added to menu's outer DIV
			//customtheme: ["#804000", "#482400"],
			contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]

		})
	</script>
</div>