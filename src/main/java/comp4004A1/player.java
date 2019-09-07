package comp4004A1;

public class player {
	private String name = "";
	private boolean firstYahtzee = false;
	private int[] categories = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] yahtzees = new int[] {0,0,0};
	private boolean bonus = false;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean firstYahtzee() {
		return firstYahtzee;
	}
	
	public void addPoints(int index, int p) {
		if(index == 12) {
			firstYahtzee = true;
		}
		categories[index] = p;
	}
	
	public void addYahtzee() {
		for(int i = 0; i < yahtzees.length; i++) {
			if(yahtzees[i] == 0) {
				yahtzees[i] = 100;
				break;
			}
		}
	}
	
	public int bonus() {
		int points = 0;
		for(int i = 0; i < categories.length; i++) {
			if(i == 5 && points >= 63) {
				bonus = true;
				break;
			}
			points += categories[i];
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
		
		if(bonus) {
			points += 35;
		}
		
		for(int i = 0; i < yahtzees.length; i++) {
			points += yahtzees[i];
		}
		return points;
	}
}
