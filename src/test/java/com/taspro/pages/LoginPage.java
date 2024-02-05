package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.taspro.base.PageBase;

public class LoginPage extends PageBase {

	/*---------------------------Page objects-------------------------------*/
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@placeholder='enter password']")
	private WebElement passwordField;

	@FindBy(xpath = "/html/body/app-root/app-login/div/div[1]/div/form/div[3]/button")
	private WebElement loginBtn;

	@FindBy(xpath = "//snack-bar-container[@class='mat-snack-bar-container ng-tns-c47-14 ng-trigger ng-trigger-state mat-snack-bar-center ng-star-inserted']")
	private WebElement errorMessagePopUp;

	@FindBy(xpath = "//a[@class='txt2']")
	private WebElement forgotPasswordBtn;

	/*------------------------Page initialization---------------------------*/

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*--------------------------Custom actions------------------------------*/

	public void loginToUserAccount(String email, String password) {
		scrollAndEnterText(emailField, email);
		scrollAndEnterText(passwordField, password);
		scrollAndClick(loginBtn);
	}

	public void getErrorMessageText() {
		waitForElementToBeVisible(errorMessagePopUp);
		errorMessagePopUp.getText();

	}

	public void clickOnForgotPassword() {
		scrollAndClick(forgotPasswordBtn);
	}

}
