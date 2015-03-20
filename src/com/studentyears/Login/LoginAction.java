package com.studentyears.Login;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbManager;
import com.studentyears.Database.DbPool;


public class LoginAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	 
	public String getUsername() {
	  return username;
	}
	public void setUsername(String username) {
	  this.username = username;
	}
	public String getPassword() {
	  return password;
	}
	public void setPassword(String password) {
	  this.password = password;
	}

	@Override
	public String execute() throws Exception {
	//if("haha".equals(username) && "hehe".equals(password))
	if(loginConfirm(username, password)){
		ServletActionContext.getRequest().getSession().setAttribute("user", username);
		System.out.println("ok");
		return SUCCESS;
	}
	  return LOGIN;
	 }
	
	public boolean loginConfirm(String name, String password)
	{
		DbPool dbPool = new DbPool();
		String sqlString = "select * from user where email=\"?\" and password=\"?\";";
		sqlString = sqlString.replaceFirst("\\?", name);
		sqlString = sqlString.replaceFirst("\\?", password);
		System.out.println(sqlString);
		return dbPool.exist(sqlString);
	}
}
