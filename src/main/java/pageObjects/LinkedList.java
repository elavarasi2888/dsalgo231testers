package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedList {
	WebDriver driver;
	By headerLinkedList = By.xpath("//h4[@class='bg-secondary text-white']");
	By headerTopics = By.xpath("//p[@class='bg-secondary text-white']");
	By topicsLink = By.xpath("//a[@class='list-group-item']");
	By verifyLinksHeader = By.xpath("//div[@class='col-sm']//strong//p");
	By tryHerebtn = By.xpath("//a[text()='Try here>>>']");
	
	public LinkedList(WebDriver driver) {
		this.driver = driver;
	}
	public void clickGetStarted(String LinkedList) {

		String xpathDef = "//a[@href='" + LinkedList + "']";

		By getStartedBtn = By.xpath(xpathDef);
		driver.findElement(getStartedBtn).click();
	}
	public String getHeaderTitle() {
		String linkedListTitle = driver.findElement(headerLinkedList).getText();
		return linkedListTitle;
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
		String timeComplexityH = driver.findElement(verifyLinksHeader).getText();
		return timeComplexityH;

	}
	public String tryHereBtn() {
		String btnText= driver.findElement(tryHerebtn).getText();
		return btnText;
		
	}

}
