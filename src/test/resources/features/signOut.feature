@Regression @SignOutPage
Feature: Sign out functionality
# Functional test case

  Background:
    Given User is in the Home page after Sign in

  Scenario: Verify that user able to sign out successfully
    When User clicks "Sign out"
    Then User should be redirected to home page with message "Logged out successfully"
