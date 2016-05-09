$(function() {
			$("#list").datagrid({
				title : "商品的列表",
				iconCls : 'icon-save',
				url : "sys/getGoodsList.action",
				method : "post",
				loadMsg : "加载数据中，请稍后",
				fitColumns : true,
				rownumbers : true,
				queryParams : {
					optype : "query"
				},
				pagination : true,
				pageList : [2, 5, 10, 15],
				pageSize : 15,
				// frozenColumns : [ [ {
				// field : 'ck',
				// checkbox : true,
				// height:50
				// } ] ],
				columns : [[{
							field : 'ck',
							checkbox : true,
							height : 50
						}, {
							field : 'id',
							title : '主键',
							hidden : true,
							width : 100,
							height : 50,
							align : "center"
						}, {
							field : 'code',
							title : '商品编码',
							width : 100,
							height : 100,
							align : "center"
						}, {
							field : 'name',
							title : '名字',
							width : 100,
							align : "center"
						}, {
							field : 'price',
							title : '价格',
							width : 100,
							align : "center"
						},
						// {field:'addr',title:'地址',width:100,align:"center",formatter:showAddr},
						{
							field : 'op',
							title : '操作',
							width : 100,
							align : "center",
							formatter : options
						}]],
				toolbar : [{
							id : 'btnadd',
							text : '添加',
							iconCls : 'icon-add',
							handler : function() {
								$('#add_zone').window('open'); // 打开窗口
							}
						}, {
							id : 'btncut',
							text : '删除',
							iconCls : 'icon-cut',
							handler : function() {
								var ids = getSelections();
								$.ajax({
											url : "xx",
											type : "post",
											data : "ids=" + ids,
											success : function(data) {
												// 删除成功的提示
											}
										});
							}
						}],
				onLoadSuccess : function(data) {
					$(".edit-linkbutton").linkbutton({
								text : '编辑',
								plain : true,
								iconCls : 'icon-edit'
							});
					$(".delete-linkbutton").linkbutton({
								text : '删除',
								plain : true,
								iconCls : 'icon-remove'
							});
					var opts = $(this).datagrid('options');
					if (opts.rownumbers) {
						var dgPanel = $(this).datagrid('getPanel');
						var tdRownumber = dgPanel
								.find('.datagrid-header-rownumber').parent();
						var hasFrozenColumns = $(this).datagrid(
								'getColumnFields', true);
						if (hasFrozenColumns.length) {
							var dgView2 = dgPanel.find('.datagrid-view2');
							var trCount = dgView2.find('.datagrid-header tr').length;

							tdRownumber.attr('rowspan', trCount);
						}
					}
				}
			});

			$('#mydate').datetimebox({

						showSeconds : false

					});
			// 添加的窗口
			$('#add_zone').window({
						width : 600,
						height : 400,
						modal : false
					});

			$('#add_zone').window('close'); // close window
			// 编辑的窗口
			$('#edit_zone').window({
						width : 600,
						height : 400,
						modal : false
					});

			$('#edit_zone').window('close'); // close window

		})
// 批量选中记录
function getSelections() {
	var ids = [];
	// 获取被选中的所有的行记录对象数组
	var rows = $("#list").datagrid("getSelections");
	for (var i = 0; i < rows.length; i++) {
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
	var str = '<a href="javascript:editObj(' + rowData.id
			+ ')" class="edit-linkbutton" >编辑</a>';
	str = str + '<a href="javascript:deleteObj(' + rowData.id
			+ ')" class="delete-linkbutton"></a>';
	return str;
}
// 编辑填充内容
function editObj(id) {
	$.ajax({
				url : "sys/findGoods.action",
				type : "post",
				data : "goods.id=" + id,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						// 拿到商品对象
						var goods = data.goods;
						// 填充表单
						$("#goodsid").val(goods.id);
						$("#goodscode").val(goods.code);
						$("#goodsname").val(goods.name);
						$("#goodsprice").val(goods.price);
						$("#version").val(goods.version);
						$('#edit_zone').window('open'); // close window
					} else if (data.flag == 0) {
						alert("不存在此商品！");
					}
				}
			});
	//	
	//	
}
// 删除的js操作
function deleteObj(id) {
	$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
				if (r) {
					$.ajax({
								url : "sys/deleteGoods.action",
								type : "post",
								data : "goods.id=" + id,
								dataType : "json",
								success : function(data) {
									// 删除成功的提示
									if (data.flag == 1) {
										alert("删除商品成功");
									} else if (data.flag == 0) {
										alert("删除商品失败，请检查操作");
									}
									$("#list").datagrid("load"); // 刷新列表
								}
							});
				}
			});

}
// 添加的操作
function addGoods() {
	var formData = $("#addGoods").serialize();
	$.ajax({
				url : "sys/addGoods.action",
				type : "post",
				data : formData,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						alert("添加商品成功");
					} else if (data.flag == 0) {
						alert("添加商品失败，请检查操作");
					}
					$('#add_zone').window('close'); // close window
					$("#list").datagrid("load"); // 刷新列表
				}
			});
}

// 更新的操作
function updateObj() {
	var formData = $("#editGoods").serialize();
	$.ajax({
				url : "sys/updateGoods.action",
				type : "post",
				data : formData,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						alert("更新商品成功");
					} else if (data.flag == 0) {
						alert("更新商品失败，请检查操作");
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
	$.each(arrays, function(i, n) {
				obj[n.name] = n.value;
			});
	// alert(obj);
	// 重新发送一次请求，重新装载这个列表
	$("#list").datagrid("load", obj);
}