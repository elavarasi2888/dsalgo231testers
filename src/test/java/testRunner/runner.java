package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "stepDefinitions"},
        tags = "@DsAlgoPortal or @HomePage or @HomePageSignIn",
        plugin = {"pretty", "html:reports/cucumber-reports.html"},
        dryRun = false,
        monochrome = true)
public class runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}