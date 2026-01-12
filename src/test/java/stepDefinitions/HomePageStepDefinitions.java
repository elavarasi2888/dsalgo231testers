package stepDefinitions;

import java.util.List;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DsAlgoPortalPage;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import pageObjects.SignInPage;
import utils.ConfigReader;
import utils.LoggerFactory;

public class HomePageStepDefinitions {

    private HomePage homePage;
    private DsAlgoPortalPage dsAlgoPortal;
    private RegisterPage registerPage;
    private SignInPage signInPage;
    private WebDriver driver;

    public HomePageStepDefinitions() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getAppUrl());
        dsAlgoPortal = new DsAlgoPortalPage(driver);
    }

    @Given("User clicks Get Started button on the DS Algo portal page")
    public void userClicksGetStartedButtonOnTheDSAlgoPortalPage() {
        homePage = dsAlgoPortal.clickDsPortalGetStarted();
    }

    @Then("NumpyNinja heading should be visible")
    public void numpy_ninja_heading_should_be_visible() {
        Assert.assertTrue(homePage.isNumpyNinjaHeaderVisible());
        LoggerFactory.getLogger().info("NumpyNinja heading is visible");
    }

    @Then("Register link should be visible")
    public void register_link_should_be_visible() {
        Assert.assertTrue(homePage.isRegisterLinkVisible());
        LoggerFactory.getLogger().info("Register link is visible");
    }

    @Then("Sign in link should be visible")
    public void sign_in_link_should_be_visible() {
        Assert.assertTrue(homePage.isSignInLinkVisible());
        LoggerFactory.getLogger().info("Sign in link is visible");
    }

    @Then("Datastructures drop down should be visible")
    public void datastructures_drop_down_should_be_visible() {
        Assert.assertTrue(homePage.isDataStructuresDropDownVisible());
        LoggerFactory.getLogger().info("Data Structures drop down is visible");
    }

    @Then("User should be able to see {int} Get Started buttons for the following panel items:")
    public void user_should_be_able_to_see_get_started_buttons_for_the_following_panel_items(int countOfGetStartedButtons, DataTable dataTable) {

        List<String> actualPanelDataStructuresNames = homePage.getPanelDataStructuresItems();

        Assert.assertEquals(actualPanelDataStructuresNames.size(), countOfGetStartedButtons);

        List<String> expectedPanelNames = dataTable.asList(String.class);

        Assert.assertEquals(actualPanelDataStructuresNames, expectedPanelNames);
    }

    @When("User clicks the Data Structures dropdown")
    public void user_clicks_the_data_structures_dropdown() {
        homePage.clickDataStructureDropDown();
    }

    @Then("User should able to see the following {int} dropdown options:")
    public void user_should_able_to_see_the_following_dropdown_options(Integer dropDownItemsCount, DataTable dataTable) {

        List<String> actualDataStructureDropDownItemNames = homePage.getDataStructureDropDownItems();

        Assert.assertEquals(actualDataStructureDropDownItemNames.size(), dropDownItemsCount);

        List<String> expectedDropDownItemNames = dataTable.asList(String.class);

        Assert.assertEquals(actualDataStructureDropDownItemNames, expectedDropDownItemNames);
    }

    @When("User selects following {string} from the drop down")
    public void user_selects_following_from_the_drop_down(String dropDownItem) {
        homePage.selectDataStructureItemFromDropdown(dropDownItem);
    }

    @Then("User should able to see a warning message {string}")
    public void user_should_able_to_see_a_warning_message(String expectedErrorMessage) {
        String actualErrorMessage = homePage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @When("User clicks Get Started button of {string} from panel")
    public void user_clicks_get_started_button_of_from_panel(String panelName) {
        homePage.clickGetStartedButton(panelName);
    }

    @When("User clicks on the Register link in the home page")
    public void user_clicks_on_the_register_link_in_the_home_page() {
        registerPage = homePage.clickRegisterLink();
    }

    @Then("User should navigate to the Register page")
    public void user_should_navigate_to_the_register_page() {
        String currentURL = registerPage.getRegisterPageURL();
        Assert.assertTrue(currentURL.contains("register"));
    }

    @When("User clicks on the Sign in link in the home page")
    public void user_clicks_on_the_sign_in_link_in_the_home_page() {
        signInPage = homePage.clickSignInLink();
    }

    @Then("User should navigate to the Sign in page")
    public void user_should_navigate_to_the_sign_in_page() {
        String currentURL = signInPage.getSignInPageURL();
        Assert.assertTrue(currentURL.contains("login"));
    }
}
