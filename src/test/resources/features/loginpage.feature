Feature: Test Login Functionality

  Scenario Outline: Check login is successful with valid credentials
    Given User is on login page
    When User enter username and password
    And Click on Login button
    Then User is navigated to the DashBoardPage
