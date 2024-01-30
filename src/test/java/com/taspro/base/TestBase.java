package com.taspro.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public void initDriver() {
		WebDriver driver;
		driver = new ChromeDriver();
	}

}
