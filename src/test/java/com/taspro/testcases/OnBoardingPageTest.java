package com.taspro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

	/*------------------------------------------------BeforClass initialization----------------------------------------------*/
	@BeforeClass
	public void initilization() {
		launchWebSite();
		onBoardingPageobj = new OnBoardingPage(driver);
		lpagloginpageObj = new LoginPage(driver);
		dashboardPageobj = new DashboardPage(driver);
		excelObj = new ExcelUtil();
	}

	/*------------------------------------------------Closing the browser after the test ----------------------------------------------*/
	@AfterClass
	public void close() {
		// tearDown();
	}

	/*------------------------------------------------TESTCASES----------------------------------------------*/
	@Test()
	public void userAccountLoginTest() {
		lpagloginpageObj.loginToUserAccount(readpropobj.getemail(), readpropobj.getpassword());
		dashboardPageobj.clickOnOnboardingTab();
		onBoardingPageobj.clickAddCandiateButton();
		onBoardingPageobj.waitForPageLoad(2000);

	}

	@DataProvider(name = "empOnBrdData")
	public String[][] onBoardData() {
		return excelObj.readExcelSheet("OnBoardData");
	}

	@Test(priority = 1, dataProvider = "empOnBrdData", dependsOnMethods = "userAccountLoginTest")
	public void candidateOnBoardingTest(String name, String email, String phno, String role, String yrofexp,
			String mnofexp, String currCTC, String expCTC, String npdays) {

		onBoardingPageobj.enterCandidateName(name);
		onBoardingPageobj.enterCandidateEmail(email);
		onBoardingPageobj.enterCandidatePhNo(phno);
		onBoardingPageobj.enterCandidateRole(role);
		onBoardingPageobj.selectCandidateYearOfexp(yrofexp);
		onBoardingPageobj.selectCandidateMonthOfexp(mnofexp);
		onBoardingPageobj.selectCurrentCTC(currCTC);
		onBoardingPageobj.selectExpectedCTC(expCTC);
		onBoardingPageobj.selectNoticePeriod(npdays);

		Boolean saveStatus = onBoardingPageobj.clickOnSaveButton();
		onBoardingPageobj.refreshDom();
		onBoardingPageobj.clickAddCandiateButton();
		Assert.assertTrue(saveStatus);
	}

	@Test(priority = 3)
	public void userLogin() {
		onBoardingPageobj.clickOnCancelButton();
	}

	@DataProvider(name = "nameData")
	public String[][] namaData() {
		excelObj = new ExcelUtil();
		return excelObj.readColumnData("OnBoardData", 0);
	}

	@Test(priority = 2, dependsOnMethods = "userLogin", dataProvider = "nameData")
	public void onBoardedCandidateDeletionTest(String candName) {

		onBoardingPageobj.clickOnDeleteButtonOfCandidate(candName);
		Boolean deletionStatus = onBoardingPageobj.acceptDeleteCandidateDialogue();
		Assert.assertTrue(deletionStatus);
	}

	@Test(dependsOnMethods = "userLogin", enabled = false)
	public void deleteAllOnBoardedCandidateTest() {
		onBoardingPageobj.deleteAllOnboardedCandidate();
	}

	@DataProvider(name = "empDelData")

	public String[][] delempData() {
		return excelObj.readExcelSheet("delEmpData");
	}

	@Test(dataProvider = "empDelData", dependsOnMethods = "userLogin", enabled = false)
	public void toVerifyDeactivateEmployee(String name) {

		onBoardingPageobj.clickOnDeactivateButtonOfCandidate(name);
		Boolean deactiveStatus = onBoardingPageobj.acceptDeactivateCandidateDialogue();
		Assert.assertTrue(deactiveStatus);
	}
}
