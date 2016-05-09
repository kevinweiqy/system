<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>树形部门结构</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(function(){
			 $('#tt').tree({  
			   url:'<%=path%>/login/json.action',
			   animate:true,
			   checkbox:true,
			   method:'post',
			   onBeforeEdit:function(node){
			   
			   },
			   onAfterEdit:function(node){  //保存以后的操作
//			   		alert(node.text);
					alert("保存成功");
			   },
			   loadFilter: function(data){ 
			        alert(data[0]);  
			        if (data.d){   
			            return data.d;   
			        } else {   
			            return data;   
			        }   
			   }, 
			   onDblClick:function(node){
		   			if (node){
//						node.text = '<span style="font-weight:bold"><input type="text" name="name" value="'+node.text+'"/></span>';
//						$('#tt').tree('beginEdit',node);	
						$('#tt').tree('beginEdit', node.target);
					}
			   		
			   },
			   onContextMenu: function(e, node){
					e.preventDefault();
					$('#tt2').tree('select', node.target);
					$('#mm').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				}
			   
			   
			     
			 });
		})
		function appendNode(){
			var node = $('#tt').tree('getSelected');
			$('#tt').tree('append',{
				parent: (node?node.target:null),
				data:[{
					text:'new node',
					checked:true
				}]
			});
		}
		function removeNode(){
			var node = $('#tt').tree('getSelected');
			$('#tt').tree('remove', node.target);
		}
	</script>
  </head>
  
  <body>
		<div id="tree">
			<div style="float: left">
				<ul id="tt" style="width: 250px; font-size: 20px;"></ul>
			</div>
<!--			<div style="float: left">-->
<!--				<dl style="margin-top: 0px;">-->
<!--					<dt>部门名称:<input type="text" name="dept.name" id="deptName"/></dt>-->
<!--				    <dt>部门编号:<input type="text" name="dept.code" id="deptName"/></dt>-->
<!--				    <dt>上级部门:<input type="text" name="dept.code" id="deptName"/></dt>-->
<!--				</dl>-->
<!--			</div>-->
		</div>
		<div id="mm" class="easyui-menu" style="width:120px;">
			<div onclick="appendNode()" iconCls="icon-add">插入下级部门</div>
			<div onclick="removeNode()" iconCls="icon-remove">移除当前部门</div>
			<div onclick="save()" iconCls="icon-save">保存新增部门</div>
	<%--		<div class="menu-sep"></div>--%>
	<!--		<div onclick="expand()">Expand</div>-->
	<!--		<div onclick="collapse()">Collapse</div>-->
		</div>

  		
  </body>
</html>
