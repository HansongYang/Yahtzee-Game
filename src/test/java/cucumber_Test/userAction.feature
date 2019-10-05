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
