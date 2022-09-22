@logOut @regression
Feature: Log Out after a customer has Logged In

  As a automation tester
  I want to ensure customer can Log out correctly
  So that he can finish the session safely

  @smoke
  Scenario: Customer logs out from web store
    Given an existing customer user opens the store web
    And the customer logs in
    When the customer logs out successfully
    Then the customer can see the log out page