@ScoreThisRound
Feature: Test the score

  @tag1
  Scenario Outline: A player wants to score this round in a category
    Given Sam wants to score this round
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
