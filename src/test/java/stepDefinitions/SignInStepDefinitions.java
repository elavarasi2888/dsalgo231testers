package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static utils.Constants.TEST_DATA_FILE_NAME;

import java.util.Map;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import factory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DsAlgoPortalPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import utils.ConfigReader;
import utils.DataReader;

public class SignInStepDefinitions {
    private HomePage homePage;
    private SignInPage signinpage;
    private DsAlgoPortalPage dsAlgoPortal;
    private WebDriver driver;

    public SignInStepDefinitions() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getAppUrl());
        dsAlgoPortal = new DsAlgoPortalPage(driver);
    }

    @Given("User clicks the Sign in link on the home page")
    public void userClicksTheSignInLinkOnTheHomePage() {
        homePage = dsAlgoPortal.clickDsPortalGetStarted();
        signinpage = homePage.clickSignInLink();
    }

    @When("User clicks login button after entering valid credentials")
    public void userClicksLoginButtonAfterEnteringValidCredentials() {
        String ScenarioName = "valid username and valid password";
        DataReader reader = new DataReader("/testData/" + TEST_DATA_FILE_NAME);
        String sheetName = "login_valid";
        Map<String, String> testData = reader.getDataByScenarioName(sheetName, ScenarioName);
        signinpage.enterUsername(testData.get("Username"));
        signinpage.enterPassword(testData.get("Password"));
        signinpage.clickSignIn();
    }

    @When("User clicks login button after entering data from the given {string}")
    public void userClicksLoginButtonAfterEnteringDataFromTheGiven(String ScenarioName) {
        DataReader reader = new DataReader("/testData/" + TEST_DATA_FILE_NAME);
        String sheetName = "login_invalid";
        Map<String, String> testData = reader.getDataByScenarioName(sheetName, ScenarioName);
        signinpage.enterUsername(testData.get("Username"));
        signinpage.enterPassword(testData.get("Password"));
        signinpage.clickSignIn();
    }

    @Then("User should land in Home Page with message {string}")
    public void user_should_land_in_home_page_with_message(String expectedMessage) {
        String actualMessage = homePage.getUserLoggedInMessage();
        assertEquals(actualMessage, expectedMessage);
    }

    @Then("User get the error message {string}")
    public void user_get_the_error_message(String expectedErrMsg) {
        String actualErrMsg;
        if (expectedErrMsg.equals("Please fill out this field.")) {
            actualErrMsg = signinpage.getBrowserValidationMessage();
        } else {
            actualErrMsg = signinpage.getApplicationErrorMessage();
        }
        Assert.assertEquals(actualErrMsg, expectedErrMsg);
    }

    @When("User clicks register button in the login page")
    public void user_clicks_register_button_in_the_login_page() {
        signinpage.clickRegister();
    }

    @Then("User should be redirected to Registration page")
    public void user_should_be_redirected_to_registration_page() {
        Assert.assertTrue(signinpage.isRegistrationPageDisplayed());
    }
}
