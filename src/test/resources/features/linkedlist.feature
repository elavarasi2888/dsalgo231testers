Feature: Linklist Functionality

  Background:
    Given User opens the browser
    Given User enters the correct DS Algo portal URL
    Given User clicks the Get Started button on DS Algo portal page
    Given User has signed In
    Given User navigates to Home page
    Given User is in the Linked List page

  Scenario: Verify User is in the Linked List page
    Then User should see Header with "Topics Covered"
    Then User should see Topic_links under the topics covered
      | Topic_links                     |
      | Introduction                    |
      | Creating Linked LIst            |
      | Types of Linked List            |
      | Implement Linked List in Python |
      | Traversal                       |
      | Insertion                       |
      | Deletion                        |

  Scenario Outline: Verify User navigate through Links and see Header in LinkedList page
    When User  clicks the "<links>" in a linklist page
    Then User should see "<header>"

    Examples:
      | links                           | header                          |
      | Introduction                    | Introduction                    |
      | Creating Linked LIst            | Creating Linked LIst            |
      | Types of Linked List            | Types of Linked List            |
      | Implement Linked List in Python | Implement Linked List in Python |
      | Traversal                       | Traversal                       |
      | Insertion                       | Insertion                       |
      | Deletion                        | Deletion                        |

  Scenario Outline: User should be redirected to a page having an try Editor with Run button to test
    Given User is on the "<linklist_topics>"
    When User clicks Try here button in the "<linklist_topics>"
    Then User should navigate to Try Editor Run button to test

    Examples:
      | linklist_topics                 |
      | Introduction                    |
      | Creating Linked LIst            |
      | Types of Linked List            |
      | Implement Linked List in Python |
      | Traversal                       |
      | Insertion                       |
      | Deletion                        |

  Scenario Outline: Verify User should see a error,output and alert for input
    Given User is in the tryEditor page for "<linKlist_topics>"
    When User clicks Run button to verify the "<code>" in Editor
    Then User should able to see "<output_type>"

    Examples:
    
      | linKlist_topics                 | code           | output_type                                        |
      | Introduction                    | print("Hello") | Console                                            |
      | Introduction                    | print("Hello"  | SyntaxError: EOF in multi-line statement on line 2 |
      | Introduction                    |                |                                                    |
      | Creating Linked LIst            | print("Hello") | Console                                            |
      | Creating Linked LIst            | print("Hello"  | SyntaxError: EOF in multi-line statement on line 2 |
      | Creating Linked LIst            |                |                                                    |
      | Types of Linked List            | print("Hello") | Console                                            |
      | Types of Linked List            | print("Hello"  | SyntaxError: EOF in multi-line statement on line 2 |
      | Types of Linked List            |                |                                                    |
      | Implement Linked List in Python | print("Hello") | Console                                            |
      | Implement Linked List in Python | print("Hello"  | SyntaxError: EOF in multi-line statement on line 2 |
      | Implement Linked List in Python |                |                                                    |
      | Traversal                       | print("Hello") | Console                                            |
      | Traversal                       | print("Hello"  | SyntaxError: EOF in multi-line statement on line 2 |
      | Traversal                       |                |                                                    |
      | Insertion                       | print("Hello") | Console                                            |
      | Insertion                       | print("Hello"  | SyntaxError: EOF in multi-line statement on line 2 |
      | Insertion                       |                |                                                    |
      | Deletion                        | print("Hello") | Console                                            |
      | Deletion                        | print("Hello"  | SyntaxError: EOF in multi-line statement on line 2 |
      | Deletion                        |                |                                                    |
