Feature: Test Login Functionality

  Scenario Outline: Check login is successful with valid credentials
    Given Hr is on the login page
    When User enter username as "<username>" and password as "<password>"
    And Click on Login button
    Then User is navigated to the DashBoardPage
    
    Examples:
		 | 							username 						| 				password 				 |
     | an2119@checkboxtechnology.com    | 			 Aniket@123    		 |
