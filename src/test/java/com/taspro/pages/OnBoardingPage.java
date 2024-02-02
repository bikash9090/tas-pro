package com.taspro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.taspro.base.PageBase;

public class OnBoardingPage extends PageBase {

	WebDriver driver;

	/*-------------------------------------------Page initialization----------------------------------------------*/
	public OnBoardingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/*------------------------------------------------Page objects----------------------------------------------*/
	@FindBy(xpath = "//i[@class='bi bi-plus']")
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

	@FindBy(className = "me-2 btn btn-primary ng-star-inserted")
	WebElement submitOnBoardingForm;

	/*---------------------------------------Custom actions---------------------------------------------------*/
	public void clickAddCandiate() {
		scrollAndClick(addCandiateButton);
	}
	public void enterCandidateName(String name) {
		scrollAndEnterText(inputName, name);
	}
public void enterEmail(String email ) {
	scrollAndEnterText(inpuEmail, email);
}
public void enterPhNo(String num) {
	scrollAndEnterText(inputNumber, num);
}
public void enterRole(String role) {
	scrollAndEnterText(inputRole, role);
}
public void selectYearOfexp(String NoYR) {
	Select drop = new Select(yearDropDown);
	drop.selectByValue(NoYR);
}
























}
