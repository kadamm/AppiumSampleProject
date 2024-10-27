Feature: End to end checkout process

  Background:
    Given I am on application login screen

  @smoke
  Scenario: Verify starts the checkout process and proceeds with payment.
    Given I am login into the application with valid credentials
    When I select "Sauce Labs Backpack" product and add it to the Cart
    Then I verify "Sauce Labs Backpack" is visible in my cart
    When I tap on the Proceed to check button
    When I started the checkout process with below details
      | Full_Name      | Address_Line_1 | Address_Line_2 | City  | State    | Zip_Code | Country        |
      | Rebecca Winter | Mandorley 112  | Entrance 1     | Truro | Cornwall | 89750    | United Kingdom |
    And I proceed with payment with below details
      | Full_Name      | Card_Number     | Expiry_date | Secure_code |
      | Rebecca Winter | 325812657568789 | 03/25       | 123         |
    Then I verify the details on Review your order screen matches to below details
      |Product_Name       | Full_Name     | Address_Line_1  | Address_Line_2  | City    | Card_Number           |
      |Sauce Labs Backpack| Rebecca Winter| Mandorley 112   | Entrance 1      | Truro   |  3258 1265 7568 789   |
    When I tap on the place order button
    Then I verify checkout complete success screen