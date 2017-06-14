<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	  
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<style type="text/css">
	*{margin:0px}
	body{
		margin:0px;
		padding:0px;
	}
	.kuangjia1{
		
	}
	.kuangjia2{
		margin-left:20%;
		margin-top:-70%;
	}
	#nav-tabs{
		font-size:30px;
		width:100%;
		margin-left:20%;
	}
	#sousuo1{
		margin-top:5px;
	}#sousuo2{
		margin-top:17px;
	}#pingfen{
		width:40px;
	}#tijiao{
		margin-left:95%;
		margin-top:2%;
	}#wodecaidan{
		margin-left:75%;
		margin-top:-5%;
		width:20%;
		height:20%;
		background:url("images/北京图片1.jpg");
		backgrounf-size:100%;
	}.container{
		width:100%;
		background:url("images/beijingtupian2.jpeg");
	}.navbar-default{
		width:100%;
	}#shanchu{
		margin-left:30%;
	}#jiezhang{
		margin-top:5%;
		margin-left:70%;
	}#hujiao{
		margin-left:10%;
		margin-bottom:-5%;
	}.btn-info{
		background:url("images/anniubeijing3.jpg");
	}#zhuohao{
		margin-left:-15%;
		margin-top:0.5%;
		background:url("images/anniubeijing4.jpg");
		padding:5px;
		color:white;
	}
	
	</style>
  </head>
		
  <body>
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
		<ul id="nav-tabs" class="nav nav-tabs" role="tablist">
		<li id="zhuohao" role="presentation">本桌桌号:031</li>
		<li role="presentation" class="active"><a id="active" href="#home" aria-controls="home" role="tab" data-toggle="tab"><button type="submit" id="sousuo1" class="btn btn-info btn-lg"><span class=" glyphicon glyphicon-apple"></span>菜单信息<span class="glyphicon glyphicon-apple"></span></button></a></li>

		<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab"><button type="submit" id="sousuo1" class="btn btn-info btn-lg"><span class=" glyphicon glyphicon-apple"></span>个人信息<span class="glyphicon glyphicon-apple"></span></button></a></li>
		<li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">
		<button type="submit" id="sousuo1" class="btn btn-info btn-lg"><span class=" glyphicon glyphicon-apple"></span>积分商城<span class="glyphicon glyphicon-apple"></span></button></a></li>
		<li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">
		<button type="submit" id="sousuo1" class="btn btn-info btn-lg"><span class=" glyphicon glyphicon-apple"></span>Settings<span class="glyphicon glyphicon-apple"></span></button></a></li>
		<li>
		<form class="navbar-form navbar-left">
			<div class="form-group">
			<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" id="sousuo1" class="btn btn-default">搜索</button>
		</form>
		</li>
		
		
		<li role="presentation"><a href="项目前台.html" /><button type="button" class="btn btn-danger">返回主页面</button></a></li>
		<li><button type="button" id="jiezhang" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2">结账</button></li>
				
	  </ul>
	 </div>
	</nav>
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal2" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal2-title" id="myModal2Label">确认结账</h4>
			  </div>
			  <div class="modal2-body">
				<iframe class="kuangjia3"src="结账.html" width="100%" height="600px" scrolling="yes" >
					
				</iframe>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<FONT SIZE="5" COLOR="green"><B>总金额:￥584.5元</B></FONT>
				  <div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-default">确认结账</button>
					</div>
			  </div>
			</div>
		  </div>
		</div>
	<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">
	<nav id="xiamiancaidan" class="navbar navbar-default navbar-fixed-bottom">
	<div class="container">
	<button type="submit" id="hujiao" class="btn btn-danger btn-lg">呼叫服务员</button>
    <button type="button" id="wodecaidan" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal9">
	我点的菜(请记得点我下单)</button>
	</div>
	</nav>
	<div class="modal fade" id="myModal9" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal9" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  </div>
			  <div class="modal9-body">
			  
        <!--表单验证-->
				<iframe class="kuangjia3"src="我的菜单.html" width="100%" height="600px" scrolling="yes" >
					
				</iframe>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<FONT SIZE="5" COLOR="green"><B>总金额:￥584.5元</B></FONT>
				  <div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-default">下单</button>
					</div>
			  </div>
			</div>
		  </div>
		  
	</div>
			<iframe class="kuangjia1"src="left.jsp" width="20%" height="1000px" scrolling="auto" >
			</iframe>
			<iframe class="kuangjia2" src="mainfood.jsp" name="main" width="80%" height="1000px" scrolling="auto" >
		</iframe>
