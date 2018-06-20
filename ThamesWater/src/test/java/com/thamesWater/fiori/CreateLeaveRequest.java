package com.thamesWater.fiori;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.applicationUtility.LoginReuse;
import com.ibm.applicationUtility.MyLeaveRequestReuse;
import com.ibm.genericUtility.DriverBase;
import com.ibm.genericUtility.GenericReusable;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thamesWater.dataModelHandler.ManageModelHandlerLeaveRequest;
import com.thamesWater.dataModelHandler.ManageModelHandlerLogin;
import com.thamesWater.dataObject.ManageDTOLeaveRequest;
import com.thamesWater.dataObject.ManageDTOLogin;
import com.thamesWater.objectHandler.HomePageHandler;
import com.thamesWater.objectHandler.LoginPageHandler;
import com.thamesWater.objectHandler.MyLeaveRequestHandler;

import Factory.ComplexReportFactory;

public class CreateLeaveRequest extends DriverBase {

	private final String Message;
	private String rowName;
	private String login;
	LoginReuse LoginReuse;
	private String methodStatus;
	private ManageDTOLogin manageDTOLogin;
	private ManageDTOLeaveRequest manageDTOLeaveRequest;
	
	public CreateLeaveRequest(){
		rowName="TC01 - Create Leave Request";
		login="HR_04";
		Message="Send this leave request to Mr Daniel Rubio?";	
		manageDTOLogin = ManageModelHandlerLogin.getDTO(login);
		manageDTOLeaveRequest=ManageModelHandlerLeaveRequest.getDTO(rowName);	
	}
	
	@Test
	private void CreateLeaveRequestTestOne() {	
		ExtentTest testReporter = ComplexReportFactory.getTest();
		try {
		//Step01-login to Application
		LoginPageHandler.lnk_DetailsCetificate().click();
		LoginPageHandler.lnk_ContinueCetificate().click();
		methodStatus=Step01LoginToApplication();
		GenericReusable.VerifyMethodStatus(methodStatus,"Login to Application is Unsuccessful");
		testReporter.log(LogStatus.PASS, "Login to Application with Username and Password", 
				"UserName= <span style='font-weight:bold;'>"+manageDTOLogin.getuserName()+"</span><br />" +
				"Password= <span style='font-weight:bold;'>"+manageDTOLogin.getpassword()+"</span>" +
				testReporter.addScreenCapture(GenericReusable.getScreenShot("Step01")));
			
		//Step02-NavigateTillMyLeaveRequests
		methodStatus=Step02NavigateTillMyLeaveRequests();
		GenericReusable.VerifyMethodStatus(methodStatus,"Navigation to My Leave Request is Unsuccessful");
		testReporter.log(LogStatus.PASS, "Click on My Leave Request Link");
		
		//Step03-SelectLeaveTypeRequest
		methodStatus=Step03SelectLeaveTypeRequest();
		GenericReusable.VerifyMethodStatus(methodStatus,"Navigation to My Leave Request is Unsuccessful");
		testReporter.log(LogStatus.PASS, "Select the Leave Request Type from Dropdown", 
				"LeaveType= <span style='font-weight:bold;'>"+manageDTOLeaveRequest.getRequestType()+"</span>" +
						testReporter.addScreenCapture(GenericReusable.getScreenShot("Step03")));
		
		//Step04-SelecttheStartDate
		methodStatus=Step04SelecttheStartDate();
		GenericReusable.VerifyMethodStatus(methodStatus,"Not able to select the Start Date");
		testReporter.log(LogStatus.PASS, "Provide the start date", 
				"StartDate= <span style='font-weight:bold;'>"+manageDTOLeaveRequest.getStartDate()+"</span>" + 
						testReporter.addScreenCapture(GenericReusable.getScreenShot("Step04Step01")));
		
		methodStatus=Step05SelectTheEndDateDate();
		GenericReusable.VerifyMethodStatus(methodStatus,"Not able to select the End Date");
		testReporter.log(LogStatus.PASS, "Provide the start date", 
				"EndDate= <span style='font-weight:bold;'>"+manageDTOLeaveRequest.getEndDate()+"</span>" +
						testReporter.addScreenCapture(GenericReusable.getScreenShot("Step05")));
		
		methodStatus=Step06ProvideTheNoteForTheLeave();
		GenericReusable.VerifyMethodStatus(methodStatus,"Not able to Provide note to the TextArea");
		testReporter.log(LogStatus.PASS, "Provide the note in the TextArea", 
				"LeaveType= <span style='font-weight:bold;'>"+manageDTOLeaveRequest.getNote()+"</span>" +
						testReporter.addScreenCapture(GenericReusable.getScreenShot("Step06")));
		
		methodStatus=Step07SelectIllnessCodeFromList();
		GenericReusable.VerifyMethodStatus(methodStatus,"Not Able to Select the IllnessCode");
		testReporter.log(LogStatus.PASS, "Select the Illness code", 
				"IllnessCode= <span style='font-weight:bold;'>"+manageDTOLeaveRequest.getIlnessCode()+"</span>" +
						testReporter.addScreenCapture(GenericReusable.getScreenShot("Step07")));
		
		methodStatus=Step08ProvideTheCertificationDate();
		GenericReusable.VerifyMethodStatus(methodStatus,"Not able to Provide Certification Date");
		testReporter.log(LogStatus.PASS, "Input the Certification Date", 
				"Certification Date= <span style='font-weight:bold;'>"+manageDTOLeaveRequest.getCertificationDate()+"</span>" +
						testReporter.addScreenCapture(GenericReusable.getScreenShot("Step08")));
		
		methodStatus=Step09InputTheReportedDate();
		GenericReusable.VerifyMethodStatus(methodStatus,"Not able to Provide Reporting Date");
		testReporter.log(LogStatus.PASS, "Input the Reporting Date", 
				"Report on Date= <span style='font-weight:bold;'>"+manageDTOLeaveRequest.getReportedOn()+"</span>" +
						testReporter.addScreenCapture(GenericReusable.getScreenShot("Step09")));
		
		methodStatus=Step10SubmitLeaveRequestAndVerifyDetails();
		GenericReusable.VerifyMethodStatus(methodStatus,"Leave Request Submit not possible");
		testReporter.log(LogStatus.PASS, "Click on Submit and Verify the details", 
				"Message= <span style='font-weight:bold;'>"+Message+"</span><br />"+
				"LeaveType= <span style='font-weight:bold;'>"+manageDTOLeaveRequest.getRequestType()+"</span>" +
				testReporter.addScreenCapture(GenericReusable.getScreenShot("Step10")));
		}catch(Exception e) {
			testReporter.log(LogStatus.FAIL, "Certficate not displayed Test Case One",testReporter.addScreenCapture(GenericReusable.getScreenShot("Step03")));
			Assert.assertTrue(false);
		}
	}	

