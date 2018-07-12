<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="container-fluid">
            <div class="row">
                <div class="col-sm-2">
                    <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-home"></span>主页
                    </a>
                    <a target="right" href="${pageContext.request.contextPath }/ParcelServlet?method=list" class="list-group-item">
                    <!-- 小图标样式设置 -->
                        <span class="glyphicon glyphicon-search" aria-hidden="true">
                    </span>包裹信息</a>
                    <a target="right" href="${pageContext.request.contextPath }/CompanyServlet?method=list"  class="list-group-item">
                        <span class="glyphicon glyphicon-align-left" aria-hidden="true">
                    </span>物流公司价格信息</a>
                    <a target="right" href="${pageContext.request.contextPath }/SiteServlet?method=list" class="list-group-item">
                        <span class="glyphicon glyphicon-camera" aria-hidden="true">
                    </span>地点设置</a>
                    <a href="${pageContext.request.contextPath }/UserServlet?method=list" target="right" class="list-group-item">
                        <span class="glyphicon glyphicon-user" aria-hidden="true">
                    </span>个人设置</a>
                </div>
            </div>
        </div>
  </body>
</html>
