<%@ page language="java" import="java.util.*" import="pojo.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'first.jsp' starting page</title>
    
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
    <br>
  <br>
   <h1 align="center">学生信息管理系统</h1><br>
   <br>
   <br>
   <br>
   <table align="center" border="1">
   <tr >
   <td align="center"><a href="saveStudent.jsp" >增添学生记录 </a></td>
   </tr>
   <tr >
   <td align="center"><a href="queryStudent.jsp">查询学生记录</a></td>
   </tr>
   </table>
  </body>
</html>
