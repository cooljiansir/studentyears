package com.studentyears.Login;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbPool;
import com.studentyears.IpSeeker.IPSeeker;
import com.studentyears.IpSeeker.Utils;
import com.studentyears.Model.User;
import com.studentyears.Utils.Constant;
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
/*		registToDatabase();
		ServletActionContext.getRequest().getSession().setAttribute("username", getEmail());
		System.out.println(getCollege());
		System.out.println(getRegistLocation());*/
		copyHeadImage(getEmail());
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
		String picturepath = Constant.UPLOAD_IMAGE_FOLDER + "/" + getEmail() + "/" + "image.jpg";
		user.setpicturepath(picturepath);
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
	
	public void copyHeadImage(String username)
	{
		int random = (int)(Math.random() * 6);
		String headImageRealpath = ServletActionContext.getServletContext().getRealPath(Constant.HEAD_IMAGE_FOLDER);
        String headImagesPath = headImageRealpath + "/"+"head"+random+".jpg";
        java.io.File src = new java.io.File(headImagesPath);
        System.out.println("src---"+src);
        String userPictureRealpath = ServletActionContext.getServletContext().getRealPath(Constant.UPLOAD_IMAGE_FOLDER);
        String userPicturepath = userPictureRealpath + "/" + getEmail() + "/" + "image.jpg";
        java.io.File des = new java.io.File(userPicturepath);
        System.out.println("des---"+des);
        try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
