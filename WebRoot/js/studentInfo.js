$(function() {
			// docuent加载完成以后，执行代码
			$("#studentInfo").datagrid({
						title : "信息列表",
						url : "xuesheng/getStudentSession.action",
						width : "500px",
						method : "post",
						rownumbers : true,
						loadMsg : "数据中，请稍后",
                        pagination : true,
						columns : [[{
									field : 'student.id',
									title : '考试成绩ID',
									'resizable' : true,
									hidden : true
								}, {
									field : 'student.studentNumber',
									title : '学生学号（账号）',
									width : 100,
									align : 'center',
									'resizable' : true
								}, {
									field : 'student.studentname',
									title : '学生姓名',
									width : 100,
									align : 'center',
									'resizable' : true
								}, {
									field : 'sex',
									title : '性别',
									width : 100,
									align : 'center',
									'resizable' : true
								}, {
									field : 'student.myClass',
									title : '班级',
									width : 100,
									align : 'center'
								}, {
									field : 'student.studentpassword',
									title : '学生登录密码',
									width : 100,
									align : 'center',
									'resizable' : true
								}, {
									field : 'student.registerdate',
									title : '注册日期',
									width : 100,
									align : 'center',
									'resizable' : true
								}
						]]

					});
		});

