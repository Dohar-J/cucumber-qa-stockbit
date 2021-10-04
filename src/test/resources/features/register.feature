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


  Scenario: Validate user can't register with an existing email and username
    Given user open chrome and start application to register
    When user click on sign up button
    Then user can see register page
    When user click button register with email
    Then user can see form page register
    When user fill register form with email and username has been registered
    Then user can see error message for email has been registered
    And user can see error message for username has been registered

  Scenario: Validate user should using valid field format
    Given user open chrome and start application to register
    When user click on sign up button
    Then user can see register page
    When user click button register with email
    Then user can see form page register
    When user fill register form with wrong email format
    Then user can see error message for wrong format email

  Scenario: Validate confirmation password is match
    Given user open chrome and start application to register
    When user click on sign up button
    Then user can see register page
    When user click button register with email
    Then user can see form page register
    When user fill register form with password didn't match
    When user click on register button
    Then user can see error message for wrong confirmation password