package com.taspro.base;

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
	public WebDriver setUp() {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			Map<String, Object> prefs = new HashMap<String, Object>();
//			Map<String, Object> profile = new HashMap<String, Object>();
//			Map<String, Object> contentSettings = new HashMap<String, Object>();
//			contentSettings.put("geolocation", 1);
//			profile.put("managed_default_content_settings", contentSettings);
//			prefs.put("profile", profile);
//			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("geo.prompt.testing", true);
			options.addPreference("geo.prompt.testing.allow", true);
			options.addPreference("geo.provider.testing", true);
		options.addPreference("geo.provider.testing.allow", true);

			driver = new FirefoxDriver(options);

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
		return driver;

	}

	/*------------------------------------------------LAUNCHING THE WEBSITE----------------------------------------------*/
	public void launchWebSite() {
		driver = setUp();
		driver.get(url);

	}

	/*------------------------------------------------CLOSING THE BROWSER----------------------------------------------*/
	public void tearDown() {
		driver.close();

	}

}
