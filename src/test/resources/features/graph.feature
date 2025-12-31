@DataStructure @Graph @Regression
Feature: Graph functionality

  Background:
    Given User is at the Home page after sign-in
    Given User clicks the Getting Started button in Graph Panel

  Scenario: Verify that User is able to see the Graph page header
    Then User should see Graph header for Graph page

  Scenario: Verify that User is able to see Topics covered header in Graph page
    Then User should see Topics Covered having link for Graph page

  Scenario Outline: Verify User is able to see Graph topics link
    Then User should see "<Graph_topics>" link of Graph page

    Examples:
      | Graph_topics          |
      | Graph                 |
      | Graph Representations |

  Scenario Outline: Verify User navigate through Links and see Header in Graph page
    When User  clicks the "<Graph_topics>" in Graph page
    Then User should see "<Graph_topics>" header of the respective Graph page

    Examples:
      | Graph_topics          |
      | Graph                 |
      | Graph Representations |

  Scenario Outline: Verify Try here button is visible in the Graph topics page
    When User clicks "<Graph_topics>" link on the Graph page
    Then User should see Try here button for the respective Graph page

    Examples:
      | Graph_topics          |
      | Graph                 |
      | Graph Representations |

  Scenario Outline: Verify User able to see Practice Questions for Graph topics page
    When User clicks "<Graph_topics>" link on the Graph page
    Then User should see Practice Questions on the Graph topics page

    Examples:
      | Graph_topics          |
      | Graph                 |
      | Graph Representations |

  Scenario Outline: Verify User is able to navigate to respective Graph page
    When User clicks "<Graph_topics>" link on the Graph page
    Then User should be redirected to "<Graph_topics_page>"  of graph page

    Examples:
      | Graph_topics          | Graph_topics_page     |
      | Graph                 | graph                 |
      | Graph Representations | graph-representations |

  Scenario Outline: Verify User is able to navigate to Practice Questions page of Graph topics
    When User clicks "<Graph_topics>" link on the Graph page
    When User clicks Practice Questions link in the respective Graph page
    Then User should be redirected to Practice Questions page of Graph topics

    Examples:
      | Graph_topics          |
      | Graph                 |
      | Graph Representations |

  Scenario Outline: Verify user is able to navigate to try Editor page
    When User clicks "<Graph_topics>" link on the Graph page
    When User clicks Try Here button in the respective Graph page
    Then User should be redirected to try Editor page

    Examples:
      | Graph_topics          |
      | Graph                 |
      | Graph Representations |
