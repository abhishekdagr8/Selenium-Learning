package com.ibm.applicationUtility;

import org.openqa.selenium.WebElement;

import com.thamesWater.dataObject.ManageDTOLogin;
import com.thamesWater.objectHandler.HomePageHandler;
import com.thamesWater.objectHandler.LoginPageHandler;

public class LoginReuse {
	

	public  String LogintoFioriLaunchPad(ManageDTOLogin manageDTOLogin) {
		String flag="fail";
		try {
			LoginPageHandler.txt_UserName().sendKeys(manageDTOLogin.getuserName());
			LoginPageHandler.txt_Password().sendKeys(manageDTOLogin.getpassword());	
			LoginPageHandler.btn_LogOn().click();
			WebElement loadComplete=HomePageHandler.wait_StaticUI();
			if(loadComplete!=null) {
				flag="success";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
