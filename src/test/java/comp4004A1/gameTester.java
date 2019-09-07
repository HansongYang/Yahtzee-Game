package comp4004A1;

import junit.framework.TestCase;

public class gameTester extends TestCase{
	yahtzeeGame game = new yahtzeeGame();
	player p1, p2, p3;
	int[] dice = new int[] {0,0,0,0,0};
	
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
		game.score("Moe", 1, 4);
		game.score("Moe", 0, 2);
		game.score("Moe", 3, 6);
		game.score("Moe", 8, 25);
		game.score("Moe", 12, 50);
		game.score("Moe", 9, 20);
		game.score("Joe", 1, 2);
		game.score("Joe", 4, 10);
		game.score("Joe", 10, 27);
		game.score("Joe", 7, 30);
		game.score("Joe", 6, 40);
		game.score("Sam", 1, 4);
		game.score("Sam", 12, 50);
		game.score("Sam", 9, 21);
		game.score("Sam", 4, 5);
		game.score("Sam", 5, 24);
		p1 = game.getPlayer("Moe");
		p2 = game.getPlayer("Joe");
		p3 = game.getPlayer("Sam");
		
		assertEquals(p1.totalPoints(), 107);
		assertEquals(p2.totalPoints(), 109);
		assertEquals(p3.totalPoints(), 104);
	}
}
