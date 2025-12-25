package stepDefinitions;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DataStructure;
import pageObjects.HomePage;

public class DataStructureStepDef {

   HomePage homePage;
   DataStructure dataStructurePage;

	WebDriver driver;

	public DataStructureStepDef() {

		driver = DriverManager.getDriver();
		dataStructurePage = new DataStructure(driver);
	}
	@Given("User is at the Home page after sign-in")
	public void user_is_at_the_home_page_after_sign_in() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@Given("User clicks the Getting Started button in {string} Panel")
	public void user_clicks_the_getting_started_button_in_panel(String expectedPanel) {
		dataStructurePage.clickGetStarted(expectedPanel.toLowerCase());
		LoggerFactory.getLogger().info("User clicks the Getting Started button in DS-introduction panel");
	}

	@Given("User is on the Data Structures-Introduction page")
	public void user_is_on_the_data_structures_introduction_page() {
		String expectedDsUrl = "/data-structures-introduction/"; // keep this in constant class inside Utils package
		Assert.assertTrue(dataStructurePage.getDataStructurePageURL().endsWith(expectedDsUrl));
		LoggerFactory.getLogger().info("User is on the Data Structures-Introduction page");
		
	}

	@Then("User should see {string} header for Data Structures-Introduction page")
	public void user_should_see_header_for_data_structures_introduction_page(String expectedDsHeader) {
		
		Assert.assertEquals(dataStructurePage.getHeaderTitle(), expectedDsHeader);
		LoggerFactory.getLogger().info("User see the Data Structure-Introduction Header");
	}

	@Then("User should see {string} having link for Data Structures-Introduction page")
	public void user_should_see_having_link_for_data_structures_introduction_page(String expectedTopicHeader) {
		
		Assert.assertEquals(dataStructurePage.getTitleForLinks(), expectedTopicHeader);
		LoggerFactory.getLogger().info("User see the Topic Covered Header for Links");

	}

	@Then("User should see {string} link of Data Structure page")
	public void user_should_see_link_of_data_structure_page(String expectedTopics) {
		
		Assert.assertTrue(dataStructurePage.getTopics().contains(expectedTopics));
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

	@When("User clicks {string} link on the Data Structures-Introduction page")
	public void user_clicks_link_on_the_data_structures_introduction_page(String expectedTopicLink) {
		dataStructurePage.clickTopicLink(expectedTopicLink);
		LoggerFactory.getLogger().info("User clicks the Time Comeplexity Link to verify Try Here button");

	}

	@Then("User should see {string} button for the respective Data Structure page")
	public void user_should_see_button_for_the_respective_data_structure_page(String buttonTryHereText) {
		String actualTryHerebtnTxt = dataStructurePage.tryHereBtn();
		Assert.assertEquals(actualTryHerebtnTxt, buttonTryHereText);
		LoggerFactory.getLogger().info("User should see Try Here button on Time complexity page");
	}

	@When("User clicks {string} link on the Ds-Introduction page")
	public void user_clicks_link_on_the_ds_introduction_page(String expectedLink) {
		dataStructurePage.clickTopicLink(expectedLink);
		LoggerFactory.getLogger().info("User clicks the Time Comeplexity Link to verify the Url");
	}

	@Then("User should be directed to {string} page containing {string}")
	public void user_should_be_directed_to_page_containing(String expectedLink, String partialLinkText) {
		String actualLinkurl = driver.getCurrentUrl();
		Assert.assertTrue(actualLinkurl.toLowerCase().contains(partialLinkText.toLowerCase()));
		LoggerFactory.getLogger().info("User verified the Url" + expectedLink);

	}
	
	

	@Given("User clicks Get Started button of {string} from panel after sign-in")
	public void user_clicks_get_started_button_of_from_panel_after_sign_in(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	

	@Then("User should be redirected to {string} page containing {string}")
	public void user_should_be_redirected_to_page_containing(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
