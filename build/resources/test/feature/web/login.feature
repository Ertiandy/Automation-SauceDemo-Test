
Feature: Login Feature

  @Web @Positif
  Scenario: Login with valid user
    Given user is on login page
    When user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage

  @Web @Negative
  Scenario: Login with invalid username and password
    Given user is on login page
    And user input username with "invalid_user"
    And user input password with "wrong_password"
    When user click login button
    Then user view message on login page "Epic sadface: Username and password do not match any user in this service"


  @Web @Negative
  Scenario: Login with valid username and invalid password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "password"
    When user click login button
    Then user view message on login page "Epic sadface: Username and password do not match any user in this service"

  @Web @Negative
  Scenario: Login with invalid username and valid password
    Given user is on login page
    And user input username with "username"
    And user input password with "secret_sauce"
    When user click login button
    Then user view message on login page "Epic sadface: Username and password do not match any user in this service"

  @Web @Negative
  Scenario: Login with valid username and empty password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with ""
    When user click login button
    Then user view message on login page "Epic sadface: Password is required"

  @Web @Negative
  Scenario: Login with valid username and empty password
    Given user is on login page
    And user input username with ""
    And user input password with "secret_sauce"
    When user click login button
    Then user view message on login page "Epic sadface: Username is required"

  @Web @Negative
  Scenario: Boundary login (empty username and password)
    Given user is on login page
    And user input username with ""
    And user input password with ""
    When user click login button
    Then user view message on login page "Epic sadface: Username is required"



