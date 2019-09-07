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
	
	public void rollSomeDice(int[] index, int[] dice) {
		for(int i = 0; i < index.length; i++) {
			d.rollDice();
			dice[index[i]] = d.getValue();
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
