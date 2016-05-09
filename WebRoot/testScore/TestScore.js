$(function(){
	//docuent加载完成以后，执行代码
	$("#list").datagrid({
		title:"考试成绩信息列表",
		url:"testscore/getTestScoreListByPage.action",
		width:"960px",
		
		method:"post",
		rownumbers:true,
		loadMsg:"数据中，请稍后",
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,24],
		pagination:true,
		columns:[[    
	        {field:'id',title:'考试成绩ID','resizable':true,hidden:true},
	        {field:'tp',title:'试卷ID',width:100,align:'center','resizable':true,
	         formatter:function formatCategory(value){
	         	  if(value!=null){
             return value.id;
                            }
                              }
	        
	        },
	        {field:'stu',title:'学生姓名',width:100,align:'center','resizable':true,
	      
	         formatter:function formatCategory(value){
	         	  if(value!=null){
             return value.studentname;
                            }
                              }
            },
	        {field:'score',title:'学生试卷成绩',width:100,align:'center','resizable':true},
	        {field:'examinationdate',title:'考试日期',width:100,align:'center',
	        formatter:function(value){
	        	if(value!=null){  var JsonDateValue=new Date(value.time);
	        var text=JsonDateValue.toLocaleString();return text;}
	      }
	        },
	        
	        {field:'pass',title:'是否补考',width:100,align:'center','resizable':true},
	        {field:'buScore',title:'补考成绩',width:100,align:'center','resizable':true},
	        {field:'isPass',title:'是否及格',width:100,align:'center','resizable':true},
	        {field:'detail',title:'说明',width:100,align:'center','resizable':true},
	        {field:'op',title:'操作',width:100,align:'center',formatter:op,'resizable':true} 
    	]],
    	toolbar: [{
    		id:"add",
    		text:"添加",
			iconCls: 'icon-add',
			handler: function(){
    			$('#addWin').window("open"); 
			}
		},'-',{
			id:"help",
			text:"帮助",
			iconCls: 'icon-help',
			handler: function(){alert('帮助按钮')}
		}
		]

		
	});
	$('#addWin').window({
	  title:"添加考试成绩信息",
	  width:500,
	  height:300,
	  modal:true,
	  inline : false
	});
	$('#addWin').window('close');
	
  $('#editWin').window({
	  title:"编辑考试成绩信息",
	  width:500,
	  height:300,
	  modal:true,
	  inline : false
	});
	$('#editWin').window('close');
	
 
});
//操作函数
function op(value,row,index){
	//alert(row.name+"--"+row.no);
	return '<a href="javascript:deleteTestScore(\''+row.id+'\')">删除</a>'
	       +'&nbsp;<a href="javascript:editTestScore(\''+row.id+'\')" >编辑</a>';
}
//添加的方法
function add(){
//获取表单的数据
	var formData=$("#addForm").serialize();
	//获取文本框的数据
	$.ajax({
	     url:"testscore/addTestScore.action",
	     type:"post",
	     data:formData,
	     dataType:"json",
	     success:function(data){
	     	if(data.flag==1){
	     		//消息窗口
	     		$.messager.alert('保存','保存成功');
	     		$('#addWin').window('close');
	     		$("#list").datagrid("load");
	     	}
	     }
	});
}
//删除的方法
function deleteTestScore(id){
	$.messager.confirm('确认','您确认要删除记录吗',function(r){
	if(r){
	$.ajax({
	url:"testscore/deleteTestScore.action",
	type:"post",
	data:"testScore.id="+id,
	dataType:"json",
	success:function(data){
		if(data.flag==1){
		 //消息窗口
			$.messager.alert('删除','删除成功');
			//加载列表
			$("#list").datagrid("load");
		}
	}
	});
	}
	});

}

function editTestScore(id) {
	$.ajax({
				url : "testscore/getTestScoreById.action",
				type : "post",
				data : "testScore.id=" + id, // 传送的数据
				dataType : "json",
				success : function(data) { 
			$("input[name='testScore.id']").eq(0).val(id);
	
			$("input[name='testScore.tp']").eq(0).val(data.tp.id);
			$("input[name='testScore.stu']").eq(0).val(data.stu.id);
			$("input[name='testScore.score']").eq(1).val(data.score);
			$("input[name='testScore.pass']").eq(1).val(data.pass);
			$("input[name='testScore.buScore']").eq(1).val(data.buScore);
			$("input[name='testScore.isPass']").eq(1).val(data.isPass);
			$("#editWin").window("open");
		}
			});
}
//更新

function update() {
	// 获取表单数据
	var formData = $("#editForm").serialize();
	// alert(formStr);
	$.ajax({
				url : "testscore/updateTestScore.action",
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


////编辑的方法
//function edit(id){
//    $("input[name='testScore.tp']").eq(1).val(tp );
//    $("input[name='testScore.stu']").eq(1).val(stu);
//    $("input[name='testScore.score']").eq(1).val(score);
//    $("input[name='testScore.examinationdate']").eq(1).val(new Date());
//    $("input[name='testScore.pass']").eq(1).val(pass);
//    $("input[name='testScore.buScore']").eq(1).val(buScore);
//    $("input[name='testScore.isPass']").eq(1).val(isPass);
//           
//    $('#editWin').window('open');
//}


