Feature: Home page test cases

  Background:
    Given User opens the browser
    Given User enters the correct DS Algo portal URL
    Given User clicks the Get Started button on DS Algo portal page
    Given User is at the Home page
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
    Then User should be able to see 7 Get Started buttons for the following panel items:
      | Data Structures-Introduction |
      | Array                        |
      | Linked List                  |
      | Stack                        |
      | Queue                        |
      | Tree                         |
      | Graph                        |

  Scenario: Verify user is able to see options for Data Structures dropdown on home page
    When User clicks the Data Structures dropdown
    Then User should able to see the following 6 options:
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |
# Functional tests

  Scenario Outline: Verify user able to see warning message by selecting an option from the drop down
    When User selects following "<option>" from the drop down
    Then User should able to see a warning message "You are not logged in"

    Examples:
      | option      |
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

  Scenario Outline: Verify user able to see warning message by clicking Get Started button in the panel
    When User clicks Get Started button of "<data-structure-item>" from panel
    Then User should able to see a warning message as "You are not logged in"

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
    When User clicks on the Register link in the home page
    Then User should navigate to the Register page

  Scenario: Verify user able to navigate to Sign in page
    When User clicks on the Sign in link in the home page
    Then User should navigate to the Sign in page
