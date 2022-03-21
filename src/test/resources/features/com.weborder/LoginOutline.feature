
Feature: Login Functionality for WebOrder Page

  Background:
    Given the user navigate to the WebOrder website

  Scenario: Validation of WebOrder Positive Scenario
    When the user provide credentials
    Then the user is on the home page

  Scenario Outline: Validation of WebOrder Login Negative Scenarios
    When the provide wrong "<wrongpassword>" and wrong "<wrongusername>"
    Then the user validates the "<errormessage>" error message
    Examples:
      | wrongpassword | wrongusername | errormessage   |
      | greg          | craciun       | Sign in Failed |
      | greg2         | damir         | Sign in Failed |
      | greg3         | misha         | Sign in Failed |
      | greg4         | vilcu         | Sign in Failed |
      | greg5         | potlog        | Sign in Failed |
      | greg6         | ghiletchi     | Sign in Failed |
      | greg7         | andriesh      | Sign in Failed |
      | greg8         | petrov        | Sign in Failed |


