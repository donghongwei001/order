<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'shengshijilian.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/province.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

a,img {
	border: 0;
}

.row .container1 ul {
	list-style-type: none;
	padding: 0px;
	margin: 0px;
}
/* 省 */
.row .right-body .province {
	width: 90px;
	height: 23px;
	margin-top: 6px;
	border: 1px solid #e2e2e2;
	font-size: 14px;
	float: left;
	line-height: 22px;
	margin-left: 26px;
	color: #a2a2a2;
}

.row .right-body .province .provincexs {
	float: left;
	padding-left: 10px;
}

.row .right-body .province .dianprovince {
	width: 22px;
	height: 22px;
	display: block;
	float: right;
	background: url(images/V.png) 0 0 no-repeat;
	cursor: pointer;
}

.row .right-body .province .quanprovince {
	width: 90px;
	height: 100px;
	overflow-y: scroll;
	overflow-x: hidden;
	display: none;
	margin-left: -1px;
	border: 1px solid #e2e2e2;
	border-top: none;
	border-right: none;
	background-color: #FFF;
}

.row .right-body .province ul {
	width: 70px;
}

.row .right-body .province li:hover {
	background-color: #f1f1f1;
}
/* 市 */
.row .right-body .city {
	width: 90px;
	height: 23px;
	margin-top: 6px;
	border: 1px solid #e2e2e2;
	font-size: 14px;
	float: left;
	line-height: 22px;
	margin-left: 10px;
	color: #a2a2a2;
}

.row .right-body .city .cityxs {
	float: left;
	padding-left: 10px;
}

.row .right-body .city .diancity {
	width: 22px;
	height: 22px;
	display: block;
	float: right;
	background: url(images/V.png) 0 0 no-repeat;
	cursor: pointer;
}

.row .right-body .city .quancity {
	width: 90px;
	height: 100px;
	overflow-y: scroll;
	overflow-x: hidden;
	display: none;
	margin-left: -1px;
	border: 1px solid #e2e2e2;
	border-top: none;
	border-right: none;
	background-color: #FFF;
}

.row .right-body .city ul {
	width: 70px;
}

.row .right-body .city li:hover {
	background-color: #f1f1f1;
}
/* 区 */
.row .right-body .area {
	width: 90px;
	height: 23px;
	margin-top: 6px;
	border: 1px solid #e2e2e2;
	font-size: 14px;
	float: left;
	line-height: 22px;
	margin-left: 10px;
	color: #a2a2a2;
}

.row .right-body .area .areaxs {
	float: left;
	padding-left: 10px;
}

.row .right-body .area .dianarea {
	width: 22px;
	height: 22px;
	display: block;
	float: right;
	background: url(images/V.png) 0 0 no-repeat;
	cursor: pointer;
}

.row .right-body .area .quanarea {
	width: 90px;
	height: 100px;
	overflow-y: scroll;
	overflow-x: hidden;
	display: none;
	margin-left: -1px;
	border: 1px solid #e2e2e2;
	border-top: none;
	border-right: none;
	background-color: #FFF;
}

.row .right-body .area .mousemove {
	display: none;
}

.row .right-body .area ul {
	width: 70px;
}

