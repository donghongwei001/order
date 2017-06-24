package com.ordersystem.dao;

import java.util.List;

import com.ordersystem.domain.FoodCategoryBean;

public interface FoodDao {
	/*@��Ӳ�Ʒ
	 * @author hcb
	 */
	public int addFood(FoodCategoryBean fo);
	
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
