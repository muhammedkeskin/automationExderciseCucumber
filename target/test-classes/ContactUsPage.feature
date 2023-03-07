Feature: Contact Us Page

    #1. point of scenario: updoading file
    #2. point of scenario: alert class
    Scenario: Sending Message
    Given Launch browser
    When Navigate to Home Page
    Then Verify that home page is visible successfully
    When Click on Contact Us button
    Then Verify GET IN TOUCH is visible
    When Enter name, email, subject and message
    When Upload file
    When Click Submit button
    When Click OK button
    When Verify success message Success! Your details have been submitted successfully is visible
    When Click Home button and verify that landed to home page successfully