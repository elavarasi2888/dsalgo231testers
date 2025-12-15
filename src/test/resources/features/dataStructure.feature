Feature: DataStruction Functionality

  Background:
    Given User opens the browser
    Given User enters the correct DS Algo portal URL
    Given User clicks the Get Started button on DS Algo portal page
    Given User has signed In
    Given User navigates to Home page
    Given User is in the Data Structures - Introduction page

  Scenario: Verify User is in the Data Structure page
    Then User should see Header with "Topics Covered"
    Then User should see Topic_links under the topics covered
      | Topic_links     |
      | Time Complexity |

  Scenario Outline: Verify User navigate through Links and see Header in Time Complexity page
    When User  clicks the "<links>" in a Data Structure page
    Then User should see "<header>"

    Examples:
      | links           | header          |
      | Time Complexity | Time Complexity |

  Scenario Outline: User should be redirected to a page having an try Editor with Run button to test
    Given User is on the "<dataStructure_topics>"
    When User clicks Try here button in the "<dataStructure_topics>"
    Then User should navigate to Try Editor Run button to test

    Examples:
      | dataStructure_topics |
      | Time Complexity      |

  Scenario Outline: Verify User should see a error,output and alert for input
    Given User is in the tryEditor page for "<dataStructure_topics>"
    When User clicks Run button to verify the "<code>" in Editor
    Then User should able to see "<output_type>"

    Examples:
      | dataStructure_topics | code           | output_type                                        |
      | Time Complexity      | print("Hello") | Console                                            |
      | Time Complexity      | print("Hello"  | SyntaxError: EOF in multi-line statement on line 2 |
      | Time Complexity      |               |                                                   |

  Scenario: Verify User Should to practice page
    Given User is in the Time Complexity page
    When User clicks the Practice Questions link
    Then User  should be redirected to Practice page
