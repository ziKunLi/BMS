<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!-- 导入的标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ page import="java.util.*"%>
<html>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
		<script language="javascript">
		function checkreader(form){
			if(form.barcode.value==""){
				alert("请输入读者条形码!");
				form.barcode.focus();
				return;
			}
			
			form.submit();
		}
		function checkbook(form){
			if(form.barcode.value==""){
				alert("请输入读者条形码!");
				form.barcode.focus();
				return;
			}		
			if(form.inputkey.value==""){
				alert("请输入查询关键字!");
				form.inputkey.focus();
				return;
			}

			if(form.number.value-form.borrowNumber.value<=0){
				alert("您不能再借阅其他图书了!");
				return;
			}
			form.submit();
		}
		</script>
</head>
<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="100%" height="509"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="27" valign="top" style="padding:5px;" class="word_orange">当前位置：图书借还 &gt; 图书借阅 &gt;&gt;&gt;</td>
  </tr>
  <tr>
    <td align="center" valign="top" style="padding:5px;"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
	<form name="form1" method="post" action="borrow_borrow.action">
      <tr>
        <td height="47" background="Images/borrowBackRenew.gif">&nbsp;</td>
      </tr>
      <tr>
        <td height="72" align="center" valign="top" background="Images/main_booksort_1.gif" bgcolor="#F8BF73"><table width="96%" border="0" cellpadding="1" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#F8BF73">
          <tr>
            <td valign="top" bgcolor="#A8A8A8">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                 <tr>
                     <td width="24%" height="18" style="padding-left:7px;padding-top:7px;">
                      	<img src="Images/reader_checkbg.jpg" width="142" height="18">
                        </td>
                         <td width="76%" style="padding-top:7px;">
                          	书籍条形码：
                         <input name="borrow.bookCode" type="text" id="barcode" size="24">&nbsp;
                  </tr>
                  <tr><td height="13" align="left" style="padding-left:7px;"><hr width="90%" size="1"></td></tr>
                  <tr>
                    <td align="center"><table width="96%" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td height="27">读者姓名：<input name="borrow.readerName" type="text" id="paperType"></td>
                          <td>证件号码：<input name="borrow.cardNo" type="text" id="paperNo"></td>
                        </tr>
                    </table></td>
                  </tr>
				 
              </table></td>
          </tr>
           <input name="Button" type="submit" class="btn_grey" value="完成借阅" >
        </table></td>
		 
      </tr>
      <tr>
        <td height="19" background="Images/main_booksort_2.gif">&nbsp;</td>
      </tr>
	 </form>
    </table></td>
  </tr>
</table>
    <%@ include file="copyright.jsp"%></td>
  </tr>
</table>
</body>
</html>