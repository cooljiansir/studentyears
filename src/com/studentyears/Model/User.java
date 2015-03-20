package com.studentyears.Model;

public class User {
	
	private String nameString;
	
	public User(String name){
		nameString = name;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
}
