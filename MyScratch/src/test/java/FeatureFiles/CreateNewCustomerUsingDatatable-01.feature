@smoke
Feature: Add New Customer
  Scenario: Create New Customer using DataTable
    Given user launches the browser
    And user logs into application
    When user navigates to new customer page
    And user enters customer details
      | name     | Gayithri   |
      | gender   | female     |
      | dob      | 05-06-1998 |
      | address  | MG Road    |
      | city     | Bangalore  |
      | state    | Karnataka  |
      | pin      |     560001 |
      | mobile   | 9876543210 |
      | password | test@123   |
    Then customer should be created successfully
