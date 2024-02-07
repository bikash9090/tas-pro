package com.taspro.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.taspro.base.PageBase;

public class OnBoardingPage extends PageBase {

	/*------------------------------------------------Page objects----------------------------------------------*/

	@FindBy(xpath = "/html/body/app-root/app-onboarding-list/div/div[2]/div/div/div/a[1]")
	private WebElement addCandiateButton;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid has-error ng-touched']")
	private WebElement inputName;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement inpuEmail;

	@FindBy(xpath = "//input[@placeholder='081234 56789']")
	private WebElement inputNumber;

	@FindBy(xpath = "//input[@formcontrolname='role']")
	private WebElement inputRole;
	
	@FindBy(xpath="//div[@class=\"mat-select-value ng-tns-c129-9\"]")
	private WebElement selectYr;

	@FindBy(xpath="//span[@class=\"mat-option-text\"]")
	private List <WebElement> yearDropDown;

	@FindBy(xpath="//div[@id='mat-select-value-7']")
	private WebElement selectMn;

	@FindBy(xpath="//mat-option[normalize-space()]")
	private List <WebElement> monthDropDown;

	@FindBy(xpath = "//input[@formcontrolname='curr_ctc']")
	private WebElement currentCTCInput;

	@FindBy(xpath = "//input[@formcontrolname='expected_ctc']")
	private WebElement expectedCTCInput;

	@FindBy(id= "mat-select-value-13")
	private WebElement OnnoticePeriodBox;

	@FindBy(xpath="//mat-option[@class=\"mat-option mat-focus-indicator ng-tns-c129-15\"]")
	private List <WebElement> selectNoticePeriod;
	

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/app-add-candidate/div/div/div[2]/form/div[11]/div/button")
	private WebElement submitOnBoardingForm;

	/*------------------------------------Page initialization----------------------------------------------*/
	public OnBoardingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*---------------------------------------Custom actions---------------------------------------------------*/
	public void clickAddCandiateButton() {

		waitForElemetTBeClickable(addCandiateButton);
		scrollAndClick(addCandiateButton);
	}

	public void enterCandidateName(String name) {
		scrollAndEnterText(inputName, name);
	}

	public void enterCandidateEmail(String email) {
		scrollAndEnterText(inpuEmail, email);
	}

	public void enterCandidatePhNo(String num) {
		scrollAndEnterText(inputNumber, num);
	}

	public void enterCandidateRole(String role) {
		scrollAndEnterText(inputRole, role);
	}

	public void selectCandidateYearOfexp(String NoYR) {
	selectYr.click();	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
for(WebElement nyr: yearDropDown)
{
if(nyr.getText().equalsIgnoreCase(NoYR)) {
	nyr.click();
	break;
}

	
	}
}

	public void selectCandidateMonthOfexp(String NoMN) {
		selectMn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(WebElement myr:monthDropDown) {
			if(myr.getText().equalsIgnoreCase(NoMN))
			{
				myr.click();
				break;
			}
		
		}
	}

	public void selectedExpectedCTC(String expctc) {
		expectedCTCInput.sendKeys(expctc);
	}

	public void selectedcurrentCTC(String currctc) {
		currentCTCInput.sendKeys(currctc);
	}

	public void selectNoticePeriod(String npday) {
		OnnoticePeriodBox.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(WebElement npdays: selectNoticePeriod) {
			if(npdays.getText().equalsIgnoreCase(npday)){
				npdays.click();
				break;
			}
			
		}
		
	}



}
