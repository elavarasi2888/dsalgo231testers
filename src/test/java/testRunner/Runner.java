package testRunner;

import factory.LoggerFactory;
import org.testng.annotations.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ConfigReader;
import utils.ValidCredentialDataReader;

@CucumberOptions(features = "src/test/resources/features",
        glue = {"hooks", "stepDefinitions"},
        tags = "@Regression",
        plugin = {"pretty",
                "html:cucumber-reports.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true)
public class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeClass
    @Parameters({"browserType"})
    public void beforeClass(@Optional String browser) {
        LoggerFactory.getLogger().info("browserType value from testNG file {}", browser);
        ConfigReader.setBrowserType(browser);
    }

    @BeforeSuite
    public void beforeSuite() {
        LoggerFactory.getLogger().info("calling ValidCredentialDataReader.getValidCredentialsFromExcelData() method");
        ValidCredentialDataReader.getValidCredentialsFromExcelData();
    }
}