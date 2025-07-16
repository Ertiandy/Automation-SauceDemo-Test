Feature: Sorting Item

  Scenario Outline: sorting item
    Given I already Logged in
    When I click filter by "<filter>"
    Then Product filtered by "<filter>"
    Examples:
      | filter              |
      | Price (high to low) |
      | Price (low to high) |
      | Name (Z to A)       |
      | Name (A to Z)       |


