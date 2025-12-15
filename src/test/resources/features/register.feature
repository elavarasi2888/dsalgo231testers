Feature: Register functionality

  Background: The User on the Register page
  	Given User opens the browser
    Given User enters the correct DS Algo portal URL
    Given User clicks the Get Started button on DS Algo portal page
    When user clicks on the Register link in the home page
    Given User is at the Register page

  Scenario: User navigates to home page after registration with valid inputs
    When User  clicks Register button after entering valid username, password and password confirmation in textboxes
    Then User should be redirected to Home Page of DS Algo with message "New Account Created. You are logged in as <ID>"

  Scenario: Verify that User is able to navigate on Login Page with login link from register page
    When User clicks Login Link in register page
    Then User should be redirected to Login Page
   

  Scenario Outline: Verify error message for empty fields during registration
    When User  clicks Register button after entering Username "<username>", Password "<password>", and Password Confirmation "<password_confirmation>"
    Then The error message "<error_message>" appears below the "<field_name>" textbox

    Examples:
      | username | password | password_confirmation | field_name            | error_message               |
      |          |          |                       | Username              | Please fill out this field. |
      | raj@123  |          |                       | Password              | Please fill out this field. |
      | raj@123  | hjkl@45  |                       | Password confirmation | Please fill out this field. |
      |          | hjkl@45  | hjkl@45               | Username              | Please fill out this field. |
      | raj@123  |          | hjkl@45               | Password              | Please fill out this field. |

  Scenario Outline: Verify error message for invalid, mismatched, or pre-registered data
    When User  clicks Register button after entering Username "<username>", Password "<password>", and Password Confirmation "<password_confirmation>"
    #Then User clicks Register button
    Then The error message "<error_message>" appears

    Examples:
      | username | password | password_confirmation | error_message                                           |
      | raj@123  | hjkl@45  | hj56                  | password_mismatch:The two password fields didn’t match. |
      | raj%     | hjkl@45  | hjkl@45               | password_mismatch:The two password fields didn’t match. |
      | raj@123  | 12345    | 12345                 | password_mismatch:The two password fields didn’t match. |
      | raj@123  | hj7      | hj7                   | password_mismatch:The two password fields didn’t match. |
      | raj@123  | raj@123  | raj@123               | password_mismatch:The two password fields didn’t match. |
      | raj@123  | hjkl@45  | hjkl@45               | password_mismatch:The two password fields didn’t match. |
