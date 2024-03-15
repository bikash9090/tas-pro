Feature: DashboardPage Functionality Test

  Scenario: Verify profile icon on dashboard page
    Given User is on the login page
    When User enters their email ID and password
    And User clicks on the login button
    Then User should navigate to the dashboard page
    And User checks if the profile icon is visible
    Then The dashboard page open successfully
