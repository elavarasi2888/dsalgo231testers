package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayPage;
import pageObjects.ArrayPracticePage;
import pageObjects.HomePage;

public class ArrayPracticeStepDefinitions {
    WebDriver driver;
    ArrayPage arrayPage;
    HomePage homePage;
    ArrayPracticePage arrayPracticePage;

    public ArrayPracticeStepDefinitions() {
        driver = DriverManager.getDriver();
        arrayPage = new ArrayPage(driver);
        homePage = new HomePage(driver);
        arrayPracticePage= new ArrayPracticePage(driver);
    }

    @Given("User clicks the Get Started button from the Array panel")
    public void user_clicks_the_get_started_button_from_the_array_panel() {
        arrayPage = (ArrayPage) homePage.clickGetStartedButtonOfGivenDsType("Array");
    }

    @Given("User clicks Array topics link on the Array page for the Practice Questions")
    public void user_clicks_array_topics_link_on_the_array_page_for_the_practice_questions() {
        arrayPracticePage.clickArrayTopicLink();
    }
    
    @When("User clicks the practice questions from the topics in the array page")
    public void user_clicks_the_practice_questions_from_the_topics_in_the_array_page() {
        arrayPracticePage.clickPracticeQuestionsTopicLink();
    }

    @Then("User should see {string} link on practice questions page")
    public void userShouldSeeLinkOnPracticeQuestionsPage(String topicName) {       
        Assert.assertTrue(
                arrayPracticePage.isPracticeQuestionLinkDisplayed(topicName),
                "Practice question link not visible: " + topicName
        );
    }
}
