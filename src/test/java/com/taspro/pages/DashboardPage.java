package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.taspro.base.PageBase;

public class DashboardPage extends PageBase {

	/*----------------------------------------Page objects----------------------------------------------*/
	@FindBy(xpath = "//*[@id=\"header\"]/div/div[3]/nav/ul/li[1]/button")
	private WebElement attendanceBtn;

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
		waitForElementToBeVisible(profileIcon);
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
		waitForElementToBeVisible(profileDetails);
		return profileDetails.getText();
	}

	public void clickCheckInBtn() {
		String currentBtnText = getCssTextOfElement(attendanceBtn);

		if (currentBtnText.toLowerCase().equalsIgnoreCase("\"Check In\"")) {
			flashAndClick(attendanceBtn);
		} else if (currentBtnText.toLowerCase().equalsIgnoreCase("\"Check Out\"")) {
			System.out.println("Employee has already checked in");
		} else {
			System.out.println("Text not matched!");
		}
	}

	public void clickCheckOutBtn() {
		String currentBtnText = getCssTextOfElement(attendanceBtn);

		if (currentBtnText.toLowerCase().equalsIgnoreCase("\"Check Out\"")) {
			flashAndClick(attendanceBtn);
		} else if (currentBtnText.toLowerCase().equalsIgnoreCase("\"Check In\"")) {
			System.out.println("Employee has not Checked In yet!");
		} else {
			System.out.println("Text not matched!");
		}
	}
}
