package com.studentyears.Database;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Date;


public class DbManager
{
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/studentyears";
    private static String user = "root";
    private static String password = "";
    Connection ct;
    PreparedStatement ps;
    Statement sm = null;
    ResultSet rs;

    public DbManager()
    {
        try
        {
            Class.forName(driver);
        } catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try
        {
            ct = DriverManager.getConnection(url, user, password);
            sm = ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

    public void close()
    {
        try{
            if (rs != null){
                rs.close();
            }
            if (sm != null){
                sm.close();
            }
            if (ps != null){
                ps.close();
            }
            if (ct != null){
                ct.close();
            }
        } catch (SQLException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public ResultSet queryExecute(String sql){
        try{
            rs = sm.executeQuery(sql);
            rs.beforeFirst();
        } catch (Exception e){
            // TODO: handle exception
            e.printStackTrace();
        }
        return rs;
    }
    
    public boolean exist(String sql){
        try{
            rs = sm.executeQuery(sql);
            rs.beforeFirst();
            if (rs.next()) {
				return true;
			}
        } catch (Exception e){
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    public boolean updExecute(String sql){
        boolean b = true;
        try{
            int check = sm.executeUpdate(sql);
            if (check != 1){
                b = false;
            }
        } catch (Exception e1){
            // TODO: handle exception
            b = false;
            e1.printStackTrace();
        }
        return b;
    }

    public boolean upd(String sql){
        boolean temp = updExecute(sql);
        this.close();
        return temp;
    }
    
    /*
     * 表名和类名要求相同
     */
    public void insert(Object target) throws SecurityException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
    	Class testClass = target.getClass();
    	String table = testClass.getSimpleName().toLowerCase();
    	String blankString = ReflectMethod.blankString(ReflectMethod.getFieldLength(target));
    	
    	String insertSql = "insert into " + table + " values("+ blankString +");";
    	System.out.println(insertSql);
    	try
		{
			ps = ct.prepareStatement(insertSql);
			Field[] field = testClass.getDeclaredFields();
		    for (int i = 0; i < field.length; i++) {
		            Class<?> type = field[i].getType();
		            System.out.println(type.getName() + " " + field[i].getName() + ";");
		            String simpleClass = type.getSimpleName();
		            Method method = ps.getClass().getMethod("set" + simpleClass, int.class, Class.forName(type.getName()));
		            method.invoke(ps, i+1, (Object)ReflectMethod.getter(target, field[i].getName()));
		        }
			ps.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
