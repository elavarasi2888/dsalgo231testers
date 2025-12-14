Feature: Try Editor test cases

  Background:
    Given User is on the tryEditor page
    
# Non-Functional test

  Scenario: Verify Run button is visible in the try Editor page
    Then User should see Run button in the try editor page
    
# Functional tests

  Scenario Outline: Verify user receives correct result for python code in the try editor page
    When User write the "<code>" in the try editor page
    When User clicks the Run button
    Then User see appropriate "<result>"

    Examples:
      | code                            | result |
      | 'print(invalid code)'           | alert  |
      | 'print("sum of 10 and 20: 30")' | output |
      |                                 | alert  |
