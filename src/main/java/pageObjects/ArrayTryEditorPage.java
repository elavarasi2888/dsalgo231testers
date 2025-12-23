package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class ArrayTryEditorPage {
	WebDriver driver;
	public ArrayTryEditorPage(WebDriver driver)
	{
		this.driver = driver;
	}    

    // ---------------- Locators ----------------

    By editor = By.id("editor");
    By runButton = By.xpath("//button[text()='Run']");
    By output = By.id("output");
    By errorMessage = By.cssSelector(".error");

    // ---------------- Actions ----------------

    public boolean isEditorVisible() {
        return driver.findElement(editor).isDisplayed();
    }

    public boolean isRunButtonVisible() {
        return driver.findElement(runButton).isDisplayed();
    }

    public void enterCode(String code) {
        driver.findElement(editor).clear();
        driver.findElement(editor).sendKeys(code);
    }

    public void clearEditor() {
        driver.findElement(editor).clear();
    }

    public void clickRunButton() {
        driver.findElement(runButton).click();
    }

    // ---------------- Validations ----------------

    public boolean isOutputDisplayed() {
        return driver.findElement(output).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isAlertPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    // ---------------- Test Data ----------------

    public String getValidCode() {
        return "print('Hello Array')";
    }

    public String getInvalidCode() {
        return "print('Hello Array'";
    }
}

