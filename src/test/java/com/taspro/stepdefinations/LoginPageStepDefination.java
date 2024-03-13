package com.taspro.stepdefinations;

import com.taspro.base.TestBase;
import com.taspro.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefination extends TestBase {
	LoginPage lpage;

	@Given("User is on login page")
	public void user_is_on_login_page() {
		launchWebSite();
		lpage = new LoginPage(driver);
		System.out.println("Login page opened successfully.");
	}

	@When("User enter username and password")
	public void user_enter_username_and_password() {
		lpage.enterEmail("an2119@checkboxtechnology.com");
		lpage.enterPassword("Aniket@1236");
	}
	
	@When("Click on Login button")
	public void click_on_login_button() {
	    lpage.clickOnLoginButton();
	}

	@Then("User is navigated to the DashBoardPage")
	public void user_is_navigated_to_the_dash_board_page() {
		
	}
}
