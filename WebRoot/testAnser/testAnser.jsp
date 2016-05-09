<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'carlist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="<%=path%>/themes/default/easyui.css"
			type="text/css"></link>
		<link rel="stylesheet" href="<%=path%>/themes/icon.css"
			type="text/css"></link>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js">
</script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js">
</script>
		<script type="text/javascript" src="<%=path%>/testAnser/testAnser.js">
</script>
		<!-- 国际化要放在jquery之后 -->
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js">
</script>
	</head>

	<body>
		<table id="list"></table>
		<div id="searchWin" style="text-align: center;">
			<form id="searchForm" action="">
				试题编号：
				<input type="text" name="testAnser.stu.id" />
				<br />
				<!--  <input type="button" name="btn" value="提交" onclick="add()"  /> -->
				<a id="btn" href="javascript:search()" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'">查询</a>
			</form>
		</div>
		<table id="allInfo"></table>
	</body>
</html>
