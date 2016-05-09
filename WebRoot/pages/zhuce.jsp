<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
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
   &nbsp;<br/> &nbsp;<br/> &nbsp;<br/> &nbsp;<br/> &nbsp;<br/> &nbsp;<br/> &nbsp;<br/> &nbsp;<br/>
  	<h1 align="center">=======学生注册=======</h1>
     	<form action="" method="post" >
     		<table align="center">
     			<tr align="center"></tr>
     			<tr><td>姓名</td><td><input type="text" name="name" required/></td><td>（*必填）</td></tr>
     			<tr><td>登录名</td><td><input type="text" name="loginName" required/></td><td>（*必填,不能包含中文）</td></tr>
     			<tr><td>性别</td><td>
     			<input type="radio" name="sex" value="1" checked="checked" id="sex"/><img alt="man" src="<%=path%>/images/Male.gif">
     			<input name="sex" type="radio" value="2"  id="sex" /><img alt="nv" src="<%=path%>/images/Female.gif">
     			</td><td></td></tr>
     			<tr><td>密码</td><td><input type="password" name="pwd"/></td><td>（*密码长度小于等于6位）</td></tr>
     			<tr><td>班号</td><td><input type="text" name="classNo"/></td><td></td></tr>
     			<tr><td>学号</td><td><input type="text" name="studenNo"/></td><td>（*必填）</td></tr>
     			<tr><td></td><td><input type="submit" value="提交"/></td><td><input type="reset" value="重置"/></td></tr>
     		</table>
     	</form>
  </body>
</html>
