Feature: Graph functionality

  Background:
    Given User opens the browser
    Given User enters the correct DS Algo portal URL
    Given User clicks the Get Started button on DS Algo portal page
    Given User has signed In
    Given User navigates to Home page
    Given User is in the Graph page

  Scenario: Verify User is in the Graph page
    Then User should see Header with "Topics Covered"
    Then User should see Topic_links under the topics covered
      | Topic_links           |
      | Graph                 |
      | Graph Representations |

  Scenario Outline: Verify User navigate through Links and see Header in Graph page
    When User  clicks the "<links>" in Graph page
    Then User should see "<header>"
      | links                 | header                |
      | Graph                 | Graph                 |
      | Graph Representations | Graph Representations |

  Scenario Outline: User should be redirected to a page having an try Editor with Run button to test
    Given User is on the "<graph_topics>"
    When User clicks Try here button in the "<graph_topics>"
    Then User should navigate to Try Editor Run button to test
      | graph_topics          |
      | Graph                 |
      | Graph Representations |

  Scenario Outline: Verify User should see a error,output and alert for input
    Given User is in the tryEditor page for "<graph_topics>"
    When User write the "<code>" in Editor and click the Run Button
    Then User should able to see "<output_type>"
      | graph_topics          | code           | output_type                                        |
      | Graph                 | print("Hello") | Console                                            |
      | Graph                 | print("Hello"  | SyntaxError: EOF in multi-line statement on line 2 |
      | Graph                 |                |                                                    |
      | Graph Representations | print("Hello") | Console                                            |
      | Graph Representations | print("Hello"  | SyntaxError: EOF in multi-line statement on line 2 |
      | Graph Representations |                |                                                    |
