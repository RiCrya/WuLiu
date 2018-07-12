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
    
    <title>My JSP 'companyList.jsp' starting page</title>
    
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
                        <li class="active">物流公司价格信息
                        </li>
                    </ol>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	 搜索
                        </div>
                        <div class="panel-body">
                            <form role="form" class="form-inline" method="post" action="${pageContext.request.contextPath }/CompanyServlet?method=search">
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
                                    <th>名称</th>
                                    <th>起始地点</th>
                                    <th>目标地点</th>
                                    <th>货物类型</th>
                                    <th>价格</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <c:forEach items="${list }" var="company">
                            <tbody>
                                <tr>
                                    <td>${company.id }</td>
                                    <td>${company.companyName }</td>
                                    <td>${company.site_name }</td>
                                    <td>${company.site_name1 }</td>
                                    <td>${company.typeName }</td>
                                    <td>${company.price }</td>
                                    <td>
                                        <div class="btn-group">
                                            <a href="${pageContext.request.contextPath }/page/updateCompany.jsp?id=${company.id}&name=${company.companyName }&startSite=${company.start_site_id }&endSite=${company.end_site_id }&type=${company.type_id }&price=${company.price } "class="btn btn-default">修改</a>
                                            <a href="${pageContext.request.contextPath }/CompanyServlet?method=delete&id=${company.id}" class="btn btn-danger">删除</a>
                                        </div>

                                    </td>
                                </tr>
                            </tbody>
                            </c:forEach>
                        </table>
                        <a href="${pageContext.request.contextPath }/page/addCompany.jsp" target="right" class="btn btn-default">添加</a>
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
