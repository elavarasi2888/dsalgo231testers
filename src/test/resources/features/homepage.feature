Feature: Home page test cases

  Background: User clicks the Get Started button on DS Algo portal page
    Given User opens the browser
    Given user enters the correct DS Algo portal URL
    Given user clicks the Get Started button on DS Algo portal page
    Given user is at the Home page
# Non-Functional tests

  Scenario: Verify NumpyNinja heading in homepage is visible
    Then NumpyNinja heading should be visible

  Scenario: Verify the Register link in homepage is visible
    Then Register link should be visible

  Scenario: Verify the Sign in link in home page is visible
    Then Sign in link should be visible

  Scenario: Verify the Datastructures dropdown visible
    Then Datastructures drop down should be visible

  Scenario: Verify the Get Started buttons visible on the home page
    Then User should be able to see 7 Get Started buttons for the folowing panel items:
      | 1 | Data Structures-Introduction |
      | 2 | Array                        |
      | 3 | Linked List                  |
      | 4 | Stack                        |
      | 5 | Queue                        |
      | 6 | Tree                         |
      | 7 | Graph                        |

  Scenario: Verify user is able to see options for Data Structures dropdown on home page
    When User clicks the Data Structures dropdown
    Then User should able to see the following 6 options:
      | 1 | Arrays       |
      | 2 | Linked List |
      | 3 | Stack       |
      | 4 | Queue       |
      | 5 | Tree        |
      | 6 | Graph       |
      
# Functional tests

  Scenario Outline: Verify user able to see warning message by selecting an option from the drop down
    When user selects following "<option>" from the drop down
    Then user should able to see a warning message "You are not logged in"

    Examples:
      | option      |
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

  Scenario Outline: Verify user able to see warning message by clicking Get Started button in the panel
    When user clicks Get Started button of "<data-structure-item>" from panel
    Then user should able to see a warning message as You are not logged in

    Examples:
      | data-structure-item          |
      | Data Structures-Introduction |
      | Array                        |
      | Linked List                  |
      | Stack                        |
      | Queue                        |
      | Tree                         |
      | Graph                        |

  Scenario: Verify user able to navigate to register page
    When user clicks on the Register link in the home page
    Then user should navigate to the Register page

  Scenario: Verify user able to navigate to Sign in page
    When user clicks on the Sign in link in the home page
    Then user should navigate to the Sign in page
