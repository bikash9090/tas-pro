package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.taspro.base.PageBase;

public class DashboardPage extends PageBase {

	/*-------------------------------------------Page initialization----------------------------------------------*/
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/*------------------------------------------------Page objects----------------------------------------------*/
	@FindBy(xpath = "//button[@class='scrollto btn btn-checkin checkin ng-star-inserted']")
	WebElement checkInbutton;

	@FindBy(className = "mat-menu-trigger scrollto")
	WebElement notificationIcon;

	@FindBy(xpath = "//i[@class='bi bi-person']")
	WebElement profileIcon;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/app-navbar/div/ul/li[1]/a/span")
	WebElement onBoardingTab;
	
	
	/*---------------------------------------Custom actions---------------------------------------------------*/


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
