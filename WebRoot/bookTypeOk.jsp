<%@page import="common.StaticDataPool"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<title>�����ɹ�!</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<%
switch(StaticDataPool.TYPE){
	case 1:
	%>
		<script language="javascript">
		alert("ͼ��������Ϣ��ӳɹ�!");
		opener.location.reload();
		window.close();
		</script>	
	<%	break;
	case 2:
	%>
		<script language="javascript">
		alert("ͼ��������Ϣ�޸ĳɹ�!");
		opener.location.reload();
		window.close();
		</script>		
	<%	break;
	case 3:
	%>
		<script language="javascript">
		alert("ͼ��������Ϣɾ���ɹ�!");
		window.location.href="bookType_query.action";
		</script>		
	<%	break;
}
%>
</body>
</html>