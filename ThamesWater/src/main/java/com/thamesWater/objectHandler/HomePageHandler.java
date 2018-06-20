package com.thamesWater.objectHandler;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.genericUtility.DriverBase;
import com.thamesWater.pageObjects.HomePage;

public class HomePageHandler extends DriverBase{
	
	public static WebElement element=null;
	static WebDriverWait wait=new WebDriverWait(DriverBase.driver,60);
	static WebDriverWait loadWait=new WebDriverWait(DriverBase.driver,60);
	

	public static WebElement wait_StaticUI(){
		try {
		loadWait.until(ExpectedConditions.invisibilityOfElementLocated(HomePage.busyIconDialog()));
		loadWait.until(ExpectedConditions.invisibilityOfElementLocated(HomePage.busyIconArea()));
		element=loadWait.until(ExpectedConditions.presenceOfElementLocated(HomePage.wait_StaticUI()));
		Thread.sleep(2000);
		
		}catch(Exception E) {
			E.printStackTrace();
		}	
		return element;
	}
	
	public static WebElement lnk_MyLeaveRequest() {
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.lnk_MyLeaveRequest()));
		return element;
	}

}
