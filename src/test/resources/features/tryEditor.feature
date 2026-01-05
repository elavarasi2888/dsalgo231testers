#Owner: Showri
@TryEditor @Regression
Feature: Try Editor test cases

  Background:
    Given User is on the tryEditor page

# Non-Functional test

  Scenario: Verify Run button is visible in the try Editor page
    Then User should see Run button in the try editor page

 #Functional tests

  Scenario Outline: Verify user receives correct result for python code in the try editor page
    When User write the code for following "<scenario>" in the try editor page
    When User clicks the Run button
    Then User see appropriate result

    Examples:
      | scenario     |
      | Valid Code   |
      | Invalid Code |
      | No Code      |