$(function() {
			// 文档加载完成以后，执行代码
			$("#list").datagrid({
						title : "学生信息列表",
						// 数据来源
						url : "student/getStudentJsonByPage.action",
						queryParams : {
							"name" : 123
						},
						width : "830px",
						height : "380px",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						pagination : true, // 显示分页效果
						pageNumber : 1,
						pageSize : 15,
						pageList : [15, 30, 45, 60],
						columns : [[{
									field : 'id',
									title : '学生编号',
									width : 100,
									align : 'center'
								}, {
									field : 'studentNumber',
									title : '学生学号',
									width : 100,
									align : 'center'
								}, {
									field : 'studentname',
									title : '学生姓名',
									width : 100,
									align : 'center'
								}, {
									field : 'myClass',
									title : '学生班级',
									width : 100,
									align : 'center',

									formatter : function formatCategory(value) {
										if (value != null) {
											return value.id;
										}
									}
								}, {
									field : 'sex',
									title : '学生性别',
									width : 100,
									align : 'center'
								}, {
									field : 'studentpassword',
									title : '学生密码',
									width : 100,
									align : 'center'
								}, {
									field : 'registerdate',
									title : '注册日期',
									width : 100,
									align : 'center',
									formatter : function(value) {
										if (value != null) {
											var JsonDateValue = new Date(value.time);
											var text = JsonDateValue
													.toLocaleString();
											return text;
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
						title : "增加学生",
						width : 260,
						height : 200,
						modal : true,
						inline : false
					});
			// 关闭之前先把div渲染成窗口
			$("#addWin").window("close");

			$('#editWin').window({
						title : "更新学生",
						width : 260,
						height : 200,
						modal : true,
						inline : false
					});
			$("#editWin").window("close");
		});

// 添加学生信息
function add() {
	// 获取表单数据
	var formData = $("#addForm").serialize();
	// alert(formStr);
	$.ajax({
				url : "student/StudentAdd.action",
				type : "post",
				data : formData,
				dataType : "json",

				success : function(data) {
					if (data.flag == 1) {
						alert("添加学生成功");
						$("#addWin").window("close"); // close window
						$("#list").datagrid("load"); // 刷新列表
					}

				}
			});
}

// 操作函数op
function op(value, row, index) {
	// 编辑就传一个对象过去
	return '<a href="javascript:Studentdelete(\'' + row.id + '\')">删除</a>'
			+ '&nbsp;<a href="javascript:editStudent(\'' + row.id
			+ '\')">编辑</a>';
}

// 异步请求删除方法
function Studentdelete(id) {
	$.messager.confirm('确认', '你确定想要删除记录吗?', function(r) {

				if (r) {
					$.ajax({
								url : "student/Studentdelete.action",
								type : "post",
								data : "student.id=" + id,// 传送的数据
								dataType : "json",
								success : function(data) {
									if (data.flag == 1) {
										$.messager.alert('删除', '删除成功');
										$("#list").datagrid("load");
									}
								}
							});
				}
			});
}

// 异步请求的编辑方法
// function editStudent(id) {
// 异步查询，取到对应的对象以后再填充进来

// $("input[name='student.id']").eq(1).val(id);
// $("input[name='student.studentNumber']").eq(2).val(studentNumber);
// $("input[name='student.studentname']").eq(1).val(studentname);
// $("input[name='student.myClass']").eq(1).val(myClass);
// $("input[name='student.sex']").eq(1).val(sex);
// $("input[name='student.studentpassword']").eq(1).val(studentpassword);
// $("input[name='student.registerdate']").eq(1).val(registerdate);
//	
//	
// $("#editWin").window("open");
//
// }
function editStudent(id) {
	$.ajax({
				url : "studnet/getstudent.action",
				type : "post",
				data : "student.id=" + id, // 传送的数据
				dataType : "json",
				success : function(data) {
					$("input[name='student.id']").eq(1).val(id);
					$("input[name='student.studentNumber']").eq(2)
							.val(data.student.studentNumber);
					$("input[name='student.studentname']").eq(1)
							.val(data.student.studentname);
					$("input[name='student.myClass']").eq(1)
							.val(data.student.myClass);
					$("input[name='student.sex']").eq(1).val(data.student.sex);
					$("input[name='student.studentpassword']").eq(1)
							.val(data.studnet.studentpassword);
					$("input[name='student.registerdate']").eq(1)
							.val(data.student.registerdate);

					$("#editWin").window("open");

				}
			});
}

// 更新的方法

function update() {
	// 获取表单数据
	var formData = $("#editForm").serialize();
	// alert(formStr);
	$.ajax({
				url : "student/Studentupdate.action",
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
