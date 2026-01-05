#Owner: Ela
@Regression @DataStructure @Stack
Feature: Stack test cases

  Background:
    Given User is at the Home page after sign-in
    Given User clicks Get Started button from Stack panel
# Stack non functional test cases

  Scenario: Verify that user is able to see the Stack header
    Then User should see Stack header for Stack page

  Scenario: Verify that user is able to see Topics covered header
    Then User should see Topics Covered header for Stack page

  Scenario Outline: Verify user is able to see Stack topics link
    Then User should see "<Stack topics>" link of Stack page

    Examples:
      | Stack topics        |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  Scenario Outline: Verify user is able to see Stack topic page heading
    When User clicks "<Stack topics>" link on the Stack page
    Then User should see "<Stack topics>" header of the respective Stack page

    Examples:
      | Stack topics        |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  Scenario Outline: Verify user able to see Practice Questions on Stack topic pages
    When User clicks "<Stack topics>" link on the Stack page
    Then User should see Practice Questions on the Stack topic page

    Examples:
      | Stack topics        |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  Scenario Outline: Verify Try here button is visible in the Stack topics page
    When User clicks "<Stack topics>" link on the Stack page
    Then User should see try here button on the Stack page

    Examples:
      | Stack topics        |
      | Operations in Stack |
      | Implementation      |
      | Applications        |
# Stack functional test cases

  Scenario Outline: Verify user is able to navigate to respective Stack page
    When User clicks "<Stack topics>" link on the Stack page
    Then User should be directed to "<topics in the stack page>" page of Stack page

    Examples:
      | Stack topics        | topics in the stack page |
      | Operations in Stack | operations-in-stack      |
      | Implementation      | implementation           |
      | Applications        | stack-applications       |

  Scenario Outline: Verify user is able to navigate to Practice Questions page of Stack topics
    When User clicks "<Stack topics>" link on the Stack page
    When User clicks PracticeQuestions link in the respective Stack page
    Then User should be redirected to Practice Questions page of Stack topics

    Examples:
      | Stack topics        |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  Scenario Outline: Verify user is able to navigate to try Editor page
    When User clicks "<Stack topics>" link on the Stack page
    When User clicks Try Here button in the respective Stack page
    Then User should be redirected to try Editor page

    Examples:
      | Stack topics        |
      | Operations in Stack |
      | Implementation      |
      | Applications        |
