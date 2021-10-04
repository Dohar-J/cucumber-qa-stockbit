Feature: Stream

  Scenario: user can post new stream
    Given user open chrome and start the application
    When user click button login
    Then user can see log in page
    When user fill username and password
    And user click log in button
    Then user can see popup choose avatar if possible
    And user can see homepage
    When user click stream input box
    And user post new stream
    And user click post stream

  Scenario: user verify section trending stocks is display
    Given user open chrome and start the application
    When user click button login
    Then user can see log in page
    When user fill username and password
    And user click log in button
    Then user can see popup choose avatar if possible
    And user can see homepage
    And user validate trending stock section is display

  Scenario: user verify section banner is display
    Given user open chrome and start the application
    When user click button login
    Then user can see log in page
    When user fill username and password
    And user click log in button
    Then user can see popup choose avatar if possible
    And user can see homepage
    And user validate banner section is display

  Scenario: user can discover stream
    Given user open chrome and start the application
    When user click button login
    Then user can see log in page
    When user fill username and password
    And user click log in button
    Then user can see popup choose avatar if possible
    And user can see homepage
    And user validate banner section is display
    When user scroll to discover section
    And user click discover button
    Then user can see user recommendation
    And user can follow one of users
