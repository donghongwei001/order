<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kitchen_sortFood</title>
<link href="${pageContext.request.contextPath }/admin/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/admin/js/jquery-2.1.3.js"></script>
<script src="${pageContext.request.contextPath }/admin/js/bootstrap.min.js"></script>
<style type="text/css">
* {
	margin: 0px;
	padding: opx;
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<%-- <li role="presentation" class="active"><a href="#">待做菜品<span class="badge" id="usetable">${count}</span></a></li>
		<!-- <li role="presentation"><a href="#">正在做菜品<span class="badge" id="surplustable">12</span>	</a></li> -->
		<li role="presentation"><a href="#">已做菜品</a></li> --%>
		 <li role="presentation"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">待做菜品<span class="badge" id="usetable">${count}</span></a>
		 <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">已做菜品</a>
	</ul>
	
	<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home"><div class="col-md-5">
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
			<td>${li.tabid }</td>
			<td>${li.wfb.emp_name }</td>
			<td>${li.wfb.food_name}</td>
			<td>${li.foodnum }</td>
			<td>${li.wfb.order_food_mark }</td>
			<td><a href="${pageContext.request.contextPath}/kitchen_doFood.action?orderfoodid=${li.order_food_id }&status=2" type="button" class="btn btn-info btn-xs">做菜</a></td>
			
		</tr>
		</c:forEach>
	</table>
</div>
<div class="col-md-7">
	<h3>正做菜单</h3>
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
		<c:forEach items="${doing }" var="dg" varStatus="di">
		<tr>
			<td>${di.count }</td>
			<td>${dg.tabid }</td>
			<td>${dg.wfb.emp_name }</td>
			<td>${dg.wfb.food_name}</td>
			<td>${dg.foodnum }</td>
			<td>${dg.wfb.order_food_mark }</td>
			<td><a type="button" class="btn btn-success btn-xs" href="${pageContext.request.contextPath}/kitchen_servingFood.action?orderfoodid=${dg.order_food_id }&status=3&orderId=${dg.orderId}">上菜</a></td>
		</tr>
		</c:forEach>
	</table>
</div></div>
    <!-- <div role="tabpanel" class="tab-pane" id="profile">...okiokiokioki</div>
    <div role="tabpanel" class="tab-pane" id="messages">..srtghjl.</div> -->
    <div role="tabpanel" class="tab-pane" id="settings">
	<table class="table table-hover" style="font-size:14">
		<tr>
			<th>序号</th>
			<th>桌号</th>
			<th>服务员</th>
			<th>菜名</th>
			<th>数量</th>
			<th>上菜时间</th>
			
			<th>备注</th>
			
			<th>上菜</th>
		</tr>
		<c:forEach items="${done }" var="dg" varStatus="di">
		<tr>
			<td>${di.count }</td>
			<td>${dg.table_name }</td>
			<td>${dg.emp_name }</td>
			<td>${dg.food_name}</td>
			<td>${dg.food_num }</td>
			<td>${dg.servingtime }</td>
			<td>${dg.order_food_mark }</td>
			<td><a type="button" class="btn btn-success btn-xs" href="${pageContext.request.contextPath}/kitchen_doFood.action?orderfoodid=${dg.order_food_id }&status=1">查看</a></td>
		</tr>
		</c:forEach>
	</table></div>
  </div>
	

</body>
</html>