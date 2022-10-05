@regression @productDetails
Feature: Navigate to the product details of Apple Cinema 30 and select several options


  @smoke
  Scenario Outline: Add different options of Apple Cinema 30" and check the prices are correctly calculated
    Given a new user opens the store web
    And the user navigates to the monitors product page
    And the customer selects the "Apple Cinema 30" monitor
    When the customer chooses the following options
      | radioOption   | checkBox   | color   | quantity   |
      | <radioOption> | <checkBox> | <color> | <quantity> |
    Then the shopping cart will show <quantity> products

    Examples:
      | radioOption | checkBox | color | quantity |
      | small       | 1,2      | Blue  | 5        |