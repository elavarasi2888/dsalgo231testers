@DataStructure @ArrayPractice
Feature: Array Practice

  Background:
    Given User clicks the Get Started button from the Array panel


  Scenario Outline: Verify user is able to navigate to practice questions page
    Given User clicks Array topics link on the Array page for the Practice Questions
    When User clicks the practice questions from the topics in the array page
    Then User should see "<practice questions topics>" link on practice questions page

    Examples:
      | practice questions topics               |
      | Search the array                        |
      | Max Consecutive Ones                    |
      | Find Numbers with Even Number of Digits |
      | Squares of a Sorted Array               |


    # Functional test cases

  Scenario: Verify user is able to navigate to Practice Questions page of Array topics
    #  Given User clicks the Get Started button from the Array panel
    When User clicks the Arrays in Python link on the Array page
    Then User clicks PracticeQuestions link in the respective Array page
    Then User should be redirected to Practice Questions page of Array topics



  Scenario Outline: User navigates to practice question and practices
	 #Given user is in Array homepage
    #When User click practice questions from the topics in the array page

    When User navigates to the Array Practice page
    When User clicks "Search the array" in the practice page
    Then user clears the text in the editor area
    When User enters the python code for the following "<scenario>"
    When User clicks Run button
    Then User see the appropriate result
    Examples:
      | scenario     |
      | Valid Code   |
      | Invalid Code |
      | No Code      |

	# When user enters invalid Python Code
	# |print(|
	# Then user clicks run button and captures error message
	# Then user navigate back


