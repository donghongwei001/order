<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">


<script type="text/javascript" src="../js/jquery-2.1.3.js"></script>

  <style type="text/css">
		#id1, .img, img {border:0px solid red;
			width:130px;
			height:180px;
		}
		.aa1{width:900px;}
	</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/shengshilianli.js"></script>
</HEAD>

<body>
	<form id="userAction_save_do" name="Form1"	onsubmit="return checkForm()" action="${pageContext.request.contextPath}/emp_addEmp.action" method="post" enctype="multipart/form-data">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加员工</STRONG> </strong>
				<!-- 添加员工 --></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">姓名：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><input type="text"
					name="emp.emp_name" class="bg" onblur="checkname()" id="empname"/><span id="empnamesp"></span>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">性别：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
				<input type="radio" name="emp.emp_gender" value="男" />男
				<input type="radio" name="emp.emp_gender" value="女" />女 <span id="gendersp"></span>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">出生年月：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
				<select name="emp.emp_birday" id="birthyear">
							<option value="">--请选择--</option>
							<option value="1972">1972</option>
							<option value="1973">1973</option>
							<option value="1974">1974</option>
							<option value="1975">1975</option>
							<option value="1976">1976</option>
							<option value="1977">1977</option>
							<option value="1978">1978</option>
							<option value="1979">1979</option>
							<option value="1980">1980</option>
							<option value="1981">1981</option>
							<option value="1982">1982</option>
							<option value="1983">1983</option>
							<option value="1984">1984</option>
							<option value="1985">1985</option>
							<option value="1986">1986</option>
							<option value="1987">1987</option>
							<option value="1988">1988</option>
							<option value="1989">1989</option>
							<option value="1990">1990</option>
							<option value="1991">1991</option>
							<option value="1992">1992</option>
							<option value="1993">1993</option>
							<option value="1994">1994</option>
							<option value="1995">1995</option>
							<option value="1996">1996</option>
							<option value="1997">1997</option>
						</select>年
						<select name="emp.emp_birday"  id="birthmonth">
						<option value="">--请选择--</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				</select> 月<select name="emp.emp_birday"  id="birthday">
						<option value="">--请选择--</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
				</select>日 <span id="empbirday"></span></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">年龄：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
				<select  name="emp.emp_age" id="empage" >
						<option value="">--请选择--</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
						<option value="32">32</option>
						<option value="33">33</option>
						<option value="34">34</option>
						<option value="35">35</option>
						<option value="36">36</option>
						<option value="37">37</option>
						<option value="38">38</option>
						<option value="39">39</option>
						<option value="40">40</option>
						<option value="41">41</option>
						<option value="42">42</option>
						<option value="43">43</option>
						<option value="44">44</option>
						<option value="45">45</option>
				</select>
				<span id="empagesp"></span>
				</td>
			</tr>

			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">身份证号：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><input type="text"
					name="emp.emp_idcar" onblur="seleidcar()"  id="idcar"
					class="bg" /><span id="idcarsp"></span>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">家庭住址：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
				<!-- <input type="text"	name="emp.emp_address" 	class="bg" /> -->
					
					<select id="cmbProvince" name="emp.emp_address"></select>  
					<select id="cmbCity" name="emp.emp_address"></select>  
					<select id="cmbArea" name="emp.emp_address"></select>  
					<input type="text"	name="emp.emp_address" 	class="bg" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">入职时间：</td>
				<td class="ta_01" bgColor="#ffffff"><select
					name="emp.emp_hire_date">
						<option value="">--请选择--</option>
						<option value="2012">2012</option>
						<option value="2013">2013</option>
						<option value="2014">2014</option>
						<option value="2015">2015</option>
						<option value="2016">2016</option>
						<option value="2017">2017</option>
				</select>年 <select name="emp.emp_hire_date">
						<option value="">--请选择--</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				</select> 月<select name="emp.emp_hire_date">
						<option value="">--请选择--</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option  value="4">4</option>
						<option  value="5">5</option>
						<option  value="6">6</option>
						<option  value="7">7</option>
						<option  value="8">8</option>
						<option  value="9">9</option>
						<option  value="10">10</option>
						<option  value="11">11</option>
						<option  value="12">12</option>
						<option  value="13">13</option>
						<option  value="14">14</option>
						<option  value="15">15</option>
						<option  value="16">16</option>
						<option  value="17">17</option>
						<option  value="18">18</option>
						<option  value="19">19</option>
						<option  value="20">20</option>
						<option  value="21">21</option>
						<option  value="22">22</option>
						<option  value="23">23</option>
						<option  value="24">24</option>
						<option  value="25">25</option>
						<option  value="26">26</option>
						<option  value="27">27</option>
						<option  value="28">28</option>
						<option  value="29">29</option>
						<option  value="30">30</option>
						<option  value="31">31</option>
					</select>日	<span id="emphireday"></span>
				</td>
				<td id="id1" bgColor="#ffffff" rowspan="5">
					 <div id="preview"></div> 					<!-- 添加图片预览位置 --><!-- 添加图片预览位置 --><!-- 添加图片预览位置 -->
				</td>
				<td class="aa1"bgColor="#ffffff">
				</td>
				
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">职位：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select  name="emp.emp_fk_pos_id" id="posSelect" onchange="checkpos()">
						<option value="" selected="selected">--请选择--</option>
					</select><span id="possp"></span>
				</td>
				<td class="aa1" bgColor="#ffffff">
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">状态：</td>
				<td class="ta_01" bgColor="#ffffff"><select onchange="checkstatus()" id="empstatus" name="emp.emp_state">
						<option value="" selected="selected" >--请选择--</option>
						<option value="4">在职</option>
						<option value="5">请假</option>
						<option value="7">调休</option>
						<option value="6">离职</option>
					</select><span id="empstatussp"></span>
				</td>
				<td class="aa1" bgColor="#ffffff">
				</td>
				
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">电话：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" onblur="checkphone()" id="phone" name="emp.emp_phone" class="bg" /><span id="phonesp"></span>
				</td>
				<td class="aa1" bgColor="#ffffff">
				</td>
			</tr>

			<!-- <TR>
				<td align="center" colSpan="1" >电话：
				</td>
				<td class="ta_01" colSpan="3"><input type="text"
					name="emp.emp_phone" 
					class="bg" /></td>
			</TR> -->
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">上传照片：</td>
				<td class="ta_01" bgColor="#ffffff" >
				<!-- <img id="img" ><br> -->
				<input type="file" name="emppic" id="emppict" onchange="preview(this)"  class="bg" />&nbsp;&nbsp;&nbsp;<span id="picsp"></span>
				</td>
				<td  class="aa1" bgColor="#ffffff">
				</td>
				<td  class="aa1" bgColor="#ffffff">
				</td>
			</tr>

			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4"><input type="submit"
					class="button_ok" id="formsub" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>



					<input type="reset" value="重置" class="button_cancel"> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	//表单验证
	$("#empname").focus(function(){
		//alert("22");
		 $("#empnamesp").text("");
	});
	
	//验证员工姓名不能为空
	function checkname(){
		var data = document.getElementById("empname");
		var name = data.value;
		var sp = $("#empnamesp");
		if(name==""){
			sp.css("color","red");
			sp.text("员工姓名不能为空!");
			return false;
		}
		sp.css("color","green");
		sp.text("正确!");
		return true;
	}
	
	//验证员工状态不能为空
	function checkstatus(){
		var data = document.getElementById("empstatus");
		var name = data.value;
		var sp = $("#empstatussp");
		if(name==""){
			sp.css("color","red");
			sp.text("请选择员工状态!");
			return false;
		}
		sp.text("");
		return true;
	}
	
	//验证职位不能为空
	function checkpos(){
		var data = document.getElementById("posSelect");
		var name = data.value;
		var sp = $("#possp");
		if(name==""){
			sp.css("color","red");
			sp.text("请选择员工职位!");
			return false;
		}
		sp.text("");
		return true;
	}
	
	//验证性别的方法
	function checkgender(){
		var gender = document.getElementsByName("emp.emp_gender");
		for(var i=0;i<gender.length;i++){
			if(gender[i].checked==true){
				return true;
			} 
		}
		$("#gendersp").text("选择您的性别!").css("color","red");
		return false;
	}
	
	//验证生日的方法
	function checkbirday(){
		var birday = document.getElementsByName("emp.emp_birday");
		for(var i=0;i<birday.length;i++){
			if(birday[i].value==""){
				$("#empbirday").text("请录入您的生日!").css("color","red");
				return false;
			} 
		}
			return true;
	}
	//验证入职日期的方法
	function checkhireday(){
		var birday = document.getElementsByName("emp.emp_hire_date");
		for(var i=0;i<birday.length;i++){
			if(birday[i].value==""){
				$("#emphireday").text("请录入您的入职日期!").css("color","red");
				return false;
			} 
		}
			return true;
	}
	
	//验证年龄的方法
	function checkage(){
		var age = document.getElementById("empage");
		alert(age.value);
		if(age.value==""){
			$("#empagesp").text("请选择您的年龄!").css("color","red");
			return false;
		}
		
		return true;
	}
	//表单验证
	$("#phone").focus(function(){
		//alert("22");
		 $("#phonesp").text("");
	});
	//验证手机号的方法
	function checkphone(){
		var data = document.getElementById("phone");
		var name = data.value;
		var idcarreg=/^[1-9][0-9]{10}$/;
		var sp = $("#phonesp");
		if(name==""){
			sp.css("color","red");
			sp.text("联系电话不能为空!");
			return false;
		}
		if(!idcarreg.test(name)){
			sp.text("联系电话格式有误!").css("color","red");
			return false;
		}	
		
		sp.css("color","green");
		sp.text("正确!");
		return true;
	}
	//验证照片格式的方法
	function checkpic(){
		 var prevDiv = document.getElementById("emppict"); 
	 	 var lastname = prevDiv.value.substring(prevDiv.value.indexOf('.')).toLowerCase();
	 	 if(lastname!=".jpg"&&lastname!=".png"&&lastname!=".gif"){
	 	 	$("#picsp").text("图片格式有误,请重新上传!").css("color","red");
	 	 	return false;
	 	 }
	 	 return true;
	}	
	
	//表单验证的方法
	function checkForm(){
		//alert(checkname());
		//alert(seleidcar());
		//alert(checkstatus());
		if(checkpic()&&checkname()&&seleidcar()&&checkstatus()&&checkpos()&&checkgender()&&checkbirday()&&checkphone()&&checkhireday()&&checkage()){
			return true;
		}
	 	return false;
	}
	
	//验证身份证号不能为空 且必须为18为数字
	 $("#idcar").focus(function(){
	 	$("#idcarsp").text("");
	 });
	
	//验证身份证号不能为空 且必须为18位数字 验证身份证号唯一性
	function seleidcar(){
		var data = document.getElementById("idcar");
		var idcar = data.value;
		var sp = $("#idcarsp");
		var idcarreg=/^[1-9][0-9]{16}([0-9]|X){1}$/;
		if(idcar==""){
			sp.text("员工身份证号不能为空!").css("color","red");
			return false;
		}
		if(!idcarreg.test(idcar)){
			sp.text("员工身份证号格式有误!").css("color","red");
			return false;
		}	
	
		$.ajax({
			url:"/Ordersystem/emp_selidcar.action",
			data:{emp_idcar:$("#idcar").val()},
			type:"post",
			dataType:"text",
			success:function(list){
				 if(list=="false"){
				 	var sp = $("#idcarsp").text("身份证号存在重复,不能再次录入!").css("color","red");
				 		var submitBtn = document.getElementById("formsub");
					 	submitBtn.onclick = function (event) {
					  	return false;
					 };
				 };
			}
		}); 
		 return true;
	}
	
	
	//省市级联
  	addressInit('cmbProvince', 'cmbCity', 'cmbArea');  
  	
	//添加图片预览的js方法
	 function preview(file){  
		 var prevDiv = document.getElementById('preview'); 
		 $("#picsp").text("");
	 	 var lastname = file.value.substring(file.value.indexOf(".")).toLowerCase();
	 	 if(lastname!=".jpg"&&lastname!=".png"&&lastname!=".gif"){
	 	 	$("#picsp").text("图片格式有误,请重新上传!").css("color","red");
	 	 	return false;
	 	 }
		 if (file.files && file.files[0]){  
		 var reader = new FileReader();  
			 reader.onload = function(evt){  
			 	prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';  
			 } ;   
			 reader.readAsDataURL(file.files[0]);  
		}  
		 else {  
			 prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  
		 }  
	}  


	//动态显示数据库中的职位信息
	$(document).ready(function(){
			$.post("emp_showPosition.action",
				function(data){
					$("#posSelect").empty();
					$("#posSelect").append("<option value='' selected='selected'>--请选择--</option>");
					for(var i = 0;i<data.length;i++){
						var str = $("<option value="+data[i].role_id+">"+data[i].role_name+"</option>");
						$("#posSelect").append(str);
					}
				},"json");})
	
	
</script>
</HTML>