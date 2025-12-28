package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import factory.DriverManager;
import pageObjects.HomePage;
import pageObjects.StackPage;

import org.openqa.selenium.WebDriver;

public class StackStepDefinitions {
	StackPage stackPage;
	HomePage homePage;
	WebDriver driver;

	public StackStepDefinitions() {
		driver = DriverManager.getDriver();
		homePage = new HomePage(driver);
		stackPage = new StackPage(driver);
	}
	// ---------------- Background ----------------
	
	@Given("User clicks Get Started button from Stack panel")
	public void user_clicks_get_started_button_from_stack_panel() {
		stackPage = (StackPage) homePage.clickGetStartedButtonOfGivenDsType("Stack");		
	}

	// ---------------- Non Functional -------------------------------------

	@Then("User should see Stack header for Stack page")
	public void user_should_see_stack_header_for_stack_page() {		
		Assert.assertTrue(stackPage.isStackHeaderVisible());
	}
	 @Then("User should see Topics Covered header for Stack page")
	    public void user_should_see_topics_covered_header_for_stack_page() {
		 Assert.assertTrue(stackPage.isTopicsCoveredHeaderForStackVisible());
	    }
/*
	@Then("user should see {string} link of Stack page")
	public void user_should_see_link_of_stack_page(String topicName) {
		switch (topicName) {
		case "Operations in Stack":
			Assert.assertTrue(stackPage.isOperationsInStackDisplayed(),
					topicName + " link is NOT visible on Stack page");
			break;
		case "Implementation":
			Assert.assertTrue(stackPage.isImplementationDisplayed(), topicName + " link is NOT visible on Stack page");
			break;
		case "Applications":
			Assert.assertTrue(stackPage.IsApplicationsDisplayed(), topicName + " link is NOT visible on Stack page");
			break;
		default:
			throw new RuntimeException("Topic not found: " + topicName);
		}
	}

 */
	
	  @Then("User should see try here button on the Stack page")
	    public void user_should_see_try_here_button_on_the_stack_page() {
	        Assert.assertTrue(stackPage.isTryHereVisible());
	    }

	

	// ---------------- Functional ---------------------------------------

	@When("User clicks {string} link on the Stack page")
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
	
	
	@Then("User should be directed to {string} page of Stack page")
	public void user_should_be_directed_to_page_of_stack_page(String expectedPage) {
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("tryEditor"));
	}

    @When("User clicks Try Here button in the respective Stack page")
    public void userClicksTryHereButtonInTheRespectiveStackPage() {
        stackPage.clickTryHereInStackLinkPage();
    }
    @Then("User should be redirected to try Editor page")
    public void user_should_be_redirected_to_try_editor_page() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("tryEditor"));
    }

    @Then("User should see {string} link of Stack page")
    public void userShouldSeeLinkOfStackPage(String topicName) {
        switch (topicName) {
            case "Operations in Stack":
                Assert.assertTrue(stackPage.isOperationsInStackDisplayed(),
                        topicName + " link is NOT visible on Stack page");
                break;
            case "Implementation":
                Assert.assertTrue(stackPage.isImplementationDisplayed(), topicName + " link is NOT visible on Stack page");
                break;
            case "Applications":
                Assert.assertTrue(stackPage.IsApplicationsDisplayed(), topicName + " link is NOT visible on Stack page");
                break;
            default:
                throw new RuntimeException("Topic not found: " + topicName);
        }
    }

   
    @Then("User should see {string} header of the respective Stack page")
    public void userShouldSeeHeaderOfTheRespectiveStackPage(String expectedStackLinkHeader) {
    	String actualHeader = stackPage.getTopicHeader();
        Assert.assertEquals(actualHeader, expectedStackLinkHeader, "Header text mismatch");
    }
}
