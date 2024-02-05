package com.taspro.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.reporters.Files;

public class ScreenShotUtil {
	
	WebDriver driver;
	
	ScreenShotUtil(WebDriver driver){
		this.driver = driver;
	}
	
	public void takeScreenShot() throws IOException {
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\taspro\\utility\\ScreenshotUtil\\screenshot.png"));
	}

}
