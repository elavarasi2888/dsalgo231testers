package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import utils.BrowserOptions;

public class DriverManager {

	private static BrowserOptions browserOptions = new BrowserOptions();
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static ChromeOptions co = browserOptions.chromeOption();
	public static EdgeOptions ed = browserOptions.edgeOption();
	public static FirefoxOptions fo = browserOptions.firefoxOption();

	public static WebDriver initBrowser(String browser) {

		LoggerFactory.getLogger().info("In launchBrowser() - browser value-{}", browser);
		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver(co));
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver(ed));
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver(fo));
		}

		return getDriver();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

}
