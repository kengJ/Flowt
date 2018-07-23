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
		<c:forEach var="line" items="${data}">
			<tr>
				<td>${line.title }</td><td>${line.Value }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>