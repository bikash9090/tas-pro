Feature: To test the forgot password functionality

  Background: 
    Given I landed on the Homepage

  Scenario: To test the forgot password link
    Given User is on the login page
    When User clicks on the forgot password button
    Then User is redirected to the forgot password page

  Scenario: To verify forgot password recovery link sent to user
    Given User is on the login page
    When User clicks on the forgot password button
    And user enters the recovery email
    Then forgot password mail link is sent

  Scenario: To verify clicking of forgot password button
    Given User is on the login page
    When User clicks on the forgot password button
    Then SendLink button is displayed
