package stepDefinitions;
import factory.DriverManager;
import io.cucumber.java.en.*;
import pageObjects.ArrayPage;
import pageObjects.ArrayTryEditorPage;
import static org.testng.Assert.assertTrue;

public class ArrayTryEditorSteps {
	


    ArrayPage arrayPage = new ArrayPage(DriverManager.getDriver());
    ArrayTryEditorPage tryEditorPage = new ArrayTryEditorPage(DriverManager.getDriver());

    // ---------------- Background ----------------

    @Given("User is on the array page")
    public void user_is_on_the_array_page() {
        assertTrue(arrayPage.isOnArrayPage(), "User is not on Array page");
    }

    @Given("User clicks on {string} on the respective Array pages")
    public void user_clicks_on_try_here_on_array_pages(String button) {
        arrayPage.clickTryHereButton();
    }

    // ---------------- Non Functional ----------------

    @Given("User is on the {string} page")
    public void user_is_on_the_array_topic_page(String pageName) {
    	if (pageName.equalsIgnoreCase("Array")) 
		{
	       assertTrue(arrayPage.isOnArrayPage(),
	                "User is NOT on Array page");
	    }
    }

    @When("User clicks Try Here button")
    public void user_clicks_try_here_button() {
        arrayPage.clickTryHereButton();
    }

    @Then("User should see Run button in the try editor page")
    public void user_should_see_run_button() {
        assertTrue(tryEditorPage.isRunButtonVisible(), "Run button not visible");
    }

    // ---------------- Functional ----------------

    @Then("User should be redirected to try Editor page")
    public void user_should_be_redirected_to_try_editor_page() {
        assertTrue(tryEditorPage.isEditorVisible(), "Try Editor page not loaded");
    }

    @When("User enters {string} python code in Try Editor and User clicks Run button in Try Editor")
    public void user_enters_code_and_clicks_run(String codeType) {

        switch (codeType.toLowerCase()) {
            case "valid":
                tryEditorPage.enterCode(tryEditorPage.getValidCode());
                break;
            case "invalid":
                tryEditorPage.enterCode(tryEditorPage.getInvalidCode());
                break;
            case "empty":
                tryEditorPage.clearEditor();
                break;
            default:
                throw new RuntimeException("Invalid Code Type");
        }

        tryEditorPage.clickRunButton();
    }

    @Then("User should see {string} in Try Editor")
    public void user_should_see_result(String expectedResult) {

        switch (expectedResult.toLowerCase()) {
            case "output displayed":
                assertTrue(tryEditorPage.isOutputDisplayed());
                break;
            case "error message":
                assertTrue(tryEditorPage.isErrorDisplayed());
                break;
            case "alert with error message":
                assertTrue(tryEditorPage.isAlertPresent());
                break;
            default:
                throw new RuntimeException("Invalid expected result");
        }
    }
}
