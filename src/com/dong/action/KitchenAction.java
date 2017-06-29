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
	PageUtil pu = new PageUtil();		//��ҳ������
	/**�㷨3:���������Ĳ�Ʒ�嵥
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
		
		//System.out.println("doneFood:"+doneFood.size());
		PageUtil paging = paging();		//��ҳ��װ��ѯ״̬Ϊ3��������Ʒ
		super.setsession("done", paging);		
		String count = ks.findCount("1");
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
		ks.updateStatusServingTime(orderfoodid,status);	//�������ݿ��Ʒ״̬�͸ò��ϲ�ʱ��
		ks.updateLastTime(orderId);		//�������ݿ�����ϲ�ʱ��
		findFood();
		return "pass";
	}
	
	/**��ҳ��װ����
	 * @author hcb
	 * 
	 */
	public PageUtil paging(){
		Integer currPage = null;
		Integer pageSize =null;
		try {
			currPage = Integer.parseInt(super.getparameter("currPage"));	//��ȡ��ǰҳ��
			pageSize = Integer.parseInt(super.getparameter("pageSize"));	//��ȡÿҳ��ʾ����
		} catch (Exception e) {
			//e.printStackTrace();
		}
		currPage =currPage==null?1:currPage;	//����Ĭ��ҳ��
		pageSize = pageSize==null?10:pageSize;	//����Ĭ��ÿҳ��ʾ����
		int startIndex=(currPage-1)*pageSize;	//����Ĭ��
		Integer count = Integer.parseInt(ks.findPageCountdone());//
		List<WaitFoodBean> doneFood = ks.showDoneFood(pageSize,startIndex);//��ѯ״̬Ϊ3��������Ʒ
		pu.setRows(doneFood);
		pu.setTotal(count);
		pu.setCurrPage(currPage);
		pu.setPage(pageSize);
		return pu;
	}
	
	/**ajax��ҳ����
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
		int startIndex = (page-1)*10;
		List<WaitFoodBean> doneFood = ks.showDoneFood(10,startIndex);//��ѯ״̬Ϊ3��������Ʒ
		for (int i = 0; i < doneFood.size(); i++) {
			String mark = doneFood.get(i).getOrder_food_mark()==null?"":doneFood.get(i).getOrder_food_mark();
			doneFood.get(i).setOrder_food_mark(mark);
		}
		String js = JSON.toJSONString(doneFood);
		super.write(js);
		return null;
	}
	
	   /**�㷨2:��ʱ���Ƚ��ȳ�  ���������Ĳ�Ʒ�嵥
		 * @author hcb
		 * ִ�д˷���ʱ  1.���� �����б�ͳ����б� 
		 * 			 2.�������ݿ��Ʒ״̬Ϊ����
		 * 			3.���»�����ʾ������
		 * 			4.���������˵��б�
		 */
		public String secFindFood(){
			List<SortKitchenFoodBean> list = ks.secShowWaitFood("1");//��ѯ״̬Ϊ1�Ĵ�����Ʒ
			super.setsession("list", list);
			List<SortKitchenFoodBean> doingFood = ks.secShowWaitFood("2");//��ѯ״̬Ϊ2��������Ʒ
			super.setsession("doing", doingFood);		
			PageUtil paging = paging();		//��ҳ��װ��ѯ״̬Ϊ3��������Ʒ
			super.setsession("done", paging);		
			String count = ks.findCount("1");
			super.setsession("count", count);
			return "secpass";
		}
		
		/**�㷨2:���˰�ť
		 * 	����:1.�������ݿ��Ʒ״̬��Ϣ
		 * 		2.����ҳ���Ʒ��ʾ ����findfood����
		 * @author hcb
		 * 
		 */
		public String secDoFood(){
			String orderfoodid = super.getparameter("orderfoodid");
			String status = super.getparameter("status");
			ks.updateStatus(orderfoodid,status);
			secFindFood();
			return "secpass";
		}
		
		/**�㷨2:�ϲ˰�ť
		 * 	����:1.�������ݿ��Ʒ״̬��Ϣ
		 * 		2.�������ݿ�����ϲ�ʱ��
		 * 		3.��¼�ò˵��ϲ�ʱ��
		 * 		3.����ҳ���Ʒ��ʾ  ����findfood����
		 * @author hcb
		 * 
		 */
		public String secServingFood(){
			String orderfoodid = super.getparameter("orderfoodid");
			String status = super.getparameter("status");
			String orderId = super.getparameter("orderId");
			ks.updateStatusServingTime(orderfoodid,status);	//�������ݿ��Ʒ״̬�͸ò��ϲ�ʱ��
			ks.updateLastTime(orderId);		//�������ݿ�����ϲ�ʱ��
			secFindFood();
			return "secpass";
		}
		
		/**�㷨3: ����������ȡ������   ���������Ĳ�Ʒ�嵥
		 * @author hcb
		 * ִ�д˷���ʱ  1.���� �����б�ͳ����б� 
		 * 			 2.�������ݿ��Ʒ״̬Ϊ����
		 * 			3.���»�����ʾ������
		 * 			4.���������˵��б�
		 */
		//@Action(value="sortwaitfood",results={@Result(name="pass",location= "admin/products/Kitchen.jsp")})
		public String thrFindFood(){
			List<SortKitchenFoodBean> list = ks.ThrShowWaitFood("1");//��ѯ״̬Ϊ1�Ĵ�����Ʒ
			super.setsession("list", list);
			List<SortKitchenFoodBean> doingFood = ks.ThrShowWaitFood("2");//��ѯ״̬Ϊ2��������Ʒ
			super.setsession("doing", doingFood);		
			
			PageUtil paging = paging();		//��ҳ��װ��ѯ״̬Ϊ3��������Ʒ
			super.setsession("done", paging);		
			String count = ks.findCount("1");
			super.setsession("count", count);
			return "thrpass";
		}
		
		/**�㷨3:���˰�ť
		 * 	����:1.�������ݿ��Ʒ״̬��Ϣ
		 * 		2.����ҳ���Ʒ��ʾ ����findfood����
		 * @author hcb
		 * 
		 */
		public String thrDoFood(){
			String orderfoodid = super.getparameter("orderfoodid");
			String status = super.getparameter("status");
			ks.updateStatus(orderfoodid,status);
			thrFindFood();
			return "thrpass";
		}
		
		/**�㷨3:�ϲ˰�ť
		 * 	����:1.�������ݿ��Ʒ״̬��Ϣ
		 * 		2.�������ݿ�����ϲ�ʱ��
		 * 		3.��¼�ò˵��ϲ�ʱ��
		 * 		3.����ҳ���Ʒ��ʾ  ����findfood����
		 * @author hcb
		 * 
		 */
		public String thrServingFood(){
			String orderfoodid = super.getparameter("orderfoodid");
			String status = super.getparameter("status");
			String orderId = super.getparameter("orderId");
			ks.updateStatusServingTime(orderfoodid,status);	//�������ݿ��Ʒ״̬�͸ò��ϲ�ʱ��
			ks.updateLastTime(orderId);		//�������ݿ�����ϲ�ʱ��
			thrFindFood();
			return "thrpass";
		}
		
		
}
