$(function() {// 文档加载完成以后，执行代码
$("#list").datagrid({
title : "学生成绩信息列表",
// 数据来源
url : "testscore/getTestScores.action",
	width : "830px",
	height : "380px",
	method : "post",
	loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
	rownumbers : true,
	pagination : true, // 显示分页效果
	columns : [[
		{field : 'id',title : '编号',width : 100,align : 'center'}, 
		{field : 'tp',title : '试卷id',width : 100,align : 'center',
		formatter : function formatCategory(value) {
			       if (value != null) {
				   return value.id;
			    	}}},
		{field : 'stu',title : '学生id',width : 100,align : 'center',
		formatter : function formatCategory(value) {
			       if (value != null) {
				   return value.id;
			    	}}},
	   {field : 'score',title : '成绩',width : 100,align : 'center'}, 
       {field : 'pass',title : '是否补考',width : 100,align : 'center'}, 
	   {field : 'buScore',title : '补考成绩',width : 100,align : 'center'}, 
	   {field : 'examinationdate',title : '考试日期',width : 100,align : 'center'
	        ,formatter : function(value) {
				if (value != null) {
				var JsonDateValue = new Date(value.time);
				var text = JsonDateValue.toLocaleString();
				return text;
				}}}, 
       {field : 'isPass',title : '是否及格',width : 100,align : 'center'}, 
       {field : 'detail',title : '说明',width : 100,align : 'center'} 				
	   
				]]
					})
					  })
			