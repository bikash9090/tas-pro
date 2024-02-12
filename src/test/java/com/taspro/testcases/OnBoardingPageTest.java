package com.taspro.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.taspro.base.TestBase;
import com.taspro.pages.DashboardPage;
import com.taspro.pages.LoginPage;
import com.taspro.pages.OnBoardingPage;
import com.taspro.utility.ExcelUtil;

public class OnBoardingPageTest extends TestBase {
	OnBoardingPage onBoardingPageobj;
	LoginPage lpagloginpageObj;
	DashboardPage dashboardPageobj;
	ExcelUtil excelObj;

	String name = "Dipak";

	/*------------------------------------------------BeforClass initialization----------------------------------------------*/
	@BeforeClass
	public void initilization() {
		launchWebSite();
		onBoardingPageobj = new OnBoardingPage(driver);
		lpagloginpageObj = new LoginPage(driver);
		dashboardPageobj = new DashboardPage(driver);
	}

	/*------------------------------------------------Closing the browser after the test ----------------------------------------------*/
	@AfterClass
	public void close() {
		//tearDown();
	}

	/*------------------------------------------------TESTCASES----------------------------------------------*/
	@Test
	public void userAccountLoginTest() {
		lpagloginpageObj.loginToUserAccount(readpropobj.getemail(), readpropobj.getpassword());
		dashboardPageobj.clickOnOnboardingTab();
		onBoardingPageobj.clickAddCandiateButton();
		onBoardingPageobj.waitForPageLoad(2000);

	}

	@DataProvider(name = "empOnBrdData")
	public String[][] onBoardData() {
		excelObj = new ExcelUtil();
		return excelObj.readExcel("OnBoardData");
	}

	@Test(dataProvider = "empOnBrdData",dependsOnMethods = "userAccountLoginTest")
	public void toVerifyEmteringCandidateDetails(String name, String email, String phno, String role, String yrofexp,
			String mnofexp, String currCTC, String expCTC, String npdays) {

		onBoardingPageobj.enterCandidateName(name);
		onBoardingPageobj.enterCandidateEmail(email);
		onBoardingPageobj.enterCandidatePhNo(phno);
		onBoardingPageobj.enterCandidateRole(role);
		onBoardingPageobj.selectCandidateYearOfexp(yrofexp);
		onBoardingPageobj.selectCandidateMonthOfexp(mnofexp);
		onBoardingPageobj.selectedcurrentCTC(currCTC);
		onBoardingPageobj.selecteExpectedCTC(expCTC);
		onBoardingPageobj.selectNoticePeriod(npdays);
		onBoardingPageobj.clickSaveButton();
		onBoardingPageobj.refreshDom();
		onBoardingPageobj.clickAddCandiateButton();

	}

}
