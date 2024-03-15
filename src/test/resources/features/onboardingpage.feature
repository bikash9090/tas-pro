Feature: Candidate Onboarding Process by HR

  Scenario Outline: Onboard a new candidate
    Given HR on the candidate onboarding page
    When HR enter candidate details from "<dataSheet>"
    And HR click on the save button
    Then the candidate should be successfully saved
    And HR should be able to add another candidate

    Examples: 
      | dataSheet   |
      | OnBoardData |
