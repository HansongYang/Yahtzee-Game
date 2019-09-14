package comp4004A1;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class gameTester extends TestCase{
	yahtzeeGame game = new yahtzeeGame();
	player p1, p2, p3;

	public void testSetPlayerName() throws CloneNotSupportedException {
		game.setPlayerName("Moe");
		game.setPlayerName("Joe");
		game.setPlayerName("Sam");
		p1 = game.getPlayer("Moe");
		p2 = game.getPlayer("Joe");
		p3 = game.getPlayer("Sam");
		
		assertEquals(p1.getName(), "Moe");
		assertEquals(p2.getName(), "Joe");
		assertEquals(p3.getName(), "Sam");
	}
	
	public void testScore() throws CloneNotSupportedException {
		game.setPlayerName("Moe");
		game.setPlayerName("Joe");
		game.setPlayerName("Sam");
		int[] dice = new int[] {6,1,2,6,6};
		
		game.setDice(dice);
		game.score("Moe", 6);
		p1 = game.getPlayer("Moe");
		assertEquals(p1.totalPoints(), 18);
		
		int[] dice2 = new int[] {6,5,5,5,4};
		game.setDice(dice2);
		game.score("Joe", 5);
		p2 = game.getPlayer("Joe");
		assertEquals(p2.totalPoints(), 15);
		
		int[] dice3 = new int[] {6,5,5,5,6};
		game.setDice(dice3);
		game.score("Sam", 9);
		p3 = game.getPlayer("Sam");
		assertEquals(p3.totalPoints(), 25);
	}
	
	public void testNextRound() throws CloneNotSupportedException {
		game.setPlayerName("Moe");
		game.setPlayerName("Joe");
		game.setPlayerName("Sam");
		game.nextRound("Moe");
		game.nextRound("Joe");
		game.nextRound("Sam");
		game.nextRound("Moe");
		game.nextRound("Joe");
		game.nextRound("Sam");
		game.nextRound("Moe");
		game.nextRound("Joe");
		game.nextRound("Sam");
		
		p1 = game.getPlayer("Moe");
		p2 = game.getPlayer("Joe");
		p3 = game.getPlayer("Sam");
		assertEquals(p1.getRound(), 4);
		assertEquals(p2.getRound(), 4);
		assertEquals(p3.getRound(), 4);
	}
	
	public void testWinner() throws CloneNotSupportedException {
		game.setPlayerName("Moe");
		game.setPlayerName("Joe");
		game.setPlayerName("Sam");
		int[] dice = new int[] {6,1,2,6,6};
		game.setDice(dice);
		game.score("Moe", 6);
		
		int[] dice2 = new int[] {6,5,5,5,4};
		game.setDice(dice2);
		game.score("Joe", 5);
		
		int[] dice3 = new int[] {6,5,5,5,6};
		game.setDice(dice3);
		game.score("Sam", 9);
		
		assertEquals(game.winner(), "Sam");
	}
	
	public void testGetPlayerRound() {
		game.setPlayerName("Moe");
		game.setPlayerName("Joe");
		game.setPlayerName("Sam");
		game.nextRound("Moe");
		game.nextRound("Joe");
		game.nextRound("Sam");
		game.nextRound("Moe");
		game.nextRound("Joe");
		game.nextRound("Sam");
		game.nextRound("Moe");
		game.nextRound("Joe");
		game.nextRound("Moe");
		
		assertEquals(game.getPlayerRound("Moe"), 5);
		assertEquals(game.getPlayerRound("Joe"), 4);
		assertEquals(game.getPlayerRound("Sam"), 3);
	}
	
	public void testNextRound2() {
		game.setPlayerName("Moe");
		game.setPlayerName("Joe");
		game.setPlayerName("Sam");
		game.nextRound("Moe");
		game.nextRound("Joe");
		game.nextRound("Sam");
		game.nextRound("Moe");
		game.nextRound("Joe");
		game.nextRound("Sam");
		game.nextRound("Moe");
		game.nextRound("Joe");
		game.nextRound("Sam");
		
		assertEquals(game.nextRound(), true);
	}
}
