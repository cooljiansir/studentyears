package com.studentyears.Model;

import java.sql.Timestamp;

public class Comment {
	
    private String goodsorderId;
    private String commentator;
    private String commentcontent;
    private Timestamp releasedate;
    
	public String getgoodsorderId() {
		return goodsorderId;
	}
	public void setgoodsorderId(String goodsorderId) {
		this.goodsorderId = goodsorderId;
	}
	public String getcommentator() {
		return commentator;
	}
	public void setcommentator(String commentator) {
		this.commentator = commentator;
	}
	public String getcommentcontent() {
		return commentcontent;
	}
	public void setcommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public Timestamp getreleasedate() {
		return releasedate;
	}
	public void setreleasedate(Timestamp releasedate) {
		this.releasedate = releasedate;
	}
    
}