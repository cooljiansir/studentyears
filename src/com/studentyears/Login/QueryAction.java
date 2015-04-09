package com.studentyears.Login;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbManager;
import com.studentyears.Database.DbPool;
import com.studentyears.Utils.StringUtils;
import com.sun.crypto.provider.RSACipher;

public class QueryAction extends ActionSupport{

	private String goodsId;
	private String imagePath;
	private String college;
	private String campus;
	private String price;
	
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String execute() throws Exception {
	if(true){
		getGoodsInfo();
		return SUCCESS;
	}
	  	return LOGIN;
	}
	
	public void getGoodsInfo() throws SQLException
	{
		DbManager dbPool = new DbManager();
		ResultSet rs = dbPool.queryExecute("select goodsorderid, college, campus, price from goodsorder;");
		StringUtils.resultSetToJson(rs);
		System.out.println("fasfdasdf");
		dbPool.close();
	}
}
