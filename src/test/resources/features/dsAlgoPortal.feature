Feature: Ds Algo portal 

Background:
	Given User opens the browser
    When User enters the correct DS Algo portal URL
   

  Scenario: Verify that User is able to open the DS Algo Portal
     Then User should able to land on DS Algo portal

  Scenario: Verify that Get started button is visible on DS Algo Portal page
    Then User should able to see Get Started button on DS Algo Portal page

  Scenario: Verify that User is able to see the heading on DS Algo Portal page
    Then User should able to see Preparing for the Interviews heading

  Scenario: Verify that User is able to see the paragraph on DS Algo Portal page
     Then User should able to see You are at the right place paragraph

#Functional scenario
 Scenario: Verify that user able to navigate to Home page
    When User clicks the Get Started button on DS Algo portal page
    Then User navigates to Home page   