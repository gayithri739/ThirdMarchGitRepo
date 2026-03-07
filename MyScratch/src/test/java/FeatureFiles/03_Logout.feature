@sanity
Feature: Logout functionality

  Scenario: Verify user can logout successfully
    Given user launches the browser
    And user logs into application
    When user logs out after account creation
    Then browser is closed
