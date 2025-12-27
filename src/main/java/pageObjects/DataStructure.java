package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataStructure {
	WebDriver driver;
	By headerTopics = By.xpath("//p[@class='bg-secondary text-white']");
	By topicsLink = By.xpath("//a[@class='list-group-item']");
	By timeLinkHeader = By.xpath("//p[normalize-space()='Time Complexity']");
	By headerDS = By.xpath("//h4[@class='bg-secondary text-white']");
	By tryHereBtn = By.xpath("//a[text()='Try here>>>']");

	public DataStructure(WebDriver driver) {
		this.driver = driver;
	}

	public void clickGetStarted(String dsType) {

		String xpathDef = "//a[@href='" + dsType + "']";

		By getStartedBtn = By.xpath(xpathDef);
		driver.findElement(getStartedBtn).click();
	}

	public String getHeaderTitle() {
		String dsTitle = driver.findElement(headerDS).getText();
		return dsTitle;
	}

	public String getTitleForLinks() {
		String topicsHeader = driver.findElement(headerTopics).getText();
		return topicsHeader;
	}

	public List<String> getTopics() {
		List<WebElement> topicsName = driver.findElements(topicsLink);
		ArrayList<String> topic = new ArrayList<>();
		for (WebElement link : topicsName) {
			topic.add(link.getText().trim());
		}
		return topic;

	}

	public void clickTopicLink(String linksName) {
		List<WebElement> topicsName = driver.findElements(topicsLink);

		for (WebElement link : topicsName) {
			if (link.getText().trim().equalsIgnoreCase(linksName)) {
				link.click();
				return;
			}
		}
	}

	public String getHeaderForLinks() {
		String timeComplexityH = driver.findElement(timeLinkHeader).getText();
		return timeComplexityH;

	}
	public String tryHereBtn() {
		String btnText= driver.findElement(tryHereBtn).getText();
		return btnText;
		
	}

	
}


