Feature: Search Functionality

  @Search
  Scenario Outline: Searching for product and selecting 3rd product
    Given User is on Home Page
    Then User Searchs for "<Product>" and presses search icon
    And User Sees List of Products
    Then User Scrolls to the third Product
    Then User Closes the Browser

    Examples: 
      | Product    |
      | Hp Laptop  |
      | Phone      |
      | Phone Case |
      | UPS        |
