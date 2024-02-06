package com.taspro.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.taspro.base.Constants;

public class ScreenShotUtil {
	
	WebDriver driver;
	
	
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
	
	public ScreenShotUtil(WebDriver driver){
		this.driver = driver;
	}
	
	public void takeScreenShot()  {
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\taspro\\utility\\ScreenshotUtil\\screenshot.png"));
		//FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"\\Screenshots\\"+timeStamp+"screenshot.png"));
		try {
			FileUtils.copyFile(f, new File(Constants.SCREENSHOT_DIR+timeStamp+"screenshot.png"));
		} catch (IOException e) {
			System.out.println("File IO exception occured! during copying the screenshot to path : "+Constants.SCREENSHOT_DIR);
			e.printStackTrace();
		}

	}

}
