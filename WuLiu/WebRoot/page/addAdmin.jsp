<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addAdmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		 function myCheck()
            {//循环所有的表单元素； 也可以用jQuery：$("#表单id")[0].elements.length-1
               for(var i=0;i<document.form1.elements.length-1;i++) //下面减一是因为数组的下标为0
               {	
                  if(document.form1.elements[i].value=="")
                  {
                     alert("当前表单不能有空项");
                     document.form1.elements[i].focus();
                     return false;
                  }
               }
               return true;
            }
	</script>
	
  </head>
  
  <body>
    <div class="container-fluid">
            <div class="row">
            	<div class="col-sm-12">
                    <ol class="breadcrumb">
                        <li class="active">主页
                        </li>
                        <li class="active">个人设置
                        </li>
                        <li class="active">个人信息修改
                        </li>
                    </ol>
                    <form role="form" action="${pageContext.request.contextPath}/UserServlet?method=add" method="post" name="form1" onSubmit="return myCheck()">
                    	<div class="row">
							<div class="col-lg-3 form-group">
								<label for="name">&nbsp;用户名</label>
								<input type="text" class="form-control" name="userName" placeholder="文本输入">
							</div>
						</div>
						<div class="row">
							<div class="col-lg-3 form-group">
								<label for="name">&nbsp;密码</label>
								<input type="text" class="form-control" name="userPassword" placeholder="文本输入">
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
