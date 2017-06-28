package com.dong.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.daofactory.DaoFactory;
import com.opensymphony.xwork2.ModelDriven;
import com.ordersystem.domain.DisheBean;
import com.ordersystem.domain.ServiceOrderListBean;
import com.ordersystem.domain.ServiceTable;
import com.ordersystem.service.DisheService;
import com.ordersystem.service.ServicePageService;

public class ServicePageAction extends BaseAction implements ModelDriven<ServiceTable> {
	ServicePageService sps = new ServicePageService();
	HttpServletRequest request=ServletActionContext.getRequest();
	public ServiceTable getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**��ѯ��ʾ����״̬
	 * @author hcb
	 * serv_*
	 */
	public String showTable(){
		List<ServiceTable> tbList = sps.showTable();
		Integer occupy = sps.countCategory(9);	//��ѯ����ʹ�õĲ�������
		Integer rest = sps.countCategory(8);		//��ѯû��ʹ�õĲ�������
		Integer call = sps.countCategory(13);		//��ѯ���з���Ա�Ĳ������� ״̬ 13
		Integer dirty = sps.countCategory(10);		//��ѯ��Ҫ��ɨ�Ĳ�������
		Integer total = sps.countOrderStatus(11);		//��ѯ����δ����Ķ�������
		Integer payed = sps.countOrderStatus(12);	//��ѯ�����Ѹ���Ķ�������
		total = total==null?0:total;
		payed = payed==null?0:payed;
		super.setsession("tbList", tbList);
		super.setsession("occupy",occupy+call);
		super.setsession("rest", rest);
		super.setsession("dirty", dirty);
		super.setsession("total", total);
		super.setsession("payed", payed);

		return "succ";
	}
	
	/**�ڷ���Աҳ����ʾ������������ 
	 * @author hcb
	 * http://localhost:8080/Ordersystem/admin/products/serv_orderDetails.action?table_id=1
	 * ��ִ�еĶ���:1.��ѯ��ʾ�����������ѵ�Ĳ�Ʒ
	 * 				2.��ҳ��ʾ���в�Ʒ �������Ա�Ӳ�
	 * 
	 */
	public String orderDetails(){
		String table_id = super.getparameter("table_id");
		List<ServiceOrderListBean> solb = sps.showOrderDetails(table_id);		//��ѯ���������е�ǰ������������
		List<DisheBean> menuList = sps.showmenuList();							//��ѯ���������е�ǰ������������
		DisheService ds = new DisheService();
		
		Map<String , String> ma = new HashMap<String, String>();				//ģ����ѯ����Աҳ��Ĳ�Ʒ�б�
		String food_name = super.getparameter("food_name");						//��ȡ�û�����Ĳ�Ʒ����
		if (food_name!=null&&!food_name.equals("")) {
			ma.put("food_name", food_name);
		}
		Integer pageSize = 12;
		Integer pageStart = 0;
		List dishList = ds.queryDishe(ma, null, pageSize+"", pageStart+"");					//���ò�Ʒ��ķ�����ѯ����ҳlist�ļ���
		menuList = (List<DisheBean>) dishList.get(0);
		Integer total = (Integer) dishList.get(1);
		Integer pageCount = total/pageSize;
		if (total%pageSize>0) {
			pageCount++;
		}
		super.setsession("table_id", table_id);
		super.setsession("menuList", menuList);
		super.setsession("userseach", food_name);
		super.setsession("solb", solb);
		super.setsession("pageCount", pageCount);
		return "details";
	}
	
	/**����Աҳ����ʾ�˵��б����ڲ����Ӳ�        //ajax��ҳ���� 
	 * @author hcb
	 * ��ִ�еĶ���:1.��ҳ��ʾ���в�Ʒ �������Ա�Ӳ�
	 * 
	 */
	public String ajaxDetails(){
		String food_name = super.getparameter("food_name");
		Map<String, String> ma = new HashMap<String, String>();
		if (food_name!=null&&!food_name.equals("")) {
			ma.put("food_name", food_name);
		}
		String pageNo = super.getparameter("pageNo");
		Integer currentPage = null;
		try {
			currentPage = Integer.parseInt(pageNo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		currentPage = currentPage==null?1:currentPage;
		DisheService ds = new DisheService();
		Integer pageSize = 12;
		Integer pageStart = (currentPage-1)*pageSize;
		List dishList = ds.queryDishe(ma, null, pageSize+"", pageStart+"");					//���ò�Ʒ��ķ�����ѯ����ҳlist�ļ���
		List<DisheBean> menuList = sps.showmenuList();							//��ѯ���������е�ǰ������������
		menuList = (List<DisheBean>) dishList.get(0);
		String str = JSON.toJSONString(menuList);
		super.write(str);
		
		return null;
	}
	
	/**ɾ��ǰ̨ȡ���Ĳ�Ʒ
	 * @author hcb
	 * 
	 */
	public String delOrderfood(){
		String foodid = super.getparameter("foodid");
		int i = sps.delOrderfood(foodid);
		if (i>0) {
			super.write("true");
		}else super.write("false");
		//ServletActionContext.getRequest().getRequestDispatcher(path);
		return null;
	}
	
	/**�߲˹���ʵ�ֵķ���
	 * @author hcb
	 * 
	 */
	public String reminder(){
		String tableid = super.getparameter("tableid");
		int i = sps.reminder(tableid);
		if (i>0) {
			super.write("true");
		}else super.write("false");
		return null;
	}
	
	/**����������Ӳ�Ʒ�ķ���
	 * @author hcb
	 * 
	 */
	public String addOrderfood(){
		String foodid = super.getparameter("foodid");
		String tableid = super.getparameter("tableid");
		Integer i = sps.addOrderfood(foodid,tableid);
		if (i>0) {
			super.write("true");
		}else super.write("false");
		orderDetails();
		return null;
	}
	
	/**�ú�������Ϊ����ǰ�ȼ��ò����Ƿ���δ����Ĳ�
	 * @author hcb
	 * 
	 */
	public String checkfood(){
		String tbid = super.getparameter("tableid");
		String count = super.getparameter("count");
		int i = sps.checkfood(tbid);
		if (i!=0) {
			super.write("false");
		}else{
			Integer status = sps.paymoney(tbid,count);
			if (status>0) {
				super.write("true");
			}else super.write("false");
		}
		return null;
	}
	
	/**ǿ�Ƹ���ķ���
	 * @author hcb
	 * 
	 */
	/*public String paymoney(){
		String tbid = super.getparameter("tableid");
		Integer status = sps.paymoney(tbid);
		if (status>0) {
			super.write("ture");
		}else super.write("false");
		return null;
	}*/

	/**��ɨ���� �ı�����״̬�ķ���
	 * ���� �ı�����״̬
	 * @author hcb
	 * 
	 */
	public String clearTable(){
		String tableid = super.getparameter("tableid");
		Integer i = sps.updateTable(tableid);
		if(i>0){
			super.write("true");
		}else super.write("false");
		return null;
	}
	
	/**ǰ̨����Ա��̨�ķ���
	 * @author hcb
	 * 
	 */
	public String starteat(){
		String tableid = super.getparameter("tableid");
		String empid = "1003";
		Integer i = sps.starteat(tableid,empid);
		if(i>0){
			super.write("true");
		}else super.write("false");
		return null;
	}
	
	/**ȡ�����з���Ա�ķ���
	 * @author hcb
	 * 
	 */
	public String cancelcall(){
		String tableid = super.getparameter("tableid");
		Integer i = sps.cancelcall(tableid);
		if(i>0){
			super.write("true");
		}else super.write("false");
		return null;
	}
	
}



