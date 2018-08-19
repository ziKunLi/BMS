<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!-- 导入的标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ page import="java.util.*"%>
<html>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;">
    <table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：读者管理 &gt; 读者类型管理 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
        <%
 				int size = (Integer)ActionContext.getContext().get(common.StaticDataPool.CARD_TYPE_SIZE);
 				if(size == 0){
 		  %>
          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
          
            <tr>
              <td height="36" align="center">暂无证件类型信息！</td>
            </tr>
          </table>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  			<tr>
    		<td>
      		<a href="#" onClick="window.open('cardTypeAdd.jsp','','width=292,height=175')">添加证件类型信息</a> </td>
  			</tr>
		</table>
			<%
 				}
				else{
 		  	%>
 		<table width="91%"  border="0" cellspacing="0" cellpadding="0">
  			<tr>
    			<td align="right">      
      			<a href="#" onClick="window.open('cardTypeAdd.jsp','','width=400,height=225')">添加证件类型信息</a> </td>
			</tr>
		</table>  
	  	<table width="91%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6b83B" bordercolorlight="#FFFFFF">
			<tr align="center" bgcolor="#e3F4F7">
			    <td width="15%" bgcolor="#C0C0C0">证件编号</td>
			    <td width="15%" bgcolor="#C0C0C0">证件名称</td>
			    <td width="15%" bgcolor="#C0C0C0">可借书数量</td>
			    <td width="15%" bgcolor="#C0C0C0">可借书天数</td>
			    <td width="16%" bgcolor="#C0C0C0">修改</td>
			    <td width="14%" bgcolor="#C0C0C0">删除</td>
			</tr> 
			
			<s:iterator value="cardTypes">
		        <tr >
		            <td style="padding:5px;">&nbsp;<s:property value="id"/></td>
		            <td style="padding:5px;">&nbsp;<s:property value="name"/></td>
		            <td style="padding:5px;">&nbsp;<s:property value="number"/></td>
		            <td style="padding:5px;">&nbsp;<s:property value="days"/></td>
		            <td align="center">
		            	<a href="
					      	<s:url action="cardType_modifyQuery.action">  
			            	<s:param name="cardType.id" value="id"/>  
			            	</s:url>">
			            	修改
			         	</a></td>
			    	<td align="center">
			    		<a href="
					      	<s:url action="readerType_delete.action">  
			            	<s:param name="cardType.id" value="id"/>  
			            	</s:url>">
			            	删除
			         	</a></td>
		        </tr>
		    </s:iterator>
		</table>
		<%
				}
		%>
		</td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
</body>
</html>
