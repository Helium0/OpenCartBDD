Feature: OpenCart Register User
  User should be able to register

  Scenario: Register with valid credentials
    Given User opens Login section
    And Click continue button
    When User enters valid first name
    And Enters valid last name
    And Enters valid email adress
    And Enters valid password
    And Accepts privacy policy
    And Click continue
    Then Defined account should be registered