package com.taspro.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.taspro.utility.PropertiesUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public PropertiesUtil readpropobj = new PropertiesUtil();

	String browser = readpropobj.getBrowser();
	String url = readpropobj.getUrl();

	/*------------------------------------------------Browser Setup----------------------------------------------*/
	public WebDriver setUp(){
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			
		}
			else if (browser.equalsIgnoreCase("firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				
			}
				else if(browser.equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();	
				
				}
		driver.manage().window().maximize();
		return driver;
				
			}
	/*------------------------------------------------LAUNCHING THE WEBSITE----------------------------------------------*/
	public void  launchWebSite() {
        driver =setUp();
		driver.get(url);
		
	}
	/*------------------------------------------------CLOSING THE BROWSER----------------------------------------------*/
	public void tearDown() {
		driver.close();

	}
		

}

