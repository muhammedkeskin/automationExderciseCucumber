Feature: LoginPage

  #point of scenario:ilk scenario oluşturma
  Scenario: Register User
    Given Launch browser
    Given Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Signup-Login button
    Then Verify New User Signup! is visible
    When Enter name and email address
    When Click Signup button
    Then Verify that ENTER ACCOUNT INFORMATION is visible
    When Fill details: Title, Name, Email, Password, Date of birth
    When Select checkbox Sign up for our newsletter
    When Select checkbox Receive special offers from our partners!
    When Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    When Click Create Account button
    Then Verify that ACCOUNT CREATED! is visible
    When Click Continue button
    Then Verify that Logged in as username is visible
    When Click Delete Account button
    Then Verify that ACCOUNT DELETED! is visible and click Continue button

  #point of scenario: data table kullanımı
  Scenario: Login User with correct email and password
    Given Launch browser
    When Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Signup-Login button
    Then Verify Login to your account is visible
    When Enter correct email address and password
      | email    | johndoe1000@gmail.com |
      | password | 123456                |
    When Click login button
    Then Verify that Logged in as username is visible
    When Click Delete Account button
    Then Verify that ACCOUNT DELETED! is visible

  #1. point of scenario: configuration reader kullanarak properties'den data çekmek
  #2. point of scenario: feature'da string olarak verilern değeri step def'de kullanma
  #3. point of scenario: genel bir method oluşturma ve farklı yerlerde kullanılabilecek şekilde dizayn etme
  Scenario: Login User with incorrect email and password
    Given Launch browser
    When Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Signup-Login button
    Then Verify Login to your account is visible
    When Enter incorrect email address and password
    When Click login button
    Then Verify error that "Your email or password is incorrect!" is visible

  # point of scenario: title ile assert yapma
  Scenario: Logout User
    Given Launch browser
    When Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Signup-Login button
    Then Verify Login to your account is visible
    When Enter correct email address and password
      | email    | johndoe1000@gmail.com |
      | password | 123456                |
    When Click login button
    Then Verify that Logged in as username is visible
    When Click Logout button
    Then Verify that user is navigated to login page

    # point of scenario: genel bir method oluşturma ve farklı yerlerde kullanılabilecek şekilde dizayn etme
  Scenario: Register User with existing email
    Given Launch browser
    When Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Signup-Login button
    Then Verify New User Signup! is visible
    When Enter name and already registered email address
    When Click Signup button
    Then Verify error that "Email Address already exist!" is visible

