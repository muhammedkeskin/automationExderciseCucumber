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
  Scenario: cenario: Search Product
    Given Launch browser
    Given Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    When Enter product name in search input and click search button
    Then Verify SEARCHED PRODUCTS is visible
    Then Verify all the products related to searched word "Blue Top" are visible

    #point of scenario: js ile scroll yapma
  Scenario: Verify Subscription in home page
    Given Launch browser
    Given Navigate to Home Page
    Then Verify that home page is visible successfully
    When Scroll down to footer
    Then Verify text SUBSCRIPTION
    When Enter email address in input and click arrow button
    Then Verify success message You have been successfully subscribed! is visible
