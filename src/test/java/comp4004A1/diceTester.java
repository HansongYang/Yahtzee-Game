package comp4004A1;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.Arrays;

public class diceTester extends TestCase {
	int[] dice = new int[] {0,0,0,0,0};
	
	public void testRollAllDice() {
		dice d = new dice();
		d.rollAllDice(dice);
		int values = d.totalValues(dice);
		assertThat(0, not(values));
		
		d.rollAllDice(dice);
		assertThat(values, not(d.totalValues(dice)));
	}
	
	public void testRollSomeDice() {
		Arrays.fill(dice, 0);
		dice d = new dice();
		String index = "0 4";
		
		d.rollSomeDice(index, dice);
		int values = d.totalValues(dice);
		assertThat(0, not(values));

		d.rollSomeDice(index, dice);
		assertThat(values, not(d.totalValues(dice)));
	}
	
	public void testTotalValue() {
		dice d = new dice();
		d.rollAllDice(dice);
		int values = d.totalValues(dice);
		assertThat(0, not(values));
		
		int [] dice2 = new int[] {1,2,3,4,5};
		assertEquals(d.totalValues(dice2), 15);
		
		int [] dice3 = new int[] {3,2,2,4,5};
		assertEquals(d.totalValues(dice3), 16);
	}
}
