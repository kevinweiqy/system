$(function() {
			// 文档加载完成以后，执行代码
			$("#list").datagrid({
						title : "角色列表",
						// 数据来源
						url : "juese/getJuSeByPage.action",
						queryParams : {
							
						},
						width : "650px",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						pagination : true, // 显示分页效果
						sort:{	        // 指定了排序顺序的列
							sortName: 'price',
							sortOrder: 'desc'
						},
						pageNumber : 3,
						pageSize : 5,
						pageList : [5,10,15,20],
						columns : [[{
									field : 'id',
									title : '编号',
									width : 100,
									align : 'center',
									hidden : 'true'
								}, {
									field : 'js_no',
									title : '角色编号',
									width : 100,
									align : 'center'
								}, {
									field : 'js_name',
									title : '角色名称',
									width : 100,
									align : 'center'
								},{
									field : 'js_detail',
									title : '角色描述',
									width : 100,
									align : 'center'
								},{
									field : 'js_status',
									title : '角色状态',
									width : 100,
									align : 'center'
								},{
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
								}, '-', {
									id : "help",
									text : "帮助",
									iconCls : 'icon-help',
									handler : function() {
										alert('帮助按钮')
									}
								}]
					});
			$('#addWin').window({
						title : "增加角色",
						width : 260,
						height : 200,
						modal : true,
						inline : false
					});
			// 关闭之前先把div渲染成窗口
			$("#addWin").window("close");
			$('#editWin').window({
						title : "编辑角色信息",
						width : 400,
						height : 400,
						modal : true,
						inline : false
					});
			$("#editWin").window("close");
		//删除角色权限的窗口
			$('#jsqx').window( {
				width : 600,
				height : 400,
				modal : false
			});
		
			$('#jsqx').window('close'); // close window
			
			
			
	$('#qx').combogrid({    
    panelWidth:260,    
    value:'1',     
    idField:'id',    
    textField:'id',    
    url:'qx/getQxAllAction.action',    
    columns:[[
        {field:'id',title:'id',width:60},    
        {field:'qx_name',title:'权限名称',width:120},    
        {field:'menu',title:'是否菜单',width:80}  
    ]]    
});
		$('#jx').combogrid({    
    panelWidth:280,    
    value:'1',     
    idField:'id',    
    textField:'id',    
    url:'juese/getAllJx.action',    
    columns:[[    
        {field:'id',title:'id',width:60},    
        {field:'js_no',title:'角色编号',width:100},    
        {field:'js_name',title:'角色名称',width:120}
    ]]    
});
	
		});

// 添加信息
function add() {
	// 获取表单数据
	var formData = $("#addForm").serialize();
	$.ajax({
				url : "juese/addJuSeAction.action",
				type : "post",
				data : formData,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						$.messager.alert('保存', '保存成功');
						$("#addWin").window("close");
						// 刷新后加载列表
						$("#list").datagrid("load");
					}
				}
			});
}
//添加角色权限
function addjsqx() {
	var formData = $("#addjsqxform").serialize();
	
	$.ajax( {
		url : "jsqx/addJsQxAction.action",
		type : "post",
		data : formData,
		dataType : "json",
		success : function(data) {
			if (data.flag == 1) {
				alert("添加成功");
			} else if (data.flag == 0) {
				alert("添加失败，请检查操作");
			}
			$('#add_zone').window('close'); // close window
		//$("#list").datagrid("load"); // 刷新列表
	}
	});
}
// 操作函数op
function op(value, row, index) {
	// 编辑就传一个对象过去
	return '<a href="javascript:deleteRecords(\'' + row.id + '\')">删除</a>'
			+ '&nbsp;<a href="javascript:editRecords(\'' + row.id + '\')">编辑</a>';
}

// 异步请求删除的方法
function deleteRecords(id) {
	$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
		
		if (r) {
			$.ajax( {
				url : "juese/deleteJuSeAction.action",
				type : "post",
				data : "jx.id=" + id,
				dataType : "json",
				success : function(data) {
					// 删除成功的提示
				if (data.flag == 1) {
					alert("删除成功");
				} else if (data.flag == 0) {
					alert("删除失败，请检查操作");
				}
				$("#list").datagrid("load"); // 刷新列表
			}
			});
		}
	});

}
//查看权限，打开窗口。填充数据
function selectJx(){
	var formData = $("#addjsqxform").serialize();
	$('#jsqx').window('open'); 
		$("#jsqxlist").datagrid({
			title : "角色权限列表",
			iconCls : 'icon-save',
			url : "jsqx/selectJsQxAction.action",
			queryParams : {
				formData : formData
			},
			method : "post",
			loadMsg : "加载数据中，请稍后",
			fitColumns : true,
			rownumbers : true,
			columns:[[    
		        {field:'id',title:'id',width:60},    
		        {field:'qx_name',title:'编号',width:60},{
									field : 'ap',
									title : '操作',
									width : 80,
									align : 'center',
									formatter : ap
								}
    		]] 
		});
}
function ap(value, row, index) {
	// 编辑就传一个对象过去
	return '<a href="javascript:deleteQx(\'' + row.id + '\')">删除</a>';
}

// 删除角色权限
function deleteQx(qid) {
	var formData = $("#addjsqxform").serialize();
	$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {		
		if (r) {
			$.ajax( {
				url : "jsqx/deleteJsQxAction.action",
				type : "post",
				data :{"qid":qid,"formData":formData},
				dataType : "json",
				success : function(data) {
					// 删除成功的提示
				if (data.flag == 1) {
					alert("删除成功");
				} else if (data.flag == 0) {
					alert("删除失败，请检查操作");
				}
				$("#jsqxlist").datagrid("load"); // 刷新列表
			}
			});
		}
	});
}

function editRecords(id) {
	$.ajax({
				url : "juese/getJuSeAction.action",
				type : "post",
				data : "jx.id=" + id, // 传送的数据
				dataType : "json",
				success : function(data) {
					$("input[name='jx.id']").eq(0).val(id);
					$("input[name='jx.js_no']").eq(1).val(data.js_no);
					$("input[name='jx.js_name']").eq(1).val(data.js_name);
					$("input[name='jx.js_detail']").eq(1).val(data.js_detail);
					$("select[name='jx.js_status']").val(data.js_status);
					$("#editWin").window("open");
				}
			});
}

function update() {
	// 获取表单数据
	var formData = $("#editForm").serialize();
	// alert(formStr);
	$.ajax({
				url : "juese/updateJuSeAction.action",
				type : "post",
				data : formData,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						//$.messager.progress();
						$.messager.alert('保存', '更新成功');
						$("#editWin").window("close");
						//刷新后加载列表
						$("#list").datagrid("load");
					}
				}
			});
}

//条件查询
function shuaxin() {
	var formArray = $("#query").serializeArray(); //表单数组
	var obj = {};//定义一个空对象
	$.each(formArray, function(i, n) {
				obj[n.name] = n.value;
			})
	$("#list").datagrid("load", obj);
}
