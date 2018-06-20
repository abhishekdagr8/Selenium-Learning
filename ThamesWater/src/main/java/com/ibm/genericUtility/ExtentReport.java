package com.ibm.genericUtility;

import java.io.File;

import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	public static ExtentReports extent;
	public ExtentTest logger;
	 
	 public static void startReport(){
		 extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/Results"+GenericReusable.reportStartTime()+"/Report"+GenericReusable.currentTime()+".html", true);
		 extent
		                .addSystemInfo("Host Name", "Thames Water")
		                .addSystemInfo("Environment", "DEV")
		                .addSystemInfo("User Name", "Abhishek Singh");
		                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		 }
	 
	 public void getResult(ITestResult result){
		 if(result.getStatus() == ITestResult.SUCCESS){
			 this.logger.log(LogStatus.PASS, "Test Case Passed is "+result.getName());
		 }else if(result.getStatus() == ITestResult.FAILURE){
		 //logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			 try {
				 this.logger.log(LogStatus.FAIL, "Test Case Failed<br /> "+result.getThrowable(),"SnapShot Below: "+ logger.addScreenCapture(GenericReusable.getScreenShot(result.getName())));
		 }catch(Exception e) {
			System.out.println("Not able to take screenshot"); 
		 }
		 
		 }else if(result.getStatus() == ITestResult.SKIP){
			 this.logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }
		 extent.endTest(logger);
		 }
	 public static void endReport(){
		                extent.flush();
		                extent.close();
		    }
	 public void startTest(ITestResult result) {
		 this.logger = extent.startTest(result.getMethod().getMethodName());
		 
	 }
}
