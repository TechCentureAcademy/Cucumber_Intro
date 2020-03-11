Feature: Autoamtion test cases for Etsy.com

  @login
  Scenario: Login to our account
    Given User is on the home page
    When User clicks on the "Sign in" button
    Then User enters valid "techcenture.test@gmail.com" and "techtest123"
    And User clicks on the "Sign in Login" button
    Then User verifies that he is on the account page
  
  @login2
  Scenario: Login to our account
    Given User is on the home page
    When User clicks on the "Sign in" button
    Then User enters valid username and password
      | userName                   | password    |
      | techcenture.test@gmail.com | techtest123 |
    And User clicks on the "Sign in Login" button
    Then User verifies that he is on the account page
    
    @login3
  Scenario: Login to our account
    Given User is on the home page
    When User clicks on the "Sign in" button
    Then User enters valid username and password
    And User clicks on the "Sign in Login" button
    Then User verifies that he is on the account page
