package com.taspro.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.taspro.base.TestBase;
import com.taspro.pages.DashboardPage;
import com.taspro.pages.LoginPage;
import com.taspro.pages.OnBoardingPage;
import com.taspro.utility.ExcelUtil;

public class OnBoardingPageTest extends TestBase {
	OnBoardingPage OnBoardingPageobj;
	LoginPage lpagloginpageObj;
	DashboardPage DashboardPageobj;
	ExcelUtil excelObj;

	String name = "Dipak";

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

	@DataProvider(name = "empOnBrdData")
	public String[][] onBoardData() {
		excelObj = new ExcelUtil();
		return excelObj.readExcel("OnBoardData");
	}

	@Test(dataProvider = "empOnBrdData", dependsOnMethods = "toVerifyTheOnboardingformOpening")
	public void toVerifyEmteringCandidateDetails(String name, String email, String phno, String role, String yrofexp,
			String mnofexp, String currCTC, String expCTC, String npdays) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
