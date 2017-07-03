<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet"
	media="screen">
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	.table-hover{
		width:70%;
		margin-left:200px;
		border:1px solid gray;
	}
	td{
		width:300px;
		text-align:center;
		font-size:20px;
	}
</style>
</head>

<body>
	<a href="order_list.jsp"><button type="button" class="btn btn-success">返回</button></a>
		<table class="table table-hover">
				<tr onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">
					<td>菜名</td><td>数量</td><td>单价</td><td>状态</td>
				</tr>
					<c:forEach items="${xiangqing}" var="a">
						<tr>
							<c:forEach items="${a}" var="b">
								<td>${b}</td>
							</c:forEach>
						</tr>
					</c:forEach>
		</table>
		<table class="table table-hover">
				<tr onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">
					<td>开始时间</td><td>结束时间</td><td>消费总金额</td>
				</tr>
					<c:forEach items="${shijian}" var="a">
						<tr>
							<c:forEach items="${a}" var="b">
								<td>${b}</td>
							</c:forEach>
						</tr>
					</c:forEach>
		</table>
</body>
<script type="text/javascript" src="../js/jquery-2.1.3.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
</html>
