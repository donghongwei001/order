package com.ordersystem.domain;

/**@ WaitFoodBean�İ�װ��  Ϊ�����ṩȨ�غͲ��˵�����
 * @author hcb
 * 
 */
public class SortKitchenFoodBean {
	private WaitFoodBean wfb;
	private String order_food_id;	//id���
	private String foodnum;	//��¼�ϲ���Ʒ��ò˵�����
	private String tabid;	//�������
	private String orderId;	//�������  �ڸ��²�������ϲ�ʱ���ʱ����Ҫ�õ�
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "wfb=" + wfb + ", order_food_id="
				+ order_food_id + ", foodnum=" + foodnum + ", tabid=" + tabid;
	}
	
	public String getOrder_food_id() {
		return order_food_id;
	}
	public void setOrder_food_id(String order_food_id) {
		this.order_food_id = order_food_id;
	}
	public String getTabid() {
		return tabid;
	}
	public void setTabid(String tabid) {
		this.tabid = tabid;
	}
	public WaitFoodBean getWfb() {
		return wfb;
	}
	public void setWfb(WaitFoodBean wfb) {
		this.wfb = wfb;
	}

	public String getFoodnum() {
		return foodnum;
	}

	public void setFoodnum(String foodnum) {
		this.foodnum = foodnum;
	}
	
	
}
