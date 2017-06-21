package com.ordersystem.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFormat {
	public static SimpleDateFormat getDateformat(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf;
	}
	public static SimpleDateFormat getDateFormata(){
		SimpleDateFormat sddf = new SimpleDateFormat("yyyy-MM-dd");
		return sddf;
	}
	public static void main(String[] args) {
		System.out.println(getDateformat().format(new Date()));
		System.out.println(new Date());
		 try {
			getDateformat().parse("2017.12.12");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
