package stepDefinitions;

import static org.testng.Assert.assertTrue;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayPage;
import pageObjects.ArrayPracticePage;

public class ArrayPracticeSteps 
{
	
	ArrayPage arrayPage = new ArrayPage(DriverManager.getDriver());
    ArrayPracticePage pqPage = new ArrayPracticePage(DriverManager.getDriver());

  //----------------------background-----------------------------------
    
  	@Given("User clicks the Getting Started button in {string} Panel")
  	public void user_clicks_the_getting_started_button_in_panel(String panelName)
  	{
  		//homePage.clickGettingStarted(panelName);
  	}
  	
  	@Given("User is on {string} page")
  	public void user_is_on_page(String pageName) 
  	{
  		if (pageName.equalsIgnoreCase("Array")) 
  		{
  	       assertTrue(arrayPage.isOnArrayPage(),"User is NOT on Array page");
  	    }
  	}
  	
	@Given("User is on the Practice Questions page")
	public void user_is_on_the_practice_questions_page()
	{
		assertTrue(pqPage.isOnPracticeQuestionsPage(), "User is NOT on Practice Questions page");	
	}
	//----------------------Non-functional Steps-----------------------------------
	
	@When("User clicks the practice questions links")
	public void user_clicks_the_practice_questions_links()
	{
	   
	}
	
	@Then("User should see {string} link of practice question page")
	public void user_should_see_link_of_practice_question_page(String topicName) 
	{
		switch (topicName) 
		{
        case "Search the array":
            assertTrue(pqPage.isSearchTheArrayDisplayed(), topicName + " link is not visible");
            break;
        case "Max Consecutive Ones":
            assertTrue(pqPage.isMaxConsecutiveOnesDisplayed(), topicName + " link is not visible");
            break;
        case "Find Numbers with Even Number of Digits":
            assertTrue(pqPage.isFindNumbersWithEvenNumberOfDigitsDisplayed(), topicName + " link is not visible");
            break;
        case "Squares of a sorted Array":
            assertTrue(pqPage.isSquaresOfSortedArrayDisplayed(), topicName + " link is not visible");
            break;
        default:
            throw new RuntimeException("Topic not found: " + topicName);
		}
	}
	@When("User clicks {string} link")
	public void user_clicks_link(String topicName) {
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
	public void user_should_see_question_run_button_and_submit_button()
	{
		assertTrue(pqPage.isQuestionTextVisible(), "QUESTION text not visible");
        assertTrue(pqPage.isRunButtonVisible(), "Run button not visible");
        assertTrue(pqPage.isSubmitButtonVisible(), "Submit button not visible");
	}
//----------------------Functional Steps-----------------------------------
	
	@Then("User should be redirected to {string} link of practice question page")
	public void user_should_be_redirected_to_link_of_practice_question_page(String topicName) {
		switch (topicName) {
        case "Search the array":
            assertTrue(pqPage.isCurrentURLContains("search-the-array"));
            break;
        case "Max Consecutive Ones":
            assertTrue(pqPage.isCurrentURLContains("max-consecutive-ones"));
            break;
        case "Find Numbers with Even Number of Digits":
            assertTrue(pqPage.isCurrentURLContains("find-numbers-even-digits"));
            break;
        case "Squares of a sorted Array":
            assertTrue(pqPage.isCurrentURLContains("squares-of-sorted-array"));
            break;
        default:
            throw new RuntimeException("Topic not found: " + topicName);
    }
	}

	@Given("User is on the practice question editor of {string}")
	public void user_is_on_the_practice_question_editor_of(String questionName)
	{
		user_clicks_link(questionName);
        assertTrue(pqPage.isEditorVisible(), "Editor is not visible for " + questionName);
	}

	@When("User write the  {string} python code in Editor and Click the Run button")
	public void user_write_the_python_code_in_editor_and_click_the_run_button(String codeType)
	{
		switch (codeType.toLowerCase()) 
		{
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
            throw new RuntimeException("CodeType not found: " + codeType);
		}
    pqPage.clickRunButton();
	}

	@Then("User should able to see {string}")
	public void user_should_able_to_see(String expectedResult) 
	{
		switch (expectedResult.toLowerCase()) 
		{
        case "output displayed":
            assertTrue(pqPage.isOutputVisible(), "Expected output not displayed");
            break;
        case "error message":
            assertTrue(pqPage.isErrorMessageVisible(), "Expected error message not displayed");
            break;
        case "alert with error message":
            assertTrue(pqPage.isAlertPresent(), "Expected alert not displayed");
            break;
        default:
            throw new RuntimeException("ExpectedResult not found: " + expectedResult);
		}
}
}
