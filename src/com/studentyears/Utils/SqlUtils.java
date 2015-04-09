package com.studentyears.Utils;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SqlUtils {

	public static String search_contion(String sqlbase, String symble, String contion, String arg)
	{
		//arg = "\""+arg+"\"";
		if (!sqlbase.contains(contion+" "+symble)) {
			if (sqlbase.matches("where\\s$")) {
				sqlbase += " and "; 
			}
			sqlbase += " "+contion+" "+symble+" " + arg;
		}
		else {
			System.out.println("test aaaa");
			System.out.println(sqlbase);
			sqlbase = sqlbase.replaceFirst(contion+" "+symble+" \\S+", contion+" "+symble+" " + arg);
			System.out.println(sqlbase);
		}
		return sqlbase;
	}
	
	public static String search_contion_equal(String sqlbase, String contion, String arg)
	{
		return search_contion(sqlbase, "=", contion, arg);
	}
	
	public static String search_contion_like(String sqlbase, String contion, String arg)
	{
		return search_contion(sqlbase, "like", contion, arg);
	}
	
	public static String search_category(String sqlbase, String arg)
	{
		return search_contion_equal(sqlbase, "category", arg);
	}
	
	public static String search_all(String sqlbase, String arg)
	{
		return search_contion_like(sqlbase, "title", arg);
	}
	
	public static String search_orderby(String sqlbase, String arg)
	{
		if (!sqlbase.contains("order by")) {
			sqlbase += " order by " + arg;
		}
		else {
			sqlbase = sqlbase.replaceFirst("order by\\s+\\S+", "order by " + arg);
		}
		return sqlbase;
	}
	public static String sql_appendtail(String sqlbase)
	{
		return sqlbase+=";";
	}
	
	public static void main(String[] args) {
		System.out.println(search_category("order by sadfasf category = aa ", "bb"));
		System.out.println(search_all("order by sadfasf title like aa ", "cc"));
		System.out.println(search_contion_equal("order by sadfasf", "cate", "bb"));
	}
}
