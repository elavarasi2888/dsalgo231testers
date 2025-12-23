package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.Register;
import pageObjects.SignInPage;
import utils.ExcelReader;

public class RegisterStepDef {

	WebDriver driver;
	Register registerPage;
	SignInPage signInPage;
	HomePage homePage;
	

	public RegisterStepDef() {
		driver = DriverManager.getDriver();
		registerPage = new Register(driver);
	}
	
    @Given("User is at the Register page")
	public void user_is_at_the_register_page() {
		
		String actualRegisterPageUrl = registerPage.getRegisterPageURL();
		String expectedUrlPart = "/register"; //keep this in constant class inside Utils package
		Assert.assertTrue(actualRegisterPageUrl.endsWith(expectedUrlPart));
		LoggerFactory.getLogger().info("User At the Register page");

	}

	@When("User clicks Login Link in register page")
	public void user_clicks_login_link_in_register_page() {
		signInPage = registerPage.loginLink();
		LoggerFactory.getLogger().info("User clicks Login Link in register page");

	}

	@Then("User should be redirected to Login Page")
	public void user_should_be_redirected_to_login_page() {
		String actualUrl = driver.getCurrentUrl(); //url of sign in page should come from sign in page reference "signInPage"
		//await Ela's code
		String expectedUrlPart = "/login";
		Assert.assertTrue(actualUrl.contains(expectedUrlPart));
		LoggerFactory.getLogger().info("User at the Login Page");

	}
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

	
	
	@When("User clicks Register button after entering the Valid data from given {string}")
	public void user_clicks_register_button_after_entering_the_valid_data_from_given(String ScenarioName) throws IOException {
		ExcelReader reader = new ExcelReader();
		String sheetName = "Register_valid";
		Map<String, String> testData = reader.getDataByScenarioName(sheetName, ScenarioName);
		registerPage.enterUserName(testData.get("Username"));
		registerPage.enterpassWord(testData.get("Password"));
		registerPage.enterPasswordConfirmation(testData.get("Password confirmation"));
		registerPage.registerBtn();
	}
	
	@Then("User should be redirected to Home Page of DS Algo with message {string}")
	public void user_should_be_redirected_to_home_page_of_ds_algo_with_message(String expectedRegisteredMsg) {
	
	String actualUserRegisterdMsg= registerPage.getRegisterMsg();
	Assert.assertTrue(actualUserRegisterdMsg.contains(expectedRegisteredMsg));
	LoggerFactory.getLogger().info("User at the Home page");

	}

	@Then("The error message {string} appears below the {string}")
	public void the_error_message_appears_below_the(String expectedErrorMessage, String fieldName) {
		WebElement field = registerPage.getFieldLocation(fieldName);
		String actualErrorMsg = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].validationMessage;", field);
		Assert.assertEquals(actualErrorMsg, expectedErrorMessage);
		LoggerFactory.getLogger().info("The error message appears below the fieldName");

	}

}
