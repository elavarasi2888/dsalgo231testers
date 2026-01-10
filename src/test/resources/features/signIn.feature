#Owner: Ela
@Regression @SignIn
Feature: Sign in functionality of DS Algo

  Background:
    Given User clicks the Sign in link on the home page

  Scenario Outline: Verify that user able to land on Home page after entering valid Username and Password fields
    When User clicks login button after entering valid data from the given "<ScenarioName>"
    Then User should land in Home Page with message "You are logged in"

    Examples:
      | ScenarioName                      |
      | valid username and valid password |

  Scenario Outline: Sign in with Invalid login data
    When User clicks login button after entering the data from given "<ScenarioName>"
    Then User get the error message "<ExpectedErrMsg>"

    Examples:
      | ScenarioName                        | Username    | Password   | ExpectedErrMsg                |
      | Empty username and empty password   |             |            | Please fill out this field.   |
      | Valid username and empty password   | application |            | Please fill out this field.   |
      | Empty username and valid password   |             | testers123 | Please fill out this field.   |
      | Invalid username and valid password | applicati   | testers123 | Invalid Username and Password |
      | Valid username and invalid password | application | testers    | Invalid Username and Password |

  Scenario: Verify that user is able to enter the register page if the user does not have an account
    When User clicks register button in the login page
    Then User should be redirected to Registration page

