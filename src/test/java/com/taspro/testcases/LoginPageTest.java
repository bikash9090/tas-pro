package com.taspro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.taspro.base.TestBase;
import com.taspro.pages.DashboardPage;
import com.taspro.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lpagloginpageObj;
	DashboardPage dpage;

	/*------------------------------------------------BeforClass initialization----------------------------------------------*/
	@BeforeClass
	public void initilization() {
		launchWebSite();
		lpagloginpageObj = new LoginPage(driver);
		dpage = new DashboardPage(driver);
	}

	/*------------------------------------------------Closing the browser after the test ----------------------------------------------*/
	@AfterClass
	public void close() {
		tearDown();
	}

	/*------------------------------------------------TESTCASES----------------------------------------------*/
	@Test
	public void loginFunTest() {

		lpagloginpageObj.loginToUserAccount(readpropobj.getemail(), readpropobj.getpassword());
	}

	@Test
	public void validateforgotpasswordlink() {
		lpagloginpageObj.clickOnForgotPassword();
	}

	@Test
	public void userCredentialLogin() {
		lpagloginpageObj.enterEmail("an2119@checkboxtechnology.com");
		lpagloginpageObj.enterPassword("Aniket@123");
		lpagloginpageObj.clickOnLoginButton();
		
		boolean flag = dpage.isLoginSuccessful("https://tas2.checkboxtechnology.com/dashboard");
		Assert.assertTrue(flag);
	}

}