<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!-- 导入的标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ page import="java.util.*"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<table width="778" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td align="center" valign="top" style="padding:5px;"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="20" align="right" valign="middle" class="word_orange">当前位置：首页 &gt;&gt;&gt;&nbsp;</td>
      </tr>
      <tr>
        <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="57" background="Images/main_booksort.gif"t>&nbsp;</td>
          </tr>
          <tr>
            <td height="72" valign="top"><table width="100%" height="63"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="2%" rowspan="2">&nbsp;</td>
                <td width="96%" align="center" valign="top">
                <table width="100%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#B7B6B6" bordercolorlight="#FFFFFF">
                  <tr align="center">
                    <td width="5%" height="25">排名</td>
					<td width="10%">图书条形码</td>
					<td width="24%">图书名称</td>
					<td width="10%">图书类型</td>
					<td width="10%">书架</td>
					<td width="14%">出版社</td>
					<td width="11%">作者</td>
					<td>定价(元)</td>
				    <td>借阅次数</td>
                  </tr>
           
                </table>
                  </td>
                <td width="2%" rowspan="2">&nbsp;</td>
              </tr>
              <tr>
                <td height="30" align="right" valign="middle"><a href=borrow.do?action=bookBorrowSort>&nbsp;更多</a></td>
              </tr>
            </table></td>
          </tr>
        </table>
          </td>
      </tr>
    </table>
    </td>
  </tr>
</table>
<%@ include file="copyright.jsp"%>
</body>
</html>
