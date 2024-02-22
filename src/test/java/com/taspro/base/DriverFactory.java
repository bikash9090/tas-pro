package com.taspro.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static final DriverFactory instance = new DriverFactory();
	private static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();

	private DriverFactory() {

	}

	public static DriverFactory getDriverFactoryInstance() {
		return instance;
	}

	public WebDriver initializeDriver(String browserName) {
		WebDriver driver = null;
		if (driver == null) {

			if (browserName.toLowerCase().equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browserName.toLowerCase().equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else if (browserName.toLowerCase().equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}
			tl.set(driver);
		}
		return getDriver();
	}

	public WebDriver getDriver() {
		return tl.get();
	}

}
