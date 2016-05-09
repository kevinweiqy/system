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
		<script type="text/javascript" src="<%=path%>/shiti/rightorwrong.js">
</script>
		<!-- 国际化要放在jquery之后 -->
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js">
</script>
	</head>

	<body>
		<table id="list"></table>
		<div id="addWin" style="text-align: center;">
			<form id="addForm" action="">
				试题编号：
				<input type="text" name="rightorwrong.shiti_code" />
				<br />
				试题内容：
				<input type="text" name="rightorwrong.neirong" />
				<br />
				答案:
				<input type="text" name="rightorwrong.answer">
				<br />
				老师编号:
				<select name="rightorwrong.teacherid">
					<option value="1" selected="selected">
						1
					</option>
				</select>
				<br />
				<input type="text" name="rightorwrong.type" value="1"
					style="display: none" />
				<br />
				<input type="text" name="rightorwrong.sctupdate" value=""
					style="display: none" />
				<br />
				<!--  <input type="button" name="btn" value="提交" onclick="add()"  /> -->
				<a id="btn" href="javascript:add()" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'">保存</a>
			</form>
		</div>
		<div id="editWin" style="text-align: center;">
			<form id="editForm" action="">
				试题编号：
				<input type="text" name="rightorwrong.shiti_code" />
				<br />
				试题内容：
				<input type="text" name="rightorwrong.neirong" />
				<br />
				答案:
				<input type="text" name="rightorwrong.answer">
				<br />
				老师编号:
				<select name="rightorwrong.teacherid">
					<option value="1" selected="selected">
						1
					</option>
				</select>
				<br />
				<input type="text" name="rightorwrong.id" value=""
					style="display: none" />
				<br />
				<input type="text" name="rightorwrong.type" value="1"
					style="display: none" />
				<br />
				<input type="text" name="rightorwrong.sctupdate" value=""
					style="display: none" />
				<br />
				<!-- <div id="selects" style="display: none;">
		                                            选项1:<input type="text" name="shiTi.result1"><br/>
		                                            选项2:<input type="text" name="shiTi.result2"><br/>
		                                            选项3:<input type="text" name="shiTi.result3"><br/>
		                                            选项4:<input type="text" name="shiTi.result4"><br/>
		                                               类型:<select name="shiTi.selectType">
		                           <option value="" selected="selected">请选择选择题类型</option>
		                           <option value="1">单选题</option>
		                           <option value="2">多选题</option>
		                       </select><br/>
		                                               答案:<input type="text" name="shiTi.answer"><br/>
		                                     老师编号:<select name="shiTi.teacherid">
		                           <option value="1" selected="selected">1</option>         
		                      </select>
		             </div> -->
				<a id="btn" href="javascript:update()" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">更新</a>
			</form>
		</div>
		<div id="searchWin" style="text-align: center;">
			<form id="searchForm" action="">
				试题编号：
				<input type="text" name="rightorwrong.shiti_code" />
				<br />
				试题内容：
				<input type="text" name="rightorwrong.neirong" />
				<br />
				<input type="text" name="rightorwrong.type" value="1"
					style="display: none" />
				<br />
				<!--  <input type="button" name="btn" value="提交" onclick="add()"  /> -->
				<a id="btn" href="javascript:search()" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'">查询</a>
			</form>
		</div>
		<div id="addMWin">
		   <table id="addMany"></table>
		</div>
		<div id="addManyWin" style="text-align: center;">
		    <form id="addManyForm" action="">
				试题编号：
				<input type="text" name="rightorwrong.shiti_code" />
				<br />
				试题内容：
				<input type="text" name="rightorwrong.neirong" />
				<br />
				答案:
				<input type="text" name="rightorwrong.answer">
				<br />
				老师编号:
				<input type="text" name="rightorwrong.teacherid" value="1">
				<br />
				<input type="text" name="rightorwrong.type" value="1"
					style="display: none" />
				<br />
				<input type="text" name="rightorwrong.sctupdate" value=""
					style="display: none" />
				<br />
				<!--  <input type="button" name="btn" value="提交" onclick="add()"  /> -->
				<a id="btn" href="javascript:addMany()" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'">增加下一个</a>
		        
		    </form>
		</div>
	</body>
</html>
