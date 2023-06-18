Feature: Item prices Validation - supposing the prices never change

  @prices @reg
  Scenario: Item prices Validation - supposing the prices never change

    Given username is entered "standard_user"
    And Password is entered "secret_sauce"
    And user clicks on login button
    Then user should be logged in successfully
    #---------------

    And every item's price should match the price list in the "ItemsAndPrices" excel file