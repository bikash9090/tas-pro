package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.taspro.base.PageBase;

public class OnBoardingPage extends PageBase {

	/*-------------------------------------------Page initialization----------------------------------------------*/
	public OnBoardingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	/*------------------------------------------------Page objects----------------------------------------------*/
	
	

	@FindBy(xpath = "/html/body/app-root/app-onboarding-list/div/div[2]/div/div/div/a[1]")
	WebElement addCandiateButton;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid has-error ng-touched']")
	WebElement inputName;

	@FindBy(xpath = "//input[@type='email']")
	WebElement inpuEmail;

	@FindBy(xpath = "//input[@placeholder='081234 56789']")
	WebElement inputNumber;

	@FindBy(xpath = "//input[@formcontrolname='role']")
	WebElement inputRole;

	@FindBy(id = " mat-select-value-3")
	WebElement yearDropDown;

	@FindBy(id = "mat-select-value-5")
	WebElement monthDropDown;

	@FindBy(xpath = "//input[@formcontrolname='curr_ctc']")
	WebElement currentCTCInput;

	@FindBy(xpath = "//input[@formcontrolname='expected_ctc']")
	WebElement expectedCTCInput;

	@FindBy(xpath = "//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
	WebElement OnnoticePeriodBox;

	@FindBy(id = "mat-select-value-13")
	WebElement selectNoticePeriod;

	@FindBy(xpath="/html/body/div[2]/div[2]/div/mat-dialog-container/app-add-candidate/div/div/div[2]/form/div[11]/div/button")
	WebElement submitOnBoardingForm;

	/*---------------------------------------Custom actions---------------------------------------------------*/
	public void clickAddCandiateButton() {
	
		waitForElemetTBeClickable(addCandiateButton);
		scrollAndClick(addCandiateButton);
	}
	public void enterCandidateName(String name) {
		scrollAndEnterText(inputName, name);
	}
public void enterCandidateEmail(String email ) {
	scrollAndEnterText(inpuEmail, email);
}
public void enterCandidatePhNo(String num) {
	scrollAndEnterText(inputNumber, num);
}
public void enterCandidateRole(String role) {
	scrollAndEnterText(inputRole, role);
}
public void selectCandidateYearOfexp(String NoYR) {
	Select drop = new Select(yearDropDown);
	drop.selectByValue(NoYR);
}
public void selectCandidateMonthOfexp(String NoMN) {
	Select drop = new Select(monthDropDown);
	drop.selectByValue(NoMN);
}
public void selectedExpectedCTC(CharSequence[] expctc) {
	expectedCTCInput.sendKeys(expctc);
}
public void selectedcurrentCTC(CharSequence currctc) {
	currentCTCInput.sendKeys(currctc);
}
public void noticePeriodBox() {
	OnnoticePeriodBox.click();
}
public void 	selectNoticePeriod(String npdays) {
	Select drop = new Select(selectNoticePeriod);
	drop.selectByValue(npdays);
}

























}
