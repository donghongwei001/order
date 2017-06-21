<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kitchen_sortFood</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-2.1.3.js"></script>
<script src="../js/bootstrap.min.js"></script>
<style type="text/css">
* {
	margin: 0px;
	padding: opx;
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="#">待做菜品<span class="badge" id="usetable">12</span></a></li>
		<!-- <li role="presentation"><a href="#">正在做菜品<span class="badge" id="surplustable">12</span>	</a></li> -->
		<li role="presentation"><a href="#">正做菜品</a></li>
	</ul>
<div class="col-md-5">
	<h3>待做菜单</h3>
	<table class="table table-hover" style="font-size:14">
		<tr>
			<th>序号</th>
			<th>桌号</th>
			<th>服务员</th>
			<th>菜名</th>
			<th>数量</th>
			<th>备注</th>
			<th>做菜</th>			
		</tr>
		<c:forEach items="${list }" var="li" varStatus="sta">
		<tr>
			<td>${sta.count }</td>
			<td>${li.table_name }</td>
			<td>${li.emp_name }</td>
			<td>${li.food_name}</td>
			<td>${li.food_num }</td>
			<td>${li.order_food_mark }</td>
			<td><a href="servlet/kitchenServlet?method=makefood&id=${li.fk_order_id }" type="button" class="btn btn-info btn-xs">做菜</a></td>
			
		</tr>
		</c:forEach>
		<tr>
			<td>2</td>
			<td>005</td>
			<td>李四</td>
			<td>麻婆豆腐</td>
			<td>1</td>
			<td>微辣</td>
			<td><button type="button" class="btn btn-info btn-xs">做菜</button></td>
		</tr>
	</table>
</div>
<div class="col-md-7">
	<h3>已做菜单</h3>
	<table class="table table-hover" style="font-size:14">
		<tr>
			<th>序号</th>
			<th>桌号</th>
			<th>服务员</th>
			<th>菜名</th>
			<th>数量</th>
			<th>备注</th>
			
			<th>上菜</th>
		</tr>
		<tr>
			<td>1</td>
			<td>002</td>
			<td>小二</td>
			<td>小炒肉</td>
			<td>1</td>
			<td>微辣</td>
			<td><button type="button" class="btn btn-success btn-xs">上菜</button></td>
		</tr>
		<tr>
			<td>2</td>
			<td>005</td>
			<td>李四</td>
			<td>麻婆豆腐</td>
			<td>1</td>
			<td>微辣</td>
			<td><button type="button" class="btn btn-success btn-xs">上菜</button></td>
		</tr>
	</table>
</div>
</body>
</html>