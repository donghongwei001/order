<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <title>订餐系统</title>
    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- DataTables Responsive CSS -->
    <link href="css/dataTables.responsive.css" rel="stylesheet">
</head>

<body>
		<div id="page-wrapper">
            <div class="row">
                
                <!-- /.col-lg-12 -->
            </div>


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
						 <div class="panel-heading">
                            餐桌详情
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>桌号</th>
                                        <th>可供就餐数</th>
                                        <th>最低消费</th>
                                        <th>服务员</th>
                                        <th>销量</th>
										<th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="odd gradeX">
                                        <td>1号桌</td>
                                        <td>10人</td>
                                        <td>300元</td>
                                        <td class="center">张三</td>
                                        <td>10次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>2号桌</td>
                                        <td>8人</td>
                                        <td>200元</td>
                                        <td class="center">李四</td>
                                        <td>8次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
									   <tr class="odd gradeX">
                                        <td>3号桌</td>
                                        <td>12人</td>
                                        <td>350元</td>
                                        <td class="center">张三</td>
                                        <td>18次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>4号桌</td>
                                        <td>20人(大桌)</td>
                                        <td>1000元</td>
                                        <td class="center">李四</td>
										<td>12次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
									 <tr class="odd gradeX">
                                        <td>5号桌</td>
                                        <td>5人</td>
                                        <td>180元</td>
                                        <td class="center">张三</td>
                                        <td>5次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>6号桌</td>
                                        <td>2人</td>
                                        <td>100元</td>
                                        <td class="center">李四</td>
                                        <td>16次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
									<tr class="even gradeC">
                                        <td>7号桌</td>
                                        <td>6人</td>
                                        <td>100元</td>
                                        <td class="center">李四</td>
                                        <td>9次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
									<tr class="even gradeC">
                                        <td>8号桌</td>
                                        <td>18人</td>
                                        <td>800元</td>
                                        <td class="center">李四</td>
                                        <td>11次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
									<tr class="even gradeC">
                                        <td>9号桌</td>
                                        <td>9人</td>
                                        <td>280元</td>
                                        <td class="center">李四</td>
                                        <td>15次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
									<tr class="odd gradeX">
                                        <td>1号桌</td>
                                        <td>10人</td>
                                        <td>300元</td>
                                        <td class="center">张三</td>
                                        <td>10次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>2号桌</td>
                                        <td>8人</td>
                                        <td>200元</td>
                                        <td class="center">李四</td>
                                        <td>8次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
									<tr class="odd gradeX">
                                        <td>1号桌</td>
                                        <td>10人</td>
                                        <td>300元</td>
                                        <td class="center">张三</td>
                                        <td>10次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>2号桌</td>
                                        <td>8人</td>
                                        <td>200元</td>
                                        <td class="center">李四</td>
                                        <td>8次</td>
										<td><button  type="button" class="btn btn-primary  btn btn-default btn-sm">增加</button><button type="button" class="btn btn-danger  btn btn-default btn-sm">删除</button></td>
                                    </tr>
                      
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
    <!-- jQuery -->
    <script src="../js/jquery.min.js"></script>
    <!-- DataTables JavaScript -->
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/dataTables.bootstrap.min.js"></script>
    <script src="js/dataTables.responsive.js"></script>
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: false
        });
    });
    </script>

</body>

</html>