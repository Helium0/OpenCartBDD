Feature: : OpenCart User Login
  Registered User should be able to login

  Scenario: Login with valid credentials
    Given User navigates to the Login section
    When User enters valid email address "testowanie1299@gmail.com"
    And Enter valid password "tojesttest666"
    And Click Login
    Then User should be successfully logged in
    And Close application


