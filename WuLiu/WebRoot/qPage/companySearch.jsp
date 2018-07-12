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
    
    <title>My JSP 'companySearch.jsp' starting page</title>
    
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
	<script type="text/javascript">
		$(function(){
		$.ajax({  
			// get请求地址  
		    url: "${pageContext.request.contextPath}/CompanyServlet",
		    dataType: "json",  
		    data:{method:"getSite"},
		    success: function (data) {  
		    var list = data.list;
		    		for (var i = 0; i < list.length; i++) {  
		            $('#startSite').append("<option value=" + list[i].id + ">" + list[i].site_name + "</option>");  
		            $('#endSite').append("<option value=" + list[i].id + ">" + list[i].site_name + "</option>"); 
		       	 }  
		  
			        $('#startSite').selectpicker('refresh');  
			        $('#startSite').selectpicker('render');  
			        $('#endSite').selectpicker('refresh');  
			        $('#endSite').selectpicker('render');  
		   		}  
			});
			
		});
	</script>
  </head>
  
  <body>
     <div class="container-fluid">
        	<div class="panel panel-default">
                        <div class="panel-heading">
                           	 物流价格搜索
                        </div>
                        <div class="panel-body">
                            <form role="form" class="form-inline" action="${pageContext.request.contextPath }/CompanyServlet?method=searchPrice" method="post">
                                <div class="form-group">
                                    <label for="name">&nbsp;&nbsp;&nbsp;&nbsp;开始地点选择</label>
                                    <select class="selectpicker" data-live-search="true" id="startSite" name="startSite">               
									</select>
                                </div>
                                <div class="form-group">
                                    <label for="name">&nbsp;&nbsp;&nbsp;&nbsp;结束地点选择</label>
                                    <select class="selectpicker" data-live-search="true" id="endSite" name="endSite">               
									</select>
                                </div>
                                <div class="form-group">
                                    <label for="name">&nbsp;&nbsp;&nbsp;&nbsp;货物类型选择</label>
                                    <select class="selectpicker" name="type" >
										<option value="1">轻货</option>
										<option value="2">重货</option>
									</select>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-default">搜索价格</button>
                                </div>
                            </form>
                        </div>
            </div>
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
                                </tr>
                            </tbody>
                            </c:forEach>
                        </table>
                    </div>
        </div>
  </body>
</html>
