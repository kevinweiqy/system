<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entor.model.TestPaper"%>
<%@taglib prefix="c" uri="../WEB-INF/tag/c-rt.tld" %>
<%@page import="com.entor.model.ShiTi"%>
<%@page import="com.entor.model.Rightorwrong"%>
<%@page import="com.entor.model.Select"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开始考试</title>
<link rel="stylesheet" href="<%=path%>/themes/default/easyui.css"
			type="text/css"></link>
		<link rel="stylesheet" href="<%=path%>/themes/icon.css"
			type="text/css"></link>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<!-- 国际化要放在jquery之后 -->
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>

</head>

<body onload="sT()">

<table width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
  <tr>
    <td width="100" height="485">&nbsp;</td>
    <td width="900" valign="top" class="rightbian">
	 <form action="submitExam.action" method="post">
	  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="10">
	      <tr>
	       <% TestPaper tp=(TestPaper)session.getAttribute("shijuan"); %>
	        <td><div align="center" class="STYLE3">考试时间：120 分钟</div></td>
	        <td><div align="center" class="STYLE3">考生：${student.studentname}</div></td>
	        <td><div align="center" class="STYLE3">总分 ：100 分</div></td>
	      </tr>
	      <tr>
	        <td>&nbsp;</td>
	        <td><div id="tTime"></div></td>
	        <td>&nbsp;</td>
	      </tr>
	      
	      <% Map<String,List<ShiTi>> map=(Map<String,List<ShiTi>>)session.getAttribute("shiti");
	         List<ShiTi> list1=map.get("danxuan");
	         List<ShiTi> list2=map.get("duoxuan");
	         List<ShiTi> list3=map.get("pan");
	      if(list1!=null){
	      int i=1;%>               
	      <tr>
	        <td colspan="3" bgcolor="#999999" class="STYLE4">单选题(每小题2分，共<%=list1.size()%>个)</td>
	      </tr>      	      	      
	    
	       <% for(ShiTi st:list1){
	    	   Select sl=(Select)st;
	      %>
	      <tr>
	        <td colspan="3"><%=i++%>.<%=sl.getNeirong()%></td>
	      </tr>
	      <tr>
	        <td colspan="3">
	          (1).<%=sl.getResult1()%>&nbsp;
	          (2).<%=sl.getResult2()%>&nbsp;
	          (3).<%=sl.getResult3()%>&nbsp;
	          (4).<%=sl.getResult4()%>&nbsp;
	        </td>
	      </tr>
	      <%} }%>
	      
	      <%if(list3!=null){
	      int j=1;%>
	      <tr>
	        <td colspan="3" bgcolor="#999999" class="STYLE4">判断题(每小题2分，共<%=list3.size()%>个)</td>
	      </tr>
	      <% for(ShiTi st:list3){
	    	  Rightorwrong rw=(Rightorwrong)st;%>
	      <tr>
	        <td colspan="3"><%=j++%>.<%=rw.getNeirong()%></td>
	      </tr>
	      <%} }%>
	      
	      
	      
	      <%if(list2!=null){
	      int k=1;%>
	      <tr>
	        <td colspan="3" bgcolor="#999999" class="STYLE4">多选题(每小题5分)，(共<%=list2.size()%>个)</td>
	      </tr>
	      <% for(ShiTi st:list2){
	      Select duo=(Select)st;%>
	      <tr>
	        <td colspan="3"><%=k++%>.<%=duo.getNeirong()%></td>
	      </tr>
	      <tr>
	        <td colspan="3">
	          (1).<%=duo.getResult1()%>&nbsp;
	          (2).<%=duo.getResult2()%>&nbsp;
	          (3).<%=duo.getResult3()%>&nbsp;
	          (4).<%=duo.getResult4()%>&nbsp;
	        </td>
	      </tr>
	      <%} }%>
	      
	       <tr>
	        <td colspan="3" bgcolor="#999999" class="STYLE4">答题卡：</td>
	      </tr> 
	      
	      <tr>
	        <td colspan="3">
	           <form id="daan">
	              <table id="daAn" >
	                  <tr>
	                     <td>单选题</td>
	                     <%for(int i=1;i<=list1.size();i++){%>
	                     <td>第<%=i%>题</td>
	                     <%} %>
	                  </tr>
	                  <tr>
	                     <td>答案</td>
	                     <%for(int i=0;i<list1.size();i++){%>
	                     <td ><input type="text" size="5" name="selectTi" /></td>
	                     <%} %>
	                  </tr>
	                  
	                  <tr>
	                     <td>判断题</td>
	                     <%for(int i=1;i<=list3.size();i++){%>
	                     <td>第<%=i%>题</td>
	                     <%} %>
	                  </tr>
	                  <tr>
	                     <td>答案</td>
	                     <%for(int i=0;i<list3.size();i++){%>
	                     <td ><input type="text"  name="panduanTi" size="5"/></td>
	                     <%} %>
	                  </tr>
	                  
	                   <tr>
	                     <td>多选题</td>
	                     <%for(int i=1;i<=list2.size();i++){%>
	                     <td>第<%=i%>题</td>
	                     <%} %>
	                  </tr>
	                  <tr>
	                     <td>答案</td>
	                     <%for(int i=0;i<list2.size();i++){%>
	                     <td ><input type="text" size="5" name="selectTis" /></td>
	                     <%} %>
	                  </tr>
	              </table>
	           </form>
	        </td>
	      </tr>
	      
		   <!--题目结束-->
	      <tr>
	        <td colspan="3"><div align="center">
	          <input type="button" value=" 提交答卷 " name="button" onclick="javascript:tijiao()" />
	        </div></td>
	      </tr>
       </table>
     </form>
    </td>
    <td width="113">&nbsp;</td>
  </tr>
