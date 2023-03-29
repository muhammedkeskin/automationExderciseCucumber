Feature: Cart Page

  #point of scenario: handPopup methodu(22)
  #element not interactable hatasını handle yapma (js ile scroll)(23)
  #point of scenario: daha önce Random olarak gelen dataları başka stepte kullanma
  #(kullanıcı oluştururken kullandığımız bilgiler Faker classtan geliyoru. buradak, değerleri farklı bir stepte kulanmamız gerekiyor)(28)
  Scenario: Verify address details in checkout page
    Given Launch browser
    Given Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Signup-Login button
    Then Verify New User Signup! is visible
    When Enter name and email address
    When Click Signup button
    When Fill details: Title, Name, Email, Password, Date of birth
    When Select checkbox Sign up for our newsletter
    When Select checkbox Receive special offers from our partners!
    When Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    When Click Create Account button
    Then Verify that ACCOUNT CREATED! is visible
    When Click Continue button
    Then Verify that Logged in as username is visible
    When Add products to cart
    When Click Cart button
    Then Verify that cart page is displayed
    When Click Proceed To Checkout
    Then Verify that the entered address information is the same
    When Click Delete Account button
    Then Verify that ACCOUNT DELETED! is visible and click Continue button


    #yeni stepler: 41,56,57,58,59,60,61
    #Point of scenario: verify the downloaded file
  Scenario: Download Invoice after purchase order
    Given Launch browser
    Given Navigate to Home Page
    Then Verify that home page is visible successfully
    When Add products to cart
    When Click Cart button
    Then Verify that cart page is displayed
    When Click Proceed To Checkout
    When Click RegisterLogin button
    Then Verify New User Signup! is visible
    When Enter name and email address
    When Click Signup button
    When Fill details: Title, Name, Email, Password, Date of birth
    When Select checkbox Sign up for our newsletter
    When Select checkbox Receive special offers from our partners!
    When Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    When Click Create Account button
    Then Verify that ACCOUNT CREATED! is visible
    When Click Continue button
    Then Verify that Logged in as username is visible
    When Click Cart button
    When Click Proceed To Checkout
    Then Verify that the entered address information is the same
    When Enter description in comment text area and click Place Order
    When Enter payment details: Name on Card, Card Number, CVC, Expiration date
    When Click Pay and Confirm Order button
    When Click Download Invoice button and verify invoice is downloaded successfully.
    When Click Continue button
    When Click Delete Account button
    Then Verify that ACCOUNT DELETED! is visible and click Continue button