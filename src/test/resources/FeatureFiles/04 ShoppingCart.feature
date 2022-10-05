@regression @shoppingCart
Feature: Adding and removing products to the customer's shopping cart

  As a automation tester
  I want to ensure customer add and remove products to the shopping cart
  So that the correct items and prices have been displayed to the customer

  @smoke
  Scenario: Adding 1 product to the shopping cart
    Given a new user opens the store web
    When the user navigates to the Phones & PDAs product page
    And the customer adds 1 product in the position 1 to the shopping cart
    Then the shopping cart will show 1 product
    And the prices are calculated correctly


  Scenario: Adding 2 products to the shopping cart
    Given a new user opens the store web
    When the user navigates to the Phones & PDAs product page
    And the customer adds 2 product in the position 1 to the shopping cart
    Then the shopping cart will show 2 products
    And the prices are calculated correctly


  Scenario: Adding 2 different products to the shopping cart
    Given a new user opens the store web
    When the user navigates to the Phones & PDAs product page
    And the customer adds 2 product in the position 1 to the shopping cart
    And the customer adds 1 product in the position 2 to the shopping cart
    Then the shopping cart will show 3 products
    And the prices are calculated correctly


  Scenario: Customer removes a product from the shopping cart
    Given a new user opens the store web
    And the user navigates to the Phones & PDAs product page
    And the customer adds 1 product in the position 1 to the shopping cart
    And the customer adds 1 product in the position 0 to the shopping cart
    And the shopping cart will show 2 products
    When the customer removes 1 product
    Then the shopping cart will show 1 products


  Scenario: Customer changes the amount of products in Shopping Cart
    Given a new user opens the store web
    And the user navigates to the Phones & PDAs product page
    And the customer adds 1 product in the position 1 to the shopping cart
    And the shopping cart will show 1 products
    When the customer changes the amount to 10
    Then the shopping cart will show 10 products

  Scenario: Existing customers will have the shopping cart saved for next session
    Given an existing customer user opens the store web
    And the customer logs in
    And the user navigates to the Phones & PDAs product page
    And the customer adds 2 product in the position 1 to the shopping cart
    When the customer logs out successfully
    And the customer logs in
    Then the shopping cart will still show the 2 products selected

  Scenario: Navigate from the Shopping Cart to the Checkout with anonymous customer
    Given a new user opens the store web
    And the user navigates to the Phones & PDAs product page
    And the customer adds 1 product in the position 1 to the shopping cart
    And the shopping cart will show 1 products
    When The customer clicks checkout Button
    Then the checkout page is displayed
    And the checkout options panel is expanded

  Scenario: Navigate from the Shopping Cart to the Checkout with existing customer
    Given an existing customer user opens the store web
    And the customer logs in
    And the user navigates to the Phones & PDAs product page
    And the customer adds 1 product in the position 1 to the shopping cart
    And the shopping cart will show 1 products
    When The customer clicks checkout Button
    Then the checkout page is displayed
    And the billing options panel is expanded