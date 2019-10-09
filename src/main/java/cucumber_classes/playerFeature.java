package cucumber_classes;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import comp4004A1.categoryChecker;
import comp4004A1.gameServer;
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

	@When("Moe has {int} in upper section and he wants to know whether he has an upper bonus or not")
	public void moe_has_and_he_wants_to_know_whether_he_has_an_upper_bonus_or_not(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    if(int1 >= 63) {
	    	bonus = true;
	    }
	}

	@Given("Sam plays the game for a couple of rounds")
	public void sam_plays_the_game_for_a_couple_of_rounds() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Sam plays the game for a couple of rounds.");
	}

	@When("Sam has {int} in upper section and he wants to know whether he has an upper bonus or not")
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

	@When("Joe has {int} in upper section and he wants to know whether he has an upper bonus or not")
	public void joe_has_and_he_wants_to_know_whether_he_has_an_upper_bonus_or_not(Integer int1) {
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

	gameServer g = new gameServer();
	@Given("The server is running")
	public void the_server_is_running() {
	    //We checked the server is on
	    System.out.println("The server is running.");
	}
	
	@When("Sam joins the game")
	public void sam_joins_the_game() throws IOException {
		g.joinGames();
	}

	@When("Joe joins the game")
	public void joe_joins_the_game() throws IOException{
		g.joinGames();
	}
	
	@When("Moe joins the game")
	public void moe_joins_the_game() throws IOException{
		g.joinGames();
	}

	@Then("I verify whether the game starts or not in step")
	public void i_verify_whether_the_game_starts_or_not_in_step() {
		if(g.ar.size() < 3) {
			assertEquals(false, g.gameStarts());
		}else {
			assertEquals(true, g.gameStarts());
		}
	}

	@Given("Joe plays the last round")
	public void joe_plays_the_last_round_then_the_game_ends() {
		System.out.println("Joe plays the last round");
	}

	@When("The winner is announced by checking {string}")
	public void the_winner_is_announced_by_checking(String string) {
		String [] arr = string.split(" ");
	    if(Integer.parseInt(arr[0]) > Integer.parseInt(arr[1]) && Integer.parseInt(arr[0]) > Integer.parseInt(arr[2])) {
	    	System.out.println("Player 1 wins the game.");
	    } else if(Integer.parseInt(arr[1]) > Integer.parseInt(arr[0]) && Integer.parseInt(arr[1]) > Integer.parseInt(arr[2])) {
	    	System.out.println("Player 2 wins the game.");
	    } else if(Integer.parseInt(arr[2]) > Integer.parseInt(arr[0]) && Integer.parseInt(arr[2]) > Integer.parseInt(arr[1])) {
	    	System.out.println("Player 3 wins the game.");
	    }
	}

	@Then("I verify whether the game ends or not in step")
	public void i_verify_whether_the_game_ends_or_not() {
	    assertEquals(false, g.active());
	}
}
