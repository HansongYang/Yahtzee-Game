package comp4004A1;

public class player implements Cloneable {
	private String name = "";
	private boolean firstYahtzee = false;
	private int[] categories = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] yahtzees = new int[] {0,0,0};
	private int round = 1;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getRound() {
		return round;
	}
	
	public void setRound(int round) {
		this.round = round;
	}
	
	public void nextRound() {
		round++;
	}
	
	public boolean firstYahtzee() {
		return firstYahtzee;
	}
	
	public int checkPoint(int index) {
		if(index >= categories.length) {
			return 0;
		}
		return categories[index];
	}
	
	public boolean addPoints(int index, int p) {
		if(index == 12) {
			firstYahtzee = true;
		}
		if(categories[index] == 0) {
			categories[index] = p;
			return true;
		}
		return false;
	}
	
	public void addYahtzee() {
		firstYahtzee = false;
		for(int i = 0; i < yahtzees.length; i++) {
			if(yahtzees[i] == 0) {
				yahtzees[i] = 100;
				break;
			}
		}
	}
	
	public int bonus() {
		int points = 0;
		boolean bonus = false;
		for(int i = 0; i < categories.length; i++) {
			points += categories[i];
			if(i == 5 && points >= 63) {
				bonus = true;
				break;
			}
		}
		if(bonus) {
			return 35;
		}
		return 0;
	}
	
	public int totalPoints() {
		int points = 0;
		for(int i = 0; i < categories.length; i++) {
			points += categories[i];
		}
		
		points += bonus();
		
		for(int i = 0; i < yahtzees.length; i++) {
			points += yahtzees[i];
		}
		return points;
	}
	
	 @Override
	 protected Object clone() throws CloneNotSupportedException {
		 return super.clone();
	 }
}
