package com.studentyears.Database;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.studentyears.Utils.Constant;
import com.studentyears.Utils.StringUtils;


public class DbPool{
	
	String confiString = "java:/comp/env/jdbc/studentyears";
	Context initContext = null;
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement ps;
    Statement sm = null;
    ResultSet rs;
	
	public DbPool(){
		try {
			initContext = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ds = (DataSource)initContext.lookup(confiString);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = (Connection) ds.getConnection();
			sm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
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
            if (conn != null){
            	conn.close();
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
    
    public String querySingleValue(String sql){
        try{
            rs = sm.executeQuery(sql);
            rs.beforeFirst();
            String value = StringUtils.getFirstResultSetRecord(rs);
            return value;
        } catch (Exception e){
            // TODO: handle exception
            e.printStackTrace();
        }
		return Constant.ERROR;
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
    public void insert(Object target) {
    	Class testClass = target.getClass();
    	String table = testClass.getSimpleName().toLowerCase();
    	String blankString = ReflectMethod.blankString(ReflectMethod.getFieldLength(target));
    	
    	String insertSql = "insert into " + table + " values("+ blankString +");";
    	System.out.println(insertSql);
    	try
		{
			ps = conn.prepareStatement(insertSql);
			Field[] field = testClass.getDeclaredFields();
		    for (int i = 0; i < field.length; i++) {
		            Class<?> type = field[i].getType();
		            System.out.println(type.getName() + " " + field[i].getName() + ";");
		            String simpleClass = type.getSimpleName();
		            Method method = null;
					try {
						if (type.getName() == "int") {
							method = ps.getClass().getMethod("setInt", int.class, int.class);
						}
						else {
							method = ps.getClass().getMethod("set" + simpleClass, int.class, Class.forName(type.getName()));
						}
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						method.invoke(ps, i+1, (Object)ReflectMethod.getter(target, field[i].getName()));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			ps.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
