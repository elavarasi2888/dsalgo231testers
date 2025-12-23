package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.Register;
import pageObjects.SignInPage;
import utils.ConfigReader;
import utils.ExcelReader;

public class SignInSteps {
	HomePage homePage;
	SignInPage signinpage;
	WebDriver driver;

	public SignInSteps() {
		driver = DriverManager.getDriver();
		signinpage = new SignInPage(driver);

	}

	@Given("User is on Sign in Page")
	public void user_is_on_sign_in_page() {

		Assert.assertTrue(signinpage.isLoginPageDisplayed());
		LoggerFactory.getLogger().info("User is at the Sign in page");
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

	@When("User clicks login button after entering valid username and valid password from the given sheet {string} and rowNumber {int}")
	public void user_clicks_login_button_after_entering_valid_username_and_valid_password_from_the_given_sheet_and_row_number(
			String sheetName, int rowNumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData("/src/test/resources/excelTestData/testdata1.xlsx",
				sheetName);
		String validUsername = testdata.get(rowNumber).get("Username");
		String validPassword = testdata.get(rowNumber).get("Password");
		homePage = signinpage.login(validUsername, validPassword);
	}

	@Then("User should land in Home Page with message {string}")
	public void user_should_land_in_home_page_with_message(String expectedMessage) {
		String actualMessage = homePage.getCurrentSignedInUserName(); // method in HomePage
		assertEquals(actualMessage, expectedMessage);
	}

	@When("User clicks login button after entering the data from given sheetName {string}")
	public void user_clicks_login_button_after_entering_invalid_and(String sheetName)
			throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testData = reader.getData("src/test/resources/excelTestData/testdata1.xlsx",
				sheetName);

		String userName = testData.get(0).get("Username");
		String password = testData.get(0).get("Password");

		homePage = signinpage.login(userName, password);
	}

	@Then("The error message {string} appears below {string} textbox")
	public void the_error_message_appears_below_textbox(String expectedErrMsg, String location) {
		String actualErrMsg;

		if (location.equalsIgnoreCase("Username")) {
			actualErrMsg = signinpage.getUsernameErrorMessage();
		} else if (location.equalsIgnoreCase("Password")) {
			actualErrMsg = signinpage.getPasswordErrorMessage();
		} else {
			// General error message displayed somewhere on the page
			actualErrMsg = signinpage.getGeneralErrorMessage();
		}

		Assert.assertEquals(expectedErrMsg, actualErrMsg);
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
