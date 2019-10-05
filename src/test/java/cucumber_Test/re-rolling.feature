@Re-rollSomeDice
Feature: Test the re-rolling some dice

  @tag1
  Scenario Outline: A player enters a number or a list of numbers for re-rolling some dice.
    Given Moe wants to re-roll some dice
    When Moe enters <value> for re-rolling
    Then I verify the <status> of user input for re-rolling in step

    Examples: 
      | value     | status |
      | "1 2 3 4" | true   |
      |     "0 4" | true   |
      |       "3" | true   |
      |       "6" | false  |
      |   "3 4 5" | false  |
      |   "0 3 6" | false  |
