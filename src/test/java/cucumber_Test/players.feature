@Players
Feature: Test Player feature

  @tag1
  Scenario Outline: A player wants to score the yahtzee bonus
    Given Moe rolles the dice and wants to score the yahtzee bonus
    When Moe chooses to score the yahtzee bonus category with his dice <value>
    Then I verify the <points> that Moe can get from yahtzee bonus category of in step

    Examples: 
      | value                    | points |
      | "5 5 5 5 5"              |      0 |
      | "6 6 6 6 6", "2 2 2 2 2" |    100 |

  @tag2
  Scenario Outline: Checking a player has upper bonus or not
    Given <name> plays the game for a couple of rounds
    When <name> has <upper section points> in upper section and he wants to know whether he has an upper bonus or not
    Then I verify his <upper section points> in step

    Examples: 
      | name | upper section points |
      | Moe  |                   50 |
      | Sam  |                   63 |
      | Joe  |                   70 |

  @tag3
  Scenario Outline: Three players join the game and the game starts
    Given The server is running
    When <name> joins the game
    Then I verify whether the game starts or not in step

    Examples: 
      | name |
      | Moe  |
      | Sam  |
      | Joe  |

  @tag4
  Scenario Outline: A player plays the last round then the game ends
    Given Joe plays the last round
    When The winner is announced by checking <points>
    Then I verify whether the game ends or not in step

    Examples: 
      | points        |
      | "198 220 212" |

  @tag5
  Scenario Outline: A player finishes his turn and then goes to another player's turn
    Given Moe finishes his turn
    When The next player is ready to play by folling the <order>
    Then I verify the correctness of ordering in step

    Examples: 
      | order         |
      | "Moe Sam Joe" |