</table>
</body>

<script type="text/javascript">
function tijiao(){
	var daAn="";
	var input = document.getElementsByName('selectTi'); 
		for(var i =0;i < input.length;i++){
			if(input[i].value!=""){
				daAn=daAn+","+input[i].value;
			}else{
				daAn=daAn+",6";
			}				
	}
	var inputs = document.getElementsByName('selectTis'); 
	for(var i =0;i < inputs.length;i++){
		if(inputs[i].value!=""){
	    	daAn=daAn+","+inputs[i].value;	
		}else{
				daAn=daAn+",6";
			}		
	}
	
	var panduan = document.getElementsByName('panduanTi'); 
	for(var i =0;i < panduan.length;i++){
		if(panduan[i].value!=""){
			daAn=daAn+","+panduan[i].value;
		}else{
				daAn=daAn+",6";
			}	
	}
	
	$.ajax({
				url : "kaoshi/jiSuanScore.action",
				type : "post",
				data : "daAn=" + daAn,
				dataType : "json",
				success : function(data) {
					$.messager.alert('提交', '已考完试，成绩合格，成绩为：'+data.score+'分');				
					//刷新后加载列表
					$("#list").datagrid("load");
				}
		  });

}


 var ksTime; //定义考试时间以分钟计算
 ksTime = 120;//设置时间 这里设置为0.1代表是6秒,测试用
 if(readCookie("ss")==""){
  setCookie("ss",new Date(),ksTime/60);
 }
 function sT(){
  var tti = new Date();
  var lt  = parseInt((tti-new Date(readCookie("ss")))/1000)
  if((ksTime*60-lt)<0){
   setCookie("ss",new Date(),0);
   alert("考试时间到!\n即将提交试卷!");
   document.forms[0].submit();
  }else{
  	lm = Math.floor(lt / 60);
	ls = lt % 60;
	allY = ksTime*60-lt;
	ym = Math.floor(allY / 60);
	ys = allY % 60;
   document.getElementById("tTime").innerHTML = "考试已经开始了" + lm + "分" + ls + "秒" + ",剩余"  + ym + "分" + ys + "秒";
   var ttt = setTimeout("sT()",1000);
  }
 }
 function readCookie(name) { 
  var cookieValue = ""; 
  var search = name + "="; 
  if(document.cookie.length > 0) { 
   offset = document.cookie.indexOf(search); 
   if (offset != -1) { 
    offset += search.length; 
    end = document.cookie.indexOf(";", offset); 
    if (end == -1) 
     end = document.cookie.length; 
    cookieValue = document.cookie.substring(offset, end) 
   } 
  } 
  return cookieValue; 
 }  
 function setCookie(name, value, hours) { 
  var expire = ""; 
  if(hours != null) { 
   expire = new Date((new Date()).getTime() + hours * 3600000); 
   expire = "; expires=" + expire.toGMTString(); 
  } 
  document.cookie = name + "=" + value + expire; 
 }

 </script>
</html>
