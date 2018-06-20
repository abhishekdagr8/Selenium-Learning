package com.ibm.applicationUtility;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.thamesWater.objectHandler.HomePageHandler;
import com.thamesWater.objectHandler.MyLeaveRequestHandler;

public class MyLeaveRequestReuse{

	public static String flag = "fail";
	public static String selectLeaveTypeDropDown(String requestType) {
		try {
		MyLeaveRequestHandler.drp_LeaveType().click();
		HomePageHandler.wait_StaticUI();
		MyLeaveRequestHandler.lst_LeaveTypeIterator(requestType).sendKeys(Keys.ENTER);
		HomePageHandler.wait_StaticUI();
		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	
	//Modified by Abhishek
	public static String selectCalendarDate(String startDate) throws ParseException {
		String flag="fail";
		String[] res = startDate.split("\\-");
		String date=res[0];
		String month=res[1];
		String year=res[2];
		String monthYear=month+" "+year;
		
		
		
		String appFirstMonthYear=MyLeaveRequestHandler.lblFirstYearMonth().getText();
		String appLastMonthYear =MyLeaveRequestHandler.lblLastYearMonth().getText();
		
//		String monthFromAppFirstMonthYear=appFirstMonthYear.split(" ")[0];
//		String monthFromAppLastMonthYear=appLastMonthYear.split(" ")[0];
		
		String yearFromAppFirstMonthYear=appFirstMonthYear.split(" ")[1];
		String yearFromAppLastMonthYear=appLastMonthYear.split(" ")[1];

		if(monthYear.trim().equalsIgnoreCase(appFirstMonthYear.trim())) {
			flag=selectDateFromFirstDiv(date);
			if(flag.equalsIgnoreCase("success")) {
				return "success";
			}
			else {
				return "fail";
			}
			
		}else if(monthYear.trim().equalsIgnoreCase(appLastMonthYear.trim())) {
			flag=selectDateFromSecondDiv(date);
			if(flag.equalsIgnoreCase("success")) {
				return "success";
			}
			else {
				return "fail";
			}
		}
		else {
			if(Integer.parseInt(yearFromAppFirstMonthYear)==Integer.parseInt(year) ||
					Integer.parseInt(yearFromAppLastMonthYear)==Integer.parseInt(year)) {
				
				flag=selectMonthFromApplication(month);
				if(flag.equalsIgnoreCase("calendar1")||flag.equalsIgnoreCase("calendar2")) {
					flag=selectDateFromApplication(flag,date);
					return flag;
					}
			}
			if(Integer.parseInt(yearFromAppFirstMonthYear)<Integer.parseInt(year) && 
					Integer.parseInt(yearFromAppLastMonthYear)<Integer.parseInt(year)){
				int count=0;
				do {	
					MyLeaveRequestHandler.btnPrevouscalendarArrow().click();
					count=count+1;
					
					appFirstMonthYear=MyLeaveRequestHandler.lblFirstYearMonth().getText();
					appLastMonthYear =MyLeaveRequestHandler.lblLastYearMonth().getText();
					
					
					yearFromAppLastMonthYear=appLastMonthYear.split(" ")[1];
					yearFromAppFirstMonthYear=appFirstMonthYear.split(" ")[1];
					
					
					
					if(Integer.parseInt(yearFromAppFirstMonthYear)==Integer.parseInt(year) ||
							Integer.parseInt(yearFromAppLastMonthYear)==Integer.parseInt(year)) {
						
						//Verify Month function
						flag=selectMonthFromApplication(month);
						if(flag.equalsIgnoreCase("calendar1")||flag.equalsIgnoreCase("calendar2")) {
							flag=selectDateFromApplication(flag,date);
							break;
							}
						}
					}while(count<50);
			}else if(Integer.parseInt(yearFromAppFirstMonthYear)>Integer.parseInt(year) && 
					Integer.parseInt(yearFromAppLastMonthYear)>Integer.parseInt(year)) {
				int count=0;
				do {	
					MyLeaveRequestHandler.btnForwardCalendarArrow().click();
					count=count+1;
					
					appFirstMonthYear=MyLeaveRequestHandler.lblFirstYearMonth().getText();
					appLastMonthYear =MyLeaveRequestHandler.lblLastYearMonth().getText();
					
					
					yearFromAppLastMonthYear=appLastMonthYear.split(" ")[1];
					yearFromAppFirstMonthYear=appFirstMonthYear.split(" ")[1];
					
					if(Integer.parseInt(yearFromAppFirstMonthYear)==Integer.parseInt(year) ||
							Integer.parseInt(yearFromAppLastMonthYear)==Integer.parseInt(year)) {
						flag=selectMonthFromApplication(month);
						if(flag.equalsIgnoreCase("calendar1")||flag.equalsIgnoreCase("calendar2")) {
							flag=selectDateFromApplication(flag,date);
							break;
							}
					}
				}while(count<50);
			}			
		}
		return "flag";
	}

	private static String selectDateFromApplication(String flag2, String date) {
		String flag="fail";
		if(flag2.equalsIgnoreCase("Calendar1")) {
			flag=selectDateFromFirstDiv(date);
			}else if(flag2.equalsIgnoreCase("Calendar2")) {
				flag=selectDateFromSecondDiv(date);
				}
		return flag;
	}

	private static String selectMonthFromApplication(String month) throws ParseException {
		String flag="fail";
		String appFirstMonthYear=MyLeaveRequestHandler.lblFirstYearMonth().getText();
		String appLastMonthYear =MyLeaveRequestHandler.lblLastYearMonth().getText();
		
		String monthFromAppFirstMonthYear=appFirstMonthYear.split(" ")[0];
		String monthFromAppLastMonthYear=appLastMonthYear.split(" ")[0];
		
		int getNumberofFirstMonthFromApplication=MonthNumberFirstDiv(monthFromAppFirstMonthYear);
		int getNumberofLastMonthFromApplication=MonthNumberFirstDiv(monthFromAppLastMonthYear);
		int getNumberofMonthFromData=MonthNumberFirstDiv(month);
		
		if(getNumberofFirstMonthFromApplication==getNumberofMonthFromData) {
			flag= "calendar1";
		}else if(getNumberofLastMonthFromApplication==getNumberofMonthFromData) {
			flag ="calendar2";
		}else {
			if(getNumberofFirstMonthFromApplication<getNumberofMonthFromData && 
					getNumberofLastMonthFromApplication<getNumberofMonthFromData) {
				int count=0;
				do {
					MyLeaveRequestHandler.btnForwardCalendarArrow().click();
					count=count+1;
					
					appFirstMonthYear=MyLeaveRequestHandler.lblFirstYearMonth().getText();
					appLastMonthYear =MyLeaveRequestHandler.lblLastYearMonth().getText();
					
					monthFromAppFirstMonthYear=appFirstMonthYear.split(" ")[0];
					monthFromAppLastMonthYear=appLastMonthYear.split(" ")[0];
					
					getNumberofFirstMonthFromApplication=MonthNumberFirstDiv(monthFromAppFirstMonthYear);
					getNumberofLastMonthFromApplication=MonthNumberFirstDiv(monthFromAppLastMonthYear);
					if(getNumberofFirstMonthFromApplication==getNumberofMonthFromData) {
						flag= "calendar1";
						break;
					}else if(getNumberofLastMonthFromApplication==getNumberofMonthFromData) {
						flag= "calendar2";
						break;
					}
				}while(count<50);	
			}else if(getNumberofFirstMonthFromApplication>getNumberofMonthFromData && 
					getNumberofLastMonthFromApplication>getNumberofMonthFromData){
				int count=0;
				do {	
					MyLeaveRequestHandler.btnPrevouscalendarArrow().click();
					count=count+1;
					
					appFirstMonthYear=MyLeaveRequestHandler.lblFirstYearMonth().getText();
					appLastMonthYear =MyLeaveRequestHandler.lblLastYearMonth().getText();
					
					monthFromAppFirstMonthYear=appFirstMonthYear.split(" ")[0];
					monthFromAppLastMonthYear=appLastMonthYear.split(" ")[0];
					
					getNumberofFirstMonthFromApplication=MonthNumberFirstDiv(monthFromAppFirstMonthYear);
					getNumberofLastMonthFromApplication=MonthNumberFirstDiv(monthFromAppLastMonthYear);
					if(getNumberofFirstMonthFromApplication==getNumberofMonthFromData) {
						flag= "calendar1";
						break;
					}else if(getNumberofLastMonthFromApplication==getNumberofMonthFromData) {
						flag= "calendar2";
						break;
					}
				}while(count<50);	
			}
			
			
		}
		return flag;
		
	}

	private static int MonthNumberFirstDiv(String month3Chars) throws ParseException {
		Date parseApplicationDate = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(month3Chars);
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(parseApplicationDate);
	    int applicationMonthNumber = cal.get(Calendar.MONTH);
		return applicationMonthNumber;
	}

	private static String selectDateFromFirstDiv(String date1) {
		String flag="fail";
		WebElement parent=MyLeaveRequestHandler.lblDateParentFirstYearMonth();
		List<WebElement> list=parent.findElements(By.xpath("./div"));
		int datesCount=list.size();
		
		for(int i=1;i<=datesCount;i++) {

			WebElement dateIterator=parent.findElement(By.xpath("./div["+i+"]/span"));
			String getStartDate=dateIterator.getText();
			if(getStartDate.equals(date1)) {
				dateIterator.click();
				flag = "success";
				break;
			}
			
		}
		return flag;
	}
	
	private static String selectDateFromSecondDiv(String date1) {
		String flag="fail";
		try {
		WebElement parent=MyLeaveRequestHandler.lblDateParentLastYearMonth();
		List<WebElement> list=parent.findElements(By.xpath("./div"));
		int datesCount=list.size();
		
		for(int i=1;i<=datesCount;i++) {
			parent=MyLeaveRequestHandler.lblDateParentLastYearMonth();
			WebElement dateIterator=parent.findElement(By.xpath("./div["+i+"]/span"));
			String getStartDate=dateIterator.getText();
			if(getStartDate.equals(date1)) {
				dateIterator.click();
				flag = "success";
				break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			}
		return flag;
		}

	public static String SelectIlnessCodefromList(String illness) {
		String flag="fail";
		try {
		MyLeaveRequestHandler.btnIllnessCode().click();
		HomePageHandler.wait_StaticUI();
		Thread.sleep(3000);
		MyLeaveRequestHandler.selIllnessCode(illness).sendKeys(Keys.ENTER);
		flag = "success";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
}
