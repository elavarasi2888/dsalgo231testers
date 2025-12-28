package stepDefinitions;

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

	@Given("User clicks Get Started button from Stack panel")
	public void user_clicks_get_started_button_from_stack_panel() {
		stackPage = (StackPage) homePage.clickGetStartedButtonOfGivenDsType("Stack");
	}

	@Then("User should see Stack header for Stack page")
	public void user_should_see_stack_header_for_stack_page() {
		Assert.assertTrue(stackPage.isStackHeaderVisible());
	}

	@Then("User should see Topics Covered header for Stack page")
	public void user_should_see_topics_covered_header_for_stack_page() {
		Assert.assertTrue(stackPage.isTopicsCoveredHeaderForStackVisible());
	}

	@Then("User should see {string} link of Stack page")
	public void user_should_see_link_of_stack_sage(String string) {
		Assert.assertTrue(stackPage.isStackLinkVisible(string));
	}

	@When("User clicks {string} link on the Stack page")
	public void user_clicks_link_on_the_stack_page(String string) {
		stackPage.clickStackTopicLink(string);
	}

	@Then("User should see {string} header of the respective Stack page")
	public void user_should_see_header_of_the_respective_stack_page(String expectedStackLinkHeader) {
		String actualStackLinkHeader = stackPage.getStackLinksTopicHeader();
		Assert.assertEquals(actualStackLinkHeader, expectedStackLinkHeader);
	}

	@Then("User should see try here button on the Stack page")
	public void user_should_see_try_here_button_on_the_stack_page() {
		Assert.assertTrue(stackPage.isTryHereVisible());
	}

	@Then("User should be directed to {string} page of Stack page")
	public void user_should_be_directed_to_page_of_stack_page(String stackTopicPage) {
       String currentURL = driver.getCurrentUrl();
       Assert.assertTrue(currentURL.contains(stackTopicPage));
	}

	@When("User clicks Try Here button in the respective Stack page")
	public void userClicksTryHereButtonInTheRespectiveStackPage() {
		stackPage.clickTryHereInStackLinkPage();
	}
/*
	@Then("User should be redirected to try Editor page")
	public void user_should_be_redirected_to_try_editor_page() {
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("tryEditor"));
	}
*/


}
