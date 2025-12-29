package testRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

import java.io.IOException;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "stepDefinitions"},
        //tags = "@DsAlgoPortal or @HomePage or @HomePageSignIn or @Queue or @Tree or @TryEditor",
        tags="@Stack",
        //tags="@Array",
        plugin = {"pretty", "html:reports/cucumber-reports.html"},
        dryRun = false,
        monochrome = true)
public class Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeClass
    @Parameters({"browserType"})
    public void beforeClass(@Optional String browser) throws IOException {
        ConfigReader.setBrowserType(browser);
    }
}

