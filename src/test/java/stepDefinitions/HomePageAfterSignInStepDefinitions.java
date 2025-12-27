package stepDefinitions;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.*;

public class HomePageAfterSignInStepDefinitions {

    private HomePage homePage;
    private WebDriver driver;
    private String userName;

    public HomePageAfterSignInStepDefinitions() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("User clicks login button after entering valid username and valid password")
    public void userClicksLoginButtonAfterEnteringValidUsernameAndValidPassword() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);

        userName = "dsalgo231";
        String password = "automation2025#";
        homePage = signInPage.login(userName, password);
    }

    @Given("User is at the Home page after sign-in")
    public void user_is_at_the_home_page_after_sign_in() {
        LoggerFactory.getLogger().info("Signed user \"{}\" is displayed on home page? {}", userName,
                homePage.isUserNameVisibleAfterSignIn(userName));
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
                currentPageURL = new DataStructure(driver).getDataStructurePageURL();
                break;
            case "array":
                currentPageURL = new ArrayPage(driver).getArrayPageURL();
                break;
            case "linked-list":
                currentPageURL = new LinkedList(driver).getLinkedListPageURL();
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
}
