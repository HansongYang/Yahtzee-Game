package cucumber_classes;
import static org.junit.Assert.assertEquals;
import comp4004A1.gameClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class rollDice {
	private boolean status = false;
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
}
