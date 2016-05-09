$(function() {
	$("#list")
			.datagrid(
					{
						title : "教师列表",
						iconCls : 'icon-save',
						url : "admin/getAdminByPage.action",
						method : "post",
						loadMsg : "加载数据中，请稍后",
						fitColumns : true,
						rownumbers : true,
						queryParams : {
							optype : "query"
						},
						pagination : true,
						pageList : [ 4, 8, 12, 20 ],
						pageSize : 10,
						// frozenColumns : [ [ {
						// field : 'ck',
						// checkbox : true,
						// height:50
						// } ] ],
						
						columns : [ [ {
							field : 'ck',
							checkbox : true,
							height:20,
						}, {
							field : 'id',
							title : '主键',
							hidden : true,
							width : 10,
						
							align : "center"
						}, {
							field : 'admin_number',
							title : '教师登录账号',
							width : 80,
						
							align : "center"
						}, {
							field : 'admin_name',
							title : '名字',
							width : 60,
							align : "center"
						}, {
							field : 'admin_password',
							title : '登录密码',
							width : 80,
							align : "center"
						}, {
							field : 'specialty',
							title : '专业',
							width : 60,
							align : "center"
						}, {
							field : 'email',
							title : '邮箱',
							width : 100,
							align : "center"
						}, {
							field : 'phone',
							title : '联系电话',
							width : 80,
							align : "center"
						}, {
							field : 'status',
							title : '在职状态',
							width : 60,
							align : "center"
						}, {
							field : 'op',
							title : '操作',
							width : 100,
							align : "center",
							formatter : options
						} ] ],
						toolbar : [ {
							id : 'btnadd',
							text : '添加',
							iconCls : 'icon-add',
							handler : function() {
								$('#add_zone').window('open'); // 打开窗口
						}
						}],
						onLoadSuccess : function(data) {
							$(".edit-linkbutton").linkbutton( {
								text : '编辑',
								plain : true,
								iconCls : 'icon-edit'
							});
							$(".delete-linkbutton").linkbutton( {
								text : '删除',
								plain : true,
								iconCls : 'icon-remove'
							});
							var opts = $(this).datagrid('options');
							if (opts.rownumbers) {
								var dgPanel = $(this).datagrid('getPanel');
								var tdRownumber = dgPanel.find(
										'.datagrid-header-rownumber').parent();
								var hasFrozenColumns = $(this).datagrid(
										'getColumnFields', true);
								if (hasFrozenColumns.length) {
									var dgView2 = dgPanel
											.find('.datagrid-view2');
									var trCount = dgView2
											.find('.datagrid-header tr').length;

									tdRownumber.attr('rowspan', trCount);
								}
							}
						}
					});

	$('#mydate').datetimebox( {

		showSeconds : false

	});
	// 添加的窗口
	$('#add_zone').window( {
		width : 600,
		height : 400,
		modal : false
	});

	$('#add_zone').window('close'); // close window
	// 编辑的窗口
	$('#edit_zone').window( {
		width : 600,
		height : 400,
		modal : false
	});

	$('#edit_zone').window('close'); // close window
	
		//删除用户角色的窗口
	$('#yhjs').window( {
		width : 600,
		height : 400,
		modal : false
	});

	$('#yhjs').window('close'); // close window
	
	
	$('#admin').combogrid({    
    panelWidth:280,    
    value:'1',     
    idField:'id',    
    textField:'id',    
    url:'admin/getAdminAllAction.action',    
    columns:[[    
        {field:'id',title:'id',width:60},    
        {field:'admin_number',title:'登录账号',width:100},    
        {field:'admin_name',title:'名字',width:120},    
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
        {field:'js_name',title:'角色名称',width:120},
    ]]    
});
	

})

function ap(value, row, index) {
	// 编辑就传一个对象过去
	return '<a href="javascript:deleteJuse(\'' + row.id + '\')">删除</a>';
}


