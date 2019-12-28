Feature:authorized users should be able to login to the application


  Scenario:user logs in with valid credentials, Account summary page should be displayed
    Given User is on Login page
    When the users enters the valid credentials
    Then the user should be able to login



  Scenario: Users with wrong username or wrong password should not be able to login.
    Given User is on Login page
    When the users enters the INvalid credentials


