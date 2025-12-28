package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	WebDriver driver;

	By usernameField = By.name("username");
	By passwordField = By.name("password");
	By lnkSignIn = By.xpath("//a[normalize-space()='Sign in']");
	By signinButton = By.xpath("//form//input[@type='submit']");
	By registerLink = By.xpath("//a[normalize-space()='Register']");
	By errorMsg = By.xpath("//div[contains(@class,'alert-primary')]");	

	// Constructor
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	// -------------------- Sign in page Validations--------------------------------------------------
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
	// -------------------- Page Chaining ---------------------------------------------------------

	/* VALID LOGIN → Navigates to HomePage */
	public HomePage login(String username, String password) {
	/*
	 	clearUsername();
		clearPassword();
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(signinButton).click();
		return new HomePage(driver);
	*/
		By txtUsername = By.xpath("//input[@id='id_username']");
        By txtPassword = By.xpath("//input[@id='id_password']");
        By loginButton=By.xpath("//input[@value='Login']");

        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement a = driver.findElement(loginButton);
        js.executeScript("arguments[0].click();", a);

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
	// ----------------------Actions performed----------------------------------------------

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
			return getErrorMsgText();
		case "password":
			return getErrorMsgText();
		default:
			throw new IllegalArgumentException("Invalid field name: " + fieldName);
		}
	}

	// --------------- Registration Page Check----------------------------------------------------------
	public boolean isRegistrationPageDisplayed() {
		return driver.getCurrentUrl().contains("register");
	}

	public String getSignInPageURL() {
		return driver.getCurrentUrl();
		
	}
}
