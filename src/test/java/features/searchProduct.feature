Feature: Search and Place the order for products


#  @CartTest
#  Scenario: Search Experience for product search in both home and Offers page
#    Given User is on GreenCart Landing Page
#    When User search with shortname "Tom" and extracted actual name of product
#    Then User searched for "Tom" shortname in offers page
#    And Validate product name in offer page matches with landing page

  @OfferPage
  Scenario Outline: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing Page
    When User search with shortname <Name> and extracted actual name of product
    Then User searched for <Name> shortname in offers page
    And Validate product name in offer page matches with landing page

    Examples:
    | Name |
    | Tom  |
    | Beet |


