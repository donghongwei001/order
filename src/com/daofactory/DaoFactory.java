package com.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoFactory {
	/*��̬�����ִֻ��һ�� �����������ݿ�
	 * @author hcb
	 */
	static{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"0");
		}
	}
	
	/* ����ָ�������ݿ�  databasename Ϊ��Ҫ���ӵ����ݿ���
	 * @author hcb
	 */
	public static Connection getConnection(String databasename){
		Connection con = null;
		String URL="jdbc:sqlserver://localhost:1433; DatabaseName="+databasename;
		try {			
			con = DriverManager.getConnection(URL,"sa","818716");
		} catch (Exception e) {
			System.out.println(e.getMessage()+"1");
		}
		return con;
	}
	/*�ر����е�����
	 * @author hcb
	 */
	public static void closeAll(Connection cc,Statement ss,ResultSet rs){
		try {
			if(cc!=null){cc.close();cc=null;}
			if(ss!=null){ss.close();ss=null;}
			if(rs!=null){rs.close();rs=null;}
		} catch (Exception e) {
			System.out.println(e.getMessage()+"2");
		}
	}
	
	/*���ò������� 
	 * @author hcb
	 */
	public static void setParams(PreparedStatement p,Object[] params){
		try {
			for (int i = 0; i < params.length; i++) {
				p.setObject(i+1, params[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+"3");
		}
	}
	
	/*
	 * @author hcb
	 */
	public static int executeUpdate(String sql,Object[] params){
		int flag = -1;
		try {
			Connection con = getConnection("ordersystem");
			PreparedStatement ps = con.prepareStatement(sql);
			setParams(ps, params);
			System.out.println("555");
			flag = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage()+"4");
		}
		return flag;
	}
	
	
	/*
	 * @author hcb
	 */
	public static ArrayList<ArrayList> execQuery(String sql,Object[]params){
		Connection con = null;
		PreparedStatement p = null;
		ResultSet rs = null;
		con = getConnection("ordersystem");
		ArrayList<ArrayList> arr = new ArrayList<ArrayList>();
		try {
			p = con.prepareStatement(sql);
			setParams(p, params);
			rs = p.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				ArrayList<Object> arr2  = new ArrayList<Object>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					arr2.add(rs.getObject(i+1));
				}
				arr.add(arr2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally{
			closeAll(con, p, rs);
		} 
		return arr;
	}
}
