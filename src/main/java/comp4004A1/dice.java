package comp4004A1;

import java.util.Random;

public class dice {
	public class die{
		private int result;
		
		public die() {
			result = 0;
		}
		
		public void rollDice() {
			Random rand = new Random();
			result = 1 + rand.nextInt(6);
		}
		
		public int getValue() {
			return result;
		}
		
	}
	private die d;
	
	public dice() {
		d = new die();
	}
	
	public void rollAllDice(int[] dice) {
		for(int i = 0; i < dice.length; i++) {
			d.rollDice();
			dice[i] = d.getValue();
		}
	}
	
	public void rollSomeDice(String index, int[] dice) {
		for(int i = 0; i < index.length(); i++) {
			if(index.charAt(i) != ' ') {
				d.rollDice();
				int j = index.charAt(i) - '0';
				if(j < 5 && j > 0) {
					dice[j] = d.getValue();
				}
			}
		}
	}
	
	public int totalValues(int[] dice) {
		int score = 0;
		for(int i = 0; i < dice.length; i++) {
			score += dice[i];
		}
		return score;
	}
}
