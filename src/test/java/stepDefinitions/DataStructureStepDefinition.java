package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DataStructurePage;
import pageObjects.HomePage;

public class DataStructureStepDefinition {

	private HomePage homePage;
	private DataStructurePage dataStructurePage;
    private WebDriver driver;

	public DataStructureStepDefinition() {

		driver = DriverManager.getDriver();
		homePage = new HomePage(driver);
	}

	@When("User clicks Get Started button of Data Structures-Introduction panel")
	public void user_clicks_get_started_button_of_data_structures_introduction_panel() {

		dataStructurePage = (DataStructurePage) homePage
				.clickGetStartedButtonOfGivenDsType("Data Structures-Introduction");
		LoggerFactory.getLogger().info("User clicks the Getting Started button in DS-introduction panel");
	}

	@Then("User should see Data Structures Introduction header for Data Structures-Introduction page")
	public void user_should_see_data_structure_introduction_header_for_data_structures_introduction_page() {

		Assert.assertTrue(dataStructurePage.HeaderTitleVisible());
		LoggerFactory.getLogger().info("User see the Data Structure-Introduction Header");
	}

	@Then("User should see Topics Covered having link for Data Structures-Introduction page")
	public void user_should_see_topics_covered_having_link_for_data_structures_introduction_page() {
		Assert.assertTrue(dataStructurePage.TopicCoveredTitleForLinksVisisble());
		LoggerFactory.getLogger().info("User see the Topic Covered Header for Links");
	}

	@Then("User should see {string} link of Data Structure page")
	public void user_should_see_link_of_data_structure_page(String string) {
		Assert.assertTrue(dataStructurePage.getTopics(string));
		LoggerFactory.getLogger().info("User Can see Time Complexity Link in Ds-introduction page");
	}

	@When("User  clicks the {string} in a Data Structure page")
	public void user_clicks_the_in_a_data_structure_page(String expectedTopicLink) {
		dataStructurePage.clickTopicLink(expectedTopicLink);
		LoggerFactory.getLogger().info("User clicks the Time Comeplexity Link to verify Header a Data Structure page");
	}

	@Then("User should see {string} header of the respective Data Structure page")
	public void user_should_see_header_of_the_respective_data_structure_page(String expectedTitle) {
		Assert.assertTrue(dataStructurePage.getHeaderForLinks().contains(expectedTitle));
		LoggerFactory.getLogger().info("User can see Time complexity Header");
	}

	@When("User clicks {string} link in the Data Structures-Introduction page")
	public void user_clicks_link_in_the_data_structures_introduction_page(String expectedTopicLink) {
		dataStructurePage.clickTopicLink(expectedTopicLink);
		LoggerFactory.getLogger().info("User clicks the Time Comeplexity Link to verify Try Here button");
	}

	@Then("User should see Try here button for the respective Data Structure page")
	public void user_should_see_try_here_button_for_the_respective_data_structure_page() {

		Assert.assertTrue(dataStructurePage.tryHereBtn());
		LoggerFactory.getLogger().info("User should see Try Here button on Time complexity page");
	}

	@When("User clicks {string} link on the Data Structures-Introduction page")
	public void user_clicks_link_on_the_data_structures_introduction_page(String expectedTopicLink) {
		dataStructurePage.clickTopicLink(expectedTopicLink);
	}

	@Then("User should see Practice Questions on the Data Structures topics page")
	public void user_should_see_practice_questions_on_the_data_structures_topics_page() {
		Assert.assertTrue(dataStructurePage.isPracticeQuestionsLinkOnDsTopicsVisible());
		LoggerFactory.getLogger().info("User should see Practice Questions link");
	}

	@When("User clicks {string} link on the Ds-Introduction page")
	public void user_clicks_link_on_the_ds_introduction_page(String expectedLink) {
		dataStructurePage.clickTopicLink(expectedLink);
		LoggerFactory.getLogger().info("User clicks the Time Comeplexity Link to verify the Url");
	}

	@Then("User should be redirected to {string} of DataStructure page")
	public void user_should_be_redirected_to_of_data_structure_page(String dSTopicPage) {

		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(dSTopicPage.toLowerCase()));
		LoggerFactory.getLogger().info("User verified the Url");
	}

	@When("User clicks Practice Questions link in the respective DataStructure page")
	public void user_clicks_practice_questions_link_in_the_respective_data_structure_page() {
		dataStructurePage.clickPracticeQuestionsLinkOnDs();
	}

	@Then("User should be redirected to Practice Questions page of Data Structure topics")
	public void user_should_be_redirected_to_practice_questions_page_of_data_structure_topics() {
		Assert.assertTrue(dataStructurePage.getPracticePageURL().contains("practice"));
	}

	@When("User clicks {string} link on the DataStructure page")
	public void user_clicks_link_on_the_data_structure_page(String expectedLink) {
		dataStructurePage.clickTopicLink(expectedLink);
		LoggerFactory.getLogger().info("User clicks the Time Comeplexity Link to verify the Url");
	}

	@When("User clicks Try Here button in the respective DataStructure page")
	public void user_clicks_try_here_button_in_the_respective_data_structure_page() {
		dataStructurePage.tryHereBtnForLinks();
		LoggerFactory.getLogger().info("User clicks the Try Here button For the respective page");
	}

	

}
