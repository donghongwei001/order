<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<script type="text/javascript" src="../js/jquery-2.1.3.js"></script></HEAD>

<body onload = "setPageInfo()">
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/emp_updateInfo.action?id=${empinfo.emp_id}" method="post">
		 <input type="hidden" value="${empinfo.emp_state }" id="sta" />
		<input type="hidden" value="${empinfo.emp_fk_pos_id }" id="poid" />
		<input type="hidden" value="${empinfo.emp_gender }" id="gend" />
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑员工信息</STRONG> </strong><!-- 编辑员工信息 -->
				</td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">员工编号：</td>
				<td class="ta_01" bgColor="#ffffff"><span>${empinfo.emp_id }</span>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">姓名：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="emp_name" value="${empinfo.emp_name }" class="bg" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">性别：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="radio" name="emp_gender" value="男"/>男
					<input type="radio"name="emp_gender" value="女"/>女
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">出生年月：</td>
				<td class="ta_01" bgColor="#ffffff">
				<input type = "text" value="${empinfo.emp_birday }" name="emp_birday">
				</td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">年龄：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" value="${empinfo.emp_age }">
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">身份证号：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" value="${empinfo.emp_idcar }"	name="emp_idcar" class="bg" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">家庭住址：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="emp_address" value="${empinfo.emp_address }"	class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">入职时间：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" value="${empinfo.emp_hire_date }" name="emp_hire_date" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">职位：</td>
				<td class="ta_01" bgColor="#ffffff">
				<select  name="emp_fk_pos_id" id="posid">
						<option>---请选择---</option>
				</select>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">状态：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="emp_state" id="empstatus">
						<option value="4">在职</option>
						<option value="5">请假</option>
						<option value="7">调休</option>
						<option value="6">离职</option>
					</select>
				</td>
			</tr>
			
			<TR>
				<td align="center" colSpan="1" >电话：
				</td>
				<td class="ta_01" colSpan="3"><input type="text"
					name="emp_phone" class="bg" value="${empinfo.emp_phone }"/></td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<input type="submit"
					class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>



					<input type="reset" value="重置" class="button_cancel"> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>




</body>
<script type="text/javascript">
	//设置类别的默认值
	function appendopt(){
		alert("55555");
		
		/*  $.ajax({
			url:"/Ordersystem/emp_showPosition.action",
			type:"post",
			dataType:"json",
			success:function(list){
				 $("#posid").empty();
				 for(var i=0;i<list.length;i++){
					 var tr = $("<option value="+data[i].role_id+">"+data[i].role_name+"</option>");
					$("#posid").append(tr);	 
				}  
			}
		});  */
		
		/* $.post("emp_showPosition.action",
				function(data){
					$("#posid").empty();
					for(var i = 0;i<data.length;i++){
						var str = $("<option value="+data[i].role_id+">"+data[i].role_name+"</option>");
						$("#posid").append(str);
					}
				},"json");  */
				
	/* $.ajax({ //发送了一个新的请求，与按钮这个请求完全不是一马事
					type : "post", //请求方式
					url : "/Ordersystem/emp_showPosition.action", //请求地址
					dataType : "json",
					//async : false,
					
					
					success : function(data) { //请求成功后调用的回调函数，参数1【data】 请求返回的数据，这个数据类型是dataType  制定
						$("#posid").empty();
						for ( var int = 0; int < data.length; int++) {
							var str = $("<option value="+data[i].role_id+">"+data[i].role_name+"</option>");
							$("#posid").append(str);
						}
							
						}
					
	
				})
	}
	 */
	 
	 $(function(){
		$("#posid").click(function(){
			$.post("emp_showPosition.action",
				function(data){
					$("#posid").empty();
					
					for(var i = 0;i<data.length;i++){
						var str = $("<option value="+data[i].role_id+">"+data[i].role_name+"</option>");
						$("#posid").append(str);
					}
				},"json");
		});
	});
			
	
	
	function setPageInfo() {
		var posid = document.getElementById("posid");
		var empgender = document.getElementsByName("emp_gender");
		var empstatus = document.getElementById("empstatus");
		var ops = category.options;
		for ( var i = 0; i < ops.length; i++) {
			if (ops[i].value == t) {
				ops[i].selected = true;
				return;
			}
		}

	}}
</script>
</HTML>