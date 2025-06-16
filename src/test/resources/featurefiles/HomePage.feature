Feature: Bank Home Page functionality
  As a user of the Bank website I want to visit and verify the home page elements

  Background:
    Given the user is on home page
    And the user accepts cookies if presented

  @regression @default @homepage
  Scenario: Verify basic home page elements
    Then the user should see the Company logo on home page
    And the user should see the main navigation menu on home page
    And the careers link should be present in the main navigation menu