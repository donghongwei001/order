<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">


</HEAD>

<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/Table_addzhuozi.action" method="post">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加餐桌</STRONG> </strong>
				</td>
			</tr>
	<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">餐桌编号：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="name" class="bg"/>
				</td>
				
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">可供餐人数：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="pnum" class="bg" />
				</td>
				
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">餐桌服务员：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
				<input type="text" name="fuwuyuan" class="bg" />
				</TD>
			</TR>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">餐桌状态：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
				<input type="text" name="zhuangtai" class="bg" />
				</TD>
			</TR>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					
					
						
					<input type="submit" class="button_ok" value="确定">	
						
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					
					
					
					<input type="reset" value="重置" class="button_cancel">

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1">
					
					</span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>