package com.studentyears.ProcessAction;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbManager;
import com.studentyears.Database.DbPool;
import com.studentyears.Database.HighLevelDbPro;
import com.studentyears.Model.Comment;
import com.studentyears.Utils.StringUtils;
import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.xpath.internal.Arg;

public class PlacequeryAction extends ActionSupport{

	private String location;
	private String college;
	private String result;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
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
		return SUCCESS;
	}
	  	return LOGIN;
	}
	
	public String collegequery() throws SQLException
	{
		String sql = "select name from univs;";
		String jsonString = HighLevelDbPro.dbReturnRsJson(sql, null);
		this.result = jsonString;
		System.out.println(jsonString);
		return SUCCESS;
		//System.out.println("goodorderid///"+getGoodsorderid());
	}
	
	public String campusquery() throws SQLException
	{
		String sql = "select name from campus where uid in (select id from univs where name = ?);";
		String arg = college;
		String jsonString = HighLevelDbPro.dbReturnRsJson(sql, arg);
		this.result = jsonString;
		System.out.println(jsonString);
		return SUCCESS;
		//System.out.println("goodorderid///"+getGoodsorderid());
	}
}
