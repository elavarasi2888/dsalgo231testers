package testRunner;      

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "hooks",
		"stepDefinitions"}, tags = "    ", plugin = { "pretty",
				"html:reports/cucumber-reports.html" }, dryRun = false, monochrome = true)
public class runner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	/*
	 * @BeforeClass
	 * 
	 * @Parameters({"browsertype"})//coming from testNG.xml public void
	 * beforeClass(@Optional String browser) throws IOException {
	 * //ConfigReader.browserType=browser; ConfigReader.setBrowserType(browser); }
	 */

}
