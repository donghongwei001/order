package com.ordersystem.domain;

/**@ WaitFoodBean�İ�װ��  Ϊ�����ṩȨ�غͲ��˵�����
 * @author hcb
 * 
 */
public class SortKitchenFoodBean {
	private WaitFoodBean wfb;
	private double weight;	//Ȩ�ؼ�¼
	private int foodnum;	//��¼�ϲ���Ʒ��ò˵�����
	
	public WaitFoodBean getWfb() {
		return wfb;
	}
	public void setWfb(WaitFoodBean wfb) {
		this.wfb = wfb;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight2) {
		this.weight = weight2;
	}
	public int getFoodnum() {
		return foodnum;
	}
	public void setFoodnum(int foodnum) {
		this.foodnum = foodnum;
	}
	
}
