package com.ordersystem.domain;

public class WaitFoodBean {
	private String fk_order_id;	//����id
	private String table_name;	//��������
	private String food_name;	//����
	//private int count; //�ϲ���Ʒ֮�������
	private String order_food_mark;	//��ע��Ÿò� ����΢����
	private int lasttime;	//���������һ�����ϲ�ʱ��  ����Ȩ�ؼ���
	private int time;		//�ö�����󴴽���ʱ��  ����Ȩ�ؼ���
	private String emp_name;	//����Ա����
	private int order_press; //�ĵ��Ĵߵ�����
	private int food_time;	//���������Ҫ��ʱ��
	private int food_num;	//����ò˵�����
	private int food_maxcb;	//�ò�����ܺϲ���
	//�޸�
	private float order_food_weight;	//�ò˵��ϲ�Ȩ�� ��Ȩ������
	private int order_food_id;	//�ò˵Ĳ˵����
	private String servingtime;		//��¼�òŵ��ϲ�ʱ��
	
	public String getServingtime() {
		return servingtime;
	}
	public void setServingtime(String servingtime) {
		this.servingtime = servingtime;
	}
	public float getOrder_food_weight() {
		return order_food_weight;
	}
	public void setOrder_food_weight(float order_food_weight) {
		this.order_food_weight = order_food_weight;
	}
	public int getOrder_food_id() {
		return order_food_id;
	}
	public void setOrder_food_id(int order_food_id) {
		this.order_food_id = order_food_id;
	}
	
	public int getFood_maxcb() {
		return food_maxcb;
	}
	@Override
	public String toString() {
		return "fk_order_id=" + fk_order_id + ", table_name="
				+ table_name + ", food_name=" + food_name
				+ ", order_food_mark=" + order_food_mark + ", lasttime="
				+ lasttime + ", time=" + time + ", emp_name=" + emp_name
				+ ", order_press=" + order_press + ", food_time=" + food_time
				+ ", food_num=" + food_num + ", food_maxcb=" + food_maxcb
				+ ", order_food_weight=" + order_food_weight
				+ ", order_food_id=" + order_food_id;
	}
	public void setFood_maxcb(int food_maxcb) {
		this.food_maxcb = food_maxcb;
	}
	public String getFk_order_id() {
		return fk_order_id;
	}
	public void setFk_order_id(String fk_order_id) {
		this.fk_order_id = fk_order_id;
	}
	public int getFood_num() {
		return food_num;
	}
	public void setFood_num(int food_num) {
		this.food_num = food_num;
	}
	public int getFood_time() {
		return food_time;
	}
	public void setFood_time(int food_time) {
		this.food_time = food_time;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getOrder_food_mark() {
		return order_food_mark;
	}
	public void setOrder_food_mark(String order_food_mark) {
		this.order_food_mark = order_food_mark;
	}
	public int getLasttime() {
		return lasttime;
	}
	public void setLasttime(int lasttime) {
		this.lasttime = lasttime;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getOrder_press() {
		return order_press;
	}
	public void setOrder_press(int order_press) {
		this.order_press = order_press;
	}
	
}
