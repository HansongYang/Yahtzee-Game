@Players
Feature: Test Player feature

  @tag1
  Scenario Outline: A player wants to score the yahtzee bonus
    Given Moe rolles the dice and wants to score the yahtzee bonus
    When Moe chooses to score the yahtzee bonus category with his dice <value>
    Then I verify the <points> and <Yahtzee> that Moe can get from yahtzee bonus category of in step

    Examples: 
      | Yahtzee | value       | points |
      |       0 | "5 5 5 5 5" |      0 |
      |       1 | "6 6 6 6 6" |    100 |
      |       1 | "1 2 3 4 5" |      0 |

  @tag2
  Scenario Outline: Checking a player has upper bonus or not
    Given <name> plays the game for a couple of rounds
    When <name> has <total upper section points> in upper section and he wants to know whether he has an upper bonus or not
    Then I verify his <total upper section points> in step

    Examples: 
      | name | total upper section points |
      | Moe  |                         50 |
      | Sam  |                         63 |
      | Joe  |                         70 |

  @tag3
  Scenario: A player joins the game
    Given The server is running
    When Moe joins the game
    Then I verify that how many players are in this game in step

  @tag4
  Scenario Outline: A player plays the last round then the game ends
    Given Joe plays the last round
    When The winner is announced by checking <points>
    Then I verify whether the game ends or not in step

    Examples: 
      | points        |
      | "198 220 212" |
      | "200 213 245" |

  @tag5
  Scenario Outline: Three players join the game and the game starts
    Given The server is running
    When <name> joins the game
    Then I verify whether the game starts or not in step

    Examples: 
      | name |
      | Moe  |
      | Sam  |
      | Joe  |

  @tag6
  Scenario Outline: A player finishes his turn and then goes to another player's turn
    Given Moe finishes his turn
    When The next player is ready to play by folling the <order>
    Then I verify the correctness of next player <next player>  in step

    Examples: 
      | order         | next player |
      | "Moe Sam Joe" | "Sam"       |
      | "Joe Sam Moe" | "Joe"       |
      | "Sam Moe Joe" | "Joe"       |
  
  @tag7
  Scenario Outline: Three players finish their turn and then this round finishes
    Given Three players finish their turn
    When This round finishes and the round <round> starts
    Then I verify the correctness of round <round> in step

    Examples: 
     | round|
     |  2		|
     |  3		|
     |  4		|
  
  @tag8
  Scenario: Three players finish their turn for the last round and then this game ends
    Given Three players finish their turn 
    When Thirteen rounds finishes
    Then I verify whether the game ends or not in step
