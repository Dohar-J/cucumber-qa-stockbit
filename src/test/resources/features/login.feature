Feature: Login

  Scenario: Validate user can login with valid username and password
    Given user open chrome and start application
    When user click on log in button
    Then user can see login page
    When user fill valid username and password
    And user click on login button
    Then user can see home page

  Scenario: Validate user cannot login with invalid username and password
    Given user open chrome and start application
    When user click on log in button
    Then user can see login page
    When user fill invalid username and password
    And user click on login button
    Then user can see toast error message

  Scenario: Validate user cannot login with invalid username and password
    Given user open chrome and start application
    When user click on log in button
    Then user can see login page
    When user fill invalid username and valid password
    And user click on login button
    Then user can see toast error message

  Scenario: Validate user cannot login with invalid username and password
    Given user open chrome and start application
    When user click on log in button
    Then user can see login page
    When user fill valid username and invalid password
    And user click on login button
    Then user can see toast error message

  Scenario: Validate user cannot login with empty username and password
    Given user open chrome and start application
    When user click on log in button
    Then user can see login page
    And user click on login button
    Then user can see toast error message
