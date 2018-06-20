package com.thamesWater.pageObjects;

import org.openqa.selenium.By;
import com.ibm.genericUtility.DriverBase;

public class HomePage extends DriverBase{
	
static By locator=null;	
	
	public static By wait_StaticUI() {
		//locator=By.id("sap-ui-static");
		locator=By.xpath("//div[@id='sapUshellFiori2LoadingDialog'][@class='sapUshellShellHidden']");
		return locator;
	}
	
	public static By lnk_MyLeaveRequest() {
		locator=By.xpath("//span[text()='My Leave Requests']");
		return locator;
	}

	public static By busyIconDialog() {
		locator=By.id("sapUshellFiori2LoadingDialog");
		return locator;
		
	}

	public static By busyIconArea() {
		locator=By.id("sapUshellFiori2LoadingArea");
		return locator;

	}

}
