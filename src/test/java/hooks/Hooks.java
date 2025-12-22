package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import factory.LoggerFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class Hooks {

	WebDriver driver;
	Properties prop;
	ConfigReader configReader = new ConfigReader();

	@Before()
	public void beforeScenario() throws IOException {

		LoggerFactory.getLogger().info("In setup()..");
		prop = configReader.loadProperties();

		String browser = null;
		// if browser values are found in the testng.xml
		if (ConfigReader.getBrowserType() != null) {
			browser = ConfigReader.getBrowserType();
		} else {
			// we will go with default browser value in config.properties

			browser = prop.getProperty("browser");
		}

		LoggerFactory.getLogger().info("In setup(), browser value {}", browser);
		driver = DriverManager.initBrowser(browser);

		String appURL = prop.getProperty("dsAppURL");
		LoggerFactory.getLogger().info("app url-{}", appURL);
		// DriverManager.getDriver().get(ConfigReader.getAppUrl());
		driver.get(appURL);
		LoggerFactory.getLogger().info("DONE setup()..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * @Before("@linkedList") public void beforeScenario2()throws IOException {
	 * 
	 * LoggerFactory.getLogger().info("User launches to dsalgo page");
	 * LoggerFactory.getLogger().info("User navigates to home page");
	 * LoggerFactory.getLogger().info("User navigates to sign in page");
	 * LoggerFactory.getLogger().info("User signs in");
	 * LoggerFactory.getLogger().info("User comes back to home page");
	 * //LoggerFactory.getLogger().info("User launches to dsalgo page"); }
	 */

	@After
	public void tearDown() {
		LoggerFactory.getLogger().info("In tearDown()..");
		DriverManager.getDriver().quit();
		LoggerFactory.getLogger().info("DONE tearDown()..");
	}

}
