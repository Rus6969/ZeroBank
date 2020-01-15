Feature: Statements and Documents details

  @wip
  Scenario Outline: Recent statements per year
    Given User is on Login page
    When the users enters the valid credentials
    Then the user should be able to login
    When the user click on Online Statements
    And  the user selects a Year<year>
    Then  <count> should be displayed for that year

    Examples:
      | year | count |
      | 2009 | 2     |
      | 2010 | 2     |
      | 2011 | 2     |
      | 2012 | 1     |