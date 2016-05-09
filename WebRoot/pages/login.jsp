<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线考试系统登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/login.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>

	</head>
  
  <body>
  <div id="textDiv"></div>
    <table align="center">
    	<tr><img alt="zaixiankaos" src="<%= path%>/images/login_3.bmp"></tr>
    	<tr>
    		<td>
    			<div>
    				<form action="<%=path %>/login/login.action" method="post" id="loginForm" >
						<table >
							<tr align="right">
								<td >用户名：</td>
								<td><input type="text" name="loginName" required/></td>
							</tr>
							<tr align="right">
								<td>密码：</td>
								<td><input type="password" name="pwd" required/></td>
							</tr>
							<tr align="right">
								<td>
									<select id="sel" name="sel">
										<option id="sel0" value="0" selected="selected">学生</option>
										<option id="sel1" value="1">教师</option>
									</select>
								</td>
								<td>
								${error }
								<input type="submit" value="登录考试" name="sbm"/>
								<!-- 	
								<input type="button" value="登录" name="sbm" onclick="login()"/>
									<input type="reset" value="重置">    -->
								</td>
							</tr>
							<tr>&nbsp;</tr>
							<tr>&nbsp;</tr>
							<tr align="right">
								
							</tr >
							<tr align="right">
								
							</tr>
						</table>
						</form>
					</div>
    		</td>
    		<td><div><img alt="zaixiankaos" src="<%= path%>/images/login_1.png"></div></td>
    	</tr>
    </table>
    
  </body>
</html>
