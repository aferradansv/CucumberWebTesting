Feature: Register a new customer in our store


  @run
  Scenario: Successfully navigating to the registration page
    Given the user is on the home page
    When I navigate to the registration page
    Then the user is on registration page