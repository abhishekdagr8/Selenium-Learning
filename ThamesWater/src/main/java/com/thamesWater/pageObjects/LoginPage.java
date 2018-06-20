package com.thamesWater.pageObjects;

import org.openqa.selenium.By;

import com.ibm.genericUtility.DriverBase;

public class LoginPage extends DriverBase{
	
	static By locator=null;	
	
	public static By txt_UserName() {
		locator=By.id("USERNAME_FIELD-inner");
		return locator;
	}
	
	public static By txt_Password() {
		locator=By.id("PASSWORD_FIELD-inner");
		return locator;
	}
	
	public static By btn_LogOn() {
		locator=By.xpath("//span[text()='Log On']");
		return locator;
	}
	
	public static By lnk_DetailsCetificate() {
		locator=By.xpath("//span[text()='Details']");
		return locator;
	}
	public static By lnk_ContinueCetificate() {
		locator=By.xpath("//*[text()='Go on to the webpage']");
		return locator;
	}
	
	
	
	
	

}
