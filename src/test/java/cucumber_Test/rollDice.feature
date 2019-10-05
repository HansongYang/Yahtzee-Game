@RollDice
Feature: Test roll all the dice

  @tag1
  Scenario Outline: A player wants to roll all the dice
    Given Moe wants to roll all the dice
    When Moe enters <value> for rolling all the dice
    Then I verify the <status> of user input for rolling in step

    Examples: 
      | value | status |
      | 'r'     | true   |
      | 't'     | false  |
