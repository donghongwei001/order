package com.ordersystem.domain;

/**@ WaitFoodBean的包装类  为排序提供权重和并菜的数量
 * @author hcb
 * 
 */
public class SortKitchenFoodBean {
	private WaitFoodBean wfb;
	private double weight;	//权重记录
	private int foodnum;	//记录合并菜品后该菜的数量
	
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
