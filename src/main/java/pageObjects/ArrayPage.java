package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArrayPage {

	private WebDriver driver;

	private By headerArray = By.xpath("//h4[normalize-space()='Array']");
	private By headerTopicsCoveredArray = By.xpath("//p[@class='bg-secondary text-white']");
	private By headerArrayLinkTopic = By.xpath("//div[@class='col-sm']//strong//p");
	private By lnkArrayLinks = By.xpath("//a[@class='list-group-item']");
	private By btnTryHereArrayLinkPage = By.xpath("//a[normalize-space()='Try here>>>']");

	public ArrayPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isArrayHeaderVisible() {
		return driver.findElement(headerArray).isDisplayed();
	}

	public boolean isTopicsCoveredHeaderForArrayVisible() {
		return driver.findElement(headerTopicsCoveredArray).isDisplayed();
	}

	public String getArrayLinksTopicHeader() {
		return driver.findElement(headerArrayLinkTopic).getText();
	}

	public boolean isTryHereButtonVisible() {
		return driver.findElement(btnTryHereArrayLinkPage).isDisplayed();
	}

	public boolean isArrayLinkVisible(String arrayTopicLink) {
		List<WebElement> arrayLinks = driver.findElements(lnkArrayLinks);

		for (WebElement a : arrayLinks) {
			if (a.getText().equals(arrayTopicLink))
				return true;
		}
		return false;
	}

	public void clickArrayTopicLink(String arrayTopicLink) {
		By linkPath = By.xpath("//a[text() = '" + arrayTopicLink + "']");
		driver.findElement(linkPath).click();
	}

	public String getArrayPageURL() {
		return driver.getCurrentUrl();
	}

	public void clickTryHereInArrayLinkPage() {
		driver.findElement(btnTryHereArrayLinkPage).click();
	}

}
