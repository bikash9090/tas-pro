package com.taspro.stepdefinations;

import org.testng.Assert;

import com.taspro.base.TestBase;
import com.taspro.pages.ForgotPasswordPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordStepDefination extends TestBase {

	ForgotPasswordPage fpage;
	
	
	@Given("I landed on the Homepage")
	public void i_landed_on_the_homepage() {
		launchWebSite();
		fpage = new ForgotPasswordPage(driver);
	   
	}

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		System.out.println("I am on the Hompage");
	}

	@When("User clicks on the forgot password button")
	public void user_clicks_on_the_forgot_password_button() {
		fpage.clickOnForgotPassword();

	}

	@Then("User is redirected to the forgot password page")
	public void user_is_redirected_to_the_forgot_password_page() {
       String url =fpage.getForgotPasswordURl();
       Assert.assertEquals(url, "https://tas2.checkboxtechnology.com/login/resetpassword");
       
	}
	@When("user enters the recovery email")
	public void user_enters_the_recovery_email() {
	   fpage.sendRecoveryEmail("db2116@checkboxtechnology.com");
	   fpage.ClickOnsendRecoveryemail();
	    
	}

	@Then("forgot password mail link is sent")
	public void forgot_password_mail_link_is_sent() {
		String popup = fpage.getEmailSentConfirmation();
		Assert.assertEquals(popup, "if given email Id is registered, mail is sent to you", "Recovery email not sent");
	}
	
	@Then("SendLink button is displayed")
	public void SendLink_button_is_displayed() {
		
		System.out.println("send link button displayed ?");
	}


}
