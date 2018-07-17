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
<title>Ui 测试</title>
<link rel="stylesheet" href="${APP_PATH}/static/plug/layui/css/layui.css">
<script src="${APP_PATH}/static/plug/layui/layui.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</head>
<body style="background: url(${APP_PATH}/static/plug/Wopop/login_bgx.gif);">
<div class="layui-row" style="margin-top: 200px;">
  <div class="layui-col-md4 layui-col-md-offset4">
    <div class="layui-card">
	  	<div class="layui-card-header">登陆</div>
	  	<div class="layui-card-body">
		    <form class="layui-form" action="">
		    	  <div class="layui-form-item">
				    <label class="layui-form-label">用户名</label>
				    <div class="layui-input-block">
				      <input type="text" name="UserName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">密码</label>
				    <div class="layui-input-block">
				      <input type="password" name="Password" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				    <div class="layui-form-item">
				    <div class="layui-input-block">
				    	<div class="layui-row layui-col-space12">
				    		<div class="layui-col-md6">
				    			<button class="layui-btn layui-btn-fluid" lay-submit lay-filter="formDemo">
				    				<i class="layui-icon layui-icon-ok-circle"></i>登陆
				    			</button>
				    		</div>
				    		<div class="layui-col-md6">
				    			<button type="reset" class="layui-btn layui-btn-primary layui-btn-fluid">
				    				<i class="layui-icon layui-icon-refresh"></i>重置
				    			</button>
				    		</div>
				    	</div>   
				    </div>
				  </div>
		    </form>
	  	</div>
	</div>
  </div>
</div>
<script>
//一般直接写在一个js文件中
layui.use(['layer', 'form'], function(){
  var layer = layui.layer
  ,form = layui.form;
  //监听提交
  form.on('submit(formDemo)', function(data){
   layer.msg(JSON.stringify(data.field));
   //$.ajax();
   var Data = data.field;
   var Url = '${APP_PATH}/Login/Login';
   var Method = "POST";
   form = $("<form></form>")
   form.attr('action',Url)
   form.attr('method',Method)
   for(var key in Data){
   	input1 = $("<input type='hidden' name='"+key+"' value='"+Data[key]+"' />");
   	form.append(input1);
   }
   form.appendTo("body");
   form.css('display','none');
   form.submit();
   //console.log()
   return false;
 });
});
</script> 
</body>
</html>