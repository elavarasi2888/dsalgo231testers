package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.SignOutPage;
import utils.ConfigReader;

public class SignOutStepDefinitions {

	WebDriver driver;
	HomePage homePage;
	SignInPage signInPage;
	SignOutPage signOutPage;

	public SignOutStepDefinitions() {
		driver = DriverManager.getDriver();
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
		signOutPage = new SignOutPage(driver);
	}

	@Given("User is at Home page after Sign in")
	public void userIsAtHomePageAfterSignIn() {
		LoggerFactory.getLogger().info("Signed user \"{}\" is displayed on home page? {}",
				ConfigReader.getValidUserName(),
				homePage.isUserNameVisibleAfterSignIn(ConfigReader.getValidUserName()));
	}

	@When("User clicks the Sign out link")
	public void userClicksTheSignOutLink() {
		signOutPage.clickSignOut();
	}

	@Then("User should see the Sign in link")
	public void userShouldSeeTheSignInLink() {
		Assert.assertTrue(signOutPage.isSignInLinkDisplayed(), "sign in link not displayed after sign out");
	}

	@Then("User should be logged out with a message Logged out successfully")
	public void userShouldBeLoggedOutWithAMessageLoggedOutSuccessfully() {
		Assert.assertTrue(signOutPage.isUserLoggedOut(), "User not redirected to home page");
		signOutPage.getLoggedOutMsg();
	}
}