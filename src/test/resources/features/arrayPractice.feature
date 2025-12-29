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
