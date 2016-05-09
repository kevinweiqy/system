<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  &nbsp;<br/> &nbsp;<br/> &nbsp;<br/> &nbsp;<br/> &nbsp;<br/> &nbsp;<br/> &nbsp;<br/> &nbsp;<br/>
  <body>
   		<form action="<%=path%>/main.jsp" method="post">
   			<h1 align="center">后台管理登录</h1>
   			<table align="center">
   				<tr align="center"><td>登录名：</td><td><input type="text" name=""/></td></tr>
   				<tr align="center"><td>密码：</td><td><input type="password" name=""/></td></tr>
   				<tr align="center">
   					<td><input type="submit" value="提交"/></td>
   					<td><input type="reset" value="重置"/></td>
   				</tr>				
   			</table>
   		</form>
  </body>
</html>
