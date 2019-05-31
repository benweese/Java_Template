@run
Feature: Feature Name
  #Test Feature Name

  Scenario Outline: statement
    Given statement
    When statement <id>
    Then statement

    Examples:
      | id  |
      | 0   |
      | 1   |
      | 2   |
      | 3   |
      | 4   |
      | 5   |
      | 6   |
      | 7   |
      | 8   |
      | 9   |
      | 10  |

  Scenario: statement
    Given statement
    When statement <id>
    Then statement
