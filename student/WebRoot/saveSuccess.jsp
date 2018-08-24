<%@ page language="java" import="java.util.*" import="pojo.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'saveSuccess.jsp' starting page</title>
    
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
  <%
  	request.setCharacterEncoding("UTF-8");
  	Student student =(Student)request.getSession().getAttribute("student");
   %>
   <br>
   <br>
   <center><h3>学生记录已成功保存！</h3></center>
    <table border="1"  align="center">
			<tr>
			<td>学号</td><td><%=student.getSno() %></td>
			</tr>
			<tr>
			<td>姓名</td><td><%=student.getSname() %></td>
			</tr>
			<tr>
			<td>性别</td><td><%=student.getSsex() %></td>
			</tr>
			<tr>
			<td>年龄</td><td><%=student.getSage() %></td>
			</tr>
			<tr>
			<td>地址</td><td><%=student.getSaddress() %></td>
			</tr>
			<tr>
			<td><a href="/student/first.jsp">返回初始页面</a></td>
			<td><a href="/student/saveStudent.jsp">返回上一级页面</a></td>
			</tr>
  </body>
</html>
