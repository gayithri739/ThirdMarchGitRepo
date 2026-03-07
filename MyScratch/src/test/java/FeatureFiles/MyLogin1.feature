@Regrssion
Feature: Login functionality for Demo Guru99

  Scenario: Validate Login Functionality
    Given user launches the browser
    When user enters valid username and password
    And user clicks on login button
    And user logs into application
    Then validate that user navigates to homepage of the application
    And close the browser
