package com.taspro.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	public WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;
	Actions actions;
	Robot robot;

	/*-------------------------------------------Page initialization----------------------------------------------*/
	public PageBase(WebDriver driver) {
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		actions = new Actions(driver);
	}

	/*----------------------------------------------------------------------------------------------------------------------------------*/

	public void refreshDom() {
		jsExecutor.executeScript("location.reload()");
	}

	protected void scrollIntoView(WebElement element) {
		jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});",
				element);
	}

	protected void flash(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver; // downcasting
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 5px red')", element);

		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			System.out.println("Interruputed exception occured! during flash operation.");
			e.printStackTrace();
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);

	}
	
	protected Boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	/*-----------------------------ENTER TEXT ACTIONS--------------------------------*/
	protected void scrollAndEnterTextTo(WebElement element, String text) {
		scrollIntoView(element);
		flash(element);
		element.sendKeys(text);
	}

	protected void flashAndEnterTextTo(WebElement element, String text) {
		flash(element);
		element.sendKeys(text);
	}

	/*-----------------------------CLICK ACTIONS--------------------------------*/

	protected void clickOnScreen() {
		actions = new Actions(driver);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			System.out.println("AWTException occured! during mouse click action on current page.");
			e.printStackTrace();
		}
		robot.mouseMove(50, 50);
		actions.click().build().perform();
	}

	protected void clickByJavaScript(WebElement element) {
		scrollIntoView(element);
		flash(element);
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	protected void scrollAndClick(WebElement element) {
		scrollIntoView(element);
		flash(element);
		waitForElemetTBeClickable(element);
		element.click();
	}

	protected void flashAndClick(WebElement element) {
		flash(element);
		element.click();
	}

	// ---------------Select option from any list------------------------
	protected void selectFromList(List<WebElement> element, String option) {
		Boolean optionFound = false;
		for (WebElement opt : element) {
			if (opt.getText().toLowerCase().equalsIgnoreCase(option)) {
				waitForElementToBeVisible(opt);
				opt.click();
				optionFound = true;
				break;
			}
		}
		if (!optionFound) {
			System.out.println("The option '" + option + "' not found! in the list ");
			actions.sendKeys(Keys.ESCAPE).build().perform();
		}

	}

	// ---------------Switch to alert------------------------
	protected String getTextFromAlert() {
		return driver.switchTo().alert().getText();
	}

	/*-------------------------------------------WAITS METHODS---------------------------------------*/

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

	protected void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	protected void waitForElemetTBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void waitForElementTobeInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForMiliSec(long miliSec) {
		try {
			Thread.sleep(miliSec);
		} catch (InterruptedException e) {
			System.out.println("Interruped exception occured! while sleeping.");
			e.printStackTrace();
		}
	}

}
