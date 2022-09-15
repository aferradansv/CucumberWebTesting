@logIn @regression
Feature: Log In with an existing customer in our store

  As a automation tester
  I want to ensure customer can Log in correctly in the store
  So that he can place orders and enjoy all our benefits

  Background:
    Given an existing customer user opens the store web
    And navigates to the login page
    And the user is on login page

    @smoke
  Scenario: Validate user can log in the web store
    When the user introduces valid credentials
    Then the user can see My personal account page

  Scenario: Validate user can not log with a non-registered user
    When the user introduces valid password and wrong username
    Then a error message is shown to the customer and user can not log In

  Scenario: Validate user can not log with incorrect password
    When the user introduces valid username and wrong password
    Then a error message is shown to the customer and user can not log In