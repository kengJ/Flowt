<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<form id="updateForm" class="layui-form" action="">
<input type="hidden" name="Id" value="${id}">
<div class="layui-form-item">
    <label class="layui-form-label">登录名</label>
    <div class="layui-input-block">
      <input type="text" name="LoginName" required value="${loginName}"  lay-verify="required" placeholder="请输入登录名" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">IP</label>
    <div class="layui-input-block">
      <input type="text" name="Ip" required value="${ip}"  lay-verify="required" placeholder="请输入IP地址" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
  <div class="layui-input-block">
  	<div class="layui-row layui-col-space12">
  		<div class="layui-col-md6">
  			<button type="button" class="layui-btn layui-btn-fluid" lay-filter="btn-save" id="btn_save">
  				<i class="layui-icon layui-icon-ok"></i>保存
  			</button>
  		</div>
  		<div class="layui-col-md6">
  			<button type="button" class="layui-btn layui-btn-primary layui-btn-fluid" lay-filter="btn-close">
  				<i class="layui-icon layui-icon-close"></i>取消
  			</button>
  		</div>
  	</div>   
  </div>
</div>
</form>
<script>
layui.use(['form','layer'],function(){
	var form = layui.form;
	var layer = layui.layer;
	/**form.on('Click(btn-save)', function(data){
		layer.msg('test');
		var Data = data.field;
		
		return false;
	});**/
	$('#btn_save').click(function(){
		//var Data = $('#updateForm').serializeArray();
		$.get('${APP_PATH}/Computer/Update?Id='+$("input[name='Id']").val()+'&LoginName='+$("input[name='LoginName']").val()+'&Ip='+$("input[name='Ip']").val(),function(data){
			if(data=="success"){
				layer.msg('保存成功');
			}else{
				layer.msg('保存错误');
			}
		});
		layer.msg("test");
		layer.msg(Data);
	});
});
</script>