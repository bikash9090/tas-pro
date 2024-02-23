package com.taspro.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.taspro.utility.PropertiesUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private PropertiesUtil readProp = new PropertiesUtil();
	private static final DriverFactory instance = new DriverFactory();
	private static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();

	//Restrict direct instance creation.
	private DriverFactory() {

	}

	//Returning current class instance indirectly.
	public static DriverFactory getDriverFactoryInstance() {
		return instance;
	}

	//Initialize the driver as per config.properties.
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

	//Get the driver instance after initializing the driver.
	public WebDriver getDriver() {
		return tl.get();
	}

	//To quite the browser instance and set the ThreadLocal to null.
	public void closeDriver() {
		getDriver().quit();
		tl.set(null);
	}

	//Setup Firefox option as per config.properties file.
	private FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();

		if (readProp.setHeadless().toLowerCase().equalsIgnoreCase("true")) {
			options.addArguments("--headless");

		} else if (readProp.setIncognito().toLowerCase().equalsIgnoreCase("true")) {
			options.addArguments("--incognito");

			if (readProp.disableInfoBar().toLowerCase().equalsIgnoreCase("true")) {
				options.addArguments("disable-infobars");
			}
		} else if (readProp.disableInfoBar().toLowerCase().equalsIgnoreCase("true")) {
			options.addArguments("disable-infobars");
		}

		//Handling the location alert first time on webpage.
		options.addPreference("geo.prompt.testing", true);
		options.addPreference("geo.prompt.testing.allow", true);
		options.addPreference("geo.provider.testing", true);
		options.addPreference("geo.provider.testing.allow", true);
		return options;
	}
}
