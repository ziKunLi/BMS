<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!-- 导入的标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%> 
<html>
<head>
<title>修改书架信息</title>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<link href="CSS/style.css" rel="stylesheet">
</head>

<body>
<table width="292" height="175" border="0" cellpadding="0" cellspacing="0" background="Images/subBG.jpg">
  <tr>
    <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="3%" height="38">&nbsp;</td>
        <td width="94%">&nbsp;</td>
        <td width="3%">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>
   <form name="form1" method="post" action="bookcase_modify.action">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="50" align="center">            书架编号：
            <input name="bookcase.id" type="text" size="50" value="<s:property value="bookcase.id"/>">
            书架名字：
    		<input name="bookcase.name" type="text" value="<s:property value="bookcase.name"/>"></td>
      </tr>
      <tr>
        <td height="35" align="center"><input name="Submit" type="submit" class="btn_grey" value="保存">&nbsp;
		<input name="Submit2" type="reset" class="btn_grey" value="重置">&nbsp;
		<input name="Submit3" type="button" class="btn_grey" onClick="window.close()" value="关闭"></td>
      </tr>
    </table>
   </form>
   </td>
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
