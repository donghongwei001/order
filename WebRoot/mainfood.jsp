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
		.row{
			margin-left:20%;
			margin-top:8%;
			width:50%;
			height:60%;
		}.row1{
			margin-left:40%;
			margin-top:-33%;
			width:50%;
		}.row2{
			margin-left:60%;
			margin-top:-50%;
			width:50%;
		}.row3{
			margin-left:20%;
			margin-top:60%;
			width:50%;
		}.row4{
			margin-left:40%;
			margin-top:60%;
			width:50%;
		}.row5{
			margin-left:60%;
			margin-top:60%;
			width:50%;
		}
		.row6{
			margin-left:20%;
			margin-top:80%;
			width:50%;
		}.row7{
			margin-left:40%;
			margin-top:80%;
			width:50%;
		}.row8{
			margin-left:60%;
			margin-top:80%;
			width:50%;
		}h4{
			margin-left:45%;
		}#shuliangzuo{
			margin-left:25%;	
		}.xialakuang{
			width:28%;
			height:15%;
			margin-left:33%;
			font-size:25px;
			background:red;
		}#queding{
			margin-left:20%;
		}#queding2{
			margin-left:80%;
		}body{
			background:url("images/kuangjia2beijing.jpg");
			background-size:100%;
		}#jiage{
			margin-top:-5%;
			margin-left:43%;
			font-size:25px;
			color:#330000;
		}#anniubeijing{
			background:url("images/beijingtupian2.jpeg");
		}.modal2-title{
			margin-left:0%;
		}.row9{
			margin-left:20%;
			margin-top:100%;
			width:50%;
		}.row10{
			margin-left:40%;
			margin-top:100%;
			width:50%;
		}
		.row11{
			margin-left:60%;
			margin-top:100%;
			width:50%;
		}
	</style>
  </head>
	<div class="row">
		<div class="col-xs-6 col-md-3">
		<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
			<a href="#" class="thumbnail">
			<img src="images/13152800091302.jpg" alt="...">
			</a>
			<h3 class="modal2-title" id="myModal2Label">鱼香肉丝<br/>
			¥35</h3>
		</button>
			
			
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><spanaria-hidden="true">&times;</span></button>
	<h4 class="modal2-title" id="myModal2Label">鱼香肉丝</h4>
    </div>
    <div class="modal-body">
        <img src="images/13152800091302.jpg" width="100%" alt="...">
		<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
		<hr>
		<div id="jiage">¥:35</div>
		<select  class="xialakuang">
			<option>清淡</option>
			<option>微辣</option>
			<option>中辣</option>
			<option>多辣</option>
			<option>表态辣</option>
		</select>
		<button type="button"id="queding" class="btn2 btn-danger btn-lg">确定</button>
    </div>
    </div>
  </div>
