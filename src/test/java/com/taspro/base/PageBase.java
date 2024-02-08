package com.taspro.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	public WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	/*-------------------------------------------Page initialization----------------------------------------------*/
	public PageBase(WebDriver driver) {
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
	}

	/*----------------------------------------------------------------------------------------------------------------------------------*/
	protected  void scrollToView(WebElement element) {
		 jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
	}
	
	protected void scrollAndEnterText(WebElement element, String text) {
		scrollToView(element);
		flash(element);
		element.sendKeys(text);
	}

	protected void scrollAndClick(WebElement element) {
		scrollToView(element);
		flash(element);
		waitForElemetTBeClickable(element);
		element.click();
	}

	public void flash(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver; // downcasting
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 5px red')", element);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);

	}

	protected void selectFromList(List<WebElement> element, String option) {
		for (WebElement opts : element) {
			if (opts.getText().toLowerCase().equalsIgnoreCase(option)) {
				waitForElementToBeVisible(opts);
				opts.click();
				break;
			}
		}
	}

	/*-------------------------------------------waits methods-------------------------------------*/

	// it waits for the page load to complete.
	public void waitForPageLoad(int timeOutInMilis) {

		long endTime = System.currentTimeMillis() + timeOutInMilis;

		while (System.currentTimeMillis() < endTime) {

			String pageState = jsExecutor.executeScript("return document.readyState").toString();
			if (pageState.equals("complete")) {
				System.out.println("page DOM is fully loaded now.....");
				break;
			}
		}
	}

	protected void initWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	protected void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	protected void waitForElemetTBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void waitForElementTobeInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

}
