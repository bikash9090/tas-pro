package com.taspro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import java.util.Map;
import com.taspro.base.PageBase;

public class DashboardPage extends PageBase {

	/*----------------------------------------Page objects----------------------------------------------*/
	@FindBy(css = ".scrollto.btn.btn-checkin.checkin.ng-star-inserted")
	private WebElement checkInbutton;

	@FindBy(css = ".scrollto.btn.btn-checkin.CheckOut.ng-star-inserted")
	WebElement checkOutButton;

	@FindBy(xpath = "/html/body/app-root/app-dashboard/app-navbar/header/div/div[3]/nav/ul/li[2]/a/i")
	private WebElement notificationIcon;

	@FindBy(xpath = "//i[@class='bi bi-person']")
	private WebElement profileIcon;

	@FindBy(xpath = "//span[@class=\"uxg-caption\"]")
	private WebElement profileDetails;

	@FindBy(xpath = "/html/body/app-root/app-dashboard/app-navbar/div/ul/li[2]/a")
	private WebElement onBoardingTab;

	/*-------------------------------------Page initialization----------------------------------------------*/
	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*----------------------------------------Custom actions---------------------------------------------------*/

	public boolean isLoginSuccessful(String url) {

		if (driver.getCurrentUrl().equals(url)) {
			return true;
		} else {
			return false;
		}

	}

	public void clickOnoNtificationbutton() {
		scrollAndClick(notificationIcon);
	}

	public void clickOnProfileIconIcon() {
		waitForElementToBeVisible(profileIcon);
		scrollAndClick(profileIcon);
	}

	public void clickOnOnboardingTab() {
		waitForElementToBeVisible(onBoardingTab);
		scrollAndClick(onBoardingTab);
	}

	public String getUsername() {
		return profileDetails.getText();
	}

	public String getCheckinBtnText() {
		waitForElementToBeVisible(checkInbutton);
		String script = "return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content')";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String checkintext = (String) js.executeScript(script, checkInbutton);
		return checkintext;

	}

	public String getCheckoutBtnText() {
		waitForElementToBeVisible(checkOutButton);
		String script = "return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content')";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String checkouttext = (String) js.executeScript(script, checkOutButton);
		return checkouttext;

	}

	public String initalText( ) {
		try {
			if (checkInbutton.isDisplayed()) {
				return getCheckinBtnText();
			}
		} catch (NoSuchElementException | StaleElementReferenceException e) {

		}

		try {
			if (checkOutButton.isDisplayed()) {
				return getCheckoutBtnText();
			}
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			// Handle exception if checkOutButton is not present
		}
		return "NOBUTTON";
		
	}
	

}
