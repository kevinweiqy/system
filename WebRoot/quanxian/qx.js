$(function() {
			// 文档加载完成以后，执行代码
			$("#list").datagrid({
						title : "权限列表",
						// 数据来源
						url : "qx/getQxByPage.action",
						queryParams : {
							
						},
						width : "800px",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						pagination : true, // 显示分页效果
						sort:{	        // 指定了排序顺序的列
							sortName: 'price',
							sortOrder: 'desc'
						},
						pageNumber : 1,
						pageSize : 20,
						pageList : [10,20,30,40],
						columns : [[{
									field : 'id',
									title : '编号',
									width : 50,
									align : 'center',
									hidden : 'true'
								}, {
									field : 'qx_code',
									title : '权限编号',
									width : 70,
									align : 'center'
								}, {
									field : 'qx_name',
									title : '权限名称',
									width : 100,
									align : 'center'
								},{
									field : 'qx_url',
									title : '权限路径',
									width : 200,
									align : 'center'
								},{
									field : 'menu',
									title : '有没有上级权限',
									width : 100,
									align : 'center'
								},{
									field : 'qx_sort',
									title : '序号',
									width : 40,
									align : 'center'
								},{
									field : 'father',
								title : '上级权限名称',
								width : 100,
								align : 'center',
								formatter : function(value, row, index) {
									if (row.father!=null) {
										return row.father.qx_name;
									} else {
										return null;
									}
								}
								},{
									field : 'state',
									title : '使用状态',
									width : 60,
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
						width : 400,
						height : 300,
						modal : true,
						inline : false
					});
			// 关闭之前先把div渲染成窗口
			$("#addWin").window("close");
			$('#editWin').window({
						title : "编辑角色信息",
						width : 500,
						height : 400,
						modal : true,
						inline : false
					});
			$("#editWin").window("close");
		});

// 添加信息
function add() {
	// 获取表单数据
	var formData = $("#addForm").serialize();
	$.ajax({
				url : "qx/addQxAction.action",
				type : "post",
				data : formData,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						$.messager.alert('保存', '保存成功');
						$("#addWin").window("close");
						// 刷新后加载列表
						$("#list").datagrid("load");
					}else{						
						$.messager.alert('错误', '保存失败');
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
	return '<a href="javascript:deleteRecords(\'' + row.id + '\')">删除</a>'
			+ '&nbsp;<a href="javascript:editRecords(\'' + row.id + '\')">编辑</a>';
}

// 异步请求删除的方法
function deleteRecords(id) {
	$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
		
		if (r) {
			$.ajax( {
				url : "qx/deleteQxAction.action",
				type : "post",
				data : "qx.id=" + id,
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

function editRecords(id) {
	$.ajax({
				url : "qx/getQxAction.action",
				type : "post",
				data : "qx.id=" + id, // 传送的数据
				dataType : "json",
				success : function(data) {
					$("input[name='qx.id']").eq(0).val(id);
					$("input[name='qx.qx_code']").eq(1).val(data.qx_code);
					$("input[name='qx.qx_name']").eq(1).val(data.qx_name);
					$("input[name='qx.qx_url']").eq(1).val(data.qx_url);
					$("select[name='qx.menu']").val(data.menu);
					$("input[name='qx.qx_sort']").eq(1).val(data.qx_sort);	
					if(data.father!=null){
						$("input[name='pxid']").eq(1).val(data.father.id);
					}
					$("select[name='qx.state']").val(data.state);
					$("#editWin").window("open");
				}
			});
}

function update() {
	// 获取表单数据
	var formData = $("#editForm").serialize();
	// alert(formStr);
	$.ajax({
				url : "qx/updateQxAction.action",
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
