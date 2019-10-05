package cucumber_classes;
import static org.junit.Assert.assertEquals;
import comp4004A1.gameClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class reRolling {
	private boolean status = false;
	
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
}
