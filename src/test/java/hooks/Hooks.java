package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.DsAlgoPortalPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import utils.ConfigReader;

public class Hooks {

    private Properties prop;
    private ConfigReader configReader;
    private String browser;
    private WebDriver driver;

    @Before("@DsAlgoPortal or @HomePage or @Register or @SignIn or @HomePageSignIn")
    public void beforeScenario() throws IOException {
        configReader = new ConfigReader();
        prop = configReader.loadProperties();

        if (ConfigReader.getBrowserType() != null) {
            browser = ConfigReader.getBrowserType();
        } else {
            browser = prop.getProperty("browser");
        }

        driver = DriverManager.initBrowser(browser);
    }

    @Before("@DataStructure")
    public void preStep() throws IOException, InterruptedException {
        configReader = new ConfigReader();
        prop = configReader.loadProperties();

        if (ConfigReader.getBrowserType() != null) {
            browser = ConfigReader.getBrowserType();
        } else {
            browser = prop.getProperty("browser");
        }

        driver = DriverManager.initBrowser(browser);

        String appURL = ConfigReader.getAppUrl();
        driver.get(appURL);

        DsAlgoPortalPage dsAlgoPortal = new DsAlgoPortalPage(driver);
        HomePage homePage = dsAlgoPortal.clickDsPortalGetStarted();
        SignInPage signInPage = homePage.clickSignInLink();
        String username = "dsalgo231";
        String password = "automation2025#";
        homePage = signInPage.login(username, password);
    }

    @Before("@TryEditor")
    public void tryEditorpPreStep() {
        configReader = new ConfigReader();
        prop = configReader.loadProperties();

        if (ConfigReader.getBrowserType() != null) {
            browser = ConfigReader.getBrowserType();
        } else {
            browser = prop.getProperty("browser");
        }

        driver = DriverManager.initBrowser(browser);
    }

    @After
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
        LoggerFactory.getLogger().info("DONE tearDown()..");
    }
}