Feature: HR Onboards Candidates

  Scenario: HR logs in and adds a candidate for onboarding
    Given the HR is on the login page
    When the HR enters their email and password and logs in
    Then the HR should be directed to the dashboard
    And the HR clicks on the onboarding tab
    And the HR clicks on the add candidate button
    And the HR waits for the page to load

  Scenario Outline: HR onboards a candidate from Excel sheet
    Given the HR is logged in and on the onboarding page
    When the HR enters candidate details and add them from the Excel sheet "<Excel File>" with sheet "<Sheet Name>"
    Then the candidate should be successfully added
    And the HR refreshes the page
    And the HR clicks on the add candidate button again