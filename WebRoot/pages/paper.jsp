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
		<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/paper.js"></script>
		<!-- 国际化要放在jquery之后 -->
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
	
	    <style type="text/css">
	        
	    </style>
	</head>

	<body>
		<form id="query" action="">
			<table>
				<tr>
					<td>
						试卷编号:
					</td>
					<td>
						<input type="text" name="tp.examination_no" />
					</td>			
					
					<td>
						<input type="button" name="bun" value="查询" onclick="shuaxin()" />
					</td>
				</tr>
			</table>
		</form>
		<table id="list"></table>
		<div id="addWin" style="text-align: center;">
			<form id="addForm" action="">
					试&nbsp;&nbsp;卷&nbsp;&nbsp;编&nbsp;&nbsp;号:<input type="text" name="tp.examination_no" /><br/>
					判&nbsp;&nbsp;断&nbsp;&nbsp;题&nbsp;&nbsp;数:<input type="text" name="tp.rightorwrong_number" /><br/>
					判断题每题分数:<input type="text" name="tp.rightorwrong_score" /><br/>
					选&nbsp;&nbsp;择&nbsp;&nbsp;题&nbsp;&nbsp;数:<input type="text" name="tp.select_number" /><br/>
					选&nbsp;择&nbsp;题&nbsp;分&nbsp;数:<input type="text" name="tp.select_score" /><br/>
					多&nbsp;选&nbsp;择&nbsp;题&nbsp;数:<input type="text" name="tp.selects_number" /><br/>
					多选择题&nbsp;分&nbsp;数:<input type="text" name="tp.selects_score" /><br/>
					设置&nbsp;出卷&nbsp;日期:<input type="text" name="setupDateTest" /><br/>
					考试&nbsp;开始&nbsp;时间:<input type="text" name="startTime" /><br/>
					考试&nbsp;结束&nbsp;时间:<input type="text" name="endTime" /><br/>
					出卷&nbsp;&nbsp;老师&nbsp;&nbsp;id:<input type="text" name="teacherid" /><br/>
					试&nbsp;&nbsp;卷&nbsp;&nbsp;说&nbsp;&nbsp;明:<input type="text" name="tp.detail" /><br/>
					试&nbsp;&nbsp;卷&nbsp;&nbsp;类&nbsp;&nbsp;型:<input type="text" name="tp.test_type" /><br/>
					合&nbsp;&nbsp;格&nbsp;&nbsp;分&nbsp;&nbsp;数:<input type="text" name="tp.pass_score" />
				<br/>
				<input type="button" name="btn" value="提交" onclick="add()" />
			</form>
		</div>
		
		
		
		
	<!--   添加考试班级 ----------------------------------------------------------- -->	
		  <div id="addTestClassWin"  >
			<form id="addTestClassForm" action="">
		             试卷编号:<input type="text" name="tp.id" /><br/>
                                   班级编号:<input type="text" name="myClass.classNumber" /><br/>
			<input type="button" name="btn" value="提交" onclick="addTestClass()" />
			</form>
		  </div>
	
	<!--   添加考试班级 --------------------------------------------------------------->	
	
	
	
	
	
		<div id="editWin" style="text-align: center;">
			<form id="editForm" action="">
				<input type="hidden" name="tp.id" /><br/>
				             试&nbsp;&nbsp;卷&nbsp;&nbsp;编&nbsp;&nbsp;号:<input type="text" name="tp.examination_no" /><br/>
					判&nbsp;&nbsp;断&nbsp;&nbsp;题&nbsp;&nbsp;数:<input type="text" name="tp.rightorwrong_number" /><br/>
					判断题每题分数:<input type="text" name="tp.rightorwrong_score" /><br/>
					选&nbsp;&nbsp;择&nbsp;&nbsp;题&nbsp;&nbsp;数:<input type="text" name="tp.select_number" /><br/>
					选&nbsp;择&nbsp;题&nbsp;分&nbsp;数:<input type="text" name="tp.select_score" /><br/>
					多&nbsp;选&nbsp;择&nbsp;题&nbsp;数:<input type="text" name="tp.selects_number" /><br/>
					多选择题&nbsp;分&nbsp;数:<input type="text" name="tp.selects_score" /><br/>
					时间日期格式是yyyy-MM-dd HH:mm:ss<br/>
					设置&nbsp;出卷&nbsp;日期:<input type="text" name="setupDateTest" /><br/>
					考试&nbsp;开始&nbsp;时间:<input type="text" name="startTime" /><br/>
					考试&nbsp;结束&nbsp;时间:<input type="text" name="endTime" /><br/>
					出卷&nbsp;&nbsp;老师&nbsp;&nbsp;id:<input type="text" name="teacherid" /><br/>
					试&nbsp;&nbsp;卷&nbsp;&nbsp;说&nbsp;&nbsp;明:<input type="text" name="tp.detail" /><br/>
					试&nbsp;&nbsp;卷&nbsp;&nbsp;类&nbsp;&nbsp;型:<input type="text" name="tp.test_type" /><br/>
					合&nbsp;&nbsp;格&nbsp;&nbsp;分&nbsp;&nbsp;数:<input type="text" name="tp.pass_score" />
				<br/>
				<a id="btn" href="javascript:update()" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">更新</a>
			</form>
		</div>
		
		
		<!--可选择的题目信息-->
		<div id="s1">
		  <table id="selectsource"></table>
		</div>
		
		<div id="s2">
		  <table id="duoselects"></table>
		</div>
		
	    <div id="s3">
		  <table id="panduansource"></table>
		</div>
		
		
		<!--试卷的详细信息--><br/><br/><br/>
		<div id="quan" style="width:800px;">
		<table width="100%"  id="xia">
		
		<tr><td>		
		<div id="d">
		  <table id="dan"></table>
		</div></td></tr>
		<tr><td>
		<div id="p">
		  <table id="pan"></table>
		</div></td></tr>		
		<tr><td>
		<div id="many">
		  <table id="duo"></table>
		</div></td></tr>
		<tr><td><input type="button" name="btnshiti" value="保存" onclick="javascript:baocun()">			
		</td></tr>		
		</table>
		</div>
	</body>
</html>
