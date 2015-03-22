package com.studentyears.Database;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.naming.*;
import java.sql.*;
import javax.sql.*;

import com.mysql.jdbc.Connection;
import com.studentyears.Model.GoodsOrder;

public class DBtest {
	
	public static void test1() throws SecurityException, IllegalArgumentException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException
	{
		DbManager dbManager = new DbManager();
		GoodsOrder student = new GoodsOrder();
		System.out.println("ok");
		dbManager.insert(student);
		boolean a = dbManager.exist("select * from student;");
		System.out.println(a);
	}
	
	public static void test2() throws NamingException, SQLException
	{
	}
	
	public static void main(String[] args) throws SecurityException, IllegalArgumentException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException {

			test1();
	}
}