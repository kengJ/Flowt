<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Excel导出</title>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

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

<script type="text/javascript">
$(document).ready(function(){
	function createSelect1(target){
		var html = '';
		var result = null;
		$.ajax({
			url:'${APP_PATH}/ExcelTable/FindExcelTables',
			success:function(data){
				for(var key in data){
					$(target).append('<option value="'+data[key].id+'">'+data[key].tableName+'</option>');
				}
			}
		});
	}
	createSelect1('#form3 > select');
});
</script>
</body>
</html>