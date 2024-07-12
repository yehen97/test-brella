Feature: Register Page UI Validation

  @Test @SuccessFlow
  Scenario Outline: Verify that user is able to submit the form with valid data and see data saved
    Given I want to open the Brella Browser
    And I want to enter name as "<Name>"
    And I want to turn on status
    And I want to enter Email as "<Email>"
    And I want to enter Input Number as "<inputNumber>"
    And I want to select Year as "<Year>"
    And I want to click on save button
    Then I want check on confimration alert as "<Alert>"

    Examples:
      | Name     | Email                | inputNumber | Year | Alert            |  |
      | Yehen    | yehen@1997@gmail.com | 50          | 2024 | cool, it is done |  |
      | Chathuma | yehen@1997@gmail.com | 60          | 2024 | cool, it is done |  |


  @Test @ErrorFlow
  Scenario Outline: Verify that user is able to enter an invalid email and see validation error
    Given I want to open the Brella Browser
    And I want to enter name as "<Name>"
    And I want to turn on status
    And I want to enter Email as "<Email>"
    And I want to enter Input Number as "<inputNumber>"
    And I want to select Year as "<Year>"
    And I want to click on save button
    Then I want check on error alert as "<Alert>"

    Examples:
      | Name  | Email              | Year | inputNumber | Alert                |
      | Yehen | yehen1997gmail.com | 2023    | 50          | email doesn't have @ |