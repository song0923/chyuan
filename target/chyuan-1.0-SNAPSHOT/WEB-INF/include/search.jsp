<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="index-search">
	<h2></h2>
	<form action="/search" method="post" id="sitesearch" name="sitesearch">
		<input name="type" type="hidden" value="${langType}"/>
		<p>
			<select name="searchId" id="searchId">
				<option value="1">${resouces.product}</option>
				<option value="2">${resouces.newsCenter}</option>
				<option value="3">${resouces.jobs}</option></select>
		</p>
		<p>
			<input name="searchText" type="text" id="searchText" value="${searchText}"/>
		</p>
		<p>
			<input name="searchbutton" type="submit" id="searchbutton" value="" />
		</p>
	</form>
</div>
