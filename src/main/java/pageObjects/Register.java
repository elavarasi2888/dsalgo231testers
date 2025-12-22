package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.LoggerFactory;

public class Register {
	WebDriver driver;
	By userTxt = By.name("username");
	By passwordTxt = By.name("password1");
	By confirmPasswrdTxt = By.name("password2");
	By registerBtn = By.xpath("//input[@type='submit']");
	By loginLink = By.xpath("//a[normalize-space()='Login']");
	By registerLink = By.xpath("//a[normalize-space()='Register']");
	By signInLink = By.xpath("//a[normalize-space()='Sign in']");
	By successRegMsg = By.xpath("//div[@role='alert']");
	By errorMsg = By.xpath("//div[@role='alert']");
	By btnGetStartedDsPortal = By.xpath("//button[normalize-space()='Get Started']");

	public Register(WebDriver driver) {

		this.driver = driver;

	}

	public void enterCredentials(String userName, String passWord, String passwordConfirmation) {
		driver.findElement(userTxt).sendKeys(userName);
		driver.findElement(passwordTxt).sendKeys(passWord);
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
		case "Username":
			return driver.findElement(userTxt);
		case "Password":
			return driver.findElement(passwordTxt);
		case "Password confirmation":
			return driver.findElement(confirmPasswrdTxt);
		default:
			LoggerFactory.getLogger().info("Invalid fieldName");

		}
		return driver.findElement(errorMsg);

	}

	public String getRegisterPageUrl() {
		
		return driver.getCurrentUrl();
	}
}
