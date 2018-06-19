<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<%
response.sendRedirect("Login/LoginPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH }/static/js/test.js"></script>
<script type="text/javascript" src="${APP_PATH }/static/js/base.js"></script>
</head>
<body>
增加数据库信息测试
<form id="form1">
	<input type="text" name="Memo" placeholder="备注" /><br/>
	<input type="text" name="Ip" placeholder="Ip" /><br/>
	<input type="text" name="UserName" placeholder="用户名" /><br/>
	<input type="password" name="Password" placeholder="密码"/><br/>
	<input type="text" name="DbName" placeholder="数据库名称"/><br/>
	<select name="Type">
		<option value="1">MySql</option>
		<option value="2">SqlServer</option>
	</select>
</form>
<input type="button" value="提交" id="btn_tijiao" />

<div id="result"></div>
<hr/>
增加报表测试
<form id="form2">
<select name="SqlMessage">
	<option value="">请选择</option>
</select><br/>
<input type="text"name="TableName" placeholder="报表名称" /><br/>
<textarea name="SqlText" placeholder="Sql" rows="5"></textarea><br/>
<textarea name="Memo" placeholder="备注" rows="3"></textarea><br/>
<input type="text" name ="CodeIcon" placeholder="编号替代符" /><br/>
<input type="text" name ="DeptIcon" placeholder="部门编号替代符" /><br/>
<input type="text" name ="StartDateIcon" placeholder="开始时间替代符" /><br/>
<input type="text" name ="FinishDateIcon" placeholder="结束时间替代符" /><br/>
</form>
<input type="button" value="提交" id="form_btn" />
<div id="result2"></div>
<hr/>
<form id="form3" action="${APP_PATH}/Test1">
<select name="ExcelTableId">
	<option value="">请选择</option>
</select><br/>
<input type="text" name="Code" placeholder="编号">
<input type="text" name="Dept" placeholder="部门编号">
<input type="date" name="StartDate" placeholder="开始时间">
<input type="date" name="FinishDate" placeholder="结束时间"> 
<input type="submit" id="form3_btn" value="提交"></input>
</form>
<hr/>
<div>用户测试</div>
<form id="form4">
<input type="text" name="UserName" placeholder="用户名"/><br/>
<input type="password" name="Password" placeholder="密码"/><br/>
<input type="button" value="添加用户">
</form>
<div id="result4"></div>
<script type="text/javascript">
var baseUrl = '${APP_PATH}';
$(document).ready(function(){
	$('#form4>input[type="button"]').click(function(){
		FetData(baseUrl+'/Login/LoginCheck',GetFormData('#form4'),function(data){
			$('#result4').append(data);
			if(data=="success"){
				self.location.href=baseUrl+'/Login/Login?'+GetFormData('#form4');
			}
		},'POST');
	});
	
});

</script>
</body>
</html>