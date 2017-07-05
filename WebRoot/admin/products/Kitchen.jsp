<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="20;url=http:${pageContext.request.contextPath}/kitchen_findFood.action">
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
    <div role="tabpanel" class="tab-pane active" id="home"><div class="col-md-7">
	<h3>待做菜单</h3>
	<table class="table table-hover" style="font-size:14">
		<tr>
			<th>序号</th>
			<th>桌号</th>
			<th>服务员</th>
			<th>菜名</th>
			<th>数量</th>
			<th>订单时间</th>
			<th>上菜间隔</th>
			<th>催菜</th>
			<th>备注</th>
			<th>做菜</th>			
		</tr>
		<tbody id="waitfood">
		<c:forEach items="${list }" var="li" varStatus="sta">
		<tr>
			<td>${sta.count }</td>
			<td>${li.tabid }</td>
			<td>${li.wfb.emp_name }</td>
			<td>${li.wfb.food_name}</td>
			<td>${li.foodnum }</td>
			<td>${li.wfb.time }</td>
			<td>${li.wfb.lasttime }</td>
			<td>${li.wfb.order_press }</td>
			<td>${li.wfb.order_food_mark }</td>
			<td><a href="${pageContext.request.contextPath}/kitchen_doFood.action?orderfoodid=${li.order_food_id }&status=2" type="button" class="btn btn-info btn-xs">做菜</a></td>
			
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagelist">
		<span id="spanFirst" class="button border-main">首页</span> <span
			id="spanPre" class="button border-main">上一页</span> <span
			id="spanNext" class="button border-main">下一页</span> <span
			id="spanLast" class="button border-main">尾页</span> 第<span
			id="spanPageNum"></span>页/共 <span id="spanTotalPage"></span>页
	</div>
</div>
<div class="col-md-5">
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
			
			<!-- <th>上菜</th> -->
		</tr>
				<tbody id="tbody">
					<c:forEach items="${done.rows }" var="dg" varStatus="di">
						<tr>
							<td>${di.count }</td>
							<td>${dg.table_name }</td>
							<td>${dg.emp_name }</td>
							<td>${dg.food_name}</td>
							<td>${dg.food_num }</td>
							<td>${dg.servingtime }</td>
							<td>${dg.order_food_mark }</td>
							<%-- <td><a type="button" class="btn btn-success btn-xs"
								href="${pageContext.request.contextPath}/kitchen_doFood.action?orderfoodid=${dg.order_food_id }&status=1">查看</a>
							</td>
						</tr> --%>
					</c:forEach>
				</tbody>
			</table>
	<button class="pre" onclick="bac()">上一页</button>
	<button class="bac" onclick="pree(4)">下一页</button><span id="currentpage">第1页</span><span>共${done.allPage }页</span>
	<input type="hidden" value="${done.allPage }" id="allpage">
	</div>
  </div>
  
  
	<div style="display: none">
		<span id="spanFirstt">首页</span> <span id="spanPret">上一页</span> <span
			id="spanNextt"> 下一页</span> <span id="spanLastt">尾页</span> 第 <span
			id="spanPageNumt"></span>页/共<span id="spanTotalPaget"></span>页
	</div>
  
