Feature: Tree feature test cases

  Background:
    Given User opens the browser
    Given User enters the correct DS Algo portal URL
    Given User clicks the Get Started button on DS Algo portal page
    Given User is at the Home page after sign-in
# Non-Functional tests

  Scenario: Verify that user is able to see the Tree header
    When User clicks the Getting Started button in Tree Panel
    Then User should see "Tree" header for Tree page

  Scenario: Verify that user is able to see Topics covered header
    When User clicks the Getting Started button in Tree Panel
    Then User should see "Topics Covered" header for Tree page

  Scenario Outline: Verify user is able to see Tree topics link
  	When: User clicks the Getting Started button in Tree Panel
  	Then: User should see "<tree-topic>" link of Tree page

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
    Given User is on the Tree page
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
    Given User is on the Tree page
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
# Functional tests

  Scenario Outline: Verify user is able to navigate to respective Tree page
    Given User is on the Tree page
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

  Scenario Outline: Verify user is able to navigate to try Editor page
    Given User is on the "<tree-topic>" page of Tree data structure
    When User clicks Try Here button in the repsective Tree page
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
