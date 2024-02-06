package com.taspro.testcases;

import org.openqa.selenium.WebElement;
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

	String name= "Dipak";
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
	@Test
	public void toVerifyEmteringCandidateDetails(String name,String email, String phno, String role, String yrofexp, String mnofexp, CharSequence currCTC, CharSequence[] expCTC, String npdays) {
		

		OnBoardingPageobj.enterCandidateName(name);
		OnBoardingPageobj.enterCandidateEmail(email);
		OnBoardingPageobj.enterCandidatePhNo(phno);
		OnBoardingPageobj.enterCandidateRole(role);
		OnBoardingPageobj.selectCandidateYearOfexp(yrofexp);
		OnBoardingPageobj.selectCandidateMonthOfexp(mnofexp);
		OnBoardingPageobj.selectedcurrentCTC(currCTC);
		OnBoardingPageobj.selectedExpectedCTC(expCTC);
		OnBoardingPageobj.selectNoticePeriod(npdays);
		
		
	}

}