// 批量选中记录
function getSelections() {
	var ids = [];
	// 获取被选中的所有的行记录对象数组
	var rows = $("#list").datagrid("getSelections");
	for ( var i = 0; i < rows.length; i++) {
		ids.push(rows[i].sno);
	}
	/*
	 * var ids = ""; $.each(rows,function(i,obj){ ids=ids+obj.sno+","; });
	 */
	// alert(ids.join(','));
	return ids.join(',');

}
/*
 * var showAddr = function(v,rowData,rowIndex){ return
 * rowData.addr.city+rowData.addr.no; }
 */
// 操作的选项
var options = function(v, rowData, rowIndex) {
	var str = '<a href="javascript:editObj(' + rowData.id + ')" class="edit-linkbutton" >编辑</a>';
	str = str + '<a href="javascript:deleteObj(' + rowData.id
			+ ')" class="delete-linkbutton"></a>';
	return str;
}
// 编辑填充内容
function editObj(id) {
	$.ajax( {
		url : "admin/getAdminAction.action",
		type : "post",
		data : "admin.id=" + id,
		dataType : "json",
		success : function(data) {		
		// 填充表单
		$("input[name='admin.id']").val(id);
		$("input[name='admin.admin_number']").val(data.admin_number);
		$("input[name='admin.admin_name']").val(data.admin_name);
		$("input[name='admin.admin_password']").val(data.admin_password);
		$("input[name='admin.specialty']").val(data.specialty);
		$("input[name='admin.email']").val(data.email);
		$("input[name='admin.phone']").val(data.phone);
		$("select[name='admin.status']").val(data.status);
		$('#edit_zone').window('open'); // close window

}
	});
	//	
	//	
}
// 删除的js操作
function deleteObj(id) {
	$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
		
		if (r) {
			$.ajax( {
				url : "admin/deleteAdminAction.action",
				type : "post",
				data : "admin.id=" + id,
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
//查看角色，打开窗口。填充数据
function selectJx(){
	var formData = $("#addYhJs").serialize();
	$('#yhjs').window('open'); 
		$("#yonghujuese").datagrid({
			title : "用户角色列表",
			iconCls : 'icon-save',
			url : "yhjs/selectYhJsAction.action",
			queryParams : {
				formData : formData
			},
			method : "post",
			loadMsg : "加载数据中，请稍后",
			fitColumns : true,
			rownumbers : true,
			columns:[[    
		        {field:'id',title:'id',width:60},    
		        {field:'js_no',title:'编号',width:60},    
		        {field:'js_name',title:'角色名',width:80,align:'right'}, {
									field : 'ap',
									title : '操作',
									width : 80,
									align : 'center',
									formatter : ap
								}
    		]] 
		});
}

// 添加的操作
function addAdmin() {
	var formData = $("#addAdmin").serialize();
	$.ajax( {
		url : "admin/addAdminAction.action",
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
		$("#list").datagrid("load"); // 刷新列表
	}
	});
}
//添加用户角色
function addYonghujuese() {
	var formData = $("#addYhJs").serialize();
	
	$.ajax( {
		url : "yhjs/addYhJsAction.action",
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

// 删除用户角色的操作
function deleteJuse(jid) {
	var formData = $("#addYhJs").serialize();
	$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {		
		if (r) {
			$.ajax( {
				url : "yhjs/deleteYhJsAction.action",
				type : "post",
				data :{"jid":jid,"formData":formData},
				dataType : "json",
				success : function(data) {
					// 删除成功的提示
				if (data.flag == 1) {
					alert("删除成功");
				} else if (data.flag == 0) {
					alert("删除失败，请检查操作");
				}
				$("#yonghujuese").datagrid("load"); // 刷新列表
			}
			});
		}
	});
}
// 更新的操作
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
			} else if (data.flag == 0) {
				alert("更新失败，请检查操作");
			}
			$('#edit_zone').window('close'); // close window
		$("#list").datagrid("load"); // 刷新列表
	}
	});
}
// 查询的js操作
function query() {
	var arrays = $("#query").serializeArray();
	var obj = {}; // 定义一个空的对象
	$.each(arrays, function(i, n){
		obj[n.name] = n.value;
	});
	// alert(obj);
	// 重新发送一次请求，重新装载这个列表
	$("#list").datagrid("load", obj);
}