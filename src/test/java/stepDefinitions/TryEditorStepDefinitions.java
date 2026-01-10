package stepDefinitions;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.TryEditorPage;
import utils.ConfigReader;
import utils.Constants;
import utils.DataReader;

import java.util.Map;

import static utils.Constants.TEST_DATA_FILE_NAME;

public class TryEditorStepDefinitions {

    private WebDriver driver;
    private String appURL = null;
    private TryEditorPage tryEditorPage;
    private String expectedResult = null;
    private String expectedMessage = null;

    public TryEditorStepDefinitions() {
        this.driver = DriverManager.getDriver();
    }

    @Given("User is on the tryEditor page")
    public void userIsOnTheTryEditorPage() {
        appURL = ConfigReader.getAppUrl();
        driver.get(appURL + "tryEditor");
        tryEditorPage = new TryEditorPage(driver);
    }

    @Then("User should see Run button in the try editor page")
    public void userShouldSeeRunButtonInTheTryEditorPage() {
        Assert.assertTrue(tryEditorPage.isRunButtonVisible());
    }

    @When("User write the code for following {string} in the try editor page")
    public void userWriteTheCodeForFollowingInTheTryEditorPage(String scenarioName) {
        DataReader dataReader = new DataReader("/testData/" + TEST_DATA_FILE_NAME);
        Map<String, String> data = dataReader.getDataByScenarioName(Constants.TRY_EDITOR_PAGE_DATA_SHEET_NAME, scenarioName);

        expectedResult = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_RESULT);
        expectedMessage = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_MESSAGE);
        String inputCode = data.get(Constants.TRY_EDITOR_PAGE_DATA_COL_CODE);

        tryEditorPage.enterDataIntoEditor(inputCode);
    }

    @When("User clicks the Run button")
    public void userClicksTheRunButton() {
        tryEditorPage.Run();
    }

    @Then("User see appropriate result")
    public void userSeeAppropriateResult() {
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
