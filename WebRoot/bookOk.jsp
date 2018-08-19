<%@page import="common.StaticDataPool"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<title>操作成功!</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<%
switch(StaticDataPool.TYPE){
	case 1:
	%>
		<script language="javascript">
		alert("图书信息添加成功!");
		opener.location.reload();
		window.location.href="book_query.action";
		</script>	
	<%	break;
	case 2:
	%>
		<script language="javascript">
		alert("图书信息修改成功!");
		opener.location.reload();
		window.location.href="book_query.action";
		</script>		
	<%	break;
	case 3:
	%>
		<script language="javascript">
		alert("图书信息删除成功!");
		window.location.href="book_query.action";
		</script>		
	<%	break;
}
%>
</body>
</html>