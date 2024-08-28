Feature: end to End testing

  Scenario Outline: Full Test
    Given User is on Home Page
    Then User Searchs for "<Product>" and presses search icon
    And User Sees List of Products
    Then User Scrolls to a random product and click it "<ProductNumber>"
    And User Checks the Product Title
    Then User Clicks on Add To Cart.
    Then User Clicks on Cart Button Goes to Cart
    And User sees the cart page
    Then User Presses on Proceed to Buy
    #And User is Directed to SignIn Page
    Then User Fills "<Phone>"
    And User clicks on Continue Button
    Then User Fills Password "<Password>"
    And User clicks on Sign In
    Then User should see checkout Screen
    Then User Closes the Browser

    Examples: 
      | Product   | ProductNumber | Phone      | Password |
      | Hp Laptop |             5 | 7032810532 | Moh123$$ |
