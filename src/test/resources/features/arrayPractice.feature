#Author: Ela

@arrayPractice
Feature: Practice Questions 

#non functional test cases

Background:
Given User clicks the Getting Started button in "Array" Panel
Given User is on "Array" page
Given User is on the Practice Questions page

Scenario Outline: Verify user is able to see Practice Questions topics link
When User clicks the practice questions links
Then User should see "<practice questions topics>" link of practice question page

Examples:

      | practice questions topics          		|
      | Search the array     					|
      |  Max Consecutive Ones  		    			|
      |  Find Numbers with Even Number of Digits |
      | Squares of a sorted Array 				|

Scenario Outline: Verify user is able to see Question and editor page 
When User clicks "<practice questions topics>" link
Then User should see "QUESTION", "Run" button and "Submit" button

Examples:

  	  | practice questions topics        		|
      | Search the array     					|
      |  Max Consecutive Ones  		    			|
      |  Find Numbers with Even Number of Digits |
      | Squares of a sorted Array 				|


#functional test cases
Scenario Outline: Verify user is able to navigate to practice questions page
When User clicks the practice questions links
Then User should be redirected to "<practice questions topics>" link of practice question page

Examples:

      | practice questions topics          		|
      | Search the array     					|
      |  Max Consecutive Ones  		    			|
      |  Find Numbers with Even Number of Digits |
      | Squares of a sorted Array 				|

Scenario Outline: Validate Array practice questions execution
    Given  User is on the practice question editor of "<QuestionName>"
    When User write the  "<CodeType>" python code in Editor and Click the Run button
    Then User should able to see "<ExpectedResult>"

    Examples:
      | QuestionName              | CodeType | ExpectedResult      |
      | Search the Array           | valid    | output displayed    |
      | Search the Array           | invalid  | error message       |
      | Search the Array  		   |empty code | alert with error message   |
      | Max Consecutive Ones       | valid    | output displayed    |
      | Max Consecutive Ones       | invalid  | error message       |
      | Max Consecutive Ones       | empty code | alert with error message   |
      |Find Numbers with Even Number of Digits| valid    | output displayed    |
      |Find Numbers with Even Number of Digits|  invalid  | error message       |
      |Find Numbers with Even Number of Digits| empty code | alert with error message   |
      | Squares of a Sorted Array  | valid  | output displayed       |
      | Squares of a Sorted Array  | invalid  | error message       |
       | Squares of a Sorted Array  | empty code | alert with error message   |
      
