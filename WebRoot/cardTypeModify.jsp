<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<!-- 导入的标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%> 
<html>
<head>
<title>证件类型信息修改</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="CSS/style.css">
</head>

<body>
	<table width="292" height="175" border="0" cellpadding="0"
		cellspacing="0" bgcolor="#d9d9d9">
		<tr>
			<td valign="top"><table width="100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="3%" height="25">&nbsp;</td>
						<td width="94%">&nbsp;</td>
						<td width="3%">&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><table width="100%" height="131" border="0"
								cellpadding="0" cellspacing="0">
								<tr>
									<td align="center" valign="top">
										<form name="form1" method="post"
											action="cardType_modify.action">
											<input name="id" type="hidden" size="50" value="">
											<table width="100%" height="111" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="28%" align="center">类型名称：</td>
													<td width="72%">
													<input name="cardType.name" type="text" size="28" value=""></td>
												</tr>
												<tr>
													<td align="center">可借数量：</td>
													<td><input name="cardType.number" type="text" size="25"
														value=""> (本)</td>
												</tr>
												<tr>
													<td align="center">每本书可借天数：</td>
													<td><input name="cardType.days" type="text" size="25"
														value=""> (天)</td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td><input name="Submit" type="submit"
														class="btn_grey" value="保存"> &nbsp; <input
														name="Submit2" type="reset" class="btn_grey" value="重置">
														&nbsp; <input name="Submit3" type="button"
														class="btn_grey" onClick="window.close()" value="关闭"></td>
												</tr>
											</table>
										</form>
									</td>
								</tr>
							</table></td>
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
