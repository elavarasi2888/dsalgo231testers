Feature: Queue feature test cases

  Background: User clicks the Get Started button on DS Algo portal page
    Given User opens the browser
    Given user enters the correct DS Algo portal URL
    Given user clicks the Get Started button on DS Algo portal page
    Given user is at the Home page
# Non-Functional tests

  Scenario: Verify that user is able to see the Queue header
    When user clicks the Getting Started button in Queue panel
    Then user should see "Queue" header for Queue page

  Scenario: Verify that user is able to see Topics covered header
    When user clicks the Getting Started button in Queue Panel
    Then user should see "Topics Covered" header for Queue page

  Scenario Outline: Verify user is able to see Queue topics link
    When user clicks the Getting Started button in Queue Panel
    Then user should see "<queue-topic>" link of Queue page

    Examples:
      | queue-topic                            |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array link        |
      | Queue Operations                       |

  Scenario Outline: Verify user is able to see Queue topic page heading
    Given user is on the Queue page
    When user clicks "<queue-topic>" link on the Queue page
    Then user should see "<queue-topic>" header of the respective Queue page

    Examples:
      | queue-topic                            |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array link        |
      | Queue Operations                       |

  Scenario Outline: Verify try here button is visible in the Queue topic page
    Given user is on the Queue page
    When user clicks "<queue-topic>" link on the Queue page
    Then User should see try here button on the Queue page

    Examples:
      | queue-topic                            |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array link        |
      | Queue Operations                       |
# Functional tests

  Scenario Outline: Verify user is able to navigate to respective Queue page
    Given user is on the Queue page
    When user clicks "<queue-topic>" link on the Queue page
    Then user should be directed to "<queue-topic-page>" of Queue data structure

    Examples:
      | queue-topic                            | queue-topic-page           |
      | Implementation of Queue in Python      | implementation-lists       |
      | Implementation using collections.deque | implementation-collections |
      | Implementation using array link        | Implementation-array       |
      | Queue Operations                       | QueueOp                    |

  Scenario Outline: Verify user is able to navigate to try Editor page
    Given user is on the "<queue-topic>" page of Queue data structure
    When user clicks Try Here button in the repsective Queue page
    Then user should be redirected to try Editor page

    Examples:
      | queue-topic                            |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array link        |
      | Queue Operations                       |