</div>
	
		<div role="tabpanel" class="tab-pane" id="profile">
			<br/>
			<br/><br/>
			<br/>
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
			  <div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
				  <h4 class="panel-title">
					<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
					  <FONT SIZE="5" COLOR="green"><B>您的个人信息</B></FONT>
					</a>
				  </h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
				  <div class="panel-body">
					<p class="text-success">您&nbsp;&nbsp;&nbsp;的&nbsp;&nbsp;&nbsp;用&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;名：<input type="text" id="gerenxinxi"placeholder="donghongwei"/></p>
					<br/>
					<p class="text-info">您关联的手机号是&nbsp;：<input type="text" id="gerenxinxi"placeholder="18603708444"/></p>
					<br/>
					<br/>
					<br/>
					<button type="button" class="btn btn-danger" data-toggle="modal" data-target=".bs-example-modal-sm">修改信息</button>
					<br/>
					<br/>
					<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
					  <div class="modal-dialog modal-lg" role="document">
						<div class="modal-content">
						  <p class="text-success">您&nbsp;&nbsp;&nbsp;的&nbsp;&nbsp;&nbsp;用&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;名：<input type="text" id="gerenxinxi"placeholder="donghongwei"/></p>
							<p class="text-info">您关联的手机号是&nbsp;：<input type="text" id="gerenxinxi"placeholder="18603708444"/></p>
							<button type="button" class="btn btn-danger btn-lg" data-dismiss="modal">取消</button>
							<button type="button" id="xiugai" class="btn btn-warning  btn btn-lg">确认修改</button>
						</div>
					  </div>
					</div>
					
				  </div>
				</div>
			  </div>
			  <div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingTwo">
				  <h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
					  <FONT SIZE="5" COLOR="green"><B>你以往的消费情况</B></FONT>
					</a>
				  </h4>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
				  <div class="panel-body">
					<table class="table table-hover">
						<tr>
							<td>光临次数</td><td>光临时间</td><td>所点菜品</td><td>消费金额</td>
						</tr>
						<tr>
							<td>0</td><td>0</td><td>0</td><td>0</td>
						</tr>
						<tr>
							<td>0</td><td>0</td><td>0</td><td>0</td>
						</tr>
						<tr>
							<td>0</td><td>0</td><td>0</td><td>0</td>
						</tr>
					</table>
				  </div>
				</div>
			  </div>
			  <div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingThree">
				  <h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
					  
					  <FONT SIZE="5" COLOR="green"><B>请写下你对我们不满意的地方，我们一定竭力做到让您满意</B></FONT>
					</a>
				  </h4>
				</div>
				<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
				  <div class="panel-body">
				  <FONT SIZE="15" COLOR=""><B>请为我们的服务打分</B></FONT>
				  <select id="pingfen" class="form-control">
					  <option>1</option>
					  <option>2</option>
					  <option>3</option>
					  <option>4</option>
					  <option>5</option>
				</select>
				<BR/>
				<BR/><BR/>

				<BR/>
				请填写你最宝贵的意见
					<textarea class="form-control" rows="3"></textarea>
					<button type="submit" id="tijiao"  class="btn btn-info">提交</button>
				  </div>
				</div>
			  </div>
			</div>
		
		</div>
    <div role="tabpanel" class="tab-pane" id="messages"><img src="images/13152800091302.jpg"/>
	dsfdsfds</div>
    <div role="tabpanel" class="tab-pane" id="settings"><img src="images/855afb27317633aa17385d7948db026ef74f244a184f3-OEcmVE_fw658.jpg"/></div>
  </div>

		
</div>
		
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-2.1.3.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script type="java/script">
		$("#mainframe",parent.document.body).attr("src","http://www.111cn.net");
	</script>
  </body>
</html>