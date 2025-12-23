package stepDefinitions;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ArraySteps {
	
	ArrayPage arrayPage=new ArrayPage(DriverManager.getDriver());
	HomePage homePage = new HomePage(DriverManager.getDriver());
	
	 WebDriver driver;
	 
	 public ArraySteps(){
		 driver = DriverManager.getDriver();
		 arrayPage=new ArrayPage(driver);
		 
	 }
	
	//----------------------background-----------------------------------
	@Given("User clicks the Getting Started button in {string} Panel")
	public void user_clicks_the_getting_started_button_in_panel(String panelName)
	{
		//homePage.clickGettingStarted(panelName);
	}
	@Given("User is on {string} page")
	public void user_is_on_page(String pageName) 
	{
		if (pageName.equalsIgnoreCase("Array")) 
		{
	       assertTrue(arrayPage.isOnArrayPage(),"User is NOT on Array page");
	    }
	}
	 // ================= Non-functional =================

	@Then("User should see {string} header for Array page")
	public void user_should_see_header_for_array_page(String expectedHeader) 
	{
		assertTrue(arrayPage.isHeaderVisible(), "Array page header is NOT visible");
		assertEquals(arrayPage.getHeaderText(), expectedHeader);
	}

	@Then("User should see Topics Covered header")
	public void user_should_see_topics_covered_header(String expectedHeader) 
	{
		assertTrue(arrayPage.isTopicsCoveredHeaderVisible(),
                "Topics Covered header is NOT visible");
        assertEquals(arrayPage.getTopicsCoveredHeaderText(), expectedHeader);
	}

	@Then("User should see {string} link of Array page")
	public void user_should_see_link_of_array_page(String topicName) 
	{
		switch (topicName) {
        case "Arrays in Python":
            assertTrue(arrayPage.isArraysInPythonDisplayed(),
                    topicName + " link is NOT visible on Array page");
            break;
        case "Arrays Using List":
            assertTrue(arrayPage.isArraysUsingListDisplayed(),
                    topicName + " link is NOT visible on Array page");
            break;
        case "Basic Operations in Lists":
            assertTrue(arrayPage.isBasicOperationsInListDisplayed(),
                    topicName + " link is NOT visible on Array page");
            break;
        case "Applications of Array":
            assertTrue(arrayPage.isApplicationsOfArrayDisplayed(),
                    topicName + " link is NOT visible on Array page");
            break;
        default:
            throw new RuntimeException("Topic not found: " + topicName);
    }
	}
	
	@Then("User should see {string} header of the respective Array page")
	public void user_should_see_header_of_the_respective_array_page(String expectedHeader) 
	{
		 assertTrue(arrayPage.isHeaderVisible(),
	                "Module header is NOT visible");
	        assertEquals(arrayPage.getHeaderText(), expectedHeader);
	}

	@Then("User should see {string} button on the Array page")
	public void user_should_see_button_on_the_array_page(String buttonText) 
	{
		 assertTrue(arrayPage.isTryHereButtonVisible(),
	                "Try Here button is NOT visible");
	}
	
	 // ================= Functional ============================================

	@When("User clicks {string} link on the Array page")
	public void user_clicks_link_on_the_array_page(String topicName) 
	{
		 switch (topicName) {
	        case "Arrays in Python":
	            arrayPage.clickArraysInPython();
	            break;
	        case "Arrays Using List":
	            arrayPage.clickArraysUsingList();
	            break;
	        case "Basic Operations in Lists":
	            arrayPage.clickBasicOperationsInList();
	            break;
	        case "Applications of Array":
	            arrayPage.clickApplicationsOfArray();
	            break;
	        default:
	            throw new RuntimeException("Topic not found: " + topicName);
	    }
	}

	 @When("User clicks {string} button on the Array page")
	    public void user_clicks_try_here_button(String buttonText) 
	 {
		 arrayPage.clickTryHereButton();
	 }
	 
	@Then("User should be directed to {string} page containing {string}")
	public void user_should_be_directed_to_page_containing(String topicName, String partialLinkText) 
	{
		  assertTrue(arrayPage.isCurrentURLContains(partialLinkText),
	                "URL does not contain expected text: " + partialLinkText);
	}
	
}
