<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
BODY {
	MARGIN: 0px;
	BACKGROUND-COLOR: #ffffff
}

BODY {
	FONT-SIZE: 15px;
	COLOR: #000000
}

TD {
	FONT-SIZE: 15px;
	COLOR: #000000
}

TH {
	FONT-SIZE: 15px;
	COLOR: #000000
}
</style>
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript">
	function exitSys() {
	alert("1212");
		$.ajax({ //发送了一个新的请求，与按钮这个请求完全不是一马事
				type : "post", //请求方式
				url : "/Ordersystem/dongtuichu.action", //请求地址
				dataType : "text",
				
				//async : false,

				success : function(data) { //请求成功后调用的回调函数，参数1【data】 请求返回的数据，这个数据类型是dataType  制定
					alert("212121212");
				}

			})
		
		

	}
</script>
</HEAD>
<body>
	<table width="100%" height="70%" border="0" cellspacing="0"
		cellpadding="0">
		<tr>
			<td width="100%"
				background="${pageContext.request.contextPath}/admin/images/top_11.png">
			</td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">

		<tr>
			<td height="30" valign="bottom"
				background="${pageContext.request.contextPath}/admin/images/mis_01.jpg">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="85%" align="left">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="#000000">
								<script language="JavaScript">
								<!--
									tmpDate = new Date();
									date = tmpDate.getDate();
									month = tmpDate.getMonth() + 1;
									year = tmpDate.getFullYear();
									document.write(year);
									document.write("年");
									document.write(month);
									document.write("月");
									document.write(date);
									document.write("日 ");

									myArray = new Array(6);
									myArray[0] = "星期日"
									myArray[1] = "星期一"
									myArray[2] = "星期二"
									myArray[3] = "星期三"
									myArray[4] = "星期四"
									myArray[5] = "星期五"
									myArray[6] = "星期六"
									weekday = tmpDate.getDay();
									if (weekday == 0 | weekday == 6) {
										document.write(myArray[weekday])
									} else {
										document.write(myArray[weekday])
									};
								// -->
								</script> </font>
						</td>
						<td width="15%">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="16"
										background="${pageContext.request.contextPath}/admin/images/mis_05b.jpg">
										<img
										src="${pageContext.request.contextPath}/admin/images/mis_05a.jpg"
										width="6" height="18">
									</td>
									<td width="155" valign="bottom"
										background="${pageContext.request.contextPath}/admin/images/mis_05b.jpg">
										<font color="blue"><button
											onclick="exitSys()">退出系统</button> </font></td>
									<td width="10" align="right"
										background="${pageContext.request.contextPath}/admin/images/mis_05b.jpg">
										<img
										src="${pageContext.request.contextPath}/admin/images/mis_05c.jpg"
										width="6" height="18">
									</td>
								</tr>
							</table>
						</td>
						<td align="right" width="5%"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</HTML>
