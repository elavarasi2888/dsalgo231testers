package stepDefinitions;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.DsAlgoPortalPage;
import pageObjects.HomePage;
import utils.ConfigReader;

import java.io.IOException;

public class DsAlgoPortalStepDefinitions {

    private DsAlgoPortalPage dsAlgoPortal;
    private HomePage homePage;
    private String appURL = null;
    private WebDriver driver;

    @Given("User opens the browser")
    public void user_opens_the_browser() throws IOException {
        driver = DriverManager.getDriver();
    }

    @When("User enters the correct DS Algo portal URL")
    public void user_enters_the_correct_ds_algo_portal_url() {
        appURL = ConfigReader.getAppUrl();
        driver.get(appURL);
        dsAlgoPortal = new DsAlgoPortalPage(driver);
    }

    @Then("User should able to land on DS Algo portal")
    public void user_should_able_to_land_on_ds_algo_portal() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(appURL, currentURL);
        LoggerFactory.getLogger().info("User landed on DsAlgo portal page");
    }

    @Then("User should able to see Get Started button on DS Algo Portal page")
    public void user_should_able_to_see_get_started_button_on_ds_algo_portal_page() {
        Assert.assertTrue(dsAlgoPortal.isDsPortalGetStartedVisible());
        LoggerFactory.getLogger().info("User can see Get Started button on DS Algo Portal page");
    }

    @Then("User should able to see Preparing for the Interviews heading")
    public void user_should_able_to_see_preparing_for_the_interviews_heading() {
        Assert.assertTrue(dsAlgoPortal.isDsPortalHeadingVisible());
        LoggerFactory.getLogger().info("User can see Preparing for the Interviews heading on DS Algo Portal page");
    }

    @Then("User should able to see You are at the right place paragraph")
    public void user_should_able_to_see_you_are_at_the_right_place_paragraph() {
        Assert.assertTrue(dsAlgoPortal.isDsPortalParagraphVisible());
        LoggerFactory.getLogger().info("User can see You are at the right place paragraph on DS Algo Portal page");
    }

    @When("User clicks the Get Started button on DS Algo portal page")
    public void user_clicks_the_get_started_button_on_ds_algo_portal_page() {
        homePage = dsAlgoPortal.clickDsPortalGetStarted();
    }

    @Then("User navigates to Home page")
    public void user_navigates_to_home_page() {
        String currentUrl = homePage.getHomePageURL();
        Assert.assertEquals(currentUrl, appURL + "home");
        LoggerFactory.getLogger().info("User navigates to Home page");
    }
}
