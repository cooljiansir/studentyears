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

public class UsercenterAction extends ActionSupport{

	private String user;
	private String result;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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
		showpersonPicture();
		return SUCCESS;
	}
	  	return LOGIN;
	}
	
	public void showpersonPicture() throws SQLException
	{
		System.out.println(user);
		String sql = "select picturepath from user where email = ?;";
		String arg = getUser();
		String jsonString = HighLevelDbPro.dbReturnRsJson(sql, arg);
		this.result = jsonString;
		System.out.println("json-----"+jsonString);
		//System.out.println("goodorderid///"+getGoodsorderid());
	}
	
}
