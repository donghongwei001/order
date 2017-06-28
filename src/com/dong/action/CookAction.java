package com.dong.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.ordersystem.domain.CookBean;
import com.ordersystem.domain.DisheBean;
import com.ordersystem.domain.FoodCategoryBean;
import com.ordersystem.service.CookService;
import com.ordersystem.service.DisheService;



public class CookAction extends BaseAction implements ModelDriven<CookBean>{
	CookService cs=new CookService();
	private CookBean cb;
	public CookBean getCb() {
		return cb;
	}
	public void setCb(CookBean cb) {
		this.cb = cb;
	}
	public CookBean getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	/**录入菜系的方法
	 * @author an
	 * 
	 */
	public String addCook(){		
		cs.addCook(cb);		//调用添加的方法
		findCook();
		return "succ";
	}
	/**
	 * 查询所有
	 */
	public String findCook(){
		List<CookBean> cook = cs.findCook();
		super.setsession("cookInfo", cook);
		return "cook";
	}
	

	
	/**跳转编辑的方法
	 * @author ah
	 * 
	 */
	public String editcook(){
		String dishes_id = super.getparameter("cookid");
		List<CookBean> oneCook =  cs.findone(dishes_id);
		if(oneCook!=null){
			CookBean cb = oneCook.get(0);
			super.setsession("coks", cb);
		}
		return "edit";
	}
	
	/**更新数据库数据的方法
	 * 
	 */
	public String modify(){
		String dishes_id = super.getparameter("cookid");
		String newname = super.getparameter("dishes_name");
		cs.modify(dishes_id,newname);
		findCook();
		return "cook";
	}
	
	/**
	 * 删除菜系的方法
	 * @return
	 */
	public String delcook(){
		String dishes_id = super.getparameter("cookid");
		cs.del_cook(dishes_id);
		findCook();
		return "cook";
	}
	
	public String yanzheng(){
		String cookname = super.getparameter("cookname");
		List<CookBean> oneCook =  cs.findonebyname(cookname);
		if(oneCook!=null&&oneCook.size()>0){
			System.out.println("oneCook"+oneCook.size());
			super.write("true");
		}
		return null;
	}
}
