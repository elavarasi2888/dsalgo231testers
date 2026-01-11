package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LinkedListPage;

public class LinkedListStepDefinition {
	private LinkedListPage linkedListPage;
	private WebDriver driver;
	private HomePage homePage;

	public LinkedListStepDefinition() {
		driver = DriverManager.getDriver();
		homePage = new HomePage(driver);
	}

	@Given("User clicks the Getting Started button in Linked List Panel")
	public void user_clicks_the_getting_started_button_in_linked_list_panel() {
		linkedListPage = (LinkedListPage) homePage.clickGetStartedButtonOfGivenDsType("Linked List");
		LoggerFactory.getLogger().info("User clicks the Getting Started button in LinkedList panel");
	}

	@Then("User should see Linked List header for Linkedlist page")
	public void user_should_see_linked_list_header_for_linkedlist_page() {
		Assert.assertTrue(linkedListPage.HeaderTitleVisisble());
		LoggerFactory.getLogger().info("User see the Linked List Header");
	}

	@Then("User should see Topics Covered having link for Linked List page")
	public void user_should_see_topics_covered_having_link_for_linked_list_page() {
		Assert.assertTrue(linkedListPage.isTopicCoveredVisible());
		LoggerFactory.getLogger().info("User can see the Topic Covered Header for Links");
	}

	@Then("User should see {string} link of Linked List page")
	public void user_should_see_link_of_linked_list_page(String string) {
		Assert.assertTrue(linkedListPage.TopicsLinkelistVisible(string));
		LoggerFactory.getLogger().info("User Can see Topics Covered For LinkedList");
	}

	@When("User  clicks the {string} in a linklist page")
	public void user_clicks_the_in_a_linklist_page(String expectedTopicCoveredLink) {
		linkedListPage.clickTopicLink(expectedTopicCoveredLink);
		LoggerFactory.getLogger().info("User clicks the Links to verify Header for the respective page");
	}

	@Then("User should see {string} header of the respective linklist page")
	public void user_should_see_header_of_the_respective_linklist_page(String expectedHeaderForLink) {
		Assert.assertTrue(linkedListPage.getHeaderForLinks().contains(expectedHeaderForLink));
		LoggerFactory.getLogger().info("User can see Header for the respective link");
	}

	@When("User clicks {string} link on the linklist page")
	public void user_clicks_link_on_the_linklist_page(String expectedTryHereBtn) {
		linkedListPage.clickTopicLink(expectedTryHereBtn);
		LoggerFactory.getLogger().info("User clicks the Links to verify Try Here button");
	}

	@Then("User should see Practice Questions on the linklist topics page")
	public void user_should_see_practice_questions_on_the_linklist_topics_page() {
		Assert.assertTrue(linkedListPage.isPracticeQuestionsLinkOnLinkedlistTopicsVisible());
		LoggerFactory.getLogger().info("User should see Practice Questions link");
	}

	@When("User clicks Practice Questions link in the respective linklist page")
	public void user_clicks_practice_questions_link_in_the_respective_linklist_page() {
		linkedListPage.clickPracticeQuestionsLinkOnLinklist();
	}

	@Then("User should be redirected to Practice Questions page of linklist topics")
	public void user_should_be_redirected_to_practice_questions_page_of_linklist_topics() {
		Assert.assertTrue(linkedListPage.getPracticePageURL().contains("practice"));
	}

	@Then("User should see Try here button for the respective linklist page")
	public void user_should_see_try_here_button_for_the_respective_linklist_page() {
		Assert.assertTrue(linkedListPage.tryHereBtn());
		LoggerFactory.getLogger().info("User should see Try Here button For the respective page");
	}

	@Then("User should be redirected to {string} of linklist page")
	public void user_should_be_redirected_to_of_linklist_page(String linklistTopicPage) {
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(linklistTopicPage.toLowerCase()));
		LoggerFactory.getLogger().info("User verified the Url");
	}

	@When("User clicks Try Here button in the respective linklist page")
	public void user_clicks_try_here_button_in_the_respective_linklist_page() {
		linkedListPage.tryHereBtnForLinks();
		LoggerFactory.getLogger().info("User clicks the Try Here button For the respective page");
	}


}
