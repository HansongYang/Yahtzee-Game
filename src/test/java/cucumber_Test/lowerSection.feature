@LowerSectionCategory
Feature: Test lower section category

  @tag1
  Scenario Outline: A player wants to score the large Straight category
    Given Moe rolles the dice and wants to score in a lower section category
    When Moe chooses to score the large Straight category with his dice <value>
    Then I verify the <points> that Moe can get from large Straight category of in step

    Examples: 
      | value       | points |
      | "4 4 5 4 4" |      0 |
      | "1 2 3 5 5" |      0 |
      | "1 2 3 4 5" |     40 |
      | "2 3 4 5 6" |     40 |
      | "3 4 5 6 1" |      0 |

  @tag2
  Scenario Outline: A player wants to score the small Straight category
    Given Moe rolles the dice and wants to score in a lower section category
    When Moe chooses to score the small Straight category with his dice <value>
    Then I verify the <points> that Moe can get from small Straight category of in step

    Examples: 
      | value       | points |
      | "4 4 5 4 4" |      0 |
      | "1 2 3 4 6" |     30 |
      | "3 2 3 4 5" |     30 |
      | "1 3 4 5 6" |     30 |
      | "2 4 5 6 1" |      0 |

  @tag3
  Scenario Outline: A player wants to score the Full House category
    Given Moe rolles the dice and wants to score in a lower section category
    When Moe chooses to score the Full House category with his dice <value>
    Then I verify the <points> that Moe can get from Full House category of in step

    Examples: 
      | value       | points |
      | "4 4 5 5 4" |     25 |
      | "1 2 3 3 2" |      0 |
      | "3 2 3 3 5" |      0 |
      | "4 4 4 4 1" |      0 |
      | "2 2 4 4 4" |     25 |

  @tag4
  Scenario Outline: A player wants to score the Three of a kind category
    Given Moe rolles the dice and wants to score in a lower section category
    When Moe chooses to score the Three of a kind category with his dice <value>
    Then I verify the <points> that Moe can get from Three of a kind category of in step

    Examples: 
      | value       | points |
      | "4 4 5 6 4" |     23 |
      | "1 2 3 3 2" |      0 |
      | "3 2 3 3 5" |     16 |
      | "4 4 4 5 1" |     18 |
      | "2 2 3 4 4" |      0 |

  @tag5
  Scenario Outline: A player wants to score the Four of a kind category
    Given Moe rolles the dice and wants to score in a lower section category
    When Moe chooses to score the Four of a kind category with his dice <value>
    Then I verify the <points> that Moe can get from Four of a kind category of in step

    Examples: 
      | value       | points |
      | "4 4 5 4 4" |     21 |
      | "1 3 3 3 2" |      0 |
      | "3 3 3 3 5" |     17 |
      | "4 4 4 4 1" |     17 |
      | "2 2 3 4 4" |      0 |

  @tag6
  Scenario Outline: A player wants to score the chance category
    Given Moe rolles the dice and wants to score in a lower section category
    When Moe chooses to score the chance category with his dice <value>
    Then I verify the <points> that Moe can get from chance category of in step

    Examples: 
      | value       | points |
      | "3 3 4 4 5" |     19 |
      | "1 3 3 2 2" |     11 |
      | "3 3 5 1 5" |     17 |

  @tag7
  Scenario Outline: A player wants to score the yahtzee category
    Given Moe rolles the dice and wants to score in a lower section category
    When Moe chooses to score the yahtzee category with his dice <value>
    Then I verify the <points> that Moe can get from yahtzee category of in step

    Examples: 
      | value       | points |
      | "4 4 4 4 4" |     50 |
      | "1 3 3 3 2" |      0 |
      | "3 3 3 3 5" |      0 |
      | "4 4 4 4 1" |      0 |
      | "1 1 1 1 1" |     50 |

