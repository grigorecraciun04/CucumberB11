Feature: Login Functionality for WebOrder Page
Background:
  Given the user navigate to the WebOrder website
  @smoke @regression
  Scenario: Validation of WebOrder Positive Scenario
#    Given the user navigate to the WebOrder website
    When the user provide credentials
    Then the user is on the home page

    Scenario: Validation of WebOrder Login Negative Scenario 1
#      Given the user navigate to the WebOrder website
      When the provide correct username and wrong password
      Then the user validates the "Sign in Failed" error message

  Scenario: Validation of WebOrder Login Negative Scenario 2
#    Given the user navigate to the WebOrder website
    When the provide wrong "greg" and wrong "craciun"
   Then the user validates the "Sign in Failed" error message
@smoke @regression
  Scenario: Validation of WebOrder Login Negative Scenario
#    Given the user navigate to the WebOrder website
    When the provide nothing for user name and nothing for password
   Then the user validates the "Sign in Failed" error message

