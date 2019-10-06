package cucumber_classes;
import static org.junit.Assert.assertEquals;
import comp4004A1.categoryChecker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class upperSection {
	private categoryChecker c = new categoryChecker();
	private int [] dice = new int[5];
	
	@Given("Moe rolles the dice and wants to score in a upper section category")
	public void moe_rolles_the_dice_and_wants_to_score_the_ace_category() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Moe rolles the dice and wants to score in a upper section category");
	}

	@When("Moe chooses to score the ones category with his dice {string}")
	public void moe_chooses_to_score_the_ace_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from ones category of in step")
	public void i_verify_the_points_that_Moe_s_can_get_from_ace_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(int1, Integer.valueOf(c.aces(dice)));
	}

	@When("Moe chooses to score the twos category with his dice {string}")
	public void moe_chooses_to_score_the_twos_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}
	
	@Then("I verify the {int} that Moe can get from twos category of in step")
	public void i_verify_the_that_Moe_can_get_from_twos_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.twos(dice)));
	}
	
	@When("Moe chooses to score the threes category with his dice {string}")
	public void moe_chooses_to_score_the_threes_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from threes category of in step")
	public void i_verify_the_that_Moe_can_get_from_threes_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.threes(dice)));
	}
	
	@When("Moe chooses to score the fours category with his dice {string}")
	public void moe_chooses_to_score_the_fours_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from fours category of in step")
	public void i_verify_the_that_Moe_can_get_from_fours_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.fours(dice)));
	}
	
	@When("Moe chooses to score the fives category with his dice {string}")
	public void moe_chooses_to_score_the_fives_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from fives category of in step")
	public void i_verify_the_that_Moe_can_get_from_fives_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.fives(dice)));
	}

	@When("Moe chooses to score the sixes category with his dice {string}")
	public void moe_chooses_to_score_the_sixes_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from sixes category of in step")
	public void i_verify_the_that_Moe_can_get_from_sixes_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.sixes(dice)));
	}
}