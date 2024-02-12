package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import java.util.Map;

import com.taspro.base.PageBase;

public class DashboardPage extends PageBase {

	/*----------------------------------------Page objects----------------------------------------------*/
	@FindBy(xpath = "//*[@id=\"header\"]/div/div[3]/nav/ul/li[1]")
	private WebElement checkInbutton;

	@FindBy(xpath = "/html/body/app-root/app-dashboard/app-navbar/header/div/div[3]/nav/ul/li[2]/a/i")
	private WebElement notificationIcon;

	@FindBy(xpath = "//*[@id=\"header\"]/div/div[3]/nav/ul/li[3]/a/i")
	private WebElement profileIcon;
	
	@FindBy(xpath="//span[@class=\"uxg-caption\"]")
	private WebElement  profileDetails;

	@FindBy(xpath = "/html/body/app-root/app-dashboard/app-navbar/div/ul/li[2]/a")
	private WebElement onBoardingTab;

	/*-------------------------------------Page initialization----------------------------------------------*/
	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*----------------------------------------Custom actions---------------------------------------------------*/

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
	
//	public String clickCheckInButton() {
//		String beforeclick = checkInbutton.getText();
//		checkInbutton.click();
//		waitForPageLoad(5000);
//		String afterclick = checkInbutton.getText();	
//		return beforeclick;
//return afterclick;
//	}
	


	public Map<String, String> clickCheckInButton() {
	    Map<String, String> result = new HashMap<>();
	    
        waitForElementToBeVisible(checkInbutton);
        waitForElemetTBeClickable(checkInbutton);
	    String beforeClick = checkInbutton.getText();
	    
	    checkInbutton.click();
	    waitForPageLoad(5000);
	    waitForElementToBeVisible(checkInbutton);
	    String afterClick = checkInbutton.getText();

	    result.put("beforeClick", beforeClick);
	    result.put("afterClick", afterClick);

	    return result;
	}


}
