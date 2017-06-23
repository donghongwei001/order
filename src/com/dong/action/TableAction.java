package com.dong.action;

import java.io.IOException;
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
		HttpServletRequest request = ServletActionContext.getRequest();
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
		
		
}
