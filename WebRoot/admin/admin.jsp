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

		<title>教师用户列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/themes/icon.css">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/themes/style.css">
		<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js">
</script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery.easyui.min.js">
</script>
		<script type="text/javascript"
			src="<%=path%>/js/easyui-lang-zh_CN.js">
</script>
		<script type="text/javascript" src="<%=path%>/admin/admin.js">
</script>
		<script type="text/javascript">
$(function() {
	$('#mycode').combogrid( {
		panelWidth : 450,
		idField : 'id',
		mode : 'remote',
		textField : 'name',
		url : 'sys/getGoodsList.action',
		columns : [ [ {
			field : 'code',
			title : '教师编号',
			width : 60
		}, {
			field : 'name',
			title : '教师名称',
			width : 100
		}, ] ]
	});
});
</script>
	</head>
	<body class="easyui-layout" fit="true" style="overflow: hidden;">
		<div  >
			<form action="" method="post" id="addYhJs">
				<table align="center">
			<tr align="center"><td colspan="4">为用户添加角色</td></tr>
			<tr>
				<td>
					选择教师
				</td>
				<td>
					<input id="admin" name="aid"/>  		
				</td>
				<td>
					选择角色
				</td>		
				<td>	
					<input id="jx" name="jid"/>  	
				</td>
			</tr>
					<tr align="center">
						<td colspan="4">
						<a href="javascript:addYonghujuese()" class="easyui-linkbutton"
								data-options="iconCls:'icon-save'">添加</a>
							<input type="button" value="查看該用戶角色信息" onclick="selectJx()"/>
						</td>
					</tr>
				</table>
				</form>
			</div>
		<div id="container">
		<table id="list"></table>		
		</div>
		<div id="add_zone" iconCls="icon-save"
			title="添加教师------为确保信息完整性，所有字段都必须填写">
			<form id="addAdmin" action="" method="post">
				<table width="99%" border="0" align="center" cellpadding="3"
					cellspacing="1" class="table_style">
					<tr>
						<td width="18%" class="left_title_1">
							<span class="left-title">教师登录账号</span>
						</td>
						<td width="82%">
							<input type="text" name="admin.admin_number" required/>
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							密码
						</td>
						<td>
							<input type="text" name="admin.admin_password" required/>
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							姓名
						</td>
						<td>
							<input type="text" name="admin.admin_name" required/>
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							专业
						</td>
						<td>
							<input type="text" name="admin.specialty" required/>
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							邮箱
						</td>
						<td>
							<input type="text" name="admin.email" required/>
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							联系电话
						</td>
						<td>
							<input type="text" name="admin.phone" required/>
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							在职状态
						</td>
						<td>
							<select name="admin.status">
								<option value="1" selected="selected">
									在职
								</option>
								<option value="0">
									离职
								</option>
							</select>
						</td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td colspan="2" align="center">
							<a href="javascript:addAdmin()" class="easyui-linkbutton"
								data-options="iconCls:'icon-save'">保存</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="edit_zone" iconCls="icon-save" title="编辑商品">
			<form id="editAdmin" action="" method="post">
				<table width="99%" border="0" align="center" cellpadding="3"
					cellspacing="1" class="table_style">
					<input type="hidden" id="adminid" name="admin.id" value="" />
					<tr>
						<td width="18%" class="left_title_1">
							<span class="left-title">教师登录账号</span>
						</td>
						<td width="82%">
							<input type="text" name="admin.admin_number" />
						</td>
					</tr>
					<tr>
						<td class="left_title_2">
							密码
						</td>
						<td>
							<input type="text" name="admin.admin_password" />
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							姓名
						</td>
						<td>
							<input type="text" name="admin.admin_name" />
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							专业
						</td>
						<td>
							<input type="text" name="admin.specialty" />
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							邮箱
						</td>
						<td>
							<input type="text" name="admin.email" />
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							联系电话
						</td>
						<td>
							<input type="text" name="admin.phone" />
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							在职状态
						</td>
						<td>
							<select name="admin.status">
								<option value="1">
									在职
								</option>
								<option value="0">
									离职
								</option>
							</select>
						</td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td colspan="2" align="center">
							<a href="javascript:updateObj()" class="easyui-linkbutton"
								data-options="iconCls:'icon-save'">更新</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="yhjs" iconCls="icon-save" title="用户角色信息">
			<table id="yonghujuese"></table>	
		</div>
	</body>
</html>
