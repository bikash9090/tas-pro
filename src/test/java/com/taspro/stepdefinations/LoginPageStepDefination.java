package com.taspro.stepdefinations;

import org.testng.Assert;

import com.taspro.base.TestBase;
import com.taspro.pages.DashboardPage;
import com.taspro.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefination extends TestBase {
	LoginPage lpage;
	DashboardPage dpage;

	@Given("User is on login page")
	public void user_is_on_login_page() {
		launchWebSite();
		lpage = new LoginPage(driver);
		dpage = new DashboardPage(driver);
		System.out.println("Login page opened successfully.");
	}

	@When("User enter username as {string} and password as {string}")
	public void user_enter_username_and_password(String uname, String pwd) {
		lpage.enterEmail(uname);
		lpage.enterPassword(pwd);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		lpage.clickOnLoginButton();
	}

	@Then("User is navigated to the DashBoardPage")
	public void user_is_navigated_to_the_dash_board_page() {
		boolean loggedInStatus = dpage.isLoginSuccessful("https://tas2.checkboxtechnology.com/dashboard");
		Assert.assertTrue(loggedInStatus, "User unable to login.");
	}
}
