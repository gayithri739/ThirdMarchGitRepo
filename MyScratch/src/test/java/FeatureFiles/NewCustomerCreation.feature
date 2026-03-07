@smoke
Feature: Creation of new customer

  Background: 
    Given user opens the browser URL
    And user enters the username as "mngr655006"
    And user enters the password as "Avegujy"
    And user clicks on login button
    Then validate that user navigates to homepage of the application

  Scenario Outline: Create new customer with all details
    Given user is on the homepage of an application
    And user clicks on New Customer link
    And user enters the customer name as "<cust_name>"
    And user selects gender
    And user enters date of birth as "<dob>"
    And user enters address as "<address>"
    And user enters city as "<city>"
    And user enters state as "<state>"
    And user enters pin as "<pin>"
    And user enters mobile as "<mobile>"
    And user enters email as "<email>"
    And user enters password as "<password>"
    When user clicks on submit button
    Then a new customer will be created
    And users capture the customer id
    When user stores generated customer id in excel
    And user clicks on New Account link
    Then user creates new account using customer id from excel

    Examples: 
      | cust_name | dob        | address | city     | state | pin    | mobile     | email             | password |
      | Harry     | 05-06-1993 | MGroad  | Banglore | KR    | 560002 | 9887456788 | abc2285@gmail.com | agfthj   |
