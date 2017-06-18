package com.dong.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.inject.Context;
import com.ordersystem.domain.SortKitchenFoodBean;
import com.ordersystem.domain.WaitFoodBean;
import com.ordersystem.service.KitchenService;

//@ParentPackage("struts-default")
//@Result(name="error",location="error.jsp")
public class KitchenAction extends BaseAction{
	KitchenService ks = new KitchenService(); 
	HttpServletRequest request=ServletActionContext.getRequest();
	
	/**���������Ĳ�Ʒ�嵥
	 * @author hcb
	 * ִ�д˷���ʱ  1.���� �����б�ͳ����б� 
	 * 			 2.�������ݿ��Ʒ״̬Ϊ����
	 * 			3.���»�����ʾ������
	 * 			4.���������˵��б�
	 */
	//@Action(value="sortwaitfood",results={@Result(name="pass",location= "admin/products/Kitchen.jsp")})
	public String findFood(){
		List<SortKitchenFoodBean> list = ks.showWaitFood("1");//��ѯ״̬Ϊ1�Ĵ�����Ʒ
		super.setsession("list", list);
		List<SortKitchenFoodBean> doingFood = ks.showWaitFood("2");//��ѯ״̬Ϊ2��������Ʒ
		super.setsession("doing", doingFood);		
		List<WaitFoodBean> doneFood = ks.showDoneFood();//��ѯ״̬Ϊ3��������Ʒ
		//System.out.println("doneFood:"+doneFood.size());
		super.setsession("done", doneFood);		
		String count = ks.findCount();
		super.setsession("count", count);
		return "pass";
	}
	
	/**���˰�ť
	 * 	����:1.�������ݿ��Ʒ״̬��Ϣ
	 * 		2.����ҳ���Ʒ��ʾ ����findfood����
	 * @author hcb
	 * 
	 */
	public String doFood(){
		String orderfoodid = super.getparameter("orderfoodid");
		String status = super.getparameter("status");
		System.out.println("update:"+orderfoodid);
		ks.updateStatus(orderfoodid,status);
		findFood();
		return "pass";
	}
	
	/**�ϲ˰�ť
	 * 	����:1.�������ݿ��Ʒ״̬��Ϣ
	 * 		2.�������ݿ�����ϲ�ʱ��
	 * 		3.��¼�ò˵��ϲ�ʱ��
	 * 		3.����ҳ���Ʒ��ʾ  ����findfood����
	 * @author hcb
	 * 
	 */
	public String servingFood(){
		String orderfoodid = super.getparameter("orderfoodid");
		String status = super.getparameter("status");
		String orderId = super.getparameter("orderId");
		System.out.println("update:"+orderfoodid);
		ks.updateStatusServingTime(orderfoodid,status);	//�������ݿ��Ʒ״̬�͸ò��ϲ�ʱ��
		ks.updateLastTime(orderId);		//�������ݿ�����ϲ�ʱ��
		findFood();
		return "pass";
	}
	
	/**�����������˵Ĳ�Ʒ����
	 * @author hcb
	 * ִ�д˷���ʱ    1.ֻ���³����б�
	 * 				2.�������ݿ��Ʒ״̬Ϊ����
	 */
	//@Action(value="doingfood",results={@Result(name="find",location="Kitchen.jsp")})
	public String findDoFood(){
		/*List<WaitFoodBean> doingFood = ks.showWaitFood(null);
		request.setAttribute("doing2", doingFood);
		for (int i = 0; i < doingFood.size(); i++) {
			System.out.println(doingFood.get(i));
		}*/
		return "find";
	}
	
	
}
