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

    /*---------------------------------------Page objects----------------------------------------------*/

    // Add Candidate Button
    @FindBy(xpath = "/html/body/app-root/app-onboarding-list/div/div[2]/div/div/div/a[1]")
    private WebElement addCandiateButton;

    // Add Candidate Form
    @FindBy(xpath = "//*[@id=\"mat-dialog-0\"]")
    private WebElement addCandidateForm;

    // Candidate Name Field
    @FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid has-error ng-touched']")
    private WebElement candidateNameField;

    // Candidate Email Field
    @FindBy(xpath = "//input[@type='email']")
    private WebElement candidateEmailField;

    // Candidate Mobile Number Field
    @FindBy(xpath = "//input[@placeholder='081234 56789']")
    private WebElement candidateMobNoField;

    // Candidate Role Field
    @FindBy(xpath = "//input[@formcontrolname='role']")
    private WebElement candidateRoleField;

    // Candidate Experience in Year
    @FindBy(xpath = "//div[@class='form-group']//div[@class='form-group']/child::div[1]/descendant::div[2]")
    private WebElement candidateExpInYear;

    // List of Experience in Years
    @FindBy(xpath = "//span[@class=\"mat-option-text\"]")
    private List<WebElement> experianceListInYear;

    // Candidate Experience in Month
    @FindBy(xpath = "//div[@class='form-group']//div[@class='form-group']/following::div[1]/child::div/descendant::div[3]")
    private WebElement candidateExpInMonth;

    // List of Experience in Months
    @FindBy(xpath = "//span[@class='mat-option-text']")
    private List<WebElement> experianceListInMonth;

    // Current CTC Input Field
    @FindBy(xpath = "//input[@formcontrolname='curr_ctc']")
    private WebElement currentCTCInput;

    // Expected CTC Input Field
    @FindBy(xpath = "//input[@formcontrolname='expected_ctc']")
    private WebElement expectedCTCInput;

    // Notice Period Field
    @FindBy(xpath = "//div[@id='mat-select-value-7']")
    private WebElement noticePeriodField;

    // List of Notice Periods
    @FindBy(xpath = "//span[@class=\"mat-option-text\"]")
    private List<WebElement> noticePeriosList;

    // Save Button
    @FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-add-candidate/div/div/div[2]/form/div[11]/div/button")
    private WebElement saveButton;

    // Cancel Button
    @FindBy(xpath = "//a[contains(@class,'btn btn-danger border-0')]")
    private WebElement cancelButton;

    // Message Pop-up Element
    @FindBy(xpath = "//span[contains(@class,'mat-simple-snack-bar-content')]")
    private WebElement messagePopUp;

    // List of Candidate Names
    @FindBy(xpath = "//*[@id=\"hr-table\"]/tbody/tr/td[2]")
    private List<WebElement> candidateNames;

    // Alert Ok Button
    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    private WebElement alertOkBtn;

    // Forward Paginator Button
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

    // Click Add Candidate Button and open the form
    public void clickAddCandiateButton() {
        waitForElementToBeVisible(addCandiateButton); // Wait for the Add Candidate button to be visible
        scrollAndClick(addCandiateButton); // Scroll to the Add Candidate button and click it
        clickOnScreen(); // Click on the screen to dismiss any overlays
    }

    // Enter Candidate Name in the form
    public void enterCandidateName(String name) {
        clickOnScreen(); // Dismiss any overlays
        waitForElementToBeVisible(candidateNameField); // Wait for the Candidate Name field to be visible
        scrollAndEnterTextTo(candidateNameField, name); // Scroll to the Candidate Name field and enter the provided name
    }

    // Enter Candidate Email in the form
    public void enterCandidateEmail(String email) {
        scrollAndEnterTextTo(candidateEmailField, email); // Scroll to the Candidate Email field and enter the provided email
    }

    // Enter Candidate Phone Number in the form
    public void enterCandidatePhNo(String num) {
        scrollAndEnterTextTo(candidateMobNoField, num); // Scroll to the Candidate Phone Number field and enter the provided number
    }

    // Enter Candidate Role in the form
    public void enterCandidateRole(String role) {
        scrollAndEnterTextTo(candidateRoleField, role); // Scroll to the Candidate Role field and enter the provided role
    }

    // Select Candidate Year of Experience in the form
    public void selectCandidateYearOfexp(String year) {
        scrollAndClick(candidateExpInYear); // Scroll to the Candidate Year of Experience field and click it
        selectFromList(experianceListInYear, year); // Select the provided year of experience from the list
    }

    // Select Candidate Month of Experience in the form
    public void selectCandidateMonthOfexp(String month) {
        scrollAndClick(candidateExpInMonth); // Scroll to the Candidate Month of Experience field and click it
        selectFromList(experianceListInMonth, month); // Select the provided month of experience from the list
    }

    // Select Expected CTC in the form
    public void selectExpectedCTC(String expCTC) {
        scrollAndEnterTextTo(expectedCTCInput, expCTC); // Scroll to the Expected CTC field and enter the provided expected CTC
    }

    // Select Current CTC in the form
    public void selectCurrentCTC(String currCTC) {
        scrollAndEnterTextTo(currentCTCInput, currCTC); // Scroll to the Current CTC field and enter the provided current CTC
    }

    // Select Notice Period in the form
    public void selectNoticePeriod(String noticePeriod) {
        scrollAndClick(noticePeriodField); // Scroll to the Notice Period field and click it
        selectFromList(noticePeriosList, noticePeriod); // Select the provided notice period from the list
    }

    // Click on Save Button in the form
    public Boolean clickOnSaveButton() {
        try {
            scrollAndClick(saveButton); // Scroll to the Save button and click it
            waitForElementToBeVisible(messagePopUp); // Wait for the message pop-up to appear
            if (messagePopUp.getText().toLowerCase().equalsIgnoreCase("Candidate Added Successfully")) {
                return true; // If the success message is displayed, return true
            } else {
                return false; // If the success message is not displayed, return false
            }
        } catch (TimeoutException e) {
            System.out.println("The 'Save' button is not clickable!"); // Log if the 'Save' button is not clickable
            clickOnCancelButton(); // If not clickable, click on Cancel button
            return false; // Return false as save action failed
        }
    }

    // Click on Cancel Button in the form
    public void clickOnCancelButton() {
        scrollAndClick(cancelButton); // Scroll to the Cancel button and click it
    }

    /*----------------------------------Deactivate candidate-----------------------------*/

    // Click on Deactivate Button of Candidate
    public void clickOnDeactivateButtonOfCandidate(String employename) {
        for (WebElement cname : candidateNames) {
            if (cname.getText().toLowerCase().equalsIgnoreCase(employename)) {
                flashAndClick(cname.findElement(deactivateEmpButton));
                break;
            }
        }
    }

    // Accept Deactivate Candidate Dialogue
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

    // Click on Delete Button of Candidate
    public void clickOnDeleteButtonOfCandidate(String candidateName) {
        Boolean elementFound = false;
        for (WebElement cname : candidateNames) {
            System.out.println(cname.getText());
            if (cname.getText().toLowerCase().equalsIgnoreCase(candidateName)) {
                scrollAndClick(cname.findElement(deleteButton));
                elementFound = true;
                break;
            }
        }
        // If candidate not found on current page, navigate to the next page and try again
        if (!elementFound) {
            try {
                scrollAndClick(forwardPaginator); // Navigate to next page
                waitForMiliSec(500);
                clickOnDeleteButtonOfCandidate(candidateName); // Recursive call to continue searching on the next page
            } catch (TimeoutException e) {
                refreshDom();
                e.printStackTrace();
            }
        }
    }

    // Delete All Onboarded Candidate
    public void deleteAllOnboardedCandidate() {
        for (WebElement cname : candidateNames) {
            if (!candidateNames.isEmpty()) {
                scrollAndClick(cname.findElement(deleteButton));
                acceptDeleteCandidateDialogue();
                refreshDom();
                deleteAllOnboardedCandidate();
            }
        }
    }

    // Accept Delete Candidate Dialogue
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
