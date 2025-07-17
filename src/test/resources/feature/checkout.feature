Feature: Checkout

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
