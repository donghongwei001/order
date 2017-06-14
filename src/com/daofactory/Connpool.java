package com.daofactory;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class Connpool {
	private static BasicDataSource bds = null;
	
	
	public static BasicDataSource getBds() {
		return bds;
	}

	public static void setBds(BasicDataSource bds) {
		Connpool.bds = bds;
	}

	static{
		bds = new BasicDataSource();
		bds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		bds.setUrl("jdbc:sqlserver://localhost:1433; DatabaseName=school");
		bds.setUsername("sa");
		bds.setPassword("818716");
	}
	
	/**get���������õ����ӳ��е�����
	 * @author hcb
	 * 
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = bds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**closeConn�ر����ӵķ���
	 * @author hcb
	 * 
	 */
	public static void closeConn(Connection conn){
		try {
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
