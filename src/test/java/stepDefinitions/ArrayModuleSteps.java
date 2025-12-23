package stepDefinitions;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayModulePage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ArrayModuleSteps {

    ArrayModulePage arrayPage = new ArrayModulePage(DriverManager.getDriver());

    // ---------------------- Background Steps ----------------------

    @Given("User clicks the Getting Started button in {string} Panel")
    public void user_clicks_the_getting_started_button_in_panel(String panelName) {
        // Optional: implement if needed, e.g., HomePage.clickGettingStarted(panelName);
    }

    @Given("User is on {string} page")
    public void user_is_on_page(String pageName) {
        if (pageName.equalsIgnoreCase("Array")) {
            assertTrue(arrayPage.isOnArrayPage(), "User is NOT on Array page");
        }
    }

    @Given("User is on the Practice Questions page")
    public void user_is_on_practice_questions_page() {
        assertTrue(arrayPage.isOnPracticeQuestionsPage(), "User is NOT on Practice Questions page");
    }

    // ---------------------- Non-functional Steps ----------------------

    @Then("User should see {string} header for Array page")
    public void user_should_see_header_for_array_page(String expectedHeader) {
        assertTrue(arrayPage.isHeaderVisible(), "Array page header is NOT visible");
        assertEquals(arrayPage.getHeaderText(), expectedHeader);
    }

    @Then("User should see Topics Covered header")
    public void user_should_see_topics_covered_header() {
        assertTrue(arrayPage.isTopicsCoveredHeaderVisible(), "Topics Covered header is NOT visible");
    }

    @Then("User should see {string} link of Array page")
    public void user_should_see_link_of_array_page(String topicName) {
        switch (topicName) {
            case "Arrays in Python":
                assertTrue(arrayPage.isArraysInPythonDisplayed());
                break;
            case "Arrays Using List":
                assertTrue(arrayPage.isArraysUsingListDisplayed());
                break;
            case "Basic Operations in Lists":
                assertTrue(arrayPage.isBasicOperationsInListDisplayed());
                break;
            case "Applications of Array":
                assertTrue(arrayPage.isApplicationsOfArrayDisplayed());
                break;
            default:
                throw new RuntimeException("Topic not found: " + topicName);
        }
    }

    @Then("User should see {string} header of the respective Array page")
    public void user_should_see_header_of_respective_array_page(String expectedHeader) {
        assertTrue(arrayPage.isHeaderVisible(), "Module header is NOT visible");
        assertEquals(arrayPage.getHeaderText(), expectedHeader);
    }

    @Then("User should see {string} button on the Array page")
    public void user_should_see_button_on_the_array_page(String buttonText) {
        assertTrue(arrayPage.isRunButtonVisible(), "Run/Try Here button is NOT visible");
    }

    // ---------------------- Functional Steps: Array Topics ----------------------

    @When("User clicks {string} link on the Array page")
    public void user_clicks_link_on_the_array_page(String topicName) {
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
    public void user_clicks_try_here_button(String buttonText) {
        arrayPage.clickTryHereButton();
    }

    @Then("User should be directed to {string} page containing {string}")
    public void user_should_be_directed_to_page_containing(String topicName, String partialLinkText) {
        assertTrue(arrayPage.isCurrentURLContains(partialLinkText),
                "URL does not contain expected text: " + partialLinkText);
    }

    // ---------------------- Non-functional: Practice Questions ----------------------

    @Then("User should see {string} link of practice question page")
    public void user_should_see_link_of_practice_question_page(String topicName) {
        switch (topicName) {
            case "Search the array":
                assertTrue(arrayPage.isSearchTheArrayDisplayed());
                break;
            case "Max Consecutive Ones":
                assertTrue(arrayPage.isMaxConsecutiveOnesDisplayed());
                break;
            case "Find Numbers with Even Number of Digits":
                assertTrue(arrayPage.isFindNumbersWithEvenNumberOfDigitsDisplayed());
                break;
            case "Squares of a sorted Array":
                assertTrue(arrayPage.isSquaresOfSortedArrayDisplayed());
                break;
            default:
                throw new RuntimeException("Topic not found: " + topicName);
        }
    }

    @When("User clicks {string} link")
    public void user_clicks_practice_question_link(String topicName) {
        switch (topicName) {
            case "Search the array":
                arrayPage.clickSearchTheArray();
                break;
            case "Max Consecutive Ones":
                arrayPage.clickMaxConsecutiveOnes();
                break;
            case "Find Numbers with Even Number of Digits":
                arrayPage.clickFindNumbersWithEvenNumberOfDigits();
                break;
            case "Squares of a sorted Array":
                arrayPage.clickSquaresOfSortedArray();
                break;
            default:
                throw new RuntimeException("Topic not found: " + topicName);
        }
    }

    @Then("User should see QUESTION, Run button and Submit button")
    public void user_should_see_question_run_submit() {
        assertTrue(arrayPage.isQuestionTextVisible());
        assertTrue(arrayPage.isRunButtonVisible());
        assertTrue(arrayPage.isSubmitButtonVisible());
    }

    @Given("User is on the practice question editor of {string}")
    public void user_is_on_practice_question_editor(String questionName) {
        user_clicks_practice_question_link(questionName);
        assertTrue(arrayPage.isEditorVisible(), "Editor not visible for " + questionName);
    }

    @When("User write the {string} python code in Editor and Click the Run button")
    public void user_write_python_code_and_click_run(String codeType) {
        switch (codeType.toLowerCase()) {
            case "valid":
                arrayPage.enterCode(arrayPage.getValidCode());
                break;
            case "invalid":
                arrayPage.enterCode(arrayPage.getInvalidCode());
                break;
            case "empty code":
                arrayPage.clearEditor();
                break;
            default:
                throw new RuntimeException("CodeType not found: " + codeType);
        }
        arrayPage.clickRunButton();
    }

    @Then("User should able to see {string}")
    public void user_should_see_expected_result(String expectedResult) {
        switch (expectedResult.toLowerCase()) {
            case "output displayed":
                assertTrue(arrayPage.isOutputVisible());
                break;
            case "error message":
                assertTrue(arrayPage.isErrorMessageVisible());
                break;
            case "alert with error message":
                assertTrue(arrayPage.isAlertPresent());
                break;
            default:
                throw new RuntimeException("ExpectedResult not found: " + expectedResult);
        }
    }
}
