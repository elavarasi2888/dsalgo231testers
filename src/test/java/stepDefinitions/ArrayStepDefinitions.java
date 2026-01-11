package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayPage;
import pageObjects.HomePage;
import pageObjects.TryEditorPage;
import utils.Constants;
import utils.DataReader;

import java.util.Map;

import static utils.Constants.TEST_DATA_FILE_NAME;

public class ArrayStepDefinitions {
    private final WebDriver driver;
    private ArrayPage arrayPage;
    private final HomePage homePage;
    private final TryEditorPage tryEditorPage;
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

    @Given("User clicks the Get Started button from the Array panel")
    public void user_clicks_the_get_started_button_from_the_array_panel() {
        arrayPage = (ArrayPage) homePage.clickGetStartedButtonOfGivenDsType("Array");
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

    @When("User clicks the Arrays in Python link on the Array page")
    public void userClicksTheArraysInPythonLinkOnTheArrayPage() {
        arrayPage.clickArraysInPythonLink();
    }

    @When("User clicks PracticeQuestions link in the respective Array page")
    public void userClicksPracticeQuestionsLinkInTheRespectiveArrayPage() {
        arrayPage.clickPracticeQuestionsFromArraysInPython();
    }

    @Then("User should be redirected to Practice Questions page of Array topics")
    public void userShouldBeRedirectedToPracticeQuestionsPageOfArrayTopics() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("array/practice"));
    }

    @Then("user clears the text in the editor area")
    public void userClearsTheTextInTheEditorArea() {
        arrayPage.clearEditorText();
    }

    @When("User enters the python code for the following {string}")
    public void userEntersThePythonCodeForTheFollowing(String scenarioName) {
        DataReader dataReader = new DataReader("/testData/" + TEST_DATA_FILE_NAME);
        Map<String, String> data = dataReader.getDataByScenarioName(Constants.TRY_EDITOR_PAGE_DATA_SHEET_NAME,
                scenarioName);

        expectedResult = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_RESULT);
        expectedMessage = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_MESSAGE);
        String inputCode = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_CODE);
        arrayPage.enterDataIntoEditor(inputCode);
    }

    @When("User clicks Run button")
    public void userClicksRunButton() {
        arrayPage.clickRunButton();
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

    @When("User navigates to the Array Practice page")
    public void userNavigatesToTheArrayPracticePage() {
        arrayPage.navigateToArrayPractice();
    }

    @When("User clicks {string} in practice page")
    public void userClicksInPracticePage(String questionName) {
        arrayPage.navigateToArrayPractice();
        arrayPage.clickPracticeQuestionByName(questionName);
    }

    @When("User enters python code for the following {string}")
    public void userEntersPythonCodeForTheFollowing(String scenarioName) {
        DataReader dataReader = new DataReader("/testData/" + TEST_DATA_FILE_NAME);
        Map<String, String> data = dataReader.getDataByScenarioName(Constants.TRY_EDITOR_PAGE_DATA_SHEET_NAME,
                scenarioName);

        expectedResult = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_RESULT);
        expectedMessage = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_MESSAGE);
        String inputCode = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_CODE);

        arrayPage.enterDataIntoEditor(inputCode);
    }

    @When("User clicks Search the array link in the practice page")
    public void userClicksSearchTheArrayLinkInThePracticePage() {
        arrayPage.clickSearchTheArray();
    }

    @When("User clicks Max Consecutive Ones link in the practice page")
    public void userClicksMaxConsecutiveOnesLinkInThePracticePage() {
        arrayPage.clickMaxConsecutiveOnes();
    }

    @When("User clicks Find Numbers with Even Number of Digits link in the practice page")
    public void userClicksFindNumbersWithEvenNumberOfDigitsLinkInThePracticePage() {
        arrayPage.clickFindNumberswithEvenNumberofDigits();
    }

    @When("User clicks Squares of a Sorted Array link in the practice page")
    public void userClicksSquaresOfASortedArrayLinkInThePracticePage() {
        arrayPage.clickSquaresofaSortedArray();
    }

    @Then("User clicks the Submit button and get output message")
    public void userClicksTheSubmitButtonAndGetOutputMessage() {
        if ("print".equalsIgnoreCase(expectedResult)) {
            arrayPage.clickSubmit();
            String output = arrayPage.getOutputText();
            Assert.assertNotNull(output, "Submit output message is null");

        } else {
            System.out.println("Submit skipped for non-valid code scenario");
        }
    }
}
