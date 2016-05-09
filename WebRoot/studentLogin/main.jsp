<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8 />
	<title>在线考试管理系统</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
	
	<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>	
	<script type="text/javascript" src="<%=path%>/studentLogin/menu.js"></script>
	<style>
	  article, aside, figure, footer, header, hgroup, 
	  menu, nav, section { display: block; }
	  .west{
	    width:200px;
	    padding:10px;
	  }
	  .north{
	    height:100px;
	  }
	</style>
	<script language="javascript" type="text/javascript">
	function showNowDate(){
	var weekDayLabels = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
	  var date = new Date();
	  var year = date.getFullYear();//年
	  var month = date.getMonth()+1;//月
	  var day = date.getDate();//日
	  var h = date.getHours();
	  var m = date.getMinutes();
	  var s = date.getSeconds();
	 var isNO = document.getElementById("oneTwo").value;
	 if(1==isNO){
		 document.getElementById("adminName").innerHTML=("系统管理员");
	 }else{
		 document.getElementById("adminName").innerHTML=("用户");
	 }
	var currentime = year+"年"+month+"月"+day+"日 "+weekDayLabels[date.getDay()]+ h + ":" + m + ":"+s;
	   document.getElementById("mytime").innerHTML=(currentime);
	}
	
	window.onload = function(){
	 showNowDate(); 
	}
	setInterval("showNowDate()",1);
	//每隔 2000毫秒，调一次showNowDate()
	function nowTime(){
		 var date = new Date();
		 var year = date.getFullYear();//年
	  var month = date.getMonth()+1;//月
	  var day = date.getDate();//日
	  var h = date.getHours();
	  var m = date.getMinutes();
	  var s = date.getSeconds();
	  	var currentime = year+"年"+month+"月"+day+"日 "+weekDayLabels[date.getDay()]+ h + ":" + m + ":"+s;
	   document.getElementById("nowTime").innerHTML=(currentime);
	}
	
	$(function() {
			// 编辑的窗口
			$('#editupdate').window({
						width : 600,
						height : 400,
						modal : false
					});

			$('#editupdate').window('close'); // close window

	})
	
	function edit(){
		$('#editupdate').window('open');
	}
	
	function update(){
		var formData = $("#ed").serialize();
	$.ajax({
				url : "../xuesheng/updatePassword.action",
				type : "post",
				data : formData,
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						alert("修改成功");
					} else if (data.flag == 0) {
						alert("修改失败");
					}
					$('#editupdate').window('close'); // close window
					$("#list").datagrid("load"); // 刷新列表
				}
			});
	}
	
