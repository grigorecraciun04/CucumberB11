@amazon
Feature: Testing Amazon SingUp Functionality

  Background: navigate

  Scenario: Amazon signUp with DataBase
    When the user click sign in and create your amazon account button
    Then the user validate the header
      | Create account |
    And the user provide the information
      | greg           |
      | greg@gmail.com |
      | greg1234       |
      | greg1234       |