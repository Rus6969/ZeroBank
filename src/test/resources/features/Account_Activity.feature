Feature: Account Activity options

  Scenario: Account Activity page should have the title "Zero – Account activity".
    Given User is on Login page
    And the users enters the valid credentials
    When User click on Account activity tab
    Then  page should have the title Zero – Account activity


  Scenario: Account drop down default option should be Savings
    Given User is on Login page
    And the users enters the valid credentials
    When User click on Account activity tab
    Then default option should be Savings


  Scenario: Account drop down should have the following options
    Given User is on Login page
    And the users enters the valid credentials
    When User click on Account activity tab
    Then  drop Down option should be :
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |


  Scenario: Transactions table should have column names Date, Description, Deposit, Withdrawal.
    Given User is on Login page
    And the users enters the valid credentials
    When User click on Account activity tab
    Then Transaction table options are:
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |


  Scenario: Brokerage account redirect
    Given User is on Login page
    When the users enters the valid credentials
    Then the user clicks on Brokerage link on the Account Summary page
    Then  page should have the title Zero – Account activity
    And Account drop down should have Brokerage selected


  Scenario: Scenario: Search date range
    Given User is on Login page
    And the users enters the valid credentials
    When User click on Account activity tab
    And  User click on Find Transactions tab
    When the user enters date range from '2012-09-01' to '2012-09-06' and click search
    Then results table should only show transactions dates between '2012-09-01' to '2012-09-06'
    And the results should be sorted by most recent date


  Scenario: Search description
    Given User is on Login page
    And the users enters the valid credentials
    When User click on Account activity tab
    And  User click on Find Transactions tab
    When user adds description
    Then results table should only show descriptions containing “ONLINE”
    Then results table should only show descriptions containing “OFFICE”


  Scenario: Search description caseignore
    Given User is on Login page
    And the users enters the valid credentials
    When User click on Account activity tab
    And  User click on Find Transactions tab
    When user adds description
    When the user enters description “online”


  Scenario: Type
    Given User is on Login page
    And the users enters the valid credentials
    When User click on Account activity tab
    And  User click on Find Transactions tab
    And User click find
    Then result shoud contain at least one result under deposit and under withdrow
    When user selects type “Deposit”
    Then result shoud contain at least one result under deposit but  withdrawal should be empty
    When user selects type “Withdrawal”
    Then results table should show at least one result under Withdrawal But results table should show no result under Deposit














