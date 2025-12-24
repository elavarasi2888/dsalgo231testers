@DataStructure @graph
Feature: Graph functionality

  Background:
    Given User is at the Home page after sign-in
    Given User clicks the Getting Started button in "Graph" Panel
    Given User is on "Graph" page

  Scenario: Verify that User is able to see the Graph page header
    Then User should see "Graph" header for Graph page

  Scenario: Verify that User is able to see Topics covered header in Graph page
    Then User should see "Topics Covered" having link for Graph page

  Scenario Outline: Verify User is able to see topics Graph link
    Then User should see "<Graph_topics>" link of Graph page

    Examples:
      | Graph_topics          |
      | Graph                 |
      | Graph Representations |

  Scenario Outline: Verify User navigate through Links and see Header in Graph page
    When User  clicks the "<links>" in Graph page
    Then User should see "<header>" header of the respective Graph page

    Examples:
      | links                 | header                |
      | Graph                 | Graph                 |
      | Graph Representations | Graph Representations |

  Scenario Outline: Verify "Try here" button is visible in the Graph topics page
    When User clicks "<Graph_topics>" link on the Graph page
    Then User should see "Try here>>>" button for the respective Graph page

    Examples:
      | Graph_topics          |
      | Graph                 |
      | Graph Representations |
# Graph pages functional test case

  Scenario Outline: Verify User is able to navigate to respective Graph page
    When User clicks "<Graph_topics>" link on the Graph page
    Then User should be redirected to "<Graph_topics>" page containing "<Partial_Link_Text>"

    Examples:
      | Graph_topics          | Partial_Link_Text     |
      | Graph                 | graph                 |
      | Graph Representations | graph-representations |
