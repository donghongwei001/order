package com.ordersystem.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.daofactory.DaoFactory;
import com.ordersystem.domain.CustBean;
import com.ordersystem.domain.TableBean;

public class TableImpl {
	DaoFactory dt=new DaoFactory();
	public List<TableBean> ss(String table_id){
		Object[] param=new Object[]{table_id};
		String sql="select table_id,table_Capacity,table_state,emp_name from   table_table,ser_tab,emp_table,role_table where emp_fk_pos_id=role_id and emp_id = fk_emp_id and fk_table_id=table_id and emp_fk_pos_id='2' and table_id=?";
		ArrayList<ArrayList> arr=dt.execQuery(sql, param);
		ArrayList<TableBean> list=new ArrayList<TableBean>();
		for (int i = 0; i < arr.size(); i++) {
			TableBean tb = new TableBean();
			tb.setTable_id( (Integer) arr.get(i).get(0));
			tb.setTable_Capacity((Integer) arr.get(i).get(1));
			tb.setTable_state((Integer) arr.get(i).get(2));
			tb.setFk_emp_id((String) arr.get(i).get(3));
			list.add(tb);
		}
		return list;
	}
	
	public  List<TableBean> seleall() {
		String sql="select table_id,table_Capacity,table_state,emp_name from table_table,ser_tab,emp_table,role_table where emp_fk_pos_id=role_id and emp_id = fk_emp_id and fk_table_id=table_id and emp_fk_pos_id='2'";
		ArrayList<ArrayList> arr=dt.execQuery(sql, null);
		ArrayList<TableBean> list=new ArrayList<TableBean>();
		for (int i = 0; i < arr.size(); i++) {
			TableBean tb = new TableBean();
			tb.setTable_id( (Integer) arr.get(i).get(0));
			tb.setTable_Capacity((Integer) arr.get(i).get(1));
			tb.setTable_state((Integer) arr.get(i).get(2));
			tb.setFk_emp_id((String) arr.get(i).get(3));
			list.add(tb);
		}
		return list;
	}
	
	public int addzhuo(){
		TableBean tb = new TableBean();
		String sql="inset into emp_table values(?)";
		return 1;
	}
	
}
