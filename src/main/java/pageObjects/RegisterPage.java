package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.LoggerFactory;

public class RegisterPage {
	private WebDriver driver;
	By userTxt = By.name("username");
	By passwordTxt = By.name("password1");
	By confirmPasswrdTxt = By.name("password2");
	By registerBtn = By.xpath("//input[@type='submit']");
	By loginLink = By.xpath("//a[normalize-space()='Login']");
	By registerLink = By.xpath("//a[normalize-space()='Register']");
	By signInLink = By.xpath("//a[normalize-space()='Sign in']");
	By successRegMsg = By.xpath("//div[@role='alert']");
	By errorMsg = By.xpath("//div[@class='alert alert-primary']");
	By btnGetStartedDsPortal = By.xpath("//button[normalize-space()='Get Started']");

	public RegisterPage(WebDriver driver) {

		this.driver = driver;

	}

	public void enterUserName(String userName) {
		driver.findElement(userTxt).sendKeys(userName);
	}

	public void enterpassWord(String passWord) {
		driver.findElement(passwordTxt).sendKeys(passWord);
	}

	public void enterPasswordConfirmation(String passwordConfirmation) {
		driver.findElement(confirmPasswrdTxt).sendKeys(passwordConfirmation);
	}

	public void registerBtn() {
		driver.findElement(registerBtn).click();
	}

	public SignInPage loginLink() {
		driver.findElement(loginLink).click();
		return new SignInPage(driver);
	}

	public String getRegisterMsg() {

		String UserRegisterMsg = driver.findElement(successRegMsg).getText();
		return UserRegisterMsg;
	}

	public void homeRegisterLink() {
		driver.findElement(registerLink).click();
	}

	public void clickDsPortalGetStarted() {
		driver.findElement(btnGetStartedDsPortal).click();
	}

	public WebElement getFieldLocation(String fieldName) {

		switch (fieldName.toLowerCase()) {
		case "username":
			return driver.findElement(userTxt);
		case "password":
			return driver.findElement(passwordTxt);
		case "password confirmation":
			return driver.findElement(confirmPasswrdTxt);
		case "login":
			return driver.findElement(errorMsg);
		default:
			throw new IllegalArgumentException("Invalid FieldName:" + fieldName);

		}

	}

	public String getloginPageUrl() {

		return driver.getCurrentUrl();

	}

	public String getRegisteredUserErrorMsg() {

		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
	       return element.getText().trim();

	}

	public String getRegisterPageURL() {
		return driver.getCurrentUrl();
	}
}
