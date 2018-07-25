<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form id="EditIpAddress" class="layui-form" action="">
<c:forEach var="line" items="${data}">
	<div class="layui-form-item">
		<label class="layui-form-label">${line.title }</label>
		<div class="layui-input-block">
	      <input type="text" name="${line.name}" required value="" placeholder="请输入${line.title }" autocomplete="off" class="layui-input">
	    </div>
	</div>
</c:forEach>
</form>
