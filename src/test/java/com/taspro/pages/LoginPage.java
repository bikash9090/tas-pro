package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.taspro.base.PageBase;

public class LoginPage extends PageBase {
	WebDriver driver;

	/*------------------------------------------------Page objects----------------------------------------------*/
	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement emailfield;

	@FindBy(xpath = "//input[@placeholder='enter password']")
	WebElement passwordfield;

	@FindBy(className = "login100-form-btn")
	WebElement loginButton;
	
	@FindBy(xpath="//snack-bar-container[@class='mat-snack-bar-container ng-tns-c47-14 ng-trigger ng-trigger-state mat-snack-bar-center ng-star-inserted']")
	WebElement errorMessage;
	
	/*-------------------------------------------Page initialization----------------------------------------------*/
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*---------------------------------------Custom actions---------------------------------------------------*/

	public void loginToUserAccount(String email, String password) {
		scrollAndEnterText(emailfield, email);                                                  
		scrollAndEnterText(passwordfield, password);
		scrollAndClick(loginButton);
	}
	public void getErrorMessageText() {
		waitForElementToBeVisible(errorMessage);
		errorMessage.getText();
		
	}
	
}
