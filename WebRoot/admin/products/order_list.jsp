<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet"
	media="screen">
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
.panel-group {
	max-height: 770px;
	overflow: auto;
}

.leftMenu {
	margin: 10px;
	margin-top: 5px;
}

.leftMenu .panel-heading {
	font-size: 14px;
	padding-left: 20px;
	height: 36px;
	line-height: 36px;
	color: white;
	position: relative;
	cursor: pointer;
} /*转成手形图标*/
.leftMenu .panel-heading span {
	position: absolute;
	right: 10px;
	top: 12px;
}

.leftMenu .menu-item-left {
	padding: 2px;
	background: transparent;
	border: 1px solid transparent;
	border-radius: 6px;
}

.leftMenu .menu-item-left:hover {
	background: #C4E3F3;
	border: 1px solid #1E90FF;
}

#n1 {
	width: 100%;
	height: 600px;
}

#guanli2 {
	display: none;
}

#guanliyuann {
	display: none;
}

.text-c th {
	width: 100px;
}

#shijian1 {
	
}

#riqi {
	margin-left: -146px;
}

#name {
	
}

#xinxi td {
	text-align: center;
}
</style>
</head>
<body id="test">
	<!--白色，浅蓝色，深蓝色，绿色，黄色，红色，黑色，对应的class为btn,btn btn-primary,btn btn-info,btn btn-success,btn btn-warning,btn btn-danger,btn btn-inverse-->



	<!------------------------------------------------------------------------------------------------------------------------------->

	<div class="col-md-12">

		<div id="n1">

			<div>

				<section class="Hui-article-box"> <nav class="breadcrumb">
				<a
					href="${pageContext.request.contextPath}/Ordersystem/wei_query1.action"><button
						style="background:#000; class="labellabel-successradius" filter:alpha(opacity:0); opacity:0.2;">全部订单</button>
				</a> </nav>
				<div class="Hui-article">
					<article class="cl pd-20">
					<form action="/Ordersystem/dongdingdan.action" method="post">


						<span id="riqi">日期范围</span>：
						<div class="control-group" id="shijian1">
							<label class="control-label"> 初始时间</label>
							<div class="controls input-append date form_datetime"
								data-date="2017-06-16T00:00:00Z" data-date-format="yyyy-MM-dd"
								data-link-field="dtp_input1">
								<input id="shijiankuang3" name="shijiankuang3" size="25"
									type="text" value="" readonly> <span class="add-on"><i
									class="icon-remove"></i> </span> <span class="add-on"><i
									class="icon-th"></i> </span>
							</div>
							<input type="hidden" id="dtp_input1" value="" /><br />
						</div>
						
						<div class="form-group">
                		<label for="dtp_input2" class="control-label">开始时间</label>
                		<div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
	                    	<input class="form-control" size="16" name="starttime" type="text" value="${starttime}" readonly>
	                   		<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
               			 </div>
						<input type="hidden" id="dtp_input2" value="" /><br/>
           			</div>
						
						
						<div class="control-group" id="shijian2">
							<label class="control-label"> 初始时间</label>
							<div class="controls input-append date form_datetime"
								data-date="2017-06-16T00:00:00Z" data-date-format="yyyy-MM-dd"
								data-link-field="dtp_input1">
								<input id="shijiankuang4" name="shijiankuang4" size="25"
									type="text" value="" readonly> <span class="add-on"><i
									class="icon-remove"></i> </span> <span class="add-on"><i
									class="icon-th"></i> </span>
							</div>
							<input type="hidden" id="dtp_input1" value="" /><br />
						</div>
						<input type="text" name="ordername" id="ordername"
							placeholder=" 订单编号" style="width:250px" class="input-text">
						<button name="" id="" type="submit" class="btn btn-success">
							<i class="Hui-iconfont">&#xe665;</i> 搜订单
						</button>


					</form>
					<div class="cl pd-5 bg-1 bk-gray mt-20">
						<input type="hidden" id="jishu" value="${jishu}"> <span
							class="l"> <span class="r">共有数据：<strong id="aaaa"
								style="font-size:25px"></strong> 条</span>
					</div>
					<div class="mt-20">
						<table
							class="table table-border table-bordered table-bg table-hover table-sort">
							<thead style="margin-bottom:0px">
								<tr class="text-c" style="margin-bottom:0px">
									<th width="40"></th>
									<th width="80"
										onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">订单编号</th>

									<th width="150"
										onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">订单时间</th>
									<th width="150"
										onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">桌子编号</th>
									<th width="60"
										onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">消费金额</th>
									<th width="100"
										onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">服务员</th>
									<th width="100"
										onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">评分</th>
									<th width="100"
										onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">评价</th>
									<th width="100"
										onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">状态</th>
									<th width="100"
										onmouseover="this.style.backgroundColor = '#5F9F9F ';"
										onmouseout="this.style.backgroundColor = '#afd1f3 ';">消费详情</th>

								</tr>

							</thead>
							<tbody id="xinxi">


								<c:forEach items="${List1}" var="b">
									<tr>
										<td><input type="checkbox">
										</td>
										<td>${b.order_id}</td>
										<td>${b.order_time}</td>
										<td>${b.order_fk_tabid}</td>
										<td>${b.order_money}</td>
										<td>${b.emp_name}</td>
										<td>${b.order_dt_score}</td>
										<td>${b.oeder_dt_mark}</td>
										<td><span class="label label-success radius">${b.code_name}</span>
										</td>
										<td><a href="/Ordersystem/xiaofeixiangqing.action?id=${b.order_id}"><button type="button"
												
												>消费详情</button></a>
										</td>

									</tr>
								</c:forEach>
							</tbody>
							
						</table>
						<div class="pagelist">
							<span id="spanFirst" class="button border-main">首页</span>
 							<span id="spanPre" class="button border-main">上一页</span> 
 							<span id="spanNext" class="button border-main">下一页</span> 
 							<span id="spanLast" class="button border-main">尾页</span>
 							 第<span	id="spanPageNum"></span>页/共 <span id="spanTotalPage"></span>页
						</div>
						
					</div>
					</article>
				</div>
				</section>

			</div>

		</div>
	</div>
	<div style="display: none">
		<span id="spanFirstt">首页</span> <span id="spanPret">上一页</span> <span
			id="spanNextt"> 下一页</span> <span id="spanLastt">尾页</span> 第 <span
			id="spanPageNumt"></span>页/共<span id="spanTotalPaget"></span>页
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script type="text/javascript" src="../js/jquery-2.1.3.js"
		charset="UTF-8"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="../js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>


	<!-- Include all compiled plugins (below), or include individual files as needed -->

	<script type="text/javascript" src="../js/jquery-2.1.3.js"
		charset="UTF-8"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="../js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
	<script type="text/javascript">
		$(".form_datetime").datetimepicker({
			//language:  'fr',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			forceParse : 0,
			showMeridian : 1,
		})
	</script>
	<script type="text/javascript">
	  
	var theTable = document.getElementById("xinxi");
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
	var pageSize = 6;
	var page = 1;
	$("#aaaa").text(numberRowsInTable);
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
</script>
</body>
</html>