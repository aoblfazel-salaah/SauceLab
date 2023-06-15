Feature: About page

  @reg @about
  Scenario: navigating to about page
    Given username is entered "standard_user"
    And Password is entered "secret_sauce"
    And user clicks on login button
    Then user should be logged in successfully
    When user clicks on menu button
    And clicks on about button
    Then user is taken to about page