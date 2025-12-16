package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;

	By lnkNumpyNinja = By.xpath("//a[normalize-space()='NumpyNinja']");
	By lnkRegister = By.xpath("//a[normalize-space()='Register']");
	By lnkSignIn = By.xpath("//a[normalize-space()='Sign in']");
	By drpDataStructures = By.xpath("//a[normalize-space()='Data Structures']");
	By drpDataStructureOptions = By.xpath("//div[@class='dropdown-menu show']//a");
	By btnGetStarted = By.xpath("//a[text()='Get Started']");
	By msgErrorMsg = By.xpath("//div[@role='alert']");
	By a = By.xpath("//h5[@class='card-title']");
	By drpDataStructues = By.xpath("//a[normalize-space()='Data Structures']");
	By drpItemOptions = By.xpath("//div[@class='dropdown-menu show']//a");
	By msgDserrmsg = By.xpath("//div[@class='alert alert-primary']");

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	public boolean isNumpyNinjaHeaderVisible() {
		return driver.findElement(lnkNumpyNinja).isDisplayed();
	}

	public boolean isRegisterLinkVisible() {
		return driver.findElement(lnkRegister).isDisplayed();
	}

	public boolean isSignInLinkVisible() {
		return driver.findElement(lnkSignIn).isDisplayed();
	}

	public boolean isDataStructuresDropDownVisible() {
		return driver.findElement(drpDataStructures).isDisplayed();
	}

	public boolean isGetStartedButtonOnDsAlgoPortalVisible() {
		return driver.findElement(btnGetStarted).isDisplayed();
	}

	public String getErrorMsgOnDsAlgoGetStartedButton() {
		return driver.findElement(msgErrorMsg).getText();
	}

	//page chaining TBD
	public void selectDataStructues(String dstype , boolean signedIn) {
		driver.findElement(drpDataStructues).click();
		List<WebElement> options = driver.findElements(drpItemOptions);

		for (int i = 0; i < options.size(); i++) {
			//LoggerFactory.getLogger().info(options.get(i).getText());

			String option = options.get(i).getText();

			if (option.equals(dstype)) {
				options.get(i).click();
				
				//signedIn == true --> return object of the destination page
				
				//signedIn == false --> return error msg text
				
				return;
			}
		}
	}
	

	public void clickGetStarted(String dstype) {

		String xpathDef = "//a[@href='" + dstype + "']";

		By a = By.xpath(xpathDef);
		driver.findElement(a).click();
	}

	public int getDataStructuresSize() {
		List<WebElement> options = driver.findElements(btnGetStarted);
		return options.size();
	}

	public List<String> getDataStructures() {
		List<WebElement> options = driver.findElements(a);

		List<String> names = new ArrayList<>();

		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i).getText().toLowerCase();
			names.add(option);
		}

		return names;
	}


	public String errorMsg() {

		return driver.findElement(msgDserrmsg).getText();
	}
}
