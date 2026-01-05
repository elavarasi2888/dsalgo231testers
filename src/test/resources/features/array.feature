#Owner: Ela
@Regression @DataStructure @Array
Feature: Array - non functional test case

  Background:
    Given User is at the Home page after sign-in
    Given User clicks Get Started button from Array panel

# non functional test cases

  Scenario: Verify that user is able to see the Array header
    Then User should see Array header for Array page

  Scenario: Verify that user is able to see Topics covered header
    Then User should see Topics Covered header for Array page

  Scenario Outline: Verify user is able to see Array topics link
    Then User should see "<Array topics>" link of Array page

    Examples:
      | Array topics              |
      | Arrays in Python          |
      | Arrays Using List         |
      | Basic Operations in Lists |
      | Applications of Array     |

  Scenario Outline: Verify user is able to see Array topic page heading
    When User clicks "<Array topics>" link on the Array page
    Then User should see "<Array topics>" header of the respective Array page

    Examples:
      | Array topics              |
      | Arrays in Python          |
      | Arrays Using List         |
      | Basic Operations in Lists |
      | Applications of Array     |

  Scenario Outline: Verify Try here button is visible in the Array topics page
    When User clicks "<Array topics>" link on the Array page
    Then User should see try here button on the Array page

    Examples:
      | Array topics              |
      | Arrays in Python          |
      | Arrays Using List         |
      | Basic Operations in Lists |
      | Applications of Array     |

# Array pages functional test case

  Scenario Outline: Verify user is able to navigate to respective Array page
    When User clicks "<Array topics>" link on the Array page
    Then User should be directed to "<topics in the Array page>" page of Array page

    Examples:
      | Array topics              | topics in the Array page  |
      | Arrays in Python          | arrays-in-python          |
      | Arrays Using List         | arrays-using-list         |
      | Basic Operations in Lists | basic-operations-in-lists |
      | Applications of Array     | applications-of-array     |

  Scenario Outline: Verify user is able to navigate to try Editor page
    When User clicks "<Array topics>" link on the Array page
    When User clicks Try Here button in the respective Array page
    Then User should be redirected to try Editor page

    Examples:
      | Array topics              |
      | Arrays in Python          |
      | Arrays Using List         |
      | Basic Operations in Lists |
      | Applications of Array     |