</div>			
	<div class="row1">
		<div class="col-xs-6 col-md-3">
			<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2">
			<a href="#" class="thumbnail">
			<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
			</a>
			<h3 class="modal2-title" id="myModal2Label">宫保鸡丁<br/>
			¥35</h3>
			</button>
		</div>
	</div>
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal2" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal2-title" id="myModal2Label">宫保鸡丁</h4>
			  </div>
			  <div class="modal2-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:55</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
	<div class="row2">
		<div class="col-xs-6 col-md-3">
			<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal3">
			<a href="#" class="thumbnail">
			<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
			</a>
			<h3 class="modal2-title" id="myModal2Label">红烧鱼<br/>
			¥35</h3>
		</button>
		</div>
	</div>
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal3" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal3-title" id="myModal3Label">红烧鱼</h4>
			  </div>
			  <div class="modal3-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:64</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
	<div class="row3">
		<div class="col-xs-6 col-md-3">
			<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal4">
			<a href="#" class="thumbnail">
			<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
			</a>
			<h3 class="modal2-title" id="myModal2Label">糖醋排骨<br/>
			¥35</h3>
		</button>
		</div>
	</div>
	<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal4" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal4-title" id="myModal4Label">糖醋排骨</h4>
			  </div>
			  <div class="modal4-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:38</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
	<div class="row4">
		<div class="col-xs-6 col-md-3">
			<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal5">
			<a href="#" class="thumbnail">
			<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
			</a>
			<h3 class="modal2-title" id="myModal2Label">金瓜粉蒸肉<br/>
			¥35</h3>
		</button>
		</div>
	</div>
	<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal5" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal5-title" id="myModal5Label">金瓜粉蒸肉</h4>
			  </div>
			  <div class="modal5-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:89</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
	<div class="row5">
		<div class="col-xs-6 col-md-3">
			<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal6">
			<a href="#" class="thumbnail">
			<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
			</a>
			<h3 class="modal2-title" id="myModal2Label">七星鱼丸汤<br/>
			¥35</h3>
		</button>
		</div>
	</div>
	<div class="modal fade" id="myModal6" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal6" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal6-title" id="myModal6Label">七星鱼丸汤</h4>
			  </div>
			  <div class="modal6-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:154</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
	<div class="row6">
		<div class="col-xs-6 col-md-3">
			<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal7">
			<a href="#" class="thumbnail">
			<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
			</a>
			<h3 class="modal2-title" id="myModal2Label">龙井虾仁<br/>
			¥35</h3>
		</button>
		</div>
	</div>
	<div class="modal fade" id="myModal7" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal7" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal7-title" id="myModal7Label">龙井虾仁</h4>
			  </div>
			  <div class="modal7-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:355</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
	<div class="row7">
		<div class="col-xs-6 col-md-3">
			<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal8">
			<a href="#" class="thumbnail">
			<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
			</a>
			<h3 class="modal2-title" id="myModal2Label">香炸琵琶虾<br/>
			¥35</h3>
		</button>
		</div>
	</div>
	<div class="modal fade" id="myModal8" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal8" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal8-title" id="myModal8Label">香炸琵琶虾</h4>
			  </div>
			  <div class="modal8-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:842</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
	<div class="row8">
		<div class="col-xs-6 col-md-3">
			<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal10">
			<a href="#" class="thumbnail">
			<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
			</a>
			<h3 class="modal2-title" id="myModal2Label">清炖马蹄鳖<br/>
			¥35</h3>
			</button>
		</div>
	</div>
	<div class="modal fade" id="myModal10" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal10" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal10-title" id="myModal10Label">清炖马蹄鳖</h4>
			  </div>
			  <div class="modal10-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:822</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
		<div class="row9">
			<div class="col-xs-6 col-md-3">
				<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal11">
				<a href="#" class="thumbnail">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				</a>
				<h3 class="modal2-title" id="myModal2Label">青椒肉丝<br/>
				¥35</h3>
				</button>
			</div>
		</div>
		<div class="modal fade" id="myModal11" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal11" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal11-title" id="myModal11Label">青椒肉丝</h4>
			  </div>
			  <div class="modal11-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:64</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
		<div class="row10">
			<div class="col-xs-6 col-md-3">
				<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal12">
				<a href="#" class="thumbnail">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				</a>
				<h3 class="modal2-title" id="myModal2Label">油焖大虾<br/>
				¥350</h3>
				</button>
			</div>
		</div>
		<div class="modal fade" id="myModal12" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal12" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal12-title" id="myModal12Label">油焖大虾</h4>
			  </div>
			  <div class="modal12-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:64</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
		<div class="row11">
			<div class="col-xs-6 col-md-3">
				<button id="anniubeijing" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal13">
				<a href="#" class="thumbnail">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				</a>
				<h3 class="modal2-title" id="myModal2Label">糖醋排骨<br/>
				¥350</h3>
				</button>
			</div>
		</div>
		<div class="modal fade" id="myModal13" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal13" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal13-title" id="myModal13Label">糖醋排骨</h4>
			  </div>
			  <div class="modal13-body">
				<img src="images/13152800091302.jpg" alt="..." width="100%" class="img-circle">
				<hr>
				
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="1"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<hr>
				<div id="jiage">¥:64</div>
				<button type="button" id="shuliangzuo" class="btn1 btn-danger btn-lg">&nbsp;-&nbsp;</button>
				<input class="shuliang" type="text" value="微辣"/>
				<button type="button"id="shuliangyou" class="btn2 btn-danger btn-lg">&nbsp;+&nbsp;</button>
				<button type="button"id="queding2" class="btn2 btn-danger btn-lg">确定</button>
			  </div>
			</div>
		  </div>
		</div>
	</div>
	<br/>
	<br/>
	<br/>
  <body>

		
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-2.1.3.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>