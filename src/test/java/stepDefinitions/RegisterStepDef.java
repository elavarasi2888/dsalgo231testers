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
import pageObjects.Register;
import pageObjects.SignInPage;
import utils.ExcelReader;

public class RegisterStepDef {

	WebDriver driver;
	Register registerPage;
	SignInPage signInPage;
	

	public RegisterStepDef() {
		driver = DriverManager.getDriver();
		registerPage = new Register(driver);
	}
	
	/*
	 * Note: Once you get SHowri's code from Github, Delete/comment lines 35-62
	 * */


	@Given("User opens the browser")
	public void user_opens_the_browser() {
		String actualUrl = driver.getTitle();
		String expectedUrl = "NumpyNinja";
		Assert.assertEquals(actualUrl, expectedUrl);
		LoggerFactory.getLogger().info("User opens the browser");
	}

	@Given("User enters the correct DS Algo portal URL")
	public void user_enters_the_correct_ds_algo_portal_url() {
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "/dsportalapp";
		Assert.assertTrue(actualUrl.contains(expectedUrl));
		LoggerFactory.getLogger().info("User enters the correct DS Algo portal URL");
	}

	@Given("User clicks the Get Started button on DS Algo portal page")
	public void user_clicks_the_get_started_button_on_ds_algo_portal_page() {
		registerPage.clickDsPortalGetStarted();
		LoggerFactory.getLogger().info("User clicks the Get Started button on DS Algo portal page");
	}

	@When("User clicks on the Register link in the home page")
	public void user_clicks_on_the_register_link_in_the_home_page() {
		registerPage.homeRegisterLink();
		LoggerFactory.getLogger().info("User clicks on the Register link in the home page");
	}

	@Given("User is at the Register page")
	public void user_is_at_the_register_page() {
		//registerPage = new Register(DriverManager.getDriver());

		//String actualUrl = driver.getCurrentUrl();
		String actualRegisterPageUrl = registerPage.getRegisterPageUrl();
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

	@When("User clicks Register button after entering the data from given sheetName {string} and rowNumber {int}")
	public void user_clicks_register_button_after_entering_the_data_from_given_sheet_name_and_row_number(
			String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		//To-Do: Use this after removing sheetName column from feature file
		//String sheetName = "Register_invalid";
		//properties in util
		List<Map<String, String>> testData = reader.getData("/src/test/resources/excelTestData/testData.xlsx",
				sheetName);
		String userName = testData.get(rowNumber).get("Username");
		String password = testData.get(rowNumber).get("Password");
		String confirmPwd = testData.get(rowNumber).get("Password confirmation");
		registerPage.enterCredentials(userName, password, confirmPwd);
		registerPage.registerBtn();
	
	}
	
	@When("User clicks Register button after entering the Valid data from given sheetName {string} and rowNumber {int}")
	public void user_clicks_register_button_after_entering_the_valid_data_from_given_sheet_name_and_row_number(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("/src/test/resources/excelTestData/testData.xlsx",
				sheetName);
		String userName = testData.get(rowNumber).get("Username");
		String password = testData.get(rowNumber).get("Password");
		String confirmPwd = testData.get(rowNumber).get("Password confirmation");
		registerPage.enterCredentials(userName, password, confirmPwd);
		registerPage.registerBtn();
	}

	@Then("User should be redirected to Home Page of DS Algo with message {string}")
	public void user_should_be_redirected_to_home_page_of_ds_algo_with_message(String expectedMsg) {
		driver.get("https://dsportalapp.herokuapp.com/home");
	String actualMsg= registerPage.getRegisterMsg();
	Assert.assertTrue(actualMsg.contains(expectedMsg));
	LoggerFactory.getLogger().info("User at the Home page");

	}

	@Then("The error message {string} appears below the {string}")
	public void the_error_message_appears_below_the(String expectedMessage, String fieldName) {
		WebElement field = registerPage.getFieldLocation(fieldName);
		String actualMsg = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].validationMessage;", field);
		Assert.assertEquals(actualMsg, expectedMessage);
		LoggerFactory.getLogger().info("The error message appears below the fieldName");

	}

}
