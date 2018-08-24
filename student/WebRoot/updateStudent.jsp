<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'updateStudent.jsp' starting page</title>
    
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
     <h3 align="center">更新学生信息<form action="/student/StudentSer" method="post"></h3>
    <h3 align="center">学号：<input type="text" name="sno" value="<%=request.getParameter("Sno")%>"/><br></h3>
  <h3 align="center"> 姓名：<input type="text" name="sname" value="<%= request.getParameter("Sname")%>"/><br></h3>
 <h3 align="center">  性别：<input type="text" name="ssex" value="<%= request.getParameter("Ssex")%>"/><br></h3>
   <h3 align="center">年龄：<input type="text" name="sage" value="<%=request.getParameter("Sage")%>"/><br></h3>
   <h3 align="center">地址：<input type="text" name="saddress" value="<%=request.getParameter("Saddress") %>"/><br></h3>
         <h3 align="center">    <input type="submit" value="提交"/></h3>
             <input type="hidden" name="studentRequest" value="updateStudent"/>
    </form>
  </body>
</html>
