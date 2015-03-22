package com.studentyears.Model;

import java.sql.Timestamp;

public class GoodsOrder {
	
	private String goodsorderId;
	private String email;
	private String title;
	private String description;
	private String picturepackage;
	private int newofpercentage;
	private int price;
	private int sold;
	private String category;
	private Timestamp releasedate;
	
	public String getgoodsorderId() {
		return goodsorderId;
	}
	public void setgoodsorderId(String goodsorderId) {
		this.goodsorderId = goodsorderId;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public String getpicturepackage() {
		return picturepackage;
	}
	public void setpicturepackage(String picturepackage) {
		this.picturepackage = picturepackage;
	}
	public int getnewofpercentage() {
		return newofpercentage;
	}
	public void setnewofpercentage(int newofpercentage) {
		this.newofpercentage = newofpercentage;
	}
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
	public int getsold() {
		return sold;
	}
	public void setsold(int sold) {
		this.sold = sold;
	}
	public String getcategory() {
		return category;
	}
	public void setcategory(String category) {
		this.category = category;
	}
	public Timestamp getreleasedate() {
		return releasedate;
	}
	public void setreleasedate(Timestamp releasedate) {
		this.releasedate = releasedate;
	}
	
}
