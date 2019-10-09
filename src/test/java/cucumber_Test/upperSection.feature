@UpperSectionCategory
Feature: Test upper section category

  @tag1
  Scenario Outline: A player wants to score the aces category
    Given Moe rolles the dice and wants to score in a upper section category
    When Moe chooses to score the ones category with his dice <value>
    Then I verify the <points> that Moe can get from ones category of in step

    Examples: 
      | value       | points |
      | "1 1 5 1 1" |      4 |
      | "3 4 5 2 4" |      0 |
      | "1 4 5 6 2" |      1 |
      | "1 1 3 4 5" |      2 |
      | "1 1 1 1 1" |      5 |

  @tag2
  Scenario Outline: A player wants to score the twos category
    Given Moe rolles the dice and wants to score in a upper section category
    When Moe chooses to score the twos category with his dice <value>
    Then I verify the <points> that Moe can get from twos category of in step

    Examples: 
      | value       | points |
      | "2 2 5 2 2" |      8 |
      | "3 4 5 2 4" |      2 |
      | "1 4 5 2 2" |      4 |
      | "1 1 3 4 5" |      0 |
      | "2 2 2 2 2" |     10 |

  @tag3
  Scenario Outline: A player wants to score the threes category
    Given Moe rolles the dice and wants to score in a upper section category
    When Moe chooses to score the threes category with his dice <value>
    Then I verify the <points> that Moe can get from threes category of in step

    Examples: 
      | value       | points |
      | "2 2 5 2 2" |      0 |
      | "3 4 5 2 4" |      3 |
      | "1 4 5 3 3" |      6 |
      | "1 3 3 4 3" |      9 |
      | "3 3 3 3 3" |     15 |

  @tag4
  Scenario Outline: A player wants to score the fours category
    Given Moe rolles the dice and wants to score in a upper section category
    When Moe chooses to score the fours category with his dice <value>
    Then I verify the <points> that Moe can get from fours category of in step

    Examples: 
      | value       | points |
      | "4 4 5 4 4" |     16 |
      | "3 4 5 2 4" |      8 |
      | "1 4 5 3 3" |      4 |
      | "1 3 3 2 3" |      0 |
      | "4 4 4 4 4" |     20 |

  @tag5
  Scenario Outline: A player wants to score the fives category
    Given Moe rolles the dice and wants to score in a upper section category
    When Moe chooses to score the fives category with his dice <value>
    Then I verify the <points> that Moe can get from fives category of in step

    Examples: 
      | value       | points |
      | "4 4 5 4 4" |      5 |
      | "3 4 5 5 4" |     10 |
      | "1 4 4 3 3" |      0 |
      | "1 5 5 5 3" |     15 |
      | "5 5 5 5 5" |     25 |
      
   @tag6
   Scenario Outline: A player wants to score the sixes category
    Given Moe rolles the dice and wants to score in a upper section category
    When Moe chooses to score the sixes category with his dice <value>
    Then I verify the <points> that Moe can get from sixes category of in step

    Examples: 
      | value       | points |
      | "4 4 5 4 4" |      0 |
      | "3 4 6 6 4" |     12 |
      | "1 4 6 3 3" |      6 |
      | "6 5 5 6 6" |     18 |
      | "6 6 6 6 6" |     30 |
      
