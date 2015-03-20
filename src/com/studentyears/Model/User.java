package com.studentyears.Model;

import java.sql.Date;


public class User {
	
	private String email;
	private String password;
	private String studentId;
	private String tel;
	private String college;
	private String campus;
	private String province;
	private String iplocation;
	private String lastiplocation;
	private Date   registerdate;
	private int    goodscount;
	
	public String getemail() {
		return email;
	}
	public String getpassword() {
		return password;
	}
	public String getstudentId() {
		return studentId;
	}
	public String gettel() {
		return tel;
	}
	public String getcollege() {
		return college;
	}
	public String getcampus() {
		return campus;
	}
	public String getprovince() {
		return province;
	}
	public String getiplocation() {
		return iplocation;
	}
	public String getlastiplocation() {
		return lastiplocation;
	}
	public Date getregisterdate() {
		return registerdate;
	}
	public int getgoodscount() {
		return goodscount;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public void setstudentId(String studentId) {
		this.studentId = studentId;
	}
	public void settel(String tel) {
		this.tel = tel;
	}
	public void setcollege(String college) {
		this.college = college;
	}
	public void setcampus(String campus) {
		this.campus = campus;
	}
	public void setprovince(String province) {
		this.province = province;
	}
	public void setiplocation(String iplocation) {
		this.iplocation = iplocation;
	}
	public void setlastiplocation(String lastiplocation) {
		this.lastiplocation = lastiplocation;
	}
	public void setregisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public void setgoodscount(int goodscount) {
		this.goodscount = goodscount;
	}
	
	
}
