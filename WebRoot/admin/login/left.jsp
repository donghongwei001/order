<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/admin/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/admin/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add(0,-1,'系统菜单树');
		d.add(1,0,'员工管理','','','mainFrame');
		d.add(2,0,'订单管理','','','mainFrame');
		d.add(24,0,'财务管理','','','mainFrame');
		d.add(25,0,'前台界面','','','mainFrame');
		
		d.add(4,0,'权限管理','','','mainFrame');
		d.add(5,0,'后厨界面','','','mainFrame');
		d.add(6,0,'菜品管理','','','mainFrame');
		d.add(7,0,'餐桌管理','','','mainFrame');
		d.add(8,0,'客户管理','','','mainFrame');
		
		//子目录添加
		d.add(9,1,'员工信息','${pageContext.request.contextPath}/emp_queryEmp.action','','mainFrame');
		/* d.add(10,1,'查看信息','${pageContext.request.contextPath}/admin/products/emp_info.jsp','','mainFrame'); */
		d.add(11,2,'订单列表','${pageContext.request.contextPath}/admin/products/order_list.jsp','','mainFrame');
		/* d.add(12,2,'订单查询','${pageContext.request.contextPath}/booklistservice','','mainFrame'); */
		d.add(13,24,'财务报表','${pageContext.request.contextPath}/admin/products/money_list.jsp ','','mainFrame');
		d.add(26,25,'前台管理','${pageContext.request.contextPath}/admin/products/servicer.jsp ','','mainFrame');
		d.add(14,4,'权限分配','${pageContext.request.contextPath}/admin/products/show_right.jsp','','mainFrame');
		d.add(15,4,'修改权限','${pageContext.request.contextPath}/admin/products/show_right.jsp','','mainFrame');
		d.add(16,5,'菜品排序','${pageContext.request.contextPath}/kitchen_findFood.action','','mainFrame');
		/* d.add(17,5,'菜目估清','${pageContext.request.contextPath}/booklistservice','','mainFrame'); */
		d.add(18,6,'菜品信息','${pageContext.request.contextPath}/admin/products/dishes_list.jsp','','mainFrame');
		/* d.add(19,6,'菜品查询','${pageContext.request.contextPath}/admin/products/food_info.jsp','','mainFrame'); */
		/* d.add(20,7,'餐桌信息','${pageContext.request.contextPath}/admin/products/table_info.jsp','','mainFrame'); */
		d.add(21,7,'添加餐桌','${pageContext.request.contextPath}/admin/products/table_list.jsp','','mainFrame');
		d.add(22,8,'顾客信息','${pageContext.request.contextPath}/admin/products/cust_list.jsp','','mainFrame');
		/* d.add(23,8,'积分查询','${pageContext.request.contextPath}/booklistservice','','mainFrame'); */

	
		
		document.write(d);
		-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
