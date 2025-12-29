package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import pageObjects.SignInPage;
import utils.ExcelReader;

public class RegisterStepDefinition {

	WebDriver driver;
	RegisterPage registerPage;
	SignInPage signInPage;
	HomePage homePage;

	public RegisterStepDefinition() {
		driver = DriverManager.getDriver();
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
		signInPage = new SignInPage(driver);
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
	public void user_clicks_register_button_after_entering_the_valid_data_from_given(String ScenarioName)
			throws IOException {
		ExcelReader reader = new ExcelReader();
		String sheetName = "Register_valid";
		Map<String, String> testData = reader.getDataByScenarioName(sheetName, ScenarioName);
		registerPage.enterUserName(testData.get("Username"));
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

	/*
	 * @When("User clicks Register button after entering registered Data {string}")
	 * public void user_clicks_register_button_after_entering_registered_data(String
	 * ScenarioName) throws IOException { ExcelReader reader = new ExcelReader();
	 * String sheetName = "Prregisterd_data"; Map<String, String> testData =
	 * reader.getDataByScenarioName(sheetName, ScenarioName);
	 * registerPage.enterUserName(testData.get("Username"));
	 * registerPage.enterpassWord(testData.get("Password"));
	 * registerPage.enterPasswordConfirmation(testData.get("Password confirmation"))
	 * ; registerPage.registerBtn();
	 * LoggerFactory.getLogger().info("User Entering registered Data"); }
	 * 
	 * @Then("User gets a errormessage {string}") public void
	 * user_gets_a_errormessage(String string) { String expectedMsg
	 * ="password_mismatch:The two password fields didn’t match."; String actualMsg
	 * = registerPage.getRegisteredUserErrorMsg();
	 * 
	 * Assert.assertEquals("Error message mismatch!", expectedMsg,actualMsg);
	 * LoggerFactory.getLogger().info("User already Registered please SignIn");
	} */

	@When("User clicks Register button after entering the data from given {string}")
	public void user_clicks_register_button_after_entering_the_data_from_given(String ScenarioName) throws IOException {
		ExcelReader reader = new ExcelReader();
		String sheetName = "Register_invalid";
		Map<String, String> testData = reader.getDataByScenarioName(sheetName, ScenarioName);
		registerPage.enterUserName(testData.get("Username"));
		registerPage.enterpassWord(testData.get("Password"));
		registerPage.enterPasswordConfirmation(testData.get("Password confirmation"));
		registerPage.registerBtn();
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
