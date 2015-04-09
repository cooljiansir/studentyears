package com.studentyears.ProcessAction;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;


import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbManager;
import com.studentyears.Database.DbPool;
import com.studentyears.Database.HighLevelDbPro;
import com.studentyears.Model.Comment;
import com.studentyears.Utils.StringUtils;
import com.sun.crypto.provider.RSACipher;

public class ShowCommentAction extends ActionSupport{

	private String goodsorderid;
	private String result;

	public String getGoodsorderid() {
		return goodsorderid;
	}

	public void setGoodsorderid(String goodsorderid) {
		this.goodsorderid = goodsorderid;
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
		showComment();
		return SUCCESS;
	}
	  	return LOGIN;
	}
	
	public void showComment() throws SQLException
	{
		String sql = "select commentator, commentcontent, picturepath " +
				"from user as u left join comment as c on u.email = c.commentator " +
				"where goodsorderid = ? order by releasedate;";
		String arg = getGoodsorderid();
		String jsonString = HighLevelDbPro.dbReturnRsJson(sql, arg);
		this.result = jsonString;
		System.out.println("comment----"+jsonString);
		//System.out.println("goodorderid---"+getGoodsorderid());
	}
}
