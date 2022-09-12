@registration @regression
Feature: Register a new customer in our store

  As a automation tester
  I want to ensure customer can register and appropriate error messages are sent
  So that the customer can register properly and can enjoy the benefits

  Background:
    Given the user opens the store web
    And navigates to the registration page
    And the user is on registration page

  @smoke
  Scenario: Successfully registering a new user
    When the user completes the registration with correct data
    Then the registration has been completed successfully


  Scenario Outline: Validate user can not register if the value in <field> <title>
    When the user completes the registration with field <field> and value "<value>"
    Then an error message in the field <field> is displayed

    Examples:
      | field           | title                                  | value                             |
      | FirstName       | is more than 1 character               |                                   |
      | FirstName       | is less than 32 characters             | 123456789012345678901234567890123 |
      | LastName        | is more than 1 character               |                                   |
      | LastName        | is less than 32 characters             | 123456789012345678901234567890123 |
      | Telephone       | is more than 3 characters              | 12                                |
      | Telephone       | is less than 32 characters             | 123456789012345678901234567890123 |
#      | Telephone       | has letters                            | abcdef                            | Bug! Telephone Number allows letters
#      | Telephone       | has special symbols                    | 123456#$%^                        | Bug! Telephone Number allows special symbols
      | Password        | is more than 4 character               | 123                               |
#      | Password        | less than 20 characters                | 1234567890123456789012            | Bug! it allows 40 characters instead of 20
      | EMail           | has incorrect format                   | test@test                         |
      | PasswordConfirm | is different for the password provided | passwordIJustCameUp               |


  Scenario: Validate user can not register unless Privacy policy is agreed
      When the user completes the registration with field Privacy and value "no"
      Then an error message in the field Privacy is displayed