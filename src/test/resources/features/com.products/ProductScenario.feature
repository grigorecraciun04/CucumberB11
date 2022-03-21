Feature: Validation of Product

  Scenario: Validation of New Product Creation
    Given the user navigate to product website homepage and click orderButton
    When the user enters the product information "MyMoney" and "4"
    And the user enters the address information "Greg Xmas","Devon","Des Planes","IL","60054"
    And the user enters the card information "Visa","123456789","04/04"
    Then the user validats success message
    And the user validate product details "Greg Xmas", "MyMoney", "4", "Devon", "Des Planes", "IL", "60054", "Visa", "123456789", "04/04"

@failedtest
  Scenario Outline: Validation of New Product Creation
    Given the user navigate to product website homepage and click orderButton
    When the user enters the product information "<productName>" and "<quantity>"
    And the user enters the address information "<customerName>","<street>","<city>","<state>","<zipcode>"
    And the user enters the card information "<cartType>","<cardNumber>","<expireDate>"
    Then the user validats success message
    And the user validate product details "<customerName>", "<productName>", "<quantity>", "<street>", "<city>", "<state>", "<zipcode>", "<cartType>", "<cardNumber>", "<expireDate>"
    Examples:
      | productName | quantity | customerName | street | city      | state | zipcode | cartType | cardNumber | expireDate |
      | MyMoney     | 4        | greg         | Devon  | DesPlanes | IL    | 60054   | Visa     | 123456789  | 04/04      |