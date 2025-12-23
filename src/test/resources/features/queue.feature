@DataStructure @Queue
Feature: Queue feature test cases

  Background:
#    Given User opens the browser
#    Given User enters the correct DS Algo portal URL
#    Given User clicks the Get Started button on DS Algo portal page
    Given User is at the Home page after sign-in
    Given User clicks Get Started button of "Queue" from panel after sign-in
    Given User is on the Queue page
# Non-Functional tests

  Scenario: Verify that user is able to see the Queue header
    Then User should see "Queue" header for Queue page

  Scenario: Verify that user is able to see Topics covered header
    Then User should see "Topics Covered" header for Queue page

  Scenario Outline: Verify user is able to see Queue topics link
    Then User should see "<queue-topic>" link of Queue page

    Examples:
      | queue-topic                            |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array link        |
      | Queue Operations                       |

  Scenario Outline: Verify user is able to see Queue topic page heading
    When User clicks "<queue-topic>" link on the Queue page
    Then User should see "<queue-topic>" header of the respective Queue page

    Examples:
      | queue-topic                            |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array link        |
      | Queue Operations                       |

  Scenario Outline: Verify try here button is visible in the Queue topic page
    When User clicks "<queue-topic>" link on the Queue page
    Then User should see try here button on the Queue page

    Examples:
      | queue-topic                            |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array link        |
      | Queue Operations                       |
# Functional tests

  Scenario Outline: Verify user is able to navigate to respective Queue page
    When User clicks "<queue-topic>" link on the Queue page
    Then User should be directed to "<queue-topic-page>" of Queue data structure

    Examples:
      | queue-topic                            | queue-topic-page           |
      | Implementation of Queue in Python      | implementation-lists       |
      | Implementation using collections.deque | implementation-collections |
      | Implementation using array link        | Implementation-array       |
      | Queue Operations                       | QueueOp                    |

  Scenario Outline: Verify user is able to navigate to try Editor page
    When User clicks "<queue-topic>" link on the Queue page
    When User clicks Try Here button in the repsective Queue page
    Then User should be redirected to try Editor page

    Examples:
      | queue-topic                            |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array link        |
      | Queue Operations                       |
