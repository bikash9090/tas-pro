package com.taspro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.taspro.base.TestBase;
import com.taspro.pages.ForgotPasswordPage;

public class ForgotPasswordTest extends TestBase {

	ForgotPasswordPage fpage;

	/*------------------------------------BeforClass initialization----------------------------------------*/
	@BeforeClass
	public void initialization() {
		launchWebSite();
		fpage = new ForgotPasswordPage(driver);

	}

	/*----------------------------------Closing the browser after the test ---------------------------------*/
	@AfterClass
	public void close() {
		tearDown();
	}

	/*------------------------------------------------TESTCASES----------------------------------------------*/

	@Test
	public void clickOnForgotPassword() {
		boolean fpageLoadStatus = fpage.clickOnForgotPassword();
		Assert.assertTrue(fpageLoadStatus);
	}

	@Test
	public void verifyUserIsRedirectedToForgotPasswordPage() {
		fpage.clickOnForgotPassword();
		String expctectedURl = "https://tas2.checkboxtechnology.com/login/resetpassword";
		String actualurl = fpage.getForgotPasswordURl();
		Assert.assertEquals(expctectedURl, actualurl, "Forgot Password page URL doesnot match");

	}

	@Test
	public void toVerifyRecoveryEmailSent() {
		fpage.clickOnForgotPassword();
		fpage.sendRecoveryEmail("an2119@checkboxtechnology.com");
		fpage.ClickOnsendRecoveryemail();
		String popup = fpage.getEmailSentConfirmation();
		Assert.assertEquals(popup, "if given email Id is registered, mail is sent to you", "Recovery email not sent");

	}

}