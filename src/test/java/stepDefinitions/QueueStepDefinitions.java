package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.QueuePage;

public class QueueStepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private QueuePage queuePage;

    public QueueStepDefinitions() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("User clicks Get Started button from Queue panel")
    public void userClicksGetStartedButtonFromQueuePanel() {
        queuePage = (QueuePage) homePage.clickGetStartedButtonOfGivenDsType("Queue");
    }

    @Then("User should see Queue header for Queue page")
    public void userShouldSeeQueueHeaderForQueuePage() {
        Assert.assertTrue(queuePage.isQueueHeaderVisible());
    }

    @Then("User should see Topics Covered header for Queue page")
    public void userShouldSeeTopicsCoveredHeaderForQueuePage() {
        Assert.assertTrue(queuePage.isTopicsCoveredHeaderForQueueVisible());
    }

    @Then("User should see {string} link of Queue page")
    public void user_should_see_link_of_queue_page(String string) {
        Assert.assertTrue(queuePage.isQueueLinkVisible(string));
    }

    @Then("User should see Practice Questions on the Queue topic page")
    public void userShouldSeePracticeQuestionsOnTheQueueTopicPage() {
        Assert.assertTrue(queuePage.isPracticeQuestionsLinkOnQueueVisible());
    }

    @When("User clicks PracticeQuestions link in the respective Queue page")
    public void userClicksPracticeQuestionsLinkInTheRespectiveQueuePage() {
        queuePage.clickPracticeQuestionsOnQueue();
    }

    @Then("User should be redirected to Practice Questions page of Queue topics")
    public void userShouldBeRedirectedToPracticeQuestionsPageOfQueueTopics() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("queue/practice"));
    }

    @When("User clicks {string} link on the Queue page")
    public void user_clicks_link_on_the_queue_page(String string) {
        queuePage.clickQueueTopicLink(string);
    }

    @Then("User should see {string} header of the respective Queue page")
    public void user_should_see_header_of_the_respective_queue_page(String expectedQueueLinkHeader) {
        String actualQueueLinkHeader = queuePage.getQueueLinkTopicHeader();
        Assert.assertEquals(actualQueueLinkHeader, expectedQueueLinkHeader);
    }

    @Then("User should see try here button on the Queue page")
    public void user_should_see_try_here_button_on_the_queue_page() {
        Assert.assertTrue(queuePage.isTryHereButtonOnQueueLinkPageVisible());
    }

    @Then("User should be directed to {string} of Queue data structure")
    public void user_should_be_directed_to_of_queue_data_structure(String queueTopicPage) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(queueTopicPage));
    }

    @When("User clicks Try Here button in the respective Queue page")
    public void userClicksTryHereButtonInTheRespectiveQueuePage() {
        queuePage.clickTryHereInQueueLinkPage();
    }

    @Then("User should be redirected to try Editor page")
    public void user_should_be_redirected_to_try_editor_page() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("tryEditor"));
    }
}
