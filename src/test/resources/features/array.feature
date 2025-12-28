@DataStructure @Array
Feature: Array - non functional test case

  Background:
  Given User is at the Home page after sign-in
   Given User clicks Get Started button from "Array" panel
    
# non functional test cases

  Scenario: Verify that user is able to see the Array header
    When User clicks the Getting Started button in Array Panel
    Then User should see Array header

  Scenario: Verify that user is able to see the Array header
  # When User clicks the Getting Started button in Array Panel
    Then User should see "Array" header for Array page

  Scenario: Verify that user is able to see Topics covered header
  # When User clicks the Getting Started button in Array Panel
    Then User should see "Topics Covered" header for Array page

  Scenario Outline: Verify user is able to see Array topics link
  # When User clicks the Getting Started button in Array Panel
    Then User should see "<Array topics>" link of Array page

    Examples:
      | Array topics              |
      | Arrays in Python          |
      | Arrays Using List         |
      | Basic Operations in Lists |
      | Applications of Array     |
# Later

  Scenario Outline: Verify user is able to see Array topic page heading
    When User clicks "<Array topics>" link on the Array page
    Then User should see "<Array topics>" header of the respective Array page

    Examples:
      | Array topics              |
      | Arrays in Python          |
      | Arrays Using List         |
      | Basic Operations in Lists |
      | Applications of Array     |

  Scenario Outline: Verify Try here button is visible in the Array topics page
    When User clicks "<Array topics>" link on the Array page
    Then User should see "Try here>>>" button on the Array page

    Examples:
      | Array topics              |
      | Arrays in Python          |
      | Arrays Using List         |
      | Basic Operations in Lists |
      | Applications of Array     |
      
# Array pages functional test case

  Scenario Outline: Verify user is able to navigate to respective Array page
    When User clicks "<Array topics>" link on the Array page
    # Then User should be directed to "<topics in the Array page>" page of Array page
    Then User should be directed to "<Array topics>" page containing "<Partial Link Text>"

    Examples:
      | Array topics              | Partial Link Text         |
      | Arrays in Python          | arrays-in-python          |
      | Arrays Using List         | Arrays Using List         |
      | Basic Operations in Lists | Basic Operations in Lists |
      | Applications of Array     | Applications of Array     |
