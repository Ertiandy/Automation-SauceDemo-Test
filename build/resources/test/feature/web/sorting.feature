Feature: Sorting

  @Web @Positive
  Scenario Outline: User already login and sorting items
    Given user is already on homepage
    And user click filter "<filter>"
    Then then product filtered "<filter>"
    Examples:
    |filter|
    |az|
    |za|
    |lohi|
    |hilo|
