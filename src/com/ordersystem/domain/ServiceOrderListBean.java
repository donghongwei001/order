package com.ordersystem.domain;

public class ServiceOrderListBean {
	private String food_name;			//food���еĲ���
	private Integer food_price;			//food�еĲ˵���
	private String table_name;			//���ӱ��еĲ�������
	private Integer table_id;			//���ӱ��еĲ������
	private Integer order_food_num;		//������Ʒ���е�����
	private String order_food_mark;		//������Ʒ���еĿ�ζ��ע
	private Integer order_food_id;		//������Ʒ���еĲ˱��
	private Integer order_id; 			//�������еĶ������
	private String code_name;			//������Ʒ���еĸò˶���״̬
	private Integer cus_id;				//�˿ͱ��еĹ˿ͱ��  �������¼���������ʱ����ܻ� �õ�
	private String cus_name;			//�˿ͱ��еĹ˿����� ����� ����ʾ�ڶ�������ҳ�Ľ�����
	
	public String getCode_name() {
		return code_name;
	}
	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}
	public Integer getCus_id() {
		return cus_id;
	}
	public void setCus_id(Integer cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public Integer getFood_price() {
		return food_price;
	}
	public Integer getTable_id() {
		return table_id;
	}
	public void setTable_id(Integer table_id) {
		this.table_id = table_id;
	}
	public void setFood_price(Integer food_price) {
		this.food_price = food_price;
	}
	public Integer getOrder_food_num() {
		return order_food_num;
	}
	public void setOrder_food_num(Integer order_food_num) {
		this.order_food_num = order_food_num;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getOrder_food_mark() {
		return order_food_mark;
	}
	public void setOrder_food_mark(String order_food_mark) {
		this.order_food_mark = order_food_mark;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getOrder_food_id() {
		return order_food_id;
	}
	public void setOrder_food_id(Integer order_food_id) {
		this.order_food_id = order_food_id;
	}
	
}
