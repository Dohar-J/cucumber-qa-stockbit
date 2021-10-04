Scenario: Validate user can see page on homepage
  Given user open chrome and start application
  When user click on log in button
  Then user can see login page
  When user fill valid username and password
  And user click on login button
  Then user can see home page
  When user click each menu on homepage
