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
		boolean dsPortalHeadingStatus = driver.findElement(lblDsPortalHeading).isDisplayed();
		return dsPortalHeadingStatus;
	}

	public boolean isDsPortalParagraphVisible() {
		boolean dsPortalParagraphStatus = driver.findElement(lblDsPortalParagraph).isDisplayed();
		return dsPortalParagraphStatus;
	}

	public boolean isDsPortalGetStartedVisible() {
		boolean dsPortalGetStartedStatus = driver.findElement(btnGetStartedDsPortal).isDisplayed();
		return dsPortalGetStartedStatus;
	}

	public void clickDsPortalGetStarted() {
		driver.findElement(btnGetStartedDsPortal).click();
	}

}
