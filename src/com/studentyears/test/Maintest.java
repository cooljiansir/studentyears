package com.studentyears.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Maintest {

	public static void main(String[] args) {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		  java.util.Date uDate=new java.util.Date();
		  System.out.println("uDate: "+uDate);
		 java.sql.Date sDate=new java.sql.Date(uDate.getTime());
		  System.out.println("sDate: "+sDate);
		  String strDate=df.format(sDate);
	}
}
