package com.ordersystem.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import sun.invoke.empty.Empty;

import com.ordersystem.dao.impl.EmpImpl;
import com.ordersystem.domain.EmpBeam;
import com.ordersystem.domain.RoleBean;

public class EmpService {
	EmpImpl ei = new EmpImpl(); //
	/**查询所有员工信息
	 * @author hcb
	 * 
	 */
	public List<EmpBeam> queryAllEmp() {
		List<EmpBeam> allEmp = ei.queryAllEmp();
		return allEmp;
	}
	
	
public static void main(String[] args) {
	EmpService es = new EmpService();
	List<EmpBeam> list = es.queryAllEmp();
	System.out.println(list.size());
}

/**添加员工的方法
 * @author hcb
 * 
 */
public void addEmp(EmpBeam emp) {
	// TODO Auto-generated method stub
	emp.setEmp_hire_date(emp.getEmp_hire_date().replace(',','-'));
	emp.setEmp_birday(emp.getEmp_birday().replace(',','-'));
	ei.addEmp(emp);
}

/**查询员工信息
 * @author hcb
 * 
 */
public List queryEmp(Map<String, String> map,String pageSize,String startIndex) {
	// TODO Auto-generated method stub
	Set<String> key = map.keySet();
	String sta = "";
	if (map.size()>0) {
		for (String str : key) {
			sta = sta + "and "+str+" like '%"+map.get(str)+"%'";
		}
	}
	List empList = ei.queryEmp(sta,pageSize,startIndex);
	return empList;
}


public List<RoleBean> findPosition() {
	// TODO Auto-generated method stub
	List<RoleBean> roleList = ei.findPosition();
	return roleList;
}


public void del_emp(String del_id) {
	// TODO Auto-generated method stub
	ei.delEmp(del_id);
}

public int seidcar(String idcar) {
	int fll = ei.sidcar(idcar);
	return fll;
}

}
