<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<script type="text/javascript" src="<%=path%>/quanxian/qx.js">
</script>
		<!-- 国际化要放在jquery之后 -->
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js">
</script>
	</head>

	<body>
		<table id="list"></table>
		<div id="addWin" style="text-align: center;">
			<form id="addForm" action="">
				编号：
				<input type="text" name="qx.qx_code" required/>
				<br />
				权限名称：
				<input type="text" name="qx.qx_name" required/>
				<br />
				权限路径：
				<input type="text" name="qx.qx_url" required/>
				<br />
				有没有上级权限：
				<input type="text" name="qx.menu" required/>
				<br />
				序号：
				<input type="text" name="qx.qx_sort" required/>
				<br />
				上级权限编号：
				<input type="text" name="qxid" />
				<br />
				使用状态状态：
				<select name="qx.state" >
					<option value=1>1启用</option>
					<option value=0>0禁用</option>
				</select>
				<br />
				<input type="button" name="btn" value="提交" onclick="add()" />
			</form>
		</div>
		<div id="editWin" style="text-align: center;">
			<form id="editForm" action="">
				<input type="hidden" name="qx.id" />
				编号：
				<input type="text" name="qx.qx_code" />
				<br />
				权限名称：
				<input type="text" name="qx.qx_name" />
				<br />
				权限路径：
				<input type="text" name="qx.qx_url" />
				<br />
				有没有上级权限：
				<select name="qx.menu" >
					<option value=1>1有</option>
					<option value=0>0没用</option>
				</select>
				<br />
				序号：
				<input type="text" name="qx.qx_sort" />
				<br />
				上级权限编号：
				<input type="text" name="qxid" />
				<br />
				使用状态状态：
				<select name="qx.state" >
					<option value=1>1启用</option>
					<option value=0>0禁用</option>
				</select>
				<br />
				<a id="btn" href="javascript:update()" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">更新</a>
			</form>
		</div>
	</body>
</html>
