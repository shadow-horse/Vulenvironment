package com.snowsec0.dao;

public class User {

	String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String password ;
	
	User(){}
	public User(String username,String passwd)
	{
		this.username = username;
		this.password = passwd;
	}
	
}
