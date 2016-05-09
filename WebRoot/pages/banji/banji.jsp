<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'banji.jsp' starting page</title>
    
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
    <script type="text/javascript" src="<%=path%>/pages/banji/banji.js"></script>
    <!-- 国际化要放在jquery之后 -->
    <script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
    </head>

  </head>
  
  <body>
  welcome to myclass js page. <br>
    <form id="selectClass" action="">
    <table >
    <tr>
       <td>班级编号:</td>
       <td><input type="text" name="myClass.classNumber" /></td>
         <!-- <td>班级名称:</td>
       <td><input type="text" name="myClass.className" /></td>-->
       <td><input type="button" name="bun" value="查询" onclick="shuaxin()"/></td>
    </tr>  
    </table>
    </form>
  <!-- 添加班级信息 -->
  <table id="list"></table>
  <div id="addWin" style="text-align:center;">
     <form id="addForm" action="">
                  <input type="hidden" name="myClass.id" /><br/>  
                                班级编号：<input type="text" name="myClass.classNumber" class="easyui-validatebox" data-options="validType:'length[5,15]'" required="true" data-options="required:true"/><br/>
		          班级名字：<input type="text" name="myClass.className" class="easyui-validatebox" data-options="validType:'length[5,15]'" required="true" data-options="required:true"/><br/>
		          专业名称：<input type="text" name="myClass.major" class="easyui-validatebox" data-options="validType:'length[5,15]'"/><br/>
         <a id="btn" href="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">保存</a>           
     </form>
  <!-- 班级信息更新编辑 -->
  </div>
    
     <div id="editWin" style="text-align:center;">
      <form id="editForm" action="">
                <input type="hidden" name="myClass.id" /><br/>
		          班级编号：<input type="text" name="myClass.classNumber" class="easyui-validatebox" data-options="validType:'length[5,15]'" required="true" data-options="required:true"/><br/>
		          班级名称：<input type="text" name="myClass.className" class="easyui-validatebox" data-options="validType:'length[5,15]'" required="true" data-options="required:true"/><br/>
		          专业名称：<input type="text" name="myClass.major"  class="easyui-validatebox" data-options="validType:'length[5,15]'" /><br/>
         <a id="btn" href="javascript:update()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>
      </form>
    </div> 
  
 
    
     
    
    
  </body>
</html>
