Feature: OpenCart User Login
  Registered User should be able to login

  Background:
    Given User navigates to the Login section


  Scenario: Login with valid credentials
    When User enters valid email address "testowanie1299@gmail.com"
    And Enter valid password "tojesttest666"
    And Click Login
    Then User should be successfully logged in
    And Close browser


  Scenario Outline: Login with invalid email address
    When User enters invalid email address "<email>"
    And Enter valid password "tojesttest666"
    And Click Login
    Then User should receive alert message
    And Close browser

    Examples:
      | email  |
      |testowanie99@gmail.com|
      |1299@gmail.com|
      |test!@12.com  |

  Scenario Outline: Login with invalid password
    When User enters valid email address "testowanie1299@gmail.com"
    And Enter invalid password "<password>"
    And Click Login
    Then User should receive alert message
    And Close browser

    Examples:
      | password |
      | 1 |
      | te |
      | !! |
      | badPas |
      | 123458960494828271829304019128374 |

  Scenario: Login without passing any credentials
    And Click Login
    Then User should receive alert message
    And Close browser
