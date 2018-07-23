<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<form id="EditIpAddress" class="layui-form" action="">
<input type="hidden" name="Id" value="${id}">
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
</div>
</form>
