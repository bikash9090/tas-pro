package com.taspro.stepdefinations;

import org.testng.Assert;

import com.taspro.base.TestBase;
import com.taspro.pages.DashboardPage;
import com.taspro.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DasboardPageStepDefination extends TestBase{
	
	LoginPage lpage;
	DashboardPage dpage;

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
			launchWebSite();
			lpage = new LoginPage(driver);
			dpage = new DashboardPage(driver);
			System.out.println("Login page opened successfully.");
	    
	}

	@When("User enters their email ID and password")
	public void user_enters_their_email_id_and_password() {
		lpage.enterEmail("an2119@checkboxtechnology.com");
		lpage.enterPassword("Aniket@123");
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
		 lpage.clickOnLoginButton();
	}

	@Then("User should navigate to the dashboard page")
	public void user_should_navigate_to_the_dashboard_page() {
		boolean loggedInStatus = lpage.isLoginSuccessfull();
		Assert.assertTrue(loggedInStatus);
	}

	@Then("User checks if the profile icon is visible")
	public void user_checks_if_the_profile_icon_is_visible() {
		dpage.isProfileIconVisible();
		System.out.println("Page should navigate to dashboard");
	}

	@Then("The dashboard page open successfully")
	public void the_dashboard_page_open_successfully() {
		//dpage.clickOnProfileIconIcon();
		System.out.println("The dashboardpage open successfully");
	}


}
