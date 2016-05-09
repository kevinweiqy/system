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
		<script type="text/javascript" src="<%=path%>/juese/juese.js">
</script>
		<!-- 国际化要放在jquery之后 -->
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js">
</script>
	</head>

	<body>
	
		<div  >
			<form action="" method="post" id="addjsqxform">
				<table align="center">
			<tr align="center"><td colspan="4">为角色添加权限</td></tr>
			<tr>
				<td>
					选择角色
				</td>
				<td>
					<input id="jx" name="jid"/>  
					  		
				</td>
				<td>
					选择权限
				</td>		
				<td>	
					<input id="qx" name="qid"/>	
				</td>
			</tr>
					<tr align="center">
						<td colspan="4">
						<a href="javascript:addjsqx()" class="easyui-linkbutton"
								data-options="iconCls:'icon-save'">添加</a>
							<input type="button" value="查看该角色拥有权限" onclick="selectJx()"/>
						</td>
					</tr>
				</table>
				</form>
			</div>
		<table id="list"></table>
		<div id="addWin" style="text-align: center;">
			<form id="addForm" action="">
				编号：
				<input type="text" name="jx.js_no" required/>
				<br />
				姓名：
				<input type="text" name="jx.js_name" required/>
				<br />
				角色描述：
				<input type="text" name="jx.js_detail" required/>
				<br />
				使用状态状态：
				<select name="jx.js_status" >
					<option value=1>1启用</option>
					<option value=0>0禁用</option>
				</select>
				<br />
				<input type="button" name="btn" value="提交" onclick="add()" />
			</form>
		</div>
		<div id="editWin" style="text-align: center;">
			<form id="editForm" action="">
				<input type="hidden" name="jx.id" />
				<br />
				编号：
				<input type="text" name="jx.js_no" />
				<br />
				姓名：
				<input type="text" name="jx.js_name" />
				<br />
				角色描述：
				<input type="text" name="jx.js_detail" />
				<br />
				使用状态状态：
				<select name="jx.js_status" >
					<option value=1>1启用</option>
					<option value=0>0禁用</option>
				</select>
				<br />
				<a id="btn" href="javascript:update()" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">更新</a>
			</form>
		</div>
		<div id="jsqx" iconCls="icon-save" title="角色权限信息">
			<table id="jsqxlist"></table>	
		</div>
	</body>
</html>
