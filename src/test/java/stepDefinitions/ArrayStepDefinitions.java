package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayPage;
import pageObjects.HomePage;

public class ArrayStepDefinitions {
    WebDriver driver;
    ArrayPage arrayPage;
    HomePage homePage;

    public ArrayStepDefinitions() {
        driver = DriverManager.getDriver();
        arrayPage = new ArrayPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("User clicks Get Started button from Array panel")
    public void user_clicks_get_started_button_from_array_panel() {
        arrayPage = (ArrayPage) homePage.clickGetStartedButtonOfGivenDsType("Array");
    }

    @Then("User should see Array header for Array page")
    public void user_should_see_array_header_for_array_page() {
        Assert.assertTrue(arrayPage.isArrayHeaderVisible());
    }

    @Then("User should see Topics Covered header for Array page")
    public void user_should_see_topics_covered_header_for_array_page() {
        Assert.assertTrue(arrayPage.isTopicsCoveredHeaderForArrayVisible());
    }

    @Then("User should see {string} link of Array page")
    public void user_should_see_link_of_array_page(String string) {
        Assert.assertTrue(arrayPage.isArrayLinkVisible(string));
    }

    @When("User clicks {string} link on the Array page")
    public void user_clicks_link_on_the_array_page(String string) {
        arrayPage.clickArrayTopicLink(string);
    }

    @Then("User should see {string} header of the respective Array page")
    public void user_should_see_header_of_the_respective_array_page(String expectedArrayLinkHeader) {
        String actualArrayLinkHeader = arrayPage.getArrayLinksTopicHeader();
        Assert.assertEquals(actualArrayLinkHeader, expectedArrayLinkHeader);
    }

    @Then("User should see try here button on the Array page")
    public void user_should_see_try_here_button_on_the_array_page() {
        Assert.assertTrue(arrayPage.isTryHereButtonVisible());
    }

    @Then("User should be directed to {string} page of Array page")
    public void user_should_be_directed_to_page_of_array_page(String arrayTopicPage) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(arrayTopicPage));
    }

    @When("User clicks Try Here button in the respective Array page")
    public void userClicksTryHereButtonInTheRespectiveArrayPage() {
        arrayPage.clickTryHereInArrayLinkPage();
    }
}
