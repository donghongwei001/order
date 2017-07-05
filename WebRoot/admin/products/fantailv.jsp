<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-2.1.3.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/bootstrap.min.js" charset="UTF-8"></script>
<!-- <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css"></link> -->
<style type="text/css">
	*{margin:0px;padding:0px;}
	div{
		border:0px solid red;
	}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css" type="text/css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/bootstrap-datetimepicker.min.css" type="text/css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
</head>
<body>
	<div class="container" style="width:90%">
		<div class="row">
			<div class="col-md-2" >
			
			<div class="list-group" style="margin-top:80px">
					<a href="${pageContext.request.contextPath}/serv_fantailv.action" target="main" class="list-group-item">今日统计</a> 
					<a href="${pageContext.request.contextPath}/serv_fantailv.action?day=3" target="main"
						class="list-group-item">最近三天</a> 
					<a href="${pageContext.request.contextPath}/serv_fantailv.action?day=7"
						target="main" class="list-group-item">最近七天</a>
					<a href="${pageContext.request.contextPath}/serv_fantailv.action?day=30"
						target="main" class="list-group-item">最近一月</a>


				</div>
			
			</div>
			<div class="col-md-10">
				<h3 align="center"><b>餐桌翻台率查询</b></h3>
				<form class="form-inline" action="${pageContext.request.contextPath}/serv_fantailv.action">
					<!-- <div class="form-group">
						<label for="exampleInputName2">开始时间</label> 
						<input type="text" class="form-control" name="starttime" id="exampleInputName2">
					</div> -->
					
					<div class="form-group">
                		<label for="dtp_input2" class="control-label">开始时间</label>
                		<div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
	                    	<input class="form-control" size="16" name="starttime" type="text" value="${starttime}" readonly>
	                   		<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
               			 </div>
						<input type="hidden" id="dtp_input2" value="" /><br/>
           			</div>
           			
					<div class="form-group">
                		<label for="dtp_input2" class="control-label">结束时间</label>
                		<div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
	                    	<input class="form-control" size="16" name="endtime" type="text" value="${endtime }" readonly>
	                   		<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
               			 </div>
						<input type="hidden" id="dtp_input2" value="" /><br/>
           			</div>
					
					
					<button type="submit" class="btn btn-success">查询</button>
				</form>

				<div style="margin-top:30px;border:1px solid #aaa;">

					<table class="table table-striped">
						<tr align="center">
							<th align="center">餐桌编号</th>
							<th align="center">订单数量</th>
							<th align="center">消费金额</th>
						</tr>
						<c:forEach items="${showftl }" var="ft">
						<tr>
							<td align="center">${ft.table_id }</td>
							<td align="center">${ft.sailnum }</td>
							<td align="center">${ft.countmoney }</td>
						</tr>	
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
    
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
	
</script>
</html>