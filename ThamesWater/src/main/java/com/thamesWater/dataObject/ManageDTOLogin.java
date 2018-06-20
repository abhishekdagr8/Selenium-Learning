package com.thamesWater.dataObject;

public class ManageDTOLogin implements ManageDTO{
	private String userName;
	private String password;
	
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}

}
