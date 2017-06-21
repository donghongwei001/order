<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
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
	
	.mytable{
		height:460px;
		background-color:#669933;
		
	}
	td{text-align:center;}
	th{text-align:center;}

	.mymenu{
		height:460px;
		
	}
	.button-control{
		width:120px;
		margin:15 0 0 15;
		text-align:center;
	}
	.collg7{width:40%;
		float:left;	
	}
	.collg5{width:55%;
		float:right;
		margin:0 12 0 12;
		height:460px;
	}
	.rowee{
		overflow:auto;
		margin:0 auto;
	}
  </style>
 </HEAD>

 <BODY>
 
	<div class="rowee">
		<div class="collg7">
			
			<div class="mytable">
			  <table class="table table-striped table-condensed table-hover">
				<tr>
					<th colspan="7">已点菜单</th>
				</tr>
				<tr>
					<th>序号</th><th>菜目名称</th><th>数量</th><th>单价</th><th>桌号</th><th>口味</th><th>删除</th>
				</tr>
				<tr>
					<td>1</td><td>油焖大虾</td><td>1</td><td>68</td><td>1</td><td>重口味</td><td><input type="checkbox" name="addmenu"></td>
				</tr>
				<tr>
					<td>2</td><td>青龙闹海</td><td>1</td><td>56</td><td>1</td><td>清淡</td><td><input type="checkbox" name="addmenu"></td>
				</tr>
				<tr>
					<td>3</td><td>蚂蚁上树</td><td>1</td><td>38</td><td>1</td><td>特辣</td><td><input type="checkbox" name="addmenu"></td>
				</tr>
			  </table>
			</div>

			<div class="" style="margin-top:10px">
				<div style="float:left;">				
				<form class="form-inline">
					<div class="form-group">
						<label><B>总计消费:</B></label>
						<input class="form-control" id="countRMB" type="text" style="width:80px">				
					</div>
				  </form>				
				</div>
				<div style="float:right">
				<div><a class="btn btn-danger" href="#">删除菜品</a></div>				
				</div>
				<div style="float:right">
				<div><a class="btn btn-warning" href="#" style="margin:0 10 0 10">修改做法</a></div>				
				</div>
			</div>
		  
		 
		</div>
		<div class="collg5">
			<div class="mymenu">
				<table class="table table-striped table-condensed table-hover">
					<tr>
						<th colspan="6">菜单目录</th>
					</tr>
					<tr>
						<th>序号</th><th>菜目名称</th><th>菜系</th><th>单价</th><th>口味</th><th>选择</th>
					</tr>
					<tr>
						<td>1</td><td>油焖大虾</td><td>豫菜</td><td>68</td><td>重口味</td><td><input type="checkbox" name="addmenu"></td>
					</tr>
					<tr>
						<td>2</td><td>青龙闹海</td><td>川菜</td><td>56</td><td>清淡</td><td><input type="checkbox" name="addmenu"></td>
					</tr>
					<tr>
						<td>3</td><td>蚂蚁上树</td><td>鲁菜</td><td>38</td><td>特辣</td><td><input type="checkbox" name="addmenu"></td>
					</tr>
				  </table>
			</div>
			
			<!-- <div class="row">
				<div class="col-lg-2">菜名</div>
				<div class="col-lg-2">单价</div>
				<div class="col-lg-2">菜系</div>
				<div class="col-lg-2">口味</div>
				<div class="col-lg-2">菜名</div>
				<div class="col-lg-2">菜名</div>
			</div>
			<div class="row">
				<div class="col-lg-2">小葱拌豆腐</div>
				<div class="col-lg-2">28</div>
				<div class="col-lg-2">家常菜</div>
				<div class="col-lg-2">清淡</div>
				<div class="col-lg-2">菜名</div>
				<div class="col-lg-2">菜名</div>
			</div>
			<div class="row">
				<div class="col-lg-2">剁椒鱼头</div>
				<div class="col-lg-2">58</div>
				<div class="col-lg-2">湘菜</div>
				<div class="col-lg-2">特辣</div>
				<div class="col-lg-2">菜名</div>
				<div class="col-lg-2">菜名</div>
			</div> -->
			<div style="margin-top:10px"><a class="btn btn-primary" href="#">添加菜品</a></div>
			
		</div>
	</div>
  
 </BODY>
</HTML>