Feature: OpenCart Register User
  User should be able to register

  Background:
    Given User navigates to the Login section
    And Click continue button


  Scenario: Register with valid credentials
    When User enters valid first name
    And Enters valid last name
    And Enters valid email adress
    And Enters valid password
    And Accepts privacy policy
    And Click continue button for register
    Then Defined account should be registered
    And Close browser

  Scenario: Register without privacy policy
    When User enters valid first name
    And Enters valid last name
    And Enters valid email adress
    And Enters valid password
    And Click continue button for register
    Then Privacy policy error message appears
    And Close browser

  Scenario: Register without passing any data
    When User doesn`t enter any data fields
    And Accepts privacy policy
    And Click continue button for register
    Then Remaining fields errors appear
    And Close browser
