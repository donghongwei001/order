package com.dong.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Context;
import com.ordersystem.domain.SortKitchenFoodBean;
import com.ordersystem.domain.WaitFoodBean;
import com.ordersystem.entity.PageUtil;
import com.ordersystem.service.KitchenService;

//@ParentPackage("struts-default")
//@Result(name="error",location="error.jsp")
public class KitchenAction extends BaseAction{
	KitchenService ks = new KitchenService(); 
	HttpServletRequest request=ServletActionContext.getRequest();
	PageUtil pu = new PageUtil();		//分页辅助类
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
		
		//System.out.println("doneFood:"+doneFood.size());
		PageUtil paging = paging();		//分页封装查询状态为3的已做菜品
		super.setsession("done", paging);		
		String count = ks.findCount("1");
		super.setsession("count", count);
		return "pass";
	}
	
	/**做菜按钮
	 * 	功能:1.更新数据库菜品状态信息
	 * 		2.更新页面菜品显示 调用findfood方法
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
	
	/**上菜按钮
	 * 	功能:1.更新数据库菜品状态信息
	 * 		2.更新数据库最后上菜时间
	 * 		3.记录该菜的上菜时间
	 * 		3.更新页面菜品显示  调用findfood方法
	 * @author hcb
	 * 
	 */
	public String servingFood(){
		String orderfoodid = super.getparameter("orderfoodid");
		String status = super.getparameter("status");
		String orderId = super.getparameter("orderId");
		ks.updateStatusServingTime(orderfoodid,status);	//更新数据库菜品状态和该菜上菜时间
		ks.updateLastTime(orderId);		//更新数据库最后上菜时间
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
	
	/**分页封装函数
	 * @author hcb
	 * 
	 */
	public PageUtil paging(){
		Integer currPage = null;
		Integer pageSize =null;
		try {
			currPage = Integer.parseInt(super.getparameter("currPage"));	//获取当前页码
			pageSize = Integer.parseInt(super.getparameter("pageSize"));	//获取每页显示条数
		} catch (Exception e) {
			//e.printStackTrace();
		}
		currPage =currPage==null?1:currPage;	//设置默认页数
		pageSize = pageSize==null?3:pageSize;	//设置默认每页显示条数
		int startIndex=(currPage-1)*pageSize;	//设置默认
		Integer count = Integer.parseInt(ks.findCount("3"));
		List<WaitFoodBean> doneFood = ks.showDoneFood(pageSize,startIndex);//查询状态为3的已做菜品
		pu.setRows(doneFood);
		pu.setTotal(count);
		pu.setCurrPage(currPage);
		pu.setPage(pageSize);
		return pu;
	}
	
	/**ajax分页方法
	 * @author hcb
	 * 
	 */
	public String slitPage(){
		String pageNo = super.getparameter("pageNo");
		Integer page = null;
		try {
			page = Integer.parseInt(pageNo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		page = page==null?1:page;
		int startIndex = (page-1)*3;
		List<WaitFoodBean> doneFood = ks.showDoneFood(3,startIndex);//查询状态为3的已做菜品
		for (int i = 0; i < doneFood.size(); i++) {
			String mark = doneFood.get(i).getOrder_food_mark()==null?"":doneFood.get(i).getOrder_food_mark();
			doneFood.get(i).setOrder_food_mark(mark);
		}
		String js = JSON.toJSONString(doneFood);
		super.write(js);
		return null;
	}
}
