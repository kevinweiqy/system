<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品的列表</title>
    
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
	<link rel="stylesheet" type="text/css" href="<%=path %>/themes/style.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/goods/list.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#mycode').combogrid({    
			    panelWidth:450,     
			    idField:'id',   
			    mode: 'remote',
			    textField:'name',    
			    url:'sys/getGoodsList.action',    
			    columns:[[    
			        {field:'code',title:'商品编码',width:60},    
			        {field:'name',title:'商品名字',width:100},    
			    ]]    
			});
		});
		 
		
	</script>
	
  </head>
  
  <body class="easyui-layout" fit="true" style="overflow: hidden;">
    <div id="container">
		<div id="queryDiv">
			<form id="query" action="" method="post">
					<table width="100%" border="0" align="left" cellpadding="3"
						cellspacing="1" class="table_style">
						<tr>
							<td class="qText">
								<span class="left-title">编号</span>
							</td>
							<td>
								<input type="text" name="goods.code" id="mycode" />
							</td>
							<td class="qText">
								<span class="left-title">名称</span>
							</td>
							<td>
								<input type="text" name="goods.name" id="name" />
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="6" align="center">
								<a href="javascript:query()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<table id="list"></table>  
    </div>

<%--    <div id="win" iconCls="icon-save" title="添加商品" style="">  --%>
<%--       <form id="addGoods" action="" >--%>
<%--		商品编号：<input type="text" name="goods.code" /> </br>--%>
<%--                  商品名称：<input type="text" name="goods.name" /> </br>--%>
<%--                  商品价格：<input type="text" name="goods.price" /> </br>--%>
<%--        <input type="button" value="提交" onclick="addGoods()">--%>
<%--       </form>--%>
<%--    </div>  --%>
		<div id="add_zone" iconCls="icon-save" title="添加商品" >
			<form id="addGoods" action="" method="post">
				<table width="99%" border="0" align="center" cellpadding="3"
					cellspacing="1" class="table_style">
					<tr>
						<td width="18%" class="left_title_1">
							<span class="left-title">商品编号</span>
						</td>
						<td width="82%">
							<input type="text" name="goods.code" />
						</td>
					</tr>
					<tr>
						<td class="left_title_2">
							商品名称
						</td>
						<td>
							<input type="text" name="goods.name" />
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							商品价格
						</td>
						<td>
							<input type="text" name="goods.price" />
						</td>
					</tr>
					
					<tr bgcolor="#FFFFFF">
						<td colspan="2" align="center">
							<a href="javascript:addGoods()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="edit_zone" iconCls="icon-save" title="编辑商品" >
			<form id="editGoods" action="" method="post">
				<table width="99%" border="0" align="center" cellpadding="3"
					cellspacing="1" class="table_style">
					<input type="hidden" id="goodsid" name="goods.id" value="" />
					<input type="hidden" id="version" name="goods.version" value="" />
					<tr>
						<td width="18%" class="left_title_1">
							<span class="left-title">商品编号</span>
						</td>
						<td width="82%">
							<input type="text" id="goodscode" name="goods.code"  />
						</td>
					</tr>
					<tr>
						<td class="left_title_2">
							商品名称
						</td>
						<td>
							<input type="text" id="goodsname"  name="goods.name" />
						</td>
					</tr>
					<tr>
						<td class="left_title_1">
							商品价格
						</td>
						<td>
							<input type="text" id="goodsprice" name="goods.price" />
						</td>
					</tr>
					
					<tr bgcolor="#FFFFFF">
						<td colspan="2" align="center">
							<a href="javascript:updateObj()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">更新</a>
							
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
