package com.ryochi.taskmanager.entities;

//A class that stores values in DB 
public class MemberRegistration {
	
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
