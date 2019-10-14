package cucumber_classes;
import static org.junit.Assert.assertEquals;
import comp4004A1.categoryChecker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class lowerSection {
	private categoryChecker c = new categoryChecker();
	private int [] dice = new int[5];
	
	@Given("Moe rolles the dice and wants to score in a lower section category")
	public void moe_rolles_the_dice_and_wants_to_score_a_lower_section_category() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Moe rolles the dice and wants to score in a lower section category");
	}

	@When("Moe chooses to score the large Straight category with his dice {string}")
	public void moe_chooses_to_score_the_large_Straight_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from large Straight category of in step")
	public void i_verify_the_that_Moe_can_get_from_large_Straight_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.longStraight(dice)));
	}
	
	@When("Moe chooses to score the small Straight category with his dice {string}")
	public void moe_chooses_to_score_the_small_Straight_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from small Straight category of in step")
	public void i_verify_the_that_Moe_can_get_from_small_Straight_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.smallStraight(dice)));
	}
	
	@When("Moe chooses to score the Full House category with his dice {string}")
	public void moe_chooses_to_score_the_Full_House_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from Full House category of in step")
	public void i_verify_the_that_Moe_can_get_from_Full_House_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.fullHouse(dice)));
	}
	
	@When("Moe chooses to score the Three of a kind category with his dice {string}")
	public void moe_chooses_to_score_the_Three_of_kind_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from Three of a kind category of in step")
	public void i_verify_the_that_Moe_can_get_from_Three_of_kind_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.threeOfKind(dice)));
	}
	
	@When("Moe chooses to score the Four of a kind category with his dice {string}")
	public void moe_chooses_to_score_the_Four_of_kind_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from Four of a kind category of in step")
	public void i_verify_the_that_Moe_can_get_from_Four_of_kind_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.fourOfKind(dice)));
	}
	
	@When("Moe chooses to score the chance category with his dice {string}")
	public void moe_chooses_to_score_the_chance_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from chance category of in step")
	public void i_verify_the_that_Moe_can_get_from_chance_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.chance(dice)));
	}

	@When("Moe chooses to score the yahtzee category with his dice {string}")
	public void moe_chooses_to_score_the_yahtzee_category_with_his_dice(String string) {
	    // Write code here that turns the phrase above into concrete actions
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				dice[j] = Integer.parseInt(String.valueOf(string.charAt(i)));
				j++;
			}
		}
	}

	@Then("I verify the {int} that Moe can get from yahtzee category of in step")
	public void i_verify_the_that_Moe_can_get_from_yahtzee_category_of_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(int1, Integer.valueOf(c.yahtzee(dice)));
	}
}
