<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="layui-card" style="margin: 10px;border: 1px solid #e8e8e8;">
  <div class="layui-card-header" style="border-bottom: 1px solid #e8e8e8;">${title}</div>
  <div class="layui-card-body">
  	<c:if test="${not empty tip}">
	  	<blockquote class="layui-elem-quote">
	  		${tip}
	  	</blockquote>
  	</c:if>
   	<div class="layui-row layui-col-space10"">
   		<c:if test="${not empty ActionAddPage }">
	   		<div class="layui-col-md2">
		   		<button class="layui-btn layui-btn-normal" id="btn-add"><i class="layui-icon layui-icon-add-circle-fine"></i> 新增</button>
		   	</div>
   		</c:if>
   		<c:if test="${not empty ActionFindByKey }">
	   		<div class="layui-col-md4">
		   		<input type="text" id="keyword" required  placeholder="请输入查询内容" autocomplete="off" class="layui-input">
		   	</div>
		   	<div class="layui-col-md4">
		   		<button class="layui-btn layui-btn-normal" id="btn-select"><i class="layui-icon layui-icon-search"></i> 查询</button>
		   	</div>
   		</c:if>
   	</div>
   	
   	<table class="layui-table" id="demo" lay-filter="demo">
   	</table>
   	<script type="text/html" id="barDemo">
		<c:if test="${not empty ActionShow }">
			<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
		</c:if>
		<c:if test="${not empty ActionEditPage }">
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		</c:if>
		<c:if test="${not empty ActionDel }">
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</c:if>
		</script>
  </div>
</div>

<script>
var cols = new Array();
<c:forEach var="col" items="${cols }">
	var test = {};
	var text = '${col}'.replace(' ','').replace('{','').replace('}','');
	var line = text.split(',');
	if(line[0].split('=')[1]=='id'){
		test.width=80;//sort: true, fixed: 'left'
		test.sort=true;
		test.fixed='left';
	}
	test.field=line[0].split('=')[1];
	test.title=line[1].split('=')[1];
	cols.push(test);
</c:forEach>
cols.push({field: 'action', title: '操作',toolbar:"#barDemo"});
layui.use(['table','layer','form'], function(){
	  var table = layui.table;
	  var layer = layui.layer;
	  var form = layui.form;
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,height: 315
	    ,url: "${ActionFind}" //数据接口
	    ,page: true //开启分页
	    ,text:'无数据'
	    ,cols:[cols],
	    done: function(res, curr, count){
	        return res;
	      }
	  });
	  
	  $('#btn-select').on('click', function(){
		    var keyword = $('#keyword').val();
		    table.reload('demo', {
                where: {
                    keyword: keyword
                }
            });
		});
	//监听工具条
	  table.on('tool(demo)', function(obj){
	    var data = obj.data;
	    if(obj.event === 'detail'){
    		var id = data['id'];
	      $.get("${ActionShow}"+id,function(data){
	    	  layer.open({
		    	  title:'详细信息',
		    	  type: 1,
		    	  skin: 'layui-layer-rim', //加上边框
		    	  //area: ['500px', '350px'], //宽高
		    	  content: data
		    	});
	      });
	    } else if(obj.event === 'del'){
	      layer.confirm('是否删除此行数据', function(index){
	    	  $.get('${ActionDel}'+data['id'],function(data){
	    		 if(data=="success") {
	    			obj.del();
	    		    layer.close(index);
	    		 }
	    	  });
	      });
	    } else if(obj.event === 'edit'){
	      $.get('${ActionEditPage}'+data['id'],function(data){
	    	  var html = "<div style='padding:10px;'>"+data+"</div>";
	    	  layer.open({
	    	        type: 1,
	    	        btn: ['确定','取消'],
	    	        title: "修改数据",
	    	        area: ["460px", "250px"],
	    	        content: html,
	    	        yes: function (index) {
	    	        	 var Data = $('#EditIpAddress').serialize();
	    	        	 var url = "${ActionEdit}"+Data;
	    	        	 $.get(url,function(data){
	    	        		if(data=="success"){
	    	        			layer.msg('修改成功');
	    	        			layer.close(index);
	    	        			table.reload('demo', {
    	        				  url: '${ActionFind}'
    	        				  ,where: {} //设定异步数据接口的额外参数
    	        				  //,height: 300
    	        				});
	    	        		}else{
	    	        			layer.msg('修改失败');
	    	        		}
	    	        	 });
	    	            return false;
	    	        },btn2: function (index) {
	    	            layer.close(index);
	    	        }
	    	    });
	      });
	    }
	  });
	
		$('#btn-add').click(function(){
			$.get('${ActionAddPage}',function(data){
		    	  var html = "<div style='padding:10px;'>"+data+"</div>";
		    	  layer.open({
		    	        type: 1,
		    	        btn: ['确定','取消'],
		    	        title: "新增数据",
		    	        //area: ["460px", "250px"],
		    	        content: html,
		    	        yes: function (index) {
		    	        	 var Data = $('#EditIpAddress').serializeArray();
		    	        	 var Json = {};
		    	        	 for(var index in Data){
		    	        		 var line = Data[index];
		    	                 eval("Json."+line.name+"='" + line.value+"'");
		    	        	 }
		    	        	 var url = "${ActionAdd}";
		    	        	 $.ajax({
		    	        		 contentType: 'application/json;charset=UTF-8',
		    	        		 type:'POST',
		    	        		 url:url,
		    	        		 data:Json,
		    	        		 success:function(data){
				    	        		if(data=="success"){
				    	        			layer.msg('新增成功');
				    	        			layer.close(index);
				    	        			table.reload('demo', {
			    	        				  url: '${ActionFind}'
			    	        				  ,where: {} //设定异步数据接口的额外参数
			    	        				  //,height: 300
			    	        				});
				    	        		}else{
				    	        			layer.msg('新增失败');
				    	        		}
				    	        	 }
		    	        	 });
		    	        	 console.log(Json);
		    	        	 /**$.post(url,{json:Json},function(data){
		    	        		if(data=="success"){
		    	        			layer.msg('新增成功');
		    	        			layer.close(index);
		    	        			table.reload('demo', {
	    	        				  url: '${ActionFind}'
	    	        				  ,where: {} //设定异步数据接口的额外参数
	    	        				  //,height: 300
	    	        				});
		    	        		}else{
		    	        			layer.msg('新增失败');
		    	        		}
		    	        	 });**/
		    	        	 //console.log(url);
		    	            return false;
		    	        },btn2: function (index) {
		    	            layer.close(index);
		    	        }
		    	    });
		      });
		});
	});
</script>