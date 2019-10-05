package cucumber_classes;
import static org.junit.Assert.assertEquals;
import comp4004A1.gameClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class score {
	private boolean status;
	@Given("Sam wants to score this round")
	public void sam_wants_to_score_this_round() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Sam wants to score this round.");
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
