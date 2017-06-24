package com.ordersystem.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.daofactory.DaoFactory;
import com.ordersystem.domain.CustBean;
import com.ordersystem.domain.TableBean;
import com.ordersystem.domain.Table_indent;
import com.ordersystem.domain.ser_tabBean;

public class TableImpl {
	DaoFactory dt=new DaoFactory();
	public List<TableBean> ss(String table_id){
		Object[] param=new Object[]{table_id};
		String sql="select table_id,table_name,table_Capacity,code_name,emp_name from  table_table,ser_tab,emp_table,role_table,code_table where emp_fk_pos_id=role_id and emp_id = fk_emp_id and fk_table_id=table_id and code_id=table_state and emp_fk_pos_id='2' and table_id=?";
		ArrayList<ArrayList> arr=dt.execQuery(sql, param);
		ArrayList<TableBean> list=new ArrayList<TableBean>();
		for (int i = 0; i < arr.size(); i++) {
			TableBean tb = new TableBean();
			tb.setTable_id( (Integer) arr.get(i).get(0));
			tb.setTable_name((String) arr.get(i).get(1));
			tb.setTable_Capacity((Integer) arr.get(i).get(2));
			tb.setTable_state((String) arr.get(i).get(3));
			tb.setFk_emp_id((String) arr.get(i).get(4));
			list.add(tb);
		}
		return list;
	}
	
	public  List<TableBean> seleall() {
		String sql="select table_id,table_name,table_Capacity,code_name,emp_name from  table_table,ser_tab,emp_table,role_table,code_table where emp_fk_pos_id=role_id and emp_id = fk_emp_id and fk_table_id=table_id and code_id=table_state and emp_fk_pos_id='2' ";
		ArrayList<ArrayList> arr=dt.execQuery(sql, null);
		ArrayList<TableBean> list=new ArrayList<TableBean>();
		for (int i = 0; i < arr.size(); i++) {
			TableBean tb = new TableBean();
			tb.setTable_id( (Integer) arr.get(i).get(0));
			tb.setTable_name((String) arr.get(i).get(1));
			tb.setTable_Capacity((Integer) arr.get(i).get(2));
			tb.setTable_state((String) arr.get(i).get(3));
			tb.setFk_emp_id((String) arr.get(i).get(4));
			list.add(tb);
		}
		return list;
	}
	
	/** 
	 * 方法功能说明：   增加桌子页面中查询数据库中服务员列表
	 */
	public List<Table_indent> selewaiter(){
		String sql="select emp_name,emp_id from emp_table,role_table where emp_fk_pos_id=role_id and role_id='2'";
		ArrayList<ArrayList> arr=dt.execQuery(sql, null);
		ArrayList<Table_indent> list=new ArrayList<Table_indent>();
		for (int i = 0; i < arr.size(); i++) {
			Table_indent ti=new Table_indent();
			ti.setWaiter((String) arr.get(i).get(0));
			ti.setEmp_id((Integer) arr.get(i).get(1));
			list.add(ti);
		}
		return list;
	}
	
	/**
	 * 
	 * 方法功能说明：	  增加桌子
	 * @return int     
	 * @throws
	 */
	public void addzhuo(TableBean tb,ser_tabBean st){
		//桌子表插入 
		
		String sql="insert into table_table (table_Capacity,table_state,table_name) values(?,?,?)";
		Object[] arr1=new Object[]{tb.getTable_Capacity(),tb.getTable_state(),tb.getTable_name()};
		dt.executeUpdate(sql, arr1);
		
		String s="select table_id from table_table where table_name=?";
		Object[] pa=new Object[]{tb.getTable_name()};
		ArrayList<ArrayList> arr=dt.execQuery(s, pa);
		Integer i = (Integer) arr.get(0).get(0);
		
		String sql1="insert into ser_tab (fk_emp_id,fk_table_id) values(?,?)";
		Object[] arr2=new Object[]{st.getFk_emp_id(),i};
		dt.executeUpdate(sql1, arr2);
	}
	
}
