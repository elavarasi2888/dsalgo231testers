
package stepDefinitions;

import io.cucumber.java.PendingException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayPage;
import pageObjects.ArrayPracticePage;
import pageObjects.HomePage;
import pageObjects.TryEditorPage;
import utils.Constants;
import utils.DataReader;

import java.io.IOException;
import java.util.Map;

public class ArrayPracticeStepDefinitions {
    WebDriver driver;
    ArrayPage arrayPage;
    HomePage homePage;
    ArrayPracticePage arrayPracticePage;
    TryEditorPage tryEditorPage;
    private String expectedResult = null;
    private String expectedMessage = null;

    public ArrayPracticeStepDefinitions() {
        driver = DriverManager.getDriver();
        arrayPage = new ArrayPage(driver);
        homePage = new HomePage(driver);
        arrayPracticePage = new ArrayPracticePage(driver);
        tryEditorPage = new TryEditorPage(driver);
    }

    @Given("User clicks the Get Started button from the Array panel")
    public void user_clicks_the_get_started_button_from_the_array_panel() {
        arrayPage = (ArrayPage) homePage.clickGetStartedButtonOfGivenDsType("Array");
    }

    @Given("User clicks Array topics link on the Array page for the Practice Questions")
    public void userClicksArrayTopicsLinkOnTheArrayPageForThePracticeQuestions() {
        arrayPracticePage.clickArrayTopicLink1();
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

    @When("User clicks the Arrays in Python link on the Array page")
    public void userClicksTheArraysInPythonLinkOnTheArrayPage() {
        arrayPracticePage.clickArraysInPythonLink();
    }
    @When("User clicks PracticeQuestions link in the respective Array page")
    public void userClicksPracticeQuestionsLinkInTheRespectiveArrayPage() {
        arrayPracticePage.clickPracticeQuestionsFromArraysInPython();
    }

    @Then("User should be redirected to Practice Questions page of Array topics")
    public void userShouldBeRedirectedToPracticeQuestionsPageOfArrayTopics() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("array/practice"));
    }


    @Then("user clears the text in the editor area")
    public void userClearsTheTextInTheEditorArea() {
        arrayPracticePage.clearEditorText();
    }

    @When("User enters the python code for the following {string}")
    public void userEntersThePythonCodeForTheFollowing(String scenarioName) {

        DataReader dataReader = new DataReader(Constants.TEST_DATA_FILE);
        Map<String, String> data = dataReader.getDataByScenarioName(Constants.TRY_EDITOR_PAGE_DATA_SHEET_NAME, scenarioName);

        expectedResult = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_RESULT);
        expectedMessage = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_MESSAGE);
        String inputCode = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_CODE);

        // tryEditorPage.enterDataIntoEditor(inputCode);
        arrayPracticePage.enterDataIntoEditor(inputCode);
        /*
        String code = "";
        switch (scenarioName) {
            case "Valid Code":
                code = "print('Hello World')";
                break;
            case "Invalid Code":
                code = "print('Hello World'";
                break;
            case "No Code":
                code = "";
                break;
        }
        arrayPracticePage.enterCodeInEditor(code);
        */

    }
    @When("User clicks Run button")
    public void userClicksRunButton()
    {
        arrayPracticePage.clickRunButton();
    }
    @Then("User see the appropriate result")
    public void userSeeTheAppropriateResult()
    {
        if (expectedResult.equalsIgnoreCase("print")) {
            Assert.assertEquals(tryEditorPage.getPrintMessage(), expectedMessage);
        } else if (expectedResult.equalsIgnoreCase("alert")) {
            TryEditorPage.Result result = tryEditorPage.getAlertWindowVisibilityAndAlertText();
            Assert.assertTrue(result.isAlertWindowVisible());
            Assert.assertEquals(result.alertWindowMessage(), expectedMessage);
        } else if (expectedResult.isEmpty() || expectedResult.isBlank()) {
            Assert.assertEquals(tryEditorPage.getPrintMessage(), expectedMessage);
        }
    }


    @When("User clicks {string} in the practice page")
    public void user_clicks_in_the_practice_page(String problemName) {
        //arrayPracticePage.clickPracticeQuestionByName(problemName);
        arrayPracticePage.clickSearchTheArray();
    }

    @When("User navigates to the Array Practice page")
    public void userNavigatesToTheArrayPracticePage() {
        arrayPracticePage.navigateToArrayPractice();
    }

}

