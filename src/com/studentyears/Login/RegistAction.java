package com.studentyears.Login;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbPool;
import com.studentyears.IpSeeker.IPSeeker;
import com.studentyears.IpSeeker.Utils;
import com.studentyears.Model.User;
import com.studentyears.Utils.DateUtils;
import com.studentyears.Utils.NetworkUtils;
import com.studentyears.Utils.StringUtils;

public class RegistAction extends ActionSupport{

	private String email;
	private String password;
	private String college;
	private String campus;
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getCollege() {
		return college;
	}
	public String getCampus() {
		return campus;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	@Override
	public String execute() throws Exception {
	if(true){
		registToDatabase();
		System.out.println(getCollege());
		System.out.println(getRegistLocation());
		return SUCCESS;
	}
	  	return LOGIN;
	}
	
	public String getRegistLocation()
	{
		return NetworkUtils.getAddress();
	}
	
	public void registToDatabase()
	{
		String location = getRegistLocation();
		
		String [] templocation = StringUtils.splitStrings(location);
		String province = templocation[0];
		
		DbPool dbPool = new DbPool();
		
		User user = new User();
		
		user.setemail(getEmail());
		user.setpassword(getPassword());
		user.setstudentId("");
		user.settel("");
		user.setcollege(getCollege());
		user.setcampus(getCampus());
		user.setprovince(province);
		user.setiplocation(location);
		user.setlastiplocation(location);
		user.setregisterdate(DateUtils.getDate());
		user.setgoodscount(0);
		
		dbPool.insert(user);
		
		dbPool.close();
	}
}
