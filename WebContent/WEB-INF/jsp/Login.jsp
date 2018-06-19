<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<!DOCTYPE html>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="${APP_PATH }/static/plug/Wopop/style_log.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/plug/Wopop/style.css">
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/plug/Wopop/userpanel.css">
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/plug/Wopop/jquery.ui.all.css">
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH }/static/js/base.js"></script>
</head>

<body class="login" mycollectionplug="bind">
<div class="login_m">
<div class="login_logo">
<!-- img src="${APP_PATH }/static/plug/Wopop/logo.png" width="196" height="46"> -->
</div>
<div class="login_boder">

<div class="login_padding" id="login_model">
  <h2>用户名</h2>
  <label>
    <input type="text" name="UserName" id="UserName" class="txt_input txt_input2" placeholder="工号">
  </label>
  <h2>密码</h2>
  <label>
    <input type="password" name="Password" id="Password" class="txt_input" placeholder="身份证后六位">
  </label>
  <div class="rem_sub">
    <label>
      <input type="submit" class="sub_button" id="button" value="登录" style="opacity: 0.7;">
    </label>
  </div>
</div>
</div>
<!--login_padding  Sign up end-->
</div><!--login_boder end-->
</div><!--login_m end-->
<script type="text/javascript">
var baseUrl = '${APP_PATH}';
</script>
<script type="text/javascript" src="${APP_PATH }/static/js/login.js"></script>
</body>
</html>