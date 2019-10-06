package cucumber_classes;
import static org.junit.Assert.assertEquals;
import comp4004A1.categoryChecker;
import comp4004A1.player;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class playerFeature {
	private player p = new player();
	private categoryChecker c = new categoryChecker();
	private int [] dice = new int[5];
	private boolean bonus = false;
	
	@Given("Moe rolles the dice and wants to score the yahtzee bonus")
	public void moe_rolles_the_dice_and_wants_to_score_the_yahtzee_bonus() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Moe rolles the dice and wants to score the yahtzee bonus.");
	}

	@When("Moe chooses to score the yahtzee bonus category with his dice {string}")
	public void moe_chooses_to_score_the_yahtzee_bonus_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
		if(c.yahtzee(dice) == 50) {
			p.addPoints(12, 50);
		}
	}

	@When("Moe chooses to score the yahtzee bonus category with his dice {string}, {string}")
	public void moe_chooses_to_score_the_yahtzee_bonus_category_with_his_dice(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
		if(c.yahtzee(dice) == 50) {
			p.addPoints(12, 50);
		}
		
		j = 0;
		for(int i = 0; i < string2.length(); i++) {
			if(string2.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string2.charAt(i)));
				j++;
			}
		}
		if(c.yahtzee(dice) == 50 && !p.firstYahtzee()) {
			p.addPoints(12, 50);
		} else if(c.yahtzee(dice) == 50  && p.firstYahtzee()) {
			p.addYahtzee();
		}
	}
	
	@Then("I verify the {int} that Moe can get from yahtzee bonus category of in step")
	public void i_verify_the_that_Moe_can_get_from_yahtzee_bonus_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		if(p.firstYahtzee()) {
			assertEquals(int1, Integer.valueOf(0));
		} else {
			assertEquals(int1, Integer.valueOf(100));
		}
	}
	
	@Given("Moe plays the game for a couple of rounds")
	public void moe_plays_the_game_for_a_couple_of_rounds() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Moe plays the game for a couple of rounds.");
	}

	@When("Moe has {int} and he wants to know whether he has an upper bonus or not")
	public void moe_has_and_he_wants_to_know_whether_he_has_an_upper_bonus_or_not(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    if(int1 >= 63) {
	    	bonus = true;
	    }
	}

	@Then("I verify his {int} in step")
	public void i_verify_his_in_step(Integer int1) {
	    if(int1 >= 63) {
	    	assertEquals(bonus, true);
	    } else {
	    	assertEquals(bonus, false);
	    }
	}

	@Given("Sam plays the game for a couple of rounds")
	public void sam_plays_the_game_for_a_couple_of_rounds() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Sam plays the game for a couple of rounds.");
	}

	@When("Sam has {int} and he wants to know whether he has an upper bonus or not")
	public void sam_has_and_he_wants_to_know_whether_he_has_an_upper_bonus_or_not(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		if(int1 >= 63) {
	    	bonus = true;
	    }
	}

	@Given("Joe plays the game for a couple of rounds")
	public void joe_plays_the_game_for_a_couple_of_rounds() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Joe plays the game for a couple of rounds.");
	}

	@When("Joe has {int} and he wants to know whether he has an upper bonus or not")
	public void joe_has_and_he_wants_to_know_whether_he_has_an_upper_bonus_or_not(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		if(int1 >= 63) {
	    	bonus = true;
	    }
	}
}
