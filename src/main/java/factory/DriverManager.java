package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.BrowserOptions;


 public class DriverManager {

    private static final BrowserOptions browserOptions = new BrowserOptions();
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private static ChromeOptions co = browserOptions.chromeOption();
    private static EdgeOptions ed = browserOptions.edgeOption();
    private static FirefoxOptions fo = browserOptions.firefoxOption();

    public static WebDriver initBrowser(String browser) {
        LoggerFactory.getLogger().info("In initBrowser(), browser value - {}", browser);
        if (browser.trim().equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver(co));
        } else if (browser.trim().equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver(ed));
        } else if (browser.trim().equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver(fo));
        }

        return getDriver();
    }
    public static WebDriver getDriver() {
        return driver.get();
    }

 }

/*
public class DriverManager {
	 private static final BrowserOptions browserOptions = new BrowserOptions();
	    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	    public static ChromeOptions co = browserOptions.chromeOption();
	    public static EdgeOptions ed = browserOptions.edgeOption();
	    public static FirefoxOptions fo = browserOptions.firefoxOption();

	    public static WebDriver initBrowser(String browser) {
	        LoggerFactory.getLogger().info("In initBrowser(), browser value - {}", browser);
	        if (browser.equalsIgnoreCase("chrome")) {
	            driver.set(new ChromeDriver(co));
	        } else if (browser.equalsIgnoreCase("edge")) {
	            driver.set(new EdgeDriver(ed));
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            driver.set(new FirefoxDriver(fo));
	        }
	        return getDriver();
	    }
    // Initialize the driver
    public static void initDriver() {
        // Automatically manage the ChromeDriver binary
        WebDriverManager.chromedriver().setup();

        // Create a new ChromeDriver instance per thread
        driver.set(new ChromeDriver());

        // Maximize window
        getDriver().manage().window().maximize();
    }

    // Get driver instance
    public static WebDriver getDriver() {
    	  WebDriver drv = driver.get();
          if (drv == null) {
              throw new RuntimeException("WebDriver not initialized. Call initDriver() first!");
          }
          return drv;
    }


 // Quit driver
    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
}
}
*/
