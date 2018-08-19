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
        <td height="22" valign="top" class="word_orange">当前位置：图书管理 &gt; 图书档案管理 &gt; 图书详细信息 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
		  <tr>
		    <td align="center" valign="top">
		    
			<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
		      <tr>
		        <td width="173" height="30" align="center">条&nbsp;形&nbsp;码：<s:property value="bookDetailDTO.code"/></td>
		      </tr>
		      <tr>
		        <td width="173" height="30" align="center">图书名称：<s:property value="bookDetailDTO.bookName"/></td>
		      </tr>
		      <tr>
		        <td height="30" align="center">图书类型：<s:property value="bookDetailDTO.code"/></td>
		      </tr>
		      <tr>
		        <td height="30" align="center">作&nbsp;&nbsp;&nbsp;&nbsp;者：<s:property value="bookDetailDTO.author"/></td>
		      </tr>
		      <tr>
		        <td height="30" align="center">译&nbsp;&nbsp;&nbsp;&nbsp;者：<s:property value="bookDetailDTO.translator"/></td>
		      </tr>
		      <tr>
		        <td height="30" align="center">出&nbsp;版&nbsp;社：<s:property value="bookDetailDTO.publisher"/></td>
		      </tr>
		      <tr>
		        <td height="30" align="center">价&nbsp;&nbsp;&nbsp;&nbsp;格：<s:property value="bookDetailDTO.price"/>(元)</td>
		      </tr>
		      <tr>
		        <td height="30" align="center">页&nbsp;&nbsp;&nbsp;&nbsp;码：<s:property value="bookDetailDTO.pageNumber"/></td>
		      </tr>
		      <tr>
		        <td height="30" align="center">书&nbsp;&nbsp;&nbsp;&nbsp;架：<s:property value="bookDetailDTO.bookcaseId"/></td>
		      </tr>
		      <tr>
		        <td height="30" align="center">入库时间：<s:property value="bookDetailDTO.inTime"/></td>
		      </tr>
		      <tr>
		        <td height="30" align="center">操&nbsp;作&nbsp;员：<s:property value="bookDetailDTO.operator"/></td>
		      </tr>
		      <tr>
		        <td align="center">&nbsp;</td>
		      <td>
				&nbsp;
		<input name="Submit2" type="button" class="btn_grey" value="返回" onClick="history.back()"></td>
      </tr>
    </table>
	</td>
  </tr>
</table></td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
</body>
</html>
