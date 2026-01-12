#Owner: Ela
@Regression @SignIn
Feature: Sign-in test cases

  Background:
    Given User clicks the Sign in link on the home page

  Scenario: Verify that user able to land on Home page after valid sign-in
    When User clicks login button after entering valid credentials
    Then User should land in Home Page with message "You are logged in"

  Scenario Outline: Sign in with Invalid login data
    When User clicks login button after entering data from the given "<ScenarioName>"
    Then User get the error message "<ExpectedErrorMessage>"

    Examples:
      | ScenarioName                        | ExpectedErrorMessage          |
      | Empty username and empty password   | Please fill out this field.   |
      | Valid username and empty password   | Please fill out this field.   |
      | Empty username and valid password   | Please fill out this field.   |
      | Invalid username and valid password | Invalid Username and Password |
      | Valid username and invalid password | Invalid Username and Password |

  Scenario: Verify that user is able to enter the register page if the user does not have an account
    When User clicks register button in the login page
    Then User should be redirected to Registration page