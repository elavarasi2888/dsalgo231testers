package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import factory.DriverManager;
import pageObjects.StackPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StackSteps {
	StackPage stackPage = new StackPage(DriverManager.getDriver());

	// ---------------- Background ----------------

	@Given("User clicks the Getting Started button in {string} Panel")
	public void user_clicks_getting_started_button(String panelName) {
		// homePage.clickGettingStarted(panelName);
	}

	@Given("User is on Stack page")
	public void user_is_on_stack_page(String panelName) {
		assertTrue(stackPage.isOnStackPage(), "User is not on Stack page");
	}
	// ---------------- Non Functional -------------------------------------

	@Then("user should see {string} header for Stack page")
	public void user_should_see_header_for_stack_page(String expectedHeader) {
		assertEquals(stackPage.getPageHeader(), expectedHeader);
	}

	@Then("user should see {string} link of Stack page")
	public void user_should_see_link_of_stack_page(String topicName) {
		switch (topicName) {
		case "Operations in Stack":
			assertTrue(stackPage.isOperationsInStackDisplayed(), topicName + " link is NOT visible on Stack page");
			break;
		case "Implementation":
			assertTrue(stackPage.isImplementationDisplayed(), topicName + " link is NOT visible on Stack page");
			break;
		case "Applications":
			assertTrue(stackPage.IsApplicationsDisplayed(), topicName + " link is NOT visible on Stack page");
			break;
		default:
			throw new RuntimeException("Topic not found: " + topicName);
		}
	}

	@Then("user should see {string} header of the respective Stack page")
	public void user_should_see_header_of_the_respective_stack_page(String header) {
		assertEquals(stackPage.getTopicsCoveredHeader(), header);
	}

	@Then("User should see {string} button on the Stack page")
	public void user_should_see_try_here_button_on_the_stack_page() {
		assertTrue(stackPage.isTryHereVisible(), "Try Here button not visible");
	}

	// ---------------- Functional ---------------------------------------

	@When("user clicks {string} link on the Stack page")
	public void user_clicks_link_on_the_stack_page(String topicName) {
		switch (topicName) {
		case "Operations in Stack":
			stackPage.clickOperations();
			break;
		case "Implementation":
			stackPage.clickImplementation();
			break;
		case "Applications":
			stackPage.clickApplications();
			break;
		default:
			throw new RuntimeException("Topic not found: " + topicName);
		}
	}

	@Then("user should be directed to {string} page of Stack page")
	public void user_should_be_directed_to_page_of_stack_page(String expectedPage) {
		assertTrue(stackPage.isUrlContains(expectedPage), "URL does not contain expected text");
	}
}
