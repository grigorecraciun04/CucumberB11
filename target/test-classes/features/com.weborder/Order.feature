
Feature: WebOrder Page Food Order
Background:
  Given the user is on webOrder homepage
  When the user select "Office" option
  And the user  is on the groupOrderPage
  And the user send invitees note "Test"
  And user sends invite list "greg@gmail.com" and "cristina@gmail.com"
  @smoke @Office @special
  Scenario: Validation of Food order For Office

#    When the user select "Office" option
#    And the user  is on the groupOrderPage
#    And the user send invitees note "Test"
#    And user sends invite list "greg@gmail.com" and "cristina@gmail.com"
    Then the user validates the "2012 EMPIRE BLVD" address
    And the user validates "View Group Order" text
    * the user validates total participants is 1
@MyHouse @regression @Smoke
  Scenario: Validation of Food order For Office
#    Given the user is on webOrder homepage
#    When the user select "Office" option
#    And the user  is on the groupOrderPage
#    And the user send invitees note "Test"
#    And user sends invite list "greg@gmail.com" and "cristina@gmail.com"
    * the user select "My House" option
    Then the user validates the "2112 EMPIRE BLVD" address
    And the user validates "View Group Order" text
    * the user validates total participants is 1