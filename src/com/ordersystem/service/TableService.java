package com.ordersystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Table;

import com.ordersystem.dao.impl.TableImpl;
import com.ordersystem.domain.TableBean;
import com.ordersystem.domain.Table_indent;
import com.ordersystem.domain.ser_tabBean;

public class TableService {
	TableImpl tq = new TableImpl();
	
	/**
	 * 
	 * 方法功能说明：  查询所有桌子信息
	 */
	public List<TableBean> seleA() {
		return tq.seleall();
	}
	
	public List<TableBean> selezhuohao(String table_id) {
		return tq.ss(table_id);
	}
	
	public List<Table_indent> selwaiter() {
		return tq.selewaiter();
	}
	
	public void addtable( TableBean tb,ser_tabBean st) {
		tq.addzhuo(tb,st);
	}
	/**
	 * 方法功能说明： 修改桌子信息
	 */
	public void updatee(TableBean tb,ser_tabBean st,String tb_id) {
		tq.update(tb,st,tb_id);
	}
	
	public void seleid(TableBean tb,ser_tabBean st,String id) {
		tq.deltable(tb,st, id);
	}
	public int seidcar(String tbname) {
		int fll = tq.sltbname(tbname);
		return fll;
	}
	
	public List<TableBean> findonetab(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from table_table,ser_tab where table_id=fk_table_id and table_id="+id;
		return tq.findonetb(sql);
	}

	/**ajax桌子列表分页的方法
	 * @author hcb
	 * 
	 */
	public List ajaxlisttab(Map<String, String> ma, Integer pagesize,Integer pageStart) {
		// TODO Auto-generated method stub
		String str = "";
		List arr = new ArrayList();
		if(ma!=null&&ma.size()!=0){
			Set<String> keySet = ma.keySet();
			for (String string : keySet) {
				str = " and "+string+"="+ma.get(string);
			}
		}
		String sql = "select top "+pagesize+" e.table_id,e.table_name,e.table_Capacity,e.code_name,emp_name,c.code_name emp_code_name from emp_state e,code_table c where e.emp_state=c.code_id"+str+" and table_id not in (select top "+pageStart+" table_id from emp_state e,code_table c where e.emp_state=c.code_id"+str+" order by table_id desc)order by table_id desc";
		List<TableBean> tblist = tq.listtab(sql);
		System.out.println(sql);
		String sql2 = "select count(*) from emp_state e,code_table c where e.emp_state=c.code_id"+str;
		Integer count = tq.countNum(sql2);
		arr.add(tblist);
		arr.add(count);
		return arr;
	}
}
