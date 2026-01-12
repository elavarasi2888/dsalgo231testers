package stepDefinitions;

import java.util.Map;

import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DsAlgoPortalPage;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import utils.ConfigReader;
import utils.DataReader;

import static utils.Constants.TEST_DATA_FILE_NAME;

public class RegisterStepDefinition {

    private WebDriver driver;
    private RegisterPage registerPage;
    private DsAlgoPortalPage dsAlgoPortal;
    private HomePage homePage;

    public RegisterStepDefinition() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getAppUrl());
        dsAlgoPortal = new DsAlgoPortalPage(driver);
    }

    @Given("User clicks the Register link button on the home page")
    public void userClicksTheRegisterLinkButtonOnTheHomePage() {
        homePage = dsAlgoPortal.clickDsPortalGetStarted();
        registerPage = homePage.clickRegisterLink();
    }


    @When("User clicks Login Link in register page")
    public void userClicksLoginLinkInRegisterPage() {
        registerPage.loginLink();
        LoggerFactory.getLogger().info("User clicks Login link");
    }

    @Then("User should be redirected to Login Page")
    public void user_should_be_redirected_to_login_page() {
        Assert.assertTrue(registerPage.getloginPageUrl());
        LoggerFactory.getLogger().info("User at the signIn page");
    }


    @When("User clicks Register button after entering the Valid data from given {string}")
    public void user_clicks_register_button_after_entering_the_valid_data_from_given(String ScenarioName) {
        DataReader reader = new DataReader("/testData/" + TEST_DATA_FILE_NAME);
        String sheetName = "Register_valid";
        Map<String, String> testData = reader.getDataByScenarioName(sheetName, ScenarioName);
        String username = testData.get("Username") + System.currentTimeMillis();
        registerPage.enterUserName(username);
        registerPage.enterpassWord(testData.get("Password"));
        registerPage.enterPasswordConfirmation(testData.get("Password confirmation"));
        registerPage.registerBtn();
        LoggerFactory.getLogger().info("User entering the Valid data");
    }

    @Then("User should be redirected to Home Page of DS Algo with message contains {string}")
    public void user_should_be_redirected_to_home_page_of_ds_algo_with_message_contains(String expectedRegisteredMsg) {

        Assert.assertTrue(registerPage.getRegisterMsg().contains(expectedRegisteredMsg));
        LoggerFactory.getLogger().info("User at the Home page");
    }


    @When("User clicks Register button after entering the data from given {string}")
    public void user_clicks_register_button_after_entering_the_data_from_given(String ScenarioName) throws InterruptedException {
        DataReader reader = new DataReader("/testData/" + TEST_DATA_FILE_NAME);
        String sheetName = "Register_invalid";
        Map<String, String> testData = reader.getDataByScenarioName(sheetName, ScenarioName);
        registerPage.enterUserName(testData.get("Username"));
        registerPage.enterpassWord(testData.get("Password"));
        registerPage.enterPasswordConfirmation(testData.get("Password confirmation"));
        registerPage.registerBtn();
        LoggerFactory.getLogger().info("User entering the invalid data");
    }

    @Then("The error message {string} appears below the {string}")
    public void the_error_message_appears_below_the(String expectedErrorMessage, String fieldName) {
        String actualErrorMsg;
        WebElement field = registerPage.getFieldLocation(fieldName);
        if (fieldName.equalsIgnoreCase("login")) {
            actualErrorMsg = field.getText();
        } else {
            actualErrorMsg = (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].validationMessage;", field);
        }
        Assert.assertEquals(actualErrorMsg.trim(), expectedErrorMessage.trim());
        LoggerFactory.getLogger().info("The error message appears below the fieldName");
    }
}
