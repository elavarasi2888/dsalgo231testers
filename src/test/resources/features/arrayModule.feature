# Author: Ela
@arrayModule
Feature: Array Module

  Background:
    Given User clicks the Getting Started button in "Array" Panel
    Given User is on "Array" page
    Given User is on the Practice Questions page

  # ---------------- Array Page Non-functional Tests ----------------

  Scenario Outline: Verify Array topics and headers are visible
    Then User should see "Array" header for Array page
    Then User should see Topics Covered header
    Then User should see "<Array topic>" link of Array page

    Examples:
      | Array topic              |
      | Arrays in Python         |
      | Arrays Using List        |
      | Basic Operations in Lists|
      | Applications of Array    |

  Scenario Outline: Verify topic page header and Try Here button
    When User clicks "<Array topic>" link on the Array page
    Then User should see "<Array topic>" header of the respective Array page
    Then User should see "Try here>>>" button on the Array page

    Examples:
      | Array topic              |
      | Arrays in Python         |
      | Arrays Using List        |
      | Basic Operations in Lists|
      | Applications of Array    |

  Scenario Outline: Verify user navigation to Array topic page
    When User clicks "<Array topic>" link on the Array page
    Then User should be directed to "<Array topic>" page containing "<Partial Link Text>"

    Examples:
      | Array topic              | Partial Link Text         |
      | Arrays in Python         | arrays-in-python          |
      | Arrays Using List        | Arrays Using List         |
      | Basic Operations in Lists| Basic Operations in Lists |
      | Applications of Array    | Applications of Array     |

  # ---------------- Practice Questions Non-functional Tests ----------------

  Scenario Outline: Verify Practice Question links visibility
    Then User should see "<practice question>" link of practice question page

    Examples:
      | practice question                 |
      | Search the array                  |
      | Max Consecutive Ones              |
      | Find Numbers with Even Number of Digits |
      | Squares of a sorted Array         |

  Scenario Outline: Verify Question editor and buttons visibility
    When User clicks "<practice question>" link
    Then User should see QUESTION, Run button and Submit button

    Examples:
      | practice question                 |
      | Search the array                  |
      | Max Consecutive Ones              |
      | Find Numbers with Even Number of Digits |
      | Squares of a sorted Array         |

  # ---------------- Practice Questions Functional Tests ----------------

  Scenario Outline: Verify user navigation to Practice Question page
    When User clicks "<practice question>" link
    Then User should be redirected to "<practice question>" link of practice question page

    Examples:
      | practice question                 |
      | Search the array                  |
      | Max Consecutive Ones              |
      | Find Numbers with Even Number of Digits |
      | Squares of a sorted Array         |

  Scenario Outline: Validate Practice Question execution
    Given User is on the practice question editor of "<practice question>"
    When User write the "<CodeType>" python code in Editor and Click the Run button
    Then User should able to see "<ExpectedResult>"

    Examples:
      | practice question                 | CodeType   | ExpectedResult              |
      | Search the array                  | valid      | output displayed            |
      | Search the array                  | invalid    | error message               |
      | Search the array                  | empty code | alert with error message    |
      | Max Consecutive Ones              | valid      | output displayed            |
      | Max Consecutive Ones              | invalid    | error message               |
      | Max Consecutive Ones              | empty code | alert with error message    |
      | Find Numbers with Even Number of Digits | valid      | output displayed    |
      | Find Numbers with Even Number of Digits | invalid    | error message       |
      | Find Numbers with Even Number of Digits | empty code | alert with error message|
      | Squares of a sorted Array         | valid      | output displayed            |
      | Squares of a sorted Array         | invalid    | error message               |
      | Squares of a sorted Array         | empty code | alert with error message    |
