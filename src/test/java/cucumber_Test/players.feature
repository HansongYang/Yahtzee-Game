@Player
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
    When <name> has <points> and he wants to know whether he has an upper bonus or not
    Then I verify his <points> in step

    Examples: 
      | name | points |
      | Moe  |     50 |
      | Sam  |     63 |
      | Joe  |     70 |
