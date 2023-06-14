Feature: correct website information

  @reg
  Scenario: correct website information
    When the title is "Swag Labs"
    Then username and password fields are available
    And Login button is enabled