package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignOutPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private By signOutMsg = By.xpath("//div[@role='alert']");
	private By signOutLink = By.xpath("//a[normalize-space()='Sign out']");
	private By signInLink = By.xpath("//a[normalize-space()='Sign in']");

	public SignOutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickSignOut() {
		wait.until(ExpectedConditions.elementToBeClickable(signOutLink)).click();
	}

	public boolean isSignInLinkDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(signInLink)).isDisplayed();
	}

	public boolean isUserLoggedOut() {

		return driver.getCurrentUrl().contains("home");
	}

	public void getLoggedOutMsg() {
		String text = driver.findElement(signOutMsg).getText();
		System.out.println(text);
	}
}