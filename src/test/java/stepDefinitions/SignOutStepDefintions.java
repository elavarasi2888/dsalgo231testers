package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import factory.DriverManager;

import pageObjects.HomePage;
import pageObjects.SignInPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class SignOutStepDefintions {
	 HomePage homePage = new HomePage(DriverManager.getDriver());

	    SignInPage signInPage = new SignInPage(DriverManager.getDriver());
	    
	 // ---------------- Background -------------------------------------------
	    
	@Given("User is in the Home page after Sign in")
	public void User_is_in_the_Home_page_after_Sign_in() {
		 // assertTrue(homePage.isUserLoggedIn(),"User is not logged in");
	}
	
	@When("User clicks \"Sign out\"")
	public void User_clicks_Sign_Out()
	{
		/*if (linkName.equalsIgnoreCase("Sign out")) 
		{
            homePage.clickSignOut();
		}*/
	}
	@Then("User should be redirected to home page with message \"Logged out successfully\"")
	public void user_should_be_redirected_to_home_page_with_message_Logged_out_successfully(String string) {
		/*
		assertTrue(signInPage.isAtHomePage(),
	                "User is not redirected to home page");
	        assertEquals(homePage.getLogoutSuccessMessage(), expectedMsg);
	        */
	}
			
}






   

    

   

  
    