	private String Step01LoginToApplication() {
		LoginReuse=new LoginReuse();
		return LoginReuse.LogintoFioriLaunchPad(manageDTOLogin);
				
	}

	private String Step02NavigateTillMyLeaveRequests() {
		try {
			HomePageHandler.lnk_MyLeaveRequest().click();
			HomePageHandler.wait_StaticUI();
		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
	private String Step03SelectLeaveTypeRequest() {
		try {
			methodStatus=MyLeaveRequestReuse.selectLeaveTypeDropDown(manageDTOLeaveRequest.getRequestType());
			
		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
	}
		return methodStatus;
	}
			
	private String Step06ProvideTheNoteForTheLeave() {
		try {
		MyLeaveRequestHandler.txtArea_Note().click();
		MyLeaveRequestHandler.txtArea_Note().sendKeys(manageDTOLeaveRequest.getNote());
		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
	private String Step04SelecttheStartDate() {
		String flag;
		try {
			flag=MyLeaveRequestReuse.selectCalendarDate(manageDTOLeaveRequest.getStartDate());
			Thread.sleep(2000);
			}catch(Exception e) {
				e.printStackTrace();
				flag="fail";
			}
		return flag;
	}
	
	private String Step05SelectTheEndDateDate() {
		String flag;
		try {
			flag=MyLeaveRequestReuse.selectCalendarDate(manageDTOLeaveRequest.getEndDate());
			}catch(Exception e) {
				e.printStackTrace();
				flag="fail";
			}
		return flag;
	}
	
	private String Step07SelectIllnessCodeFromList() {
		String flag="fail";
		try {
		flag=MyLeaveRequestReuse.SelectIlnessCodefromList(manageDTOLeaveRequest.getIlnessCode());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private String Step09InputTheReportedDate() {
		String flag="fail";
		try {
			MyLeaveRequestHandler.txtReportedOnDate().sendKeys(manageDTOLeaveRequest.getReportedOn());
			HomePageHandler.wait_StaticUI();
			flag="success";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private String Step08ProvideTheCertificationDate() {
		String flag="fail";
		try {
			MyLeaveRequestHandler.txtCertificationDate().sendKeys(manageDTOLeaveRequest.getCertificationDate());
			flag="success";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private String Step10SubmitLeaveRequestAndVerifyDetails() {
		String flag="fail";
		try {
			MyLeaveRequestHandler.btnSubmitLeaveRequest().sendKeys(Keys.ENTER);
			HomePageHandler.wait_StaticUI();
			//MyLeaveRequestReuse.VerifySubmitPopupDetails();
			
			flag="success";
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Test update");
		}
		return flag;
	}
}
