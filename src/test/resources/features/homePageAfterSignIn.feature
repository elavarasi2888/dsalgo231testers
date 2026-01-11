#Owner: Showri
@HomePageSignIn @Regression
Feature: Home page functional test cases after user sign-in

  Background:
    Given User is at the Home page after sign-in

  Scenario Outline: Verify that user able to navigate to respective page from drop down
    When User selects following "<option>" from the drop down after sign-in
    Then User should able to navigate to "<corresponding-page>"
    Examples:
      | option      | corresponding-page |
      | Arrays      | array              |
      | Linked List | linked-list        |
      | Stack       | stack              |
      | Queue       | queue              |
      | Tree        | tree               |
      | Graph       | graph              |

  Scenario Outline: Verify that user able to navigate to respective page from the panel
    When User clicks Get Started button of "<data-structure-item>" from panel after sign-in
    Then User should able to navigate to "<corresponding-page>"

    Examples:
      | data-structure-item          | corresponding-page           |
      | Data Structures-Introduction | data-structures-introduction |
      | Array                        | array                        |
      | Linked List                  | linked-list                  |
      | Stack                        | stack                        |
      | Queue                        | queue                        |
      | Tree                         | tree                         |
      | Graph                        | graph                        |

  Scenario: Verify user can sign out successfully
    When User clicks the Sign out link
    Then User should be logged out with a message "Logged out successfully"