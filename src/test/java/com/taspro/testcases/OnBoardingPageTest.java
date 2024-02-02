package com.taspro.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.taspro.base.TestBase;
import com.taspro.pages.DashboardPage;
import com.taspro.pages.LoginPage;
import com.taspro.pages.OnBoardingPage;

public class OnBoardingPageTest extends TestBase {
	OnBoardingPage OnBoardingPageobj;
	LoginPage lpagloginpageObj;
	DashboardPage DashboardPageobj;

	/*------------------------------------------------BeforClass initialization----------------------------------------------*/
	@BeforeClass
	public void initilization() {
		launchWebSite();
		OnBoardingPageobj = new OnBoardingPage(driver);
		lpagloginpageObj = new LoginPage(driver);
		DashboardPageobj = new DashboardPage(driver);
	}

	/*------------------------------------------------Closing the browser after the test ----------------------------------------------*/
//	@AfterClass
//	public void close() {
//		tearDown();
//	}

	/*------------------------------------------------TESTCASES----------------------------------------------*/
	@Test
	public void toVerifyTheOnboardingformOpening() {
		lpagloginpageObj.loginToUserAccount(readpropobj.getemail(), readpropobj.getpassword());
		DashboardPageobj.clickOnOnboardingTab();
		 OnBoardingPageobj.clickAddCandiateButton();

	}

}
