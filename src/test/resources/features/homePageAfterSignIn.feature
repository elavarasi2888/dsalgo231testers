Feature: Home page functional test cases after user sign-in

  Background:
    Given User opens the browser
    Given User enters the correct DS Algo portal URL
    Given User clicks the Get Started button on DS Algo portal page
    Given User clicks on the Sign in link in the home page
    Given User clicks login button after entering valid username and valid password
    Given User is at the Home page after sign-in

  Scenario Outline: Verify that user able to navigate to respective page from drop down
    When User selects an "<option>" from the drop down
    #Then User should able to navigate to the corresponding page (TBC)

    Examples:
      | option      |
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

  Scenario Outline: Verify that user able to navigate to respective page from the panel
    #When User clicks "<data-structure-item>" from the panel
    When User clicks the Getting Started button in "<data-structure-item>" Panel
    Then User should able to navigate to the corresponding page

    Examples:
      | data-structure-item          |
      | Data Structures-Introduction |
      | Array                        |
      | Linked List                  |
      | Stack                        |
      | Queue                        |
      | Tree                         |
      | Graph                        |
