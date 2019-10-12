package comp4004A1; 

public class yahtzeeGame {
	private player p1 = new player();
	private player p2 = new player();
	private player p3 = new player();
	private int[] dice = new int[] {0,0,0,0,0};
	private categoryChecker c = new categoryChecker();
	private dice d = new dice();
	
	public void setPlayerName(String name) {
		if(p1.getName().equals("")){
			p1.setName(name);
		} else if(p2.getName().equals("")) {
			p2.setName(name);
		} else if (p3.getName().equals("")){
			p3.setName(name);
		}
	}
	
	public void setDice(int[] d) {
		for(int i = 0; i < dice.length; i++) {
			dice[i] = d[i];
		}
	}
	
	public player getPlayer(String name) throws CloneNotSupportedException {
		if(p1.getName().equals(name)){
			return (player) p1.clone();
		} else if(p2.getName().equals(name)) {
			return (player) p2.clone();
		} else if (p3.getName().equals(name)){
			return (player) p3.clone();
		}
		return null;
	}
	
	public int getPlayerPoints(String name) {
		if(p1.getName().equals(name)){
			return p1.totalPoints();
		} else if(p2.getName().equals(name)) {
			return p2.totalPoints();
		} else if (p3.getName().equals(name)){
			return p3.totalPoints();
		}
		return 0;
	}
	
	public int getPlayerRound(String name) {
		if(p1.getName().equals(name)){
			return p1.getRound();
		} else if(p2.getName().equals(name)) {
			return p2.getRound();
		} else if (p3.getName().equals(name)){
			return p3.getRound();
		}
		return 0;
	}
	
	public boolean nextRound() {
		if((p1.getRound() == p2.getRound()) && (p2.getRound() == p3.getRound())) {
			return true;
		}
		return false;
	}
	
	public String printAllDice() {
		StringBuilder out = new StringBuilder(""); 
		out.append(" rolled:    ");
		for(int i = 0; i < dice.length; i++) {
			out.append("| "  + dice[i] + " |   ");
		}
		out.append('\n');
		return out.toString();
	}
	
	public boolean score(String name, int index) {
		int points = 0;
		switch(index) {
			case 1:
				points = c.aces(dice);
				break;
			case 2:
				points = c.twos(dice);
				break;
			case 3:
				points = c.threes(dice);
				break;
			case 4: 
				points = c.fours(dice);
				break;
			case 5:
				points = c.fives(dice);
				break;
			case 6:
				points = c.sixes(dice);
				break;
			case 7:
				points = c.longStraight(dice);
				break;
			case 8:
				points = c.smallStraight(dice);
				break;
			case 9:
				points = c.fullHouse(dice);
				break;
			case 10:
				points = c.threeOfKind(dice);
				break;
			case 11:
				points = c.fourOfKind(dice);
				break;
			case 12:
				points = c.chance(dice);
				break;
			case 13:
				points = c.yahtzee(dice);
				break;
			default:
				points = 0;
		}

		index--;
		if(p1.getName().equals(name)){
			if(points == 50  && p1.firstYahtzee()) {
				p1.addYahtzee();
			}
			return p1.addPoints(index, points);
		} else if(p2.getName().equals(name)) {
			if(points == 50  && p2.firstYahtzee()) {
				p2.addYahtzee();
			}
			return p2.addPoints(index, points);
		} else if (p3.getName().equals(name)){
			if(points == 50  && p3.firstYahtzee()) {
				p3.addYahtzee();
			}
			return p3.addPoints(index, points);
		}
		return false;
	}
	
	public String nextRound(String name) {
		if(p1.getName().equals(name)){
			p1.nextRound();
		} else if(p2.getName().equals(name)) {
			p2.nextRound();
		} else if (p3.getName().equals(name)){
			p3.nextRound();
		}
		
		if(p1.getRound() == 14 && p2.getRound() == 14 && p3.getRound() == 14) {
			return winner();
		}
		return null;
	}
	
	public void setCurrentRound(int round) {
		p1.setRound(round);
		p2.setRound(round);
		p3.setRound(round);
	}
	
	public String winner() {
		if(p1.totalPoints() >= p2.totalPoints() && p1.totalPoints() >= p3.totalPoints()) {
			return p1.getName();
		} else if(p2.totalPoints() >= p1.totalPoints() && p2.totalPoints() >= p3.totalPoints()) {
			return p2.getName();
		} else if (p3.totalPoints() >= p1.totalPoints() && p3.totalPoints() >= p2.totalPoints()) {
			return p3.getName();
		}
		return null;
	}
	
	public void rollAllDice() {
		d.rollAllDice(dice);
	}
	
	public void rollSomeDice(String index) {
		d.rollSomeDice(index, dice);
	}
	
