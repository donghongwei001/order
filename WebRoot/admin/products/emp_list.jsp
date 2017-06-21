<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/Myjs.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/jquery-2.1.3.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/products/emp_add.jsp";
	}
</script>
<style type="text/css">
#search_he {
	border: 0px solid red;
	position: absolute;
	width: 150;
	top: 66px;
	left: 108px;
	background-color: white;
}

#DataGrid1 td {
	width: 100px;
}
</style>
</HEAD>
<script type="text/javascript">
	/* /* var ipid = document.getElementById("Form1_userName");
	ipid.onkeyup=function(){
		alert("111");
	} */

	/* $(document).ready(function(){
		var ipid = document.getElementById("Form1_userName");
		//var div=document.getElementById("search_he");
		alert("111");
		ipid.onkeyup=function(){
		
	};
	}); */

	/* $("input").focus(
		function(){
			alert("11");
			 $("#search_he").get(0).style.left=$(this).get(0).offsetLeft+"px";
			$("#search_he").get(0).style.display="block";
			alert("000");
			$("#search_he").get(0).style.width=$(this).get(0).offsetWidth+"px";
			$("#search_he").get(0).style.top=$(this).get(0).offsetHeight+$(this).get(0).offsetTop+"px"; 
		}); */

	/* $("input").focus(
		function(){
			alert("aaaaa");
		
			$("#search_he").get(0).style.display="block";
			$("#search_he").get(0).style.left=$(this).get(0).offsetLeft+"px";
			$("#search_he").get(0).style.width=$(this).get(0).offsetWidth+"px";
			$("#search_he").get(0).style.top=$(this).get(0).offsetHeight+$(this).get(0).offsetTop+"px";
		
	}
	);
	$("input").blur(
	function(){$("#search_he").get(0).style.display="none";}
	);
	
	
	window.onload = function(){
	//alert("00");
	var ipt = document.getElementById("Form1_userName");
	var div = document.getElementById("search_he");
	ipt.onkeyup = function(){
		var xhr = getXMLHttpRequest();//获取连接
		//处理结果
		xhr.onreadystatechange=function(){
				//alert(xhr.readyState);
			if(xhr.readyState==4&&xhr.status==200){
				var str=xhr.responseText;
				var ss = str.split(",");
				var childdivs = "";
				for(var i=0;i<ss.length;i++){
					childdivs+="<div onmouseover='bgco(this)' onmouseout='bgcot(this)' onclick='writeva(this)'>"+ss[i]+"</div>";
				}
				div.innerHTML=childdivs;
			};
		};
		//建立连接
		xhr.open("post","searchele?name="+ipt.value+"&time="+new Date().getTime());
		//发送连接
		xhr.send(null);
	};
	ipt.onblur=function(){
		div.innerHTML="";
	};
	
	};	
	function writeva(di){
		alert("55");
		var dive = document.getElementById("search_he");
		var value = di.innerHTML;
		dive.innerHTML=value;
	}
	function bgco(div){
		div.style.backgroundColor="gray";
	}
	function bgcot(div){
		div.style.backgroundColor="white";
	} */
</script>

<body>
	<!-- <div id="search_he"></div> -->
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/findProductByManyCondition"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查
							询 条 件</strong></td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									员工编号</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="id" size="15" value="" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									姓名：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="id" size="15" value="" id="Form1_userName" class="bg" />
								</td>
							</tr>

							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									性别：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="radio"
									name="emp_gender" />男 <input type="radio" name="emp_gender" />女
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									身份证号：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="name" size="15" value="" id="Form1_userName" class="bg" />
								</td>

							</tr>
							<!--  -->

							<tr>
								<td width="100" height="22" align="center" bgColor="#f5fafe"
									class="ta_01"></td>
								<td class="ta_01" bgColor="#ffffff"><font face="宋体"
									color="red"> &nbsp;</font></td>
								<td align="right" bgColor="#ffffff" class="ta_01"><br />
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01">
									<button type="submit" id="search" name="search"
										value="&#26597;&#35810;" class="button_view">&#26597;&#35810;</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" name="reset"
									value="&#37325;&#32622;" class="button_view" /></td>
							</tr>
						</table></td>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>员工信息列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="&#28155;&#21152;"
							class="button_add" onclick="addProduct()">&#28155;&#21152;
						</button></td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="7%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">员工编号</td>
								<td align="center" width="6%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">姓名</td>
								<td align="center" width="5%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">性别</td>
								<td align="center" width="8%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">出生年月</td>
								<td align="center" width="5%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">年龄</td>
								<td align="center" width="17%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">身份证号</td>
								<td align="center" width="12%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">家庭住址</td>
								<td align="center" width="8%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">入职时间</td>
								<td align="center" width="7%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">职位</td>
								<td align="center" width="6%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">状态</td>
								<td align="center" width="9%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">电话</td>
								<td align="center" width="5%"
									onmouseover="this.style.backgroundColor = '#5F9F9F ';"
									onmouseout="this.style.backgroundColor = '#afd1f3 ';">编辑和删除</td>


							</tr>
							<tr onmouseover="this.style.backgroundColor = 'green '"
								onmouseout="this.style.backgroundColor = '#5F9F9F ';">
								<div id="xinxi">
									<table border=1>
										<c:forEach var=“rowData " items="${list}"
											varStatus="staRow">
											<tr>
												<c:forEach var="colValue" varStatus="staCol"
													items="${rowData}">
													<%-- <c:if test="${staRow.last}">
														<td><input type="radio" name=“id
															" value="${colValue}"
															>
														</td>
													</c:if> --%>
													
														<td>${colValue}</td>
												</c:forEach>
											</tr>
										</c:forEach>
									</table>
									
								</div>
							</tr>
							<!--  -->
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">

							</tr>

							<%-- <c:forEach items="${list }" var = "li">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23">${li.bookid }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${li.name }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${li.price }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${li.pnum }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${li.category }</td>
									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="${pageContext.request.contextPath}/deleterecord?id=${li.bookid}&method=update">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand"> </a>
									</td>

									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="${pageContext.request.contextPath}/deleterecord?id=${li.bookid}&method=del">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
									</td>
								</tr>
						</c:forEach> --%>
						</table></td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
<script type="text/javascript">
	
</script>
</HTML>

