@DataStructure @Tree
Feature: Tree feature test cases

  Background:
    Given User is at the Home page after sign-in
    Given User clicks Get Started button from Tree panel

 # Non-Functional tests

  Scenario: Verify that user is able to see the Tree header
    Then User should see Tree header for Tree page

  Scenario: Verify that user is able to see Topics covered header
    Then User should see Topics Covered header for Tree page

  Scenario Outline: Verify user is able to see Tree topics link
    Then User should see "<tree-topic>" link of Tree page

    Examples:
      | tree-topic                     |
      | Overview of Trees              |
      | Terminologies                  |
      | Types of Trees                 |
      | Tree Traversals                |
      | Traversals-Illustration        |
      | Binary Trees                   |
      | Types of Binary Trees          |
      | Implementation in Python       |
      | Binary Tree Traversals         |
      | Implementation of Binary Trees |
      | Applications of Binary trees   |
      | Binary Search Trees            |
      | Implementation Of BST          |

  Scenario Outline: Verify user is able to see Tree topic page heading
    When User clicks "<tree-topic>" link on the Tree page
    Then User should see "<tree-topic>" header of the respective Tree page

    Examples:
      | tree-topic                     |
      | Overview of Trees              |
      | Terminologies                  |
      | Types of Trees                 |
      | Tree Traversals                |
      | Traversals-Illustration        |
      | Binary Trees                   |
      | Types of Binary Trees          |
      | Implementation in Python       |
      | Binary Tree Traversals         |
      | Implementation of Binary Trees |
      | Applications of Binary trees   |
      | Binary Search Trees            |
      | Implementation Of BST          |

  Scenario Outline: Verify try here button is visible in the Tree topic page
    When User clicks "<tree-topic>" link on the Tree page
    Then User should see try here button on the Tree page

    Examples:
      | tree-topic                     |
      | Overview of Trees              |
      | Terminologies                  |
      | Types of Trees                 |
      | Tree Traversals                |
      | Traversals-Illustration        |
      | Binary Trees                   |
      | Types of Binary Trees          |
      | Implementation in Python       |
      | Binary Tree Traversals         |
      | Implementation of Binary Trees |
      | Applications of Binary trees   |
      | Binary Search Trees            |
      | Implementation Of BST          |

  Scenario Outline: Verify user able to see Practice Questions on Tree topic pages
    When User clicks "<tree-topic>" link on the Tree page
    Then User should see Practice Questions on the Tree topic page

    Examples:
      | tree-topic                     |
      | Overview of Trees              |
      | Terminologies                  |
      | Types of Trees                 |
      | Tree Traversals                |
      | Traversals-Illustration        |
      | Binary Trees                   |
      | Types of Binary Trees          |
      | Implementation in Python       |
      | Binary Tree Traversals         |
      | Implementation of Binary Trees |
      | Applications of Binary trees   |
      | Binary Search Trees            |
      | Implementation Of BST          |


# Functional tests

  Scenario Outline: Verify user is able to navigate to respective Tree page
    When User clicks "<tree-topic>" link on the Tree page
    Then User should be directed to "<tree-topic-page>" of Tree data structure

    Examples:
      | tree-topic                     | tree-topic-page                |
      | Overview of Trees              | overview-of-trees              |
      | Terminologies                  | terminologies                  |
      | Types of Trees                 | types-of-trees                 |
      | Tree Traversals                | tree-traversals                |
      | Traversals-Illustration        | traversals-illustration        |
      | Binary Trees                   | binary-trees                   |
      | Types of Binary Trees          | types-of-binary-trees          |
      | Implementation in Python       | implementation-in-python       |
      | Binary Tree Traversals         | binary-tree-traversals         |
      | Implementation of Binary Trees | implementation-of-binary-trees |
      | Applications of Binary trees   | applications-of-binary-trees   |
      | Binary Search Trees            | binary-search-trees            |
      | Implementation Of BST          | implementation-of-bst          |

  Scenario Outline: Verify user is able to navigate to Practice Questions page of Tree topics
    When User clicks "<tree-topic>" link on the Tree page
    When User clicks PracticeQuestions link in the respective Tree page
    Then User should be redirected to Practice Questions page of Tree topics

    Examples:
      | tree-topic                     |
      | Overview of Trees              |
      | Terminologies                  |
      | Types of Trees                 |
      | Tree Traversals                |
      | Traversals-Illustration        |
      | Binary Trees                   |
      | Types of Binary Trees          |
      | Implementation in Python       |
      | Binary Tree Traversals         |
      | Implementation of Binary Trees |
      | Applications of Binary trees   |
      | Binary Search Trees            |
      | Implementation Of BST          |


  Scenario Outline: Verify user is able to navigate to try Editor page
    When User clicks "<tree-topic>" link on the Tree page
    When User clicks Try Here button in the respective Tree page
    Then User should be redirected to try Editor page

    Examples:
      | tree-topic                     |
      | Overview of Trees              |
      | Terminologies                  |
      | Types of Trees                 |
      | Tree Traversals                |
      | Traversals-Illustration        |
      | Binary Trees                   |
      | Types of Binary Trees          |
      | Implementation in Python       |
      | Binary Tree Traversals         |
      | Implementation of Binary Trees |
      | Applications of Binary trees   |
      | Binary Search Trees            |
      | Implementation Of BST          |