	public String printGameBoard(String name) {
		StringBuilder out = new StringBuilder(""); 
		if(name.equals(p1.getName())) {
			out.append("---------------------------------------------------------------------------------------------------------------\n");
			out.append(" | Name: "+p1.getName()+"            |    Current Score: "+p1.totalPoints()+ "     |      Current Round: " + p1.getRound() + "                                      |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (1) Ones:  " +p1.checkPoint(0)+" | (2) Twos:   " + p1.checkPoint(1) + " | (3) Threes:  "+ p1.checkPoint(2)+ " | (4) Fours:  "+ p1.checkPoint(3) 
						+ " | (5) Fives:   "+ p1.checkPoint(4) + " | (6) Sixes:   " + p1.checkPoint(5) + " | Bonus:  " + p1.bonus()+" |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (7) Large Straight: " + p1.checkPoint(6) + " | (8) Small Straight: " + p1.checkPoint(7) + " | (9) Full House: "
						+p1.checkPoint(8)+ " | (10) Three of a kind: " + p1.checkPoint(9) + "                 |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (11) Four of a kind: " + p1.checkPoint(10) + "    | (12) Chance: " + p1.checkPoint(11) + "      | (13) Yahtzee!: " + p1.checkPoint(12) + "                                          |\n");
			out.append("----------------------------------------------------------------------------------------------------------------\n");
			
			out.append(" \n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
			out.append(" | Name: "+p2.getName()+"            |    Current Score: "+p2.totalPoints()+ "        |      Current Round: " + p2.getRound() + "                                   |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (1) Ones:  " +p2.checkPoint(0)+" | (2) Twos:   " + p2.checkPoint(1) + " | (3) Threes:  "+p2.checkPoint(2)+ " | (4) Fours:  "+ p2.checkPoint(3)
						+ " | (5) Fives:   "+ p2.checkPoint(4) + " | (6) Sixes:   " + p2.checkPoint(5) + " | Bonus:  " + p2.bonus()+" |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (7) Large Straight: " + p2.checkPoint(6) + " | (8) Small Straight: " + p2.checkPoint(7) + " | (9) Full House: "
						+p2.checkPoint(8)+ " | (10) Three of a kind: " + p2.checkPoint(9) + "                 |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (11) Four of a kind: " + p2.checkPoint(10) + "    | (12) Chance: " + p2.checkPoint(11) + "      | (13) Yahtzee!: " + p2.checkPoint(12) + "                                          |\n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
			
			out.append(" \n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
			out.append(" | Name: "+p3.getName()+"            |    Current Score: "+p3.totalPoints()+ "     |    Current Round: " + p3.getRound() + "                                        |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (1) Ones:  " +p3.checkPoint(0)+" | (2) Twos:   " + p3.checkPoint(1) + " | (3) Threes:  "+ p3.checkPoint(2)+ " | (4) Fours:  "+ p3.checkPoint(3) 
								+ " | (5) Fives:   "+ p3.checkPoint(4) + " | (6) Sixes:   " + p3.checkPoint(5) + " | Bonus:  " + p3.bonus()+" |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (7) Large Straight: " + p3.checkPoint(6) + " | (8) Small Straight: " + p3.checkPoint(7) + " | (9) Full House: "
						+p3.checkPoint(8)+ " | (10) Three of a kind: " + p3.checkPoint(9) + "                 |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (11) Four of a kind: " + p3.checkPoint(10) + "    | (12) Chance: " + p3.checkPoint(11) + "      | (13) Yahtzee!: " + p3.checkPoint(12) + "                                          |\n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
		} else if(name.equals(p2.getName())){
			out.append("---------------------------------------------------------------------------------------------------------------\n");
			out.append(" | Name: "+p2.getName()+"            |    Current Score: "+p2.totalPoints()+ "        |      Current Round: " + p2.getRound() + "                                   |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (1) Ones:  " +p2.checkPoint(0)+" | (2) Twos:   " + p2.checkPoint(1) + " | (3) Threes:  "+p2.checkPoint(2)+ " | (4) Fours:  "+ p2.checkPoint(3)
						+ " | (5) Fives:   "+ p2.checkPoint(4) + " | (6) Sixes:   " + p2.checkPoint(5) + " | Bonus:  " + p2.bonus()+" |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (7) Large Straight: " + p2.checkPoint(6) + " | (8) Small Straight: " + p2.checkPoint(7) + " | (9) Full House: "
						+p2.checkPoint(8)+ " | (10) Three of a kind: " + p2.checkPoint(9) + "                 |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (11) Four of a kind: " + p2.checkPoint(10) + "    | (12) Chance: " + p2.checkPoint(11) + "      | (13) Yahtzee!: " + p2.checkPoint(12) + "                                          |\n");
			out.append("----------------------------------------------------------------------------------------------------------------\n");
	
			out.append(" \n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
			out.append(" | Name: "+p1.getName()+"            |    Current Score: "+p1.totalPoints()+ "     |      Current Round: " + p1.getRound() + "                                      |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (1) Ones:  " +p1.checkPoint(0)+" | (2) Twos:   " + p1.checkPoint(1) + " | (3) Threes:  "+ p1.checkPoint(2)+ " | (4) Fours:  "+ p1.checkPoint(3) 
						+ " | (5) Fives:   "+ p1.checkPoint(4) + " | (6) Sixes:   " + p1.checkPoint(5) + " | Bonus:  " + p1.bonus()+" |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (7) Large Straight: " + p1.checkPoint(6) + " | (8) Small Straight: " + p1.checkPoint(7) + " | (9) Full House: "
						+p1.checkPoint(8)+ " | (10) Three of a kind: " + p1.checkPoint(9) + "                 |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (11) Four of a kind: " + p1.checkPoint(10) + "    | (12) Chance: " + p1.checkPoint(11) + "      | (13) Yahtzee!: " + p1.checkPoint(12) + "                                          |\n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
			
			out.append(" \n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
			out.append(" | Name: "+p3.getName()+"            |    Current Score: "+p3.totalPoints()+ "     |    Current Round: " + p3.getRound() + "                                        |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (1) Ones:  " +p3.checkPoint(0)+" | (2) Twos:   " + p3.checkPoint(1) + " | (3) Threes:  "+ p3.checkPoint(2)+ " | (4) Fours:  "+ p3.checkPoint(3) 
						+ " | (5) Fives:   "+ p3.checkPoint(4) + " | (6) Sixes:   " + p3.checkPoint(5) + " | Bonus:  " + p3.bonus()+" |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (7) Large Straight: " + p3.checkPoint(6) + " | (8) Small Straight: " + p3.checkPoint(7) + " | (9) Full House: "
						+p3.checkPoint(8)+ " | (10) Three of a kind: " + p3.checkPoint(9) + "                 |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (11) Four of a kind: " + p3.checkPoint(10) + "    | (12) Chance: " + p3.checkPoint(11) + "      | (13) Yahtzee!: " + p3.checkPoint(12) + "                                          |\n");
			out.append("----------------------------------------------------------------------------------------------------------------\n");
		} else if(name.equals(p3.getName())){
			out.append("---------------------------------------------------------------------------------------------------------------\n");
			out.append(" | Name: "+p3.getName()+"            |    Current Score: "+p3.totalPoints()+ "     |      Current Round: " + p3.getRound() + "                                      |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (1) Ones:  " +p3.checkPoint(0)+" | (2) Twos:   " + p3.checkPoint(1) + " | (3) Threes:  "+ p3.checkPoint(2)+ " | (4) Fours:  "+ p3.checkPoint(3) 
								+ " | (5) Fives:   "+ p3.checkPoint(4) + " | (6) Sixes:   " + p3.checkPoint(5) + " | Bonus:  " + p3.bonus()+" |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (7) Large Straight: " + p3.checkPoint(6) + " | (8) Small Straight: " + p3.checkPoint(7) + " | (9) Full House: "
						+p3.checkPoint(8)+ " | (10) Three of a kind: " + p3.checkPoint(9) + "                 |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (11) Four of a kind: " + p3.checkPoint(10) + "    | (12) Chance: " + p3.checkPoint(11) + "      | (13) Yahtzee!: " + p3.checkPoint(12) + "                                          |\n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
			
			out.append(" \n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
			out.append(" | Name: "+p1.getName()+"            |    Current Score: "+p1.totalPoints()+ "     |      Current Round: " + p1.getRound() + "                                      |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (1) Ones:  " +p1.checkPoint(0)+" | (2) Twos:   " + p1.checkPoint(1) + " | (3) Threes:  "+ p1.checkPoint(2)+ " | (4) Fours:  "+ p1.checkPoint(3) 
						+ " | (5) Fives:   "+ p1.checkPoint(4) + " | (6) Sixes:   " + p1.checkPoint(5) + " | Bonus:  " + p1.bonus()+" |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (7) Large Straight: " + p1.checkPoint(6) + " | (8) Small Straight: " + p1.checkPoint(7) + " | (9) Full House: "
						+p1.checkPoint(8)+ " | (10) Three of a kind: " + p1.checkPoint(9) + "                 |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (11) Four of a kind: " + p1.checkPoint(10) + "    | (12) Chance: " + p1.checkPoint(11) + "      | (13) Yahtzee!: " + p1.checkPoint(12) + "                                          |\n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
			
			out.append(" \n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
			out.append(" | Name: "+p2.getName()+"            |    Current Score: "+p2.totalPoints()+ "        |    Current Round: " + p2.getRound() + "                                     |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (1) Ones:  " +p2.checkPoint(0)+" | (2) Twos:   " + p2.checkPoint(1) + " | (3) Threes:  "+p2.checkPoint(2)+ " | (4) Fours:  "+ p2.checkPoint(3)
						+ " | (5) Fives:   "+ p2.checkPoint(4) + " | (6) Sixes:   " + p2.checkPoint(5) + " | Bonus:  " + p2.bonus()+" |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (7) Large Straight: " + p2.checkPoint(6) + " | (8) Small Straight: " + p2.checkPoint(7) + " | (9) Full House: "
						+p2.checkPoint(8)+ " | (10) Three of a kind: " + p2.checkPoint(9) + "                 |\n");
			out.append(" | ----------------------------------------------------------------------------------------------------------- |\n");
			out.append(" | (11) Four of a kind: " + p2.checkPoint(10) + "    | (12) Chance: " + p2.checkPoint(11) + "      | (13) Yahtzee!: " + p2.checkPoint(12) + "                                          |\n");
			out.append(" ---------------------------------------------------------------------------------------------------------------\n");
		}
		return out.toString();
	}
}
