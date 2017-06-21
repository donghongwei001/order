package com.daofactory;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class Connpool {
	public static BasicDataSource getDataSource() {
		return dataSource;
	}
	public static void setDataSource(BasicDataSource dataSource) {
		Connpool.dataSource = dataSource;
	}
	private static BasicDataSource dataSource=null;
	static{
<<<<<<< HEAD
		
		dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://172.16.22.78:1433; DatabaseName=order");
		dataSource.setUsername("sa");
		dataSource.setPassword("818716");
		
=======
		bds = new BasicDataSource();
		bds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		bds.setUrl("jdbc:sqlserver://172.16.22.78:1433; DatabaseName=order");
		bds.setUsername("sa");
		bds.setPassword("818716");
>>>>>>> 7cefe3b6e14880f74adc48f4cb7ccbcf4e7beddb
	}
	public Connection getConnection(){

		try {
			if (dataSource!=null) {
				return dataSource.getConnection();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void close(){
		try {
			dataSource.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
