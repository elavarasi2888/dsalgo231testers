@DataStructure @DataStructureIntroduction
Feature: DataStructure Functionality

  Background:
    Given User is at the Home page after sign-in
    Given User clicks Get Started button of Data Structures-Introduction panel

  Scenario: Verify that User is able to see the Data Structures-Introduction header
    Then User should see Data Structures Introduction header for Data Structures-Introduction page

  Scenario: Verify that User is able to see Topics covered header
    Then User should see Topics Covered having link for Data Structures-Introduction page

  Scenario Outline: Verify User is able to see Data Structures-Introduction topics link
    Then User should see "<DS_topics>" link of Data Structure page

    Examples:
      | DS_topics       |
      | Time Complexity |

  Scenario Outline: Verify User navigate through Links and see Header in Time Complexity page
    When User  clicks the "<DS_topics>" in a Data Structure page
    Then User should see "<DS_topics>" header of the respective Data Structure page

    Examples:
      | DS_topics       |
      | Time Complexity |

  Scenario Outline: Verify Try here button is visible in the Data Structures-Introduction topics page
    When User clicks "<DS_topics>" link in the Data Structures-Introduction page
    Then User should see Try here button for the respective Data Structure page

    Examples:
      | DS_topics       |
      | Time Complexity |

  Scenario Outline: Verify User able to see Practice Questions for Data Structures topics page
    When User clicks "<DS_topics>" link on the Data Structures-Introduction page
    Then User should see Practice Questions on the Data Structures topics page

    Examples:
      | DS_topics       |
      | Time Complexity |

  Scenario Outline: Verify User is able to navigate to respective Data Structures-Introduction page
    When User clicks "<DS_topics>" link on the Ds-Introduction page
    Then User should be redirected to "<DS_topics_page>" of DataStructure page

    Examples:
      | DS_topics       | DS_topics_page  |
      | Time Complexity | time-complexity |

  Scenario Outline: Verify User is able to navigate to Practice Questions page of Data Structure topics
    When User clicks "<DS_topics>" link on the DataStructure page
    When User clicks Practice Questions link in the respective DataStructure page
    Then User should be redirected to Practice Questions page of Data Structure topics

    Examples:
      | DS_topics       |
      | Time Complexity |

  Scenario Outline: Verify user is able to navigate to try Editor page
    When User clicks "<DS_topics>" link on the DataStructure page
    When User clicks Try Here button in the respective DataStructure page
    Then User should be redirected to try Editor page

    Examples:
      | DS_topics       |
      | Time Complexity |
