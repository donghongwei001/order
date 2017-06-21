package com.dong.action;

import java.io.File;

import com.opensymphony.xwork2.ModelDriven;
import com.ordersystem.domain.DisheBean;

public class DisheAction extends BaseAction implements ModelDriven<DisheBean> {
	private DisheBean db;
	private File food_pic;
	private String food_picFileName;
	public File getFood_pic() {
		return food_pic;
	}

	public void setFood_pic(File food_pic) {
		this.food_pic = food_pic;
	}

	public String getFood_picFileName() {
		return food_picFileName;
	}

	public void setFood_picFileName(String food_picFileName) {
		this.food_picFileName = food_picFileName;
	}

	public DisheBean getDb() {
		return db;
	}

	public void setDb(DisheBean db) {
		this.db = db;
	}
	
	/**录入菜品的方法
	 * @author hcb
	 * 
	 */
	public String addDishe(){
		super
		System.out.println(db+"****"+food_picFileName);
		return "succ";
	}

	public DisheBean getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
