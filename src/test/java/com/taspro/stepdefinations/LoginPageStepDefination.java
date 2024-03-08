package com.taspro.stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefination {
	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("Given method : Open the URL.");
	}

	@When("User enter username and password")
	public void user_enter_username_and_password() {
		System.out.println("When method : Enter userid and password to the fields.");
	}

	@Then("User is navigated to the DashBoardPage")
	public void user_is_navigated_to_the_dash_board_page() {
		System.out.println("Then method : Verify the login is succssfull or not!");
	}
}
