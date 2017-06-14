<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">


</HEAD>

<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/addservlet" method="post">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加员工</STRONG> </strong><!-- 添加员工 -->
				</td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">员工编号：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="emp_id" class="bg"/>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">姓名：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="emp_name" 
					class="bg" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">性别：</td>
				<td class="ta_01" bgColor="#ffffff">
				<input type="radio" name="emp_gender"  />男
				<input type="radio"name="emp_gender"  />女
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">出生年月：</td>
				<td class="ta_01" bgColor="#ffffff">
						<select name="emp_birthday">
							<option>1972年</option>
							<option>1973年</option>
							<option>1974年</option>
							<option>1975年</option>
							<option>1976年</option>
							<option>1977年</option>
							<option>1978年</option>
							<option>1979年</option>
							<option>1980年</option>
							<option>1981年</option>
							<option>1982年</option>
							<option>1983年</option>
							<option>1984年</option>
							<option>1985年</option>
							<option>1986年</option>
							<option>1987年</option>
							<option>1988年</option>
							<option>1989年</option>
							<option>1990年</option>
							<option>1991年</option>
							<option>1992年</option>
							<option>1993年</option>
							<option>1994年</option>
							<option>1995年</option>
							<option>1996年</option>
							<option>1997年</option>
						</select>
						<select name="emp_birthday">
						<option>1月</option>
						<option>2月</option>
						<option>3月</option>
						<option>4月</option>
						<option>5月</option>
						<option>6月</option>
						<option>7月</option>
						<option>8月</option>
						<option>9月</option>
						<option>10月</option>
						<option>11月</option>
						<option>12月</option>
					</select>
					<select name="emp_birthday">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
						<option>17</option>
						<option>18</option>
						<option>19</option>
						<option>20</option>
						<option>21</option>
						<option>22</option>
						<option>23</option>
						<option>24</option>
						<option>25</option>
						<option>26</option>
						<option>27</option>
						<option>28</option>
						<option>29</option>
						<option>30</option>
						<option>31</option>
					</select>
				</td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">年龄：</td>
				<td class="ta_01" bgColor="#ffffff">
				<select  name="emp_age">
						<option>20</option>
						<option>21</option>
						<option>22</option>
						<option>23</option>
						<option>24</option>
						<option>25</option>
						<option>26</option>
						<option>27</option>
						<option>28</option>
						<option>29</option>
						<option>30</option>
						<option>31</option>
						<option>32</option>
						<option>33</option>
						<option>34</option>
						<option>35</option>
						<option>36</option>
						<option>37</option>
						<option>38</option>
						<option>39</option>
						<option>40</option>
						<option>41</option>
						<option>42</option>
						<option>43</option>
						<option>44</option>
						<option>45</option>
					</select>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">身份证号：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="emp_idCar" 
					class="bg" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">家庭住址：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="emp_address" 
					class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">入职时间：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="emp_hire_date">
						<option>2012年</option>
						<option>2013年</option>
						<option>2014年</option>
						<option>2015年</option>
						<option>2016年</option>
						<option>2017年</option>
					</select>
					<select name="emp_hire_date">
						<option>1月</option>
						<option>2月</option>
						<option>3月</option>
						<option>4月</option>
						<option>5月</option>
						<option>6月</option>
						<option>7月</option>
						<option>8月</option>
						<option>9月</option>
						<option>10月</option>
						<option>11月</option>
						<option>12月</option>
					</select>
					<select name="emp_hire_date">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
						<option>17</option>
						<option>18</option>
						<option>19</option>
						<option>20</option>
						<option>21</option>
						<option>22</option>
						<option>23</option>
						<option>24</option>
						<option>25</option>
						<option>26</option>
						<option>27</option>
						<option>28</option>
						<option>29</option>
						<option>30</option>
						<option>31</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">职位：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select  name="emp_fk_pos_id">
						<option value="服务员">服务员</option>
						<option value="经理">经理</option>
						<option value="厨师">厨师</option>
						<option value="领班">领班</option>
						<option value="保洁">保洁</option>
						<option value="保安">保安</option>
					</select>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">状态：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="emp_struts">
						<option>在职</option>
						<option>请假</option>
						<option>调休</option>
					</select>
				</td>
			</tr>
			
			<TR>
				<td align="center" colSpan="1" >电话：
				</td>
				<td class="ta_01" colSpan="3"><input type="text"
					name="emp_phone" 
					class="bg" /></td>
			</TR>

			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					
					
						
					<input type="submit" class="button_ok" value="确定">	
						
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					
					
					
					<input type="reset" value="重置" class="button_cancel">

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1">
					
					</span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>