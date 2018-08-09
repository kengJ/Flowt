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
	   		<div class="layui-col-md1">
		   		<button class="layui-btn layui-btn-normal" id="btn-add"><i class="layui-icon layui-icon-add-circle-fine"></i> 新增</button>
		   	</div>
   		</c:if>
   		<c:if test="${not empty ActionFindByKey }">
	   		<div class="layui-col-md4">
		   		<input type="text" id="keyword" placeholder="请输入查询内容" autocomplete="off" class="layui-input">
		   	</div>
		   	<div class="layui-col-md1">
		   		<button class="layui-btn layui-btn-normal" id="btn-select"><i class="layui-icon layui-icon-search"></i> 查询</button>
		   	</div>
		   	<div class="layui-col-md1">
		   		<button class="layui-btn layui-btn-normal" id="btn-clean"><i class="layui-icon layui-icon-refresh"></i> 清除</button>
   			</div>
   		</c:if>
   	</div>
   	
   	<table class="layui-table" id="demo" lay-filter="demo" lay-size="sm">
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
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="updateRole">更新权限</a>
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
cols.push({field: 'action', title: '操作',toolbar:"#barDemo",width:250});
layui.use(['table','layer','form'], function(){
	  var table = layui.table;
	  var layer = layui.layer;
	  var form = layui.form;
	  //第一个实例
	  table.render({
	    elem: '#demo'	
	    ,method: 'post'
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
		    	url: '${ActionFindByKey}',
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
	      $.ajax({
	    	  type:'POST',
	    	  url:'${ActionShow}',
	    	  data:{Id:id},
	    	  success:function(data){
		    	  layer.open({
			    	  title:'详细信息',
			    	  type: 1,
			    	  skin: 'layui-layer-rim', //加上边框
			    	  area: '${width}',
			    	  content: data
			    	});
		      }
	      });
	    } else if(obj.event === 'del'){
	      layer.confirm('是否删除此行数据', function(index){
	    	  $.ajax({
	    		  url:'${ActionDel}',
	    		  type:'POST',
	    		  data:{Id:data['id']},
	    		  success:function(data){
	    			  if(data=="success") {
    				  table.reload('demo', {
        				  url: '${ActionFind}'
        				  ,where: {} //设定异步数据接口的额外参数
        				  //,height: 300
        				});
	  	    		    layer.close(index);
	  	    		  	layer.msg('删除成功');
	  	    		 }else{
	  	    			layer.msg('删除失败'); 
	  	    		 }
	    		  }
	    	  });
	      });
	    } else if(obj.event === 'edit'){
	    	var id = data['id'];
	      $.ajax({
	    	  url:'${ActionEditPage}',
	    	  type:'POST',
	    	  data:{Type:'edit',Id:id},
	    	  success:function(data){
	    		  var html = "<div style='padding:10px;'>"+data+"</div>";
		    	  layer.open({
		    	        type: 1,
		    	        btn: ['确定','取消'],
		    	        title: "修改数据",
		    	        area: "${width}",
		    	        content: html,
		    	        yes: function (index) {
		    	        	 var Data = $('#EditIpAddress').serialize();
		    	        	 var url = "${ActionEdit}";
		    	        	 $.ajax({
		    	        		 url:url,
		    	        		 type:'POST',
		    	        		 data:Data,
		    	        		 success:function(data){
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
		    	        	 	}
		    	        	 });
		    	        	 	
		    	            return false;
		    	        },btn2: function (index) {
		    	            layer.close(index);
		    	        }
		    	    });
	    	  }
	      });
	    }else if(obj.event === 'updateRole'){
	    	var id = data['id'];
	    	$.ajax({
		    	  type:'POST',
		    	  btn: ['确定','取消'],
		    	  url:'${ActionUpdateRolePage}',
		    	  data:{Id:id},
		    	  success:function(data){
			    	  layer.open({
				    	  title:'更新权限',
				    	  type: 1,
				    	  skin: 'layui-layer-rim', //加上边框
				    	  area: '${width}',
				    	  content: data
				    	});
			      }
		      });
	    }
	  });
	
	$('#btn-add').click(function(){
		$.ajax({
			url:'${ActionAddPage}',
			type:'POST',
	    	data:{ActionName:'${action}'},
			success:function(data){
				var html = "<div style='padding:10px;'>"+data+"</div>";
		    	  layer.open({
		    	        type: 1,
		    	        btn: ['确定','取消'],
		    	        title: "新增数据",
		    	        area: "${width}",
		    	        content: html,
		    	        yes: function (box) {
		    	        	 var Data = $('#EditIpAddress').serializeArray();
		    	        	 var Json = "";
		    	        	 for(var index in Data){
		    	        		 var line = Data[index];
		    	        		 if(index==0){
		    	        			 Json+=line.name+":'" + line.value+"'";
		    	        		 }
		    	        		 Json+=','+line.name+":'" + line.value+"'";
		    	        	 }
		    	        	 var url = "${ActionAdd}";
		    	        	 $.ajax({
		    	        		 type:'POST',
		    	        		 url:url,
		    	        		 data:eval('({'+Json+'})'),
		    	        		 success:function(data){
				    	        		if(data=="success"){
				    	        			layer.close(box);
				    	        			layer.msg('新增成功');
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
		    	            return false;
		    	        },btn2: function (box) {
		    	            layer.close(box);
		    	        }
		    	    });// layer.open
		}//success function
		});//ajax ActionAddPage
	});//click
	
	$('#btn-clean').click(function(){
		$('#keyword').val('');
		table.reload('demo', {
			  url: '${ActionFind}'
			  ,where: {} //设定异步数据接口的额外参数
			  //,height: 300
			});
	});
});
</script>