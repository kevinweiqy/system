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
    <script type="text/javascript" src="<%=path%>/xuesheng/student.js"></script>
    <!-- 国际化要放在jquery之后 -->
    <script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
   	

	
  </head>
  
  <body> <!--class="easyui-layout" fit="true" style="overflow: hidden;">-->
    
	   <form id="selectid" action="" >
	   <table>
	   <tr>
       <td>学生学号:</td>
       <td><input type="text" name="student.studentNumber" /></td>
       <td>学生名称:</td>
       <td><input type="text" name="student.studnetname" /></td>
       <td><input type="button" name="bun" value="查询" onclick="chaxun()"/></td>
       </tr>  
	   </table>
	   </form>
			
	  
    
  
  
    <table id="list"></table>
    <div id="addWin" style="text-align:center;">
      <form id="addForm" action="">
           
		         学生学号：<input type="text" name="student.studentNumber" class="easyui-validatebox" data-options="validType:'length[5,15]'" required="true" data-options="required:true"/><br/>
		         学生姓名：<input type="text" name="student.studentname" class="easyui-validatebox" data-options="validType:'length[5,15]'" required="true" data-options="required:true"/><br/>
		        学生班级：<input type="text" name="myClassid" class="easyui-validatebox" data-options="validType:'length[5,15]'"/><br/>    
		         学生性别：<input type="text" name="student.sex" class="easyui-validatebox" data-options="validType:'length[5,15]'"/><br/>
		         学生密码：<input type="text" name="student.studentpassword" class="easyui-validatebox" data-options="validType:'length[5,15]'"/><br/>
		         注册日期：<input type="text" name="student.registerdate" class="easyui-validatebox" data-options="validType:'length[5,15]'"/><br/>
		         
		         <input type="button" name="bt" value="保存" onclick="add()" />
         </form>
    </div> 
    
    
     <div id="editWin" style="text-align:center;">
      <form id="editForm" action="">
<!--学生编号：  -->  <input type="hidden" name="student.id"/><br/>
<!--学生学号：  -->  <input type="hidden" name="student.studentNumber" value=""/><br/>
		     学生姓名：<input type="text" name="student.studentname" class="easyui-validatebox" data-options="validType:'length[5,15]'"/><br/>
  		     学生班级：<input type="text" name="myClassid"/><br/>
		     学生性别 :<input type="text" name="student.sex" class="easyui-validatebox" data-options="validType:'length[5,15]'"/><br/>
		     学生密码：<input type="text" name="student.studentpassword" class="easyui-validatebox" data-options="validType:'length[5,15]'"/><br/>
<!--注册日期： -->  <input type="hidden" name="student.registerdate" class="easyui-validatebox" data-options="validType:'length[5,15]'"/><br/>
	     <input type="button" name="btn" value="保存" onclick="update()"/>
      </form>
     </div> 
  </body>
</html>
