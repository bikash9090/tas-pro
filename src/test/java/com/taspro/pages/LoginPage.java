package com.taspro.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.taspro.base.PageBase;

public class LoginPage extends PageBase {

	/*------------------------------------------------Page objects----------------------------------------------*/
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement emailfield;

	@FindBy(xpath = "//input[@placeholder='enter password']")
	private WebElement passwordfield;

	@FindBy(xpath = "/html/body/app-root/app-login/div/div[1]/div/form/div[3]/button")
	private WebElement loginButton;

	@FindBy(xpath = "//span[contains(@class,'mat-simple-snack-bar-content')]")
    private WebElement errorMessage;

	@FindBy(xpath = "//a[@class='txt2']")
	private WebElement forgotPassword;
	
	@FindBy(xpath = "//i[@class='bi bi-person']")
	private WebElement profileIcon;

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
	
	public boolean isLoginSuccessfull() {
		try {
			waitForElementToBeVisible(errorMessage);
			 if(errorMessage.getText().equalsIgnoreCase("Please enter valid credential")) {
				return true;
			}
			else {
				return false;
			}
		} catch (TimeoutException e) {
			waitForElementToBeVisible(profileIcon);
			return profileIcon.isDisplayed();
		}
		
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
