package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.taspro.base.PageBase;

public class LoginPage extends PageBase {

	/*------------------------------------------------Page objects----------------------------------------------*/
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement emailfield;

	@FindBy(xpath = "//input[@placeholder='enter password']")
	private WebElement passwordfield;

	@FindBy(xpath = "/html/body/app-root/app-login/div/div[1]/div/form/div[3]/button")
	private WebElement loginButton;

	@FindBy(xpath = "//snack-bar-container[@class='mat-snack-bar-container ng-tns-c47-14 ng-trigger ng-trigger-state mat-snack-bar-center ng-star-inserted']")
	private WebElement errorMessage;

	@FindBy(xpath = "//a[@class='txt2']")
	private WebElement forgotPassword;

	/*-------------------------------------------Page initialization----------------------------------------------*/

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*---------------------------------------Custom actions---------------------------------------------------*/

	public void loginToUserAccount(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickOnLoginButton();
	}

	public void getErrorMessageText() {
		waitForElementToBeVisible(errorMessage);
		errorMessage.getText();

	}

	public void clickOnForgotPassword() {
		scrollAndClick(forgotPassword);
	}

	public void enterEmail(String email) {
		scrollAndEnterTextTo(emailfield, email);
	}

	public void enterPassword(String password) {
		scrollAndEnterTextTo(passwordfield, password);
	}

	public void clickOnLoginButton() {
		scrollAndClick(loginButton);
	}

}
