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
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：读者管理 &gt; 读者档案管理 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
        <%
        	int size = (Integer)ActionContext.getContext().get(StaticDataPool.READER_SIZE);
        	if(size == 0){
        %>
          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">暂无读者信息！</td>
            </tr>
          </table>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
      <a href="reader_addQuery.action">添加读者信息</a> </td>
  </tr>
</table>
		<%
        	}
        	else{
  		%>
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="87%">&nbsp;      </td>
<td width="13%">
      <a href="reader_addQuery.action">添加读者信息</a></td>	  
  </tr>
</table>  
  <table width="95%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="13%" bgcolor="#C0C0C0">证件编号</td>  
    <td width="10%" bgcolor="#C0C0C0">姓名</td>
    <td width="12%" bgcolor="#C0C0C0">性别</td>
    <td width="12%" bgcolor="#C0C0C0">生日</td>
    <td width="12%" bgcolor="#C0C0C0">电话</td>
    <td width="15%" bgcolor="#C0C0C0">邮箱</td>
    <td width="5%" bgcolor="#C0C0C0">修改</td>
    <td width="5%" bgcolor="#C0C0C0">删除</td>
  </tr>
  <tr>
  	<s:iterator value="readers">
	    <td style="padding:5px;"><s:property value="id"/></td>  
	    <td style="padding:5px;">
	    	<a href="
		      	<s:url action="reader_detail.action">  
            	<s:param name="reader.id" value="id"/>  
            	</s:url>">
            	<s:property value="name"/>
         	</a>
	    <td style="padding:5px;"><s:property value="sex"/></td>
	    <td align="center"><s:property value="tel"/></td>
	    <td align="center"><s:property value="email"/></td>
	    <td align="center">
	    	<a href="
		      	<s:url action="reader_modifyQuery.action">  
            	<s:param name="reader.id" value="id"/>  
            	</s:url>">
            	修改
         	</a></td>
	    <td align="center">
	    	<a href="
		      	<s:url action="reader_delete.action">  
            	<s:param name="reader.id" value="id"/>  
            	</s:url>">
            	删除
         	</a></td>
    </s:iterator>
  </tr>
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
