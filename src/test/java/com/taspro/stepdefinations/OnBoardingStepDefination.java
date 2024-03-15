package com.taspro.stepdefinations;

import org.testng.Assert;

import com.taspro.base.TestBase;
import com.taspro.pages.DashboardPage;
import com.taspro.pages.LoginPage;
import com.taspro.pages.OnBoardingPage;
import com.taspro.utility.ExcelUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoardingStepDefination extends TestBase {
	LoginPage lpage;
	DashboardPage dpage;
	OnBoardingPage onboardPage;
	ExcelUtil excelObj;
	boolean saveStatus;

	@Given("HR on the candidate onboarding page")
	public void hr_am_on_the_candidate_onboarding_page() {
		launchWebSite();
		lpage = new LoginPage(driver);
		dpage = new DashboardPage(driver);
		onboardPage = new OnBoardingPage(driver);		
		
		lpage.loginToUserAccount(readpropobj.getemail(), readpropobj.getpassword());
		dpage.clickOnOnboardingTab();
		onboardPage.clickAddCandiateButton();
		dpage.waitForPageLoad(2000);
	}

	@When("HR enter candidate details from {string}")
	public void hr_enter_candidate_details_from(String excelSheetName) {

		excelObj = new ExcelUtil();
		String[][] candidateData = excelObj.readExcelSheet(excelSheetName);
		
		for (int i = 1; i < candidateData.length; i++) {
			onboardPage.enterCandidateName(candidateData[i][0]);
			onboardPage.enterCandidateEmail(candidateData[i][1]);
			onboardPage.enterCandidatePhNo(candidateData[i][2]);
			onboardPage.enterCandidateRole(candidateData[i][3]);
			onboardPage.selectCandidateYearOfexp(candidateData[i][4]);
			onboardPage.selectCandidateMonthOfexp(candidateData[i][5]);
			onboardPage.selectCurrentCTC(candidateData[i][6]);
			onboardPage.selectExpectedCTC(candidateData[i][7]);
			onboardPage.selectNoticePeriod(candidateData[i][8]);
			saveStatus = onboardPage.clickOnSaveButton();
			onboardPage.refreshDom();
			onboardPage.clickAddCandiateButton();
			Assert.assertTrue(saveStatus);
		}
	}

	@When("HR click on the save button")
	public void hr_click_on_the_save_button() {

	}

	@Then("the candidate should be successfully saved")
	public void the_candidate_should_be_successfully_saved() {
	
	}

	@Then("HR should be able to add another candidate")
	public void hr_should_be_able_to_add_another_candidate() {
		
	}
}
