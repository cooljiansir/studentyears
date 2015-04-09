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

public class CommentAction extends ActionSupport{

	private String goodsorderid;
	private String commentator;
	private String commentcontent;
	private String result;

	public String getGoodsorderid() {
		return goodsorderid;
	}

	public void setGoodsorderid(String goodsorderid) {
		this.goodsorderid = goodsorderid;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public String getCommentator() {
		return commentator;
	}

	public void setCommentator(String commentator) {
		this.commentator = commentator;
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
		comment();
		return SUCCESS;
	}
	  	return LOGIN;
	}
	
	public void comment() throws SQLException
	{
		Comment comment = new Comment();
		comment.setgoodsorderId(getGoodsorderid());
		comment.setcommentator(getCommentator());
		comment.setcommentcontent(getCommentcontent());
		comment.setreleasedate(new Timestamp(System.currentTimeMillis()));
		HighLevelDbPro.dbInsertObj(comment);
		
		String sql = "select commentator, commentcontent, picturepath " +
		"from user as u left join comment as c on u.email = c.commentator " +
		"where goodsorderid = ? order by releasedate;";
		String arg = getGoodsorderid();
		String jsonString = HighLevelDbPro.dbReturnRsJson(sql, arg);
		this.result = jsonString;
		System.out.println(jsonString);
		//System.out.println("goodorderid///"+getGoodsorderid());
	}
}
