package com.thamesWater.objectHandler;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.genericUtility.DriverBase;
import com.thamesWater.pageObjects.MyLeaveRequests;

public class MyLeaveRequestHandler extends DriverBase {
	
	public static WebElement element=null;
	static WebDriverWait wait=new WebDriverWait(DriverBase.driver,60);
	

	public static WebElement drp_LeaveType() {
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(MyLeaveRequests.drp_LeaveType()));
		return element;
	}


	public static WebElement lst_LeaveTypeIterator(String requestType) {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.lst_LeaveTypeIterator(requestType)));
		return element;
	}
	
	public static WebElement txtArea_Note() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.txtArea_Note()));
		return element;
	}
	
	public static WebElement lblFirstYearMonth() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.lblFirstYearMonth()));
		return element;
	}


	public static WebElement lblLastYearMonth() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.lblLastYearMonth()));
		return element;
	}
	
	public static WebElement lblDateParentFirstYearMonth() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.lblDateParentFirstYearMonth()));
		return element;
	}
	
	public static WebElement lblDateParentLastYearMonth() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.lblDateParentLastYearMonth()));
		return element;
	}


	public static WebElement btnPrevouscalendarArrow() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.btnPrevouscalendarArrow()));
		return element;
	}


	public static WebElement btnForwardCalendarArrow() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.btnForwardcalendarArrow()));
		return element;
	}


	public static WebElement btnIllnessCode() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.btnIllnessCode()));
		return element;
	}


	public static WebElement selIllnessCode(String illness) {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.selIllnessCode(illness)));
		return element;
	}


	public static WebElement txtCertificationDate() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.txtCertificationDate()));
		return element;
	}


	public static WebElement txtReportedOnDate() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.txtReportedOnDate()));
		return element;
	}


	public static WebElement btnSubmitLeaveRequest() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.btnSubmitLeaveRequest()));
		return element;
	}

	public static WebElement lblPopUpConfirmationMessage() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.lblPopUpConfirmationMessage()));
		return element;
	}
	
	public static WebElement lblPopUpLeavetype() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.lblPopUpLeavetype()));
		return element;
	}
	
	public static WebElement btnCacnelPopUp() {
		element= wait.until(ExpectedConditions.presenceOfElementLocated(MyLeaveRequests.btnCacnelPopUp()));
		return element;
	}
}
