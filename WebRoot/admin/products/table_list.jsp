
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script type="text/javascript" src ="${pageContext.request.contextPath }/admin/js/Myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/jquery-2.1.3.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/products/table_add.jsp";
	}
</script> 
<style type="text/css">
	#search_he{
		border:0px solid red;
		position:absolute;
		width:150;
		top:66px;
		left:108px;
		background-color:white;
	}
</style>
</HEAD>
<script type="text/javascript">
	
</script>
<body>
	<div id="search_he"></div>
	
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0"> 
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" ><strong>查  
							询 条 件</strong>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%"> 
						 	<tr>
						 		<td>
							<form action="Table_selezhuo.action" method="post">
								桌号：<input type="text" name="zhuohao"/><br>
								<input type="submit" value="查询"> 
							</form>
								</td>
							</tr> 
						 </table> 
					</td>

				</tr>
				
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>餐桌列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="&#28155;&#21152;"
							class="button_add" onclick="addProduct()">&#28155;&#21152;
						</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="13%">桌号</td>
								<td align="center" width="13%">桌名</td>
								<td width="13%" align="center">桌子状态</td>
								<td align="center" width="13%">可供就餐人数</td>
								<td align="center" width="13%">服务员</td>
								<td align="center" width="13%">服务员状态</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<tbody  id="DataGrid1">
							 <c:forEach items="${list}" var="row">
									<tr style="FONT-WEIGHT: bold; HEIGHT:33px;FONT-WEIGHT: bold;FONT-SIZE: 12pt; HEIGHT: 25px;">
										<td align="center" width="13%">${row.table_id}</td>
										<td align="center" width="13%">${row.table_name}</td>
										<td align="center" width="13%">${row.table_state }</td>
										<td align="center" width="13%">${row.table_Capacity}</td>
										<td align="center" width="13%">${row.fk_emp_id}</td>
										<td align="center" width="13%">${row.emp_state}</td>
										<td width="7%" align="center">
										 <a href="${pageContext.request.contextPath}/Table_seid.action?tabled=${row.table_id}&name=${row.table_name}&capacity=${row.table_Capacity}" > 
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											width="16" height="16" border="0" style="CURSOR: hand" type="submit">
									</a>
									
								</td>
								<td width="7%" align="center">
									<a
										href="${pageContext.request.contextPath}/Table_del.action?tab=${row.table_id}">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
								</td> 
									</tr>
								</c:forEach>
								</tbody>
							</table>
					</td>
				</tr>
			</TBODY>
		</table>
	<div class="pagelist">
		<span id="spanFirst" class="button border-main">首页</span> <span
			id="spanPre" class="button border-main">上一页</span> <span
			id="spanNext" class="button border-main">下一页</span> <span
			id="spanLast" class="button border-main">尾页</span> 第<span
			id="spanPageNum"></span>页/共 <span id="spanTotalPage"></span>页
	</div>
	<div style="display: none">
		<span id="spanFirstt">首页</span> <span id="spanPret">上一页</span> <span
			id="spanNextt"> 下一页</span> <span id="spanLastt">尾页</span> 第 <span
			id="spanPageNumt"></span>页/共<span id="spanTotalPaget"></span>页
	</div>
<script type="text/javascript">
	//分页
	var theTable = document.getElementById("DataGrid1");
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
	var pageSize = 3;
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
</script>


</body>
</HTML>

