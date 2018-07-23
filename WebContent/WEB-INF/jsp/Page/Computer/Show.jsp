<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style='padding:5px;'>
	<table class='layui-table'>
		<thead>
			<tr>
				<th style='width:10;'>key</th>
				<th>value</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items=""></c:forEach>
		${Result}
			<tr>
				<td>Id</td><td>${id}</td>
			</tr>
			<tr>
				<td>LoginName</td><td>${loginName}</td>
			</tr>
			<tr>
				<td>Ip</td><td>${ip}</td>
			</tr>
			<tr>
				<td>UserCode</td><td>${userCode}</td>
			</tr>
			<tr>
				<td>UserName</td><td>${userName}</td>
			</tr>
		</tbody>
	</table>
</div>