</script>
</head>
<body class="easyui-layout">
  <!--顶部div-->
		<div region="north"  style="overflow: hidden;">
			<TABLE cellSpacing=0 cellPadding=0 width="100%"
				background="<%=path%>/images/header_bg.jpg" border=0>
				<TR height=100>
					<TD width=260>
						<font size="6" color="white">在线考试系统V1.0</font>
					</TD>
					<TD style="FONT-WEIGHT: bold; COLOR: #fff; PADDING-TOP: 20px"
						align=left>
						当前学生：${loginName} &nbsp;&nbsp;
						<A style="COLOR: #fff" href="javascript:edit()" target=main>修改口令</A> &nbsp;&nbsp;
						<A style="COLOR: #fff"
							onclick="if (confirm('确定要退出吗？')) return true; else return false;"
							href="" target=_top>退出系统</A>&nbsp;&nbsp;
						<A style="COLOR: #fff"
							onclick="if (confirm('确定要重新登录吗？')) return true; else return false;"
							href="<%=path%>/pages/login.jsp" target=_top>重新登录</A>
						<br/>当前时间：<h2 id="mytime"></h2>
					</TD>
				</TR>
			</TABLE>
		</div>
		<!--左侧菜单div-->
        <div region="west" split="true" title="菜单栏" style="width:180px;padding1:1px;overflow:hidden;">
			<ul id="tree">
			</ul>
			<!-- onclick="Open('在线考试','<%=path%>/kaoshi/kaoshi.action')" -->
		</div>
   		<!--中间显示内容div-->
		<div region="center" style="overflow: hidden;">
			<div class="easyui-tabs" fit="true" border="false" id="tabs">
				<div title="首页" style="padding: 20px; overflow: hidden;">
					<div style="margin-top: 20px;">
						<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center
							border=0>
							<TR height=28>
								<TD background="<%=path%>/images/title_bg1.jpg">
									当前位置: 首页
								</TD>
							</TR>
							<TR>
								<TD bgColor=#b1ceef height=1></TD>
							</TR>
							<TR height=20>
								<TD background="<%=path%>/images/shadow_bg.jpg"></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center
							border=0>
							<TR height=100>
								<TD align=middle width=100>
									<IMG height=100 src="<%=path%>/images/admin_p.gif" width=90>
								</TD>
								<TD width=60>
									&nbsp;
								</TD>
								<TD>
									<TABLE height=100 cellSpacing=0 cellPadding=0 width="100%"
										border=0>

										<TR>
											<TD>

											</TD>
										</TR>
										<TR>
											<TD
												style="FONT-WEIGHT: bold; FONT-SIZE: 16px; COLOR: #880000">
												<input type="hidden" id="oneTwo" value="${op_is_admin}" />
												<h2 id="adminName"></h2>
												${LOGIN_NAME}
											</TD>
										</TR>
										<TR>
											<TD>
												学生信息系统
											</TD>
										</TR>
									</TABLE>
								</TD>
							</TR>
							<TR>
								<TD colSpan=3 height=10></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center
							border=0>
							<TR height=20>
								<TD></TD>
							</TR>
							<TR height=22>
								<TD
									style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
									background="<%=path%>/images/title_bg2.jpg">
									当前用户信息
								</TD>
							</TR>
							<TR bgColor=#ecf4fc height=12>
								<TD></TD>
							</TR>
							<TR height=20>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center
							border=0>
							<TR>
								<TD align=right width=100>
									登陆帐号：
								</TD>
								<TD style="COLOR: #880000">
									${loginName}
								</TD>
							</TR>
							<TR>
								<TD align=right>
									真实姓名：
								</TD>
								<TD style="COLOR: #880000">
									${Aname}
								</TD>
							</TR>
							<TR>
								<TD align=right>
									上线时间：
								</TD>
								<TD style="COLOR: #880000">
									${timeNow}
								</TD>
							</TR>
							<TR>
								<TD align=right>
									IP地址：
								</TD>
								<TD style="COLOR: #880000">
									${LocaLip}
								</TD>
							</TR>
							<TR>
								<TR>
									<TD align=right>
										主机名称：
									</TD>
									<TD style="COLOR: #880000">
										${LocaName}
									</TD>
								</TR>
								
								<TR>
									<TD align=right>
										网站开发QQ：
									</TD>
									<TD style="COLOR: #880000">
										123456789
									</TD>
								</TR>
								<TR>
									<TD align=right>
										entor：
									</TD>
									<TD style="COLOR: #880000">
										<a href="http://www.entor.cn">www.entor.cn</a>
									</TD>
								</TR>
						</TABLE>
					</div>
				</div>
			</div>
		</div>


		<!--底部div-->
		<div region="south"  style="height:50px;padding:10px;background:#efefef;">
			<div class="easyui-layout" fit="true" style="background:#ccc;">
				<div region="center">系统版权信息显示</div>
				<div region="east" split="true" style="width:200px;">sub center</div>
			</div>
		</div>
  
	  <div id="tabsMenu" class="easyui-menu" style="width:120px;">  
	    <div name="close">关闭</div>  
	    <div name="Other">关闭其他</div>  
	    <div name="All">关闭所有</div>
	  </div> 
	  <div id="editupdate">
	   <form id="ed" action="">
	          请输入新的密码：<input type="text" name="student.studentpassword"/>
	    <br/><input type="button" name="bttn" value="保存" onclick="javascript:update()"/>      
	    </form>
	  </div> 
</body>
</html>
