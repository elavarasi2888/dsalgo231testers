package testRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.ConfigReader;
import java.io.IOException;
@CucumberOptions(features = "src/test/resources/features",
		glue = { "hooks", "stepDefinitions" },
		//tags="@SignIn",
		//tags = "@DsAlgoPortal",
		tags="@Queue",
		plugin = { "pretty", 
				"html:cucumber-reports.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		dryRun = false, monochrome = true)
public class Runner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
		
	@BeforeClass
	@Parameters({ "browserType" })
	public void beforeClass(@Optional String browser) throws IOException {
		ConfigReader.setBrowserType(browser);
	}
}