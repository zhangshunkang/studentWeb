<%@ page language="java" import="java.util.*" import="pojo.User" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>">
    
   <font size="10" color="blue"> <title>学生信息管理系统</title></font>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 
  <body>
  
  <script type="text/javascript">
   function checkData() {
   		var s = '<%=request.getAttribute("num")%>';
   		if(s != null)
   		{
   			window.alert("用户名或密码错误！");
   		}
   }
   	
    </script>
   <br>
  <br>
   <h1 align="center">学生信息管理系统</h1><br>
   <br>
   <br>
   <br>
   
   <form action="/student/UserSer" method="post" >
  <h3 align="center"> 用户名：<input type="text" name="Lname" /></h3><br>
  <h3 align="center"> 密    码：<input type="text" name="Lpassword" /></h3><br>
              <p align="center"> <input type="submit" value="登录"/></p>
   
  <%
  
   %>
  </body>
</html>
