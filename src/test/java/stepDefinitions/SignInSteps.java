package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import utils.ConfigReader;

public class SignInSteps {
	 HomePage homePage;
	 SignInPage signinpage;
	 WebDriver driver;
	 
	 @Before
	    public void setUp() {
	        DriverManager.getDriver();
	        homePage = new HomePage(DriverManager.getDriver());
	        signinpage = new SignInPage(DriverManager.getDriver());
	    }

/*	 
@Given("User opens the browser")
public void user_opens_the_browser() {
	 DriverManager.getDriver();
}

@Given("User enters the correct DS Algo portal URL")
public void user_enters_the_correct_ds_algo_portal_url() {
	  DriverManager.getDriver().get(ConfigReader.getAppUrl());
}

@Given("User clicks the Get Started button on DS Algo portal page")
public void user_clicks_the_get_started_button_on_ds_algo_portal_page() {
	// homePage.clickGetStarted();
}

@When("user clicks on the Sign in link in the home page")
public void user_clicks_on_the_sign_in_link_in_the_home_page() {
     //homePage.clickSignIn();
}
*/
	 
@Given("User is on Sign in Page")
public void user_is_on_sign_in_page() {
	driver.get("https://dsportalapp.herokuapp.com/login");
	Assert.assertTrue(signinpage.isLoginPageDisplayed());
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

@When("User clicks login button after entering valid username and valid password")
public void user_clicks_login_button_after_entering_valid_username_and_valid_password() {
	 // Replace these with valid credentials 
    String validUsername = "validUser";
    String validPassword = "validPass";

    signinpage.enterUsername(validUsername);
    signinpage.enterPassword(validPassword);
    signinpage.clickSignIn();
}

@Then("User should land in Home Page with message {string}")
public void user_should_land_in_home_page_with_message(String string) {
	//homepage work
}

@When("User clicks login button after entering invalid {string} and {string}")
public void user_clicks_login_button_after_entering_invalid_and(String username, String password) {
	 signinpage.clearUsername();
     signinpage.clearPassword();

     if (!username.isEmpty()) {
         signinpage.enterUsername(username);
     }

     if (!password.isEmpty()) {
         signinpage.enterPassword(password);
     }

     signinpage.clickSignIn();
}

@Then("The error message {string} appears below {string} textbox")
public void the_error_message_appears_below_textbox(String expectedErrMsg, String location) {
	 String actualErrMsg;

	    if(location.equalsIgnoreCase("Username")) {
	        actualErrMsg = signinpage.getUsernameErrorMessage();
	    } else if(location.equalsIgnoreCase("Password")) {
	        actualErrMsg = signinpage.getPasswordErrorMessage();
	    } else {
	        // General error message displayed somewhere on the page
	        actualErrMsg = signinpage.getGeneralErrorMessage();
	    }

	    assertEquals(expectedErrMsg, actualErrMsg);
}

@When("User clicks register button")
public void user_clicks_register_button() {
	signinpage.clickRegister();
}

@Then("User should be redirected to Registration page")
public void user_should_be_redirected_to_registration_page() {
	 assertTrue(signinpage.isRegistrationPageDisplayed());
}

}



   
  