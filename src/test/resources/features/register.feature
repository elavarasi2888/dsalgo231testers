@Register
Feature: Register functionality

  Background:
    Given User opens the browser
    Given User enters the correct DS Algo portal URL
    Given User clicks the Get Started button on DS Algo portal page
    Given User clicks on the Register link in the home page
    Given User is at the Register page

  Scenario: Verify that User is able to navigate on Login Page with login link from register page
    When User clicks Login Link in register page
    Then User should be redirected to Login Page

  Scenario: User navigates to home page after registration with valid inputs
    When User clicks Register button after entering the Valid data from given "<ScenarioName>"
    Then User should be redirected to Home Page of DS Algo with message "New Account Created. You are logged in"

  Scenario: Verify unsuccessful registration 
    When User clicks Register button with registered username as "raj@123" password as "hjkl@45" and password_confirmation as "hjkl@45"
    Then User gets a errormessage "User already Registered please SignIn"

  @wip_reg
  Scenario Outline: User enters invalid registration data
    When User clicks Register button after entering the data from given "<ScenarioName>"
    Then The error message "<error_message>" appears below the "<field_name>"

    Examples:
      | ScenarioName                                 | field_name            | error_message                                           |
      | AllEmptyFields                               | Username              | Please fill out this field.                             |
      | OnlyUsername                                 | Password              | Please fill out this field.                             |
      | EmptyPasswordConfirmation                    | Password confirmation | Please fill out this field.                             |
      | EmptyUsername                                | Username              | Please fill out this field.                             |
      | EmptyPassword                                | Password              | Please fill out this field.                             |
      | PasswordConfirmationAndPasswordNotMatching   | Login                 | password_mismatch:The two password fields didn’t match. |
      | InvalidUsername                              | Login                 | password_mismatch:The two password fields didn’t match. |
      | IntegerPasswordConfirmationAnd PasswordValue | Login                 | password_mismatch:The two password fields didn’t match. |
      | InvalidPasswordAndPasswordConfirmation       | Login                 | password_mismatch:The two password fields didn’t match. |
      | SameInputInAllField                          | Login                 | password_mismatch:The two password fields didn’t match. |
      | PreRegistertedData                           | Login                 | password_mismatch:The two password fields didn’t match. |
