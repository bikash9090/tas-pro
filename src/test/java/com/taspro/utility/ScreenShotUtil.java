package com.taspro.utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.reporters.Files;

public class ScreenShotUtil {
	
	WebDriver driver;
	
	ScreenShotUtil(WebDriver driver){
		this.driver = driver;
	}
	
	public void takeScreenShot() {
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	}

}
