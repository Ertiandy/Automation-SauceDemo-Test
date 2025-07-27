Feature: Checkout

    @Web @Positive
    Scenario: User already login and want checkout
      Given user is already on homepage
      And user click add to cart button
      And user click cart icon
      And user click checkout button
      And user input firstName with "John"
      And user input lastName with "Doe"
      And user input ZipCode with "16000"
      When user click continue button
      Then user is on checkout overview page
      And user click finish button
      Then user is on checkout finish page

  @Web @Positive
    Scenario: User already login and want checkout all items
      Given user is already on homepage
      And user click add to cart button for each items
      And user click cart icon
      And user click checkout button
      And user input firstName with "John"
      And user input lastName with "Doe"
      And user input ZipCode with "16000"
      When user click continue button
      Then user is on checkout overview page
      And user click finish button
      Then user is on checkout finish page

  @Web @Negative
  Scenario: User already login and want checkout but did not input firstName
    Given user is already on homepage
    And user click add to cart button
    And user click cart icon
    And user click checkout button
    And user input firstName with ""
    And user input lastName with "Doe"
    And user input ZipCode with "16000"
    When user click continue button
    Then user view error message on page check step one "Error: First Name is required"

  @Web @Negative
  Scenario: User already login and want checkout but did not input lastName
    Given user is already on homepage
    And user click add to cart button
    And user click cart icon
    And user click checkout button
    And user input firstName with "John"
    And user input lastName with ""
    And user input ZipCode with "16000"
    When user click continue button
    Then user view error message on page check step one "Error: Last Name is required"

  @Web @Negative
  Scenario: User already login and want checkout but did not input ZipCode
    Given user is already on homepage
    And user click add to cart button
    And user click cart icon
    And user click checkout button
    And user input firstName with "John"
    And user input lastName with "Doe"
    And user input ZipCode with ""
    When user click continue button
    Then user view error message on page check step one "Error: Postal Code is required"

  @Web @Negative
  Scenario: User already login and want checkout but did not input firstName, lastName and ZipCode
    Given user is already on homepage
    And user click add to cart button
    And user click cart icon
    And user click checkout button
    And user input firstName with ""
    And user input lastName with ""
    And user input ZipCode with ""
    When user click continue button
    Then user view error message on page check step one "Error: First Name is required"
