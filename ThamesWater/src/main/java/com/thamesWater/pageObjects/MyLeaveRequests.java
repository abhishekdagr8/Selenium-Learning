package com.thamesWater.pageObjects;

import org.openqa.selenium.By;
import com.ibm.genericUtility.DriverBase;

public class MyLeaveRequests extends DriverBase{
	
static By locator=null;	
	
	public static By drp_LeaveType() {
		locator=By.xpath("//span[contains(@id,'LEAVETYPE-arrow')]");
		return locator;
	}

	public static By lst_LeaveTypeIterator(String requestType) {
		locator=By.xpath("//ul[@class='sapMSelectList sapMSltList-CTX']/li[text()='"+requestType+"']");
		return locator;
	}
	
	public static By txtArea_Note() {
		locator=By.xpath("//textarea[@class='sapMInputBaseInner sapMTextAreaInner']");
		return locator;
	}
	
	public static By lblFirstYearMonth() {
		locator=By.xpath("//div[@class='s4Calendar sapMeCalendar sapMeCalendarApproval']/div[1]/div[1]");
		return locator;
	}

	public static By lblLastYearMonth() {
		locator=By.xpath("//div[@class='s4Calendar sapMeCalendar sapMeCalendarApproval']/div[2]/div[1]");
		return locator;
	}
	
	public static By lblDateParentFirstYearMonth() {
		locator=By.xpath("//*[@class='sapMeCalendarMonth sapMeCalendarMonthNotSingle'][1]/div[3]");
		return locator;
	}
	
	public static By lblDateParentLastYearMonth() {
		locator=By.xpath("//*[@class='sapMeCalendarMonth sapMeCalendarMonthNotSingle'][2]/div[3]");
		return locator;
	}

	public static By btnPrevouscalendarArrow() {
		locator=By.className("sapMeCalendarPrevious sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer");
		return locator;
		
	}

	public static By btnForwardcalendarArrow() {
		locator=By.className("sapMeCalendarNext sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer");
		return locator;
	}

	public static By btnIllnessCode() {
		locator=By.className("sapMInputValHelpInner sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer");
		return locator;
	}

	public static By selIllnessCode(String illness) {
		locator=By.xpath("//li//*[text()='"+illness+"']/ancestor::li");
		return locator;
	}

	public static By txtCertificationDate() {
		locator=By.xpath("//input[contains(@id,'CERTIFICATION_DATE-Picker-inner')]");
		return locator;
	}

	public static By txtReportedOnDate() {
		locator=By.xpath("//input[contains(@id,'REPORTED_ON-Picker-inner')]");
		return locator;
	}

	public static By btnSubmitLeaveRequest() {
		locator=By.xpath("//span[text()='Send']/ancestor::button[1]");
		return locator;
	}
	
	public static By lblPopUpConfirmationMessage() {
		locator=By.xpath("//span[@class='sapMText sapMTextMaxWidth sapUiSelectable'][contains(@id,'VIEW_CONFIRM')]");
		return locator;
	}
	
	public static By lblPopUpLeavetype() {
		locator=By.xpath("//label[text()='Category']/../preceding-sibling::div[1]/span");
		return locator;
	}
	
	public static By btnCacnelPopUp() {
		locator=By.xpath("//span[text()='Cancel'][contains(@id,'VIEW_CONFIRM--BTN_CANCEL')]/ancestor::button[1]");
		return locator;
	}
}
