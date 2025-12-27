package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayPage;
import pageObjects.ArrayPracticePage;
import pageObjects.HomePage;

public class ArrayStepDefinitions {
	 WebDriver driver;
     ArrayPage arrayPage;
     ArrayPracticePage pqPage;
     HomePage homePage;

     public ArrayStepDefinitions() {
         driver = DriverManager.getDriver();
         arrayPage = new ArrayPage(driver);
         pqPage = new ArrayPracticePage(driver);
         homePage = new HomePage(driver);
     }

     // ======================= Background / Navigation =======================

     @Given("User clicks Get Started button from {string} panel")
     public void user_clicks_get_started_button_from_panel(String panelName) {
         arrayPage = (ArrayPage) homePage.clickGetStartedButtonOfGivenDsType(panelName);
     }

     @Given("User is on Array {string} page")
     public void user_is_on_Array_page(String pageName) {

         switch (pageName.toLowerCase()) {

             case "array":
                 arrayPage = new ArrayPage(driver);
                 assertTrue(arrayPage.isOnArrayPage(), "User is NOT on Array page");
                 break;

             case "practice questions":
                 pqPage = new ArrayPracticePage(driver);
                 assertTrue(pqPage.isOnPracticeQuestionsPage(),
                         "User is NOT on Practice Questions page");
                 break;

             default:
                 throw new RuntimeException("Unknown page: " + pageName);
         }
     }

     // ======================= Array Page – Non-Functional =======================

     @Then("User should see {string} header for Array page")
     public void user_should_see_header_for_array_page(String expectedHeader) {
         assertTrue(arrayPage.isHeaderVisible(), "Array page header is NOT visible");
         assertEquals(arrayPage.getHeaderText(), expectedHeader);
     }

     @Then("User should see Topics Covered header")
     public void user_should_see_topics_covered_header(String expectedHeader) {
         assertTrue(arrayPage.isTopicsCoveredHeaderVisible(),
                 "Topics Covered header is NOT visible");
         assertEquals(arrayPage.getTopicsCoveredHeaderText(), expectedHeader);
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

     @Then("User should see {string} button on the Array page")
     public void user_should_see_button_on_the_array_page(String buttonText) {
         assertTrue(arrayPage.isTryHereButtonVisible(),
                 "Try Here button is NOT visible");
     }

     // ======================= Array Page – Functional =======================

     @When("User clicks {string} link on the Array page")
     public void user_clicks_link_on_array_page(String topicName) {

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

     // ======================= Practice Questions – Non-Functional =======================

     @Then("User should see {string} link of practice question page")
     public void user_should_see_link_of_practice_question_page(String topicName) {

         switch (topicName) {
             case "Search the array":
                 assertTrue(pqPage.isSearchTheArrayDisplayed());
                 break;
             case "Max Consecutive Ones":
                 assertTrue(pqPage.isMaxConsecutiveOnesDisplayed());
                 break;
             case "Find Numbers with Even Number of Digits":
                 assertTrue(pqPage.isFindNumbersWithEvenNumberOfDigitsDisplayed());
                 break;
             case "Squares of a sorted Array":
                 assertTrue(pqPage.isSquaresOfSortedArrayDisplayed());
                 break;
             default:
                 throw new RuntimeException("Topic not found: " + topicName);
         }
     }

     // ======================= Practice Questions – Functional =======================

     @When("User clicks {string} link")
     public void user_clicks_practice_question_link(String topicName) {

         switch (topicName) {
             case "Search the array":
                 pqPage.clickSearchTheArray();
                 break;
             case "Max Consecutive Ones":
                 pqPage.clickMaxConsecutiveOnes();
                 break;
             case "Find Numbers with Even Number of Digits":
                 pqPage.clickFindNumbersWithEvenNumberOfDigits();
                 break;
             case "Squares of a sorted Array":
                 pqPage.clickSquaresOfSortedArray();
                 break;
             default:
                 throw new RuntimeException("Topic not found: " + topicName);
         }
     }

     @Then("User should see Question, run button and submit button")
     public void user_should_see_question_run_and_submit_buttons() {
         assertTrue(pqPage.isQuestionTextVisible());
         assertTrue(pqPage.isRunButtonVisible());
         assertTrue(pqPage.isSubmitButtonVisible());
     }

     @Given("User is on the practice question editor of {string}")
     public void user_is_on_practice_question_editor(String questionName) {
         user_clicks_practice_question_link(questionName);
         assertTrue(pqPage.isEditorVisible(),
                 "Editor not visible for " + questionName);
     }

     @When("User write the {string} python code in Editor and Click the Run button")
     public void user_write_code_and_click_run(String codeType) {

         switch (codeType.toLowerCase()) {
             case "valid":
                 pqPage.enterCode(pqPage.getValidCode());
                 break;
             case "invalid":
                 pqPage.enterCode(pqPage.getInvalidCode());
                 break;
             case "empty code":
                 pqPage.clearEditor();
                 break;
             default:
                 throw new RuntimeException("Invalid code type: " + codeType);
         }
         pqPage.clickRunButton();
     }

     @Then("User should able to see {string}")
     public void user_should_able_to_see(String expectedResult) {

         switch (expectedResult.toLowerCase()) {
             case "output displayed":
                 assertTrue(pqPage.isOutputVisible());
                 break;
             case "error message":
                 assertTrue(pqPage.isErrorMessageVisible());
                 break;
             case "alert with error message":
                 assertTrue(pqPage.isAlertPresent());
                 break;
             default:
                 throw new RuntimeException("Invalid expected result: " + expectedResult);
         }
     }
}
