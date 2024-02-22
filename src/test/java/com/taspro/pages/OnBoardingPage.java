package com.taspro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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

	@FindBy(xpath = "//a[contains(@class,'btn btn-danger border-0')]")
	private WebElement cancelButton;

	@FindBy(xpath = "//span[contains(@class,'mat-simple-snack-bar-content')]")
	private WebElement messagePopUp;

	@FindBy(xpath = "//*[@id=\"hr-table\"]/tbody/tr/td[2]")
	private List<WebElement> candidateNames;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	private WebElement alertOkBtn;

	@FindBy(xpath = "//div[contains(@class,'mat-paginator-range-actions')]/child::button[2]")
	private WebElement forwardPaginator;

	private By deactivateEmpButton = By.xpath("./following-sibling::td[contains(@class,'text-center')]/a[3]");
	private By deleteButton = By.xpath("./following-sibling::td[contains(@class,'text-center')]/a[1]");

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

	/*----------------------------------Add candidate form-----------------------------*/
	public void enterCandidateName(String name) {
		clickOnScreen();
		waitForElementToBeVisible(candidateNameField);
		scrollAndEnterTextTo(candidateNameField, name);
	}

	public void enterCandidateEmail(String email) {
		scrollAndEnterTextTo(candidateEmailField, email);
	}

	public void enterCandidatePhNo(String num) {
		scrollAndEnterTextTo(candidateMobNoField, num);
	}

	public void enterCandidateRole(String role) {
		scrollAndEnterTextTo(candidateRoleField, role);
	}

	public void selectCandidateYearOfexp(String year) {
		scrollAndClick(candidateExpInYear);
		selectFromList(experianceListInYear, year);
	}

	public void selectCandidateMonthOfexp(String month) {
		scrollAndClick(candidateExpInMonth);
		selectFromList(experianceListInMonth, month);
	}

	public void selectExpectedCTC(String expCTC) {
		scrollAndEnterTextTo(expectedCTCInput, expCTC);
	}

	public void selectCurrentCTC(String currCTC) {
		scrollAndEnterTextTo(currentCTCInput, currCTC);
	}

	public void selectNoticePeriod(String noticePeriod) {
		scrollAndClick(noticePeriodField);
		selectFromList(noticePeriosList, noticePeriod);

	}

	public Boolean clickOnSaveButton() {

		try {
			scrollAndClick(saveButton);
			waitForElementToBeVisible(messagePopUp);
			if (messagePopUp.getText().toLowerCase().equalsIgnoreCase("Candidate Added Successfully")) {
				return true;
			} else {
				return false;
			}
		} catch (TimeoutException e) {
			System.out.println("The 'Save' button is not clickable!");
			clickOnCancelButton();
			return false;
		}
	}

	public void clickOnCancelButton() {
		scrollAndClick(cancelButton);
	}

	/*----------------------------------Deactivate candidate-----------------------------*/
	public void clickOnDeactivateButtonOfCandidate(String employename) {
		for (WebElement cname : candidateNames) {
			if (cname.getText().toLowerCase().equalsIgnoreCase(employename)) {
				flashAndClick(cname.findElement(deactivateEmpButton));
				break;
			}
		}
	}

	public Boolean acceptDeactivateCandidateDialogue() {
		waitForElementToBeVisible(alertOkBtn);
		flashAndClick(alertOkBtn);
		waitForPageLoad(3000);
		waitForElementToBeVisible(messagePopUp);
		if (messagePopUp.getText().toLowerCase().equalsIgnoreCase("Candidate Deactivated Successfully")) {
			return true;
		} else {
			return false;
		}
	}

	/*----------------------------------Deletion of candidate-----------------------------*/
	public void clickOnDeleteButtonOfCandidate(String candidateName) {
		Boolean elementFound = false;
		for (WebElement cname : candidateNames) {
			if (cname.getText().toLowerCase().equalsIgnoreCase(candidateName)) {
				scrollAndClick(cname.findElement(deleteButton));
				elementFound = true;
				break;
			}
		}
		if (!elementFound) {
			// To do if the name not found the page.
		}
	}

	public Boolean acceptDeleteCandidateDialogue() {
		waitForElementToBeVisible(alertOkBtn);
		alertOkBtn.click();
		waitForPageLoad(3000);
		waitForElementToBeVisible(messagePopUp);
		if (messagePopUp.getText().toLowerCase().equalsIgnoreCase("Candidate Deleted Successfully")) {
			return true;
		} else {
			return false;
		}
	}

}
