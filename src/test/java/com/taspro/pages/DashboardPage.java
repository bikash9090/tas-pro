package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.taspro.base.PageBase;

public class DashboardPage extends PageBase {

	/*-----------------------------Page objects----------------------------------------------*/

	@FindBy(xpath = "//button[@class='scrollto btn btn-checkin checkin ng-star-inserted']")
	private WebElement checkInbutton;

	@FindBy(xpath = "/html/body/app-root/app-dashboard/app-navbar/header/div/div[3]/nav/ul/li[2]/a/i")
	private WebElement notificationIcon;

	@FindBy(xpath = "//i[@class='bi bi-person']")
	private WebElement profileIcon;

	@FindBy(css = ".link-dark.nav-link.active")
	private WebElement onBoardingTab;

	/*----------------------Page Objects initialization-------------------------------------*/
	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	/*-----------------------------Custom actions--------------------------------------------*/

	public void notificationbutton() {
		scrollAndClick(notificationIcon);
	}

	public void profileIconIcon() {
		scrollAndClick(profileIcon);
	}

	public void clickOnOnboardingTab() {
		scrollAndClick(onBoardingTab);
	}

}
