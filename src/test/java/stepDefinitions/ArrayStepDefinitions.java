package stepDefinitions;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.ArrayPage;
import pageObjects.HomePage;
import pageObjects.TryEditorPage;
import utils.Constants;
import utils.DataReader;

import static utils.Constants.TEST_DATA_FILE_NAME;

import java.util.Map;

public class ArrayStepDefinitions {
    private WebDriver driver;
    private ArrayPage arrayPage;
    private HomePage homePage;
    private TryEditorPage tryEditorPage;
    private String expectedResult = null;
    private String expectedMessage = null;

    public ArrayStepDefinitions() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        tryEditorPage = new TryEditorPage(driver);
    }

    @When("User clicks Get Started button from Array panel")
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

    @Given("User clicks Array topics link on the Array page for the Practice Questions")
    public void userClicksArrayTopicsLinkOnTheArrayPageForThePracticeQuestions() {
        arrayPage.clickArrayTopicLink1();
    }

    @When("User clicks the practice questions from the topics in the array page")
    public void user_clicks_the_practice_questions_from_the_topics_in_the_array_page() {
        arrayPage.clickPracticeQuestionsTopicLink();
    }

    @Then("User should see {string} link on practice questions page")
    public void userShouldSeeLinkOnPracticeQuestionsPage(String topicName) {
        Assert.assertTrue(arrayPage.isPracticeQuestionLinkDisplayed(topicName),
                "Practice question link not visible: " + topicName);
    }

    @When("User clicks Practice Questions link in the Arrays in Python page")
    public void userClicksPracticeQuestionsLinkInTheArraysInPythonPage() {
        arrayPage.clickArraysInPythonLink();
    }

    @Then("User should be redirected to Practice Questions page of Array topics")
    public void userShouldBeRedirectedToPracticeQuestionsPageOfArrayTopics() {
        arrayPage.clickPracticeQuestionsFromArraysInPython();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("array/practice"));
    }

    @Given("User navigates to the Array Practice page")
    public void userNavigatesToTheArrayPracticePage() {
        arrayPage.navigateToArrayPractice();
    }

    @When("User clicks Search the array link in the practice page")
    public void userClicksSearchTheArrayLinkInThePracticePage() {
        arrayPage.clickSearchTheArray();
        arrayPage.clearEditorText();
    }

    @When("User runs the following python code {string}")
    public void userRunsTheFollowingPythonCode(String scenarioName) {
        DataReader dataReader = new DataReader("/testData/" + TEST_DATA_FILE_NAME);
        Map<String, String> data = dataReader.getDataByScenarioName(Constants.TRY_EDITOR_PAGE_DATA_SHEET_NAME,
                scenarioName);

        expectedResult = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_RESULT);
        expectedMessage = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_MESSAGE);
        String inputCode = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_CODE);
        arrayPage.enterDataIntoEditor(inputCode);
        arrayPage.clickRunButton();
    }

    @When("User clicks Max Consecutive Ones link in the practice page")
    public void userClicksMaxConsecutiveOnesLinkInThePracticePage() {
        arrayPage.clickMaxConsecutiveOnes();
        arrayPage.clearEditorText();
    }

    @When("User clicks Find Numbers with Even Number of Digits link in the practice page")
    public void userClicksFindNumbersWithEvenNumberOfDigitsLinkInThePracticePage() {
        arrayPage.clickFindNumberswithEvenNumberofDigits();
        arrayPage.clearEditorText();
    }

    @When("User clicks Squares of a Sorted Array link in the practice page")
    public void userClicksSquaresOfASortedArrayLinkInThePracticePage() {
        arrayPage.clickSquaresofaSortedArray();
        arrayPage.clearEditorText();
    }

    @Then("User see the appropriate result")
    public void userSeeTheAppropriateResult() {
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
}
