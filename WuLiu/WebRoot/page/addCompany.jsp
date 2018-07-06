<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addCompany.jsp' starting page</title>
    
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
                        <li class="active">物流公司价格信息添加
                        </li>
                    </ol>
                    <form role="form">
                    	<div class="row">
							<div class="col-lg-3 form-group">
								<label for="name">&nbsp;名称</label>
								<input type="text" class="form-control" placeholder="文本输入">
							</div>
						</div>
						<div class="row">
							<div class="col-lg-3 form-group">
								<label for="name">&nbsp;起始地点</label>
								<input type="text" class="form-control" placeholder="文本输入">
							</div>
						</div>
						<div class="row">
							<div class="col-lg-3 form-group">
								<label for="name">&nbsp;目标地点</label>
								<input type="text" class="form-control" placeholder="文本输入">
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4 form-group">
								<label for="name">&nbsp;货物类型</label>
								<input type="text" class="form-control" placeholder="文本输入">
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4 form-group">
								<label for="name">&nbsp;价格</label>
								<input type="text" class="form-control" placeholder="文本输入">
							</div>
						</div>
						<div class="row">
							<div class="col-lg-1 form-group">
								<input class="btn btn-primary" type="submit" value="确定">
							</div>
						</div>
					</form>
                </div>
            </div>
        </div>
  </body>
</html>