.row .right-body .area li:hover {
	background-color: #f1f1f1;
}
</style>
<script>
	$(function() {

		$("body").click(function() {//点击空白处隐藏，使用e.stopPropagation()阻止事件冒泡
			$(".quanprovince").hide();
			$(".quancity").hide();
			$(".quanarea").hide();
		});
		//下拉列表获取地址
		var strSHENG = document.querySelector('.ulprovince').outerHTML; //获取class为ulprovince的outerHTML
		var strSHI = document.querySelector('.ulcity').outerHTML; //获取class为ulcity的outerHTML
		var strQU = document.querySelector('.ularea').outerHTML; //获取class为ulcity的outerHTML
		//从js库里得到所有的数据
		var sfgsmr = provinceList;
		var sfxz = 0;
		var csxz = 0;
		var qyxz = 0;
		/*省*/
		document.querySelector('.dianprovince').onclick = function(e) {
			document.querySelector('.quanprovince').style.display = "block";//下拉窗口显示
			e.stopPropagation();
			var str = strSHENG.substring(0, strSHENG.length - 5); //获取strSHENG的第0-第3个字节
			for ( var i = 0; i < sfgsmr.length; i++) // 
			{
				str += "<li value='" + sfgsmr[i].name + "' style='padding-left:10px;'> "
						+ sfgsmr[i].name + "</li>"; //创建li标签 把i值放进去
			}
			document.querySelector('.ulprovince').outerHTML = str + "</ul>"; //把li放进class为ulyear中
			var lis = document.querySelector('.ulprovince')
					.getElementsByTagName('li'); //获取这里边的li标签
			for ( var i = 0; i < lis.length; i++) {
				lis[i].onclick = function() {
					for ( var ii = 0; ii < lis.length; ii++) {
						if (this == lis[ii]) {
							document.querySelector('.provincexs').innerHTML = lis[ii].innerHTML; //li的内容赋给document.querySelector('.xs')
							var sheng = lis[ii].getAttribute('value'); //获取点击的li的value属性值
							document.querySelector('.provincexs').setAttribute(
									"value", sheng); //设置document.querySelector('.xs')的value属性值yearvalue
							document.querySelector('.quanprovince').style.display = "none"; //窗口消失
							var shi = provinceList[ii].cityList[0].name;
							document.querySelector('.cityxs').innerHTML = shi;
							var qu = provinceList[ii].cityList[0].areaList[0];
							document.querySelector('.areaxs').innerHTML = qu;
							return sfxz = sheng;//把选中的li的传参给省
						}
					}
				}
			}
		}

		/*市*/
		var shiXb = 0;
		document.querySelector('.diancity').onclick = function(e) {
			document.querySelector('.quancity').style.display = "block";//下拉窗口显示
			e.stopPropagation();
			for ( var i = 0; i < sfgsmr.length; i++) {
				if (provinceList[i].name == sfxz) {
					shiXb = i;
					var str = strSHI.substring(0, strSHI.length - 5);
					for ( var j = 0; j < provinceList[i].cityList.length; j++) {
						str += "<li value='" + provinceList[i].cityList[j].name + "' style='padding-left:10px;'> "
								+ provinceList[i].cityList[j].name + "</li>";
					}
					document.querySelector('.ulcity').outerHTML = str + "</ul>";
					var lis = document.querySelector('.ulcity')
							.getElementsByTagName('li');
					for ( var ii = 0; ii < lis.length; ii++) {
						lis[ii].onclick = function() {
							for ( var jj = 0; jj < lis.length; jj++) {
								if (this == lis[jj]) {
									document.querySelector('.cityxs').innerHTML = lis[jj].innerHTML;
									var shi = lis[jj].getAttribute('value');
									document.querySelector('.cityxs')
											.setAttribute("value", shi);
									document.querySelector('.quancity').style.display = "none";
									var qu = provinceList[shiXb].cityList[jj].areaList[0];
									document.querySelector('.areaxs').innerHTML = qu;
									return csxz = shi;//把选中的li的传参给市
								}
							}
						}
					}
				}
			}
		}
		/*区*/
		document.querySelector('.dianarea').onclick = function(e) {
			document.querySelector('.quanarea').style.display = "block";//下拉窗口显示
			e.stopPropagation();
			for ( var i = 0; i < sfgsmr.length; i++) {
				if (provinceList[i].name == sfxz) {
					for ( var j = 0; j < provinceList[i].cityList.length; j++) {
						if (provinceList[i].cityList[j].name == csxz) {
							var str = strQU.substring(0, strQU.length - 5);
							for ( var k = 0; k < provinceList[i].cityList[j].areaList.length; k++) {
								str += "<li value='" + provinceList[i].cityList[j].areaList[k]+ "' style='padding-left:10px;'> "
										+ provinceList[i].cityList[j].areaList[k]
										+ "</li>";
							}
							document.querySelector('.ularea').outerHTML = str
									+ "</ul>";
							var lis = document.querySelector('.ularea')
									.getElementsByTagName('li');
							for ( var ii = 0; ii < lis.length; ii++) {
								lis[ii].onclick = function() {
									for ( var jj = 0; jj < lis.length; jj++) {
										if (this == lis[jj]) {
											document.querySelector('.areaxs').innerHTML = lis[jj].innerHTML;
											document.querySelector('.quancity').style.display = "none";
											return qyxz = qu;//把选中的li的传参给区
										}
									}
								}
							}
						}
					}
				}
			}
		}
	})
</script>



</head>

<body>
	<div class="row" style="margin-left:0px;">
		<div class="container1 a">
			<div class="right">
				<div>
					<ul>
						<li class="right-body" id="updateinfo">
							<div>
								<div class="right-info">
									<div style="float:left">地址&nbsp;：&nbsp;</div>
									<div class="province">
										<div class="provincexs">北京</div>
										<!--把选的值放入这个div里-->
										<span class="dianprovince"></span>
										<!--下拉选项按钮-->
										<div class="quanprovince">
											<!--结果窗口-->
											<ul class="ulprovince"></ul>
										</div>
									</div>
									<div class="city">
										<div class="cityxs">北京</div>
										<!--把选的值放入这个div里-->
										<span class="diancity"></span>
										<!--下拉选项按钮-->
										<div class="quancity">
											<!--结果窗口-->
											<ul class="ulcity"></ul>
										</div>
									</div>
									<div class="area">
										<div class="areaxs">朝阳区</div>
										<!--把选的值放入这个div里-->
										<span class="dianarea"></span>
										<!--下拉选项按钮-->
										<div class="quanarea">
											<!--结果窗口-->
											<ul class="ularea"></ul>
										</div>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
