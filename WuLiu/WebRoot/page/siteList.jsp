<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>

  </head>
  
  <body>
    <div class="container-fluid">
            <div class="row">
            	<div class="col-sm-12">
                    <ol class="breadcrumb">
                        <li class="active">主页
                        </li>
                        <li class="active">地点设置
                        </li>
                    </ol>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	 搜索
                        </div>
                        <div class="panel-body">
                            <form role="form" class="form-inline" method="post" action="${pageContext.request.contextPath }/SiteServlet?method=search">
                                <div class="form-group">
                                    <label for="name">名称</label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入名称">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-default">开始搜索</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!--
                     	   列表展示
                    -->
                    <div class="table-responsive">
                        <table class="table table-striped ">
                            <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>地点</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <c:forEach items="${list }" var="site">
                            <tbody>
                                <tr>
                                    <td>${site.id }</td>
                                    <td>${site.site_name } </td>
                                    <td>
                                        <div class="btn-group">
                                            <a href="${pageContext.request.contextPath }/page/updateSite.jsp?id=${site.id }&name=${site.site_name }" class="btn btn-default">修改</a>
                                            <a href="${pageContext.request.contextPath }/SiteServlet?method=delete&id=${site.id }" class="btn btn-danger">删除</a>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                            </c:forEach>
                        </table>
                        <a href="${pageContext.request.contextPath }/page/addSite.jsp" target="right" class="btn btn-default">添加</a>
                    </div>
                    <ul class="pagination" style="float: right;">
                        <li><a href="#">&laquo;</a>
                        </li>
                        <li class="active"><a href="#">1</a>
                        </li>
                        <li><a href="#">2</a>
                        </li>
                        <li><a href="#">3</a>
                        </li>
                        <li><a href="#">4</a>
                        </li>
                        <li><a href="#">5</a>
                        </li>
                        <li><a href="#">&raquo;</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
  </body>
</html>
