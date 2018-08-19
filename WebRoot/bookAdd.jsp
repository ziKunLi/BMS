<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!-- 导入的标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ page import="java.util.*"%>
<html>
<script language="jscript">
function check(form){
	if(form.code.value==""){
		alert("请输入条形码!");form.barcode.focus();return false;
	}
	if(form.bookName.value==""){
		alert("请输入图书名称!");form.bookName.focus();return false;
	}
	if(form.price.value==""){
		alert("请输入图书定价!");form.price.focus();return false;
	}
}
</script>
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
        <td height="22" valign="top" class="word_orange">当前位置：图书管理 &gt; 图书档案管理 &gt; 添加图书信息 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
    
    
	<form name="form1" method="post" action="book_add.action">
	<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="173" align="center">条&nbsp;形&nbsp;码：</td>
        <td width="427" height="39"><input name="book.code" type="text" id="barcode">*</td>
      </tr>
      <tr>
        <td align="center">图书名称：</td>
        <td height="39"><input name="book.bookName" type="text" id="bookName" size="50">* </td>
      </tr>
      <tr>
        <td align="center">图书类型：</td>
        <td>
		<select name="book.typeId" class="wenbenkuang" id="typeId">	
		<s:iterator value="bookTypes">
          <option value="<s:property value="id"/>"><s:property value="typeName"/></option>
         </s:iterator>
        </select>
        </td>
      </tr>
      <tr>
        <td align="center">作者：</td>
        <td><input name="book.author" type="text" id="author" size="40"></td>
      </tr>
      <tr>
        <td align="center">译者：</td>
        <td><input name="book.translator" type="text" id="translator" size="40"></td>
      </tr>
      <tr>
        <td align="center">出版社：</td>
        <td><select name="book.publisher" class="wenbenkuang">	
		<s:iterator value="publishings">		
          <option value="<s:property value="publisher_id"/>"><s:property value="publisher_name"/></option>
        </s:iterator>
        </select> </td>
      </tr>
      <tr>
        <td align="center">价格：</td>
        <td><input name="book.price" type="text" id="price">(元) * </td>
      </tr>
      <tr>
        <td align="center">页码：</td>
        <td><input name="book.page" type="text" id="page"></td>
      </tr>
      <tr>
        <td align="center">书架：</td>
        <td>
        <select name="book.bookcaseId" class="wenbenkuang" id="bookcaseid">	
	        <s:iterator value="bookcases">		
	          <option value="<s:property value="id"/>"><s:property value="name"/></option>
	        </s:iterator>
        </select></td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
        <td>
        <input name="Submit" type="submit" class="btn_grey" value="保存" onClick="return check(form1)">
		&nbsp;
		<input name="Submit2" type="button" class="btn_grey" value="返回" onClick="history.back()"></td>
      </tr>
    </table>
	</form>
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
