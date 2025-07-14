
Feature: Login Feature

  Scenario: Positive login
    Given user is on login page
    When user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage

  Scenario: Negative login
    Given user is on login page
    And user input username with "invalid_user"
    And user input password with "wrong_password"
    When user click login button
    Then user is on homepage

  Scenario: Boundary login (empty username and password)
    Given user is on login page
    And user input username with ""
    And user input password with ""
    When user click login button
    Then user is on homepage
