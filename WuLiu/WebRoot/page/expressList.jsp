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
    
    <title>My JSP 'expressList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap-paginator.min.js"></script>
	
	<script type="text/javascript">
	
	$(function(){
    test("", function(){
        var element = $('#bp-element');
        options = {
            bootstrapMajorVersion:3, //对应的bootstrap版本
            currentPage: ${currentPage}, //当前页数，这里是用的EL表达式，获取从后台传过来的值
            numberOfPages: 2, //每页页数
            totalPages:${totalPages}, //总页数，这里是用的EL表达式，获取从后台传过来的值
            shouldShowPage:true,//是否显示该按钮
            itemTexts: function (type, page, current) {//设置显示的样式，默认是箭头
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "末页";
                    case "page":
                        return page;
                }
            },
            //点击事件
            onPageClicked: function (event, originalEvent, type, page) {
                location.href = "${pageContext.request.contextPath }/ParcelServlet?method=page&page=" + page;
            }
        };
        element.bootstrapPaginator(options);
    })
});
</script>
	

  </head>
  
  <body>
    <div class="container-fluid">
            <div class="row">
            	<div class="col-sm-12">
                    <ol class="breadcrumb">
                        <li class="active">主页
                        </li>
                        <li class="active">包裹信息
                        </li>
                    </ol>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	 搜索
                        </div>
                        <div class="panel-body">
                            <form role="form" class="form-inline" method="post" action="${pageContext.request.contextPath }/ParcelServlet?method=search">
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
                                    <th>订单号</th>
                                    <th>起始地点</th>
                                    <th>目标地点</th>
                                    <th>货物类型</th>
                                    <th>寄件人</th>
                                    <th>寄件号码</th>
                                    <th>收件人</th>
                                    <th>收件人号码</th>
                                    <th>操作</th>
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
                                    <td>
                                        <div class="btn-group">
                                            <a href="${pageContext.request.contextPath }/page/updateExpress.jsp?id=${parcel.id }&pkg_number=${parcel.pkg_number }&pkg_start=${parcel.pkg_start_id}&pkg_end=${parcel.pkg_end_id}&pkg_type=${parcel.pkg_type_id}
                                            &sender=${parcel.sender }&sender_phone=${parcel.sender_phone }&recipient=${parcel.recipient }&recipient_phone=${parcel.recipient_phone }
                                            "  target="right" class="btn btn-default">修改</a>
                                            <a href="${pageContext.request.contextPath }/ParcelServlet?method=delete&id=${parcel.id }" class="btn btn-danger">删除</a>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                            </c:forEach>
                        </table>
                        <a href="${pageContext.request.contextPath }/page/addExpress.jsp" target="right" class="btn btn-default">添加</a>
                    </div>
                    <ul class="pagination" id="bp-element" style="float: right;">
                    </ul>
                </div>
            </div>
        </div>
  </body>
</html>
