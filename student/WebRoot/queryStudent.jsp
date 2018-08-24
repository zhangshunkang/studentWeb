<%@page import="pojo.Student"%>
<%@ page language="java" import="java.util.*" import="pojo.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryStudent.jsp' starting page</title>
    
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
  <h3 align="center"><a href="/student/first.jsp" >返回初始页面</a><br></h3>
    <form action="/student/StudentSer" method="post" >
  <h3 align="center">  关键字:<input type="text" name="sname"/> </h3>
    <h3 align="center"><input type="submit" value="查询"/></h3>
    <input type="hidden" name="studentRequest" value="queryStudent"/>
    </form>
    <%
    	ArrayList<Student> students = (ArrayList) request
						.getAttribute("students");
				if(students!=null) {
     %>
    <table border="1" align="center">
			<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>地址</td>
			<td>更新</td>
			<td>删除</td>
			</tr>
			<%
					for (int i = 0; i < students.size(); i++) {
			%>
			<tr>
				<td><%=students.get(i).getSno()%></td>
				<td><%=students.get(i).getSname()%></td>
				<td><%=students.get(i).getSsex()%></td>
				<td><%=students.get(i).getSage()%></td>
				<td><%=students.get(i).getSaddress()%></td>
				<td><a href="/student/updateStudent.jsp?Sno=<%=students.get(i).getSno()%>&Sname=<%=students.get(i).getSname().toString()%>&Ssex=<%=students.get(i).getSsex().toString()%>&Sage=<%=students.get(i).getSage()%>&Saddress=<%=students.get(i).getSaddress().toString()%>">更新</a></td>
				<td><a href="/student/StudentSer?sno=<%=students.get(i).getSno()%>&studentRequest=deleteStudent">删除</a></td>
			</tr>
			<%
					}
				}
			%>
		</table>
  </body>
</html>
