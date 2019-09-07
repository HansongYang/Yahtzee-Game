package comp4004A1;

public class yahtzeeGame {
	private player p1 = new player();
	private player p2 = new player();
	private player p3 = new player();
	private int round = 1;
	private categoryChecker c = new categoryChecker();
	private int[] dice = new int[] {0,0,0,0,0};
	private dice d = new dice();
	
	public void setPlayerName(String name) {
		if(p1.getName().equals("")){
			p1.setName(name);
		} else if(p2.getName().equals("")) {
			p2.setName(name);
		} else {
			p3.setName(name);
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
	
	public void printAllDice() {
		System.out.print("Your rolled:    ");
		for(int i = 0; i < dice.length; i++) {
			System.out.print("| "  + dice[i] + " |");
		}
	}
	
	public void score(String name, int index, int points) {
		if(p1.getName().equals(name)){
			p1.addPoints(index, points);
		} else if(p2.getName().equals(name)) {
			p2.addPoints(index, points);
		} else if (p3.getName().equals(name)){
			p3.addPoints(index, points);
		}
	}
	
	public void rollAllDice() {
		d.rollAllDice(dice);
	}
	
	public void rollSomeDice(int[] index, int[] dice) {
		d.rollSomeDice(index, dice);
	}
	
	public void printGameBoard(String name) {
		if(name.equals(p1.getName())) {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("| Name: "+p1.getName()+"                 | Current Score: "+p1.totalPoints()+ "   |    Current Round: " + p1.getRound() + "   |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("(1) Ones:  " +p1.checkPoint(0)+" | (2) Twos:   " + p1.checkPoint(1) + "| (3) Threes:  "+ p1.checkPoint(2)+ "| (4) Fours:  "+ p1.checkPoint(3) 
								+ "| (5) Fives:   "+ p1.checkPoint(4) + "| (6) Sixes:   " + p1.checkPoint(5) + "| Bonus:   " + p1.bonus()+"|");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (7) Large Straight: " + p1.checkPoint(6) + " | (8) Small Straight: " + p1.checkPoint(7) + " | (9) Full House: "
								+p1.checkPoint(8)+ " | (10) Three of a kind: " + p1.checkPoint(9) + "    |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (11) Four of a kind: " + p1.checkPoint(10) + " | (12) Chance: " + p1.checkPoint(11) + " | (13) Yahtzee " + p1.checkPoint(12) + "    |");
			
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("| Name: "+p2.getName()+"                 | Current Score: "+p2.totalPoints()+ "   |    Current Round: " + p2.getRound() + "   |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("(1) Ones:  " +p2.checkPoint(0)+" | (2) Twos:   " + p2.checkPoint(1) + "| (3) Threes:  "+p2.checkPoint(2)+ "| (4) Fours:  "+ p2.checkPoint(3)
								+ "| (5) Fives:   "+ p2.checkPoint(4) + "| (6) Sixes:   " + p2.checkPoint(5) + "| Bonus:   " + p2.bonus()+"|");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (7) Large Straight: " + p2.checkPoint(6) + " | (8) Small Straight: " + p2.checkPoint(7) + " | (9) Full House: "
								+p2.checkPoint(8)+ " | (10) Three of a kind: " + p2.checkPoint(9) + "    |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (11) Four of a kind: " + p2.checkPoint(10) + " | (12) Chance: " + p2.checkPoint(11) + " | (13) Yahtzee " + p2.checkPoint(12) + "    |");
			
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("| Name: "+p3.getName()+"                 | Current Score: "+p3.totalPoints()+ "   |    Current Round: " + p3.getRound() + "   |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("(1) Ones:  " +p3.checkPoint(0)+" | (2) Twos:   " + p3.checkPoint(1) + "| (3) Threes:  "+ p3.checkPoint(2)+ "| (4) Fours:  "+ p3.checkPoint(3) 
								+ "| (5) Fives:   "+ p3.checkPoint(4) + "| (6) Sixes:   " + p3.checkPoint(5) + "| Bonus:   " + p3.bonus()+"|");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (7) Large Straight: " + p3.checkPoint(6) + " | (8) Small Straight: " + p3.checkPoint(7) + " | (9) Full House: "
								+p3.checkPoint(8)+ " | (10) Three of a kind: " + p3.checkPoint(9) + "    |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (11) Four of a kind: " + p3.checkPoint(10) + " | (12) Chance: " + p3.checkPoint(11) + " | (13) Yahtzee " + p3.checkPoint(12) + "    |");
		} else if(name.equals(p2.getName())){
			System.out.println("-------------------------------------------------------------------");
			System.out.println("| Name: "+p2.getName()+"                 | Current Score: "+p2.totalPoints()+ "   |    Current Round: " + p2.getRound() + "   |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("(1) Ones:  " +p2.checkPoint(0)+" | (2) Twos:   " + p2.checkPoint(1) + "| (3) Threes:  "+p2.checkPoint(2)+ "| (4) Fours:  "+ p2.checkPoint(3)
								+ "| (5) Fives:   "+ p2.checkPoint(4) + "| (6) Sixes:   " + p2.checkPoint(5) + "| Bonus:   " + p2.bonus()+"|");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (7) Large Straight: " + p2.checkPoint(6) + " | (8) Small Straight: " + p2.checkPoint(7) + " | (9) Full House: "
								+p2.checkPoint(8)+ " | (10) Three of a kind: " + p2.checkPoint(9) + "    |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (11) Four of a kind: " + p2.checkPoint(10) + " | (12) Chance: " + p2.checkPoint(11) + " | (13) Yahtzee " + p2.checkPoint(12) + "    |");
			
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("| Name: "+p1.getName()+"                 | Current Score: "+p1.totalPoints()+ "   |    Current Round: " + p1.getRound() + "   |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("(1) Ones:  " +p1.checkPoint(0)+" | (2) Twos:   " + p1.checkPoint(1) + "| (3) Threes:  "+ p1.checkPoint(2)+ "| (4) Fours:  "+ p1.checkPoint(3) 
								+ "| (5) Fives:   "+ p1.checkPoint(4) + "| (6) Sixes:   " + p1.checkPoint(5) + "| Bonus:   " + p1.bonus()+"|");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (7) Large Straight: " + p1.checkPoint(6) + " | (8) Small Straight: " + p1.checkPoint(7) + " | (9) Full House: "
								+p1.checkPoint(8)+ " | (10) Three of a kind: " + p1.checkPoint(9) + "    |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (11) Four of a kind: " + p1.checkPoint(10) + " | (12) Chance: " + p1.checkPoint(11) + " | (13) Yahtzee! " + p1.checkPoint(12) + "    |");
			
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("| Name: "+p3.getName()+"                 | Current Score: "+p3.totalPoints()+ "   |    Current Round: " + p3.getRound() + "   |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("(1) Ones:  " +p3.checkPoint(0)+" | (2) Twos:   " + p3.checkPoint(1) + "| (3) Threes:  "+ p3.checkPoint(2)+ "| (4) Fours:  "+ p3.checkPoint(3) 
								+ "| (5) Fives:   "+ p3.checkPoint(4) + "| (6) Sixes:   " + p3.checkPoint(5) + "| Bonus:   " + p3.bonus()+"|");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (7) Large Straight: " + p3.checkPoint(6) + " | (8) Small Straight: " + p3.checkPoint(7) + " | (9) Full House: "
								+p3.checkPoint(8)+ " | (10) Three of a kind: " + p3.checkPoint(9) + "    |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (11) Four of a kind: " + p3.checkPoint(10) + " | (12) Chance: " + p3.checkPoint(11) + " | (13) Yahtzee " + p3.checkPoint(12) + "    |");
		} else if(name.equals(p3.getName())){
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("| Name: "+p3.getName()+"                 | Current Score: "+p3.totalPoints()+ "   |    Current Round: " + p3.getRound() + "   |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("(1) Ones:  " +p3.checkPoint(0)+" | (2) Twos:   " + p3.checkPoint(1) + "| (3) Threes:  "+ p3.checkPoint(2)+ "| (4) Fours:  "+ p3.checkPoint(3) 
								+ "| (5) Fives:   "+ p3.checkPoint(4) + "| (6) Sixes:   " + p3.checkPoint(5) + "| Bonus:   " + p3.bonus()+"|");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (7) Large Straight: " + p3.checkPoint(6) + " | (8) Small Straight: " + p3.checkPoint(7) + " | (9) Full House: "
								+p3.checkPoint(8)+ " | (10) Three of a kind: " + p3.checkPoint(9) + "    |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (11) Four of a kind: " + p3.checkPoint(10) + " | (12) Chance: " + p3.checkPoint(11) + " | (13) Yahtzee " + p3.checkPoint(12) + "    |");
			
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("| Name: "+p1.getName()+"                 | Current Score: "+p1.totalPoints()+ "   |    Current Round: " + p1.getRound() + "   |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("(1) Ones:  " +p1.checkPoint(0)+" | (2) Twos:   " + p1.checkPoint(1) + "| (3) Threes:  "+ p1.checkPoint(2)+ "| (4) Fours:  "+ p1.checkPoint(3) 
								+ "| (5) Fives:   "+ p1.checkPoint(4) + "| (6) Sixes:   " + p1.checkPoint(5) + "| Bonus:   " + p1.bonus()+"|");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (7) Large Straight: " + p1.checkPoint(6) + " | (8) Small Straight: " + p1.checkPoint(7) + " | (9) Full House: "
								+p1.checkPoint(8)+ " | (10) Three of a kind: " + p1.checkPoint(9) + "    |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (11) Four of a kind: " + p1.checkPoint(10) + " | (12) Chance: " + p1.checkPoint(11) + " | (13) Yahtzee " + p1.checkPoint(12) + "    |");
			
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("| Name: "+p2.getName()+"                 | Current Score: "+p2.totalPoints()+ "   |    Current Round: " + p2.getRound() + "   |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("(1) Ones:  " +p2.checkPoint(0)+" | (2) Twos:   " + p2.checkPoint(1) + "| (3) Threes:  "+p2.checkPoint(2)+ "| (4) Fours:  "+ p2.checkPoint(3)
								+ "| (5) Fives:   "+ p2.checkPoint(4) + "| (6) Sixes:   " + p2.checkPoint(5) + "| Bonus:   " + p2.bonus()+"|");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (7) Large Straight: " + p2.checkPoint(6) + " | (8) Small Straight: " + p2.checkPoint(7) + " | (9) Full House: "
								+p2.checkPoint(8)+ " | (10) Three of a kind: " + p2.checkPoint(9) + "    |");
			System.out.println("| ----------------------------------------------------------------- |");
			System.out.println("| (11) Four of a kind: " + p2.checkPoint(10) + " | (12) Chance: " + p2.checkPoint(11) + " | (13) Yahtzee " + p2.checkPoint(12) + "    |");
		}
	}
}
