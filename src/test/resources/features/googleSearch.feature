Feature: Google Search

  @google
  Scenario: Google search positive
    Given user goes to "http://google.com"
    Then user searches for "apple"
    And user verifies "apple" in the page title