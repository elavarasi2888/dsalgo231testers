Feature: Register functionality

  Background: The User on the Register page
   # Given User opens the browser
    #Given User enters the correct DS Algo portal URL
    #Given User clicks the Get Started button on DS Algo portal page
    #When User clicks on the Register link in the home page
   Given User is at the Register page

  Scenario: Verify that User is able to navigate on Login Page with login link from register page
    When User clicks Login Link in register page
    Then User should be redirected to Login Page

  Scenario Outline: User navigates to home page after registration with valid inputs
    When User clicks Register button after entering the Valid data from given sheetName "<sheetName>" and rowNumber <rowNumber>
    Then User should be redirected to Home Page of DS Algo with message "New Account Created. You are logged in"

    Examples:
      | sheetName      | rowNumber |
      | Register_valid | 0         |

  Scenario Outline: User enters invalid registration data for scenario "<ScenarioName>"
    When User clicks Register button after entering the data from given sheetName "<sheetName>" and rowNumber <rowNumber>
    Then The error message "<error_message>" appears below the "<field_name>"

    Examples:
      | sheetName        | rowNumber | field_name            | error_message                                           |
      | Register_invalid | 0         | Username              | Please fill out this field.                             |
      | Register_invalid | 1         | Password              | Please fill out this field.                             |
      | Register_invalid | 2         | Password confirmation | Please fill out this field.                             |
      | Register_invalid | 3         | Username              | Please fill out this field.                             |
      | Register_invalid | 4         | Password              | Please fill out this field.                             |
      | Register_invalid | 5         | Login                 | password_mismatch:The two password fields didn’t match. |
      | Register_invalid | 6         | Login                 | password_mismatch:The two password fields didn’t match. |
      | Register_invalid | 7         | Login                 | password_mismatch:The two password fields didn’t match. |
      | Register_invalid | 8         | Login                 | password_mismatch:The two password fields didn’t match. |
      | Register_invalid | 9         | Login                 | password_mismatch:The two password fields didn’t match. |
      | Register_invalid | 10        | Login                 | password_mismatch:The two password fields didn’t match. |
# Scenario Outline: Verify error message for empty fields during registration
# When User  clicks Register button after entering Username "<username>", Password "<password>", and Password Confirmation "<password_confirmation>"
# Then The error message "<error_message>" appears below the "<field_name>" textbox
# Examples:
# | username | password | password_confirmation | field_name            | error_message               |
# |          |          |                       | Username              | Please fill out this field. |
# | raj@123  |          |                       | Password              | Please fill out this field. |
# | raj@123  | hjkl@45  |                       | Password confirmation | Please fill out this field. |
# |          | hjkl@45  | hjkl@45               | Username              | Please fill out this field. |
# | raj@123  |          | hjkl@45               | Password              | Please fill out this field. |
# Scenario Outline: Verify error message for empty,invalid, mismatched, or pre-registered data
# When User clicks Register button after entering Username "<username>", Password "<password>", and Password Confirmation "<password_confirmation>"
# Then The error message "<error_message>" appears below the "<field_name>"
# Examples:
# | username | password | password_confirmation | error_message                                           | field_name            |
# | empty    | empty    | empty                 | Please fill out this field.                             | Username              |
# | raj@123  | empty    | empty                 | Please fill out this field.                             | Password              |
# | raj@123  | hjkl@45  | empty                 | Please fill out this field.                             | Password confirmation |
# | empty    | hjkl@45  | hjkl@45               | Please fill out this field.                             | Username              |
# | raj@123  | empty    | hjkl@45               | Please fill out this field.                             | Password              |
# | raj@123  | hjkl@45  | hj56                  | password_mismatch:The two password fields didn’t match. | Login                 |
# | raj%     | hjkl@45  | hjkl@45               | password_mismatch:The two password fields didn’t match. | Login                 |
# | raj@123  | 12345    | 12345                 | password_mismatch:The two password fields didn’t match. | Login                 |
# | raj@123  | hj7      | hj7                   | password_mismatch:The two password fields didn’t match. | Login                 |
# | raj@123  | raj@123  | raj@123               | password_mismatch:The two password fields didn’t match. | Login                 |
# | raj@123  | hjkl@45  | hjkl@45               | password_mismatch:The two password fields didn’t match. | Login                 |
