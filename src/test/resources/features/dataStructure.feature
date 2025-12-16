Feature: DataStruction Functionality

  Background:
    Given User clicks the Getting Started button in "Data Structures-Introduction page" Panel
    Given User is on "Data Structures-Introduction page" page

  Scenario: Verify that User is able to see the Data Structures-Introduction page header
    Then User should see "Data Structures-Introduction page" header for Data Structures-Introduction page

  Scenario: Verify that User is able to see Topics covered header
    Then User should see "Topics Covered" header for Data Structures-Introduction page

  Scenario Outline: Verify User is able to see Data Structures-Introduction topics link
    Then User should see "<DS_topics>" link of Data Structure page

    Examples:
      | DS_topics       |
      | Time Complexity |

 Scenario Outline: Verify User navigate through Links and see Header in Time Complexity page
    When User  clicks the "<links>" in a Data Structure page
    Then User should see "<header>" header of the respective Data Structure page

    Examples:
      | links           | header          |
      | Time Complexity | Time Complexity |

  Scenario Outline: Verify "Try here" button is visible in the Data Structures-Introduction topics page
    When User clicks "<DS_topics>" link on the Data Structures-Introduction page
    Then User should see "Try here>>>" button on the Data Structures-Introduction page

    Examples:
      | DS_topics       |
      | Time Complexity |
      
# Ds pages functional test case

  Scenario Outline: Verify User is able to navigate to respective Data Structures-Introduction page
    When User clicks "<DS_topics>" link on the Data Structures-Introduction page
    Then User should be directed to "<DS_topics>" page containing "<Partial Link Text>"

    Examples:
      | DS_topics       | Partial Link Text |
      | Time Complexity | time-complexity   |
