$(function() {
	
	      $("#dan").datagrid({
	    	title : "单选题信息列表",
						// 数据来源
						url : "",
						width : "100%",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						columns : [[
							{field : 'id',title : '',width : '100%',align : 'center',fixed:true}
							]]
				});
				//判断题
		    $("#pan").datagrid({
	    	title : "判断题信息列表",
						// 数据来源
						url : "",
						width : "100%",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						columns : [[
							{field : 'id',title : '',width : '100%',align : 'center',fixed:true}
							]]
				});
				 
		    $("#duo").datagrid({
	    	title : "多选题信息列表",
						// 数据来源
						url : "",
						width : "100%",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						columns : [[
							{field : 'id',title : '',width : '100%',align : 'center',fixed:true}
							]]
				});
	      
			// 文档加载完成以后，执行代码
			$("#list").datagrid({
						title : "试卷信息列表",
						// 数据来源
						url : "paper/getTestPaperByPage.action",
						queryParams : {
							"name" : "123"
						},
						width : "100%",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						pagination : true, // 显示分页效果
						sort:{	        // 指定了排序顺序的列
							sortName: 'examination_no',
							sortOrder: 'desc'
						},
						pageNumber : 1,
						pageSize : 6,
						pageList : [6, 12, 18, 24],
						columns : [[
							        {field : 'id',title : '编号',width : 100,align : 'center',hidden : 'true'}, 
									{field : 'examination_no',title : '试卷编号',width : 100,align : 'center'}, 
									{field : 'rightorwrong_number',title : '判断题数',width : 100,align : 'center'},
									{field : 'rightorwrong_score',title : '判断题每题分数',width : 100,align : 'center'},
									{field : 'select_number',title : '选择题数',width : 100,align : 'center'},
									{field : 'select_score',title : '选择题分数',width : 100,align : 'center'},
									{field : 'selects_number',title : '多选择题数',width : 100,align : 'center'},
									{field : 'selects_score',title : '多选择题分数',width : 100,align : 'center'},
									{field : 'setupDate',title : '设置日期',width : 100,align : 'center',
									formatter: function(value,rowData,rowIndex){
									if(value!=null){
										var JsonDateValue=new Date(value.time);
								        var text=JsonDateValue.toLocaleString();
								        return text;
									              }
										}	
								    }, 
								    {field : 'beginTime',title : '开始日期',width : 100,align : 'center',
									formatter: function(value,rowData,rowIndex){
									if(value!=null){
										var JsonDateValue=new Date(value.time);
								        var text=JsonDateValue.toLocaleString();
								        return text;
									            }
									 }
								    }, 
								    {field : 'endTime',title : '结束日期',width : 100,align : 'center',
									formatter: function(value,rowData,rowIndex){
									if(value!=null){
										var JsonDateValue=new Date(value.time);
								        var text=JsonDateValue.toLocaleString();
								        return text;
									    }
								     }
								
								    },
								    {field : 'status',title : '试卷状态',width : 100,align : 'center'},
								    {
									field : 'teacher',
									title : '出卷老师',
									width : 100,
									align : 'center',
									formatter : function formatCategory(value) {
										if (value != null) {
											return value.admin_name;
										}
									}
								    },
								    {field : 'detail',title : '试卷说明',width : 100,align : 'center'},
								    {field : 'test_type',title : '试卷类型',width : 100,align : 'center'},
								    {field : 'pass_score',title : '合格分数',width : 100,align : 'center'
								}, {
									field : 'op',
									title : '操作',
									width : 350,
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
								},
								
								//--------------"添加考试班级---------------------
								'-', {
									id : "addTestClass",
									text : "添加考试班级",
									iconCls : 'icon-add',
									handler : function() {
									$("#addTestClassWin").window("open")
									}
								}
								
								//--------------添加考试班级---------------------
								
								]
					});
	
			
			
			
			$('#addWin').window({
						title : "增加试卷",
						
						width : 350,
						height :450,
						modal : true,
						inline : false
					});
			// 关闭之前先把div渲染成窗口
			$("#addWin").window("close");
			
			
			
			//-------------------添加考试班级----------------------------------			
			$('#addTestClassWin').window({
				title : "添加考试班级",
				width : 350,
				height :150,
				modal : true,
				inline : false
			});
	       // 关闭之前先把div渲染成窗口
	       $("#addTestClassWin").window("close");

	     //-------------- 添加考试班级-------------------------------------	
	       
	       
	       
			$('#editWin').window({
						title : "编辑试卷",
						width : 400,
						height : 400,
						modal : true,
						inline : false
					});
			$("#editWin").window("close");
			
			$('#s1').window({
						title : "单选题",
						width : 450,
						height : 300,
						
						modal : true,
						inline : false
					});
			$("#s1").window("close");
			
			$('#s2').window({
						title : "多选题",
						width : 450,
						height : 300,
						modal : true,
						inline : false
					});
			$("#s2").window("close");
			
			$('#s3').window({
						title : "判断题",
						width : 450,
						height : 300,
						modal : true,
						inline : false
					});
			$("#s3").window("close");
			
			
			
		});

// 添加信息
function add() {
	// 获取表单数据
	var formData = $("#addForm").serialize();
	$.ajax({
				url : "paper/addPaper.action",
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


// 操作函数op
function op(value, row, index) {
	// 编辑就传一个对象过去
	return '<a href="javascript:deletePaper(\'' + row.id + '\')">删除</a>'
			+ '&nbsp;<a href="javascript:editPaper(\'' + row.id + '\')">编辑</a>'+
			'&nbsp;<a href="javascript:addShiTi(\'' + row.id + '\')">添加单选题</a>'+
			'&nbsp;<a href="javascript:addDuoSelect(\'' + row.id + '\')">添加多选题</a>'+
			'&nbsp;<a href="javascript:addPanDuan(\'' + row.id + '\')">添加判断题</a>'+
			'&nbsp;<a href="javascript:zidong(\'' + row.id + '\')">快速添加试题</a>';
}


//-------------------添加考试班级-----------------------------

function addTestClass() {
	// 获取表单数据
	var formData = $("#addTestClassForm").serialize();
	alert(formData);
	$.ajax({
				url : "paper/addTestClass.action",
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

//--------------------添加考试班级---------------------------


// 异步请求删除的方法
function deletePaper(id) {
	$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
				if (r) {
					$.ajax({
								url : "paper/delete.action",
								type : "post",
								data : "tp.id=" + id, // 传送的数据
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

function editPaper(id) {
	$.ajax({
				url : "paper/getPaper.action",
				type : "post",
				data : "tp.id=" + id, // 传送的数据
				dataType : "json",
				success : function(data) {
					$("input[name='tp.id']").eq(0).val(id);
					$("input[name='tp.examination_no']").eq(2).val(data.examination_no);
					$("input[name='tp.rightorwrong_number']").eq(1)
							.val(data.rightorwrong_number);
					$("input[name='tp.rightorwrong_score']").eq(1)
							.val(data.rightorwrong_score);
					$("input[name='tp.select_number']").eq(1)
							.val(data.select_number);
					$("input[name='tp.select_score']").eq(1)
							.val(data.select_score);
					$("input[name='tp.selects_number']").eq(1)
							.val(data.selects_number);
					$("input[name='tp.selects_score']").eq(1)
							.val(data.selects_score);
							
				   
								$("input[name='setupDateTest']").eq(1)
							.val(null);
							
					
						$("input[name='startTime']").eq(1)
							.val(null);
					
					
				 
						$("input[name='endTime']").eq(1).val(null);
					
					
					
			if (data.teacher != null) {
				$("input[name='teacherid']").eq(1).val(data.teacher.id);
			} else {
				$("input[name='teacherid']").eq(1).val(null);
			}
					
					$("input[name='tp.detail']").eq(1)
							.val(data.detail);
					$("input[name='tp.test_type']").eq(1)
							.val(data.test_type);
					$("input[name='tp.pass_score']").eq(1)
							.val(data.pass_score);
					$("#editWin").window("open");
				}
			});
}

function update() {
	// 获取表单数据
	var formData = $("#editForm").serialize();
	alert(formData);
	// alert(formStr);
	$.ajax({
				url : "paper/updatePaper.action",
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

var q="q";//试卷试题字符串定义
//添加单选题
function addShiTi(id){ 
	q=q+","+id;
	$("#selectsource").datagrid({
						title : "单选题信息列表",
						// 数据来源
						url : "paper/getShiTi.action",
						queryParams : {
							"type" : 0
						},
						width : "100%",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						pagination : true, // 显示分页效果
						pageNumber : 1,
						pageSize : 6,
						pageList : [6, 12, 18, 24],
						columns : [[{
									field:"ck",
									checkbox:"true"
						        },{
									field : 'id',
									title : '编号',
									width : 100,
									align : 'center'
									
								}, {
									field : 'shiti_code',
									title : '试题编号',
									width : 100,
									align : 'center'
								}, {
									field : 'neirong',
									title : '试题内容',
									width : 100,
									align : 'center'
								}, {
									field : 'type',
									title : '试题类型',
									width : 100,
									align : 'center'
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
									field : 'selectType',
									title : '选择题类型',
									width : 100,
									align : 'center'
								}, {
									field : 'answer',
									title : '正确答案',
									width : 100,
									align : 'center'
								}, {
									field : 'sctupdate',
									title : '加入日期',
									width : 100,
									align : 'center',
									formatter: function(value,rowData,rowIndex){
									if(value!=null){
										var JsonDateValue=new Date(value.time);
								        var text=JsonDateValue.toLocaleString();
								        return text;
									}
										}
								
								},{
									field : 'teacherId',
									title : '出题老师',
									width : 100,
									align : 'center'
								}]],
								toolbar : [{
									id : "add",
									text : "增加",
									iconCls : 'icon-add',
									handler : function() {
										addDan();
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
	//手动添加试题
	$("#s1").window("open");	
}

function addDuoSelect(id){
	q=q+","+id;
	$("#duoselects").datagrid({
						title : "多选题信息列表",
						// 数据来源
						url : "paper/getShiTi.action",
						queryParams : {
							"type" : 2
						},
						width : "100%",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						pagination : true, // 显示分页效果
						pageNumber : 1,
						pageSize : 6,
						pageList : [6, 12, 18, 24],
						columns : [[{
									field:"ck",
									checkbox:"true"
						        },{
									field : 'id',
									title : '编号',
									width : 100,
									align : 'center',
									hidden : 'true'
								}, {
									field : 'shiti_code',
									title : '试题编号',
									width : 100,
									align : 'center'
								}, {
									field : 'neirong',
									title : '试题内容',
									width : 100,
									align : 'center'
								}, {
									field : 'type',
									title : '试题类型',
									width : 100,
									align : 'center'
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
									field : 'selectType',
									title : '选择题类型',
									width : 100,
									align : 'center'
								}, {
									field : 'answer',
									title : '正确答案',
									width : 100,
									align : 'center'
								}, {
									field : 'sctupdate',
									title : '加入日期',
									width : 100,
									align : 'center',
									formatter: function(value,rowData,rowIndex){
									if(value!=null){
										var JsonDateValue=new Date(value.time);
								        var text=JsonDateValue.toLocaleString();
								        return text;
									}
										}
								
								},{
									field : 'teacherId',
									title : '出题老师',
									width : 100,
									align : 'center'
								}]],
								toolbar : [{
									id : "add",
									text : "增加",
									iconCls : 'icon-add',
									handler : function() {
										addMany();
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
    //手动添加试题
    $("#s2").window("open");
}

function addPanDuan(id){
	q=q+","+id;
	$("#panduansource").datagrid({
						title : "判断题信息列表",
						// 数据来源
						url : "paper/getShiTi.action",
						queryParams : {
							"type" : 1
						},
						width : "100%",
						method : "post",
						loadMsg : "数据加载中，请稍后", // 数据没加载完前的提示
						rownumbers : true,
						pagination : true, // 显示分页效果
						pageNumber : 1,
						pageSize : 6,
						pageList : [6, 12, 18, 24],
						columns : [[{
									field:"ck",
									checkbox:"true"
						        },{
									field : 'id',
									title : '编号',
									width : 100,
									align : 'center',
									hidden : 'true'
								}, {
									field : 'shiti_code',
									title : '试题编号',
									width : 100,
									align : 'center'
								}, {
									field : 'neirong',
									title : '试题内容',
									width : 100,
									align : 'center'
								}, {
									field : 'type',
									title : '试题类型',
									width : 100,
									align : 'center'
								}, {
									field : 'answer',
									title : '选项1',
									width : 100,
									align : 'center'
								}, {
									field : 'sctupdate',
									title : '加入日期',
									width : 200,
									align : 'center',
									formatter: function(value,rowData,rowIndex){
									if(value!=null){
										var JsonDateValue=new Date(value.time);
								        var text=JsonDateValue.toLocaleString();
								        return text;
									}
										}
								
								},{
									field : 'teacherId',
									title : '出题老师',
									width : 100,
									align : 'center'
								}]],
								toolbar : [{
									id : "add",
									text : "增加",
									iconCls : 'icon-add',
									handler : function() {
										addPan();
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
    $("#s3").window("open");
}

function zidong(id){
    $.ajax({
				url : "paper/addDefaultPaper.action",
				type : "post",
				data : "tp.id=" + id,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						$.messager.alert('添加', '添加成功');
						//刷新后加载列表
						$("#list").datagrid("load");
					}
				}
		  });
}


function addDan(){
	var rows=$("#selectsource").datagrid("getSelections");
	for(var a=0;a<rows.length;a++){
		//d=d+","+rows[a].id;
		q=q+","+rows[a].id;
		$("#dan").datagrid('appendRow',{
				id:'<table id='+rows[a].id+'><tr><td colspan=4>'+rows[a].neirong+'</td>'+
				'<tr><td><input type="radio" name="result+ '+a+' value=a"/>'+rows[a].result1+'</td>'+
		        '<td><input type="radio" name="result+ '+a+' value=a"/>'+rows[a].result2+'</td>'+
		        '<td><input type="radio" name="result+ '+a+' value=a"/>'+rows[a].result3+'</td>'+
		        '<td><input type="radio" name="result+ '+a+' value=a"/>'+rows[a].result4+'</td>'+
		        '</tr></table>'
		});
	}	
}
function addPan(){
	var rows=$("#panduansource").datagrid("getSelections");
	for(var a=0;a<rows.length;a++){
		//p=p+","+rows[a].id;
		q=q+","+rows[a].id;
		 $("#pan").datagrid('appendRow', {
							id:'<table id='+rows[a].id+'><tr><td>'+rows[a].neirong+'</td>'+
				'<td><input type="radio" name="result+'+a+' value=a"/>对</td>'+
		        '<td><input type="radio" name="result+'+a+' value=a"/>错</td>'+
		        
		        '</tr></table>'
		});
	}
	

	
}


function addMany(){
	var rows=$("#duoselects").datagrid("getSelections");
	for(var a=0;a<rows.length;a++){
		//p=p+","+rows[a].id;
		q=q+","+rows[a].id;
		 $("#duo").datagrid('appendRow', {
				id:'<table id='+rows[a].id+'><tr><td colspan=4>'+rows[a].neirong+'</td>'+
				'<tr><td><input type="checkbox" name="result+ '+a+' value=a"/>'+rows[a].result1+'</td>'+
		        '<td><input type="checkbox" name="result1'+a+' value=a"/>'+rows[a].result2+'</td>'+
		        '<td><input type="checkbox" name="result2'+a+' value=a"/>'+rows[a].result3+'</td>'+
		        '<td><input type="checkbox" name="result3'+a+' value=a"/>'+rows[a].result4+'</td>'+
		        '</tr></table>'
							});}	
}

function baocun(){
	   alert(q);
	   $.ajax({
				url : "paper/baocunPaper.action",
				type : "post",
				data : "qpaper=" + q,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						$.messager.alert('保存', '保存成功');
						//刷新后加载列表
						$("#list").datagrid("load");
					}
				}
		  });
}













