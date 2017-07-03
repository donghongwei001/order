<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>Starter Template for Bootstrap</title>
<style type="text/css">
.table-hover {
	margin-top: 200px;
	width: 1000px;
}

.table-hover td {
	text-align: center;
	border: 1px solid gray;
}
</style>

<link href="../css/bootstrap.min.css" rel="stylesheet">


</head>

<body>
	<table class="table table-hover">
		<tr>
			<td style="font-size:30px;color:brown;">角色</td>
			<td style="font-size:30px;color:brown;">权限</td>
		</tr>
		<c:forEach items="${list}" var="a">
			<tr>
				<td id="id">${a}</td>
				<td><button type="button" onclick="xiugaiquanxian('${a}')"
						class="btn btn-primary" data-toggle="modal"
						data-target=".bs-example-modal-sm">修改权限</button></td>
			</tr>

		</c:forEach>

	</table>
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<form action="/Ordersystem/cust_xiugaiquanxian.action" method="post">
					<span style="margin-left:120px;font-size:20px;color:gray">权限修改</span>
					<br> <br> <br> 
					<input type="checkbox" style="margin-left:10px;" value="1" name="box" id="101">员工管理 <br/>
					<input type="checkbox" name="box" style="margin-left:30px;" value="30" id="10101">员工查询 
					<input	style="margin-left:90px;" type="checkbox" name="box" id="10102" value="13">员工添加<br>
					<input type="checkbox" name="box" style="margin-left:30px;" value="14" id="10103">员工删除 
					<input	style="margin-left:90px;" type="checkbox" name="box" id="10104" value="15">员工修改<br>
					
					<input style="margin-left:10px;" type="checkbox" name="box" id="103" value="2">订单管理<br> 
					
					<input	type="checkbox" style="margin-left:10px;" name="box" id="104" value="3">财务管理<br/>
					
					<input	style="margin-left:10px;" type="checkbox" id="105" name="box" value="4">前台管理<br>
					
					<input type="checkbox" style="margin-left:10px;" name="box" id="106" value="5">角色权限 <br/>
					<input type="checkbox" name="box" style="margin-left:30px;" value="16" id="10601">修改权限 <br/>
					
					<input	style="margin-left:10px;" type="checkbox"  id="108" name="box" value="6">综合排序<br>
					
					<input type="checkbox" name="box" style="margin-left:10px;" value="7"  id="109">先后排序 <br/>
					
					<input	style="margin-left:10px;" type="checkbox" name="box"  id="110" value="8">按桌排序<br>
					
					<input type="checkbox" name="box" style="margin-left:10px;" value="9"  id="112">菜品管理 <br/>
					<input type="checkbox" name="box" style="margin-left:30px;" value="20" id="11202">菜品修改 
					<input	style="margin-left:90px;" type="checkbox" name="box" id="11201" value="19">菜品查询<br>
					<input type="checkbox" name="box" style="margin-left:30px;" value="22" id="11204">菜品删除 
					<input	style="margin-left:90px;" type="checkbox" name="box" value="21" id="11203">菜品增加<br>
					
					<input	style="margin-left:10px;" type="checkbox" name="box" value="10"  id="113">餐桌管理<br>
					<input type="checkbox" name="box" style="margin-left:30px;" value="26" id="11301">餐桌查询 
					<input	style="margin-left:90px;" type="checkbox" name="box" id="11302" value="27">餐桌添加<br>
					<input type="checkbox" name="box" style="margin-left:30px;" value="28" id="11303">餐桌修改
					<input	style="margin-left:90px;" type="checkbox" id="11304" name="box" value="29">餐桌删除<br>
					
					<input type="checkbox" name="box" style="margin-left:10px;" value="11"  id="114">顾客管理<br/>
					
					<input	style="margin-left:10px;" type="checkbox"  id="107" name="box" value="12">角色管理<br>
					<input type="checkbox" name="box" style="margin-left:30px;" value="18" id="10702">修改角色 
					<input	style="margin-left:90px;" type="checkbox" name="box" id="10701" value="17">增加角色<br>
					
					<input	style="margin-left:10px;" type="checkbox" name="box"  id="111" value="23">菜系查询<br>
					<input type="checkbox" name="box" style="margin-left:30px;" value="24" id="11101">菜系增加 
					<input	style="margin-left:90px;" type="checkbox" name="box" id="11102" value="25">菜系删除<br>
					<input type="checkbox" name="box" style="margin-left:30px;" id="11103" value="31">菜系修改 <br/>
					
					<input	style="margin-left:10px;" type="checkbox" name="box" id="102" value="32">帐号管理<br>
					<input type="checkbox" name="box" style="margin-left:30px;" value="33" id="10201">帐号修改 
					<input	style="margin-left:90px;" type="checkbox" name="box" id="10202"  value="34">帐号添加<br>


					<br> <br>
					<button type="button" style="margin-left:50px;margin-bottom:30px;" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="submit" style="margin-left:70px;margin-bottom:30px;"
						class="btn btn-success">确定添加</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="../js/jquery-2.1.3.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
	function xiugaiquanxian(index) {
		var box = document.getElementsByName("box");
		//alert(box.length);
		$.ajax({
			type : "post",
			url : "/Ordersystem/cust_xiugaijuese.action",
			data : {
				quanxianname : index
			},
			dataType : "text",
			success : function(data) {
				var arr = data.split(",");

				//alert("555");
				for ( var i = 0; i < box.length; i++) {
					box[i].checked = false;
					if (arr.indexOf(box[i].value) >= 0) {
						box[i].checked = true;
					}
				}
			}

		})

	}
	$(":checkbox").click(
			function(){
				var code=this.id;
				var parentCode = code.substr(0,code.legth-2);
				var che=$(this).prop("checked");
				//
				$(":checkbox[id^="+code+"]").prop("checked",che);
				checkParent(code);

			}
		);
		
		
	function checkParent(code){
			if (code.length<=3)
			{
				return;
			}
			var parentCode=code.substr(0,code.length-2);
			var flag=$(":checkbox[id="+code+"]").prop("checked");
			if (flag)
			{
				$(":checkbox[id="+parentCode+"]").prop("checked",true);
			}else{
				var sonFlag=-1;
				$(":checkbox[id^="+parentCode+"]").each(
					function (){
						var code1=this.id;
						if (code1!=parentCode)
						{
							var sonCheck = $(this).prop("checked");
							if (sonCheck)
							{
								sonFlag=1;
							}
						}
					}
				);
				if (sonFlag==-1)
				{
					$(":checkbox[id="+parentCode+"]").prop("checked",false);
				}
			}
			checkParent(parentCode);
		}
	
</script>




</html>