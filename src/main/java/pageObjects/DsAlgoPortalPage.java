package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DsAlgoPortalPage {

    private WebDriver driver;

    By lblDsPortalHeading = By.xpath("//h1[normalize-space()='Preparing for the Interviews']");
    By lblDsPortalParagraph = By.xpath("//p[normalize-space()='You are at the right place']");
    By btnGetStartedDsPortal = By.xpath("//button[normalize-space()='Get Started']");

    public DsAlgoPortalPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDsPortalHeadingVisible() {
        return driver.findElement(lblDsPortalHeading).isDisplayed();
    }

    public boolean isDsPortalParagraphVisible() {
        return driver.findElement(lblDsPortalParagraph).isDisplayed();
    }

    public boolean isDsPortalGetStartedVisible() {
        return driver.findElement(btnGetStartedDsPortal).isDisplayed();
    }

    public HomePage clickDsPortalGetStarted() {
        driver.findElement(btnGetStartedDsPortal).click();
        return new HomePage(driver);
    }
}
