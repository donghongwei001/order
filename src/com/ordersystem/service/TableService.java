package com.ordersystem.service;

import java.util.ArrayList;
import java.util.List;

import com.ordersystem.dao.impl.TableImpl;
import com.ordersystem.domain.TableBean;
import com.ordersystem.domain.Table_indent;
import com.ordersystem.domain.ser_tabBean;

public class TableService {
	TableImpl tq = new TableImpl();
	
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
}
