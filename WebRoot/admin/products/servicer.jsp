<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <HEAD>
  <TITLE> New Document </TITLE>
  <META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
  <link href = "../css/bootstrap.min.css" rel = "stylesheet">
  <script src="../js/jquery-2.1.3.js"></script>
	<script src="../js/bootstrap.min.js"></script>

	<style>		
		*{margin:0px;padding:0px;}
		div{
			border:0px red solid;
		}
		.page-back{
			width:100%;
			height:750px;
			position:absolute;
			background-color:#fff;
		}
		#allpage-back{
			background:url(../images/000001.jpg);
		}
		.button-control{
		width:80px;
		margin-top:15px;
		text-align:center;
		}
	</style>
 </HEAD>

 <BODY>
 <div class="page-back" id="allpage-back"></div>
 <div class="container">	
	<div class="page-header">
		<!-- 导航栏 -->
		<nav class="navbar navbar-default" style="margin:-25 0 -15 0;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">brand</a>
			</div>
			<div class="collapse navbar-collapse">
				<p class="navbar-text">已用桌位:<span class="badge" id="usetable">${occupy}</span></p>
				<p class="navbar-text">剩余桌位:<span class="badge" id="surplustable">${rest}</span></p>
				<p class="navbar-text" >待清桌位:<span class="badge" id="surplustable" class="label label-danger">${dirty}</span></p>
				<p class="navbar-text">未结单:<span class="badge" id="surplustable">${total}</span></p>
				<p class="navbar-text">已结单:<span class="badge" id="surplustable">${payed}</span></p>
				
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input class="form-control" type="text" placeholder="搜索">
					</div>					
					<button class="btn btn-default" type="submit" >搜索</button>					
				</form>				
			</div>
		</div>
	</nav>

	</div>

	<!-- 功能区 -->
	<div class="body" style="margin-top:0px;">
		<div class="row">
			<div class="col-md-10" style="width:83%">
				<iframe id="main" name="main" width="100%" frameborder=0 height="590px" scrolling="yes" src="ManagementTable.jsp" >					
					
				</iframe>
			</div>
			<div class="col-md-2" style="width:17%">
				<div class="list-group">
				  <a href="ManagementTable.jsp" target="main"class="list-group-item">餐桌管理</a>
				<!--   <a href="ReservationTable.jsp" target="main" class="list-group-item">餐桌预定</a>
				  <a href="order_lsit.jsp" target="main" class="list-group-item">订单查询</a> -->
				 
				  
				</div>
				<!-- <a href="###" class="btn btn-danger button-control"  role="button">清台</a>
				<a href="###" class="btn btn-danger button-control"  role="button">清扫结束</a><BR>
				<a href="###" class="btn btn-primary button-control" role="button" data-toggle="modal" data-target="#myModal2">买单</a>
				<a href="###" class="btn btn-primary button-control" role="button">交班报表</a><BR>
				<a href="###" class="btn btn-warning button-control" role="button">催菜</a>
				<a href="###" class="btn btn-warning button-control" role="button">查看流水</a><BR>
				<a href="###" class="btn btn-danger button-control" role="button">拆台</a>
				<a href="ManagementTable.html" target="main" class="btn btn-success button-control" role="button">刷新桌位</a> -->
				
			</div>
		</div>
	</div>
 </div>

<div class="modal fade bs-example-modal-lg" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h3 class="modal-title" id="myModalLabel" style="align:center;font-weight:bold;">菜单详情</h3>
      </div>
      <div class="modal-body">
		  <div class="mytable">
			  <table class="table table-striped table-condensed table-hover">				
				<tr>
					<th>序号</th><th>菜目名称</th><th>数量</th><th>单价</th><th>桌号</th><th>口味</th>
				</tr>
				<tr>
					<td>1</td><td>油焖大虾</td><td>1</td><td>68</td><td>1</td><td>重口味</td>
				</tr>
				<tr>
					<td>2</td><td>青龙闹海</td><td>1</td><td>56</td><td>1</td><td>清淡</td>
				</tr>
				<tr>
					<td>3</td><td>蚂蚁上树</td><td>1</td><td>38</td><td>1</td><td>特辣</td>
				</tr>
			  </table>
		  </div>
		  <div style="overflow:auto">
			<div style="float:left;">				
				<form class="form-inline">
					<div class="form-group">
						<label><B>总计消费:</B></label>
						<input class="form-control" id="countRMB" type="text" style="width:80px">			
					</div>
				</form>				
			</div>				
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary">确认结账</button>
      </div>
    </div>
  </div>
</div>
<br><br>

      
<script type="text/javascript">  
function getValue()  
{  
    var ofrm1 = document.getElementById("main").document;      
    if (ofrm1==undefined)  
    {  
        ofrm1 = document.getElementById("main").contentWindow.document;  
        var ff = ofrm1.getElementById("txt1").value;  
        alert("firefox/chrome取值结果为:" + ff);  
    }  
    else  
    {  
        var ie = document.frames["main"].document.getElementById("txt1").value;  
        alert("ie取值结果为:" + ie);  
    }   
}  
</script>  

 </BODY>
</HTML>
