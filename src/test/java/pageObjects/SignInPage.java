package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	private WebDriver driver;

	private By txtUsername = By.xpath("//input[@id='id_username']");
	private By txtPassword = By.xpath("//input[@id='id_password']");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By registerLink = By.xpath("//a[normalize-space()='Register']");
	private By errorMsg = By.xpath("//div[@role='alert' and contains(text(),'Invalid Username and Password')]");

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		if (username != null && !username.isEmpty()) {
			driver.findElement(txtUsername).clear();
			driver.findElement(txtUsername).sendKeys(username);
		}
	}

	public void enterPassword(String password) {
		if (password != null && !password.isEmpty()) {
			driver.findElement(txtPassword).clear();
			driver.findElement(txtPassword).sendKeys(password);
		}
	}

	public String getSignInPageURL() {
		return driver.getCurrentUrl();
	}

	public String getBrowserValidationMessage() {
		WebElement activeElement = driver.switchTo().activeElement();
		return activeElement.getAttribute("validationMessage");
	}

	public String getApplicationErrorMessage() {
		return driver.findElement(errorMsg).getText();
	}

	public HomePage login(String username, String password) {
		driver.findElement(txtUsername).sendKeys(username);
		driver.findElement(txtPassword).sendKeys(password);
		WebElement loginButtonWebElement = driver.findElement(loginButton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginButtonWebElement);
		return new HomePage(driver);
	}

	public SignInPage clickSignIn() {
		driver.findElement(loginButton).click();
		return this;
	}

	public RegisterPage clickRegister() {
		driver.findElement(registerLink).click();
		return new RegisterPage(driver);
	}

	public boolean isRegistrationPageDisplayed() {
		return driver.getCurrentUrl().contains("register");
	}

}
