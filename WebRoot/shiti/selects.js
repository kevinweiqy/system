
$(function dous() {
			// 文档加载完成以后，执行代码
			$("#list").datagrid({
						title : "选择题信息列表",
						// 数据来源
						url : "shiti/getShiTiListByPage.action",
						queryParams : {
							
							"select.type" : 2
						},
						width : "900px",
						height : "500px",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						pagination : true, // 显示分页效果
						pageNumber : 1,
						pageSize : 15,
						pageList : [15, 30, 45, 60],
						columns : [[{
									field:"ck",
									checkbox:"true"
						        },{
									field : 'id',
									title : '试题ID',
									width : 50,
									align : 'center',
								   hidden : 'true'
								}, {
									field : 'shiti_code',
									title : '试题编号',
									width : 50,
									align : 'center'
								}, {
									field : 'neirong',
									title : '试题内容',
									width : 300,
									align : 'center'
								}, {
									field : 'type',
									title : '试题类型',
									width : 100,
									align : 'center',
									formatter : type
								}, {
									field : 'result1',
									title : '选项1',
									width : 100,
									align : 'center'
								}, {
									field : 'result2',
									title : '选项2',
									width : 100,
									align : 'center'
								}, {
									field : 'result3',
									title : '选项3',
									width : 100,
									align : 'center'
								}, {
									field : 'result4',
									title : '选项4',
									width : 100,
									align : 'center'
								}, {
									field : 'answer',
									title : '答案',
									width : 100,
									align : 'center'
								}, {
									field : 'sctupdate',
									title : '时间',
									width : 100,
									align : 'center',
							     formatter: date
								}, {
									field : 'teacherId',
									title : '老师',
									width : 100,
									align : 'center'
								}, {
									field : 'op',
									title : '操作',
									width : 100,
									align : 'center',
									formatter : op
								}]],
						toolbar : [{
									id : "add",
									text : "增加",
									iconCls : 'icon-add',
									handler : function() {
										$("#addWin").window("open");
									}
								},  {
									id : "add",
									text : "批量增加",
									iconCls : 'icon-add',
									handler : function() {
										$("#addMWin").window("open");
									}
								},  {
									id : "help",
									text : "查询",
									iconCls : 'icon-search',
									handler : function() {
										$("#searchWin").window("open");
									}
								}]

					});
			$('#addWin').window({
						title : "增加试题",
						width : 300,
						height : 400,
						modal : true,
						inline : false
					});
			// 关闭之前先把div渲染成窗口
			$("#addWin").window("close");

			$('#editWin').window({
						title : "修改信息",
						width : 260,
						height : 200,
						modal : true,
						inline : false
					});
			$("#editWin").window("close");
			$('#searchWin').window({
						title : "查询",
						width : 260,
						height : 200,
						modal : true,
						inline : false
					});
			$("#searchWin").window("close");
			$('#addMWin').window({
						title : "增加试题",
						width : 600,
						height : 400,
						modal : true,
						inline : false
					});
		    $("#addMWin").window("close");
		});
$(function(){
	$("#addMany").datagrid({
		    singleSelect : true,
	        columns : [[{
									field:"ck",
									checkbox:"true"
						        },{
									field : 'shiti_code',
									title : '试题编号',
									width : 50,
									align : 'center'
								}, {
									field : 'neirong',
									title : '试题内容',
									width : 300,
									align : 'center'
								}, {
									field : 'type',
									title : '试题类型',
									width : 100,
									align : 'center',
									formatter : type
								}, {
									field : 'result1',
									title : '选项1',
									width : 100,
									align : 'center'
								}, {
									field : 'result2',
									title : '选项2',
									width : 100,
									align : 'center'
								}, {
									field : 'result3',
									title : '选项3',
									width : 100,
									align : 'center'
								}, {
									field : 'result4',
									title : '选项4',
									width : 100,
									align : 'center'
								}, {
									field : 'answer',
									title : '答案',
									width : 100,
									align : 'center'
								}, {
									field : 'sctupdate',
									title : '时间',
									width : 100,
									align : 'center'
								}, {
									field : 'teacherId',
									title : '老师',
									width : 100,
									align : 'center'
								}, {
									field : 'op',
									title : '操作',
									width : 100,
									align : 'center',
									formatter : op2
								}]],
	                   toolbar : [  {
									id : "add",
									text : "增加",
									iconCls : 'icon-add',
									handler : function() {
										$("#addManyWin").window("open");
									}
									}, {
									id : "add",
									text : "批量增加",
									iconCls : 'icon-add',
									handler : addManyShiTi
									}]
	});
	$('#addManyWin').window({
						title : "增加试题",
						width : 300,
						height : 400,
						modal : true,
						inline : false
					});
	$("#addManyWin").window("close");
});
// 添加信息
function add() {
	// 获取表单数据
	var time = new Date();
	var mytime = time.toLocaleString();//获取当前时间
	$("input[name='select.sctupdate']").eq(0).val(mytime);
	var formData = $("#addForm").serialize();
	//"select.type" =num;
	// alert(formStr);
	$.ajax({
				url : "shiti/addShiTi.action",
//	    queryParams : {
//	    	                "rightorwrong.type" : 1,
//							"rightorwrong.sctupdate" : new Date()
//						},
				type : "post",
				data : formData,
				dataType : "json",

				success : function(data) {
					if (data.flag == 1) {
						// $.messager.progress();
						$.messager.alert('保存', '保存成功');
						/*
						 * $.messager.show({ title:'保存成功', msg:'消息将在4秒后关闭。',
						 * showType:'show', style:{ right:'',
						 * top:document.body.scrollTop+document.documentElement.scrollTop,
						 * bottom:'' } });
						 */
						$("#addWin").window("close");
						// 刷新后加载列表
						$("#list").datagrid("load");
					}
				}
			});
}
// 操作函数op
function op(value, row, index) {
	// 编辑就传一个对象过去
	return '<a href="javascript:deleteShiTi(\'' + row.id + '\')">删除</a>'
			+ '&nbsp;<a href="javascript:editShiTi(\'' + row.id + '\')">修改</a>';
}
// 操作函数op
function op2(value, row, index) {
	// 编辑就传一个对象过去
	return '<a href="javascript:deleteRow()">删除</a>'
			+ '&nbsp;<a href="javascript:editRow()">修改</a>';
}
//操作函数type
function type(value, row, index) {
	if(value==1){
		return '判断题';
	}else if(value==0){
		return '单选题';
	}else if(value==2){
		return '多选题';
	}
}
function date(value,rowData,rowIndex){
    if(value!=null){  
               var JsonDateValue=new Date(value.time);
	           var text=JsonDateValue.toLocaleString();
	           return text;
	           }
	}
