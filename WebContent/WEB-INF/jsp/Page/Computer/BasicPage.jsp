<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<div class="layui-card" style="margin: 10px;border: 1px solid #e8e8e8;">
  <div class="layui-card-header" style="border-bottom: 1px solid #e8e8e8;">准入IP地址列表</div>
  <div class="layui-card-body">
  	<blockquote class="layui-elem-quote">
  		说明:<br/>
  		1.系统登录时会进行Ip检查，准入IP里没有信息是不可以访问的<br/>
  		2.查询功能可查询所有列
  	</blockquote>
   	<div class="layui-row layui-col-space10"">
	   	<div class="layui-col-md2">
	   		<button class="layui-btn layui-btn-normal" id="btn-add"><i class="layui-icon layui-icon-add-circle-fine"></i> 新增</button>
	   	</div>
	   	<div class="layui-col-md4">
	   		<input type="text" id="keyword" required  placeholder="请输入查询内容" autocomplete="off" class="layui-input">
	   	</div>
	   	<div class="layui-col-md4">
	   		<button class="layui-btn layui-btn-normal" id="btn-select"><i class="layui-icon layui-icon-search"></i> 查询</button>
	   	</div>
   	</div>
   	
   	<table class="layui-table" id="demo" lay-filter="demo">
   	</table>
   	<script type="text/html" id="barDemo">
    		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
  </div>
</div>

<script>
layui.use(['table','layer'], function(){
	  var table = layui.table;
	  var layer = layui.layer;
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,height: 315
	    ,url: '${APP_PATH}/Computer/FindAll' //数据接口
	    ,page: true //开启分页
	    ,text:'无数据'
	    ,cols: [[ //表头
	      {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
	      ,{field: 'loginName', title: '登录名', width:300}
	      ,{field: 'ip', title: 'IP', width:200, sort: true}
	      ,{field: 'userCode', title: '账号', width:200} 
	      ,{field: 'userName', title: '用户名', width: 200}
	      ,{field: 'action', title: '操作',toolbar:"#barDemo"}
	    ]],
	    done: function(res, curr, count){
	        //如果是异步请求数据方式，res即为你接口返回的信息。
	        //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
	        //console.log(res);
	        
	        //得到当前页码
	        //console.log(curr); 
	        
	        //得到数据总量
	        //console.log(count);
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
	      //layer.msg('ID：'+ data.id + ' 的查看操作');
	      var html = "<div style='padding:5px;'><table class='layui-table'><thead><tr><th style='width:10;'>key</th><th>value</th></tr></thead><tbody>";
	      var titles = ['id','loginName','ip','userCode','userName'];
	      for(var index in titles){
	    	  title = titles[index];
		      html+="<tr><td>"+title+"</td><td>"+data[title]+"</td></tr>";
	      }
	      html+="</tbody></table></div>";
	      layer.open({
	    	  title:'详细信息',
	    	  type: 1,
	    	  skin: 'layui-layer-rim', //加上边框
	    	  area: ['500px', '350px'], //宽高
	    	  content: html
	    	});
	    } else if(obj.event === 'del'){
	      layer.confirm('是否删除此行数据', function(index){
	    	  $.get('${APP_PATH}/Computer/Del?Id='+data['id'],function(data){
	    		 if(data=="success") {
	    			obj.del();
	    		    layer.close(index);
	    		 }
	    	  });
	      });
	    } else if(obj.event === 'edit'){
	      //layer.alert('编辑行：<br>'+ JSON.stringify(data))
	      $.get('${APP_PATH}/Page/ComputerEditPage?Id='+data['id']+'&Ip='+data['ip']+'&LoginName='+data['loginName'],function(data){
	    	  var html = "<div style='padding:10px;'>"+data+"</div>";
	    	  layer.open({
		    	  title:'修改数据',
		    	  type: 1,
		    	  skin: 'layui-layer-rim', //加上边框
		    	  area: ['500px', '250px'], //宽高
		    	  content: html
		    	});
	      });
	    }
	    //console.log('data',data);
	    //console.log('obj',obj);
	  });
	});
</script>