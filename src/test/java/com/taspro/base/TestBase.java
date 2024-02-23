package com.taspro.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.taspro.utility.PropertiesUtil;

public class TestBase {

	public WebDriver driver;
	public PropertiesUtil readpropobj = new PropertiesUtil();
	WebDriverWait wait;

	String browser = readpropobj.getBrowser();
	String url = readpropobj.getUrl();

	/*------------------------------------------------LAUNCHING THE WEBSITE----------------------------------------------*/
	public void launchWebSite() {
		driver = DriverFactory.getDriverFactoryInstance().initializeDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
	}

	/*-------------------------------------------------CLOSING THE BROWSER----------------------------------------------*/
	public void tearDown() {
		DriverFactory.getDriverFactoryInstance().quitDriver();
	}

}
