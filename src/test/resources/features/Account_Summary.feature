Feature: Account summary page


  Scenario: Account Summary options
    Given User is on Login page
    And the users enters the valid credentials
    Then Account summary page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts table must have columns:
    Given User is on Login page
    And the users enters the valid credentials
    Then Credit Accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |

