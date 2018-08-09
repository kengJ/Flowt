<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form id="EditIpAddress" class="layui-form" action="">
<input type="hidden" name="Id" value="${id}">
<div class="layui-form-item">
    <label class="layui-form-label">登录名</label>
    <div class="layui-input-block">
      ${name }
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">权限</label>
    <div class="layui-input-block">
        <select name="role" lay-verify="required">
        	<option value=""></option>
        	<c:forEach items="${roles }" var="role">
        		<option value="${role.id}">${role.memo }</option>
        	</c:forEach>
      </select>
      <!-- input type="text" name="Ip" required value="${ip}"  lay-verify="required" placeholder="请输入IP地址" autocomplete="off" class="layui-input"> -->
    </div>
</div>
</form>