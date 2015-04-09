package com.studentyears.Utils;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StringUtils {

	public static String [] splitStrings(String arg)
	{
		String [] tempsStrings = arg.split(" ");
		if (tempsStrings.length < 2) {
			tempsStrings = new String[2];
			tempsStrings[0] = "本地地址";
			tempsStrings[1] = "二级";
		}
		return tempsStrings;
	}
	
	public static String getSuffix(String filename)
	{
		return filename.replaceAll("^.*\\.", "");
	}
	
	public static String genImageName(int index, String filename)
	{
		return "image"+index+"."+StringUtils.getSuffix(filename);
	}
	
	public static String resultSetToJson(ResultSet rs)
	{  
	   // json数组  
	   JSONArray array = new JSONArray();  
	   // 获取列数  
	   // 遍历ResultSet中的每条数据  
	    try {
	    	ResultSetMetaData metaData = rs.getMetaData();  
	    	int columnCount = metaData.getColumnCount();  
	    	System.out.println(columnCount);
			while (rs.next()) {  
			    JSONObject jsonObj = new JSONObject();  
			     System.out.println("---------------");
			    // 遍历每一列  
			    for (int i = 1; i <= columnCount; i++) {  
			        String columnName =metaData.getColumnLabel(i);  
			        String value = rs.getString(columnName);  
			        System.out.println(columnName);
			        System.out.println(value);
			        jsonObj.put(columnName, value);
			    }  
			    array.add(jsonObj);  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return array.toString();  
	}  
	
	public static String getFirstResultSetRecord(ResultSet rs)
	{  
	   // 获取列数  
	   // 遍历ResultSet中的每条数据  
	    try {
	    	ResultSetMetaData metaData = rs.getMetaData();  
	    	int columnCount = metaData.getColumnCount();  
	    	System.out.println(columnCount);
			if (rs.next()) {
			        String columnName =metaData.getColumnLabel(1);  
			        String value = rs.getString(columnName);  
			        System.out.println(columnName);
			        System.out.println(value);
			        return value;
			} else {
				return Constant.NULL_VALUE;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return Constant.NULL_VALUE;  
	}

	public static String generateOrderId(String user, String ordercount){
		int len = ordercount.length();
		String temp = "";
		for (int i = 0; i < 4-len; i++) {
			temp += "0";
		}
		temp += ordercount;
		return user+ordercount;
	}
	
	public static String returnSuccessJson(Boolean flag){
		if (flag == true) {
			return "{\"success\":\"true\"}";
		}
		else{
			return "{\"success\":\"false\"}";
		}
	}
	
	public static String timestampToDateString(Timestamp timestamp){
		//DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dFormat.format(timestamp);  
	}
	
	public static String timestampToDateString(String timestampsString){
		//DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		timestampsString = timestampsString.replaceAll(" .*$", "");
		return timestampsString;  
	}
	
	public static void main(String[] args) {
		System.out.println(timestampToDateString("2015-04-06 11:01:45.0"));
	}
	
}
