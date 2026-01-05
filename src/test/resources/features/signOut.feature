#Owner: Ela
@Regression @DataStructure @SignOut
Feature: Sign out functionality

  Background:
    Given User is at Home page after Sign in

  Scenario: Verify user can sign out successfully
    When User clicks the Sign out link 
    Then User should be logged out with a message Logged out successfully
    Then User should see the Sign in link

   