<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form id="EditIpAddress" class="layui-form" action="">
<!--  
<div class="layui-form-item">
    <label class="layui-form-label">登录名</label>
    <div class="layui-input-block">
      <input type="text" name="LoginName" required value="${loginName}" placeholder="请输入登录名" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">IP</label>
    <div class="layui-input-block">
      <input type="text" name="Ip" required value="${ip}" placeholder="请输入IP地址" autocomplete="off" class="layui-input">
    </div>
</div>-->
<c:out value="${width}"></c:out>
<c:forEach var="line" items="${data}">
	<c:choose>
	    <c:when test="${line.name eq \"Id\"}">  
	       	<input type="hidden" name="Id" value="${line.Value }">
	    </c:when>
	    <c:otherwise>
	        <div class="layui-form-item">
			<label class="layui-form-label">${line.title }</label>
			<div class="layui-input-block">
		      <input type="text" name="${line.name}" required value="${line.Value }" placeholder="请输入${line.title }" autocomplete="off" class="layui-input">
		    </div>
			</div>
	    </c:otherwise>
	</c:choose>		
</c:forEach>
</form>
