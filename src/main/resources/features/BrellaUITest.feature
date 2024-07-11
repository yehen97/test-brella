Feature: Register Page UI Validation

  @Test
  Scenario Outline: Verify that Browser Open the Url
    Given I want to open the Brella Browser

    Examples:
      | acctNumber |threeDSRequestorChallengeInd |merchantCountryCode|purchaseCurrency|purchaseAmount|MessageCategory|value|deviceChannel|threeRIInd|
      | 4283759991999111 |02 |840|840|650000|02|Y|03|01|