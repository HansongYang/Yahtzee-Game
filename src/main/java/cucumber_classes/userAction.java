package cucumber_classes;
import static org.junit.Assert.assertEquals;

import comp4004A1.gameClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userAction {
	private boolean status = false;
	
	@Given("Moe enters the game and the game starts")
	public void moe_enters_the_game() {
		// The server is running
	    // we have checked Moe enters the game
	}

	@When("Moe enters a {int} for action")
	public void moe_enters_a_for_action(Integer int1) {
	   status = gameClient.userActionChecker(int1);
	}

	@Then("I verify the true in step")
	public void i_verify_the_success_in_step() {
	    assertEquals(true, status);
	}

	@Given("Joe enters the game and the game starts")
	public void joe_enters_the_game() {
		// The server is running
	    // we have checked Moe enters the game
	}

	@When("Joe enters a {int} for action")
	public void joe_enters_a_for_action(Integer int1) {
		status = gameClient.userActionChecker(int1);
	}

	@Given("Sam enters the game and the game starts")
	public void sam_enters_the_game() {
		// The server is running
	    // we have checked Moe enters the game
	}

	@When("Sam enters a {int} for action")
	public void sam_enters_a_for_action(Integer int1) {
		status = gameClient.userActionChecker(int1);
	}

	@Then("I verify the false in step")
	public void i_verify_the_Fail_in_step() {
		assertEquals(false, status);
	}
}
