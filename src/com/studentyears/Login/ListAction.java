package com.studentyears.Login;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.swing.Box.Filler;

import org.apache.struts2.ServletActionContext;

import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.studentyears.Database.DbManager;
import com.studentyears.IpSeeker.IPLocation;
import com.studentyears.IpSeeker.IPSeeker;
import com.studentyears.Model.Student;
import com.studentyears.Model.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	public ArrayList<User> userArrayList = null;

	public void fill() throws SecurityException, IllegalArgumentException, NoSuchMethodException, ClassNotFoundException, 
		IllegalAccessException, InvocationTargetException, FileNotFoundException, NamingException, SQLException{
		userArrayList = new ArrayList<User>();
		userArrayList.add(new User("images/b1.jpg"));
		userArrayList.add(new User("images/b1.jpg"));
		userArrayList.add(new User(getIpAddr(ServletActionContext.getRequest())));
		//userArrayList.add(new User(dbOpt()));
		//userArrayList.add(new User("afdf"));
	}
	
	public String dbOpt() throws NamingException, SQLException
	{
		Context initContext = new InitialContext();
		DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/studentyears");
		Connection conn = (Connection) ds.getConnection();
		conn.close();
		return "ok";
	}
	
	public String getAddress()
	{
		String ipString = getIpAddr(ServletActionContext.getRequest());
		String ipresource = ServletActionContext.getServletContext().getRealPath("/ipresource");
		IPSeeker ipSeeker = null;
		try {
			ipSeeker = new IPSeeker(ipresource+"/QQWry.Dat");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipSeeker.getAddress(ipString);
	}
	
	public String getIpAddr(HttpServletRequest request) {
	     String ip = request.getHeader("x-forwarded-for");
	     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("Proxy-Client-IP");
	     }
	     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("WL-Proxy-Client-IP");
	     }
	     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("X-Real-IP");
	     }
	     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getRemoteAddr();
	     }
	     return ip;
		}
	
	@Override
	public String execute() throws Exception {
	//if("haha".equals(username) && "hehe".equals(password))
	if(true){
		fill();
		return SUCCESS;
	}
	  	return LOGIN;
	}
}
