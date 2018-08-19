<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!-- 导入的标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%> 
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
    <td height="22" valign="top" class="word_orange">当前位置：系统设置 &gt; 管理员设置 &gt;&gt;&gt;</td>
  </tr>
  <tr>
    <td align="center" valign="top">
 	<%
 		
 		int size = (Integer)ActionContext.getContext().get(common.StaticDataPool.MANAGER_SIZE);
 		if(ActionContext.getContext().getContextMap().containsKey(StaticDataPool.MANAGER_SIZE)&&size == 0){
 	%>
	          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
	            <tr>
	              <td height="36" align="center">暂无管理员信息！</td>
	            </tr>
	          </table>
	          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
	          <tr><td><a href="#" onClick="window.open('managerAdd.jsp','','width=292,height=175')">添加管理员信息</a></td></tr>
			  </table>
 	<%
		}else if(size > 0){
	%>
			<table width="100%"  border="0" cellspacing="0" cellpadding="0">
			  <tr>
			    <td width="84%">&nbsp;</td>
			    <td width="16%"><a href="#" onClick="window.open('managerAdd.jsp','','width=292,height=175')">添加管理员信息</a></td>	  
			  </tr>
			</table>  
			  <table width="91%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#C0C0C0" bordercolorlight="#FFFFFF">
			  <tr align="center" bgcolor="#e3F4F7">
			  <td width="15%" bgcolor="#C0C0C0">管理员账号</td>
			    <td width="15%" bgcolor="#C0C0C0">管理员名称</td>
			    <td width="11%" bgcolor="#C0C0C0">系统设置</td>
			    <td width="11%" bgcolor="#C0C0C0">读者管理</td>
			    <td width="11%" bgcolor="#C0C0C0">图书管理</td>
			    <td width="11%" bgcolor="#C0C0C0">图书借还</td>
			    <td width="10%" bgcolor="#C0C0C0">系统查询</td>
			    <td width="9%" bgcolor="#C0C0C0">权限设置</td>
			    <td width="8%" bgcolor="#C0C0C0">删除</td>
			  </tr>
  
			<s:iterator value="managerDTOs">
		        <tr >
		            <td><s:property value="id"/></td>
		            <td><s:property value="name"/></td>
		            <td><s:property value="systemSet"/></td>
		            <td><s:property value="readerSet"/></td>
		            <td><s:property value="bookSet"/></td>
		            <td><s:property value="borrowSet"/></td>
		            <td><s:property value="systemQuerySet"/></td>
		            
		            <%
		            	if(StaticDataPool.context.containsKey("系统设置")){ 
		            %>
		            <td align="center">
		            <a href="<s:url action="manager_modifyQuery.action">  
                    	<s:param name="manager.id" value="id"/>  
                 		</s:url>">权限设置  
         			</a>
         			</td>
         			<td align="center">
		            <a href="<s:url action="manager_delete.action">  
                    	<s:param name="manager.id" value="id"/>  
                 		</s:url>">删除 
         			</a>
         			</td>
		            <%
		            	}
		            	else{
		            %>
		            <td align="center">权限设置  </td>
         			<td align="center">删除  </td>
		            <%
		            	}
		            %>
		        </tr>
		    </s:iterator>
			</table>
			
		<%} %>
		</td>
      </tr>
    </table>
</td>
</tr>
</table><%@ include file="../copyright.jsp"%></td>
</tr>
</table>
</body>
</html>
