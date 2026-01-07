package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import utils.BrowserOptions;

public class DriverManager {

	private static final BrowserOptions browserOptions = new BrowserOptions();
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private static ChromeOptions chromeOptions = browserOptions.chromeOption();
	private static EdgeOptions edgeOptions = browserOptions.edgeOption();
	private static FirefoxOptions firefoxOptions = browserOptions.firefoxOption();

	public static WebDriver initBrowser(String browser) {
		LoggerFactory.getLogger().info("In initBrowser(), browser type - {}", browser);

		String browserType = browser.trim().toLowerCase();

		switch (browserType) {
		case "chrome":
			driver.set(new ChromeDriver(chromeOptions));
			break;
		case "edge":
			driver.set(new EdgeDriver(edgeOptions));
			break;
		case "firefox":
			driver.set(new FirefoxDriver(firefoxOptions));
			break;
		default:
			driver.set(new EdgeDriver(edgeOptions));
			break;
		}

		getDriver().manage().window().maximize();
		//getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return getDriver();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}
}