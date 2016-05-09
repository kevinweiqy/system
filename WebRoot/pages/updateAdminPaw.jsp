<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改口令</title>
    
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
	<script type="text/javascript">
		function updateObj() {
	var formData = $("#editAdmin").serialize();
	$.ajax( {
		url : "admin/updateAdminAction.action",
		type : "post",
		data : formData,
		dataType : "json",
		success : function(data) {
			if (data.flag == 1) {
				alert("更新成功");
				window.location.href="<%=path%>/";
			} else if (data.flag == 0) {
				alert("更新失败，请检查操作");
			}
			$('#ss').window('close'); // close window
	}
	});
}		
	</script>
  </head>
  
  <body>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/>
  	<h1 align="center">教师密码修改</h1>
  	<hr/>
  	<form action="" align="center" method="post" id="editAdmin" name="editAdmin"> 	
		<table width="99%" border="0" align="center" cellpadding="3"
					cellspacing="1" class="table_style" id="ss">
					<input type="hidden" id="adminid" name="admin.id" value="${Admin.id}" />
					<tr>
						<td width="18%" class="left_title_1">
							<span class="left-title">教师登录账号</span>
						</td>
						<td width="82%">
							<input type="text" name="admin.admin_number" value="${Admin.admin_number}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td class="left_title_2" >
							密码
						</td>
						<td>
							<input type="text" name="admin.admin_password" value="${Admin.admin_password}"/><span style="COLOR: #880000">在这里重新输入密码</span>
						</td>
					</tr>
					<tr>
						<td class="left_title_1" >
							姓名
						</td>
						<td>
							<input type="text" name="admin.admin_name" value="${Admin.admin_name}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							专业
						</td>
						<td>
							<input type="text" name="admin.specialty" value="${Admin.specialty}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							邮箱
						</td>
						<td>
							<input type="text" name="admin.email" value="${Admin.email}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							联系电话
						</td>
						<td>
							<input type="text" name="admin.phone" value="${Admin.phone}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							在职状态
						</td>
						<td>
							<input type="text" name="admin.status" value="${Admin.status}" readonly="readonly"/>
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
    
  </body>
</html>
