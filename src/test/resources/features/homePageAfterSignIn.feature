Feature: Home page functional test case after sign in

  Background: User sign in to dsAlgo Portal
   	Given User opens the browser
    Given User enters the correct DS Algo portal URL
    Given User clicks the Get Started button on DS Algo portal page
   # Given User has signed In 
	Given User navigates to Home page

  Scenario Outline: Verify that user able to navigate to respective page from drop down
    Given user is at the Home page
    When user selects "<option>" from the drop down
    Then User should able to navigate to the corresponding page

    Examples:
      | option      |
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

  Scenario Outline: Verify that user able to navigate to respective page from the panel
    Given user is at the Home page
    When user clicks "<data-structure-item>" from the panel
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
