package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DataStructure;
import pageObjects.GraphPage;
import pageObjects.HomePage;

public class GraphStepDef {
	  HomePage homePage;
	   GraphPage graphPage;
     WebDriver driver;
	public GraphStepDef() {
		driver = DriverManager.getDriver();
		graphPage = new GraphPage(driver);
	}
	@Given("User is at the Home page after sign-in")
	public void user_is_at_the_home_page_after_sign_in() {
	
	}
	@Given("User clicks the Getting Started button in {string} Panel")
	public void user_clicks_the_getting_started_button_in_panel(String expectedPanel) {
		graphPage.clickGetStarted(expectedPanel.toLowerCase());
		LoggerFactory.getLogger().info("User clicks the Getting Started button in Graph panel");
	}
	@Given("User is on {string} page")
	public void user_is_on_page(String expectedPanel) {
		
		String actualUrl = graphPage.getGraphPageURL();
		Assert.assertTrue(actualUrl.contains(expectedPanel.toLowerCase()));
		LoggerFactory.getLogger().info("User is on the Graph page");
	}

	
	@Then("User should see {string} header for Graph page")
	public void user_should_see_header_for_graph_page(String expectedHeader) {
		String actualHeader = graphPage.getHeaderTitle();
		Assert.assertEquals(actualHeader, expectedHeader);
		LoggerFactory.getLogger().info("User see the Graph Header");
	}
	@Then("User should see {string} having link for Graph page")
	public void user_should_see_having_link_for_graph_page(String expectedTopicHeader) {
		String actualTopicHeader = graphPage.getHeaderForLinks();
		Assert.assertEquals(actualTopicHeader, expectedTopicHeader);
		LoggerFactory.getLogger().info("User see the Topic Covered Header for Graph");
	}

	@Then("User should see {string} link of Graph page")
	public void user_should_see_link_of_graph_page(String expectedTopics) {
		List<String> actualTopic = graphPage.getTopics();
		Assert.assertTrue(actualTopic.contains(expectedTopics));
		LoggerFactory.getLogger().info("User Can see Topics Covered For Graph");
	}
	

	@When("User  clicks the {string} in Graph page")
	public void user_clicks_the_in_graph_page(String expectedLink) {
		graphPage.clickTopicLink(expectedLink);
		LoggerFactory.getLogger().info("User clicks the Links to verify Header for the respective page");
	}

	@Then("User should see {string} header of the respective Graph page")
	public void user_should_see_header_of_the_respective_graph_page(String expectedTitle) {
		String actualHeader = graphPage.getHeaderForLinks();
		Assert.assertTrue(actualHeader.contains(expectedTitle));
		LoggerFactory.getLogger().info("User can see Header for the respective link"); 
	}

	
	@When("User clicks {string} link on the Graph page")
	public void user_clicks_link_on_the_graph_page(String expectedLink) {
		graphPage.clickTopicLink(expectedLink);
		LoggerFactory.getLogger().info("User clicks the Links to verify Try Here button");
	}
	
	@Then("User should see {string} button for the respective Graph page")
	public void user_should_see_button_for_the_respective_graph_page(String buttonText) {
		String actualbtnTxt = graphPage.tryHereBtn();
		Assert.assertEquals(actualbtnTxt, buttonText);
		LoggerFactory.getLogger().info("User should see Try Here button For the respective page");
	}
	@Then("User should be redirected to {string} page containing {string}")
	public void user_should_be_redirected_to_page_containing(String expectedLink, String partialLinkText) {
		String actualurl = driver.getCurrentUrl();
		Assert.assertTrue(actualurl.toLowerCase().contains(partialLinkText.toLowerCase()));
		LoggerFactory.getLogger().info("User verified the Url"+ expectedLink);
	}
	


}
