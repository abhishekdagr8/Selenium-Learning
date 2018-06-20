package com.ibm.genericUtility;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Factory.ComplexReportFactory;


public class DriverBase{
	
	static String projectPath = System.getProperty("user.dir");
	static String driverPath = projectPath+"\\src\\test\\resources\\drivers\\";
	public static WebDriver driver;

	@Parameters({"browser","appURL"})
	@BeforeMethod
	public void beforeMethod(Method caller, String browser, String appURL) {
		ComplexReportFactory.getTest(caller.getName());
		
		String flag;
		switch(browser){
		case "edge" :
			System.out.println("launching Microsoft Edge browser");
			flag=launchEdgeBrowser();
			break;
	   
		case "firefox" :
			flag=launchFirefoxBrowser();
			break; 
			
		case "chrome" :
			System.out.println("launching Chrome browser");
			flag=launchChromeBrowser();
			break; 
	   
		default :
			flag=launchEdgeBrowser();
			break;
		}
		
		if(flag.equalsIgnoreCase("success")) {
			System.out.println("Lanuch Browser: "+browser+" Successful");
			launchApplicationURL(appURL);
		}
		else {
			//log the error message using logger
			Assert.assertEquals(true, false);
		}
		
		
		
		
	}

	@AfterMethod
	public void afterMethod(Method caller) {
		ComplexReportFactory.closeTest(caller.getName());

	}

	/*
	 * After suite will be responsible to close the report properly at the end
	 * You an have another afterSuite as well in the derived class and this one
	 * will be called in the end making it the last method to be called in test exe
	 */
	@AfterSuite
	public void afterSuite() {
		ComplexReportFactory.closeReport();
	}
	
	private String launchEdgeBrowser() {
		String returnFlag;
		try {
			System.setProperty("webdriver.edge.driver", driverPath+"MicrosoftWebDriver.exe");	
			driver = new EdgeDriver();	
			returnFlag="success";
		}catch(Exception e) {
			returnFlag=e.getMessage();
			System.out.println("Error Opening Edge Browser");
		}
		return returnFlag;
	}

	public void launchApplicationURL(String appURL) {
		try {
			driver.navigate().to(appURL);
		}catch(Exception e) {
			System.out.println("Error");
		}
		
	}
	private String launchChromeBrowser() {
		String returnFlag;
		System.setProperty("webdriver.chrome.driver", driverPath+ "chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
        ChromeOptions options = new ChromeOptions();	
        options.addArguments("test-type");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments((System.getProperty("user.dir")+"\\src\\main\\resources\\User Data\\Default"));
        capabilities.setCapability("chrome.binary","./src//lib//chromedriver");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver();
        returnFlag="success";
		return returnFlag;
	}

	private String launchFirefoxBrowser() {
		String returnFlag;
		System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
		driver = new FirefoxDriver();
		returnFlag="success";
		return returnFlag;
		
	}


	
//@AfterTest	
	public void closeDriver() {
		if(driver!=null) {
			driver.close();
		}
	}

}
