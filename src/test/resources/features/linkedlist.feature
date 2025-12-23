Feature: Linklist Functionality

    Background:
    Given User is at the Home page after sign-in
    Given User clicks the Getting Started button in "Graph" Panel
    Given User is on "Linked List" page

  Scenario: Verify that User is able to see the "Linked List" page header
    Then User should see "Linked List" header for Linkedlist page

  Scenario: Verify that User is able to see Topics covered header in Linked List page
    Then User should see "Topics Covered" having link for Linked List page

  Scenario Outline: Verify User is able to see topics Linked List topics link
    Then User should see "<Linkedlist_topics>" link of Linked List page

    Examples:
      | Linkedlist_topics               |
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

  Scenario Outline: Verify "Try here" button is visible in the linklist topics page
    When User clicks "<linklist_topics>" link on the linklist page
    Then User should see "Try here>>>" button for the respective linklist page

    Examples:
      | linklist_topics                 |
      | Introduction                    |
      | Creating Linked LIst            |
      | Types of Linked List            |
      | Implement Linked List in Python |
      | Traversal                       |
      | Insertion                       |
      | Deletion                        |

  Scenario Outline: Verify User is able to navigate to respective linklist page
    When User clicks "<linklist_topics>" link on the linklist page
    Then User should be redirected to "<linklist_topics>" page containing "<Partial_Link_Text>"

    Examples:
      | linklist_topics                 | Partial_Link_Text               |
      | Introduction                    | introduction                    |
      | Creating Linked LIst            | creating-linked-lIst            |
      | Types of Linked List            | types-of-linked-list            |
      | Implement Linked List in Python | implement-linked-list-in-Python |
      | Traversal                       | traversal                       |
      | Insertion                       | insertion                       |
      | Deletion                        | deletion                        |
