package com.taspro.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
	public WebDriver driver;
	WebDriverWait wait;
	

	/*-------------------------------------------Page initialization----------------------------------------------*/
	public PageBase(WebDriver driver) {
	this.driver=driver;
	initWait();
		
	}
/*----------------------------------------------------------------------------------------------------------------------------------*/
	protected void scrollAndEnterText(WebElement element, String text) {
		element.sendKeys(text);
	}

	protected void scrollAndClick(WebElement element) {
		element.click();
	}
	protected void initWait() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
	
	protected void waitForElementToBeVisible(WebElement element) {
		   wait.until(ExpectedConditions.visibilityOf(element));
      
}
	public void waitForElemetTBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementTobeInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
	
}
	
