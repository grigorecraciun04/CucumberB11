Feature: Netflix login

  Scenario: Negative login
    When I navigate to Netflix login page
    And I enter not valid email
    And I enter not valid password
    And I click submit button
    Then I see Incorrect password element