// 异步请求删除方法
function deleteShiTi(id) {
	$.ajax({
				url : "shiti/deleteShiTi.action",
				type : "post",
				data : "select.id=" + id, // 传送的数据
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						$.messager.alert('删除', '删除成功');
						$("#list").datagrid("load");
					}
				}
			});
}

// 异步请求的编辑方法edit
function editShiTi(id) {
	$.ajax({
				url : "shiti/getShiti.action",
				type : "post",
				data : "select.id=" + id, // 传送的数据
				dataType : "json",
				success : function(data) {
					    $("input[name='select.shiti_code']").eq(1).val(data.shiti_code);
					    $("input[name='select.neirong']").eq(1).val(data.neirong);
					    $("input[name='select.result1']").eq(1).val(data.result1);
					    $("input[name='select.result2']").eq(1).val(data.result2);
					    $("input[name='select.result3']").eq(1).val(data.result3);
					    $("input[name='select.result4']").eq(1).val(data.result4);
					    $("input[name='select.answer']").eq(1).val(data.answer);
					    $("input[name='select.id']").eq(0).val(data.id);
						
						$("#editWin").window("open");
				}
			});		
}
// 删除本行数据
function deleteRow(){
	$("#addMany").datagrid("deleteRow",1);
}
//编辑本行数据
function editRow(){
	var row = $('#addMany').datagrid('getSelected');
	if(row){
		alert('shiti_code:'+row.shiti_code);
	}
}
// 更新的方法

function update() {
	var time = new Date();
	var mytime = time.toLocaleString();//获取当前时间
	$("input[name='select.sctupdate']").eq(1).val(mytime);
	// 获取表单数据
	var formData = $("#editForm").serialize();
	// alert(formStr);
	$.ajax({
				url : "shiti/updateShiTi.action",
				type : "post",
				data : formData,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						// $.messager.progress();
						$.messager.alert('保存', '保存成功');
						$("#editWin").window("close");
						// 刷新后加载列表
						$("#list").datagrid("load");
					}
				}
			});

}
function search() {
	var formArray = $("#searchForm").serializeArray();
	var obj={};//第一个空对象
	$.each(formArray,function(i,n){
		obj[n.name]=n.value;
	});
	$("#list").datagrid("load", obj);
}
function addMany() {
	// 获取表单数据
	var time = new Date();
	var mytime = time.toLocaleString();//获取当前时间
	$("input[name='select.sctupdate']").eq(2).val(mytime);
	var form = document.getElementById("addManyForm");
	var input = form.getElementsByTagName("input");
    $("#addMany").datagrid('insertRow',{
		      row : {
		      	shiti_code : input[0].value,
		      	neirong : input[1].value,
		      	result1 : input[2].value,
		      	result2 : input[3].value,
		      	result3 : input[4].value,
		      	result4 : input[5].value,
		      	answer : input[6].value,
		      	teacherid : input[7].value,
		      	type : input[8].value,
		      	sctupdate : input[9].value
		      }
    });
}
function addManyShiTi(){
	
}