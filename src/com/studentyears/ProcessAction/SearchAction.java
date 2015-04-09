package com.studentyears.ProcessAction;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbManager;
import com.studentyears.Database.DbPool;
import com.studentyears.Database.HighLevelDbPro;
import com.studentyears.Utils.SqlUtils;
import com.studentyears.Utils.StringUtils;
import com.sun.crypto.provider.RSACipher;

public class SearchAction extends ActionSupport{

	private String goodsId;
	private String imagePath;
	private String college;
	private String campus;
	private String price;
	private String search;
	private String result;
	
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

	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String execute() throws Exception {
	if(true){
		search();
		System.out.println(getSearch());
		return SUCCESS;
	}
	  	return LOGIN;
	}
	
	public void search() throws SQLException
	{
		String sql = "select goodsorderid, title, picturepackage, college, campus, price " +
				"from goodsorder where ";
		sql = SqlUtils.search_contion_like(sql, "title", "?");
		sql = SqlUtils.sql_appendtail(sql);
		String arg = "%"+getSearch()+"%";
		String jsonString = HighLevelDbPro.dbReturnRsJson(sql, arg);
		System.out.println(jsonString);
		this.result = jsonString;
	}
}
