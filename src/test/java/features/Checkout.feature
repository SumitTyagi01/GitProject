Feature: Place the order for products


#  @CartTest
#  Scenario: Search Experience for product search in both home and Offers page
#    Given User is on GreenCart Landing Page
#    When User search with shortname "Tom" and extracted actual name of product
#    Then User searched for "Tom" shortname in offers page
#    And Validate product name in offer page matches with landing page

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing Page
    When User search with shortname <Name> and extracted actual name of product
    And Added "3" items of the selected product to the cart
    Then User proceed to checkout and validate the <Name> items in the checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
    | Name |
    | Tom  |



