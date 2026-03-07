@sanity
Feature: New account creation

  Scenario: New account creation from excel data
    Given user is on the homepage of an application
    And user clicks on New Account link
    Then user creates new account using customer id from excel
	