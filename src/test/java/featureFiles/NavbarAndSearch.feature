Feature: Testing Navbar and Search Functionality on 2NHABER Website

  Scenario: Verify all Navbar Links and Search Functionality
    Given the user is on the 2NHABER homepage
    When the user clicks on each navbar element
    Then all pages should open without errors
    When the user clicks on the search button
    And the user searches for "İstanbul"
    Then the user should navigate to the 8th news detail page
