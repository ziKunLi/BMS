<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<html>
<%
Collection coll=(Collection)request.getAttribute("bookType");
%>
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
        <td height="22" valign="top" class="word_orange">当前位置：图书管理 &gt; 图书类型设置 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
        <%
			if(ActionContext.getContext().getContextMap().containsKey(StaticDataPool.BOOK_TYPE_SIZE)
					&&(Integer)ActionContext.getContext().get(StaticDataPool.BOOK_TYPE_SIZE) == 0){
		%>
          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">暂无图书类型信息！</td>
            </tr>
          </table>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
      <a href="#" onClick="window.open('bookTypeAdd.jsp','','width=400,height=225')">添加图书类型信息</a> </td>
  </tr>
</table>
 	<%
		}
		else{
  		//通过迭代方式显示数据
  	%>
 <table width="91%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="82%">&nbsp;      </td>
	<td width="18%" align="right">
    <a href="#" onClick="window.open('bookTypeAdd.jsp','','width=292,height=175')">添加图书类型信息</a> </td>	  
  </tr>
</table>  
  <table width="91%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
  	<td width="25%" bgcolor="#C0C0C0">图书类型编号</td>
    <td width="25%" bgcolor="#C0C0C0">图书类型名称</td>
    <td width="25%" bgcolor="#C0C0C0">可借天数</td>
    <td width="25%" bgcolor="#C0C0C0">操作</td>
  </tr>
  <tr>
    <s:iterator value="bookTypes">
	<tr >
	     <td width="25%"><s:property value="id"/></td>
	     <td style="padding:5px;"><s:property value="typeName"/></td>
	     <td style="padding:5px;"><s:property value="days"/></td>
	     <td align="center">
	     	<a href="
		       	<s:url action="bookType_modifyQuery.action">  
           			<s:param name="bookType.id" value="id"/>  
           		</s:url>">
           		修改
         	</a>
         </td>
    	 <td align="center">
    	 	<a href="
		       	<s:url action="bookType_delete.action">  
           			<s:param name="bookType.id" value="id"/>  
           		</s:url>">
           		删除
         	</a>
		</td>
	</tr>
  </s:iterator> 
	<%
	  }
	%>  
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
