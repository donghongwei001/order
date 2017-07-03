package com.ordersystem.domain;

public class TableBean {
	private int table_id;
	private int table_Capacity;
	private String  table_state;
	private String fk_emp_id;
	private String code_name;
	private String emp_code_name;
	public String getCode_name() {
		return code_name;
	}
	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}
	public String getEmp_code_name() {
		return emp_code_name;
	}
	public void setEmp_code_name(String emp_code_name) {
		this.emp_code_name = emp_code_name;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	private String emp_name;
	private String table_name;
	private String emp_state;
	public String getEmp_state() {
		return emp_state;
	}
	public void setEmp_state(String emp_state) {
		this.emp_state = emp_state;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public int getTable_Capacity() {
		return table_Capacity;
	}
	public void setTable_Capacity(int table_Capacity) {
		this.table_Capacity = table_Capacity;
	}
	
	public String getTable_state() {
		return table_state;
	}
	public void setTable_state(String table_state) {
		this.table_state = table_state;
	}
	public String getFk_emp_id() {
		return fk_emp_id;
	}
	public void setFk_emp_id(String fk_emp_id) {
		this.fk_emp_id = fk_emp_id;
	}
	

}
