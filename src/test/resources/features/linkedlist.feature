Feature: Linklist Functionality

  Background:
    Given User clicks the Getting Started button in "Linked List" Panel
    Given User is on "Linked List" page
    
  Scenario: Verify that User is able to see the Linked List page header
    Then User should see "Linked List" header for Linkedlist  page

  Scenario: Verify that User is able to see Topics covered header in Linked List page
    Then User should see "Topics Covered" header for Linked List page
    
    
  Scenario Outline: Verify User is able to see topics Linked List link
    Then User should see "<Linkedlist_topics>" link of Linked List page
      | Linkedlist_topics                     |
      | Introduction                    |
      | Creating Linked LIst            |
      | Types of Linked List            |
      | Implement Linked List in Python |
      | Traversal                       |
      | Insertion                       |
      | Deletion                        |

  Scenario Outline: Verify User navigate through Links and see Header in LinkedList page
    When User  clicks the "<links>" in a linklist page
    Then User should see "<header>" header of the respective linklist page

    Examples:
      | links                           | header                          |
      | Introduction                    | Introduction                    |
      | Creating Linked LIst            | Creating Linked LIst            |
      | Types of Linked List            | Types of Linked List            |
      | Implement Linked List in Python | Implement Linked List in Python |
      | Traversal                       | Traversal                       |
      | Insertion                       | Insertion                       |
      | Deletion                        | Deletion                        |

    Scenario Outline: Verify "Try here" button is visible in the linklist page
    When User clicks "<linklist_topics>" link on the linklist page
    Then User should see "Try here>>>" button on the linklist page

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
