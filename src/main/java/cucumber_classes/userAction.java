package cucumber_classes;
import static org.junit.Assert.assertEquals;
import comp4004A1.gameClient;
import comp4004A1.yahtzeeGame;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userAction {
	private boolean status = false;
	private yahtzeeGame g = new yahtzeeGame();
	
	@Given("Moe enters the game and the game starts")
	public void moe_enters_the_game() {
		// The server is running
	    // we have checked Moe enters the game
		System.out.println("Moe enters the game and the game starts.");
	}

	@When("Moe enters a {int} for action")
	public void moe_enters_a_for_action(Integer int1) {
	   status = gameClient.userActionChecker(int1);
	}

	@Then("I verify the true of user input for user action in step")
	public void i_verify_the_success_in_step() {
	    assertEquals(true, status);
	}

	@Given("Joe enters the game and the game starts")
	public void joe_enters_the_game() {
		// The server is running
	    // we have checked Moe enters the game
		System.out.println("Joe enters the game and the game starts.");
	}

	@When("Joe enters a {int} for action")
	public void joe_enters_a_for_action(Integer int1) {
		status = gameClient.userActionChecker(int1);
	}

	@Given("Sam enters the game and the game starts")
	public void sam_enters_the_game() {
		// The server is running
	    // we have checked Moe enters the game
		System.out.println("Sam enters the game and the game starts.");
	}

	@When("Sam enters a {int} for action")
	public void sam_enters_a_for_action(Integer int1) {
		status = gameClient.userActionChecker(int1);
	}

	@Then("I verify the false of user input for user action in step")
	public void i_verify_the_Fail_in_step() {
		assertEquals(false, status);
	}
	
	@Given("Moe wants to re-roll some dice")
	public void moe_wants_to_re_roll_some_dice() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Moe wants to re-roll some dice");
	}

	@When("Moe enters {string} for re-rolling")
	public void moe_enters_for_re_rolling(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    status = gameClient.userReRollChecker(string);
	}
	
	@Then("I verify the true of user input for re-rolling in step")
	public void i_verify_the_true_of_re_rolling_in_step() {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(status, true);
	}

	@Then("I verify the false of user input for re-rolling in step")
	public void i_verify_the_false_of_re_rolling_in_step() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(status, false);
	}
	
	@Given("Moe wants to roll all the dice")
	public void moe_wants_to_roll_all_the_dice() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Moe wants to roll all the dice.");
	}

	@When("Moe enters {string} for rolling all the dice")
	public void moe_enters_for_rolling_all_the_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    status = gameClient.userRollingChecker(string.charAt(0));
	}

	@Then("I verify the true of user input for rolling in step")
	public void i_verify_the_true_of_user_input_for_rolling_in_step() {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(status, true);
	}

	@Then("I verify the false of user input for rolling in step")
	public void i_verify_the_false_of_user_input_for_rolling_in_step() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(status, false);
	}

	@Given("Sam wants to score this round")
	public void sam_wants_to_score_this_round() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Sam wants to score this roud with no re-roll");
	}
	
	@Given("After {int} re-rolling, Sam wants to score this round")
	public void after_re_rolling_Sam_wants_to_score_this_round(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		for(int i = 0; i < int1; i++) {
	    	g.rollAllDice();
	    }
	}
	
	@Given("After {int} re-roll of less than {int} dice, Sam wants to score this round")
	public void after_re_roll_of_less_than_dice_Sam_wants_to_score_this_round(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		for(int i = 0; i < int1; i++) {
			g.rollSomeDice("1 2 3");
		}
	}
	
	@Given("After {int} re-roll of {int} dice, Sam wants to score this round")
	public void after_re_roll_of_dice_Sam_wants_to_score_this_round(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		for(int i = 0; i < int1; i++) {
	    	g.rollAllDice();
	    }
	}

	@When("Sam enters {int} for a category that he wants to score")
	public void sam_enters_for_a_category_that_he_wants_to_score(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    status = gameClient.userScoreChecker(int1);
	}

	@Then("I verify the true of user input for scoring in step")
	public void i_verify_the_true_of_user_input_for_scoring_in_step() {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(status, true);
	}

	@Then("I verify the false of user input for scoring in step")
	public void i_verify_the_false_of_user_input_for_scoring_in_step() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(status, false);
	}
}
