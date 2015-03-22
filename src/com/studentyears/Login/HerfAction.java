package com.studentyears.Login;

import com.opensymphony.xwork2.ActionSupport;

public class HerfAction extends ActionSupport{
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception {
	if(true){
		System.out.println(this.getId());
		return SUCCESS;
	}
	  	return LOGIN;
	}
}
