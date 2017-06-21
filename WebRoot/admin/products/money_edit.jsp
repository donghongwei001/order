
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/check.js"></script>

<style type="text/css">
#div1 {
	float: left;
	margin-left: 350px;
	margin-right: 800px;
}

td {
	width: 800px;
	height:50px;
}
</style>

</HEAD>
<script type="text/javascript" src="../js/jquery-2.1.3.js"
		charset="UTF-8"></script>

<body>
	
	<div id="div1">帐号</div>
	<div>密码</div>
	<table border=1 width=100%>
	<c:forEach items="${Listorder.rows}" var="b">
	<tr>
    	<td>${b.order_id}</td><td>${b.order_time}</td><td>${b.order_fk_tabid}</td><td>${b.order_money}</td><td>${b.emp_name}</td><td>${b.cus_name}</td><td>${b.order_dt_score}</td><td>${b.oeder_dt_mark}</td><br>
    </tr>
	</c:forEach>
	 
	
	</table>
	${Listorder.pageStr}    ${Listorder.total }     ${Listorder.allPage }
	



</body>
<script type="text/javascript">
	
	
</script>
</HTML>