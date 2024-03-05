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

	public ScreenShotUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String takeScreenShot(String testName) {

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = Constants.SCREENSHOT_DIR + testName + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
			return destination;
		} catch (IOException e) {
			System.out.println(
					"File IO exception occured! during copying the screenshot to path : " + Constants.SCREENSHOT_DIR);
			e.printStackTrace();
			return null;
		}
	}
}
