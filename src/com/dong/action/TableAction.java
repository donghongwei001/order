package com.dong.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.daofactory.DaoFactory;
import com.opensymphony.xwork2.ModelDriven;
import com.ordersystem.domain.EmpBeam;
import com.ordersystem.domain.TableBean;
import com.ordersystem.domain.Table_indent;
import com.ordersystem.domain.ser_tabBean;
import com.ordersystem.service.TableService;



public class TableAction extends BaseAction {
	/*	HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		TableService ts=new TableService();
		public String selezhuo() {
			String table_id = super.getparameter("zhuohao");
			List<TableBean> li=ts.selezhuohao(table_id);
			super.setsession("list", li);
			System.out.println("11111");
			return "ss";
		}
		
		public String seleAll() { 
			List<TableBean> li=ts.seleA();
			super.setsession("list", li);
			
			try {
				request.getRequestDispatcher("/admin/products/table_list.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "ss";
		}
		*//**
		 * ��json�õ�����ķ���Ա��
		 *//*
		public String sewaiter() {
			List<Table_indent> li=ts.selwaiter();
			String str = com.alibaba.fastjson.JSON.toJSONString(li);
			super.write(str);
			return null;*/
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	TableService ts=new TableService();
	/**
	 * ��������˵����  �������Ų�ѯ������Ϣ
	 */
	public String selezhuo() {
		String table_id = super.getparameter("zhuohao");
		List<TableBean> li=ts.selezhuohao(table_id);
		super.setsession("list", li);
		System.out.println("11111");
		return "ss";
	}

	public String seleAll() { 
		List<TableBean> li=ts.seleA();
		super.setsession("list", li);
		try {
			request.getRequestDispatcher("/admin/products/table_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ss";
	}
	/**
	 * ��json�õ�����ķ���Ա��
	 */
	public String sewaiter() {
		List<Table_indent> li=ts.selwaiter();
		String str = com.alibaba.fastjson.JSON.toJSONString(li);
		super.write(str);
		return null;
	}

	/**
	 * 
	 * ��������˵���� �������� 
	 */
	public String addzhuozi() {
		int table_state=8;
		TableBean tb=new TableBean();
		ser_tabBean st=new ser_tabBean();
		String pnum = super.getparameter("pnum");      //��ÿɹ�������
		String emp_fk_pos_id=super.getparameter("emp_fk_pos_id"); //���ѡ�к����Ա�� ID
		String table_name=super.getparameter("table_name"); //���������ӵ�name
		try {
			tb.setTable_Capacity(Integer.parseInt(pnum));
			tb.setTable_state(String.valueOf(table_state));
			tb.setTable_name(table_name);
			st.setFk_emp_id(Integer.parseInt(emp_fk_pos_id));
		} catch (Exception e) {
			// TODO: handle exception
		}
		ts.addtable(tb,st);
		seleAll();			//���ز���ҳ�沢���²�ѯ
		return "ss";
	}

	public EmpBeam getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * ��������˵���� ������Ϣ�༭ʱ�������ID
	 * @throws UnsupportedEncodingException 
	 */
	public String seid() throws UnsupportedEncodingException {
		String id=super.getparameter("tabled");
		List<TableBean> onetb = ts.findonetab(id);
		System.out.println(onetb.get(0).getFk_emp_id());
		super.setsession("tab", onetb.get(0));
		return "up";
	}

	/** 
	 * ��������˵����  �޸�������Ϣ
	 *people:��ȡ�޸ĺ�Ŀɹ�������
	 *t_name:�޸ĺ����������
	 *emp_fk_pos_id:�޸ĺ�ķ���ԱID
	 *tb_id:��ȡ����ID 
	 */
	public String updatezhuozi(){
		System.out.println(request.getRequestURI());
		TableBean tb=new TableBean();
		ser_tabBean st=new ser_tabBean();
		String tb_id=super.getparameter("id");
		String people=super.getparameter("people");
		String t_name=super.getparameter("t_name");
		String emp_fk_pos_id=super.getparameter("emp_fk_pos_id");
		try {
			tb.setTable_Capacity(Integer.parseInt(people));
			tb.setTable_name(t_name);
			st.setFk_emp_id(Integer.parseInt(emp_fk_pos_id));
		} catch (Exception e) {
			// TODO: handle exception
		}
		ts.updatee(tb,st,tb_id);
		seleAll();
		return "ss";
	}
	
	/** 
	 * ��������˵����  ɾ������
	 * id:Ҫɾ�������ӵ�id
	 */
	public String del(){
		System.out.println(request.getRequestURI());
		String id=super.getparameter("tab");
		TableBean tb=new TableBean();
		ser_tabBean st=new ser_tabBean();
		ts.seleid(tb, st, id);
		seleAll();
		return "ss";
	}
	
	/** 
	 * ��������˵����  �༭������Ϣʧ����ѯ���������Ƿ����
	 * 
	 */
	public String sltbname() {
		String tbname=super.getparameter("tbname");
		int flag=ts.seidcar(tbname);
		if (flag>0) {
			super.write("false");
		}else super.write("true");
		return null;
	}
	
}
