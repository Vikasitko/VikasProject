@Test
Feature: Search and place the order for products
 
  
@Scenario1  
Scenario: Adding a First Product Item in Cart and verify sub total
  
    Given User is on Amazon Landing page
    When User searched with name as "Monitor" and extract actual price of the product
    And User click on the first item
    And User add the item by clicking on Add to Cart button
    And Open the cart
    Then Verify that the price is identical to the product page
    And Verify that the sub total is identical to the product page
   
   
@Scenario2  
Scenario: Adding a Second Product Item in Cart and verify sub total
  
    Given User is on Amazon Landing page
    When User searched with name as "Laptop" and extract actual price of the product
    And User click on the second item
    And User add item by clicking on Add to Cart button
    #And Open the goToCart
     And Open the cart
    Then Verify that the price is identical to the product page
    And Verify that the sub total is identical to the product page
    
  
@Scenario3  
Scenario: Adding a two Product Item in Cart and verify sub total
  
    Given User is on Amazon Landing page
    When User searched with name as "Headphones" and extract actual price of the product
    And User click on the first item
    And User add the item by clicking on Add to Cart button
    And User close child window
    And User searched with name as "Keyboard" and extract actual price of the product
    And User click on the first item
    And User add the item by clicking on Add to Cart button
    #And Open the goToCart
    And Open the cart
    Then Verify that each  item price is identical to the product page
    And Verify that the sub total is identical to sum of item price
    
   

 