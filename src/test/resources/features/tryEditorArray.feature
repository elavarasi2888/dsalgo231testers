Feature: Try Editor functionality 
  
  Background:
    Given User is on the array page    
    Given User clicks on "Try Here" on the respective Array pages

#try editor non functional test case

Scenario:Verify Run button is visible in the try Editor page for Arrays pages
	Given User is on the "<array topics>" page
	When User clicks Try Here button
	Then User should see Run button in the try editor page

Examples:
 	  | Array topics            		|
      | Arrays in Python    			|
      | Arrays Using List  		    |
      | Basic Operations in Lists    |
      | Applications of Array		|

#try editor functional test case

Scenario:Verify user is able to navigate to try Editor page for Arrays pages 
	Given User is on the "<array topics>" page
	When User clicks Try Here button
	Then User should be redirected to try Editor page

Examples:
 	  | Array topics            		|
      | Arrays in Python    			|
      | Arrays Using List  		    |
      | Basic Operations in Lists    |
      | Applications of Array		|

Scenario Outline:Validate python code execution
 	Given User is on the Try Editor page
 	When  User write the  "<CodeType>" python code in Editor and Click the Run button
 	Then User should able to see "<ExpectedResult>"
 
 Examples:
 	
 	  | CodeType | ExpectedResult      |
 	  | valid    | output displayed    |
      | invalid  | error message       |
      |empty code| alert with error message   |