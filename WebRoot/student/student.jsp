<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="<%=path%>/themes/default/easyui.css" type="text/css"></link>    
    <link rel="stylesheet" href="<%=path%>/themes/icon.css" type="text/css"></link>
    <script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/student/student.js"></script>
    <!-- 国际化要放在jquery之后 -->
    <script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
   	
	</script>
	
  </head>
  
  <body class="easyui-layout" fit="true" style="overflow: hidden;">
    <div id="container">
		<div id="queryDiv">
			<form id="query" action="" method="post">
					<table width="100%" border="0" align="left" cellpadding="3"
						cellspacing="1" class="table_style">
						<tr>
							<td class="qText">
								<span class="left-title">学号</span>
							</td>
							<td>
								<input type="text" name="student.studentNumber" id="studentNumber" />
							</td>
							<td class="qText">
								<span class="left-title">学生姓名</span>
							</td>
							<td>
								<input type="text" name="student.studnetname" id="studentname" />
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="6" align="center">
								<a href="javascript:query()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<table id="list"></table>  
    </div>
  
    <table id="list"></table>
    <div id="addWin" style="text-align:center;">
      <form id="addForm" action="">
		        <input type="hidden" name="student.id" /><br/>
		         学生学号：<input type="text" name="student.studentNumber" /><br/>
		         学生姓名：<input type="text" name="student.studentname" /><br/>
		         学生班级：<input type="text" name="student.myClass" /><br/>
		         学生性别：<input type="text" name="student.sex" /><br/>
		         学生密码：<input type="text" name="student.studentpassword" /><br/>
		         注册日期：<input type="text" name="student.registerdate" /><br/>
          <!--  <input type="button" name="btn" value="提交" onclick="add()"  /> -->
         <input type="button" name="bt" value="保存" onclick="add()" />
      </form>
    </div> 
     <div id="editWin" style="text-align:center;">
      <form id="editForm" action="">
                 <input type="hidden" name="student.id" /><br/>
                 <input type="hidden" name="student.studentNumber" /><br/>
		         学生姓名：<input type="text" name="student.studentname" /><br/>
		         学生班级：<input type="text" name="student.myClass" /><br/>
		     <input type="hidden" name="student.sex" /><br/>
		         学生密码：<input type="text" name="student.studentpassword" /><br/>
		         <input type="text" name="student.registerdate" value=""
					style="display: none"/><br/>
         <a id="btn" href="javascript:update()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>
      </form>
    </div> 
  </body>
</html>
