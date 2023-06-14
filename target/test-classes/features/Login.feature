Feature: Valid and Invalid login

  @login @reg
  Scenario: a valid user is able to log in
    Given username is entered "standard_user"
    And Password is entered "secret_sauce"
    And user clicks on login button
    Then user should be logged in successfully

    @reg @invalidLogin
  Scenario Outline: combination of improper entries
    Given username is entered "<username>"
    And Password is entered "<password>"
    And user clicks on login button
    Then user gets the "<errorMessage>"

    Examples:
    |username     |password    |errorMessage|
    |standard_user|            |Password is required|
    |             |secret_sauce|Username is required|
    |             |            |Username is required|
    |invalid      |asdfdf      |Username and password do not match any user in this service|
    |@#$@#$@1112  |@#$@#GGG    |Username and password do not match any user in this service|