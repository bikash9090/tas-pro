package com.taspro.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.taspro.base.TestBase;
import com.taspro.pages.ForgotPasswordPage;
import com.taspro.utility.ExcelUtil;

public class ForgotPasswordTest extends TestBase {

	ForgotPasswordPage fpage;
	Logger log;

	/*------------------------------------BeforClass initialization----------------------------------------*/
	@BeforeClass
	public void initialization() {
		launchWebSite();
		fpage = new ForgotPasswordPage(driver);
		 log  = LogManager.getLogger(ForgotPasswordTest.class.getName());

	}

	/*----------------------------------Closing the browser after the test ---------------------------------*/
	@AfterClass
	public void close() {
		tearDown();
	}

	/*------------------------------------------------TESTCASES----------------------------------------------*/

	@Test(testName="To verify clicking of forgot password button",priority=0)
	public void clickOnForgotPassword() {
		boolean fpageLoadStatus = fpage.clickOnForgotPassword();
		log.info("Clicked on the forgot password tab");
		Assert.assertTrue(fpageLoadStatus);
		
	}

	@Test(testName="To verify the URL of the forgot password page",dependsOnMethods = {"clickOnForgotPassword"},priority=1)
	public void verifyUserIsRedirectedToForgotPasswordPage() {
		//fpage.clickOnForgotPassword();
		String expctectedURl = "https://tas-pro.checkboxtechnology.com/login/resetpassword";
		String actualurl = fpage.getForgotPasswordURl();
		Assert.assertEquals(expctectedURl, actualurl, "Forgot Password page URL doesnot match");
		log.info("Verified the forgot passsword URL");

	}

	@Test(testName="To verify recovery link sent to user",priority=2)
	public void toVerifyRecoveryEmailSent() {
		//fpage.clickOnForgotPassword();
		fpage.sendRecoveryEmail("an2119@checkboxtechnology.com");
		log.info("Sent email to change password");
		fpage.ClickOnsendRecoveryemail();
		String popup = fpage.getEmailSentConfirmation();
		log.info("Email sent confirmation recieved on UI");
		Assert.assertEquals(popup, "if given email Id is registered, mail is sent to you", "Recovery email not sent");

	}

}