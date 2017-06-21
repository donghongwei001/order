package com.ordersystem.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFormat {
	public static SimpleDateFormat getDateformat(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss");
		return sdf;
	}
	public static SimpleDateFormat getLastServingFormat(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf;
	}
	public static void main(String[] args) {
		System.out.println(getDateformat().format(new Date()));
	}
}
