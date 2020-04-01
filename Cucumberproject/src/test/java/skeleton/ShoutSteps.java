package skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShoutSteps {
	
	Person sean= new Person();
	
	@Given("Sean and Lucia are {int} meters away")
	public void sean_and_Lucia_are_meters_away(Integer distance) {
		sean.SetDistance(distance);
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@When("Aean shouts {string} to Lucia")
	public void aean_shouts_to_Lucia(String message) {
		// Write code here that turns the phrase above into concrete actions
		
	   sean.setMessage(message);
	}

	@Then("Lucia listens to the message")
	public void lucia_listens_to_hte_message() {
	    // Write code here that turns the phrase above into concrete actions
		
		String message=sean.getMessage();
	   Assert.assertEquals("free coffee",message);
	}
	
	
	   @Then("Lucia doesnot listens to the message")
	   public void lucia_doesnot_listens_to_the_message() {
	       // Write code here that turns the phrase above into concrete actions
		   
	   String message=sean.getMessage();
	   Assert.assertNull(message);
	  
		
	}
}
