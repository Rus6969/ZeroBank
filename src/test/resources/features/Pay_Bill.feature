Feature: Pay Bills


  Scenario: Account Activity page should have the title Zero – Pay Bills.
    Given User is on Login page
    When the users enters the valid credentials
    Then the user click on Pay Bills
    And page should have the title Zero – Pay Bills


  Scenario:When user completes a successful Pay operation, The payment was successfully submitted
    Given User is on Login page
    When the users enters the valid credentials
    Then the user click on Pay Bills
    Then add any amount to amount box
    Then choose date
    And add description
    When click Pay button
    Then The payment was successfully submitted. should be displayed

  Scenario: When user tries to make a payment without entering the amount or date, Please fill out this field message! should be displayed.
    Given User is on Login page
    When the users enters the valid credentials
    Then the user click on Pay Bills
    Then add any amount to amount box
    When click Pay button
    Then Please fill out this field message! should be displayed.


  Scenario: Amount field should not accept alphabetical or special characters.
    Given User is on Login page
    When the users enters the valid credentials
    Then the user click on Pay Bills
    Then  the user enters special charecters in amount box
    Then choose date
    And add description
    When click Pay button
    Then The payment was successfully submitted. should NOT be displayed

  Scenario: Date field should not accept alphabetical characters.
    Given User is on Login page
    When the users enters the valid credentials
    Then the user click on Pay Bills
    Then add any amount to amount box
    Then the user enters special charecters in date box
    When click Pay button
    Then The payment was successfully submitted. should NOT be displayed

  Scenario: add new  payee under pay bills
    Given User is on Login page
    When the users enters the valid credentials
    Then the user click on Pay Bills
    Then the user clicks on Add new Payee
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks  |
      | Payee Address | 100 Same st, Anytown, USA, 10001          |
      | Account       | Checking                                  |
      | Payee details | XYZ account                               |
      | XYZ account   | successfully created. should be displayed |
    Then the Message The new Payee The Law Offices of Hyde, Price & Scharks should be displayed.

  Scenario: Available currencies
    Given User is on Login page
    When the users enters the valid credentials
    Then the user click on Pay Bills
    Then the user click on Purchase foreign currency
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |

  Scenario: Error message for not selecting currency
    Given User is on Login page
    When the users enters the valid credentials
    Then the user click on Pay Bills
    Then the user click on Purchase foreign currency
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed














