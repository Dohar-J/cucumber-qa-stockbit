Feature: Register

  Scenario: Validate new user can see register page
    Given user open chrome and start application to register
    When user click on sign up button
    Then user can see register page
    When user click button register with email
    Then user can see form page register
    When user fill register form
    And user click on register button
    Then user can sms verification page
    When user input phone number
    Then user got captcha
