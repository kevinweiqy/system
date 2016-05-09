<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试成绩页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=path %>/themes/default/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=path %>/themes/icon.css" type="text/css"></link>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js"></script>

	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<%--中文放在easyui之后	--%>
	<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path%>/testScore/TestScore.js"></script>
	

  </head>
  
  <body>
        <table id="list"></table>
     <div id="addWin" style="text-align:center;">
      <form id="addForm" action="">
		        试卷&nbsp;&nbsp;ID：<input type="text" name="paperid"/><br/>
		         学生&nbsp;&nbsp;ID：<input type="text" name="studentid"/><br/>
		          成&nbsp;&nbsp;&nbsp;&nbsp;绩：<input type="text" name="testScore.score"/><br/>
		        
		        是否补考：<input type="text" name="testScore.pass"/><br/>
		           补考成绩：<input type="text" name="testScore.buScore"/><br/>
		           是否通过：<input type="text" name="testScore.isPass"/><br/>
		         说&nbsp;&nbsp;&nbsp;&nbsp;明：<input type="text" name="testScore.detail"/><br/>

         <a id="btn" href="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">保存</a>
      </form>
    </div> 
    
     <div id="editWin" style="text-align:center;">
      <form id="editForm" action="">
           <input type="hidden" name="testScore.id" /><br/>
                                 试卷&nbsp;&nbsp;ID：<input type="text" name="testScore.tp" readonly="true"/><br/>
		         学生&nbsp;&nbsp;ID：<input type="text" name="testScore.stu" readonly="true"/><br/>   
		         成&nbsp;&nbsp;&nbsp;&nbsp;绩：<input type="text" name="testScore.score"/><br/>
		      
		         是否补考：<input type="text" name="testScore.pass"/><br/>
		          补考成绩：<input type="text" name="testScore.buScore"/><br/>
		          是否通过：<input type="text" name="testScore.isPass"/><br/>
         <a id="btn" href="javascript:update()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>
      </form>
    </div> 
  </body>
</html>
