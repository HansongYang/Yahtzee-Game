package comp4004A1;

public class categoryChecker {
	
	public int aces(int[] dice) {
		int score = 0;
		for(int i = 0; i < dice.length; i++) {
			if(dice[i] == 1) {
				score++;
			}
		}
		return score;
	}
	
	public int twos(int[] dice) {
		int score = 0;
		for(int i = 0; i < dice.length; i++) {
			if(dice[i] == 2) {
				score += 2;
			}
		}
		return score;
	}
	
	public int threes(int[] dice) {
		int score = 0;
		for(int i = 0; i < dice.length; i++) {
			if(dice[i] == 3) {
				score += 3;
			}
		}
		return score;
	}
	
	public int fours(int[] dice) {
		int score = 0;
		for(int i = 0; i < dice.length; i++) {
			if(dice[i] == 4) {
				score += 4;
			}
		}
		return score;
	}
	
	public int fives(int[] dice) {
		int score = 0;
		for(int i = 0; i < dice.length; i++) {
			if(dice[i] == 5) {
				score += 5;
			}
		}
		return score;
	}

	public int sixes(int[] dice) {
		int score = 0;
		for(int i = 0; i < dice.length; i++) {
			if(dice[i] == 6) {
				score += 6;
			}
		}
		return score;
	}
	
	public int threeOfKind(int[] dice) {
		int score = 0;
		if(aces(dice) >= 3 || twos(dice) >= 6 || threes(dice) >= 9 || fours(dice) >= 12 || fives(dice) >= 15 || sixes(dice) >= 18) {
			for(int i = 0; i < dice.length; i++) {
				score += dice[i];
			}
		}
		return score;
	}
	
	public int fourOfKind(int[] dice) {
		int score = 0;
		if(aces(dice) >= 4 || twos(dice) >= 8 || threes(dice) >= 12 || fours(dice) >= 16 || fives(dice) >= 20 || sixes(dice)  >= 24) {
			for(int i = 0; i < dice.length; i++) {
				score += dice[i];
			}
		}
		return score;
	}
	
	public int fullHouse(int[] dice) {
		int score = 0;
		if((aces(dice) == 3 || twos(dice) == 6 || threes(dice) == 9 || fours(dice) == 12 || fives(dice) == 15 || sixes(dice)  == 18) &&
			(aces(dice) == 2 || twos(dice) == 4 || threes(dice) == 6 || fours(dice) == 8 || fives(dice) == 10 || sixes(dice)  == 12)) {
			score = 25;
		}
		return score;
	}
	
	public int smallStraight(int[] dice) {
		int score = 0;
		if((aces(dice) >= 1 && twos(dice) >= 2 && threes(dice) >= 3 && fours(dice) >= 4) ||
			(twos(dice) >= 2 && threes(dice) >= 3 && fours(dice) >= 4 && fives(dice) >= 5) ||
			(threes(dice) >= 3 && fours(dice) >= 4 && fives(dice) >= 5 && sixes(dice) >= 6)) {
			score = 30;
		}
		return score;
	}
	
	public int longStraight(int[] dice) {
		int score = 0;
		if((aces(dice) >= 1 && twos(dice) >= 2 && threes(dice) >= 3 && fours(dice) >= 4 && fives(dice) >= 5) ||
			(twos(dice) >= 2 && threes(dice) >= 3 && fours(dice) >= 4 && fives(dice) >= 5 && sixes(dice) >= 6)) {
			score = 40;
		}
		return score;
	}
	
	public int yahtzee(int[] dice) {
		int score = 0;
		if(aces(dice) == 5 || twos(dice) == 10 || threes(dice) == 15 || fours(dice) == 20 || fives(dice) == 25 || sixes(dice)  == 30) {
			score = 50;
		}
		return score;
	}
	
	public int chance(int[] dice) {
		int score = 0;
		for(int i = 0; i < dice.length; i++) {
			score += dice[i];
		}
		return score;
	}
}
