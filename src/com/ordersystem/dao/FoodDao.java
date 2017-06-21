package com.ordersystem.dao;

import java.util.List;

import com.ordersystem.domain.FoodBean;

public interface FoodDao {
	/*@��Ӳ�Ʒ
	 * @author hcb
	 */
	public int addFood(FoodBean fo);
	
	/*��ѯ���в�Ʒ�ķ���
	 * @author hcb
	 */
	public List QueryAllFood();
	
	/*@��id��ѯָ����Ʒ
	 * @author hcb
	 */
	public List QueryFoodById(int id);
	
	/*@�����ֲ�ѯָ����Ʒ
	 * @author hcb
	 */
	public List QueryFoodByName(String name);
	
}
