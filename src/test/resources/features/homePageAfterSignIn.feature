@HomePageSignIn
Feature: Home page functional test cases after user sign-in

  Background:
    Given User opens the browser
    Given User enters the correct DS Algo portal URL
    Given User clicks the Get Started button on DS Algo portal page
    Given User clicks on the Sign in link in the home page
    Given User clicks login button after entering valid username and valid password
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
