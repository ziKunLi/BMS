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
		alert("管理员信息添加成功!");
		opener.location.reload();
		window.close();
		window.location.href="manager_query.action";
		</script>	
	<%	break;
	case 2:
	%>
		<script language="javascript">
		alert("管理员权限设置成功!");
		window.location.href="manager_query.action";
		</script>		
	<%	break;
	case 3:
	%>
		<script language="javascript">
		alert("管理员信息删除成功!");
		window.location.href="manager_query.action";
		</script>		
	<%	break;
}
%>
</body>
</html>