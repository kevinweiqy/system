<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'score.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link rel="stylesheet" href="<%=path%>/themes/default/easyui.css" type="text/css"></link>    
    <link rel="stylesheet" href="<%=path%>/themes/icon.css" type="text/css"></link>
    <script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/studentLogin/score.js"></script>
    <!-- 国际化要放在jquery之后 -->
    <script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>

  </head>
  
  <body>
    <table id="list"></table>
  </body>
</html>
