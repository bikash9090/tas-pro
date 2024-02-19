package com.taspro.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.taspro.utility.PropertiesUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public PropertiesUtil readpropobj = new PropertiesUtil();
	WebDriverWait wait;

	String browser = readpropobj.getBrowser();
	String url = readpropobj.getUrl();

	/*------------------------------------------------Browser Setup----------------------------------------------*/
	public void setUp() {
		driver = DriverFactory.getDriverFactoryInstance().initializeDriver();

	}

	/*------------------------------------------------LAUNCHING THE WEBSITE----------------------------------------------*/
	public void launchWebSite() {
		driver.get(url);
		driver.manage().window().maximize();

	}

	/*------------------------------------------------CLOSING THE BROWSER----------------------------------------------*/
	public void tearDown() {
		driver.close();

	}

}
