@SignInPage
Feature: Sign in functionality of DS Algo

  Background: User clicks the Get Started button on DS Algo portal page
  # Given User opens the browser
    # Given User enters the correct DS Algo portal URL
    # Given User clicks the Get Started button on DS Algo portal page
    # Given Registered user clicks on the Sign in link in the home page
    Given User is on Sign in Page
# non functional test case------------------------------------

  Scenario: Verify the Username textbox in sign in page is visible
    Then Username textbox should be visible

  Scenario: Verify the Password textbox in sign in page is visible
    Then Password textbox should be visible

  Scenario: Verify the Login button is visible
    Then Login button should be visible

  Scenario: Verify there is a register button option in the sign in page
    Then Register option in sign in page should be visible
# Functional test case-----------------------------------------------

  Scenario Outline: Verify that user able to land on Home page after entering valid Username and Password fields
    When User clicks login button after entering valid username and valid password from the given sheet "<sheetName>"
    Then User should land in Home Page with message "You are logged in"
  # application and testers123 are valid username and password
  # dsalgo231 and automation2025# are valid username and password

    Examples:
      | sheetName   |
      | login_valid | 

  Scenario Outline: Sign in with Invalid data for scenario "<ScenarioName>"
    When User clicks login button after entering the data from given sheetName "<sheetName>"
    Then The error message "<expectedErrMsg>" appears below "<location>" textbox

    Examples:
      | ScenarioName                        | username    | password   | expectedErrMsg                | location |
      | Empty username and empty password   |             |            | Please fill out this field.   |          |
      | Valid username and empty password   | application |            | Please fill out this field.   |          |
      | Empty username and valid password   |             | testers123 | Please fill out this field.   |          |
      | Invalid username and valid password | applicati   | testers123 | Invalid username and password |          |
      | Valid username and invalid password | application | testers    | Invalid username and password |          |

  Scenario: Verify that user is able to enter the register page if the user does not have an account
    When User clicks register button
    Then User should be redirected to Registration page
