package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOutPage {


    private WebDriver driver;

    public SignOutPage(WebDriver driver) {
        this.driver = driver;
    }

    // ================= Locators =================

   private By signOutLink = By.linkText("Sign out");
   private By logoutSuccessMessage = By.className("alert alert-primary");
   private By homePageIdentifier = By.xpath("//a[text()='Sign out']");

    // ================= Actions =================

    public void clickSignOut() {
        driver.findElement(signOutLink).click();
    }

    // ================= Validations =================

    /** Confirms user is logged in (Sign out visible) */
    public boolean isUserLoggedIn() {
        return driver.findElement(homePageIdentifier).isDisplayed();
    }

    /** Gets success message after logout */
    public String getLogoutSuccessMessage() {
        return driver.findElement(logoutSuccessMessage).getText();
    }

    /** Confirms user is redirected to home page */
    public boolean isAtHomePage() {
        return driver.getCurrentUrl().contains("home");
    }
}
