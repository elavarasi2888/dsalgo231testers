package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LinkedList;

public class LinkedListStepDef {
	private LinkedList linkedListPage;
	WebDriver driver;

	public LinkedListStepDef() {
		driver = DriverManager.getDriver();
		linkedListPage = new LinkedList(driver);
	}

	@Given("User is at the Home page after sign-in")
	public void user_is_at_the_home_page_after_sign_in() {

	}

	@Given("User clicks the Getting Started button in {string} Panel")
	public void user_clicks_the_getting_started_button_in_panel(String expectedPanel) {
		linkedListPage.clickGetStarted(expectedPanel.toLowerCase());
		LoggerFactory.getLogger().info("User clicks the Getting Started button in LinkedList panel");
	}

	@Given("User is on {string} page")
	public void user_is_on_page(String expectedPanel) {

		String actualUrl = linkedListPage.getLinkedListPageURL();
		Assert.assertTrue(actualUrl.contains(expectedPanel.toLowerCase()));
		LoggerFactory.getLogger().info("User is on the Linked List page");
	}

	@Then("User should see {string} header for Linkedlist page")
	public void user_should_see_header_for_linkedlist_page(String expectedHeader) {
		driver.get("https://dsportalapp.herokuapp.com/linked-list/");
		String actualHeader = linkedListPage.getHeaderTitle();
		Assert.assertEquals(actualHeader, expectedHeader);
		LoggerFactory.getLogger().info("User see the Linked List Header");
	}

	@Then("User should see {string} having link for Linked List page")
	public void user_should_see_having_link_for_linked_list_page(String expectedTopicHeader) {
		String actualTopicHeader = linkedListPage.getTitleForLinks();
		Assert.assertEquals(actualTopicHeader, expectedTopicHeader);
		LoggerFactory.getLogger().info("User see the Topic Covered Header for Links");
	}

	@Then("User should see {string} link of Linked List page")
	public void user_should_see_link_of_linked_list_page(String expectedTopics) {
		List<String> actualTopic = linkedListPage.getTopics();
		Assert.assertTrue(actualTopic.contains(expectedTopics));
		LoggerFactory.getLogger().info("User Can see Topics Covered For LinkedList");
	}

	@When("User  clicks the {string} in a linklist page")
	public void user_clicks_the_in_a_linklist_page(String expectedLink) {
		linkedListPage.clickTopicLink(expectedLink);
		LoggerFactory.getLogger().info("User clicks the Links to verify Header for the respective page");
	}

	@Then("User should see {string} header of the respective linklist page")
	public void user_should_see_header_of_the_respective_linklist_page(String expectedTitle) {
		String actualHeader = linkedListPage.getHeaderForLinks();
		Assert.assertTrue(actualHeader.contains(expectedTitle));
		LoggerFactory.getLogger().info("User can see Header for the respective link");
	}

	@When("User clicks {string} link on the linklist page")
	public void user_clicks_link_on_the_linklist_page(String expectedLink) {
		linkedListPage.clickTopicLink(expectedLink);
		LoggerFactory.getLogger().info("User clicks the Links to verify Try Here button");
	}

	@Then("User should see {string} button for the respective linklist page")
	public void user_should_see_button_for_the_respective_linklist_page(String buttonText) {
		String actualbtnTxt = linkedListPage.tryHereBtn();
		Assert.assertEquals(actualbtnTxt, buttonText);
		LoggerFactory.getLogger().info("User should see Try Here button For the respective page");
	}

	@Then("User should be redirected to {string} page containing {string}")
	public void user_should_be_redirected_to_page_containing(String expectedLink, String partialLinkText) {
		String actualurl = driver.getCurrentUrl();
		Assert.assertTrue(actualurl.toLowerCase().contains(partialLinkText.toLowerCase()));
		LoggerFactory.getLogger().info("User verified the Url" + expectedLink);
	}

}
