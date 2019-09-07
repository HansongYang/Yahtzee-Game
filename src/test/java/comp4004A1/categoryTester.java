package comp4004A1;

import junit.framework.TestCase;
import java.util.Arrays;

public class categoryTester extends TestCase{
	categoryChecker c = new categoryChecker();
	
	public void testAces() {
		int[] dice = new int[] {1,2,1,4,5};
		assertEquals(2,c.aces(dice));
		
		Arrays.fill(dice, 1);
		assertEquals(5,c.aces(dice));
		
		Arrays.fill(dice, 2);
		assertEquals(0,c.aces(dice));
	}
	
	public void testTwos() {
		int[] dice = new int[] {1,2,2,2,5};
		assertEquals(6,c.twos(dice));
		
		Arrays.fill(dice, 2);
		assertEquals(10,c.twos(dice));
		
		Arrays.fill(dice, 1);
		assertEquals(0,c.twos(dice));
	}
	
	public void testThrees() {
		int[] dice = new int[] {3,2,3,4,5};
		assertEquals(6,c.threes(dice));
		
		Arrays.fill(dice, 3);
		assertEquals(15,c.threes(dice));
		
		Arrays.fill(dice, 1);
		assertEquals(0,c.threes(dice));
	}
	
	public void testFours() {
		int[] dice = new int[] {3,4,4,4,4};
		assertEquals(16,c.fours(dice));
		
		Arrays.fill(dice, 4);
		assertEquals(20,c.fours(dice));
		
		Arrays.fill(dice, 1);
		assertEquals(0,c.fours(dice));
	}
	
	public void testFives() {
		int[] dice = new int[] {3,2,3,3,5};
		assertEquals(5,c.fives(dice));
		
		Arrays.fill(dice, 5);
		assertEquals(25,c.fives(dice));
		
		Arrays.fill(dice, 1);
		assertEquals(0,c.fives(dice));
	}
	
	public void testSixes() {
		int[] dice = new int[] {6,1,2,3,5};
		assertEquals(6,c.sixes(dice));
		
		Arrays.fill(dice, 6);
		assertEquals(30,c.sixes(dice));
		
		Arrays.fill(dice, 1);
		assertEquals(0,c.sixes(dice));
	}
	
	public void testThreeOfKind() {
		int[] dice = new int[] {6,1,2,2,2};
		assertEquals(13,c.threeOfKind(dice));
		
		int[] dice2 = new int[] {6,1,4,2,2};
		assertEquals(0,c.threeOfKind(dice2));
	}
	
	public void testFourOfKind() {
		int[] dice = new int[] {6,6,6,6,2};
		assertEquals(26,c.fourOfKind(dice));
		
		int[] dice2 = new int[] {6,6,6,3,2};
		assertEquals(0,c.fourOfKind(dice2));
	}
	
	public void testFullHouse() {
		int[] dice = new int[] {6,6,6,2,2};
		assertEquals(25,c.fullHouse(dice));
		
		int[] dice2 = new int[] {6,6,6,3,2};
		assertEquals(0,c.fullHouse(dice2));
	}
	
	public void testSmallStraight() {
		int[] dice = new int[] {1,3,2,2,4};
		assertEquals(30,c.smallStraight(dice));
		
		int[] dice2 = new int[] {5,3,2,2,4};
		assertEquals(30,c.smallStraight(dice2));
		
		int[] dice3 = new int[] {6,3,2,2,4};
		assertEquals(0,c.smallStraight(dice3));
	}
	
	public void testLongStraight() {
		int[] dice = new int[] {1,3,5,2,4};
		assertEquals(40,c.longStraight(dice));
		
		int[] dice2 = new int[] {5,3,2,1,4};
		assertEquals(40,c.longStraight(dice2));
		
		int[] dice3 = new int[] {6,3,2,2,4};
		assertEquals(0,c.longStraight(dice3));
	}
	
	public void testYahtzee() {
		int[] dice = new int[] {1,1,1,1,1};
		assertEquals(50, c.yahtzee(dice));
		
		int[] dice2 = new int[] {1,1,1,2,1};
		assertEquals(0, c.yahtzee(dice2));
	}
	
	public void testChance() {
		int[] dice = new int[] {2,3,3,4,6};
		assertEquals(18, c.chance(dice));
		
		int[] dice2 = new int[] {1,1,2,3,2};
		assertEquals(9, c.chance(dice2));
	}
}
