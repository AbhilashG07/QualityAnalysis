Feature: Bank Careers Page Functionality
  As a user of the Bank website
  I want to navigate and interact with the carriers page
  So that I can find job opportunities and relevant information

  Background:
    Given the user is on home page
    And the user accepts cookies if presented
    And the user navigates to Company careers page


  @regression @smoke @sanity
  Scenario: Verify basic page elements are displayed
    Then the user should see the logo
    And the user should see the main navigation menu
    And the page title should be Careers

  @regression
  Scenario: Search for job openings by keyword
    When the user chooses "Professionals" section and "Search Roles" sub-section from the careers page
    Then division should be selected by default

  @regression @smoke @sanity
  Scenario: Verify all desired filters are available for filter by Division
    When the user chooses "Professionals" section and "Search Roles" sub-section from the careers page
    Then the user should see the following divisions
      | Division Category          |
      | Country                    |
      | State                      |
      | City                       |
      | Corporate title            |
      | I want to work             |
      | What is your availability? |

  @regression @sanity
  Scenario: Verify all desired filters are available for filter by Profession
    When the user chooses "Professionals" section and "Search Roles" sub-section from the careers page
    And the user chooses Profession filter
    Then the user should see the following professions
      | Profession Category        |
      | Profession                 |
      | Country                    |
      | State                      |
      | City                       |
      | Corporate title            |
      | I want to work             |
      | What is your availability? |

  @regression
  Scenario: Search for job openings by Division Category
    When the user chooses "Professionals" section and "Search Roles" sub-section from the careers page
    And the user searches with below details
      | Filter Type       | Filter Value |
      | Division Category | Chairman     |
    And the user will Search the job filters applied
    Then the job listings should be filtered according to below filter value
      | Chairman |

  @regression @smoke @sanity
  Scenario: Search for job by multiple division filters
    When the user chooses "Professionals" section and "Search Roles" sub-section from the careers page
    And the user searches with below details
      | Filter Type       | Filter Value |
      | Division Category | Chairman     |
      | City              | Bangalore    |
    And the user will Search the job filters applied
    Then the job listings should be filtered according to below filter value
      | Chairman  |
      | Bangalore |

  @regression
  Scenario: Resetting job filters should clear all applied filters
    When the user chooses "Professionals" section and "Search Roles" sub-section from the careers page
    And the user searches with below details
      | Filter Type       | Filter Value |
      | Division Category | Chairman     |
      | City              | Bangalore    |
    And the user will Reset the job filters applied
    Then all filters should be cleared

  @regression
  Scenario: Search for jobs by profession
    When the user chooses "Professionals" section and "Search Roles" sub-section from the careers page
    And the user chooses Profession filter
    And the user searches with below details
      | Filter Type         | Filter Value |
      | Profession Category | Audit        |
    And the user will Search the job filters applied
    Then the job listings should be filtered according to below filter value
      | Audit |


  @regression @sanity
  Scenario: Search for jobs by multiple profession filters
    When the user chooses "Professionals" section and "Search Roles" sub-section from the careers page
    And the user chooses Profession filter
    And the user searches with below details
      | Filter Type         | Filter Value |
      | Profession Category | Audit        |
      | Country             | India        |
      | Corporate title     | Associate    |
    And the user will Search the job filters applied
    Then the job listings should be filtered according to below filter value
      | Audit     |
      | India     |
      | Associate |

  @regression
  Scenario: Verify whether Your Applications page is rendered or not.
    When the user chooses "Professionals" section and "Your Application" sub-section from the careers page
    Then the user should see the Your Applications page
