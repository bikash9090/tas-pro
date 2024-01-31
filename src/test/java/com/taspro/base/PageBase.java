package com.taspro.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	WebDriverWait wait;
	public WebDriver driver;
	

	/*-------------------------------------------Page initialization----------------------------------------------*/
	public PageBase(WebDriver driver) {
		this.driver=driver;
		
	}
/*----------------------------------------------------------------------------------------------------------------------------------*/
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
	
