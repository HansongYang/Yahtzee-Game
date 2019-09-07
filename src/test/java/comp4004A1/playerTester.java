package comp4004A1;

import junit.framework.TestCase;

public class playerTester extends TestCase{
	public void testAddPoint() {
		player p1 = new player();
		p1.addPoints(0, 3);
		p1.addPoints(1, 6);
		p1.addPoints(2, 6);
		p1.addPoints(3, 8);
		p1.addPoints(4, 5);
		p1.addPoints(5, 12);
		p1.addPoints(6, 13);
		p1.addPoints(7, 17);
		p1.addPoints(8, 25);
		p1.addPoints(9, 30);
		p1.addPoints(10, 40);
		p1.addPoints(11, 50);
		p1.addPoints(12, 20);

		assertEquals(235, p1.totalPoints());
		
		player p2 = new player();
		p2.addPoints(0, 3);
		p2.addPoints(1, 0);
		p2.addPoints(2, 6);
		p2.addPoints(3, 0);
		p2.addPoints(4, 5);
		p2.addPoints(5, 12);
		p2.addPoints(6, 13);
		p2.addPoints(7, 17);
		p2.addPoints(8, 25);
		p2.addPoints(9, 30);
		p2.addPoints(10, 40);
		p2.addPoints(11, 0);
		p2.addPoints(12, 20);

		assertEquals(171, p2.totalPoints());
		
		player p3 = new player();
		p3.addPoints(0, 3);
		p3.addPoints(1, 2);
		p3.addPoints(2, 6);
		p3.addPoints(3, 4);
		p3.addPoints(4, 5);
		p3.addPoints(5, 18);
		p3.addPoints(6, 13);
		p3.addPoints(7, 17);
		p3.addPoints(8, 25);
		p3.addPoints(9, 30);
		p3.addPoints(10, 40);
		p3.addPoints(11, 50);
		p3.addPoints(12, 20);
		p3.addYahtzee();

		assertEquals(333, p3.totalPoints());
		
		player p4 = new player();
		p4.addPoints(0, 3);
		p4.addPoints(1, 6);
		p4.addPoints(2, 9);
		p4.addPoints(3, 12);
		p4.addPoints(4, 15);
		p4.addPoints(5, 18);
		p4.addPoints(6, 13);
		p4.addPoints(7, 17);
		p4.addPoints(8, 25);
		p4.addPoints(9, 30);
		p4.addPoints(10, 40);
		p4.addPoints(11, 50);
		p4.addPoints(12, 20);

		assertEquals(293, p4.totalPoints());
	}
	
	public void testCheckPoint() {
		player p = new player();
		p.addPoints(0, 3);
		p.addPoints(1, 6);
		p.addPoints(2, 9);
		p.addPoints(3, 12);
		
		assertEquals(3, p.checkPoint(0));
		assertEquals(6, p.checkPoint(1));
		assertEquals(9, p.checkPoint(2));
		assertEquals(12, p.checkPoint(3));
	}
}
