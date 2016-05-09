
$(function(){
    //文档加载完成以后，执行代码
	$("#list").datagrid({
	 title:"班级信息列表",
	 //数据来源
	 url:"banji/getMyClassJsonByPage.action",
	 queryParams:{"name":123},
	 width:"800px",
	 height:"500px",
	 method:"post",
	 loadMsg:"数据加载中，请稍后",  //数据没加载完前的提示
	 rownumbers:true, 
	 pagination:true, //显示分页效果
	 pageNumber:1,
	 pageSize:15,
	 pageList:[15,30,45,60],
	 columns:[[
	    {field:'id',title:'班级id',width:100,align:'center',hidden:'true'},    
        {field:'classNumber',title:'班级编号',width:100,align:'center'},    
        {field:'className',title:'班级名称',width:100,align:'center'},
        {field:'major',title:'专业',width:100,align:'center'},
        {field:'op',title:'操作',width:100,align:'center',formatter:op}
      ]],
      toolbar: [{
	      	id:"add",
	      	text:"增加",
			iconCls: 'icon-add',
			handler: function(){
	        $("#addWin").window("open");
		}
	    },'-',{
		    id:"help",
	      	text:"帮助",
			iconCls: 'icon-help',
			handler: function(){alert('帮助按钮')}
	  }]
	 
	});
	
	$('#addWin').window({
		title:"增加班级信息",
		width:260,    
		height:200,    
		modal:true, 
		inline:false
        }); 
    //关闭之前先把div渲染成窗口
	$("#addWin").window("close");
	
    $('#editWin').window({
	title:"编辑班级信息",
	width:260,    
	height:200,    
	modal:true, 
	inline:false
    }); 
	$("#editWin").window("close"); 
	
});

    
//添加班级信息
function add(){
	//获取表单数据
	var formData=$("#addForm").serialize();
	//alert(formStr);
	
    $.ajax({
      url:"banji/add.action",
      type:"post",
      data:formData,
      dataType:"json",
      
      success:function(data){
           if(data.flag==1){
           $.messager.alert('保存','保存成功');  
  
            $("#addWin").window("close");
            //刷新后加载列表
            $("#list").datagrid("load");
           }
       }
      
    });
    
}  
  //操作函数op
  function op(value,row,index){   
  	//编辑就传一个对象过去                                                                                             
    return '<a href="javascript:deleteMyClass(\''+row.id+'\')">删除</a>'+
    '&nbsp;'+'<a href="javascript:editMyClass(\''+row.id+'\')">编辑</a>';
  //(\''+row.classNumber+'\',\''+row.className+'\',\''+row.major+'\')
  }
  
 //异步请求删除方法
  function deleteMyClass(id){
  	 $.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
    if (r){    
      $.ajax({
      url:"banji/delete.action",
      type:"post",
      data:"myClass.id="+id, //传送的数据
      dataType:"json",
      success:function(data){
      if(data.flag==1){
         $.messager.alert('删除','删除成功');  
         $("#list").datagrid("load");
        }
       }
     });	
    }    
   }); 
  }

  //异步请求的编辑方法editCar 先拿到原始数据
  function editMyClass(id){
     $.ajax({
     url:"banji/selectOnesClass.action",
     type:"post",
     data:"myClass.id="+id, //传送的数据
     dataType:"json",
     success:function(data){
    
     $("input[name='myClass.id']").eq(1).val(id);	
     $("input[name='myClass.classNumber']").eq(2).val(data.myClass.classNumber);
     $("input[name='myClass.className']").eq(2).val(data.myClass.className);
     $("input[name='myClass.major']").eq(1).val(data.myClass.major);
     $("#editWin").window("open"); 
    }
     });}
//////以下方法是直接从页面上面那数据
//  	 $("input[name='myClass.id']").eq(1).val(id);
//     $("input[name='myClass.classNumber']").eq(2).val(classNumber);
//     $("input[name='myClass.className']").eq(2).val(className);
//     $("input[name='myClass.major']").eq(1).val(major);
//     $("#editWin").window("open"); 
//  }

//更新的方法

function update(){
	//获取表单数据
	var formData=$("#editForm").serialize();
	//alert(formStr);
    $.ajax({
      url:"banji/update.action",
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


function shuaxin(){
   var formArray=$("#selectClass").serializeArray(); //表单数组
   var obj={};//定义一个空对象
   $.each(formArray,function(i,n){
       obj[n.name] =n.value;
   })
   $("#list").datagrid("load",obj);
}


