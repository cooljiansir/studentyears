package com.studentyears.Database;

import java.sql.ResultSet;

import com.opensymphony.xwork2.Result;
import com.studentyears.Utils.StringUtils;

public class HighLevelDbPro {
	
	public static String returnCompleteSql(String sql, String ... arg)
	{
		if (arg == null) {
			return sql;
		}
		sql = sql.replaceAll("\\?", "\"\\?\"");
		for (int i = 0; i < arg.length; i++) {
			sql = sql.replaceFirst("\\?", arg[i]);
		}
		return sql;
	}
	
	public static void dbInsertObj(Object target){
		DbPool dbPool = new DbPool();
		dbPool.insert(target);
		dbPool.close();
	}

	public static void dbUpdate(String sql, String ... arg){
		DbPool dbPool = new DbPool();
		sql = returnCompleteSql(sql, arg);
		dbPool.updExecute(sql);
		dbPool.close();
	}
	
	public static boolean exist(String sql, String ... arg){
		DbPool dbPool = new DbPool();
		sql = returnCompleteSql(sql, arg);
		boolean returnbool = dbPool.exist(sql);
		dbPool.close();
		return returnbool;
	}
	
	public static String dbReturnRsJson(String sql, String ... arg){
		DbManager dbPool = new DbManager();
		sql = returnCompleteSql(sql, arg);
		System.out.println(sql);
		ResultSet rSet = dbPool.queryExecute(sql);
		String jsonString = StringUtils.resultSetToJson(rSet);
		dbPool.close();
		return jsonString;
	}
	
	public static String dbReturnSingleValue(String sql, String ... arg){
		DbPool dbPool = new DbPool();
		sql = returnCompleteSql(sql, arg);
		String rSet = dbPool.querySingleValue(sql);
		dbPool.close();
		return rSet;
	}
	
	public static void main(String[] args) {
		String sql = "select name from campus where uid in (select id from univs where name = ?);";
		String arg = "中国科学院大学";
		String jsonString = HighLevelDbPro.dbReturnRsJson(sql, arg);
		System.out.println(jsonString);
	}
}
