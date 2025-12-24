package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	WebDriver driver;

	By usernameField = By.id("id_username");
	By passwordField = By.id("id_password");
	By signinButton = By.cssSelector("button[type='submit']");
	By registerLink = By.linkText("Register");

	By errorMsg = By.className("alert alert-primary");
	By usernameError = By.id("username_error");
	By passwordError = By.id("password_error");
	By generalError = By.id("generalError");

	// Constructor
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	// -------------------- Sign in page Validations
	// --------------------------------------
	public boolean isLoginPageDisplayed() {
		return driver.getCurrentUrl().contains("login");
	}

	public boolean isUsernameFieldVisible() {
		return driver.findElement(usernameField).isDisplayed();
	}

	public boolean isPasswordFieldVisible() {
		return driver.findElement(passwordField).isDisplayed();
	}

	public boolean isSignInButtonVisible() {
		return driver.findElement(signinButton).isDisplayed();
	}

	public boolean isRegisterOptionVisible() {
		return driver.findElement(registerLink).isDisplayed();
	}
	// -------------------- Page Chaining --------------------

	/* VALID LOGIN → Navigates to HomePage */
	public HomePage login(String username, String password) {
		clearUsername();
		clearPassword();
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(signinButton).click();
		return new HomePage(driver);
	}

	/* INVALID LOGIN → Stays on SignInPage */
	public SignInPage clickSignIn() {
		driver.findElement(signinButton).click();
		return this;
	}

	/* Navigates to Register Page */
	public RegisterPage clickRegister() {
		driver.findElement(registerLink).click();
		return new RegisterPage(driver);
	}
	// ----------------------Actions performed--------------------------

	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {

		driver.findElement(passwordField).sendKeys(password);
	}

	public void clearUsername() {
		driver.findElement(usernameField).clear();
	}

	public void clearPassword() {
		driver.findElement(passwordField).clear();
	}

	/*
	 * public void clickSignIn() { driver.findElement(signinButton).click(); }
	 * public void clickRegister() { driver.findElement(registerLink).click(); }
	 */
	// ----------------------Errors--------------------------------------------------
	public String getErrorMsgText() {
		return driver.findElement(errorMsg).getText();
	}

	public String getUsernameErrorMessage() {
		return driver.findElement(usernameError).getText();
	}

	public String getPasswordErrorMessage() {
		return driver.findElement(passwordError).getText();
	}

	public String getGeneralErrorMessage() {
		return driver.findElement(generalError).getText();
	}

	// Get browser validation message for username field
	public String getUsernameValidationMessage() {
		return driver.findElement(usernameField).getAttribute("validationMessage");
	}

	// Get browser validation message for password field
	public String getPasswordValidationMessage() {
		return driver.findElement(passwordField).getAttribute("validationMessage");
	}

	// to get error based on field name
	public String getErrorMessageBelowTextbox(String fieldName) {
		switch (fieldName.toLowerCase()) {
		case "username":
			return getUsernameErrorMessage();
		case "password":
			return getPasswordErrorMessage();
		default:
			throw new IllegalArgumentException("Invalid field name: " + fieldName);
		}
	}

	// ===== Registration Page Check =====
	public boolean isRegistrationPageDisplayed() {
		return driver.getCurrentUrl().contains("register");
	}

	public String getSignInPageURL() {
		// TODO Auto-generated method stub
		return null;
	}
}
