@UserAction
Feature: Test the user action

  @tag1
  Scenario Outline: A player enters a number for user action
    Given <name> enters the game and the game starts
    When <name> enters a <value> for action
    Then I verify the <status> of user input for user action in step

    Examples: 
      | name | value | status |
      | Moe  |     1 | true   |
      | Joe  |     2 | true   |
      | Sam  |     4 | false  |

  @tag2
  Scenario Outline: A player enters a number or a list of numbers for re-rolling some dice.
    Given Moe wants to re-roll some dice
    When Moe enters <value> for re-rolling
    Then I verify the <status> of user input for re-rolling in step

    Examples: 
      | value       | status |
      | "0 1 2 3 4" | true   |
      | "0 4"       | true   |
      | "3"         | true   |
      | "6"         | false  |
      | "3 4 5"     | false  |
      | "0 3 6"     | false  |

  @tag3
  Scenario Outline: A player wants to roll all the dice
    Given Moe wants to roll all the dice
    When Moe enters <value> for rolling all the dice
    Then I verify the <status> of user input for rolling in step

    Examples: 
      | value | status |
      | 'r'   | true   |
      | 't'   | false  |

  @tag4
  Scenario Outline: A player wants to score with no re-rolls
    Given Sam wants to score this round without re-rolling
    When Sam enters <value> for a category that he wants to score
    Then I verify the <status> of user input for scoring in step

    Examples: 
      | value | status |
      |     3 | true   |
      |     5 | true   |
      |     0 | false  |
      |    20 | false  |

  @tag5
  Scenario Outline: A player wants to score with 1 re-roll of less than 5 dice
    Given Sam wants to re-roll some dice
    When Sam enters <dice> for re-rolling
    And He enters <value> for a category that he wants to score
    Then I verify the <status> of user input for scoring in step

    Examples: 
      | dice    | value | status |
      | "1 2 3" |     2 | true   |
      | "2"     |     4 | true   |
      | "1 2"   |    14 | false  |
      | "3 4"   |    20 | false  |

  @tag6
  Scenario Outline: A player wants to score with 1 re-roll of 5 dice
    Given After 1 re-roll of 5 dice, Sam wants to score this round
    When Sam enters <value> for a category that he wants to score
    Then I verify the <status> of user input for scoring in step

    Examples: 
      | value | status |
      |     2 | true   |
      |     4 | true   |
      |    14 | false  |
      |    20 | false  |

  @tag7
  Scenario Outline: A player wants to score after 2 re-rolls
    Given After 2 re-rolling, Sam wants to score this round
    When Sam enters <value> for a category that he wants to score
    Then I verify the <status> of user input for scoring in step

    Examples: 
      | value | status |
      |     1 | true   |
      |     7 | true   |
      |    13 | true   |
      |     0 | false  |
      |    14 | false  |
      |    20 | false  |
