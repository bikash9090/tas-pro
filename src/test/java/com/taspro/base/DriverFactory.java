package com.taspro.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.taspro.utility.PropertiesUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static final PropertiesUtil prop = new PropertiesUtil();
	private static final DriverFactory instance = new DriverFactory();

	private static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();

	private DriverFactory() {

	}

	public static DriverFactory getDriverFactoryInstance() {
		return instance;
	}

	public WebDriver initializeDriver() {
		WebDriver driver = null;
		if (driver == null) {

			if (prop.getBrowser().toLowerCase().equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				tl.set(driver);
			} else if (prop.getBrowser().toLowerCase().equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				tl.set(driver);
			} else if (prop.getBrowser().toLowerCase().equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				tl.set(driver);
			}
		}
		return getDriver();
	}

	public WebDriver getDriver() {
		return tl.get();
	}

}
