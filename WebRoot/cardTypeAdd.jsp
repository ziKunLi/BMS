<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<title>添加读者类型信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/style.css" rel="stylesheet">
</head>
<script language="jscript">
function check(form){
	if(form.name.value==""){
		alert("请输入类型名称!");
		form.name.focus();
		return false;
	}
	if(form.number.value==""){
		alert("请输入可借数量!");
		form.number.focus();
		return false;
	}	
	if(form.days.value==""){
		alert("请输入可借天数!");
		form.days.focus();
		return false;
	}
	if(form.id.value==""){
		alert("请输入证件编号!");
		form.id.focus();
		return false;
	}
}
</script>
<body>
<table width="400" height="225" border="0" cellpadding="0" cellspacing="0"  bgcolor="#d9d9d9">
  <tr>
    <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="3%" height="25">&nbsp;</td>
        <td width="94%">&nbsp;</td>
        <td width="3%">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><table width="100%" height="131"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center">	<form name="form1" method="post" action="cardType_add.action">
	<table height="100"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="84" align="center">证件编号：</td>
        <td width="191" height="39">
        <input name="cardType.id" type="text" size="28"></td>
      </tr>
      <tr>
        <td width="84" align="center">类型名称：</td>
        <td width="191" height="39">
          <input name="cardType.name" type="text" size="28">        </td>
      </tr>
      <tr>
        <td width="84" align="center">可借数量：</td>
        <td height="35"><input name="cardType.number" type="text" id="number">(本)</td>
      </tr>
      <tr>
        <td width="84" align="center">每本书可借天数：</td>
        <td width="191" height="39">
          <input name="cardType.days" type="text" size="28">        </td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
        <td><input name="Submit" type="submit" class="btn_grey" value="保存" onClick="return check(form1)">
          &nbsp;
          <input name="Submit2" type="button" class="btn_grey" value="关闭" onClick="window.close();"></td>
      </tr>
    </table>
	        </form></td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>

</body>
</html>
