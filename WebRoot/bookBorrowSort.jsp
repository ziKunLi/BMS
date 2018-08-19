<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：图书借阅查询 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
        <%
        	int size = (Integer)ActionContext.getContext().get(StaticDataPool.BOOK_BORROW_SIZE);
	        if(size == 0){
        %>
          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">暂无图书借阅信息！</td>
            </tr>
          </table>
         <%
	        }
	        else{
	        
         %>
         	   
          <td valign="top" bgcolor="#C0C0C0" style="padding:5px">
            <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#A8A8A8" bordercolordark="#C0C0C0" bordercolorlight="#A8A8A8">
               <tr align="center" bgcolor="#A8A8A8">
			  	<td width="8%" bgcolor="#C0C0C0">借阅次数</td>
			    <td width="11%" bgcolor="#C0C0C0">图书条形码</td>
			    <td width="17%" bgcolor="#C0C0C0">图书名称</td>
			    <td width="15%" bgcolor="#C0C0C0">图书类型</td>
			    <td width="16%" bgcolor="#C0C0C0">书架</td>
			    <td width="14%" bgcolor="#C0C0C0">出版社</td>
			    <td width="11%" bgcolor="#C0C0C0">作者</td>
			    <td colspan="2" bgcolor="#C0C0C0">定价(元)</td>
			   </tr>
               <s:iterator value="bookBorrowDTOs">
		          <tr >
		       	   <td height="25" style="padding:5px;"><s:property value="bookName"/></td>
		           <td style="padding:5px;"><s:property value="borrowTime"/></td>
		           <td style="padding:5px;"><s:property value="shouldBackTime"/></td>
		           <td align="center"><s:property value="readerId"/></td>
		           <td align="center"><s:property value="readerName"/></td>
		           <td width="14%" align="center"><s:property value="bookcaseId"/></td>
		           <td width="14%" align="center"><s:property value="price"/></td>
		          </tr>
		   	   </s:iterator>
 			   <input name="borrowNumber" type="hidden" id="borrowNumber" value="">
          </table>
		</td>
		<%
         	}
	     %>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
</body>
</html>
