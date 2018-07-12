<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateCompany.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
		            $('.selectpicker').append("<option value=" + list[i].id + ">" + list[i].site_name + "</option>");  
		            $('#startSite').find('option[value="'+${param.startSite}+'"]').attr("selected",true);  
		            $('#endSite').find('option[value="'+${param.endSite}+'"]').attr("selected",true); 
		       	 }  
		  
		        	// 缺一不可  
			        $('#startSite').selectpicker('refresh');  
			        $('#startSite').selectpicker('render');  
			        
			        $('#endSite').selectpicker('refresh');  
			        $('#endSite').selectpicker('render');  
			         
		   		}  
			});
			$("#type").find('option[value="'+${param.type}+'"]').attr("selected",true);//回显  
		});
		
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
                        <li class="active">物流公司价格信息
                        </li>
                        <li class="active">物流公司价格信息修改
                        </li>
                    </ol>
                    <form role="form" action="${pageContext.request.contextPath}/CompanyServlet?method=update&id=${param.id }" method="post" name="form1" onsubmit="return myCheck()">
                    	<div class="row">
							<div class="col-lg-3 form-group">
								<label for="name">&nbsp;名称</label>
								<input type="text" class="form-control" placeholder="文本输入"  name="companyName" value="${param.name }">
							</div>
						</div>
						<div class="row">
							<div class="col-lg-3 form-group">
								<label for="name">&nbsp;起始地点</label>
								<select class="selectpicker" data-live-search="true" id="startSite" name="startSite" >               
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-3 form-group">
								<label for="name">&nbsp;目标地点</label>
								<select class="selectpicker" data-live-search="true" id="endSite" name="endSite">              
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4 form-group">
								<label for="name">&nbsp;货物类型</label>
								<select class="selectpicker" name="type" id="type" >
									<option value="1">轻货</option>
									<option value="2">重货</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4 form-group">
								<label for="name">&nbsp;价格</label>
								<input type="text" class="form-control" placeholder="文本输入" name="price" value="${param.price }">
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
