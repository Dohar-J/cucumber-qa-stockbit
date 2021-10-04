Feature: Search

  Scenario Outline: Validate user can search
    Given user open chrome and start application for search
    When user click on log in button for sign in
    Then user verify login page is visible
    When user fill valid username and password valid
    And user click login button
    Then user can see pop up choose avatar if possible
    Then user can see stream page
    And user input BBRI in searchbox
#    And user input <search> in searchbox
    Then user can see the result of BBRI
#    Then user can see the result of <search>

    Examples:
    | search |
    |  BBRI  |
#    |  BBCA  |
#    |  BRIS  |
#    |  AGRO  |


  Scenario: User can see Recent Searches in search box
    Given user open chrome and start application for search
    When user click on log in button for sign in
    Then user verify login page is visible
    When user fill valid username and password valid
    And user click login button
    Then user can see pop up choose avatar if possible
    Then user can see stream page
    When user click search box
    Then user can see section recent searches
