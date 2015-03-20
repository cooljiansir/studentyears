package com.studentyears.Login;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbManager;


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
	if(loginConfirm(username)){
		ServletActionContext.getRequest().getSession().setAttribute("user", "leilei");
		return SUCCESS;
	}
	  return LOGIN;
	 }
	
	public boolean loginConfirm(String name)
	{
		DbManager dbManager = new DbManager();
		String sqlString = "select * from student where studentId = ?";
		sqlString = sqlString.replaceFirst("\\?", name);
		return dbManager.exist(sqlString);
	}
}
