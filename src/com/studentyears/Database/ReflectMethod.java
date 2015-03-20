package com.studentyears.Database;
import java.lang.reflect.*;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
public class ReflectMethod
{
	
	public String gettestString()
	{
		return testString;
	}

	public int gettestInt()
	{
		return testInt;
	}

	public String gettestString1()
	{
		return testString1;
	}

	public void settestString(String testString)
	{
		this.testString = testString;
	}

	public void settestInt(int testInt)
	{
		this.testInt = testInt;
	}

	public void settestString1(String testString1)
	{
		this.testString1 = testString1;
	}

	public String testString;
	public int testInt;
	public String testString1;
	
    public static Object getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            return method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "get_error";
    }
    
    public static void setter(Object obj, String att, Object value, Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int getFieldLength(Object obj)
    {
    	Class testClass = obj.getClass();
    	Field [] fields = testClass.getDeclaredFields();
    	return fields.length;
    }
    
    public static String blankString(int count)
	{
    	StringBuffer sBuffer = new StringBuffer("?");
    	for (int i = 0; i < count-1; i++)
		{
			sBuffer.insert(0, "?, ");
		}
		return sBuffer.toString();
	}
    
	public static void main(String[] args)
	{
		ReflectMethod classField = new ReflectMethod();
		classField.testString = "234123";
		Class testClass = classField.getClass();
		Field[] field = testClass.getDeclaredFields();
	    for (int i = 0; i < field.length; i++) {
	            Class<?> type = field[i].getType();
	            System.out.println(type.getName() + " "
	                    + field[i].getName() + ";");
	        }
		System.out.println(getFieldLength(classField));
		System.out.println(blankString(5));
        setter(classField, "testString", "asdffa", String.class);
        getter(classField,"testString");
        String AALOAD ="sdfa.afs.string".replaceAll("^.*\\.", "");
        System.out.println(AALOAD);
	}
}
