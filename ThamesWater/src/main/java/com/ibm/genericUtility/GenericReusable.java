package com.ibm.genericUtility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class GenericReusable extends DriverBase {
	
	public static String reportStartTime;

	public static String currentTime() {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		   LocalDateTime now = LocalDateTime.now();
		   return dtf.format(now);
	}
	
	public static String reportStartTime() {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		   LocalDateTime now = LocalDateTime.now();
		   reportStartTime=dtf.format(now);
		   return reportStartTime;
	}

	public static void VerifyMethodStatus(String methodStatus, String message) {
		if(!methodStatus.equalsIgnoreCase("success")) {
			Assert.fail(message);
		}
		
	}
	
	public static void selectbyVisibletext(String sVisibletext, WebElement element) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(sVisibletext);
	}
	
	public static void mouseHoverAndClick(WebElement element) {
		Actions action =new Actions(driver);
		//action.moveToElement(element);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
	}

	public static String fullScreenShot(String screenShotName) throws IOException {
        
		String fileName = currentTime();
		final Screenshot screenshot = new AShot().shootingStrategy(
                new ViewportPastingStrategy(100)).takeScreenshot(driver);
        final BufferedImage image = screenshot.getImage();
        ImageIO.write(image, "PNG", new File("./test-output/Results/" + screenShotName +"_"+fileName+".png"));

		String newDest="./"+ screenShotName +"_"+fileName+".png";
		return newDest;
	}
	
	public static String getScreenShot(String screenShotName){
		String newDest=null;
		try {
			System.out.println("Taking Screen Shot");
			TakesScreenshot ts = (TakesScreenshot)driver;
        	File screenshot = ts.getScreenshotAs(OutputType.FILE);
			String fileName = currentTime();
			
        	File destination = new File("./test-output/Results"+reportStartTime+"/"+ screenShotName +"_"+fileName+".png");
        	FileUtils.copyFile(screenshot, destination);
        	newDest="./"+ screenShotName +"_"+fileName+".png";
		}catch(Exception e) {
			return "fail";
		}
		return newDest;
	}
}
