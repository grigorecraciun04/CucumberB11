Feature: Etsy search functionality

  Background:
  Given the user navigate to "https://www.etsy.com/"

  Scenario: Validation of etsy search Hat
    When  the user search with "Hat"
    Then  the user validate the title "Hat | Etsy"

  Scenario: Validation of etsy search Key
    When  the user search with "Key"
    Then  the user validate the title "Key | Etsy"

  Scenario: Validation of etsy search Pin
    When  the user search with "Pin"
    Then  the user validate the title "Pin | Etsy"