package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DataStructurePage;
import pageObjects.GraphPage;
import pageObjects.HomePage;
import pageObjects.QueuePage;

public class GraphStepDefinition {
	HomePage homePage;
	GraphPage graphPage;
	WebDriver driver;

	public GraphStepDefinition() {
		driver = DriverManager.getDriver();
		homePage=new HomePage(driver);
		graphPage = new GraphPage(driver);
	}

	@Given("User clicks the Getting Started button in Graph Panel")
	public void user_clicks_the_getting_started_button_in_graph_panel() {
		graphPage = (GraphPage)homePage.clickGetStartedButtonOfGivenDsType("Graph");
		LoggerFactory.getLogger().info("User clicks the Getting Started button in Graph panel");
	}

	@Then("User should see Graph header for Graph page")
	public void user_should_see_graph_header_for_graph_page(String expectedHeader) {

		Assert.assertTrue(graphPage.HeaderTitleVisible());
		LoggerFactory.getLogger().info("User see the Graph Header");
	}

	@Then("User should see Topics Covered having link for Graph page")
	public void user_should_see_topics_covered_having_link_for_graph_page() {

		Assert.assertTrue(graphPage.TopicHeaderVisible());
		LoggerFactory.getLogger().info("User see the Topic Covered Header for Graph");
	}

	@Then("User should see {string} link of Graph page")
	public void user_should_see_link_of_graph_page(String expectedTopics) {

		Assert.assertTrue(graphPage.TopicsGraphVisible().contains(expectedTopics));
		LoggerFactory.getLogger().info("User Can see Topics Covered For Graph");
	}

	@When("User  clicks the {string} in Graph page")
	public void user_clicks_the_in_graph_page(String expectedLink) {
		graphPage.clickTopicLink(expectedLink);
		LoggerFactory.getLogger().info("User clicks the Links to verify Header for the respective page");
	}

	@Then("User should see {string} header of the respective Graph page")
	public void user_should_see_header_of_the_respective_graph_page(String expectedTitle) {

		Assert.assertTrue(graphPage.getHeaderForLinks().contains(expectedTitle));
		LoggerFactory.getLogger().info("User can see Header for the respective link");
	}

	@When("User clicks {string} link on the Graph page")
	public void user_clicks_link_on_the_graph_page(String expectedLink) {
		graphPage.clickTopicLink(expectedLink);
		LoggerFactory.getLogger().info("User clicks the Links to verify Try Here button");
	}

	@Then("User should see Try here button for the respective Graph page")
	public void user_should_see_try_here_button_for_the_respective_graph_page() {

		Assert.assertTrue(graphPage.tryHereBtn());
		LoggerFactory.getLogger().info("User should see Try Here button For the respective page");
	}

	@Then("User should be redirected to {string}  of graph page")
	public void user_should_be_redirected_to_of_graph_page(String graphTopicPage) {

		Assert.assertTrue(driver.getCurrentUrl().contains(graphTopicPage));
		LoggerFactory.getLogger().info("User verified the Url");
	}

	@When("User clicks Try Here button in the respective Graph page")
	public void user_clicks_try_here_button_in_the_respective_graph_page() {
		graphPage.tryHereBtnForLinks();
		LoggerFactory.getLogger().info("User clicks the Try Here button For the respective page");
	}

	/*
	 * @Then("User should be redirected to try Editor page for respective Graph page"
	 * ) public void
	 * user_should_be_redirected_to_try_editor_page_for_respective_graph_page() {
	 * String currentURL = driver.getCurrentUrl();
	 * Assert.assertTrue(currentURL.contains("tryEditor"));
	 * LoggerFactory.getLogger().info("User should be redirected to try Editor page"
	 * ); }
	 */

}
