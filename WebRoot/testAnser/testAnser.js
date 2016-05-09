$(function() {
			// 文档加载完成以后，执行代码
			$("#list").datagrid({
						title : "答案信息列表",
						// 数据来源
						url : "testscore/getTestScoreByPage.action",
						queryParams : {
							"testScore.detail" : 1
						},
						width : "400px",
						height : "300px",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						pagination : true, // 显示分页效果
						pageNumber : 1,
						pageSize : 15,
						pageList : [15, 30, 45, 60],
						columns : [[{
									field : 'id',
									title : 'ID',
									width : 100,
									align : 'center',
								   hidden : 'true'
								}, {
									field : 'tp',
									title : '试题编号',
									width : 100,
									align : 'center',
									formatter:function formatCategory(value){
	         	                           if(value!=null){
                                                return value.id;
                                           }
                                    }
								}, {
									field : 'stu',
									title : '学生编号',
									width : 100,
									align : 'center',
									formatter:function formatCategory(value){
	         	                           if(value!=null){
                                                return value.id;
                                           }
                                    }
								}, {
									field : 'op',
									title : '操作',
									width : 100,
									align : 'center',
									formatter : op
								}]],
						toolbar : [{
									id : "search",
									text : "查询",
									iconCls : 'icon-search',
									handler : function() {
										$("#searchWin").window("open");
									}
								}]

					});
			// 关闭之前先把div渲染成窗口
			$('#searchWin').window({
						title : "查询",
						width : 260,
						height : 100,
						modal : true,
						inline : false
					});
			$("#searchWin").window("close");
			$('#allInfo').window({
						title : "答案信息列表",
						width : 700,
						height : 300,
						modal : true,
						inline : false
					});
			$("#allInfo").window("close");
		});

	

// 操作函数op
function op(value, row, index) {
//	var a=row.stu.id+","+row.tp.id;
	// 编辑就传一个对象过去
	return '<a href="javascript:allInfo(\'' +row.stu.id + '\',\'' +row.tp.id + '\')">详细信息</a>';
}
// 更新的方法
function allInfo(sid,tid) {
	$("#allInfo").datagrid({	                
						// 数据来源
						url : "testAnser/getTestAnserByPage.action",
						queryParams : {
							"testAnser.student.id" : sid,
							"testAnser.testPaper.id" : tid
						},
						width : "1000px",
						height : "300px",
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
									field : 'select',
									title : '选择题id',
									width : 100,
									align : 'center',
									formatter:function formatCategory(value){
	         	                           if(value!=null){
                                                return value.id;
                                           }
                                    }
								}, {
									field : 'rightorwrong',
									title : '判断题id',
									width : 100,
									align : 'center',
									formatter:function formatCategory(value){
	         	                           if(value!=null){
                                                return value.id;
                                           }
                                    }
								}, {
									field : 'ssAnswer',
									title : '提交的选择题答案',
									width : 100,
									align : 'center'
								}, {
									field : 'selectAnswer',
									title : '选择题标准答案',
									width : 100,
									align : 'center'
								}, {
									field : 'rwAnswer',
									title : '提交的判断题答案',
									width : 100,
									align : 'center'
								}, {
									field : 'rightorwrongAnswer',
									title : '判断题标准答案',
									width : 100,
									align : 'center'
								}]]
	});
	$("#allInfo").window("open");
}
function search() {
	var arrays = $("#searchForm").serializeArray();
	var obj={};//第一个空对象
	$.each(arrays,function(i,n){
		obj[n.name]=n.value;
	});
	$("#list").datagrid("load", obj);
}