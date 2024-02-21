package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.taspro.base.PageBase;

public class ForgotPasswordPage extends PageBase {

	/*-------------------------------------------Page initialization----------------------------------------------*/

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*------------------------------------------------Page objects----------------------------------------------*/

	@FindBy(xpath = "//a[@class='txt2']")
	private WebElement forgotPasswordButton;

	@FindBy(xpath = "//input[@formcontrolname=\"email\"]")
	private WebElement revoceryEmail;

	@FindBy(xpath = "//button[.=\" Send Link \"]")
	private WebElement sendLinkButton;

	@FindBy(xpath = "//span[@class=\"mat-simple-snack-bar-content\"]")
	private WebElement emailsentpopup;

	/*---------------------------------------Custom actions---------------------------------------------------*/

	public void clickOnForgotPassword() {
		scrollAndClick(forgotPasswordButton);
	}

	public void sendRecoveryEmail(String recoveryemail) {
		scrollAndEnterText(revoceryEmail, recoveryemail);

	}

	public void ClickOnsendRecoveryemail() {
		scrollAndClick(sendLinkButton);
	}

	public String getEmailSentConfirmation() {
		waitForElementToBeVisible(emailsentpopup);
		return emailsentpopup.getText();
	}

	public String getForgotPasswordURl() {
		String currenturl = driver.getCurrentUrl();
		return currenturl;
	}

}
