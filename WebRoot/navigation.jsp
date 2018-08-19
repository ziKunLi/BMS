<%@page import="common.StaticDataPool"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page contentType="text/html; charset=utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="JS/onclock.JS"></script>
<script src="JS/menu.JS"></script>
<div class=menuskin id=popmenu
      onmouseover="clearhidemenu();highlightmenu(event,'on')"
      onmouseout="highlightmenu(event,'off');dynamichide(event)" style="Z-index:100;position:absolute;"></div>
	<table width="778"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr bgcolor="#C0C0C0">
        <td width="3%" height="27">&nbsp;</td>
        <td width="29%">
        	<div id=x class="word_white">
        		<script>
        		setInterval(function(){
				var myDate = new Date();
				var month = myDate.getMonth() + 1;
				var x=myDate.getFullYear()+"年"+ month +"月"+myDate.getDate()+"日 "+myDate.getHours()+"点"+myDate.getMinutes()+"分"+myDate.getSeconds()+"秒";
				document.getElementById("x"). innerHTML=x;
				},1000); 
				</script>
        	</div>
        </td>
		<script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="logout.jsp";
				}
			}
		</script>
      <td width="66%" align="right" bgcolor="#A8A8A8" class="word_white"><a href="main.jsp" class="word_white">
      	首页
      	</a> |
        	<%if(StaticDataPool.context.containsKey("系统设置")&&(Integer)StaticDataPool.context.get("系统设置") == 1){%>
        <a  onmouseover=showmenu(event,sysmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand" >
        	系统设置
        </a> | 
        <%}%>
        	<%if(StaticDataPool.context.containsKey("图书管理")&&(Integer)StaticDataPool.context.get("图书管理") == 1){%>
        <a  onmouseover=showmenu(event,bookmenu) onmouseout=delayhidemenu() style="CURSOR:hand"  class="word_white">
        	图书管理
        </a> | 
        <%}%>
        	<%if(StaticDataPool.context.containsKey("读者管理")&&(Integer)StaticDataPool.context.get("读者管理") == 1){%>
        <a  onmouseover=showmenu(event,readermenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand" >
        	读者管理
        </a> |
        <%}%>
         	<%if(StaticDataPool.context.containsKey("图书借还")&&(Integer)StaticDataPool.context.get("图书借还") == 1){%>
        <a  onmouseover=showmenu(event,borrowmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand">
        	图书借还
        </a> |
        <%}%>
         	<%if(StaticDataPool.context.containsKey("系统查询")&&(Integer)StaticDataPool.context.get("系统查询") == 1){%>
        <a  onmouseover=showmenu(event,querymenu) onmouseout=delayhidemenu()  class="word_white" style="CURSOR:hand" >
        	系统查询
        </a> |
        <%}%>
        <a  href="manager.do?action=querypwd" class="word_white">
        	更改口令
        </a> | <a href="#" onClick="quit()" class="word_white">
        	退出系统</a></td>
        <td width="2%" bgcolor="#C0C0C0">&nbsp;</td>
  		</tr>
      <tr bgcolor="#C0C0C0">
        <td height="9" colspan="4" background="Images/navigation_bg_bottom.gif"></td>
      </tr>
</table>