</body>
<script type="text/javascript">

	//分页
	var theTable = document.getElementById("waitfood");
	var totalPage = document.getElementById("spanTotalPage");
	var pageNum = document.getElementById("spanPageNum");

	var spanPre = document.getElementById("spanPre");
	var spanNext = document.getElementById("spanNext");
	var spanFirst = document.getElementById("spanFirst");
	var spanLast = document.getElementById("spanLast");

	var totalPaget = document.getElementById("spanTotalPaget");
	var pageNumt = document.getElementById("spanPageNumt");

	var spanPret = document.getElementById("spanPret");
	var spanNextt = document.getElementById("spanNextt");
	var spanFirstt = document.getElementById("spanFirstt");
	var spanLastt = document.getElementById("spanLastt");
	


	var numberRowsInTable = theTable.rows.length;
	var pageSize = 10;
	var page = 1;

	//下一页     
	function next() {

		hideTable();

		currentRow = pageSize * page;
		maxRow = currentRow + pageSize;
		if (maxRow > numberRowsInTable)
			maxRow = numberRowsInTable;
		for ( var i = currentRow; i < maxRow; i++) {
			theTable.rows[i].style.display = '';
		}
		page++;

		if (maxRow == numberRowsInTable) {
			nextText();
			lastText();
		}
		showPage();
		preLink();
		firstLink();
	}

	//上一页     
	function pre() {

		hideTable();

		page--;

		currentRow = pageSize * page;
		maxRow = currentRow - pageSize;
		if (currentRow > numberRowsInTable)
			currentRow = numberRowsInTable;
		for ( var i = maxRow; i < currentRow; i++) {
			theTable.rows[i].style.display = '';
		}

		if (maxRow == 0) {
			preText();
			firstText();
		}
		showPage();
		nextLink();
		lastLink();
	}

	//第一页     
	function first() {
		hideTable();
		page = 1;
		for ( var i = 0; i < pageSize; i++) {
			theTable.rows[i].style.display = '';
		}
		showPage();

		preText();
		nextLink();
		lastLink();
	}

	//最后一页     
	function last() {
		hideTable();
		page = pageCount();
		currentRow = pageSize * (page - 1);
		for ( var i = currentRow; i < numberRowsInTable; i++) {
			theTable.rows[i].style.display = '';
		}
		showPage();

		preLink();
		nextText();
		firstLink();
	}

	function hideTable() {
		for ( var i = 0; i < numberRowsInTable; i++) {
			theTable.rows[i].style.display = 'none';
		}
	}

	//控制分页
	function showPage() {
		pageNum.innerHTML = page;
		pageNumt.innerHTML = page;
	}

	//总共页数     
	function pageCount() {
        var count = 0;
        if (numberRowsInTable % pageSize != 0) count = 1;
        return parseInt(numberRowsInTable / pageSize) + count;
    }

	//显示链接     
	function preLink() {
		spanPre.innerHTML = "<a href='javascript:pre();' id='sasasaa'>上一页</a>";

		spanPret.innerHTML = "<a href='javascript:pre();'>上一页</a>";
	}
	function preText() {
		spanPre.innerHTML = "上一页";
		spanPret.innerHTML = "上一页";
	}

	function nextLink() {
		spanNext.innerHTML = "<a href='javascript:next();' id='sasasaa'>下一页</a>";

		spanNextt.innerHTML = "<a href='javascript:next();'>下一页</a>";
	}
	function nextText() {
		spanNext.innerHTML = "下一页";
		spanNextt.innerHTML = "下一页";
	}

	function firstLink() {
		spanFirst.innerHTML = "<a href='javascript:first();' id='sasasaa'>首页</a>";
		spanFirstt.innerHTML = "<a href='javascript:first();'>首页</a>";
	}
	function firstText() {
		spanFirst.innerHTML = "首页";
		spanFirstt.innerHTML = "首页";
	}

	function lastLink() {
		spanLast.innerHTML = "<a href='javascript:last();' id='sasasaa'>尾页";
		spanLastt.innerHTML= "<a href='javascript:last();'>尾页</a>";
	}
	function lastText() {
		spanLast.innerHTML = "尾页";
		spanLastt.innerHTML = "尾页";
	}

	//隐藏表格     
	function hide() {
		for ( var i = pageSize; i < numberRowsInTable; i++) {
			theTable.rows[i].style.display = 'none';
		}

		totalPage.innerHTML = pageCount();
		pageNum.innerHTML = '1';

		totalPaget.innerHTML = pageCount();
		pageNumt.innerHTML = '1';

		nextLink();
		lastLink();
	}
	hide(); 

	/* $(function(){
		$(".pre").click(function(){
			alert("555");
			$.post("kitchen_slitPage.action",
				{pageNo:++pageNo},
				function(tlist){
					$("#tbody").empty();
					var list = eval("("+tlist+")");
					for(var i=0,i<list.length,i++){
						var tr = $("<tr><td>"+(pageNo*10+i)+"</td><td>"+list[i].table_name+"</td><td>"+list[i].emp_name+"</td><td>"+list[i].food_num+"</td><td>"+list[i].servingtime+"</td><td>"+list[i].order_food_mark+"</td><td><a type='button' class='btn btn-success btn-xs' href='${pageContext.request.contextPath}/kitchen_doFood.action?orderfoodid="+list[i].order_food_id+"&status=1'>查看</a></td>");
						$("#tbody").append(tr);	
					}
				},"text");
		});
	})	 */
	var pageNo=1;
	function bac(){
		pageNo = --pageNo<1?1:pageNo;
		 $.ajax({
			url:"/Ordersystem/kitchen_slitPage.action",
			data:{pageNo:pageNo},
			type:"post",
			dataType:"json",
			success:function(list){
				 $("#tbody").empty();
				 for(var i=0;i<list.length;i++){
					 var tr = $("<tr><td>"+((pageNo-1)*10+i+1)+"</td><td>"+list[i].table_name+"</td><td>"+list[i].emp_name+"</td><td>"+list[i].food_name+"</td><td>"+list[i].food_num+"</td><td>"+list[i].servingtime+"</td><td>"+list[i].order_food_mark+"</td>");
					$("#tbody").append(tr);	 
				}  
				$("#currentpage").text("第"+pageNo+"页"); 
			}
		}); 
	}
	function pree(){
		var total = $("#allpage").val();
		pageNo = ++pageNo>total?total:pageNo;
		 $.ajax({
			url:"/Ordersystem/kitchen_slitPage.action",
			data:{pageNo:pageNo},
			type:"post",
			dataType:"json",
			success:function(list){
				 $("#tbody").empty();
				 for(var i=0;i<list.length;i++){
						 var tr = $("<tr><td>"+((pageNo-1)*10+i+1)+"</td><td>"+list[i].table_name+"</td><td>"+list[i].emp_name+"</td><td>"+list[i].food_name+"</td><td>"+list[i].food_num+"</td><td>"+list[i].servingtime+"</td><td>"+list[i].order_food_mark+"</td>");
						$("#tbody").append(tr);	 
				}   
				 $("#currentpage").text("第"+pageNo+"页");
			}
		}); 
	};

</script>
</html>





