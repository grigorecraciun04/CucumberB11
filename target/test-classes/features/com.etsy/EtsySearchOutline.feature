Feature: Etsy search functionality

  Background:
    Given the user navigate to "https://www.etsy.com/"

  @smoke
  Scenario Outline: Validation of etsy search value
    When  the user search with "<searcvalue>"
    Then  the user validate the title "<titlevalidation>"
    Examples:
      | searcvalue | titlevalidation |
      | Hat        | Hat \| Etsy     |
      | Key        | Key \| Etsy     |
      | Pin        | Pin \| Etsy     |