package com.studentyears.Utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateUtils {

	public static Date getDate()
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		java.util.Date uDate=new java.util.Date();
		//System.out.println("uDate: "+uDate);
		java.sql.Date sDate=new java.sql.Date(uDate.getTime());
		//System.out.println("sDate: "+sDate);
		String strDate=df.format(sDate);
		return sDate;
	}
}
