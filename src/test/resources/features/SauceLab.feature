Feature: SauceLab

  Background:
    Given  the user is on Home Page

  Scenario: ReverseSorting
    When User Clicks on Z-A sort button
    Then list of product should be displayed in descending order


  Scenario: ByPrice
    When User select High to Low price
    Then list of product should be displayed in Price High toLow format


  Scenario: Checkout Process
    Given User adds items to the cart
    When User clicks on the cart logo
    Then The cart page should be displayed
    When User clicks on the Checkout button
    Then User should be navigated to the information page
    When User provides null value for any field
    Then An error message should be displayed
    When User clicks on the Continue button
    Then User should be navigated to the checkout page
    When User clicks on the Finish button
    Then An order successful message should be visible
