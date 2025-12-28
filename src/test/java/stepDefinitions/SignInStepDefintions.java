package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import utils.ExcelReader1;

public class SignInStepDefintions {
	HomePage homePage;
	SignInPage signinpage;
	WebDriver driver;

	public SignInStepDefintions() {
		driver = DriverManager.getDriver();
		signinpage = new SignInPage(driver);
		homePage = new HomePage(driver);

	}
  
	@Then("Username textbox should be visible")
	public void username_textbox_should_be_visible() {
		Assert.assertTrue(signinpage.isUsernameFieldVisible());

	}

	@Then("Password textbox should be visible")
	public void password_textbox_should_be_visible() {
		Assert.assertTrue(signinpage.isPasswordFieldVisible());
	}

	@Then("Login button should be visible")
	public void login_button_should_be_visible() {
		Assert.assertTrue(signinpage.isSignInButtonVisible());
	}

	@Then("Register option in sign in page should be visible")
	public void register_option_in_sign_in_page_should_be_visible() {
		Assert.assertTrue(signinpage.isRegisterOptionVisible());
	}

	@When("User clicks login button after entering valid username and valid password from the given sheet {string}")
	public void user_clicks_login_button_after_entering_valid_username_and_valid_password_from_the_given_sheet(
			String ScenarioName) throws InvalidFormatException, IOException {

		ExcelReader1 reader = new ExcelReader1();
		String sheetName = "login_valid";
		Map<String, String> testData = reader.getDataByScenarioName(sheetName, ScenarioName);
		signinpage.enterUsername(testData.get("Username"));
		signinpage.enterPassword(testData.get("Password"));
		signinpage.clickSignIn();
		LoggerFactory.getLogger().info("User entering the Valid data");
	}

	@Then("User should land in Home Page with message {string}")
	public void user_should_land_in_home_page_with_message(String expectedMessage) {
		// String actualMessage = homePage.getCurrentSignedInUserName(); // method in
		// HomePage
		String actualMessage = homePage.getUserLoggedInMessage();
		assertEquals(actualMessage, expectedMessage);
	}

	@When("User clicks login button after entering the data from given sheetName {string}")
	public void user_clicks_login_button_after_entering_invalid_and(String ScenarioName)
			throws InvalidFormatException, IOException {
		ExcelReader1 reader = new ExcelReader1();
		String sheetName = "login_invalid";
		Map<String, String> testData = reader.getDataByScenarioName(sheetName, ScenarioName);
		signinpage.enterUsername(testData.get("Username"));
		signinpage.enterPassword(testData.get("Password"));
		signinpage.clickSignIn();
	}

	@Then("The error message {string} appears below {string} textbox")
	public void the_error_message_appears_below_textbox(String expectedErrMsg, String location) {

		String actualErrMsg = signinpage.getErrorMsgText();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);

	}

	@When("User clicks register button")
	public void user_clicks_register_button() {
		signinpage.clickRegister();		
	}

	@Then("User should be redirected to Registration page")
	public void user_should_be_redirected_to_registration_page() {
		Assert.assertTrue(signinpage.isRegistrationPageDisplayed());
	}
}
