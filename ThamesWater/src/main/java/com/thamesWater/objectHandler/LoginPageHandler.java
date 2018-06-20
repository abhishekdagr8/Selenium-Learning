package com.thamesWater.objectHandler;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.genericUtility.DriverBase;
import com.thamesWater.pageObjects.LoginPage;

public class LoginPageHandler extends DriverBase{
	
	public static WebElement element=null;
	static WebDriverWait wait=new WebDriverWait(DriverBase.driver,60);
	

	public static WebElement txt_UserName() {
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.txt_UserName()));
		return element;
	}
	
	public static WebElement txt_Password() {
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.txt_Password()));
		return element;
	}
	
	public static WebElement btn_LogOn() {
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.btn_LogOn()));
		return element;
	}
	
	public static WebElement lnk_DetailsCetificate() {
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.lnk_DetailsCetificate()));
		return element;
	}
	
	public static WebElement lnk_ContinueCetificate() {
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.lnk_ContinueCetificate()));
		return element;
	}
	

}
