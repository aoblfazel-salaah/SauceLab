Feature: Logout

  Background:
    Given username is entered "standard_user"
    And Password is entered "secret_sauce"
    And user clicks on login button
    And user should be logged in successfully


  @logout   @reg
  Scenario: Logout with empty cart

    When user clicks on menu button
    And user clicks on logout button
    Then the user is taken to the login page
    Then the title is "Swag Labs"
    And username and password fields are available
    And Login button is enabled

    @logoutWithItems @reg
  Scenario: Logout with items in the cart

    When user adds item #itemNumber to the cart
      |1         |
      |2         |
    And user clicks on menu button
    And user clicks on logout button
    Then the user is taken to the login page
    And the title is "Swag Labs"
    And username and password fields are available
    And Login button is enabled

