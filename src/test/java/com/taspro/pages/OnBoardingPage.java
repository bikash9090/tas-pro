package com.taspro.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.taspro.base.PageBase;

public class OnBoardingPage extends PageBase {

	/*------------------------------------------------Page objects----------------------------------------------*/

	@FindBy(xpath = "/html/body/app-root/app-onboarding-list/div/div[2]/div/div/div/a[1]")
	private WebElement addCandiateButton;

	@FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-add-candidate/div/div")
	private WebElement addCandidateForm;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid has-error ng-touched']")
	private WebElement candidateNameField;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement candidateEmailField;

	@FindBy(xpath = "//input[@placeholder='081234 56789']")
	private WebElement candidateMobNoField;

	@FindBy(xpath = "//input[@formcontrolname='role']")
	private WebElement candidateRoleField;

	@FindBy(xpath = "//div[@class=\"mat-select-value ng-tns-c129-9\"]")
	private WebElement candidateExpInYear;

	@FindBy(xpath = "//span[@class=\"mat-option-text\"]")
	private List<WebElement> experianceListInYear;

	@FindBy(xpath = "//div[@id='mat-select-value-5']")
	private WebElement candidateExpInMonth;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> experianceListInMonth;

	@FindBy(xpath = "//input[@formcontrolname='curr_ctc']")
	private WebElement currentCTCInput;

	@FindBy(xpath = "//input[@formcontrolname='expected_ctc']")
	private WebElement expectedCTCInput;

	@FindBy(id = "mat-select-value-13")
	private WebElement OnnoticePeriodBox;

	@FindBy(xpath = "//mat-option[@class=\"mat-option mat-focus-indicator ng-tns-c129-15\"]")
	private List<WebElement> selectNoticePeriod;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/app-add-candidate/div/div/div[2]/form/div[11]/div/button")
	private WebElement submitOnBoardingForm;

	/*------------------------------------Page initialization----------------------------------------------*/
	public OnBoardingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*---------------------------------------Custom actions---------------------------------------------------*/
	public void clickAddCandiateButton() {
		waitForElementToBeVisible(addCandiateButton);
		scrollAndClick(addCandiateButton);
	}

	public void enterCandidateName(String name) {
		waitForElementToBeVisible(candidateNameField);
		scrollAndEnterText(candidateNameField, name);
	}

	public void enterCandidateEmail(String email) {
		scrollAndEnterText(candidateEmailField, email);
	}

	public void enterCandidatePhNo(String num) {
		scrollAndEnterText(candidateMobNoField, num);
	}

	public void enterCandidateRole(String role) {
		scrollAndEnterText(candidateRoleField, role);
	}

	public void selectCandidateYearOfexp(String year) {
		candidateExpInYear.click();
		selectFromList(experianceListInYear, year);
	}

	public void selectCandidateMonthOfexp(String month) {
		candidateExpInMonth.click();
		selectFromList(experianceListInMonth, month);
	}

	public void selectedExpectedCTC(String expctc) {
		expectedCTCInput.sendKeys(expctc);
	}

	public void selectedcurrentCTC(String currctc) {
		currentCTCInput.sendKeys(currctc);
	}

	public void selectNoticePeriod(String noticePeriod) {
		selectFromList(selectNoticePeriod, noticePeriod);

	}

}
