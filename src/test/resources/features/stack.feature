Feature: Stack test cases

Background: User clicks Get Started button on Homepage for Stack tile#
#Given User is on Stack page
Given User clicks the Getting Started button in "Stack" Panel
Given User is on "Stack" page

#non functional test cases

Scenario: Verify that user is able to see the Stack header
   # When user clicks the Getting Started button in Stack panel
    Then User should see "Stack" header for Stack page

Scenario: Verify that user is able to see Topics covered header
#When user clicks the Getting Started button in Stack Panel
Then User should see "Topics Covered" header for Stack page

Scenario Outline: Verify user is able to see Stack topics link
#When user clicks the Getting Started button in Stack Panel
Then User should see "<Stack topics>" link of Stack page

Examples:

      | Stack topics            |
      | Operations in Stack     |
      | Implementation  		    |
      | Applications       		|
      
Scenario Outline: Verify user is able to see Stack topic page heading
    Given user is on the Stack page
    When user clicks "<Stack topics>" link on the Stack page
    Then user should see "<Stack topics>" header of the respective Stack page

Examples:

      | Stack topics            |
      | Operations in Stack     |
      | Implementation  		    |
      | Applications       		|
      
Scenario Outline: Verify Try here button is visible in the Stack topics page
    When user clicks "<Stack topics>" link on the Stack page
    Then User should see "Try here>>>" button on the Stack page

    Examples:

     | Stack topics            |
      | Operations in Stack    |
      | Implementation  		   |
      | Applications       	   |
      
      
# functional test cases

  Scenario Outline: Verify user is able to navigate to respective Stack page
    When user clicks "<Stack topics>" link on the Stack page
    Then user should be directed to "<topics in the stack page>" page of Stack page

    Examples:

      | Stack topics            |  topics in the stack page	|
      | Operations in Stack    |   Operations in Stack		|
      | Implementation  		   |Implementation				|
      | Applications       	   | Applications				|



  
