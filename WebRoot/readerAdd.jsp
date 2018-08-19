<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<html>
<script language="jscript">
function check(form){
	if(form.name.value==""){
		alert("请输入读者姓名!");
		form.name.focus();
		return false;
	}
	if(form.barcode.value==""){
		alert("请输入条形码!");
		form.barcode.focus();
		return false;
	}
	if(form.paperNO.value==""){
		alert("请输入证件号码!");
		form.paperNO.focus();
		return false;
	}
	if(form.birthday.value==""){
		alert("请输入出生日期!");
		form.paperNO.focus();
		return false;
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
        <td height="22" valign="top" class="word_orange">当前位置：读者管理 &gt; 读者档案管理 &gt; 添加读者信息 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
	<form name="form1" method="post" action="reader_add.action">
	<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="173" align="center">姓名：</td>
        <td width="427" height="39">
          <input name="reader.name" type="text">*</td>
      </tr>
      <tr>
          <td width="173" align="center">性别：</td>
          <td height="35">
          <input name="reader.sex" type="radio" class="noborder" id="radiobutton" value="男" checked>
          <label for="radiobutton">男 </label>
          <label><input name="reader.sex" type="radio" class="noborder" value="女">女</label></td>
      </tr>
      <tr>
        <td align="center">证件号码：</td>
        <td><input name="reader.id" type="text" id="barcode">
* </td>
      </tr>
      <tr>
        <td align="center">证件类型：</td>
        <td>
			<select name="reader.cardType" class="wenbenkuang" id="typeid">	
				<s:iterator value="cardTypes">			
	          		<option value="<s:property value="id"/>"><s:property value="name"/></option>
				</s:iterator>
	        </select>
		</td>
      </tr>
      <tr>
        <td align="center">出生日期：</td>
        <td><input name="reader.birthday" type="text" id="birthday">*(1988-01-01)</td>
      </tr>
      <tr>
        <td align="center">电话：</td>
        <td><input name="reader.tel" type="text" id="tel"></td>
      </tr>
      <tr>
        <td align="center">Email：</td>
        <td><input name="reader.email" type="text" id="email" size="50">
          <input name="operator" type="hidden" id="operator" value=""></td>
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
