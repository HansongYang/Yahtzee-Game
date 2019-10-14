package cucumber_classes;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import comp4004A1.categoryChecker;
import comp4004A1.gameServer;
import comp4004A1.player;
import comp4004A1.yahtzeeGame;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class playerFeature {
	private categoryChecker c = new categoryChecker();
	private yahtzeeGame game = new yahtzeeGame();
	private gameServer g = new gameServer();
	private int [] dice = new int[5];
	private String nextPlayer = "";
	private boolean bonus = false;
	private boolean status = false;
	
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
			status = true;
		}
	}
	
	@Then("I verify the {int} and {int} that Moe can get from yahtzee bonus category of in step")
	public void i_verify_the_and_that_Moe_can_get_from_yahtzee_bonus_category_of_in_step(Integer int1, Integer int2) {
	   if(int2 == 0) {
		   assertEquals(int1, Integer.valueOf(0));
	   } else {
		   if(status) {
			   assertEquals(int1, Integer.valueOf(100));
		   } else {
			   assertEquals(int1, Integer.valueOf(0));
		   }
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

	@Given("The server is running")
	public void the_server_is_running() {
	    //We checked the server is on
	    System.out.println("The server is running.");
	    g.ar.clear();
	}
	
	@When("Sam joins the game")
	public void sam_joins_the_game() throws IOException {
		g.joinGames("Sam");
		game.setPlayerName("Sam");
	}

	@When("Joe joins the game")
	public void joe_joins_the_game() throws IOException{
		g.joinGames("Joe");
		game.setPlayerName("Joe");
	}
	
	@When("Moe joins the game")
	public void moe_joins_the_game() throws IOException{
		g.joinGames("Moe");
		game.setPlayerName("Moe");
	}

	@Then("I verify that how many players are in this game in step")
	public void i_verify_that_how_many_players_are_in_this_game_in_step() {
		assertEquals(1, g.ar.size());
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
	
	@Given("Moe finishes his turn")
	public void moe_finishes_his_turn() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Moe finishes his turn.");
	}

	@When("The next player is ready to play by folling the {string}")
	public void the_next_player_is_ready_to_play_by_folling_the(String string) throws IOException {
		g = new gameServer();
		g.ar.clear();
		String [] arr = string.split(" ");
	    for(int i = 0; i < arr.length; i++) {
	    	g.joinGames(arr[i]);
	    }
	    nextPlayer = g.nextPlayer("Moe");
	}

	@Then("I verify the correctness of next player {string}  in step")
	public void i_verify_the_correctness_of_in_step(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(string, nextPlayer);
	}

	@Given("Three players finish their turn")
	public void three_players_finish_their_turn() {
		game.setPlayerName("Sam");
		game.setPlayerName("Joe");
		game.setPlayerName("Moe");
	    System.out.println("Three players finish their turn.");
	}

	@When("This round finishes and the round {int} starts")
	public void this_round_finishes_and_the_next_round_starts(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		game.setCurrentRound(int1-1);
	    game.nextRound("Sam");
	    game.nextRound("Joe");
	    game.nextRound("Moe");
	}
	
	@When("Thirteen rounds finishes")
	public void thirteen_rounds_finishes() {
	    // Write code here that turns the phrase above into concrete actions
	    for(int i = 0; i < 13; i++) {
	    	game.nextRound("Sam");
		    game.nextRound("Joe");
		    game.nextRound("Moe");
	    }
	}

	@Then("I verify the correctness of round {int} in step")
	public void i_verify_the_correctness_of_round_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(int1, Integer.valueOf(game.getPlayerRound("Sam")));
	    assertEquals(int1, Integer.valueOf(game.getPlayerRound("Moe")));
	    assertEquals(int1, Integer.valueOf(game.getPlayerRound("Joe")));
	}
}
