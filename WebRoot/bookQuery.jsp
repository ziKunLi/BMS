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
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：系统查询 &gt; 图书档案查询 &gt;&gt;&gt;</td>
      </tr>
      <tr>
      <td align="center" valign="top">
      
	 <form action="book_ifQuery.action" method="post" name="form1">  
	 <table width="98%" height="38"  border="0" cellpadding="0" cellspacing="0" bgcolor="#C0C0C0" class="tableBorder_gray">
	  <tr>
	    <td align="center" bgcolor="#C0C0C0">&nbsp;
	    <img src="Images/search.gif" width="45" height="28">
	    </td>
	    <td bgcolor="#C0C0C0">请选择查询依据：
	      <select name="type" class="wenbenkuang" id="f">
	        <option value="1">条形码</option>
	        <option value="2">类别</option>
	        <option value="3" selected>书名</option>
	        <option value="4">作者</option>
	        <option value="5">出版社</option>
	        <option value="6">书架</option>
	      </select>
	      <input name="key" type="text" id="key" size="50">
	      <input name="Submit" type="submit" class="btn_grey" value="查询"></td>
	  </tr>
	</table>
	</form>
		<%
			int size = (Integer)ActionContext.getContext().get(StaticDataPool.BOOK_QUERY_SIZE);
			if(size == 0){
		%>
          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">暂无图书信息！</td>
            </tr>
          </table>
          <%
			}else{
		  %>  
		  <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
			  	<tr align="center" bgcolor="#e3F4F7">
			    <td width="17%" bgcolor="#C0C0C0">条形码</td>  
			    <td width="31%" bgcolor="#C0C0C0">图书名称</td>
			    <td width="18%" bgcolor="#C0C0C0">图书类型</td>
			    <td width="19%" bgcolor="#C0C0C0">出版社</td>
			    <td width="15%" bgcolor="#C0C0C0">书架</td>
			    </tr>
    
    			<s:iterator value="bookQueryDTOs">
		        <tr >
		            <td style="padding:5px;">&nbsp;<s:property value="code"/></td>
		            <td style="padding:5px;">
		            	<a href="<s:url action="book_detail.action">  
                    		<s:param name="book.code" value="code"/>  
                 			</s:url>">
                 			<s:property value="bookName"/> 
         				</a></td>
		            <td style="padding:5px;"><s:property value="bookTypeName"/></td>
		            <td style="padding:5px;"><s:property value="publisherName"/></td>
		            <td style="padding:5px;"><s:property value="bookcaseId"/></td>
		        </tr>
		    	</s:iterator>
		    	 </table>
			<%
			  }
			%>  
</table>
	
</td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</body>
</html>
