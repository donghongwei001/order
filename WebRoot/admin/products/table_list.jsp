
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
						 		<td style="padding-left:80px">
							 		<div>
										<form action="Table_seleAll.action" method="post">
											桌号：<input type="text" name="tabid" id="tabidaa" value="${tabid}"/>&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="submit" value="查询"> 
										</form>
									</div>
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
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="13%">桌号</td>
								<td align="center" width="13%">桌名</td>
								<td width="13%" align="center">桌子状态</td>
								<td align="center" width="13%">可供就餐人数</td>
								<td align="center" width="13%">服务员</td>
								<td align="center" width="13%">服务员状态</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<tbody id="tbody">
							 <c:forEach items="${list}" var="row">
								<tr style="FONT-WEIGHT: bold; HEIGHT:33px;FONT-WEIGHT: bold;FONT-SIZE: 12pt; HEIGHT: 25px;">
									<td align="center" width="13%">${row.table_id}</td>
									<td align="center" width="13%">${row.table_name}</td>
									<td align="center" width="13%">${row.code_name }</td>
									<td align="center" width="13%">${row.table_Capacity}</td>
									<td align="center" width="13%">${row.emp_name}</td>
									<td align="center" width="13%">${row.emp_code_name}</td>
									<td width="7%" align="center">
									 <a href="${pageContext.request.contextPath}/Table_seid.action?tabled=${row.table_id}&name=${row.table_name}&capacity=${row.table_Capacity}" > 
										<img src="${pageContext.request.contextPath}/admin/images/i_edit.gif" width="16" height="16" border="0" style="CURSOR: hand" type="submit">
									</a>								
									</td>
									<td width="7%" align="center">
									<a href="${pageContext.request.contextPath}/Table_del.action?tab=${row.table_id}">
										<img src="${pageContext.request.contextPath}/admin/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
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
	<button  class="pre" onclick="bac()">上一页</button>
	<button  class="bac" onclick="pre(4)">下一页</button><span id="currentpage">第1页</span><span>共${total }页</span>
	<input type="hidden" value="${total }" id="allpage">
<script type="text/javascript">
var pageNo=1;
	 function bac(){
		pageNo = --pageNo<1?1:pageNo;
		 $.ajax({
			url:"/Ordersystem/Table_ajaxlisttab.action",
			data:{pageNo:pageNo,tabid:$("#tabidaa").val()},
			type:"post",
			dataType:"json",
			success:function(list){
				 $("#tbody").empty();
				 for(var i=0;i<list.length;i++){
					  var tr = $("<tr style='FONT-WEIGHT: bold; HEIGHT:33px;FONT-WEIGHT: bold;FONT-SIZE: 12pt; HEIGHT: 25px;'>"+
									"<td align='center' width='13%'>"+list[i].table_id+"</td>"+
									"<td align='center' width='13%'>"+list[i].table_name+"</td>"+
									"<td align='center' width='13%'>"+list[i].code_name+"</td>"+
									"<td align='center' width='13%'>"+list[i].table_Capacity+"</td>"+
									"<td align='center' width='13%'>"+list[i].emp_name+"</td>"+
									"<td align='center' width='13%'>"+list[i].emp_code_name+"</td>"+
									"<td width='7%' align='center'>"+
									" <a href='${pageContext.request.contextPath}/Table_seid.action?tabled="+list[i].table_id+"&name="+list[i].table_name+"&capacity="+list[i].table_Capacity+"' >"+ 
									"<img src='${pageContext.request.contextPath}/admin/images/i_edit.gif' width='16' height='16' border='0' style='CURSOR: hand' type='submit'></a></td>"+
									"<td width='7%' align='center'><a href='${pageContext.request.contextPath}/Table_del.action?tab="+list[i].table_id+"'>"+
									"<img src='${pageContext.request.contextPath}/admin/images/i_del.gif' width='16' height='16' border='0' style='CURSOR: hand'></a></td></tr>");
					$("#tbody").append(tr);	 
				}  
				$("#currentpage").text("第"+pageNo+"页"); 
			}
		}); 
	}
	function pre(){
		var total = $("#allpage").val();
		pageNo = ++pageNo>total?total:pageNo;
		 $.ajax({
			url:"/Ordersystem/Table_ajaxlisttab.action",
			data:{pageNo:pageNo,tabid:$("#tabidaa").val()},
			type:"post",
			dataType:"json",
			success:function(list){
				 $("#tbody").empty();
				 for(var i=0;i<list.length;i++){
						  var tr = $("<tr style='FONT-WEIGHT: bold; HEIGHT:33px;FONT-WEIGHT: bold;FONT-SIZE: 12pt; HEIGHT: 25px;'>"+
									"<td align='center' width='13%'>"+list[i].table_id+"</td>"+
									"<td align='center' width='13%'>"+list[i].table_name+"</td>"+
									"<td align='center' width='13%'>"+list[i].code_name+"</td>"+
									"<td align='center' width='13%'>"+list[i].table_Capacity+"</td>"+
									"<td align='center' width='13%'>"+list[i].emp_name+"</td>"+
									"<td align='center' width='13%'>"+list[i].emp_code_name+"</td>"+
									"<td width='7%' align='center'>"+
									" <a href='${pageContext.request.contextPath}/Table_seid.action?tabled="+list[i].table_id+"&name="+list[i].table_name+"&capacity="+list[i].table_Capacity+"' >"+ 
									"<img src='${pageContext.request.contextPath}/admin/images/i_edit.gif' width='16' height='16' border='0' style='CURSOR: hand' type='submit'></a></td>"+
									"<td width='7%' align='center'><a href='${pageContext.request.contextPath}/Table_del.action?tab="+list[i].table_id+"'>"+
									"<img src='${pageContext.request.contextPath}/admin/images/i_del.gif' width='16' height='16' border='0' style='CURSOR: hand'></a></td></tr>");
					$("#tbody").append(tr);	
				}   
				 $("#currentpage").text("第"+pageNo+"页");
			}
		}); 
	}; 
	
</script>

</body>
</HTML>

