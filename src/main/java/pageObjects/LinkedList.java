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
	By verifyTopicLinksHeader = By.xpath("//div[@class='col-sm']//strong//p");
	By tryHereBtn = By.xpath("//a[text()='Try here>>>']");
	
	public LinkedList(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean HeaderTitleVisisble() {
		return driver.findElement(headerLinkedList).isDisplayed();
		
	}
	public boolean TopicCoveredTitleForLinks() {
		return driver.findElement(headerTopics).isDisplayed();
		
	}
	public List<String> TopicsLinkelistVisible() {
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
	public boolean isTopicCoveredVisible() {
		return driver.findElement(headerTopics).isDisplayed();
	}
	public String getHeaderForLinks() {
		String timeComplexityH = driver.findElement(verifyTopicLinksHeader).getText();
		return timeComplexityH;

	}
	public boolean tryHereBtn() {
		return driver.findElement(tryHereBtn).isDisplayed();
		
		
	}
	public void tryHereBtnForLinks() {
		 driver.findElement(tryHereBtn).click();
		
	}
	public String getLinkedListPageURL() {
	return driver.getCurrentUrl();
	}

}
