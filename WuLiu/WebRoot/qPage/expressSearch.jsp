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
    
    <title>My JSP 'expressSearch.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-select.min.css">
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap-select.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/defaults-zh_CN.min.js"></script>

  </head>
  
  <body>
    <div class="container-fluid">
            <div class="panel panel-default">
                        <div class="panel-heading">
                           	 物流单号搜索
                        </div>
                        <div class="panel-body">
                            <form role="form" class="form-inline" action="${pageContext.request.contextPath }/ParcelServlet?method=searchList" method="post">
                                <div class="form-group">
                                    <label for="name">单号</label>
                                    <input type="text" class="form-control" id="name" name="number" placeholder="请输入单号">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-default">开始搜索</button>
                                </div>
                            </form>
                        </div>
                    </div>  
                    
                     <div class="table-responsive">
                        <table class="table table-striped ">
                            <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>订单号</th>
                                    <th>起始地点</th>
                                    <th>目标地点</th>
                                    <th>货物类型</th>
                                    <th>寄件人</th>
                                    <th>寄件号码</th>
                                    <th>收件人</th>
                                    <th>收件人号码</th>
                                </tr>
                            </thead>
                            <c:forEach items="${list }" var="parcel">
                            <tbody>
                                <tr>
                                    <td>${parcel.id }</td>
                                    <td>${parcel.pkg_number }</td>
                                    <td>${parcel.site_name }</td>
                                    <td>${parcel.site_name1 }</td>
                                    <td>${parcel.typeName }</td>
                                    <td>${parcel.sender }</td>
                                    <td>${parcel.sender_phone }</td>
                                    <td>${parcel.recipient }</td>
                                    <td>${parcel.recipient_phone }</td>
                                </tr>
                            </tbody>
                            </c:forEach>
                        </table>
                    </div>  
        </div>
  </body>
</html>
