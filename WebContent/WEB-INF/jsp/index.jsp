<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("error", request.getParameter("error-box"));
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${APP_PATH }/static/plug/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${APP_PATH }/static/plug/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${APP_PATH }/static/plug/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${APP_PATH }/static/js/base.js"></script>
<title>首页</title>
</head>
<body>
<header>
<jsp:include page="header.jsp"></jsp:include>
</header>
<section id="main">

</section>
<script type="text/javascript">
var baseUrl = '${APP_PATH}';
</script>
<script type="text/javascript" src="${APP_PATH }/static/js/main.js"></script>
</body>
</html>