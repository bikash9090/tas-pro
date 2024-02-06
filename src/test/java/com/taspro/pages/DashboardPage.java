package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.taspro.base.PageBase;

public class DashboardPage   extends PageBase {

	/*-------------------------------------------Page initialization----------------------------------------------*/
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*------------------------------------------------Page objects----------------------------------------------*/
	@FindBy(xpath = "//button[@class='scrollto btn btn-checkin checkin ng-star-inserted']")
	WebElement checkInbutton;

	@FindBy(xpath ="/html/body/app-root/app-dashboard/app-navbar/header/div/div[3]/nav/ul/li[2]/a/i")
	WebElement notificationIcon;

	
	@FindBy(xpath = "//i[@class='bi bi-person']")
	WebElement profileIcon;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/app-navbar/div/ul/li[2]/a")
	WebElement onBoardingTab;
	
	
	
	/*---------------------------------------Custom actions---------------------------------------------------*/


	public void clickOnoNtificationbutton() {
		scrollAndClick(notificationIcon);
	}

	public void clickOnProfileIconIcon() {
		scrollAndClick(profileIcon);
	}
	public void clickOnOnboardingTab() {
		waitForElementToBeVisible(onBoardingTab);
		scrollAndClick(onBoardingTab);
		
	}

}
