Feature: LoginPage

  #1. point of scenario: findElements kullanarak assert yapma
  #2. point of scenario: feature da integer olarak verilen değerli method ve locator içinde kullanma
  #3. point of scenario: data table kullanımı
  Scenario: Register User
    Given Launch browser
    Given Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    Then The products list is visible
    When Click on View Product of 1. product
    Then User is landed to product detail page
    Then Verify that detail following details are visible
      | product name |
      | category     |
      | price        |
      | availability |
      | condition    |
      | brand        |

    #point of scenario: birden çok webelementin sayfada olduğunu veirfy yapma
  Scenario: Search Product
    Given Launch browser
    Given Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    When Enter product name "Blue Top" in search input and click search button
    Then Verify SEARCHED PRODUCTS is visible
    Then Verify all the products related to searched word "Blue Top" are visible

    #point of scenario: scrolling with Js
  Scenario: Verify Subscription in home page
    Given Launch browser
    Given Navigate to Home Page
    Then Verify that home page is visible successfully
    When Scroll down to footer
    Then Verify text SUBSCRIPTION
    When Enter email address in input and click arrow button
    Then Verify success message You have been successfully subscribed! is visible

    #point of scenario: Hovering-over
  Scenario: Add Products in Cart
    Given Launch browser
    Given Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Products button
    When Hover over first product and click Add to cart
    When Click Continue Shopping button
    When Hover over second product and click Add to cart
    When Click View Cart button
    Then Verify both products are added to Cart
    And Verify their prices, quantity and total price

    #point of scenario: using Random Class while building logic
  Scenario: View & Cart Brand Products
    Given Launch browser
    Given Navigate to Home Page
    When Click on Products button
    Then Verify that Brands are visible on left side bar
    When Click on any brand name
    Then Verify that user is navigated to brand page and brand products are displayed
    When On left side bar, click on any other brand link
    Then Verify that user is navigated to that brand page and can see products

