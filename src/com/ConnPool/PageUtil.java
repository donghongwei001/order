package com.ConnPool;

import java.util.List;

public class PageUtil {//��ҳ
	private int total;//������
	private List rows;//ÿ�δ����ݿ��ȡ��������
	private String pageStr;//��װ  ��ҳ ���� ����
	private  int allPage;//ʹ�������������������ҳ��
	private  int  page;//��ǰ������
	private  int currPage;//��ǰҳ��
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public String getPageStr() {
		if (getCurrPage()<1)setCurrPage(0);
		if(getCurrPage()>getAllPage())setCurrPage(getAllPage());
		int flag1=0;
		int flag2=0;
		flag1=getCurrPage()-1;
		flag2=getCurrPage()+1;
		if (flag1==0) {
			flag1=1;
		}
		if (flag2>getAllPage()) {
			flag2=getAllPage();
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<a  href='/Ordersystem/Ordersystem/wei_query1.action?currPage=1&pageSize="+getPage()+"'>��ҳ</a>");
		sb.append("<a  href='/Ordersystem/Ordersystem/wei_query1.action?currPage="+flag1+"&pageSize="+getPage()+"'>��һҳ</a>");	
		sb.append("<a  href='/Ordersystem/Ordersystem/wei_query1.action?currPage="+flag2+"&pageSize="+getPage()+"'>��һҳ</a>");
		sb.append("<a  href='/Ordersystem/Ordersystem/wei_query1.action?currPage="+getAllPage()+"&pageSize="+getPage()+"'>βҳ</a>");
		return sb.toString(); 	
		
	}
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}
	public int getAllPage() {
		allPage=getTotal()/getPage();
		if(getTotal()%getPage()>0){
			allPage++;
		}
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
}
