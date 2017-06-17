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
	
	/**查找排序后的菜品清单
	 * @author hcb
	 * 执行此方法时  1.更新 排序列表和出菜列表 
	 * 			 2.更新数据库菜品状态为正做
	 * 			3.更新徽章显示的数量
	 * 			4.更新已做菜单列表
	 */
	//@Action(value="sortwaitfood",results={@Result(name="pass",location= "admin/products/Kitchen.jsp")})
	public String findFood(){
		List<SortKitchenFoodBean> list = ks.showWaitFood("1");//查询状态为1的待做菜品
		super.setsession("list", list);
		List<SortKitchenFoodBean> doingFood = ks.showWaitFood("2");//查询状态为2的正做菜品
		super.setsession("doing", doingFood);		
		List<SortKitchenFoodBean> doneFood = ks.showWaitFood("3");//查询状态为3的已做菜品
		//System.out.println("doneFood:"+doneFood.size());
		super.setsession("done", doneFood);		
		String count = ks.findCount();
		super.setsession("count", count);
		return "pass";
	}
	
	/**update方法为更新数据库菜品状态信息
	 * @author hcb
	 * 
	 */
	public String update(){
		String orderfoodid = super.getparameter("orderfoodid");
		String status = super.getparameter("status");
		System.out.println("update:"+orderfoodid);
		ks.updateStatus(orderfoodid,status);
		findFood();
		return "pass";
	}
	
	/**查找正在做菜的菜品集合
	 * @author hcb
	 * 执行此方法时    1.只更新出菜列表
	 * 				2.更新数据库菜品状态为已做
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
