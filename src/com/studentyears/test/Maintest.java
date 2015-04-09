package com.studentyears.test;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.studentyears.Database.DbManager;
import com.studentyears.Database.DbPool;
import com.studentyears.Utils.Constant;
import com.studentyears.Utils.ImageFolderUtils;
import com.studentyears.Utils.StringUtils;

public class Maintest {

	public static void main(String[] args) {
		/*SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		  java.util.Date uDate=new java.util.Date();
		  System.out.println("uDate: "+uDate);
		 java.sql.Date sDate=new java.sql.Date(uDate.getTime());
		  System.out.println("sDate: "+sDate);
		  String strDate=df.format(sDate);
		  System.out.println(new Timestamp(System.currentTimeMillis()));
		  System.out.println(StringUtils.getSuffix("fasdfs.txt"));
		  System.out.println(ImageFolderUtils.genOrderImageFolderBase("a", "b"));
		  */
		  DbManager dbPool = new DbManager();
		  ResultSet rs = dbPool.queryExecute("select goodsorderid, college, campus, price from goodsorder;");
		  System.out.println(StringUtils.resultSetToJson(rs));
			//System.out.println("fasfdasdf");
		  dbPool.close();
	}
}
