package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignInPage {
	WebDriver driver;
	By usernameField=By.id("id_username");
	By passwordField=By.id("id_password");
	By signinButton=By.cssSelector("button[type='submit']");
	By errorMsg=By.className("alert alert-primary");

	// Constructor
	public SignInPage(WebDriver driver)
    {
        this.driver = driver;
    }
	
	public void enterUsername(String username)
    {
		driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn()
    {
        driver.findElement(signinButton).click();
    }


    public String getErrorMsgText()
    {
        return driver.findElement(errorMsg).getText();
    }
}
