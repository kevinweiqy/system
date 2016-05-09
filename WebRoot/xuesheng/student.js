$(function() {// 文档加载完成以后，执行代码
$("#list").datagrid({
title : "学生信息列表",
// 数据来源
url : "xuesheng/getStudentJsonByPage.action",
	queryParams : {"name" : 123},
	width : "830px",
	height : "380px",
	method : "post",
	loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
	rownumbers : true,
	pagination : true, // 显示分页效果
	pageNumber : 1,
	pageSize : 15,
	pageList : [15, 30, 45, 60],
	columns : [[
		{field : 'id',title : '学生编号',width : 100,align : 'center'}, 
		{field : 'studentNumber',title : '学生学号',width : 100,align : 'center'}, 
		{field : 'studentname',title : '学生姓名',width : 100,align : 'center'},
		{field : 'myClass',title : '学生班级',width : 100,align : 'center',
		formatter : function formatCategory(value) {
			       if (value != null) {
				   return value.id;
			    	}}}, 
       {field : 'sex',title : '学生性别',width : 100,align : 'center'}, 
	   {field : 'studentpassword',title : '学生密码',width : 100,align : 'center'}, 
	   {field : 'registerdate',title : '注册日期',width : 100,align : 'center'
	        ,formatter : function(value) {
				if (value != null) {
				var JsonDateValue = new Date(value.time);
				var text = JsonDateValue.toLocaleString();
				return text;
				}}}, 
	   {field : 'op',title : '操作',width : 100,align : 'center',formatter : op}
				]],
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
			  handler : function() {alert('帮助按钮')}
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
	//alert(formData);
	// alert(formStr);
	$.ajax({
				url : "xuesheng/StudentAdd.action",
				type : "post",
				data : formData,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						//alert(formData);
						$("#addWin").window("close"); // close window
						$("#list").datagrid("load"); // 刷新列表
					}
					

				}
			});
}

// 操作函数op
function op(value, row, index) {
	// 编辑就传一个对象过去
	return '<a href="javascript:Studentdelete(\''+row.id+'\')">删除</a>'
	 +'&nbsp;'+'<a href="javascript:editStudent(\''+row.id+'\')">编辑</a>';//,\''+row.studentNumber+'\',\''+row.studentname+'\',\''+row.myClass+'\',\''+row.sex+'\',\''+row.studentpassword+'\',\''+row.registerdate+'\')">编辑</a>';
}

// 异步请求删除方法
function Studentdelete(id) {
		//alert(id);
	$.messager.confirm('确认', '你确定想要删除记录吗?', function(r) {
				if (r) {
					$.ajax({
					url : "xuesheng/Studentdelete.action",
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


function editStudent(id){//,studentNumber,studentname,myClass,sex,studentpassword,registerdate) {

	$.ajax({
				url : "xuesheng/getonesstudent.action",
				type : "post",
				data : "student.id=" + id, // 传送的数据
				dataType : "json",
				success : function(data) {
				
					$("input[name='student.id']").eq(0).val(id);
					$("input[name='student.studentNumber']").eq(2)
							.val(data.studentNumber);
					$("input[name='student.studentname']").eq(1)
							.val(data.studentname);
							var myClassid=data.myClass.id;
					$("input[name='myClassid']").eq(1).val(myClassid);		
					$("input[name='student.sex']").eq(1).val(data.sex);
					$("input[name='student.studentpassword']").eq(1)
							.val(data.studentpassword);
				    $("input[name='student.registerdate']").eq(1).
				    val(new Date(data.registerdate.time).toLocaleString());//data.registerdate);
				    
					$("#editWin").window("open");

				}
			});
//			$("input[name='student.id']").eq(0).val(id);
//			//alert(id);
//			$("input[name='student.studentNumber']").eq(2).val(studentNumber);
//			var Class=myClass.id;
//			if(Class!=null){
//				$("input[name='student.myClass']").eq(0).val(Class);
//			}
//			
//		    $("input[name='student.studentname']").eq(1).val(studentname);
//			
//			$("input[name='student.sex']").eq(1).val(sex);
//			$("input[name='student.studentpassword']").eq(1).val(studentpassword);
//			$("input[name='student.registerdate']").eq(1).val(registerdate);
//           $("#editWin").window("open");
//				
}

// 更新的方法

function update(){
	//获取表单数据
	var formData=$("#editForm").serialize();
	//alert(formData);
    $.ajax({
      url:"xuesheng/Studentupdate.action",
      type:"post",
      data:formData,
      dataType:"json",  
      success:function(data){
           if(data.flag==1){
           //$.messager.progress();
           $.messager.alert('保存','保存成功');  
            $("#editWin").window("close");
            //刷新后加载列表
            $("#list").datagrid("load");
           }
       }
    });
} 
function chaxun(){
   var formArray=$("#selectid").serializeArray(); //表单数组
   var obj={};//定义一个空对象
   $.each(formArray,function(i,n){
       obj[n.name] =n.value;
   })
   $("#list").datagrid("load",obj);
} 
