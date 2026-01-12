package stepDefinitions;

import factory.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.*;
import utils.ConfigReader;
import utils.LoggerFactory;
import utils.ValidCredentialDataReader;

public class HomePageAfterSignInStepDefinitions {

    private HomePage homePage;
    private WebDriver driver;

    public HomePageAfterSignInStepDefinitions() {
        driver = DriverManager.getDriver();
    }

    @Given("User clicks login button after entering valid username and valid password")
    public void userClicksLoginButtonAfterEnteringValidUsernameAndValidPassword() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        homePage = signInPage.login(ValidCredentialDataReader.getValidUserName(), ValidCredentialDataReader.getValidPassword());
    }

    @Given("User is at the Home page after sign-in")
    public void user_is_at_the_home_page_after_sign_in() {
        String appURL = ConfigReader.getAppUrl();
        driver.get(appURL);

        DsAlgoPortalPage dsAlgoPortal = new DsAlgoPortalPage(driver);
        homePage = dsAlgoPortal.clickDsPortalGetStarted();
        SignInPage signInPage = homePage.clickSignInLink();
        String username = ValidCredentialDataReader.getValidUserName();
        String password = ValidCredentialDataReader.getValidPassword();
        homePage = signInPage.login(username, password);

        LoggerFactory.getLogger().info("Signed user \"{}\" is displayed on home page? {}", username,
                homePage.isUserNameVisibleAfterSignIn(username));
    }

    @When("User selects following {string} from the drop down after sign-in")
    public void userSelectsFollowingFromTheDropDownAfterSignIn(String dropdownItem) {
        homePage.selectDataStructureItemFromDropdown(dropdownItem.trim());
    }

    @Then("User should able to navigate to {string}")
    public void userShouldAbleToNavigateTo(String dsPage) {
        String currentPageURL = null;
        String dataStructurePageName = dsPage.toLowerCase().trim();

        switch (dataStructurePageName) {
            case "data-structures-introduction":
                currentPageURL = new DataStructurePage(driver).getDataStructurePageURL();
                break;
            case "array":
                currentPageURL = new ArrayPage(driver).getArrayPageURL();
                break;
            case "linked-list":
                currentPageURL = new LinkedListPage(driver).getLinkedListPageURL();
                break;
            case "stack":
                currentPageURL = new StackPage(driver).getStackPageURL();
                break;
            case "queue":
                currentPageURL = new QueuePage(driver).getQueuePageURL();
                break;
            case "tree":
                currentPageURL = new TreePage(driver).getTreePageURL();
                break;
            case "graph":
                currentPageURL = new GraphPage(driver).getGraphPageURL();
                break;
            default:
                LoggerFactory.getLogger().warn("Data Structure page name does not exist.");
                break;
        }

        Assert.assertTrue(currentPageURL.contains(dataStructurePageName));
    }

    @When("User clicks Get Started button of {string} from panel after sign-in")
    public void userClicksGetStartedButtonOfFromPanelAfterSignIn(String panelItem) {
        homePage.clickGetStartedButton(panelItem);
    }

    @When("User clicks the Sign out link")
    public void userClicksTheSignOutLink() {
        homePage.clickSignOut();
    }

    @Then("User should be logged out with a message {string}")
    public void userShouldBeLoggedOutWithAMessage(String loggedOutMessage) {
        Assert.assertEquals(homePage.getLoggedOutMsg(), loggedOutMessage);
    }
}
