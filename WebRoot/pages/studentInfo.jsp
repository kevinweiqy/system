<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="<%=path %>/themes/default/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=path %>/themes/icon.css" type="text/css"></link>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js"></script>

	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<%--中文放在easyui之后	<script type="text/javascript" src="<%=path%>/js/studentInfo.js"></script>--%>
	<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
	
	
 
  </head>
  
  <body> 
     <table  id="studentInfo" align="center">
     	<tr  align="center">
     		<td>学生账号</td>
     		<td>学生姓名</td>
     		<td>学生性别</td>
     		<td>登录密码</td>
     	</tr>
     	<tr align="center">
     		<td>${student.studentNumber}</td>
     		<td>${student.studentname}</td>
     		<td>${student.sex}</td>
     		<td>${student.studentpassword}</td>
     	</tr>
     	<tr>
     		<td>
     			<a href="<%=path%>/kaoshi/kaoshi.action" >参加考试</a>
     		</td>
     	</tr>     
     </table> 
  </body>
</html>
