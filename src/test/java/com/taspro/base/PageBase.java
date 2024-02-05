package com.taspro.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
	private WebDriver driver;
	WebDriverWait wait;
	

	/*----------------------------------PageBase initialization---------------------------------------*/
	public PageBase(WebDriver driver) {
		this.driver=driver;
		
	}
	/*--------------------------Common Actions performed on the webPage--------------------------------*/
	protected void scrollAndEnterText(WebElement element, String text) {
		element.sendKeys(text);
	}

	protected void scrollAndClick(WebElement element) {
		element.click();
	}
	protected void justWait() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
	
	protected void waitForElementToBeVisible(WebElement element) {
		   wait.until(ExpectedConditions.visibilityOf(element));
      
}
	
	
}
	
