package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinitions {

	@Given("User is at the Home page")
	public void user_is_at_the_home_page() {

	}

	@Then("NumpyNinja heading should be visible")
	public void numpy_ninja_heading_should_be_visible() {
	}

	@Then("Register link should be visible")
	public void register_link_should_be_visible() {

	}

	@Then("Sign in link should be visible")
	public void sign_in_link_should_be_visible() {

	}

	@Then("Datastructures drop down should be visible")
	public void datastructures_drop_down_should_be_visible() {

	}

	@Then("User should be able to see {int} Get Started buttons for the following panel items:")
	public void user_should_be_able_to_see_get_started_buttons_for_the_following_panel_items(Integer int1,
			io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}

	@When("User clicks the Data Structures dropdown")
	public void user_clicks_the_data_structures_dropdown() {

	}

	@Then("User should able to see the following {int} options:")
	public void user_should_able_to_see_the_following_options(Integer int1, io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}

	@When("User selects following {string} from the drop down")
	public void user_selects_following_from_the_drop_down(String string) {

	}

	@Then("User should able to see a warning message {string}")
	public void user_should_able_to_see_a_warning_message(String string) {

	}

	@When("User clicks Get Started button of {string} from panel")
	public void user_clicks_get_started_button_of_from_panel(String string) {

	}

	@Then("User should able to see a warning message as {string}")
	public void user_should_able_to_see_a_warning_message_as(String string) {

	}

	@When("User clicks on the Register link in the home page")
	public void user_clicks_on_the_register_link_in_the_home_page() {

	}

	@Then("User should navigate to the Register page")
	public void user_should_navigate_to_the_register_page() {

	}

	@When("User clicks on the Sign in link in the home page")
	public void user_clicks_on_the_sign_in_link_in_the_home_page() {

	}

	@Then("User should navigate to the Sign in page")
	public void user_should_navigate_to_the_sign_in_page() {

	}

}
