package com.taspro.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.taspro.utility.PropertiesUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public WebDriver driver;
	public PropertiesUtil readpropobj;

	
	public void initDriver() {
		readpropobj = new PropertiesUtil();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(readpropobj.getUrl());
		driver.manage().window().maximize();
		readpropobj = new PropertiesUtil();
		
	}
	
	public void destroyDriver() {
		driver.quit();
	}

}
