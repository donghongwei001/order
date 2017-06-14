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
		window.location.href = "${pageContext.request.contextPath}/admin/products/money_add.jsp";
	}
</script> 
<style type="text/css">
	body{
		font-size:25px;
	}
	#search_he{
		border:0px solid red;
		position:absolute;
		width:150;
		top:66px;
		left:108px;
		background-color:white;
	}
	.shijian{
		height:50px;
		text-align:center;
	}
	.jinri{
		height:50px;
		text-align:center;
	}
	span{
		border-bottom:1px solid red;
	}
	.jieguo{
		border:1px solid green;
		width:100%;
		text-align:center;
	}
	#a1{
		border:1px solid green;
		width:500px;
		height:30px;
	}h1{
		text-align:center;
		background:gray;
		height:80px;
		line-height:80px;
	}
</style>
</HEAD>
<script type="text/javascript">
	
	
	/*window.onload = function(){
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
		}*/
</script>

<body>
	
	
		<h1>财务统计查询</h1>
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0"> 
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" ><strong>查
							询 条 件</strong>
					</td>
				</tr>
				<tr>
					<td class="shijian">
					时间：<select>
							<option>2012</option>
							<option>2013</option>
							<option>2014</option>
							<option>2015</option>
							<option>2016</option>
						</select>年
						<select>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
						</select>月
						<select>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>日~~~
						<select>
							<option>2012</option>
							<option>2013</option>
							<option>2014</option>
							<option>2015</option>
							<option>2016</option>
						</select>年
						<select>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
						</select>月
						<select>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>日
						
						
					
						
					</td>

				</tr>
				<tr>
					<td class="ta_01" align="center"bgColor="#afd1f3"><strong>今日结算</strong>
						
					</td>
					
				</tr>
				<tr>
					<td class="jinri"><div >今日一共进账<span>12132</span>元</div></td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查询结果</strong>
					</TD>
				</tr>
				
				<tr>
					<table class="jieguo">
						<tr>
							<td id="a1">2015-06-01~2016-07-01</td>
							<td id="a1">营业额为<span>1546546</span></td>
						</tr>
					</table>
				</tr>
			</TBODY>
		</table>
	
</body>
</HTML>

