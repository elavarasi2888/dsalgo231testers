package stepDefinitions;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.TreePage;

public class TreeStepDefinitions {

    WebDriver driver;
    HomePage homePage;
    TreePage treePage;

    public TreeStepDefinitions() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        treePage = new TreePage(driver);
    }

    @Given("User clicks Get Started button from Tree panel")
    public void userClicksGetStartedButtonFromTreePanel() {
        treePage = (TreePage) homePage.clickGetStartedButtonOfGivenDsType("Tree");
    }

    @Given("User is on the Tree page")
    public void user_is_on_the_tree_page() {
        LoggerFactory.getLogger().info("Currently user is at {}",
                driver.getCurrentUrl());
    }

    @Then("User should see Tree header for Tree page")
    public void userShouldSeeTreeHeaderForTreePage() {
        Assert.assertTrue(treePage.isTreeHeaderVisible());
    }

    @Then("User should see Topics Covered header for Tree page")
    public void userShouldSeeTopicsCoveredHeaderForTreePage() {
        Assert.assertTrue(treePage.isTopicsCoveredHeaderTreeVisible());
    }

    @Then("User should see {string} link of Tree page")
    public void userShouldSeeLinkOfTreePage(String string) {
        Assert.assertTrue(treePage.isTreeLinkVisible(string));
    }

    @When("User clicks {string} link on the Tree page")
    public void user_clicks_link_on_the_tree_page(String string) {
        treePage.clickTreeTopicLink(string);
    }

    @Then("User should see {string} header of the respective Tree page")
    public void user_should_see_header_of_the_respective_tree_page(String expectedTreeLinkHeader) {
        String actualTreeLinkHeader = treePage.getTreeLinkHeader();
        Assert.assertEquals(actualTreeLinkHeader, expectedTreeLinkHeader);
    }

    @Then("User should see try here button on the Tree page")
    public void user_should_see_try_here_button_on_the_tree_page() {
        Assert.assertTrue(treePage.isTryHereButtonOnTreeLinkPageVisible());
    }

    @When("User clicks Try Here button in the respective Tree page")
    public void userClicksTryHereButtonInTheRespectiveTreePage() {
        treePage.clickTryHereInTreeLinkPage();
    }

    @Then("User should be directed to {string} of Tree data structure")
    public void user_should_be_directed_to_of_tree_data_structure(String treeTopicPage) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(treeTopicPage));
    }
}