package com.ordersystem.service;

import java.util.ArrayList;
import java.util.List;

import com.ordersystem.dao.impl.TableImpl;
import com.ordersystem.domain.TableBean;

public class TableService {
	TableImpl tq = new TableImpl();
	
	public List<TableBean> seleA() {
		return tq.seleall();
	}
	
	public List<TableBean> selezhuohao(String table_id) {
		return tq.ss(table_id);
	}
}
