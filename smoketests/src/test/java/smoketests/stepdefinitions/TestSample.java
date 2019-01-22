package smoketests.stepdefinitions;

import cucumber.api.java.en.Given;

public class TestSample {	
	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside the framework");
	}


}
