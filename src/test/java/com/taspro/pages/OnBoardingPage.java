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

	@FindBy(xpath = "//*[@id=\"mat-dialog-0\"]")
	private WebElement addCandidateForm;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid has-error ng-touched']")
	private WebElement candidateNameField;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement candidateEmailField;

	@FindBy(xpath = "//input[@placeholder='081234 56789']")
	private WebElement candidateMobNoField;

	@FindBy(xpath = "//input[@formcontrolname='role']")
	private WebElement candidateRoleField;

	@FindBy(xpath = "//div[@class='form-group']//div[@class='form-group']/child::div[1]/descendant::div[2]")
	private WebElement candidateExpInYear;

	@FindBy(xpath = "//span[@class=\"mat-option-text\"]")
	private List<WebElement> experianceListInYear;

	@FindBy(xpath = "//div[@class='form-group']//div[@class='form-group']/following::div[1]/child::div/descendant::div[3]")
	private WebElement candidateExpInMonth;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> experianceListInMonth;

	@FindBy(xpath = "//input[@formcontrolname='curr_ctc']")
	private WebElement currentCTCInput;

	@FindBy(xpath = "//input[@formcontrolname='expected_ctc']")
	private WebElement expectedCTCInput;

	@FindBy(xpath = "//div[@id='mat-select-value-7']")
	private WebElement noticePeriodField;

	@FindBy(xpath = "//span[@class=\"mat-option-text\"]")
	private List<WebElement> noticePeriosList;

	@FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-add-candidate/div/div/div[2]/form/div[11]/div/button")
	private WebElement saveButton;
	
	@FindBy(xpath="//tbody/tr[1]/td[11]/a[3]/mat-icon[1]")
	private WebElement deactivatebutton;
	
	@FindBy(xpath="//button[normalize-space()='Ok']")
	private WebElement deactivateOK;

	/*------------------------------------Page initialization----------------------------------------------*/
	public OnBoardingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*---------------------------------------Custom actions---------------------------------------------------*/
	public void clickAddCandiateButton() {

		waitForElementToBeVisible(addCandiateButton);
		scrollAndClick(addCandiateButton);
		clickOnScreen();
	}

	public void enterCandidateName(String name) {
		clickOnScreen();
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
		scrollAndClick(candidateExpInYear);
		selectFromList(experianceListInYear, year);
	}

	public void selectCandidateMonthOfexp(String month) {
		scrollAndClick(candidateExpInMonth);
		selectFromList(experianceListInMonth, month);
	}

	public void selecteExpectedCTC(String expctc) {
		scrollAndEnterText(expectedCTCInput, expctc);
	}

	public void selectedcurrentCTC(String currctc) {
		scrollAndEnterText(currentCTCInput, currctc);
	}

	public void selectNoticePeriod(String noticePeriod) {
		scrollAndClick(noticePeriodField);
		selectFromList(noticePeriosList, noticePeriod);

	}

	public void clickSaveButton() {
		scrollAndClick(saveButton);
	}
	public void clickDeactivateButton() {
		scrollAndClick(deactivatebutton);
	}
	
	public void clickOnDeactivateOK() {
		waitForElementToBeVisible(deactivateOK);
		waitForElemetTBeClickable(deactivateOK);
		scrollAndClick(deactivateOK);
	}

}
